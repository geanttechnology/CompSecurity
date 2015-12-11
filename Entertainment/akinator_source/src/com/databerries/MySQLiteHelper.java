// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.databerries;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteHelper extends SQLiteOpenHelper
{

    static final String COLUMN_ACCURACY = "accuracy";
    static final String COLUMN_DATE = "_date";
    static final String COLUMN_ID = "_id";
    static final String COLUMN_LATITUDE = "latitude";
    static final String COLUMN_LONGITUDE = "longitude";
    static final String COLUMN_UUID = "uuid";
    private static final String CREATE_LOCATION_TABLE = "create table locations(_id integer primary key autoincrement, _date integer, longitude double, latitude double, accuracy integer, uuid text not null);";
    private static final String DATA_BASE_NAME = "DataBerriesDB";
    private static final int DATA_BASE_VERSION = 2;
    public static final String LOCATION_TABLE_NAME = "locations";

    MySQLiteHelper(Context context)
    {
        super(context, "DataBerriesDB", null, 2);
    }

    void createLocationTable(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("create table locations(_id integer primary key autoincrement, _date integer, longitude double, latitude double, accuracy integer, uuid text not null);");
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        createLocationTable(sqlitedatabase);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        if (i == 1 && j == 2)
        {
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS locations");
            createLocationTable(sqlitedatabase);
        }
    }
}
