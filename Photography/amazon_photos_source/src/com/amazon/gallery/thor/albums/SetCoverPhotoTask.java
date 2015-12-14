// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Activity;
import android.os.AsyncTask;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.model.CollectionProperties;
import com.amazon.clouddrive.model.CollectionPropertiesUpdateObject;
import com.amazon.clouddrive.model.CoverObject;
import com.amazon.clouddrive.model.UpdateCollectionPropertiesRequest;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.activity.SingleViewActivity;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.cds.CDSUtil;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AlbumOperation, RefreshCoverPhotoTask, AlbumsMetricsHelper

public class SetCoverPhotoTask extends AlbumOperation
{

    private static final String TAG = com/amazon/gallery/thor/albums/SetCoverPhotoTask.getName();
    private String coverId;
    private String parentId;

    public SetCoverPhotoTask(Activity activity, String s, String s1, ComponentProfiler componentprofiler)
    {
        super(activity, componentprofiler);
        coverId = s;
        parentId = s1;
        shouldCloseCAB = true;
    }

    protected boolean doInBackground()
    {
        Object obj;
        if (promptIfOffline())
        {
            return false;
        }
        Object obj2 = new CoverObject();
        ((CoverObject) (obj2)).setId(coverId);
        obj = new ArrayList(1);
        ((List) (obj)).add(obj2);
        obj2 = new CollectionProperties();
        ((CollectionProperties) (obj2)).setCovers(((List) (obj)));
        obj = new CollectionPropertiesUpdateObject();
        ((CollectionPropertiesUpdateObject) (obj)).setPath("/covers");
        ((CollectionPropertiesUpdateObject) (obj)).setOp("add");
        ((CollectionPropertiesUpdateObject) (obj)).setCollectionProperties(((CollectionProperties) (obj2)));
        obj2 = new ArrayList(1);
        ((List) (obj2)).add(obj);
        obj = new UpdateCollectionPropertiesRequest();
        ((UpdateCollectionPropertiesRequest) (obj)).setId(parentId);
        ((UpdateCollectionPropertiesRequest) (obj)).setOperations(((List) (obj2)));
        cdsClientManager.getForegroundCdsClient().updateCollectionProperties(((UpdateCollectionPropertiesRequest) (obj)));
        recordMetrics(true, 1);
        return true;
        Object obj1;
        obj1;
_L2:
        recordMetrics(false, 1);
        GLogger.ex(TAG, "Error trying to set cover photo", ((Throwable) (obj1)));
        return false;
        obj1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    protected int getProgressMessage()
    {
        return 0x7f0e0031;
    }

    protected void onPostExecute(Boolean boolean1)
    {
        Activity activity;
label0:
        {
            super.onPostExecute(boolean1);
            recordOperationDuration(AlbumsMetricsHelper.MetricsEvent.SetPhotoAlbumCoverTime);
            activity = getActivity();
            if (activity != null)
            {
                (new RefreshCoverPhotoTask(activity, parentId)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                if (activity instanceof SingleViewActivity)
                {
                    ((SingleViewActivity)activity).adjustSnackbarForSoftKeyBar();
                }
                if (boolean1.booleanValue())
                {
                    break label0;
                }
                showSnackbar(activity.getString(0x7f0e0030));
            }
            return;
        }
        showSnackbar(activity.getString(0x7f0e0032));
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Boolean)obj);
    }

    protected void performLocalOperation()
    {
        TagDao tagdao = (TagDao)ThorGalleryApplication.getBean(Keys.TAG_DAO);
        Tag tag = tagdao.getTagById(CDSUtil.getObjectId(parentId));
        if (tag != null)
        {
            tag.setCoverId(CDSUtil.getObjectId(coverId));
            tagdao.save(tag, true);
            return;
        } else
        {
            GLogger.i(TAG, "Tag was null, failed to locally set cover photo", new Object[0]);
            return;
        }
    }

    protected void recordOperationMetric(boolean flag, int i)
    {
        AlbumsMetricsHelper.MetricsEvent metricsevent;
        if (flag)
        {
            metricsevent = AlbumsMetricsHelper.MetricsEvent.SetPhotoAlbumCover;
        } else
        {
            metricsevent = AlbumsMetricsHelper.MetricsEvent.SetPhotoAlbumCoverError;
        }
        profiler.trackEvent(metricsevent, AlbumsMetricsHelper.createMetricsExtra(metricsevent.name(), null, AlbumsMetricsHelper.getPageName(getActivity())));
    }

}
