// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class TypeDb extends SQLiteOpenHelper
{

    public static final String CREATE_TIME = "create_time";
    private static final String DATABASE_APK = "create table file_list(id VARCHAR(255) PRIMARY KEY, typ VARCHAR(20), title VARCHAR(255), icon VARCHAR(255), size VARCHAR(20), path VARCHAR(255),serial INT(10),create_time INT(10))";
    public static final String ICON = "icon";
    public static final String PATH = "path";
    public static final String SERIAL = "serial";
    public static final String SIZE = "size";
    public static final String TABLE_NAME = "file_list";
    public static final String TITLE = "title";
    public static final String TYPE = "typ";
    public static final String _ID = "id";

    public TypeDb(Context context)
    {
        super(context, "file_list", null, 1);
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("create table file_list(id VARCHAR(255) PRIMARY KEY, typ VARCHAR(20), title VARCHAR(255), icon VARCHAR(255), size VARCHAR(20), path VARCHAR(255),serial INT(10),create_time INT(10))");
        Log.e("qwa", "dbdbdb");
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
    }
}
