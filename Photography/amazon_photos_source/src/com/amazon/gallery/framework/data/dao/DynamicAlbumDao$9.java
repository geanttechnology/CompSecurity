// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteException;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.sqlite.DBReadExecutor;
import com.amazon.gallery.framework.data.dao.sqlite.ReadOnlySQLiteDatabase;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.amazon.gallery.framework.data.dao:
//            DynamicAlbumDao

class tor extends DBReadExecutor
{

    final DynamicAlbumDao this$0;

    public volatile Object execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        return execute(readonlysqlitedatabase);
    }

    public List execute(ReadOnlySQLiteDatabase readonlysqlitedatabase)
    {
        ReadOnlySQLiteDatabase readonlysqlitedatabase1;
        ReadOnlySQLiteDatabase readonlysqlitedatabase2;
        ArrayList arraylist;
        arraylist = new ArrayList();
        readonlysqlitedatabase2 = null;
        readonlysqlitedatabase1 = null;
        readonlysqlitedatabase = readonlysqlitedatabase.query(true, "dynamic_album_membership", new String[] {
            "tag_id"
        }, null, null, "tag_id", null, "cache_time ASC", null);
        readonlysqlitedatabase1 = readonlysqlitedatabase;
        readonlysqlitedatabase2 = readonlysqlitedatabase;
        int i = readonlysqlitedatabase.getColumnIndex("tag_id");
        readonlysqlitedatabase1 = readonlysqlitedatabase;
        readonlysqlitedatabase2 = readonlysqlitedatabase;
        if (!readonlysqlitedatabase.moveToFirst()) goto _L2; else goto _L1
_L1:
        readonlysqlitedatabase1 = readonlysqlitedatabase;
        readonlysqlitedatabase2 = readonlysqlitedatabase;
        arraylist.add(Long.valueOf(readonlysqlitedatabase.getLong(i)));
_L5:
        readonlysqlitedatabase1 = readonlysqlitedatabase;
        readonlysqlitedatabase2 = readonlysqlitedatabase;
        if (!readonlysqlitedatabase.moveToNext()) goto _L2; else goto _L3
_L3:
        readonlysqlitedatabase1 = readonlysqlitedatabase;
        readonlysqlitedatabase2 = readonlysqlitedatabase;
        arraylist.add(Long.valueOf(readonlysqlitedatabase.getLong(i)));
        if (true) goto _L5; else goto _L4
_L4:
        readonlysqlitedatabase;
        readonlysqlitedatabase2 = readonlysqlitedatabase1;
        GLogger.ex(DynamicAlbumDao.access$200(), "Error fetching dynamic album node ids", readonlysqlitedatabase);
        if (readonlysqlitedatabase1 != null)
        {
            readonlysqlitedatabase1.close();
        }
_L7:
        return arraylist;
_L2:
        if (readonlysqlitedatabase == null) goto _L7; else goto _L6
_L6:
        readonlysqlitedatabase.close();
        return arraylist;
        readonlysqlitedatabase;
        if (readonlysqlitedatabase2 != null)
        {
            readonlysqlitedatabase2.close();
        }
        throw readonlysqlitedatabase;
    }

    iteDatabase()
    {
        this$0 = DynamicAlbumDao.this;
        super();
    }
}
