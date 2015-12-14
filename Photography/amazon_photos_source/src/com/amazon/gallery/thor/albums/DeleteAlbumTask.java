// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Activity;
import android.os.AsyncTask;
import android.view.View;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.extended.model.BulkTrashRestoreNodesRequest;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.IdUtils;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AlbumOperation, AlbumsMetricsHelper

public class DeleteAlbumTask extends AlbumOperation
{

    private static final String TAG = com/amazon/gallery/thor/albums/DeleteAlbumTask.getName();
    private final List tags;

    public DeleteAlbumTask(Activity activity, List list, ComponentProfiler componentprofiler)
    {
        super(activity, componentprofiler);
        tags = list;
    }

    protected boolean doInBackground()
    {
        if (promptIfOffline())
        {
            return false;
        }
        ArrayList arraylist = new ArrayList();
        ObjectID objectid;
        for (Iterator iterator = tags.iterator(); iterator.hasNext(); arraylist.add(IdUtils.objectIdToNodeId(objectid.getMostSignificantBits(), objectid.getLeastSignificantBits())))
        {
            objectid = ((Tag)iterator.next()).getObjectId();
        }

        Iterator iterator1 = partitionIds(arraylist).iterator();
        do
        {
            if (!iterator1.hasNext())
            {
                break;
            }
            List list = (List)iterator1.next();
            Object obj;
            if (undo)
            {
                obj = "remove";
            } else
            {
                obj = "add";
            }
            obj = new BulkTrashRestoreNodesRequest(list, ((String) (obj)));
            ((BulkTrashRestoreNodesRequest) (obj)).setRecurse(Boolean.valueOf(false));
            try
            {
                cdsClientManager.getForegroundCdsClient().bulkTrashRestoreNodes(((BulkTrashRestoreNodesRequest) (obj)));
            }
            catch (CloudDriveException clouddriveexception)
            {
                GLogger.ex(TAG, "Error deleting album", clouddriveexception);
                recordMetrics(false, list.size());
                return false;
            }
            catch (InterruptedException interruptedexception)
            {
                GLogger.d(TAG, "Error deleting album - interrupted", new Object[0]);
                recordMetrics(false, list.size());
                return false;
            }
            recordMetrics(true, list.size());
        } while (true);
        return true;
    }

    protected android.view.View.OnClickListener getAction()
    {
        return new android.view.View.OnClickListener() {

            final DeleteAlbumTask this$0;

            public void onClick(View view)
            {
                view = new DeleteAlbumTask(getActivity(), tags, profiler);
                view.setUndo();
                view.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }

            
            {
                this$0 = DeleteAlbumTask.this;
                super();
            }
        };
    }

    protected int getProgressMessage()
    {
        if (undo)
        {
            return 0x7f0e0033;
        }
        return tags.size() != 1 ? 0x7f0e0020 : 0x7f0e0021;
    }

    protected void onPostExecute(Boolean boolean1)
    {
        Activity activity;
label0:
        {
            super.onPostExecute(boolean1);
            recordOperationDuration(AlbumsMetricsHelper.MetricsEvent.DeletePhotoAlbumTime);
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
            showSnackbar(activity.getString(0x7f0e0023));
            return;
        }
        if (tags.size() == 1)
        {
            showSnackbarWithAction(activity.getString(0x7f0e0025), getAction(), activity.getString(0x7f0e01fc));
            return;
        } else
        {
            showSnackbarWithAction(activity.getString(0x7f0e0024), getAction(), activity.getString(0x7f0e01fc));
            return;
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Boolean)obj);
    }

    protected void performLocalOperation()
    {
        TagDao tagdao = (TagDao)ThorGalleryApplication.getBean(Keys.TAG_DAO);
        if (undo)
        {
            tagdao.bulkInsert(tags, true);
            return;
        } else
        {
            tagdao.delete(tags, true);
            return;
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
                metricsevent = AlbumsMetricsHelper.MetricsEvent.DeletePhotoAlbumUndo;
            } else
            {
                metricsevent = AlbumsMetricsHelper.MetricsEvent.DeletePhotoAlbumUndoError;
            }
        } else
        if (flag)
        {
            metricsevent = AlbumsMetricsHelper.MetricsEvent.DeletePhotoAlbum;
        } else
        {
            metricsevent = AlbumsMetricsHelper.MetricsEvent.DeletePhotoAlbumError;
        }
        for (j = 0; j < i; j++)
        {
            profiler.trackEvent(metricsevent, AlbumsMetricsHelper.createMetricsExtra(metricsevent.name(), null, null));
        }

    }


}
