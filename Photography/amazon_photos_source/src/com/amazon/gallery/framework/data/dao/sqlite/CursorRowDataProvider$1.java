// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;


// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            DBReadExecutor, CursorRowDataProvider, ReadOnlySQLiteDatabase

class this._cls0 extends DBReadExecutor
{

    final CursorRowDataProvider this$0;

    protected Integer execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        return Integer.valueOf(sizeHelper(readonlysqlitedatabase));
    }

    protected volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        return execute(readonlysqlitedatabase);
    }

    ()
    {
        this$0 = CursorRowDataProvider.this;
        super();
    }
}
