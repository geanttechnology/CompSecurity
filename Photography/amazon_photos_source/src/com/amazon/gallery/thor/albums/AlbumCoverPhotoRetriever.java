// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.thor.albums;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.RemoteException;
import com.amazon.clouddrive.exceptions.CloudDriveException;
import com.amazon.clouddrive.extended.model.ListNodesExtendedResponse;
import com.amazon.clouddrive.model.ListNodesRequest;
import com.amazon.gallery.foundation.utils.IdUtils;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.SortOrder;
import com.amazon.gallery.framework.data.dao.sqlite.SQLiteDaoUtil;
import com.amazon.gallery.framework.data.dao.tag.TagDao;
import com.amazon.gallery.framework.kindle.Keys;
import com.amazon.gallery.framework.kindle.auth.AuthenticationManager;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.framework.model.tags.TagType;
import com.amazon.gallery.thor.app.ThorGalleryApplication;
import com.amazon.gallery.thor.cds.CDSUtil;
import com.amazon.gallery.thor.cds.CloudDriveServiceClientManager;
import com.amazon.mixtape.service.MixtapeCloudDriveServiceClient;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class AlbumCoverPhotoRetriever
{

    private static final String PROJECTION[] = {
        "_id", "event_id", "node_id", "cover_id"
    };
    private static final String TAG = com/amazon/gallery/thor/albums/AlbumCoverPhotoRetriever.getName();
    private final AuthenticationManager authenticationManager;
    protected Context context;
    private final MixtapeCloudDriveServiceClient mixtapeCdsClient;

    public AlbumCoverPhotoRetriever(Context context1)
    {
        context = context1.getApplicationContext();
        authenticationManager = (AuthenticationManager)ThorGalleryApplication.getBean(Keys.AUTHENTICATING_MANAGER);
        mixtapeCdsClient = ((CloudDriveServiceClientManager)ThorGalleryApplication.getBean(Keys.CLOUD_DRIVE_SERVICE_CLIENT_MANAGER)).getBackgroundCdsClient();
    }

    private List getExistingVisualCollections()
    {
        Object obj;
        Object obj1;
        ContentProviderClient contentproviderclient;
        ArrayList arraylist;
        TagDao tagdao;
        contentproviderclient = context.getContentResolver().acquireContentProviderClient(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.Tag.CONTENT_URI);
        arraylist = new ArrayList();
        obj1 = null;
        obj = null;
        tagdao = (TagDao)ThorGalleryApplication.getBean(Keys.TAG_DAO);
        Object obj2 = contentproviderclient.query(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.Tag.CONTENT_URI, null, "type=?", new String[] {
            String.valueOf(TagType.ALBUM.ordinal())
        }, null);
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        obj = obj2;
        obj1 = obj2;
        boolean flag = ((Cursor) (obj2)).moveToFirst();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
        }
        contentproviderclient.release();
        return null;
_L2:
        obj = obj2;
        obj1 = obj2;
        if (((Cursor) (obj2)).isAfterLast())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj2;
        obj1 = obj2;
        arraylist.add(SQLiteDaoUtil.itemFromCursor(((Cursor) (obj2)), tagdao));
        obj = obj2;
        obj1 = obj2;
        ((Cursor) (obj2)).moveToNext();
        if (true) goto _L2; else goto _L1
        obj2;
        obj1 = obj;
        GLogger.ex(TAG, "Error while querying for visual collections", ((Throwable) (obj2)));
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        contentproviderclient.release();
        return null;
_L1:
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
        }
        contentproviderclient.release();
        return arraylist;
        Exception exception;
        exception;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        contentproviderclient.release();
        throw exception;
    }

    private void persistVisualCollectionsFromCDS(int i)
    {
        Object obj;
        obj = new ListNodesRequest();
        ((ListNodesRequest) (obj)).setFilters("kind:VISUAL_COLLECTION");
        ((ListNodesRequest) (obj)).setOffset(Integer.valueOf(i));
        obj = (ListNodesExtendedResponse)mixtapeCdsClient.listNodesPersistAsync(((ListNodesRequest) (obj)), null).get();
        if ((long)(((ListNodesExtendedResponse) (obj)).getData().size() + i) < ((ListNodesExtendedResponse) (obj)).getCount())
        {
            persistVisualCollectionsFromCDS(((ListNodesExtendedResponse) (obj)).getData().size() + i);
        }
        return;
        Object obj1;
        obj1;
_L2:
        GLogger.ex(TAG, "Error performing listNodes call to fetch cover photos from CDS", ((Throwable) (obj1)));
        return;
        obj1;
        continue; /* Loop/switch isn't completed */
        obj1;
        if (true) goto _L2; else goto _L1
_L1:
    }

    private void updateCoverPhotosForVisualCollections(List list)
    {
        ContentProviderClient contentproviderclient = context.getContentResolver().acquireContentProviderClient(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.Tag.CONTENT_URI);
        try
        {
            ContentValues contentvalues = new ContentValues();
            for (list = list.iterator(); list.hasNext(); contentvalues.clear())
            {
                Tag tag = (Tag)list.next();
                contentvalues.put("cover_id_high", Long.valueOf(tag.getCoverId().getMostSignificantBits()));
                contentvalues.put("cover_id_low", Long.valueOf(tag.getCoverId().getLeastSignificantBits()));
                contentvalues.put("custom_cover_id_high", Long.valueOf(tag.getCustomCoverId().getMostSignificantBits()));
                contentvalues.put("custom_cover_id_low", Long.valueOf(tag.getCustomCoverId().getLeastSignificantBits()));
                contentproviderclient.update(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.Tag.CONTENT_URI, contentvalues, "id=?", new String[] {
                    String.valueOf(tag.getId())
                });
            }

            break MISSING_BLOCK_LABEL_181;
        }
        // Misplaced declaration of an exception variable
        catch (List list) { }
        finally
        {
            contentproviderclient.release();
            throw list;
        }
        GLogger.ex(TAG, "Error while persisting cover photos for visual collections", list);
        contentproviderclient.release();
        return;
        contentproviderclient.release();
        return;
    }

    public void fetchAllAndPersist()
    {
        if (authenticationManager.hasActiveAccount()) goto _L2; else goto _L1
_L1:
        Object obj;
        return;
_L2:
        if ((obj = getExistingVisualCollections()) == null || ((List) (obj)).isEmpty()) goto _L1; else goto _L3
_L3:
        Object obj1;
        Object obj2;
        ArrayList arraylist;
        HashMap hashmap;
        ContentProviderClient contentproviderclient;
        arraylist = new ArrayList(((List) (obj)).size());
        hashmap = new HashMap(((List) (obj)).size());
        Tag tag;
        ObjectID objectid;
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext(); hashmap.put(IdUtils.objectIdToNodeId(objectid.getMostSignificantBits(), objectid.getLeastSignificantBits()), tag))
        {
            tag = (Tag)((Iterator) (obj)).next();
            objectid = tag.getObjectId();
        }

        obj2 = com.amazon.mixtape.provider.CloudNodesContract.NodeCoverPhotos.getContentUri(context.getResources().getString(0x7f0e02fb), authenticationManager.getAccountId());
        contentproviderclient = context.getContentResolver().acquireContentProviderClient(((android.net.Uri) (obj2)));
        obj1 = null;
        obj = null;
        obj2 = contentproviderclient.query(((android.net.Uri) (obj2)), PROJECTION, null, null, (new SortOrder("event_id", com.amazon.gallery.framework.data.dao.SortOrder.Order.DESC, "_id", com.amazon.gallery.framework.data.dao.SortOrder.Order.ASC)).getOrderByString());
        if (obj2 == null)
        {
            break MISSING_BLOCK_LABEL_213;
        }
        obj = obj2;
        obj1 = obj2;
        boolean flag = ((Cursor) (obj2)).moveToFirst();
        if (flag)
        {
            break MISSING_BLOCK_LABEL_230;
        }
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
        }
        contentproviderclient.release();
        return;
        obj = obj2;
        obj1 = obj2;
        int i = ((Cursor) (obj2)).getColumnIndex("node_id");
        obj = obj2;
        obj1 = obj2;
        int j = ((Cursor) (obj2)).getColumnIndex("cover_id");
