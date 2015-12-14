// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.database.more;

import android.database.sqlite.SQLiteDatabase;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.database.more:
//            x, DatabaseOpenHelper, DatabaseUpgradeHelper

class a
    implements x
{

    final DatabaseOpenHelper a;

    public void a(SQLiteDatabase sqlitedatabase)
    {
        m.b("database.more.DatabaseOpenHelper", (new StringBuilder()).append("update db: ").append(DatabaseOpenHelper.a(a, 1, 8)).toString());
        sqlitedatabase.execSQL("CREATE TABLE StyleInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT,GUID TEXT,ExtraData TEXT,Ext1 TEXT,Ext2 TEXT,Ext3 TEXT,Ext4 TEXT,Ext5 TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE PaletteStyleInfo (_id INTEGER PRIMARY KEY AUTOINCREMENT,palette_guid TEXT,style_guid TEXT,inner_ratio TEXT,feather_strength TEXT,intensity TEXT);");
        DatabaseUpgradeHelper.e(sqlitedatabase);
        DatabaseUpgradeHelper.d(sqlitedatabase);
        DatabaseUpgradeHelper.a(sqlitedatabase, UpgradeType.a);
    }

    UpgradeType(DatabaseOpenHelper databaseopenhelper)
    {
        a = databaseopenhelper;
        super();
    }
}
