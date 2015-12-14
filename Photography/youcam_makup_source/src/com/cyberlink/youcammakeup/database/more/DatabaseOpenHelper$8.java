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
        m.b("database.more.DatabaseOpenHelper", (new StringBuilder()).append("update db: ").append(DatabaseOpenHelper.a(a, 1, 6)).toString());
        sqlitedatabase.delete("MakeupItemCache", null, null);
        sqlitedatabase.delete("MakeupCategoryCache", null, null);
        sqlitedatabase.execSQL("CREATE TABLE LookCategoryInfo (GUID TEXT,Type TEXT,Category TEXT,ExtStr1 TEXT,ExtStr2 TEXT,ExtInt1 INTEGER,ExtInt2 INTEGER);");
        sqlitedatabase.execSQL("CREATE TABLE LocalizationInfo (Lang TEXT,Name TEXT,Value TEXT,ExtStr1 TEXT,ExtStr2 TEXT,ExtInt1 INTEGER,ExtInt2 INTEGER, UNIQUE (Lang, Name) ON CONFLICT REPLACE);");
    }

    (DatabaseOpenHelper databaseopenhelper)
    {
        a = databaseopenhelper;
        super();
    }
}
