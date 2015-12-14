// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.extended.model.BulkAddRemoveChildRequest;
import com.amazon.clouddrive.model.AddChildToParentRequest;
import com.amazon.gallery.foundation.metrics.ComponentProfiler;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.DynamicAlbumDao;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.util.IntentUtil;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.cds.CDSUtil;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AlbumOperation, AlbumPageTracker, AlbumsMetricsHelper

public class AddToAlbumTask extends AlbumOperation
{

    private static final String TAG = com/amazon/gallery/thor/albums/AddToAlbumTask.getName();
    private Tag album;
    private List childIds;
    protected String parentId;

    public AddToAlbumTask(Activity activity, List list, String s, ComponentProfiler componentprofiler)
    {
        super(activity, componentprofiler);
        childIds = list;
        parentId = s;
    }

    protected boolean doInBackground()
    {
        Iterator iterator;
        if (promptIfOffline())
        {
            return false;
        }
        iterator = partitionIds(childIds).iterator();
_L7:
        if (!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        List list = (List)iterator.next();
        if (list.size() != 1) goto _L4; else goto _L3
_L3:
        AddChildToParentRequest addchildtoparentrequest = new AddChildToParentRequest(parentId, (String)list.get(0));
        cdsClientManager.getForegroundCdsClient().addChildToParent(addchildtoparentrequest);
_L5:
        recordMetrics(true, list.size());
        continue; /* Loop/switch isn't completed */
_L4:
        try
        {
            BulkAddRemoveChildRequest bulkaddremovechildrequest = new BulkAddRemoveChildRequest(parentId, list, "add");
            cdsClientManager.getForegroundCdsClient().bulkAddRemoveChild(bulkaddremovechildrequest);
        }
        catch (CloudDriveException clouddriveexception)
        {
            GLogger.ex(TAG, "Error adding media to album", clouddriveexception);
            recordMetrics(false, list.size());
            return false;
        }
        catch (InterruptedException interruptedexception)
        {
            GLogger.d(TAG, "Error adding media to album - interrupted", new Object[0]);
            recordMetrics(false, list.size());
            return false;
        }
        if (true) goto _L5; else goto _L2
_L2:
        album = ((TagDao)ThorGalleryApplication.getBean(Keys.TAG_DAO)).getTagById(CDSUtil.getObjectId(parentId));
        return true;
        if (true) goto _L7; else goto _L6
_L6:
    }

    protected android.view.View.OnClickListener getAction()
    {
        return new android.view.View.OnClickListener() {

            final AddToAlbumTask this$0;

            public void onClick(View view)
            {
                navigateToAlbum(parentId);
            }

            
            {
                this$0 = AddToAlbumTask.this;
                super();
            }
        };
    }

    protected int getProgressMessage()
    {
        return 0x7f0e0015;
    }

    protected void onPostExecute(Boolean boolean1)
    {
        super.onPostExecute(boolean1);
        recordOperationDuration(AlbumsMetricsHelper.MetricsEvent.AddPhotosTime);
        Activity activity = getActivity();
        if (activity != null && album != null && boolean1.booleanValue())
        {
            boolean1 = IntentUtil.getAlbumContentsIntent(activity, album);
            boolean1.putExtra("fromAddToAlbumAction", true);
            boolean1.putExtra("countAddedToAlbum", childIds.size());
            activity.startActivity(boolean1);
        }
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((Boolean)obj);
    }

    protected void performLocalOperation()
    {
        Object obj1 = null;
        MediaItemDao mediaitemdao = (MediaItemDao)ThorGalleryApplication.getBean(Keys.MEDIA_ITEM_DAO);
        TagDao tagdao = (TagDao)ThorGalleryApplication.getBean(Keys.TAG_DAO);
        Tag tag = tagdao.getTagById(CDSUtil.getObjectId(parentId));
        ArrayList arraylist = new ArrayList(childIds.size());
        ArrayList arraylist1 = new ArrayList(arraylist.size());
        for (Iterator iterator = childIds.iterator(); iterator.hasNext();)
        {
            com.amazon.gallery.framework.model.ObjectID objectid = CDSUtil.getObjectId((String)iterator.next());
            Object obj = obj1;
            if (obj1 == null)
            {
                obj = objectid;
            }
            obj1 = mediaitemdao.getItemById(objectid);
            arraylist1.add(obj1);
            arraylist.add(Long.valueOf(((MediaItem) (obj1)).getId()));
            obj1 = obj;
        }

        mediaitemdao.addTagMemberships(arraylist1, tag);
        if (tag.getCoverId() == null && obj1 != null)
        {
            tag.setCoverId(((com.amazon.gallery.framework.model.ObjectID) (obj1)));
            tagdao.save(tag, true);
        }
        ((DynamicAlbumDao)ThorGalleryApplication.getBean(Keys.DYNAMIC_ALBUM_DAO)).addToDynamicAlbum(tag.getId(), arraylist);
        AlbumPageTracker albumpagetracker = AlbumPageTracker.getInstance();
        int i = albumpagetracker.getTotalItems();
        if (undo)
        {
            i -= arraylist.size();
        } else
        {
            i = arraylist.size() + i;
        }
        albumpagetracker.setTotalItems(i);
    }

    protected void recordOperationMetric(boolean flag, int i)
    {
        AlbumsMetricsHelper.MetricsEvent metricsevent;
        String s;
        if (flag)
        {
            metricsevent = AlbumsMetricsHelper.MetricsEvent.AddPhotos;
        } else
        {
            metricsevent = AlbumsMetricsHelper.MetricsEvent.AddPhotosError;
        }
        s = AlbumsMetricsHelper.getPageName(getActivity());
        for (int j = 0; j < i; j++)
        {
            profiler.trackEvent(metricsevent, AlbumsMetricsHelper.createMetricsExtra(metricsevent.name(), null, s));
        }

    }

}
