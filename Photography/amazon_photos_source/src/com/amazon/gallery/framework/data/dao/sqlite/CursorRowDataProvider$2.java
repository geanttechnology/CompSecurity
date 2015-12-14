// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            DBReadExecutor, CursorRowDataProvider, ReadOnlySQLiteDatabase

class mit extends DBReadExecutor
{

    final CursorRowDataProvider this$0;
    final mit val$limit;

    protected volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        return execute(readonlysqlitedatabase);
    }

    protected List execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        return queryHelper(readonlysqlitedatabase, val$limit);
    }

    mit()
    {
        this$0 = final_cursorrowdataprovider;
        val$limit = mit.this;
        super();
    }
}
