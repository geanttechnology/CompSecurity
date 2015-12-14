// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more;

import android.database.sqlite.SQLiteDatabase;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.database.more:
//            x, DatabaseOpenHelper

class a
    implements x
{

    final DatabaseOpenHelper a;

    public void a(SQLiteDatabase sqlitedatabase)
    {
        m.b("database.more.DatabaseOpenHelper", (new StringBuilder()).append("update db: ").append(DatabaseOpenHelper.a(a, 1, 4)).toString());
        sqlitedatabase.execSQL("CREATE TABLE SkuColorInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT,SkuGUID TEXT,ItemGUID TEXT,PatternGUID TEXT,ColorNumber TEXT,ColorName TEXT,ColorType TEXT,Color TEXT,Intensity INTEGER,ExtraData TEXT,Ext_1 TEXT,Ext_2 TEXT, UNIQUE (SkuGUID, ItemGUID) ON CONFLICT REPLACE);");
        sqlitedatabase.execSQL("CREATE TABLE SkuCache (_id INTEGER PRIMARY KEY AUTOINCREMENT,Skuid BIGINT,SkuType TEXT,SkuStartDate BIGINT,SkuEndDate BIGINT,JsonString TEXT,Ext_1 TEXT,Ext_2 TEXT);");
    }

    (DatabaseOpenHelper databaseopenhelper)
    {
        a = databaseopenhelper;
        super();
    }
}
