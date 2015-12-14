// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.extended.model.BulkAddRemoveChildRequest;
import com.amazon.clouddrive.extended.model.BulkTrashRestoreNodesRequest;
import com.amazon.clouddrive.model.AddChildToParentRequest;
import com.amazon.clouddrive.model.RemoveChildFromParentRequest;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.DynamicAlbumDao;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import com.amazon.mixtape.utils.IdUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AlbumOperation, AlbumPageTracker, AlbumsMetricsHelper

public class DeleteFromAlbumTask extends AlbumOperation
{

    private static final String TAG = com/amazon/gallery/thor/albums/DeleteFromAlbumTask.getName();
    private String albumObjectId;
    private final boolean deleteFromCloud;
    private int errorMessage;
    private List mediaItems;

    public DeleteFromAlbumTask(Activity activity, List list, String s, boolean flag, ComponentProfiler componentprofiler)
    {
        super(activity, componentprofiler);
        mediaItems = list;
        albumObjectId = s;
        deleteFromCloud = flag;
        errorMessage = 0x7f0e002d;
    }

    protected boolean doInBackground()
    {
        Object obj1;
        Iterator iterator1;
        if (promptIfOffline())
        {
            return false;
        }
        ArrayList arraylist = new ArrayList(mediaItems.size());
        ObjectID objectid;
        for (Iterator iterator = mediaItems.iterator(); iterator.hasNext(); arraylist.add(IdUtils.objectIdToNodeId(objectid.getMostSignificantBits(), objectid.getLeastSignificantBits())))
        {
            objectid = ((MediaItem)iterator.next()).getObjectId();
        }

        obj1 = ObjectID.parseString(albumObjectId);
        obj1 = IdUtils.objectIdToNodeId(((ObjectID) (obj1)).getMostSignificantBits(), ((ObjectID) (obj1)).getLeastSignificantBits());
        iterator1 = partitionIds(arraylist).iterator();
_L7:
        List list;
        if (!iterator1.hasNext())
        {
            break MISSING_BLOCK_LABEL_389;
        }
        list = (List)iterator1.next();
        if (list.size() != 1) goto _L2; else goto _L1
_L1:
        if (!undo) goto _L4; else goto _L3
_L3:
        AddChildToParentRequest addchildtoparentrequest = new AddChildToParentRequest(((String) (obj1)), (String)list.get(0));
        cdsClientManager.getForegroundCdsClient().addChildToParent(addchildtoparentrequest);
_L5:
        recordMetrics(true, list.size());
        Object obj;
        CloudDriveException clouddriveexception1;
        if (deleteFromCloud)
        {
            try
            {
                BulkTrashRestoreNodesRequest bulktrashrestorenodesrequest = new BulkTrashRestoreNodesRequest(list, "add");
                cdsClientManager.getForegroundCdsClient().bulkTrashRestoreNodes(bulktrashrestorenodesrequest);
            }
            catch (CloudDriveException clouddriveexception)
            {
                GLogger.ex(TAG, "Unable to trash nodes", clouddriveexception);
                if (getActivity() != null)
                {
                    errorMessage = 0x7f0e0022;
                }
                return false;
            }
            catch (InterruptedException interruptedexception)
            {
                GLogger.d(TAG, "Error trashing nodes - interrupted", new Object[0]);
                return false;
            }
        }
        continue; /* Loop/switch isn't completed */
_L4:
        try
        {
            obj = new RemoveChildFromParentRequest(((String) (obj1)), (String)list.get(0));
            cdsClientManager.getForegroundCdsClient().removeChildFromParent(((RemoveChildFromParentRequest) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (CloudDriveException clouddriveexception1)
        {
            GLogger.ex(TAG, "Error removing media items from album", clouddriveexception1);
            recordMetrics(false, list.size());
            return false;
        }
        // Misplaced declaration of an exception variable
        catch (CloudDriveException clouddriveexception1)
        {
            GLogger.d(TAG, "Error removing media items from album - interrupted", new Object[0]);
            recordMetrics(false, list.size());
            return false;
        }
          goto _L5
_L2:
        if (undo)
        {
            clouddriveexception1 = "add";
        } else
        {
            clouddriveexception1 = "remove";
        }
        clouddriveexception1 = new BulkAddRemoveChildRequest(((String) (obj1)), list, clouddriveexception1);
        cdsClientManager.getForegroundCdsClient().bulkAddRemoveChild(clouddriveexception1);
          goto _L5
        return true;
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected android.view.View.OnClickListener getAction()
    {
        if (deleteFromCloud)
        {
            return null;
        } else
        {
            return new android.view.View.OnClickListener() {

                final DeleteFromAlbumTask this$0;

                public void onClick(View view)
                {
                    view = new DeleteFromAlbumTask(getActivity(), mediaItems, albumObjectId, false, profiler);
                    view.setUndo();
                    view.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                }

            
            {
                this$0 = DeleteFromAlbumTask.this;
                super();
            }
            };
        }
    }

    protected int getProgressMessage()
    {
        if (undo)
        {
            return 0x7f0e0033;
        }
        return !deleteFromCloud ? 0x7f0e002e : 0x7f0e008e;
    }

    protected void onPostExecute(Boolean boolean1)
    {
        Activity activity;
label0:
        {
            super.onPostExecute(boolean1);
            recordOperationDuration(AlbumsMetricsHelper.MetricsEvent.RemovePhotosTime);
            activity = getActivity();
            if (activity != null)
            {
                if (!undo || !boolean1.booleanValue())
                {
                    break label0;
                }
                showSnackbar(activity.getString(0x7f0e01fe));
            }
            return;
        }
        if (undo && !boolean1.booleanValue())
        {
            showSnackbar(activity.getString(0x7f0e01fd));
            return;
        }
        if (!boolean1.booleanValue())
        {
            showSnackbar(activity.getString(errorMessage));
            return;
        } else
        {
            showSnackbarWithAction(activity.getString(0x7f0e002f), getAction(), activity.getString(0x7f0e01fc));
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Boolean)obj);
    }

    protected void performLocalOperation()
    {
        MediaItemDao mediaitemdao = (MediaItemDao)ThorGalleryApplication.getBean(Keys.MEDIA_ITEM_DAO);
        Object obj = ((TagDao)ThorGalleryApplication.getBean(Keys.TAG_DAO)).getTagById(ObjectID.parseString(albumObjectId));
        if (obj == null)
        {
            GLogger.i(TAG, "Tag was null, failed to remove tag membership locally", new Object[0]);
        } else
        {
            ArrayList arraylist = new ArrayList(mediaItems.size());
            for (Iterator iterator = mediaItems.iterator(); iterator.hasNext(); arraylist.add(Long.valueOf(((MediaItem)iterator.next()).getId()))) { }
            DynamicAlbumDao dynamicalbumdao;
            int i;
            if (undo)
            {
                mediaitemdao.addTagMemberships(mediaItems, ((Tag) (obj)));
            } else
            {
                mediaitemdao.deleteTagMemberships(mediaItems, ((Tag) (obj)));
            }
            dynamicalbumdao = (DynamicAlbumDao)ThorGalleryApplication.getBean(Keys.DYNAMIC_ALBUM_DAO);
            if (undo)
            {
                dynamicalbumdao.addToDynamicAlbum(((Tag) (obj)).getId(), arraylist);
            } else
            {
                dynamicalbumdao.deleteFromDynamicAlbum(((Tag) (obj)).getId(), arraylist);
            }
            obj = AlbumPageTracker.getInstance();
            i = ((AlbumPageTracker) (obj)).getTotalItems();
            if (undo)
            {
                i = mediaItems.size() + i;
            } else
            {
                i -= mediaItems.size();
            }
            ((AlbumPageTracker) (obj)).setTotalItems(i);
            if (deleteFromCloud)
            {
                mediaitemdao.deleteCloudFields(mediaItems, true);
                return;
            }
        }
    }

    protected void recordOperationMetric(boolean flag, int i)
    {
        AlbumsMetricsHelper.MetricsEvent metricsevent;
        int j;
        if (undo)
        {
            if (flag)
            {
                metricsevent = AlbumsMetricsHelper.MetricsEvent.RemovePhotosUndo;
            } else
            {
                metricsevent = AlbumsMetricsHelper.MetricsEvent.RemovePhotosUndoError;
            }
        } else
        if (flag)
        {
            metricsevent = AlbumsMetricsHelper.MetricsEvent.RemovePhotos;
        } else
        {
            metricsevent = AlbumsMetricsHelper.MetricsEvent.RemovePhotosError;
        }
        for (j = 0; j < i; j++)
        {
            profiler.trackEvent(metricsevent, AlbumsMetricsHelper.createMetricsExtra(metricsevent.name(), null, null));
        }

    }



}
