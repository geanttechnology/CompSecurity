// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.tag;

import com.amazon.gallery.framework.data.dao.sqlite.DBReadExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadOnlySQLiteDatabase;
import com.amazon.gallery.framework.model.ObjectID;
import com.amazon.gallery.framework.model.tags.Tag;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.tag:
//            TagDaoSqliteImpl

class val.id extends DBReadExecutor
{

    final TagDaoSqliteImpl this$0;
    final ObjectID val$id;

    protected Tag execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        return TagDaoSqliteImpl.access$100(TagDaoSqliteImpl.this, readonlysqlitedatabase, val$id);
    }

    protected volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        return execute(readonlysqlitedatabase);
    }

    I()
    {
        this$0 = final_tagdaosqliteimpl;
        val$id = ObjectID.this;
        super();
    }
}
