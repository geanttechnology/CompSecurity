// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.RemoteException;
import com.amazon.gallery.foundation.utils.file.Md5Util;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.data.dao.sqlite.SQLiteDaoUtil;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemUtil;
import com.amazon.gallery.framework.model.media.SyncState;
import com.amazon.gallery.thor.settings.HidePreferenceManager;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao:
//            AbstractDeduplicater

public class Md5Deduplicater extends AbstractDeduplicater
{
    private static class Batch
    {

        public long batchFileSize;
        public final List batchList = new ArrayList();
        public int itemCount;

        public void clear()
        {
            batchList.clear();
            itemCount = 0;
            batchFileSize = 0L;
        }

        public Batch()
        {
            itemCount = 0;
            batchFileSize = 0L;
        }
    }

    public static interface DeduplicationObserver
    {

        public abstract boolean isObserverActive();

        public abstract void onDeduplicationFinished(List list);

        public abstract void onDuplicatesFound(List list, long l);

        public abstract void onUpdateProgress(long l);
    }


    private static final Uri MEDIA_ITEM_URI;
    private static final String TAG = com/amazon/gallery/framework/data/dao/Md5Deduplicater.getName();
    private final Context context;
    private String selection;

    public Md5Deduplicater(Context context1, MediaItemDao mediaitemdao)
    {
        super(mediaitemdao);
        selection = (new StringBuilder()).append("(local_path IS NOT NULL AND full_md5 IS NOT NULL AND sync_state=").append(SyncState.SYNCED.value).append(") AND (").append("duration").append(" IS NULL OR ").append("duration").append(" < ").append(0x124f80L).append(")").toString();
        context = context1;
        if (!(new HidePreferenceManager(context1)).getHiddenPreference())
        {
            selection = (new StringBuilder()).append(selection).append(" AND ").append("hidden").append(" IS 0").toString();
        }
    }

