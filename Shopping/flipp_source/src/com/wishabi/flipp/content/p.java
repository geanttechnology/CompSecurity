// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.database.sqlite.SQLiteDatabase;

// Referenced classes of package com.wishabi.flipp.content:
//            x

final class p
    implements x
{

    p()
    {
    }

    public final void a(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE flyers (_id INTEGER PRIMARY KEY, flyer_id INTEGER, available_from TEXT, available_to TEXT, flyer_run_id INTEGER, flyer_type_id INTEGER, width REAL, height REAL, language TEXT, locale TEXT, merchant TEXT, merchant_id INTEGER, merchant_logo TEXT, name TEXT, path TEXT, postal_code TEXT, premium INTEGER, priority INTEGER, resolutions TEXT, thumbnail TEXT, updated_at TEXT, valid_from TEXT, valid_to TEXT, web_indexed INTEGER);");
        sqlitedatabase.execSQL("CREATE TABLE items (_id INTEGER PRIMARY KEY, available_to TEXT, bottom REAL, top REAL, left REAL, right REAL, brand TEXT, discount REAL, flyer_id INTEGER, name TEXT, price TEXT, thumbnail TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE categories (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, flyer_id INTEGER, UNIQUE (name, flyer_id));");
    }

    public final void b(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS flyers;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS items;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS categories;");
    }
}
