// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.database.sqlite.SQLiteDatabase;

// Referenced classes of package com.wishabi.flipp.content:
//            bk

final class be
    implements bk
{

    be()
    {
    }

    public final void a(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE shopping_list_categories(item_name TEXT PRIMARY KEY,category TEXT);");
        sqlitedatabase.execSQL("CREATE TABLE shopping_list_cat_order (category TEXT PRIMARY KEY,position INTEGER);");
    }

    public final void b(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS shopping_list_categories;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS shopping_list_cat_order;");
    }
}
