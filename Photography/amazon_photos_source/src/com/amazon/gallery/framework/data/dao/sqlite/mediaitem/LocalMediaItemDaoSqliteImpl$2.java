// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import android.content.ContentValues;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.sqlite.DBWriteExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadWriteSQLiteDatabase;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediaitem:
//            LocalMediaItemDaoSqliteImpl

class this._cls0 extends DBWriteExecutor
{

    final LocalMediaItemDaoSqliteImpl this$0;

    protected volatile Object execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        return execute(readwritesqlitedatabase);
    }

    protected Void execute(ReadWriteSQLiteDatabase readwritesqlitedatabase)
    {
        String s = String.format("%s = %d AND %s IN (%s)", new Object[] {
            "potentially_orphaned", Integer.valueOf(1), "id", LocalMediaItemDaoSqliteImpl.access$000()
        });
        ContentValues contentvalues = new ContentValues(1);
        contentvalues.put("potentially_orphaned", Integer.valueOf(0));
        int i = readwritesqlitedatabase.update("media_item", contentvalues, s, new String[0]);
        GLogger.i(LocalMediaItemDaoSqliteImpl.access$100(), "Reset potentially_orphaned flag on %d media items.", new Object[] {
            Integer.valueOf(i)
        });
        if (i > 0)
        {
            incrementSessionCounter();
        }
        return null;
    }

    ()
    {
        this$0 = LocalMediaItemDaoSqliteImpl.this;
        super();
    }
}
