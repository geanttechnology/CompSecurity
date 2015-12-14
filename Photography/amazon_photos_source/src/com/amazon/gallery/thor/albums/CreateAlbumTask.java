// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.Toast;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.model.CreateNodeRequest;
import com.amazon.clouddrive.model.CreateNodeResponse;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.DynamicAlbumDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.util.IntentUtil;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagProperty;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.cds.CDSUtil;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AlbumOperation, AlbumsMetricsHelper, AddToAlbumTask

public class CreateAlbumTask extends AlbumOperation
{

    private static final String TAG = com/amazon/gallery/thor/albums/CreateAlbumTask.getName();
    private final String createAlbumError;
    private final DynamicAlbumDao dynamicAlbumDao;
    private final List mediaItemsToAdd;
    private String name;
    private String parentId;
    private CreateNodeResponse response;

    public CreateAlbumTask(Activity activity, String s, List list, ComponentProfiler componentprofiler)
    {
        super(activity, componentprofiler);
        name = s;
        mediaItemsToAdd = list;
        dynamicAlbumDao = (DynamicAlbumDao)ThorGalleryApplication.getBean(Keys.DYNAMIC_ALBUM_DAO);
        createAlbumError = activity.getString(0x7f0e001c);
    }

    protected boolean doInBackground()
    {
        if (promptIfOffline())
        {
            return false;
        }
        try
        {
            CreateNodeRequest createnoderequest = new CreateNodeRequest(name, "VISUAL_COLLECTION");
            response = cdsClientManager.getForegroundCdsClient().createNode(createnoderequest);
            parentId = response.getId();
        }
        catch (CloudDriveException clouddriveexception)
        {
            GLogger.ex(TAG, "Error creating new album", clouddriveexception);
            recordMetrics(false, 1);
            return false;
        }
        catch (InterruptedException interruptedexception)
        {
            GLogger.d(TAG, "Error creating new album - interrupted", new Object[0]);
            recordMetrics(false, 1);
            return false;
        }
        recordMetrics(true, 1);
        if (mediaItemsToAdd != null && !mediaItemsToAdd.isEmpty() && getActivity() != null)
        {
            shouldCloseCAB = true;
            Activity activity = getActivity();
            if (activity != null)
            {
                activity.runOnUiThread(new Runnable() {

                    final CreateAlbumTask this$0;

                    public void run()
                    {
                        (new AddToAlbumTask(getActivity(), mediaItemsToAdd, response.getId(), profiler)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
                    }

            
            {
                this$0 = CreateAlbumTask.this;
                super();
            }
                });
            }
        }
        return true;
    }

    protected android.view.View.OnClickListener getAction()
    {
        return new android.view.View.OnClickListener() {

            final CreateAlbumTask this$0;

            public void onClick(View view)
            {
                navigateToAlbum(parentId);
            }

            
            {
                this$0 = CreateAlbumTask.this;
                super();
            }
        };
    }

    protected int getProgressMessage()
    {
        return 0x7f0e001b;
    }

    protected void onPostExecute(Boolean boolean1)
    {
        Activity activity;
label0:
        {
            super.onPostExecute(boolean1);
            recordOperationDuration(AlbumsMetricsHelper.MetricsEvent.CreatePhotoAlbumTime);
            activity = getActivity();
            if (activity != null)
            {
                if (mediaItemsToAdd == null || !mediaItemsToAdd.isEmpty());
                if (!boolean1.booleanValue())
                {
                    break label0;
                }
                if (mediaItemsToAdd == null || mediaItemsToAdd.isEmpty())
                {
                    boolean1 = IntentUtil.getBaseAddToAlbumIntent(activity);
                    boolean1.putExtra("TAG_NODE_ID", response.getId());
                    boolean1.putExtra("TAG_NAME", name);
                    activity.startActivity(boolean1);
                }
            }
            return;
        }
        Toast.makeText(activity, createAlbumError, 0).show();
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Boolean)obj);
    }

    protected void performLocalOperation()
    {
        Object obj = CDSUtil.getObjectId(response.getId());
        TagDao tagdao = (TagDao)ThorGalleryApplication.getBean(Keys.TAG_DAO);
        Tag tag = tagdao.create(TagType.ALBUM);
        tag.setLabel(name);
        tag.setProperty(TagProperty.CLOUD);
        tag.setSortDateMs(CDSUtil.getUnixTimestamp(response.getCreatedDate()));
        tag.setHasSortDate(true);
        tag.setValid(true);
        tag.setObjectId(((com.amazon.gallery.framework.model.ObjectID) (obj)));
        tagdao.save(tag, true);
        obj = tagdao.getTagById(((com.amazon.gallery.framework.model.ObjectID) (obj)));
        dynamicAlbumDao.insert(((Tag) (obj)).getId(), null, com.amazon.gallery.framework.data.dao.DynamicAlbumDao.CacheStatus.NORMAL);
    }

    protected void recordOperationMetric(boolean flag, int i)
    {
        AlbumsMetricsHelper.MetricsEvent metricsevent;
        if (flag)
        {
            metricsevent = AlbumsMetricsHelper.MetricsEvent.CreatePhotoAlbum;
        } else
        {
            metricsevent = AlbumsMetricsHelper.MetricsEvent.CreatePhotoAlbumError;
        }
        profiler.trackEvent(metricsevent, AlbumsMetricsHelper.createMetricsExtra(AlbumsMetricsHelper.MetricsEvent.CreatePhotoAlbum.name(), null, AlbumsMetricsHelper.getPageName(getActivity())));
    }




}
