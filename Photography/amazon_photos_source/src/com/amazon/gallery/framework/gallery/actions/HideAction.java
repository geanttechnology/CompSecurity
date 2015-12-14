// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.gallery.actions;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.os.AsyncTask;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.model.Settings;
import com.amazon.clouddrive.model.UpdateNodeRequest;
import com.amazon.gallery.foundation.utils.IdUtils;
import com.amazon.gallery.foundation.utils.MediaContentUtil;
import com.amazon.gallery.foundation.utils.async.BlockingSpinnerDialog;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.ActionCompleteEvent;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.gallery.demo.PhotosDemoManager;
import com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.network.connectivity.NetworkConnectivity;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.gallery.actions:
//            MediaItemAction

public class HideAction extends MediaItemAction
{

    private static final String TAG = com/amazon/gallery/framework/gallery/actions/HideAction.getName();
    protected final Context context;
    private final MediaItemDao mediaItemDao;
    private long parentTag;
    private TagDao tagDao;

    public HideAction(Activity activity, NetworkConnectivity networkconnectivity, PhotosDemoManager photosdemomanager, TagDao tagdao, MediaItemDao mediaitemdao)
    {
        super(activity, networkconnectivity, photosdemomanager, 0x7f0e01c0);
        parentTag = 0L;
        context = activity;
        mediaItemDao = mediaitemdao;
        tagDao = tagdao;
    }

    private void setLocalMediaItemHide(MediaItem mediaitem)
    {
        mediaitem.setHidden(shouldHide());
        mediaItemDao.saveMergedFields(mediaitem, false);
    }

    public void execute(final List mediaItemList)
    {
        if (networkConnectivity.promptIfOffline(context))
        {
            return;
        }
        super.execute(mediaItemList);
        Object obj = MediaContentUtil.getTagFromContentConfiguration();
        if (obj != null)
        {
            obj = ((Tag) (obj)).getObjectId().toString();
            if (obj != null && !((String) (obj)).isEmpty())
            {
                parentTag = tagDao.getTagById(ObjectID.parseString(((String) (obj)))).getId();
            }
        }
        mediaItemList = new Runnable() {

            final HideAction this$0;
            final List val$mediaItemList;

            public void run()
            {
                Iterator iterator = mediaItemList.iterator();
_L2:
                MediaItem mediaitem;
                if (!iterator.hasNext())
                {
                    break MISSING_BLOCK_LABEL_199;
                }
                mediaitem = (MediaItem)iterator.next();
                GLogger.d(HideAction.TAG, "media item is %s and hidden is %s and should hide is %s", new Object[] {
                    mediaitem.getName(), Boolean.valueOf(mediaitem.isHidden()), Boolean.valueOf(shouldHide())
                });
                if (MediaItemUtil.isCloudMediaItem(mediaitem))
                {
                    UpdateNodeRequest updatenoderequest = new UpdateNodeRequest(IdUtils.objectIdToNodeId(mediaitem.getObjectId().getMostSignificantBits(), mediaitem.getObjectId().getLeastSignificantBits()));
                    Settings settings = new Settings();
                    settings.setHidden(Boolean.valueOf(shouldHide()));
                    updatenoderequest.setSettings(settings);
                    cloudDriveServiceClientManager.getForegroundCdsClient().updateNode(updatenoderequest);
                }
                setLocalMediaItemHide(mediaitem);
                continue; /* Loop/switch isn't completed */
                CloudDriveException clouddriveexception;
                clouddriveexception;
                GLogger.ex(HideAction.TAG, "Unable to update hidden property for cloud item", clouddriveexception);
                continue; /* Loop/switch isn't completed */
                InterruptedException interruptedexception;
                interruptedexception;
                GLogger.d(HideAction.TAG, "Unable to update hidden property for cloud item - interrupted", new Object[0]);
                Thread.currentThread().interrupt();
                return;
                if (true) goto _L2; else goto _L1
_L1:
            }

            
            {
                this$0 = HideAction.this;
                mediaItemList = list;
                super();
            }
        };
        obj = new Runnable() {

            final HideAction this$0;

            public void run()
            {
                if (parentTag != 0L)
                {
                    android.net.Uri uri = GalleryInternalContentProvider.createDynamicAlbumMediaUri(parentTag);
                    context.getContentResolver().notifyChange(uri, null);
                }
            }

            
            {
                this$0 = HideAction.this;
                super();
            }
        };
        if (shouldHide())
        {
            mediaItemList = new BlockingSpinnerDialog(context, mediaItemList, context.getString(0x7f0e01c1));
        } else
        {
            mediaItemList = new BlockingSpinnerDialog(context, mediaItemList, context.getString(0x7f0e0227));
        }
        mediaItemList.setPostExecuteTask(((Runnable) (obj)));
        mediaItemList.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
        GlobalMessagingBus.post(new ActionCompleteEvent());
    }

    protected boolean isValid(MediaItem mediaitem)
    {
        return super.isValid(mediaitem) && !mediaitem.isHidden();
    }

    protected boolean isValid(Tag tag)
    {
        return false;
    }

    public void recordOnActionMetrics(List list)
    {
    }

    protected boolean shouldHide()
    {
        return true;
    }




}
