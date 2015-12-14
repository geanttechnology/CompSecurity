// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite.mediaitem;

import android.database.Cursor;
import com.amazon.gallery.framework.data.dao.sqlite.DBReadExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadOnlySQLiteDatabase;
import com.amazon.gallery.framework.model.media.MediaType;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite.mediaitem:
//            LocalMediaItemDaoSqliteImpl

class this._cls0 extends DBReadExecutor
{

    final LocalMediaItemDaoSqliteImpl this$0;

    protected volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        return execute(readonlysqlitedatabase);
    }

    protected Map execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        Object obj;
        obj = new HashMap();
        readonlysqlitedatabase = readonlysqlitedatabase.rawQuery("select type ordinal, count(*) count from media_item where local_path is NULL group by type", null);
        while (readonlysqlitedatabase.moveToNext()) 
        {
            int i = readonlysqlitedatabase.getInt(readonlysqlitedatabase.getColumnIndexOrThrow("ordinal"));
            int j = readonlysqlitedatabase.getInt(readonlysqlitedatabase.getColumnIndexOrThrow("count"));
            ((Map) (obj)).put(MediaType.values()[i], Integer.valueOf(j));
        }
        break MISSING_BLOCK_LABEL_98;
        obj;
        if (readonlysqlitedatabase != null && !readonlysqlitedatabase.isClosed())
        {
            readonlysqlitedatabase.close();
        }
        throw obj;
        if (readonlysqlitedatabase != null && !readonlysqlitedatabase.isClosed())
        {
            readonlysqlitedatabase.close();
        }
        return ((Map) (obj));
    }

    ()
    {
        this$0 = LocalMediaItemDaoSqliteImpl.this;
        super();
    }
}
