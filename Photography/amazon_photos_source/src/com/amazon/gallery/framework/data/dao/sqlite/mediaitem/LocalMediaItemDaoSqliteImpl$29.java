// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import android.database.Cursor;
import com.amazon.gallery.framework.data.dao.sqlite.DBReadExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadOnlySQLiteDatabase;
import com.amazon.gallery.framework.model.tags.TagType;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediaitem:
//            LocalMediaItemDaoSqliteImpl

class val.onlyUnuploaded extends DBReadExecutor
{

    final LocalMediaItemDaoSqliteImpl this$0;
    final boolean val$onlyUnuploaded;

    public Integer execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        Object obj;
        String s;
        obj = new ArrayList();
        ((List) (obj)).add(String.format("c.%s = %d", new Object[] {
            "valid", Integer.valueOf(1)
        }));
        ((List) (obj)).add(String.format("c.%s = %d", new Object[] {
            "type", Integer.valueOf(TagType.LOCAL_FOLDER.ordinal())
        }));
        ((List) (obj)).add(String.format("c.%s = %d", new Object[] {
            "auto_save", Integer.valueOf(1)
        }));
        if (val$onlyUnuploaded)
        {
            ((List) (obj)).add(String.format("a.%s IN %s", new Object[] {
                "sync_state", LocalMediaItemDaoSqliteImpl.access$2000()
            }));
        }
        s = LocalMediaItemDaoSqliteImpl.access$1900(LocalMediaItemDaoSqliteImpl.this, "COUNT(*) AS COUNT", (String[])((List) (obj)).toArray(new String[((List) (obj)).size()]));
        obj = null;
        readonlysqlitedatabase = readonlysqlitedatabase.rawQuery(s, null);
        obj = readonlysqlitedatabase;
        if (!readonlysqlitedatabase.moveToFirst())
        {
            break MISSING_BLOCK_LABEL_206;
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
        val$onlyUnuploaded = Z.this;
        super();
    }
}
