// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.os.AsyncTask;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.model.ListChildrenRequest;
import com.amazon.clouddrive.model.ListChildrenResponse;
import com.amazon.clouddrive.model.Node;
import com.amazon.gallery.foundation.utils.IdUtils;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.foundation.utils.messaging.GlobalMessagingBus;
import com.amazon.gallery.foundation.utils.messaging.ToggleContentObserverEvent;
import com.amazon.gallery.framework.data.dao.DynamicAlbumDao;
import com.amazon.gallery.framework.data.dao.MediaItemSortType;
import com.amazon.gallery.framework.data.dao.SortTypeDao;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.tag.LocalTagDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.cds.CDSUtil;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.gallery.thor.albums:
//            AlbumPageTracker

public class ListChildrenTask extends AsyncTask
{

    private static final String TAG = com/amazon/gallery/thor/albums/ListChildrenTask.getName();
    private ObjectID albumId;
    private final CloudDriveServiceClientManager cloudDriveServiceClientManager;
    private int offset;
    private MediaItemSortType sortType;
    private Tag tag;
    private final AlbumPageTracker tracker;

    public ListChildrenTask(ObjectID objectid)
    {
        offset = 0;
        albumId = objectid;
        cloudDriveServiceClientManager = (CloudDriveServiceClientManager)ThorGalleryApplication.getBean(Keys.CLOUD_DRIVE_SERVICE_CLIENT_MANAGER);
        tracker = AlbumPageTracker.getInstance();
    }

    public ListChildrenTask(Tag tag1)
    {
        offset = 0;
        tag = tag1;
        cloudDriveServiceClientManager = (CloudDriveServiceClientManager)ThorGalleryApplication.getBean(Keys.CLOUD_DRIVE_SERVICE_CLIENT_MANAGER);
        tracker = AlbumPageTracker.getInstance();
    }

    public static void executeWithOffset(ObjectID objectid, int i)
    {
        MediaItemSortType mediaitemsorttype = ((SortTypeDao)ThorGalleryApplication.getBean(Keys.SORT_PREFERENCE_DAO)).getSortTypeById(objectid.toString());
        objectid = new ListChildrenTask(objectid);
        objectid.setOffset(i);
        objectid.setSortType(mediaitemsorttype);
        objectid.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    public static void executeWithOffset(Tag tag1, int i)
    {
        MediaItemSortType mediaitemsorttype = ((SortTypeDao)ThorGalleryApplication.getBean(Keys.SORT_PREFERENCE_DAO)).getSortTypeById(tag1.getObjectId().toString());
        tag1 = new ListChildrenTask(tag1);
        tag1.setOffset(i);
        tag1.setSortType(mediaitemsorttype);
        tag1.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
    }

    protected volatile Object doInBackground(Object aobj[])
    {
        return doInBackground((Void[])aobj);
    }

    protected List doInBackground(Void avoid[])
    {
        if (tag == null)
        {
            tag = ((LocalTagDao)ThorGalleryApplication.getBean(Keys.LOCAL_TAG_DAO)).getTagById(albumId);
        }
        if (tag == null)
        {
            GLogger.e(TAG, "Cannot run ListChildrenTask for album - tag not found in TagDao", new Object[0]);
            return null;
        }
        GLogger.d(TAG, (new StringBuilder()).append("ListChildrenTask running for album ").append(tag.getLabel()).append(" with offset: ").append(offset).toString(), new Object[0]);
        Object obj = IdUtils.objectIdToNodeId(tag.getObjectId().getMostSignificantBits(), tag.getObjectId().getLeastSignificantBits());
        DynamicAlbumDao dynamicalbumdao = (DynamicAlbumDao)ThorGalleryApplication.getBean(Keys.DYNAMIC_ALBUM_DAO);
        if (offset == 0)
        {
            tracker.reset();
        }
        ArrayList arraylist;
        if (sortType == MediaItemSortType.TIME_STAMP_ASC)
        {
            avoid = "[\"contentProperties.contentDate ASC\"]";
        } else
        {
            avoid = "[\"contentProperties.contentDate DESC\"]";
        }
        obj = new ListChildrenRequest(((String) (obj)));
        ((ListChildrenRequest) (obj)).setSort(avoid);
        ((ListChildrenRequest) (obj)).setOffset(Integer.valueOf(offset));
        try
        {
            obj = cloudDriveServiceClientManager.getForegroundCdsClient().listChildren(((ListChildrenRequest) (obj)));
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            GLogger.ex(TAG, "Error calling listChildren", avoid);
            return null;
        }
        // Misplaced declaration of an exception variable
        catch (Void avoid[])
        {
            GLogger.d(TAG, "Error calling listChildren - interrupted", new Object[0]);
            return null;
        }
        arraylist = new ArrayList(((ListChildrenResponse) (obj)).getData().size());
        avoid = (MediaItemDao)ThorGalleryApplication.getBean(Keys.MEDIA_ITEM_DAO);
        for (Iterator iterator = ((ListChildrenResponse) (obj)).getData().iterator(); iterator.hasNext();)
        {
            String s = ((Node)iterator.next()).getId();
            long l = avoid.getItemIdByObjectID(CDSUtil.getObjectId(s)).longValue();
            if (l != 0L)
            {
                arraylist.add(Long.valueOf(l));
            } else
            {
                GLogger.e(TAG, (new StringBuilder()).append("MediaItemDao returned id 0 for child in ListChildren response, node id: ").append(s).toString(), new Object[0]);
            }
        }

        if ((long)(offset + 200) < ((ListChildrenResponse) (obj)).getCount())
        {
            if (offset == 0)
            {
                avoid = com.amazon.gallery.framework.data.dao.DynamicAlbumDao.CacheStatus.NORMAL;
            } else
            {
                avoid = com.amazon.gallery.framework.data.dao.DynamicAlbumDao.CacheStatus.FILLING;
            }
            dynamicalbumdao.insert(tag.getId(), arraylist, avoid);
        } else
        {
            if (offset == 0)
            {
                avoid = com.amazon.gallery.framework.data.dao.DynamicAlbumDao.CacheStatus.NORMAL;
            } else
            {
                avoid = com.amazon.gallery.framework.data.dao.DynamicAlbumDao.CacheStatus.FULL;
            }
            dynamicalbumdao.insert(tag.getId(), arraylist, avoid);
        }
        tracker.setCurrentItems(offset + 200);
        tracker.setTotalItems((int)((ListChildrenResponse) (obj)).getCount());
        return arraylist;
    }

    protected volatile void onPostExecute(Object obj)
    {
        onPostExecute((List)obj);
    }

    protected void onPostExecute(List list)
    {
        tracker.setLoading(false);
        GlobalMessagingBus.post(new ToggleContentObserverEvent(true));
    }

    protected void onPreExecute()
    {
        tracker.setLoading(true);
        GlobalMessagingBus.post(new ToggleContentObserverEvent(false));
    }

    public void setOffset(int i)
    {
        offset = i;
    }

    public void setSortType(MediaItemSortType mediaitemsorttype)
    {
        sortType = mediaitemsorttype;
    }

}
