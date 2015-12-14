// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.model.GetAccountQuotaRequest;
import com.amazon.clouddrive.model.GetAccountQuotaResponse;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.gallery.actions.MediaItemAction;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.kindle.util.UploadUtils;
import com.amazon.gallery.framework.metrics.clickstream.ClickstreamEventHelper;
import com.amazon.gallery.framework.metrics.clickstream.HitType;
import com.amazon.gallery.framework.metrics.customer.CustomerMetricsHelper;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.network.NetworkExecutor;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.http.rest.RestClient;
import com.amazon.gallery.framework.network.multiqueueuploader.QueueType;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadMediaItemsEvent;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadStrategy;
import com.amazon.gallery.framework.network.multiqueueuploader.UploadTagsEvent;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import org.apache.commons.io.FileUtils;

public class ManualUploadAction extends MediaItemAction
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent ManualUploadClicked;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/kindle/action/ManualUploadAction$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            ManualUploadClicked = new MetricsEvent("ManualUploadClicked", 0);
            $VALUES = (new MetricsEvent[] {
                ManualUploadClicked
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }

    protected static final class PostUploadAction extends Enum
    {

        private static final PostUploadAction $VALUES[];
        public static final PostUploadAction MANAGE_STORAGE;
        public static final PostUploadAction WIRELESS_SETTINGS;

        public static PostUploadAction valueOf(String s)
        {
            return (PostUploadAction)Enum.valueOf(com/amazon/gallery/framework/kindle/action/ManualUploadAction$PostUploadAction, s);
        }

        public static PostUploadAction[] values()
        {
            return (PostUploadAction[])$VALUES.clone();
        }

        static 
        {
            WIRELESS_SETTINGS = new PostUploadAction("WIRELESS_SETTINGS", 0);
            MANAGE_STORAGE = new PostUploadAction("MANAGE_STORAGE", 1);
            $VALUES = (new PostUploadAction[] {
                WIRELESS_SETTINGS, MANAGE_STORAGE
            });
        }

        private PostUploadAction(String s, int i)
        {
            super(s, i);
        }
    }

    protected class UploadDialogClickListener
        implements android.content.DialogInterface.OnClickListener
    {

        private PostUploadAction postUploadAction;
        final ManualUploadAction this$0;
        private UploadRequest uploadRequest;
        private UploadStrategy uploadStrategy;

        public void onClick(DialogInterface dialoginterface, int i)
        {
            queueUpload(uploadRequest, uploadStrategy, postUploadAction);
        }

        public UploadDialogClickListener(UploadRequest uploadrequest)
        {
            this(uploadrequest, UploadStrategy.WIFI_ONLY, null);
        }

        public UploadDialogClickListener(UploadRequest uploadrequest, UploadStrategy uploadstrategy, PostUploadAction postuploadaction)
        {
            this$0 = ManualUploadAction.this;
            super();
            uploadRequest = uploadrequest;
            uploadStrategy = uploadstrategy;
            postUploadAction = postuploadaction;
        }
    }

    protected class UploadRequest
    {

        private final List mediaItems;
        private final List tags;
        final ManualUploadAction this$0;
        private int toastMessage;

        private boolean containsVideo(List list)
        {
            for (list = list.iterator(); list.hasNext();)
            {
                MediaItem mediaitem = (MediaItem)list.next();
                if (mediaitem.getType() == MediaType.VIDEO && SyncState.SYNCED != mediaitem.getSyncState())
                {
                    return true;
                }
            }

            return false;
        }

        public boolean containsVideo()
        {
label0:
            {
                if (mediaItems != null && containsVideo(mediaItems))
                {
                    return true;
                }
                if (tags == null)
                {
                    break label0;
                }
                Iterator iterator = tags.iterator();
                Tag tag;
                do
                {
                    if (!iterator.hasNext())
                    {
                        break label0;
                    }
                    tag = (Tag)iterator.next();
                } while (!containsVideo(mediaItemDao.getItemsByTag(tag).getMediaItems()));
                return true;
            }
            return false;
        }

        public long getFileLength(Set set)
        {
            long l = 0L;
            if (mediaItems != null)
            {
                l = 0L + MediaItemUtil.getFileLength(mediaItems, set);
            }
            long l1 = l;
            if (tags != null)
            {
                Iterator iterator = tags.iterator();
                do
                {
                    l1 = l;
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Tag tag = (Tag)iterator.next();
                    l += MediaItemUtil.getFileLength(mediaItemDao.getItemsByTag(tag).getMediaItems(), set);
                } while (true);
            }
            return l1;
        }

        public List getMediaItems()
        {
            return mediaItems;
        }

        public List getTags()
        {
            return tags;
        }

        public int getToastMessage()
        {
            return toastMessage;
        }

        public int photoCount()
        {
            int i = 0;
            if (mediaItems != null)
            {
                i = 0 + mediaItems.size();
            }
            int j = i;
            if (tags != null)
            {
                Iterator iterator = tags.iterator();
                do
                {
                    j = i;
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Tag tag = (Tag)iterator.next();
                    i += mediaItemDao.getItemsByTag(tag).getMediaItems().size();
                } while (true);
            }
            return j;
        }

        public void setToastMessage(int i)
        {
            toastMessage = i;
        }

        public UploadRequest(List list, List list1)
        {
            this$0 = ManualUploadAction.this;
            super();
            toastMessage = 0x7f0e018c;
            mediaItems = list;
            tags = list1;
        }
    }


    private static final String TAG = com/amazon/gallery/framework/kindle/action/ManualUploadAction.getName();
    private final AuthenticationManager authenticationManager;
    private final SharedPreferences kindlePreferences;
    private final MediaItemDao mediaItemDao;
    private final RestClient restClient;

    public ManualUploadAction(Activity activity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager, RestClient restclient, MediaItemDao mediaitemdao, AuthenticationManager authenticationmanager)
    {
        super(activity, networkconnectivity, photosdemomanager, 0x7f0e0187);
        restClient = restclient;
        mediaItemDao = mediaitemdao;
        authenticationManager = authenticationmanager;
        kindlePreferences = activity.getSharedPreferences("galleryKindleSharedPrefs", 0);
        GlobalMessagingBus.register(this);
    }

    private void displayUploadMessage(UploadStrategy uploadstrategy, final int messageId)
    {
        if (!networkConnectivity.isNetworkConnected() || networkConnectivity.getConnectionStatus() == com.amazon.gallery.framework.network.connectivity.NetworkConnectivity.ConnectionStatus.WAN && uploadstrategy == UploadStrategy.WIFI_ONLY)
        {
            messageId = 0x7f0e018b;
        }
        uploadstrategy = new Runnable() ;
        context.runOnUiThread(uploadstrategy);
    }

    private void execute(UploadRequest uploadrequest)
    {
        if (photosDemoManager.isInDemoMode())
        {
            photosDemoManager.showWarningForUnavailableAction(context);
            return;
        }
        if (!authenticationManager.hasActiveAccount())
        {
            context.startActivity(new Intent("com.amazon.dcp.sso.AddAccount"));
            return;
        }
        if (!networkConnectivity.isNetworkConnected())
        {
            promptNoConnection(uploadrequest);
            return;
        }
        if (networkConnectivity.getConnectionStatus() == com.amazon.gallery.framework.network.connectivity.NetworkConnectivity.ConnectionStatus.WAN)
        {
            promptWANConnection(uploadrequest);
            return;
        } else
        {
            fetchStorageInformation(uploadrequest);
            return;
        }
    }

    private void fetchStorageInformation(final UploadRequest uploadRequest)
    {
        (new AsyncTask() {

            final ManualUploadAction this$0;
            final UploadRequest val$uploadRequest;

            protected volatile Object doInBackground(Object aobj[])
            {
                return doInBackground((Void[])aobj);
            }

            protected transient Void doInBackground(Void avoid[])
            {
                avoid = new GetAccountQuotaRequest();
                try
                {
                    avoid = .getForegroundCdsClient().getAccountQuota(avoid);
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    GLogger.ex(ManualUploadAction.TAG, "Failed to get the storage information...", avoid);
                    onStorageInformationFailedToLoad(uploadRequest);
                    return null;
                }
                // Misplaced declaration of an exception variable
                catch (Void avoid[])
                {
                    GLogger.d(ManualUploadAction.TAG, "Failed to get the storage information - interrupted", new Object[0]);
                    onStorageInformationFailedToLoad(uploadRequest);
                    return null;
                }
                onStorageInformationLoaded(avoid.getAvailable(), uploadRequest);
                return null;
            }

            
            {
                this$0 = ManualUploadAction.this;
                uploadRequest = uploadrequest;
                super();
            }
        }).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    private void onStorageInformationFailedToLoad(UploadRequest uploadrequest)
    {
        queueUpload(uploadrequest, UploadStrategy.WIFI_ONLY, null);
    }

    private void onStorageInformationLoaded(long l, UploadRequest uploadrequest)
    {
        if (uploadrequest.containsVideo() && (l == 0L || l < uploadrequest.getFileLength(Collections.singleton(MediaType.VIDEO))))
        {
            promptLowSpace(uploadrequest);
            return;
        } else
        {
            queueUpload(uploadrequest, UploadStrategy.WIFI_ONLY, null);
            return;
        }
    }

    private boolean setMediaItemSyncStatePendingManual(List list)
    {
        boolean flag = false;
        Iterator iterator = list.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            MediaItem mediaitem = (MediaItem)iterator.next();
            static class _cls6
            {

                static final int $SwitchMap$com$amazon$gallery$framework$kindle$action$ManualUploadAction$PostUploadAction[];
                static final int $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[];

                static 
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$SyncState = new int[SyncState.values().length];
                    try
                    {
                        $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.PENDING_MANUAL.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror5) { }
                    try
                    {
                        $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.PENDING_AUTO.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror4) { }
                    try
                    {
                        $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.SYNCED.ordinal()] = 3;
                    }
                    catch (NoSuchFieldError nosuchfielderror3) { }
                    try
                    {
                        $SwitchMap$com$amazon$gallery$framework$model$media$SyncState[SyncState.SYNCING.ordinal()] = 4;
                    }
                    catch (NoSuchFieldError nosuchfielderror2) { }
                    $SwitchMap$com$amazon$gallery$framework$kindle$action$ManualUploadAction$PostUploadAction = new int[PostUploadAction.values().length];
                    try
                    {
                        $SwitchMap$com$amazon$gallery$framework$kindle$action$ManualUploadAction$PostUploadAction[PostUploadAction.WIRELESS_SETTINGS.ordinal()] = 1;
                    }
                    catch (NoSuchFieldError nosuchfielderror1) { }
                    try
                    {
                        $SwitchMap$com$amazon$gallery$framework$kindle$action$ManualUploadAction$PostUploadAction[PostUploadAction.MANAGE_STORAGE.ordinal()] = 2;
                    }
                    catch (NoSuchFieldError nosuchfielderror)
                    {
                        return;
                    }
                }
            }

            switch (_cls6..SwitchMap.com.amazon.gallery.framework.model.media.SyncState[mediaitem.getSyncState().ordinal()])
            {
            default:
                mediaitem.setSyncState(SyncState.PENDING_MANUAL);
                flag = true;
                break;

            case 1: // '\001'
            case 2: // '\002'
            case 3: // '\003'
            case 4: // '\004'
                break;
            }
        } while (true);
        if (flag)
        {
            mediaItemDao.saveMergedFields(list, true);
        }
        return flag;
    }

    public boolean canExecute(ViewDescriptor viewdescriptor, MediaItem mediaitem)
    {
        return mediaitem != null && isValid(mediaitem);
    }

    public void execute(List list)
    {
        super.execute(list);
        execute(new UploadRequest(list, null));
    }

    public void executeTags(List list)
    {
        execute(new UploadRequest(null, list));
    }

    protected boolean isValid(MediaItem mediaitem)
    {
        boolean flag1 = false;
        boolean flag = flag1;
        if (super.isValid(mediaitem))
        {
            flag = flag1;
            if (kindlePreferences.getBoolean("coldBootStatus", false))
            {
                flag = flag1;
                if (!MediaItemUtil.isCloudMediaItem(mediaitem))
                {
                    flag = flag1;
                    if (SyncState.PENDING_MANUAL != mediaitem.getSyncState())
                    {
                        flag = true;
                    }
                }
            }
        }
        return flag;
    }

    protected boolean isValid(Tag tag)
    {
        return tag.hasProperty(TagProperty.LOCAL);
    }

    protected void launchManageStorage()
    {
        Intent intent = UploadUtils.getManageStorageWebIntent(restClient, NetworkExecutor.getInstance(), networkConnectivity);
        if (intent == null)
        {
            return;
        } else
        {
            context.startActivity(intent);
            return;
        }
    }

    protected void promptLowSpace(final UploadRequest uploadRequest)
    {
        uploadRequest.setToastMessage(0x7f0e018c);
        context.runOnUiThread(new Runnable() );
    }

    protected void promptNoConnection(final UploadRequest uploadRequest)
    {
        context.runOnUiThread(new Runnable() );
    }

    protected void promptWANConnection(final UploadRequest uploadRequest)
    {
        final String message = new HashSet();
        message.add(MediaType.PHOTO);
        message.add(MediaType.VIDEO);
        long l = uploadRequest.getFileLength(message);
        message = context.getString(0x7f0e0188, new Object[] {
            Integer.valueOf(uploadRequest.photoCount()), FileUtils.byteCountToDisplaySize(l)
        });
        context.runOnUiThread(new Runnable() );
    }

    protected void queueUpload(UploadRequest uploadrequest, UploadStrategy uploadstrategy, PostUploadAction postuploadaction)
    {
        if (uploadrequest.getMediaItems() != null)
        {
            GlobalMessagingBus.post(new UploadMediaItemsEvent(uploadrequest.getMediaItems(), QueueType.MANUAL, uploadstrategy, TAG));
            setMediaItemSyncStatePendingManual(uploadrequest.getMediaItems());
        }
        if (uploadrequest.getTags() != null)
        {
            GlobalMessagingBus.post(new UploadTagsEvent(uploadrequest.getTags(), QueueType.MANUAL, uploadstrategy, TAG));
            Tag tag;
            for (Iterator iterator = uploadrequest.getTags().iterator(); iterator.hasNext(); setMediaItemSyncStatePendingManual(new LinkedList(mediaItemDao.getItemsByTag(tag).getMediaItems())))
            {
                tag = (Tag)iterator.next();
            }

        }
        GlobalMessagingBus.post(new ActionCompleteEvent());
        displayUploadMessage(uploadstrategy, uploadrequest.getToastMessage());
        if (postuploadaction == null)
        {
            return;
        }
        switch (_cls6..SwitchMap.com.amazon.gallery.framework.kindle.action.ManualUploadAction.PostUploadAction[postuploadaction.ordinal()])
        {
        default:
            return;

        case 1: // '\001'
            context.startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
            return;

        case 2: // '\002'
            launchManageStorage();
            break;
        }
    }

    public void recordOnActionMetrics(List list)
    {
        if (actionSource == com.amazon.gallery.framework.gallery.actions.MediaItemAction.ActionSource.SINGLE_VIEW_HAB)
        {
            profiler.trackEvent(MetricsEvent.ManualUploadClicked, ClickstreamEventHelper.createClickstreamExtra("ActionEvent", HitType.APP_ACTION));
        }
        if (isWhisperPlayMode())
        {
            list = com.amazon.gallery.whisperplay.metrics.WhisperPlayMetrics.MetricsEvent.WPUploadAction;
            profiler.trackEvent(list, CustomerMetricsHelper.getExtraEventTag(list.toString()));
        }
    }










}
