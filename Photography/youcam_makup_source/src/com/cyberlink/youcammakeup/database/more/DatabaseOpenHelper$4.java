// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more;

import android.database.sqlite.SQLiteDatabase;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.database.more:
//            x, DatabaseOpenHelper, j

class a
    implements x
{

    final DatabaseOpenHelper a;

    public void a(SQLiteDatabase sqlitedatabase)
    {
        m.b("database.more.DatabaseOpenHelper", (new StringBuilder()).append("update db: ").append(DatabaseOpenHelper.a(a, 1, 2)).toString());
        sqlitedatabase.execSQL(j.a());
        sqlitedatabase.execSQL("CREATE TABLE MakeupCategoryCache (_id INTEGER PRIMARY KEY AUTOINCREMENT,MCid BIGINT,JsonString TEXT,Ext_1 TEXT,Ext_2 TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE MakeupItemCache (_id INTEGER PRIMARY KEY AUTOINCREMENT,MIid BIGINT,Cid BIGINT,JsonString TEXT,Ext_1 TEXT,Ext_2 TEXT);");
    }

    (DatabaseOpenHelper databaseopenhelper)
    {
        a = databaseopenhelper;
        super();
    }
}
