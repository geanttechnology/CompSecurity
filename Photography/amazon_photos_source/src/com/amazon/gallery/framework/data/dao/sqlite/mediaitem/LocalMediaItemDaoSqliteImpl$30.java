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

    public Long execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        ReadOnlySQLiteDatabase readonlysqlitedatabase1;
        String s;
        s = LocalMediaItemDaoSqliteImpl.access$1900(LocalMediaItemDaoSqliteImpl.this, String.format("SUM(%s) as %s", new Object[] {
            "file_size", "file_size"
        }), new String[] {
            String.format("c.%s = ?", new Object[] {
                "id"
            })
        });
        readonlysqlitedatabase1 = null;
        readonlysqlitedatabase = readonlysqlitedatabase.rawQuery(s, new String[] {
            String.valueOf(val$tag.getId())
        });
        readonlysqlitedatabase1 = readonlysqlitedatabase;
        if (!readonlysqlitedatabase.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_113;
        }
        readonlysqlitedatabase1 = readonlysqlitedatabase;
        long l = readonlysqlitedatabase.getLong(0);
        if (readonlysqlitedatabase != null)
        {
            readonlysqlitedatabase.close();
        }
        return Long.valueOf(l);
        if (readonlysqlitedatabase != null)
        {
            readonlysqlitedatabase.close();
        }
        return Long.valueOf(-1L);
        readonlysqlitedatabase;
        if (readonlysqlitedatabase1 != null)
        {
            readonlysqlitedatabase1.close();
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
