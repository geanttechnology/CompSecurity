// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.MediaItemSortType;
import com.amazon.gallery.framework.data.dao.SortTypeDao;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.tags.Tag;
import com.amazon.gallery.thor.cds.CDSUtil;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            DBWriteExecutor, DBReadExecutor, GalleryDBConnectionManager, ReadOnlySQLiteDatabase, 
//            ReadWriteSQLiteDatabase

public class SortTypeSqliteImpl
    implements SortTypeDao
{

    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/SortTypeSqliteImpl.getName();
    private GalleryDBConnectionManager connectionManager;

    public SortTypeSqliteImpl(GalleryDBConnectionManager gallerydbconnectionmanager)
    {
        connectionManager = gallerydbconnectionmanager;
    }

    public void deleteSortTags(final Collection tags)
    {
        (new DBWriteExecutor() {

            final SortTypeSqliteImpl this$0;
            final Collection val$tags;

            protected volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                return execute(readwritesqlitedatabase);
            }

            protected Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                for (Iterator iterator = tags.iterator(); iterator.hasNext(); readwritesqlitedatabase.delete("sort_preference", "tag_id=?", new String[] {
            ((Tag)iterator.next()).getObjectId().toString()
        })) { }
                return null;
            }

            
            {
                this$0 = SortTypeSqliteImpl.this;
                tags = collection;
                super();
            }
        }).execute(connectionManager);
    }

    protected MediaItemSortType getDefaultSortType(String s, ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        byte byte0 = -1;
        s.hashCode();
        JVM INSTR lookupswitch 3: default 40
    //                   96673: 72
    //                   112202875: 100
    //                   2059117911: 86;
           goto _L1 _L2 _L3 _L4
_L1:
        break; /* Loop/switch isn't completed */
_L3:
        break MISSING_BLOCK_LABEL_100;
_L5:
        switch (byte0)
        {
        default:
            return MediaItemSortType.TIME_STAMP_ASC;

        case 0: // '\0'
        case 1: // '\001'
        case 2: // '\002'
            return MediaItemSortType.TIME_STAMP_DESC;
        }
_L2:
        if (s.equals("all"))
        {
            byte0 = 0;
        }
          goto _L5
_L4:
        if (s.equals("camera_roll"))
        {
            byte0 = 1;
        }
          goto _L5
        if (s.equals("video"))
        {
            byte0 = 2;
        }
          goto _L5
    }

    public MediaItemSortType getSortTypeById(final String id)
    {
        return (MediaItemSortType)(new DBReadExecutor() {

            final SortTypeSqliteImpl this$0;
            final String val$id;

            protected MediaItemSortType execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                Object obj;
                obj = id;
                obj = readonlysqlitedatabase.query("sort_preference", new String[] {
                    "sort_order"
                }, "tag_id=?", new String[] {
                    obj
                }, null, null, null);
                if (!((Cursor) (obj)).moveToFirst())
                {
                    break MISSING_BLOCK_LABEL_67;
                }
                readonlysqlitedatabase = MediaItemSortType.toEnum(((Cursor) (obj)).getString(((Cursor) (obj)).getColumnIndex("sort_order")));
                CDSUtil.closeCursorQuietly(((Cursor) (obj)));
                return readonlysqlitedatabase;
                GLogger.v(SortTypeSqliteImpl.TAG, "Nothing found in DB, returning default sort order", new Object[0]);
                readonlysqlitedatabase = getDefaultSortType(id, readonlysqlitedatabase);
                CDSUtil.closeCursorQuietly(((Cursor) (obj)));
                return readonlysqlitedatabase;
                readonlysqlitedatabase;
                CDSUtil.closeCursorQuietly(((Cursor) (obj)));
                throw readonlysqlitedatabase;
            }

            protected volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
            {
                return execute(readonlysqlitedatabase);
            }

            
            {
                this$0 = SortTypeSqliteImpl.this;
                id = s;
                super();
            }
        }).execute(connectionManager);
    }

    public void saveSortTypeById(final String id, final MediaItemSortType sortType)
    {
        (new DBWriteExecutor() {

            final SortTypeSqliteImpl this$0;
            final String val$id;
            final MediaItemSortType val$sortType;

            protected volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                return execute(readwritesqlitedatabase);
            }

            protected Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
            {
                ContentValues contentvalues = new ContentValues(2);
                contentvalues.put("tag_id", id);
                contentvalues.put("sort_order", sortType.toString());
                if (readwritesqlitedatabase.update("sort_preference", contentvalues, "tag_id=?", new String[] {
            id
        }) == 0)
                {
                    readwritesqlitedatabase.insert("sort_preference", null, contentvalues);
                }
                return null;
                readwritesqlitedatabase;
                return null;
            }

            
            {
                this$0 = SortTypeSqliteImpl.this;
                id = s;
                sortType = mediaitemsorttype;
                super();
            }
        }).execute(connectionManager);
    }


}