_L5:
        obj = obj2;
        obj1 = obj2;
        if (((Cursor) (obj2)).isAfterLast())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj2;
        obj1 = obj2;
        String s = ((Cursor) (obj2)).getString(i);
        obj = obj2;
        obj1 = obj2;
        Tag tag1 = (Tag)hashmap.get(s);
        if (tag1 == null)
        {
            break MISSING_BLOCK_LABEL_425;
        }
        obj = obj2;
        obj1 = obj2;
        Object obj3 = ((Cursor) (obj2)).getString(j);
        if (obj3 == null)
        {
            break MISSING_BLOCK_LABEL_425;
        }
        obj = obj2;
        obj1 = obj2;
        obj3 = CDSUtil.getObjectId(((String) (obj3)));
        obj = obj2;
        obj1 = obj2;
        if (tag1.getCoverId() == null)
        {
            break MISSING_BLOCK_LABEL_371;
        }
        obj = obj2;
        obj1 = obj2;
        if (((ObjectID) (obj3)).equals(tag1.getCoverId()))
        {
            break MISSING_BLOCK_LABEL_425;
        }
        obj = obj2;
        obj1 = obj2;
        tag1.setCoverId(((ObjectID) (obj3)));
        obj = obj2;
        obj1 = obj2;
        tag1.setCustomCoverId(((ObjectID) (obj3)));
        obj = obj2;
        obj1 = obj2;
        arraylist.add(tag1);
        obj = obj2;
        obj1 = obj2;
        hashmap.remove(s);
        obj = obj2;
        obj1 = obj2;
        ((Cursor) (obj2)).moveToNext();
        if (true) goto _L5; else goto _L4
        obj2;
        obj1 = obj;
        GLogger.ex(TAG, "Error while querying content provider client", ((Throwable) (obj2)));
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        contentproviderclient.release();
        return;
