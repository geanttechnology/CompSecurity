// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.database.sqlite.SQLiteDatabase;

// Referenced classes of package com.wishabi.flipp.content:
//            bk

final class bd
    implements bk
{

    bd()
    {
    }

    public final void a(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE shopping_lists (id INTEGER PRIMARY KEY,name TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE shopping_list_items (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,position INTEGER,checked INTEGER,datetime_updated INTEGER,shopping_list_id INTEGER,FOREIGN KEY(shopping_list_id) REFERENCES shopping_lists(id));");
    }

    public final void b(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS shopping_lists;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS shopping_list_items;");
    }
}
