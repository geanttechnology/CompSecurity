// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import com.amazon.gallery.framework.data.dao.sqlite.DBReadExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadOnlySQLiteDatabase;
import com.amazon.gallery.framework.model.ObjectID;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediaitem:
//            LocalMediaItemDaoSqliteImpl

class val.id extends DBReadExecutor
{

    final LocalMediaItemDaoSqliteImpl this$0;
    final ObjectID val$id;

    public Long execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        return LocalMediaItemDaoSqliteImpl.access$800(LocalMediaItemDaoSqliteImpl.this, readonlysqlitedatabase, val$id);
    }

    public volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        return execute(readonlysqlitedatabase);
    }

    ()
    {
        this$0 = final_localmediaitemdaosqliteimpl;
        val$id = ObjectID.this;
        super();
    }
}
