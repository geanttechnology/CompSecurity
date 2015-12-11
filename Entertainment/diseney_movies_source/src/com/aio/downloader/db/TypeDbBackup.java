// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.aio.downloader.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class TypeDbBackup extends SQLiteOpenHelper
{

    public static final String APP_NAME = "app_name";
    private static final String DATABASE_APK = "create table backup(package_name VARCHAR(255) PRIMARY KEY, typ VARCHAR(20),version VARCHAR(255),size VARCHAR(255),img VARCHAR(255),app_name VARCHAR(255))";
    public static final String IMG = "img";
    public static final String PACKAGE_NAME = "package_name";
    public static final String SIZE = "size";
    public static final String TABLE_BUCKUP = "backup";
    public static final String TYPE = "typ";
    public static final String VERSION = "version";

    public TypeDbBackup(Context context)
    {
        super(context, "backup", null, 1);
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("create table backup(package_name VARCHAR(255) PRIMARY KEY, typ VARCHAR(20),version VARCHAR(255),size VARCHAR(255),img VARCHAR(255),app_name VARCHAR(255))");
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
    }
}