_L4:
        obj = obj2;
        obj1 = obj2;
        if (arraylist.isEmpty())
        {
            break MISSING_BLOCK_LABEL_493;
        }
        obj = obj2;
        obj1 = obj2;
        updateCoverPhotosForVisualCollections(arraylist);
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
        }
        contentproviderclient.release();
        return;
        Exception exception;
        exception;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        contentproviderclient.release();
        throw exception;
    }

    public void fetchAllFromCDSAndPersist()
    {
        if (!authenticationManager.hasActiveAccount())
        {
            return;
        } else
        {
            persistVisualCollectionsFromCDS(0);
            fetchAllAndPersist();
            return;
        }
    }

    public ObjectID fetchForAlbum(ObjectID objectid)
    {
        Cursor cursor;
        Cursor cursor1;
        ObjectID objectid1;
        Object obj;
        ContentProviderClient contentproviderclient;
        Object obj1;
        String s;
        if (!authenticationManager.hasActiveAccount())
        {
            return null;
        }
        obj1 = com.amazon.mixtape.provider.CloudNodesContract.NodeCoverPhotos.getContentUri(context.getResources().getString(0x7f0e02fb), authenticationManager.getAccountId());
        contentproviderclient = context.getContentResolver().acquireContentProviderClient(((android.net.Uri) (obj1)));
        objectid1 = null;
        cursor1 = null;
        obj = null;
        s = IdUtils.objectIdToNodeId(objectid.getMostSignificantBits(), objectid.getLeastSignificantBits());
        cursor = cursor1;
        objectid = objectid1;
        String as[] = PROJECTION;
        cursor = cursor1;
        objectid = objectid1;
        String s1 = (new SortOrder("_id", com.amazon.gallery.framework.data.dao.SortOrder.Order.ASC)).getOrderByString();
        cursor = cursor1;
        objectid = objectid1;
        cursor1 = contentproviderclient.query(((android.net.Uri) (obj1)), as, "node_id =? AND event_id IN (SELECT event_id FROM cloud_nodes WHERE node_id=?)", new String[] {
            s, s
        }, s1);
        objectid1 = obj;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        objectid1 = obj;
        cursor = cursor1;
        objectid = cursor1;
        if (!cursor1.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_207;
        }
        cursor = cursor1;
        objectid = cursor1;
        obj1 = cursor1.getString(cursor1.getColumnIndex("cover_id"));
        objectid1 = obj;
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_207;
        }
        cursor = cursor1;
        objectid = cursor1;
        objectid1 = CDSUtil.getObjectId(((String) (obj1)));
        if (cursor1 != null)
        {
            cursor1.close();
        }
        contentproviderclient.release();
        return objectid1;
        RemoteException remoteexception;
        remoteexception;
        objectid = cursor;
        GLogger.ex(TAG, "Error while querying content provider client", remoteexception);
        if (cursor != null)
        {
            cursor.close();
        }
        contentproviderclient.release();
        return null;
        Exception exception;
        exception;
        if (objectid != null)
        {
            objectid.close();
        }
        contentproviderclient.release();
        throw exception;
    }

}
