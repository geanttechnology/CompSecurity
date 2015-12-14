// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import com.amazon.gallery.framework.data.dao.SortOrder;
import com.amazon.gallery.framework.data.dao.sqlite.DBReadExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadOnlySQLiteDatabase;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediaitem:
//            LocalMediaItemDaoSqliteImpl

class val.value extends DBReadExecutor
{

    final LocalMediaItemDaoSqliteImpl this$0;
    final String val$key;
    final List val$value;

    public volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        return execute(readonlysqlitedatabase);
    }

    public List execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        return LocalMediaItemDaoSqliteImpl.access$400(LocalMediaItemDaoSqliteImpl.this, readonlysqlitedatabase, val$key, val$value, new SortOrder("id"));
    }

    ()
    {
        this$0 = final_localmediaitemdaosqliteimpl;
        val$key = s;
        val$value = List.this;
        super();
    }
}
