// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import android.content.ContentValues;
import com.amazon.gallery.framework.data.dao.MediaItemSortType;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            DBWriteExecutor, SortTypeSqliteImpl, ReadWriteSQLiteDatabase

class > extends DBWriteExecutor
{

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
        contentvalues.put("tag_id", val$id);
        contentvalues.put("sort_order", val$sortType.toString());
        if (readwritesqlitedatabase.update("sort_preference", contentvalues, "tag_id=?", new String[] {
    val$id
}) == 0)
        {
            readwritesqlitedatabase.insert("sort_preference", null, contentvalues);
        }
        return null;
        readwritesqlitedatabase;
        return null;
    }

    se()
    {
        this$0 = final_sorttypesqliteimpl;
        val$id = s;
        val$sortType = MediaItemSortType.this;
        super();
    }
}
