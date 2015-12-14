// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import android.database.Cursor;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.MediaItemSortType;
import com.amazon.gallery.thor.cds.CDSUtil;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            DBReadExecutor, SortTypeSqliteImpl, ReadOnlySQLiteDatabase

class  extends DBReadExecutor
{

    final SortTypeSqliteImpl this$0;
    final String val$id;

    protected MediaItemSortType execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        Object obj;
        obj = val$id;
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
        GLogger.v(SortTypeSqliteImpl.access$000(), "Nothing found in DB, returning default sort order", new Object[0]);
        readonlysqlitedatabase = getDefaultSortType(val$id, readonlysqlitedatabase);
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

    e()
    {
        this$0 = final_sorttypesqliteimpl;
        val$id = String.this;
        super();
    }
}
