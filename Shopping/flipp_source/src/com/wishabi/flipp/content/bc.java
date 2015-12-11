// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.database.sqlite.SQLiteDatabase;

// Referenced classes of package com.wishabi.flipp.content:
//            bk

final class bc
    implements bk
{

    bc()
    {
    }

    public final void a(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE favorite_merchants (_id INTEGER PRIMARY KEY);");
        sqlitedatabase.execSQL("CREATE TABLE clipped_items (_id INTEGER PRIMARY KEY,flyer_id INTEGER,bottom REAL,top REAL,left REAL,right REAL,merchant TEXT,merchant_logo TEXT,name TEXT,premium INTEGER, price TEXT,thumbnail TEXT,valid_to TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE read_flyers (_id INTEGER PRIMARY KEY,valid_to TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE sent_analytics (_id INTEGER PRIMARY KEY,flyer_id INTEGER,analytic_type INTEGER,valid_to TEXT);");
    }

    public final void b(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS favorite_merchants;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS clipped_items;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS read_flyers;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS sent_analytics;");
    }
}
