// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.migration;

import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.os.RemoteException;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.thor.cds.CDSUtil;
import java.io.File;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.migration:
//            MigrationPolicy

public class MediaSizeMigration extends MigrationPolicy
{

    private static final String LOCAL_PATH_PROJECTION[] = {
        "_id", "local_path"
    };
    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/migration/MediaSizeMigration.getName();
    private final Context context;

    public MediaSizeMigration(int i, Context context1)
    {
        super(i);
        context = context1;
    }

    public void doMigration()
    {
        Object obj;
        Object obj1;
        ContentProviderClient contentproviderclient;
        contentproviderclient = context.getContentResolver().acquireContentProviderClient(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.MediaItem.CONTENT_URI);
        obj1 = null;
        obj = null;
        Object obj2 = contentproviderclient.query(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.MediaItem.CONTENT_URI, LOCAL_PATH_PROJECTION, "local_path IS NOT NULL AND file_size = 0", null, null);
_L2:
        obj = obj2;
        obj1 = obj2;
        if (!((Cursor) (obj2)).moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj = obj2;
        obj1 = obj2;
        int i = ((Cursor) (obj2)).getInt(((Cursor) (obj2)).getColumnIndex("_id"));
        obj = obj2;
        obj1 = obj2;
        long l = (new File(((Cursor) (obj2)).getString(((Cursor) (obj2)).getColumnIndex("local_path")))).length();
        obj = obj2;
        obj1 = obj2;
        ContentValues contentvalues = new ContentValues();
        obj = obj2;
        obj1 = obj2;
        contentvalues.put("file_size", Long.valueOf(l));
        obj = obj2;
        obj1 = obj2;
        contentproviderclient.update(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.MediaItem.CONTENT_URI, contentvalues, "id = ?", new String[] {
            String.valueOf(i)
        });
        if (true) goto _L2; else goto _L1
        obj2;
        obj1 = obj;
        GLogger.ex(TAG, "Exception running MediaSizeMigration", ((Throwable) (obj2)));
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        if (contentproviderclient != null)
        {
            contentproviderclient.release();
        }
_L4:
        return;
_L1:
        if (obj2 != null)
        {
            ((Cursor) (obj2)).close();
        }
        if (contentproviderclient == null) goto _L4; else goto _L3
_L3:
        contentproviderclient.release();
        return;
        Exception exception;
        exception;
        if (obj1 != null)
        {
            ((Cursor) (obj1)).close();
        }
        if (contentproviderclient != null)
        {
            contentproviderclient.release();
        }
        throw exception;
    }

    public boolean needsMigration()
    {
        Cursor cursor;
        long l1;
        cursor = null;
        l1 = 0L;
        Cursor cursor1 = context.getContentResolver().query(com.amazon.gallery.framework.kindle.provider.GalleryInternalContentProvider.MediaItem.CONTENT_URI, new String[] {
            "COUNT(*) AS count"
        }, "local_path IS NOT NULL AND file_size = 0", null, null);
        long l;
        l = l1;
        if (cursor1 == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        l = l1;
        cursor = cursor1;
        if (!cursor1.moveToNext())
        {
            break MISSING_BLOCK_LABEL_63;
        }
        cursor = cursor1;
        l = cursor1.getLong(0);
        CDSUtil.closeCursorQuietly(cursor1);
        Exception exception;
        return l > 0L;
        exception;
        CDSUtil.closeCursorQuietly(cursor);
        throw exception;
    }

}
