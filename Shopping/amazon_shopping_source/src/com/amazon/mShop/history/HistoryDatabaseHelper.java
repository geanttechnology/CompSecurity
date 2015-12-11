// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.history;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.amazon.mShop.util.DatabaseHelper;

public class HistoryDatabaseHelper extends DatabaseHelper
{

    protected HistoryDatabaseHelper(Context context)
    {
        super(context, "history.db", 2);
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL(String.format("CREATE TABLE %s (%s INTEGER PRIMARY KEY, %s TEXT, %s TEXT, %s TEXT, %s INTEGER, %s TEXT, %s TEXT,UNIQUE(%s, %s, %s, %s) ON CONFLICT REPLACE);", new Object[] {
            "history", "_id", "asin", "type", "locale", "visit_date", "email", "original_scanned_history", "asin", "type", 
            "locale", "email"
        }));
    }

    public void onDowngrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS history");
        onCreate(sqlitedatabase);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS history");
        onCreate(sqlitedatabase);
    }
}
