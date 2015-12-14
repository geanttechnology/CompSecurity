// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MixtapeMetricsDatabaseHelper extends SQLiteOpenHelper
{

    public MixtapeMetricsDatabaseHelper(Context context)
    {
        super(context, "mixtape_metrics.db", null, 1);
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE metrics (_id INTEGER PRIMARY KEY AUTOINCREMENT, type TEXT, event_name TEXT, start_time TEXT, duration INTEGER, count INTEGER, is_error INTEGER)");
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
    }
}
