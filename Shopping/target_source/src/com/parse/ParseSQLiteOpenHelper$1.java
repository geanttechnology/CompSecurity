// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

// Referenced classes of package com.parse:
//            ParseSQLiteOpenHelper

class base.CursorFactory extends SQLiteOpenHelper
{

    final ParseSQLiteOpenHelper this$0;

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        ParseSQLiteOpenHelper.this.onCreate(sqlitedatabase);
    }

    public void onOpen(SQLiteDatabase sqlitedatabase)
    {
        super.onOpen(sqlitedatabase);
        ParseSQLiteOpenHelper.this.onOpen(sqlitedatabase);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        ParseSQLiteOpenHelper.this.onUpgrade(sqlitedatabase, i, j);
    }

    base.CursorFactory(Context context, String s, android.database.sqlite.tory tory, int i)
    {
        this$0 = ParseSQLiteOpenHelper.this;
        super(context, s, tory, i);
    }
}
