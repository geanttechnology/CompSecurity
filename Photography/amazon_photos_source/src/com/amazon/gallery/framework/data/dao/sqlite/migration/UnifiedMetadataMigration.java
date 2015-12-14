// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.migration;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.mediaitem.MediaItemDao;
import com.amazon.gallery.framework.model.media.MediaItem;
import com.amazon.gallery.framework.model.media.MediaItemCollection;
import com.amazon.gallery.thor.cds.CDSUtil;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.migration:
//            MigrationPolicy

public class UnifiedMetadataMigration extends MigrationPolicy
{

    private static final Uri IMAGE_MEDIA_STORE_URI;
    public static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/migration/UnifiedMetadataMigration.getName();
    private final Context mContext;
    private final SQLiteDatabase mDb;
    private final MediaItemDao mMediaItemDao;

    public UnifiedMetadataMigration(int i, Context context, MediaItemDao mediaitemdao, SQLiteDatabase sqlitedatabase)
    {
        super(i);
        mContext = context;
        mMediaItemDao = mediaitemdao;
        mDb = sqlitedatabase;
    }

    private MediaItem updateMetadata(Cursor cursor)
    {
        String s;
        long l;
        try
        {
            s = cursor.getString(cursor.getColumnIndexOrThrow("_data"));
            l = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            GLogger.e(TAG, "Failed to find index for item at cursor position %d", new Object[] {
                Integer.valueOf(cursor.getPosition())
            });
            return null;
        }
        cursor = mMediaItemDao.getItemsByLocalPath(s);
        if (cursor.getMediaItems().isEmpty())
        {
            GLogger.d(TAG, "mediaItem with path %s does not exist in local DB, skipping...", new Object[] {
                s
            });
            return null;
        } else
        {
            cursor = (MediaItem)cursor.getMediaItems().get(0);
            cursor.getMetadata().put("media-store.uri", (new StringBuilder()).append(IMAGE_MEDIA_STORE_URI).append("/").append(l).toString());
            GLogger.d(TAG, "Put uri for item %s", new Object[] {
                cursor.getName()
            });
            return cursor;
        }
    }

    public void doMigration()
    {
        Object obj;
        LinkedList linkedlist;
        GLogger.i(TAG, "Executing %s", new Object[] {
            com/amazon/gallery/framework/data/dao/sqlite/migration/UnifiedMetadataMigration.getSimpleName()
        });
        linkedlist = new LinkedList();
        obj = null;
        Object obj1 = mContext.getContentResolver().query(IMAGE_MEDIA_STORE_URI, new String[] {
            "_id", "_data"
        }, null, null, null);
        obj = obj1;
        ((Cursor) (obj1)).moveToFirst();
_L2:
        obj = obj1;
        if (((Cursor) (obj1)).isAfterLast())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj1;
        MediaItem mediaitem = updateMetadata(((Cursor) (obj1)));
        if (mediaitem == null)
        {
            break MISSING_BLOCK_LABEL_106;
        }
        obj = obj1;
        linkedlist.add(mediaitem);
        obj = obj1;
        ((Cursor) (obj1)).moveToNext();
        if (true) goto _L2; else goto _L1
        obj1;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        if (!linkedlist.isEmpty())
        {
            mMediaItemDao.saveLocalFields(linkedlist, false);
        }
        throw obj1;
_L1:
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        if (!linkedlist.isEmpty())
        {
            mMediaItemDao.saveLocalFields(linkedlist, false);
        }
        return;
    }

    public boolean needsMigration()
    {
        Cursor cursor;
        long l1;
        boolean flag;
        flag = false;
        cursor = null;
        l1 = 0L;
        Cursor cursor1 = mDb.rawQuery("select count(*) from media_item a left join metadata b on a.id = b.media_item_id where a.local_path is not null and b.key is null", null);
        long l;
        l = l1;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_50;
        }
        l = l1;
        cursor = cursor1;
        if (!cursor1.moveToNext())
        {
            break MISSING_BLOCK_LABEL_50;
        }
        cursor = cursor1;
        l = cursor1.getLong(0);
        CDSUtil.closeCursorQuietly(cursor1);
        if (l > 0L)
        {
            flag = true;
        }
        return flag;
        Exception exception;
        exception;
        CDSUtil.closeCursorQuietly(cursor);
        throw exception;
    }

    static 
    {
        IMAGE_MEDIA_STORE_URI = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
    }
}