    public void getAllMd5Duplicates(DeduplicationObserver deduplicationobserver)
    {
        Cursor cursor1;
        Cursor cursor2;
        Cursor cursor3;
        Cursor cursor4;
        ContentProviderClient contentproviderclient;
        contentproviderclient = context.getContentResolver().acquireContentProviderClient(MEDIA_ITEM_URI);
        cursor2 = null;
        cursor3 = null;
        cursor4 = null;
        cursor1 = null;
        Cursor cursor = contentproviderclient.query(MEDIA_ITEM_URI, null, selection, null, "file_size DESC");
        cursor1 = cursor;
        if (cursor == null) goto _L2; else goto _L1
_L1:
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        int i = cursor.getColumnIndex("local_path");
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        int j = cursor.getColumnIndex("full_md5");
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        int k = cursor.getColumnIndex("file_size");
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        HashMap hashmap = new HashMap();
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        Object obj = new Batch();
_L6:
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        if (!cursor.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        if (!cursor.getString(j).equals(Md5Util.md5AsHex(cursor.getString(i)))) goto _L4; else goto _L3
_L3:
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        com.amazon.gallery.framework.model.ObjectID objectid = SQLiteDaoUtil.objectIdFromCursor(cursor);
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        MediaItem mediaitem = SQLiteDaoUtil.itemFromCursor(cursor, mediaItemDao);
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        hashmap.put(objectid, mediaitem);
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        ((Batch) (obj)).batchList.add(mediaitem);
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        obj.batchFileSize = ((Batch) (obj)).batchFileSize + cursor.getLong(k);
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        obj.itemCount = ((Batch) (obj)).itemCount + 1;
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        if (((Batch) (obj)).itemCount >= 3)
        {
            break MISSING_BLOCK_LABEL_387;
        }
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        if (((Batch) (obj)).batchFileSize < 0x5000000L)
        {
            break MISSING_BLOCK_LABEL_430;
        }
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        deduplicationobserver.onDuplicatesFound(((Batch) (obj)).batchList, ((Batch) (obj)).batchFileSize);
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        ((Batch) (obj)).clear();
_L15:
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        deduplicationobserver.onUpdateProgress(Math.round(100D * ((double)(cursor.getPosition() + 1) / (double)cursor.getCount())));
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        if (deduplicationobserver.isObserverActive()) goto _L6; else goto _L5
_L5:
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        if (cursor.getCount() <= 0) goto _L8; else goto _L7
_L7:
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        if (((Batch) (obj)).batchList.isEmpty()) goto _L8; else goto _L9
_L9:
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        deduplicationobserver.onUpdateProgress(Math.round(100D * ((double)(cursor.getPosition() + 1) / (double)cursor.getCount())));
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        deduplicationobserver.onDuplicatesFound(((Batch) (obj)).batchList, ((Batch) (obj)).batchFileSize);
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        ((Batch) (obj)).clear();
_L17:
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        cursor = contentproviderclient.query(MEDIA_ITEM_URI, null, selection, null, "date_created ASC");
        cursor1 = cursor;
        if (cursor == null) goto _L2; else goto _L10
_L10:
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        obj = new ArrayList();
_L14:
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        if (!cursor.moveToNext()) goto _L12; else goto _L11
_L11:
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        objectid = SQLiteDaoUtil.objectIdFromCursor(cursor);
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        if (!hashmap.containsKey(objectid)) goto _L14; else goto _L13
_L13:
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        ((List) (obj)).add(hashmap.get(objectid));
          goto _L14
        deduplicationobserver;
_L18:
        cursor2 = cursor1;
        GLogger.ex(TAG, deduplicationobserver.getMessage(), deduplicationobserver);
        if (cursor1 != null)
        {
            cursor1.close();
        }
        contentproviderclient.release();
        return;
_L4:
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        GLogger.e(TAG, "Item's localpath resulted in different Md5 than in DB.", new Object[0]);
          goto _L15
_L8:
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        if (cursor.getCount() != 0) goto _L17; else goto _L16
_L16:
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        deduplicationobserver.onDuplicatesFound(((Batch) (obj)).batchList, ((Batch) (obj)).batchFileSize);
          goto _L17
_L12:
        cursor1 = cursor;
        cursor2 = cursor;
        cursor3 = cursor;
        cursor4 = cursor;
        deduplicationobserver.onDeduplicationFinished(((List) (obj)));
        cursor1 = cursor;
_L2:
        if (cursor1 != null)
        {
            cursor1.close();
        }
        contentproviderclient.release();
        return;
        deduplicationobserver;
        if (cursor2 != null)
        {
            cursor2.close();
        }
        contentproviderclient.release();
        throw deduplicationobserver;
        deduplicationobserver;
        cursor1 = cursor3;
          goto _L18
        deduplicationobserver;
        cursor1 = cursor4;
          goto _L18
    }

    public List getCloudDuplicates(MediaItem mediaitem)
    {
        MediaItem mediaitem1;
        MediaItem mediaitem2;
        Object obj;
        MediaItem mediaitem3;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        ContentProviderClient contentproviderclient;
        ArrayList arraylist;
        arraylist = new ArrayList();
        contentproviderclient = context.getContentResolver().acquireContentProviderClient(MEDIA_ITEM_URI);
        if (!MediaItemUtil.isLocalMediaItem(mediaitem))
        {
            return arraylist;
        }
        obj2 = null;
        obj3 = null;
        obj4 = null;
        obj1 = null;
        mediaitem1 = obj1;
        mediaitem2 = obj2;
        obj = obj3;
        mediaitem3 = obj4;
        mediaitem = Md5Util.md5AsHex(mediaitem.getLocalPath());
        mediaitem1 = obj1;
        mediaitem2 = obj2;
        obj = obj3;
        mediaitem3 = obj4;
        mediaitem = contentproviderclient.query(MEDIA_ITEM_URI, null, (new StringBuilder()).append("sync_state=").append(SyncState.SYNCED.value).append("full_md5").append(" = ?").toString(), new String[] {
            mediaitem
        }, null);
        if (mediaitem == null) goto _L2; else goto _L1
_L1:
        mediaitem1 = mediaitem;
        mediaitem2 = mediaitem;
        obj = mediaitem;
        mediaitem3 = mediaitem;
        if (!mediaitem.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        mediaitem1 = mediaitem;
        mediaitem2 = mediaitem;
        obj = mediaitem;
        mediaitem3 = mediaitem;
        arraylist.add(SQLiteDaoUtil.itemFromCursor(mediaitem, mediaItemDao));
        if (true) goto _L1; else goto _L2
        obj;
        mediaitem = mediaitem1;
_L4:
        mediaitem2 = mediaitem;
        GLogger.ex(TAG, ((Exception) (obj)).getMessage(), ((Throwable) (obj)));
        if (mediaitem != null)
        {
            mediaitem.close();
        }
        contentproviderclient.release();
        return arraylist;
_L2:
        if (mediaitem != null)
        {
            mediaitem.close();
        }
        contentproviderclient.release();
        return arraylist;
        mediaitem;
        if (mediaitem2 != null)
        {
            mediaitem2.close();
        }
        contentproviderclient.release();
        throw mediaitem;
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        mediaitem = ((MediaItem) (obj));
        obj = nosuchalgorithmexception;
        continue; /* Loop/switch isn't completed */
        obj;
        mediaitem = mediaitem3;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public List getLocalDuplicates(MediaItem mediaitem)
    {
        MediaItem mediaitem1;
        MediaItem mediaitem2;
        Object obj;
        MediaItem mediaitem3;
        Object obj1;
        Object obj2;
        Object obj3;
        Object obj4;
        ContentProviderClient contentproviderclient;
        ArrayList arraylist;
        arraylist = new ArrayList();
        contentproviderclient = context.getContentResolver().acquireContentProviderClient(MEDIA_ITEM_URI);
        if (!MediaItemUtil.isCloudMediaItem(mediaitem))
        {
            return arraylist;
        }
        obj2 = null;
        obj3 = null;
        obj4 = null;
        obj1 = null;
        mediaitem1 = obj1;
        mediaitem2 = obj2;
        obj = obj3;
        mediaitem3 = obj4;
        String s = mediaitem.getFullMd5();
        mediaitem1 = obj1;
        mediaitem2 = obj2;
        obj = obj3;
        mediaitem3 = obj4;
        mediaitem = contentproviderclient.query(MEDIA_ITEM_URI, null, "local_path IS NOT NULL", null, null);
        if (mediaitem == null) goto _L2; else goto _L1
_L1:
        mediaitem1 = mediaitem;
        mediaitem2 = mediaitem;
        obj = mediaitem;
        mediaitem3 = mediaitem;
        int i = mediaitem.getColumnIndex("local_path");
_L5:
        mediaitem1 = mediaitem;
        mediaitem2 = mediaitem;
        obj = mediaitem;
        mediaitem3 = mediaitem;
        if (!mediaitem.moveToNext()) goto _L2; else goto _L3
_L3:
        mediaitem1 = mediaitem;
        mediaitem2 = mediaitem;
        obj = mediaitem;
        mediaitem3 = mediaitem;
        if (!s.equals(Md5Util.md5AsHex(mediaitem.getString(i)))) goto _L5; else goto _L4
_L4:
        mediaitem1 = mediaitem;
        mediaitem2 = mediaitem;
        obj = mediaitem;
        mediaitem3 = mediaitem;
        arraylist.add(SQLiteDaoUtil.itemFromCursor(mediaitem, mediaItemDao));
          goto _L5
        obj;
        mediaitem = mediaitem1;
_L7:
        mediaitem2 = mediaitem;
        GLogger.ex(TAG, ((Exception) (obj)).getMessage(), ((Throwable) (obj)));
        if (mediaitem != null)
        {
            mediaitem.close();
        }
        contentproviderclient.release();
        return arraylist;
_L2:
        if (mediaitem != null)
        {
            mediaitem.close();
        }
        contentproviderclient.release();
        return arraylist;
        mediaitem;
        if (mediaitem2 != null)
        {
            mediaitem2.close();
        }
        contentproviderclient.release();
        throw mediaitem;
        NoSuchAlgorithmException nosuchalgorithmexception;
        nosuchalgorithmexception;
        mediaitem = ((MediaItem) (obj));
        obj = nosuchalgorithmexception;
        continue; /* Loop/switch isn't completed */
        obj;
        mediaitem = mediaitem3;
        if (true) goto _L7; else goto _L6
_L6:
    }

    static 
    {
        MEDIA_ITEM_URI = com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.MediaItem.CONTENT_URI;
    }
}
