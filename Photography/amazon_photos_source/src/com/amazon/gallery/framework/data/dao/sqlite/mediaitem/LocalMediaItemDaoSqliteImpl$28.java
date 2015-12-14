// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import android.database.Cursor;
import com.amazon.gallery.framework.data.dao.sqlite.DBReadExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadOnlySQLiteDatabase;
import com.amazon.gallery.framework.model.tags.Tag;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediaitem:
//            LocalMediaItemDaoSqliteImpl

class val.tag extends DBReadExecutor
{

    final LocalMediaItemDaoSqliteImpl this$0;
    final Tag val$tag;

    public Integer execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        String as[];
        Object obj;
        String s;
        obj = null;
        as = null;
        if (val$tag != null)
        {
            obj = String.format("c.%s = ?", new Object[] {
                "id", Long.valueOf(val$tag.getId())
            });
            as = new String[1];
            as[0] = String.valueOf(val$tag.getId());
        }
        s = LocalMediaItemDaoSqliteImpl.access$1900(LocalMediaItemDaoSqliteImpl.this, "COUNT(*) AS COUNT", new String[] {
            obj
        });
        obj = null;
        readonlysqlitedatabase = readonlysqlitedatabase.rawQuery(s, as);
        obj = readonlysqlitedatabase;
        if (!readonlysqlitedatabase.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_128;
        }
        obj = readonlysqlitedatabase;
        int i = readonlysqlitedatabase.getInt(0);
        if (readonlysqlitedatabase != null)
        {
            readonlysqlitedatabase.close();
        }
        return Integer.valueOf(i);
        if (readonlysqlitedatabase != null)
        {
            readonlysqlitedatabase.close();
        }
        return Integer.valueOf(-1);
        readonlysqlitedatabase;
        if (obj != null)
        {
            ((Cursor) (obj)).close();
        }
        throw readonlysqlitedatabase;
    }

    public volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        return execute(readonlysqlitedatabase);
    }

    ()
    {
        this$0 = final_localmediaitemdaosqliteimpl;
        val$tag = Tag.this;
        super();
    }
}
