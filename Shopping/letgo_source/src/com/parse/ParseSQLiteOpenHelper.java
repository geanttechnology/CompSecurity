// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseSQLiteDatabase

abstract class ParseSQLiteOpenHelper
{

    private final SQLiteOpenHelper helper;

    public ParseSQLiteOpenHelper(Context context, String s, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory, int i)
    {
        helper = new SQLiteOpenHelper(context, s, cursorfactory, i) {

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

            public void onUpgrade(SQLiteDatabase sqlitedatabase, int j, int k)
            {
                ParseSQLiteOpenHelper.this.onUpgrade(sqlitedatabase, j, k);
            }

            
            {
                this$0 = ParseSQLiteOpenHelper.this;
                super(context, s, cursorfactory, i);
            }
        };
    }

    private cu getDatabaseAsync(boolean flag)
    {
        SQLiteOpenHelper sqliteopenhelper = helper;
        int i;
        if (!flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        return ParseSQLiteDatabase.openDatabaseAsync(sqliteopenhelper, i);
    }

    public cu getReadableDatabaseAsync()
    {
        return getDatabaseAsync(false);
    }

    public cu getWritableDatabaseAsync()
    {
        return getDatabaseAsync(true);
    }

    public abstract void onCreate(SQLiteDatabase sqlitedatabase);

    public void onOpen(SQLiteDatabase sqlitedatabase)
    {
    }

    public abstract void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j);
}
