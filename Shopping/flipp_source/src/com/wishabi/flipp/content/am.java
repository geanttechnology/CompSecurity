// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;

import android.database.sqlite.SQLiteDatabase;

// Referenced classes of package com.wishabi.flipp.content:
//            ao

final class am
    implements ao
{

    am()
    {
    }

    public final void a(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE history (_id INTEGER PRIMARY KEY,word TEXT UNIQUE ON CONFLICT REPLACE,date LONG);");
        sqlitedatabase.execSQL("CREATE TABLE item (_id INTEGER PRIMARY KEY,word TEXT UNIQUE ON CONFLICT REPLACE,locale TEXT);");
        sqlitedatabase.execSQL("CREATE INDEX index_item_word ON item (word COLLATE NOCASE);");
        sqlitedatabase.execSQL("CREATE INDEX index_item_locale ON item (locale COLLATE NOCASE);");
        sqlitedatabase.execSQL("CREATE TABLE merchant (_id INTEGER PRIMARY KEY,word TEXT UNIQUE ON CONFLICT REPLACE);");
        sqlitedatabase.execSQL("CREATE INDEX index_merchant_word ON merchant (word COLLATE NOCASE);");
    }

    public final void b(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS history;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS item;");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS merchant;");
    }
}
