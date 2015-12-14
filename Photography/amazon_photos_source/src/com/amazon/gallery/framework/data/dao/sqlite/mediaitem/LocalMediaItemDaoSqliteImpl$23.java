// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import android.database.Cursor;
import com.amazon.gallery.framework.data.dao.sqlite.CursorRowProcessor;
import com.amazon.gallery.framework.data.dao.sqlite.DBReadExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadOnlySQLiteDatabase;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediaitem:
//            LocalMediaItemDaoSqliteImpl

class val.rowProcessor extends DBReadExecutor
{

    final LocalMediaItemDaoSqliteImpl this$0;
    final String val$query;
    final CursorRowProcessor val$rowProcessor;
    final String val$selectionArgs[];

    protected volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        return execute(readonlysqlitedatabase);
    }

    protected Void execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        readonlysqlitedatabase = readonlysqlitedatabase.rawQuery(val$query, val$selectionArgs);
_L2:
        if (readonlysqlitedatabase == null)
        {
            break; /* Loop/switch isn't completed */
        }
        if (!readonlysqlitedatabase.moveToNext())
        {
            break; /* Loop/switch isn't completed */
        }
        val$rowProcessor.process(readonlysqlitedatabase);
        if (true) goto _L2; else goto _L1
        Exception exception;
        exception;
        if (readonlysqlitedatabase != null && !readonlysqlitedatabase.isClosed())
        {
            readonlysqlitedatabase.close();
        }
        throw exception;
_L1:
        if (readonlysqlitedatabase != null && !readonlysqlitedatabase.isClosed())
        {
            readonlysqlitedatabase.close();
        }
        return null;
    }

    ()
    {
        this$0 = final_localmediaitemdaosqliteimpl;
        val$query = s;
        val$selectionArgs = as;
        val$rowProcessor = CursorRowProcessor.this;
        super();
    }
}
