// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import com.amazon.gallery.framework.data.dao.sqlite.DBWriteExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediaitem:
//            LocalMediaItemDaoSqliteImpl

static final class  extends DBWriteExecutor
{

    protected Long execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return Long.valueOf(readwritesqlitedatabase.count("media_item", String.format("%s = %d", new Object[] {
            "potentially_orphaned", Integer.valueOf(1)
        }), new String[0]));
    }

    protected volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return execute(readwritesqlitedatabase);
    }

    ()
    {
    }
}
