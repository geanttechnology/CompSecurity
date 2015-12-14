// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.kindle.action;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.SystemClock;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.async.BlockingProgressDialog;
import com.amazon.gallery.foundation.utils.async.CancellableBlockingProgressDialog;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.store.Asset;
import com.amazon.gallery.framework.data.store.DiskStorageUtils;
import com.amazon.gallery.framework.data.store.DiskStore;
import com.amazon.gallery.framework.data.store.LenticularHelper;
import com.amazon.gallery.framework.gallery.actions.LaunchAviary;
import com.amazon.gallery.framework.gallery.actions.MediaItemAction;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.gallery.share.ShareStore;
import com.amazon.gallery.framework.gallery.view.ViewDescriptor;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.NativeGalleryActivity;
import com.amazon.gallery.framework.kindle.provider.MediaContentConfiguration;
import com.amazon.gallery.framework.metrics.clickstream.ClickstreamEventHelper;
import com.amazon.gallery.framework.metrics.clickstream.HitType;
import com.amazon.gallery.framework.metrics.customer.CustomerMetricsHelper;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.EditType;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.MediaType;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.framework.network.disk.NetworkStore;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.removablestorage.RemovableStorageManager;
import java.io.File;
import java.io.IOException;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class EditMediaItemAction extends MediaItemAction
{
    public static final class MetricsEvent extends Enum
    {

        private static final MetricsEvent $VALUES[];
        public static final MetricsEvent ContextMenuEditSelected;
        public static final MetricsEvent SingleViewEditSelected;

        public static MetricsEvent valueOf(String s)
        {
            return (MetricsEvent)Enum.valueOf(com/amazon/gallery/framework/kindle/action/EditMediaItemAction$MetricsEvent, s);
        }

        public static MetricsEvent[] values()
        {
            return (MetricsEvent[])$VALUES.clone();
        }

        static 
        {
            ContextMenuEditSelected = new MetricsEvent("ContextMenuEditSelected", 0);
            SingleViewEditSelected = new MetricsEvent("SingleViewEditSelected", 1);
            $VALUES = (new MetricsEvent[] {
                ContextMenuEditSelected, SingleViewEditSelected
            });
        }

        private MetricsEvent(String s, int i)
        {
            super(s, i);
        }
    }

    private class PreUploadCloudEditTask extends AsyncTask
    {

        private final MediaItem mediaItem;
        final EditMediaItemAction this$0;

        protected transient File doInBackground(Void avoid[])
        {
            GLogger.i(EditMediaItemAction.TAG, "Editing cloud photo before it's uploaded, making a copy of temporary local version", new Object[0]);
            avoid = new File(mediaItem.getLocalPath());
            Object obj = (new StringBuilder()).append(EditMediaItemAction.getBaseName(mediaItem.getName())).append(SystemClock.uptimeMillis()).append(com.amazon.gallery.framework.data.store.Asset.AssetType.JPG.getFileExtension()).toString();
            obj = new File(EditMediaItemAction.getTempEditDir(
// JavaClassFileOutputException: get_constant: invalid tag

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected void onPostExecute(File file)
        {
            if (file != null && file.exists())
            {
                launchAviary(file, mediaItem, EditType.CLOUD);
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((File)obj);
        }

        public PreUploadCloudEditTask(MediaItem mediaitem)
        {
            this$0 = EditMediaItemAction.this;
            super();
            mediaItem = mediaitem;
        }
    }


    private static final String TAG = com/amazon/gallery/framework/kindle/action/EditMediaItemAction.getName();
    private final DiskStore diskStore;
    private final LaunchAviary launchAviary;
    private final NetworkStore networkStore;
    private final ShareStore shareStore;

    public EditMediaItemAction(Activity activity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager, LaunchAviary launchaviary, ShareStore sharestore, DiskStore diskstore, NetworkStore networkstore)
    {
        super(activity, networkconnectivity, photosdemomanager, 0x7f0e0118);
        shareStore = sharestore;
        diskStore = diskstore;
        networkStore = networkstore;
        launchAviary = launchaviary;
    }

    private static String appendMediaItemData(MediaItem mediaitem, Tag tag)
    {
        String s = "null";
        if (tag != null)
        {
            s = tag.getObjectId().toString();
        }
        ObjectID objectid = mediaitem.getParentObjectID();
        tag = objectid;
        if (objectid == null)
        {
            tag = mediaitem.getObjectId();
        }
        return (new StringBuilder()).append(s).append("_").append(tag.toString()).append("_").append(mediaitem.getDateCreatedMs()).append("_").append(getEditedName(mediaitem.getName())).toString();
    }

    private File copyToSharedDirectory(String s, File file)
    {
        File file1 = new File(shareStore.getSharedDirectory(), (new StringBuilder()).append(FilenameUtils.getBaseName(s)).append(com.amazon.gallery.framework.data.store.Asset.AssetType.JPG.getFileExtension()).toString());
        s = file1;
        if (file1.exists())
        {
            s = file1;
            if (file1.length() != file.length())
            {
                s = shareStore.resolveNameConflict(file1, file.length());
            }
        }
        try
        {
            if (!s.exists())
            {
                diskStore.getDiskStorageUtils().storeFile(file, s);
            }
        }
        // Misplaced declaration of an exception variable
        catch (File file)
        {
            GLogger.ex(TAG, "Unable to copy asset to shared directory.", file);
            return s;
        }
        return s;
    }

    private void editPhoto(MediaItem mediaitem)
    {
        boolean flag = MediaItemUtil.isCloudMediaItem(mediaitem);
        boolean flag1 = MediaItemUtil.isLocalMediaItem(mediaitem);
        if (mediaitem.getSyncState() == SyncState.PENDING_EDITED)
        {
            (new PreUploadCloudEditTask(mediaitem)).executeOnExecutor(AsyncTask.SERIAL_EXECUTOR, new Void[0]);
            return;
        }
        if (flag1)
        {
            Object obj = mediaitem.getLocalPath();
            File file1 = diskStore.getDiskStorageUtils().createFile(((String) (obj)));
            if (flag)
            {
                obj = EditType.UNIFIED;
            } else
            {
                obj = EditType.LOCAL;
            }
            launchAviary(file1, mediaitem, ((EditType) (obj)));
            return;
        }
        GLogger.d(TAG, "Attempting to use original for Aviary", new Object[0]);
        File file = diskStore.getOriginal(mediaitem);
        if (file != null && file.exists())
        {
            launchAviary(file, mediaitem, EditType.CLOUD);
            return;
        } else
        {
            GLogger.d(TAG, "Original does not exist.", new Object[0]);
            CancellableBlockingProgressDialog cancellableblockingprogressdialog = new CancellableBlockingProgressDialog(1, true, mediaitem) {

                final EditMediaItemAction this$0;
                final MediaItem val$mediaItem;

                protected transient File doInBackground(MediaItem amediaitem[])
                {
                    amediaitem = amediaitem[0];
                    if (!
// JavaClassFileOutputException: get_constant: invalid tag

                protected volatile Object doInBackground(Object aobj[])
                {
                    return doInBackground((MediaItem[])aobj);
                }

                protected void onPostExecute(File file2)
                {
                    onPostExecute(file2);
                    if (file2 == null || !file2.exists())
                    {
                        if (!
// JavaClassFileOutputException: get_constant: invalid tag

                protected volatile void onPostExecute(Object obj1)
                {
                    onPostExecute((File)obj1);
                }

            
            {
                this$0 = EditMediaItemAction.this;
                mediaItem = mediaitem;
                super(final_context, i, flag);
            }
            };
            String s = context.getString(0x7f0e009d);
            String s1 = context.getString(0x7f0e009c);
            cancellableblockingprogressdialog.setDialogTitle(s);
            cancellableblockingprogressdialog.setDialogMessage(s1);
            cancellableblockingprogressdialog.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new MediaItem[] {
                mediaitem
            });
            return;
        }
    }

    private String generateFileName(MediaItem mediaitem)
    {
        Tag tag = null;
        if (context instanceof NativeGalleryActivity)
        {
            tag = ((NativeGalleryActivity)context).getMediaContentConfiguration().toViewDescriptor().getTag();
        }
        return appendMediaItemData(mediaitem, tag);
    }

    private static String getBaseName(String s)
    {
        int i = s.lastIndexOf(".");
        String s1 = s;
        if (i != -1)
        {
            s1 = s.substring(0, i);
        }
        return s1;
    }

    public static String getEditedName(String s)
    {
        String s1 = getBaseName(s);
        int i = s1.indexOf("_kindlephoto-");
        s = s1;
        if (i != -1)
        {
            s = s1.substring(0, i);
        }
        return (new StringBuilder()).append(s).append("_kindlephoto-").append(SystemClock.uptimeMillis()).append(".jpg").toString();
    }

    public static File getTempEditDir(Context context)
    {
        context = new File(context.getFilesDir(), "edits");
        if (!context.exists())
        {
            context.mkdir();
        }
        return context;
    }

    public static boolean isInTempEditDir(Context context, String s)
    {
        return FilenameUtils.getFullPathNoEndSeparator(s).equals(getTempEditDir(context).getAbsolutePath());
    }

    private void launchAviary(File file, MediaItem mediaitem, EditType edittype)
    {
        Uri uri;
        char c;
        GLogger.d(TAG, "Passing file to aviary: %s", new Object[] {
            file
        });
        uri = Uri.fromFile(file);
        file = file.getParentFile();
        c = '\uFFFF';
        static class _cls2
        {

            static final int $SwitchMap$com$amazon$gallery$framework$model$media$EditType[];

            static 
            {
                $SwitchMap$com$amazon$gallery$framework$model$media$EditType = new int[EditType.values().length];
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$EditType[EditType.LOCAL.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$EditType[EditType.CLOUD.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$amazon$gallery$framework$model$media$EditType[EditType.UNIFIED.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.com.amazon.gallery.framework.model.media.EditType[edittype.ordinal()];
        JVM INSTR tableswitch 1 3: default 64
    //                   1 149
    //                   2 157
    //                   3 173;
           goto _L1 _L2 _L3 _L4
_L1:
        GlobalMessagingBus.post(new ActionCompleteEvent());
        edittype = generateFileName(mediaitem);
        mediaitem = new File(file, edittype);
        RemovableStorageManager removablestoragemanager = (RemovableStorageManager)ThorGalleryApplication.getBean(Keys.REMOVABLE_STORAGE_MANAGER);
        file = mediaitem;
        if (removablestoragemanager.isFileInReadOnlyRemovableStorageLocation(mediaitem))
        {
            file = new File(removablestoragemanager.getRemovableStorageDownloadDirectory(), edittype);
        }
        launchAviary.launch(context, uri, file, c);
        return;
_L2:
        c = '\234';
        continue; /* Loop/switch isn't completed */
_L3:
        c = '\233';
        file = getTempEditDir(context);
        continue; /* Loop/switch isn't completed */
_L4:
        c = '\235';
        if (true) goto _L1; else goto _L5
_L5:
    }

    public static long parseDate(String s)
    {
        int i = s.indexOf("_", s.indexOf("_", 0) + 1);
        long l;
        try
        {
            l = Long.parseLong(s.substring(i + 1, s.indexOf("_", i + 1)));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            GLogger.e(TAG, "Failed to parse date from filename", new Object[0]);
            return 0L;
        }
        return l;
    }

    public static ObjectID parseParentId(String s)
    {
        ObjectID objectid;
        try
        {
            int i = s.indexOf("_", 0);
            objectid = ObjectID.parseString(s.substring(i + 1, s.indexOf("_", i + 1)));
        }
        catch (StringIndexOutOfBoundsException stringindexoutofboundsexception)
        {
            GLogger.ex(TAG, String.format("#parseParentId(%s): Unexpected filename format", new Object[] {
                s
            }), stringindexoutofboundsexception);
            return null;
        }
        catch (Exception exception)
        {
            GLogger.ex(TAG, String.format("#parseParentId(%s): Failed to parse ObjectID parent from filename", new Object[] {
                s
            }), exception);
            return null;
        }
        return objectid;
    }

    public static String removeArgumentsFromName(String s)
    {
        s = s.substring(s.indexOf("_") + 1);
        s = s.substring(s.indexOf("_") + 1);
        return s.substring(s.indexOf("_") + 1);
    }

    public boolean canExecute(List list)
    {
        return canExecute(list) && list.size() == 1;
    }

    public void execute(List list)
    {
        if (list.size() != 1)
        {
            throw new UnsupportedOperationException("We don't support multiple photo edits");
        } else
        {
            execute(list);
            editPhoto((MediaItem)list.get(0));
            return;
        }
    }

    protected boolean isValid(MediaItem mediaitem)
    {
        return isValid(mediaitem) && mediaitem.getType() == MediaType.PHOTO && !"image/gif".equals(mediaitem.getMIMEType()) && !LenticularHelper.isLenticular(mediaitem.getName());
    }

    protected boolean isValid(Tag tag)
    {
        return false;
    }

    public void recordOnActionMetrics(List list)
    {
        if (profiler != null && actionSource != null && actionSource == com.amazon.gallery.framework.gallery.actions.MediaItemAction.ActionSource.SINGLE_VIEW_HAB)
        {
            profiler.trackEvent(MetricsEvent.SingleViewEditSelected, ClickstreamEventHelper.createClickstreamExtra("ActionEvent", HitType.APP_ACTION));
        }
        if (isWhisperPlayMode())
        {
            list = com.amazon.gallery.whisperplay.metrics.WhisperPlayMetrics.MetricsEvent.WPEditAction;
            profiler.trackEvent(list, CustomerMetricsHelper.getExtraEventTag(list.toString()));
        }
    }










}
