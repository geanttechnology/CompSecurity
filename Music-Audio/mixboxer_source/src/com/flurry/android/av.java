// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

final class av extends SQLiteOpenHelper
{

    public av(Context context, String s)
    {
        super(context, (new StringBuilder()).append("flurry_cache_DB_pending").append(s).toString(), null, 1);
    }

    public final void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("create table registeredDirtyObjectsTable (primery_key_id integer primary key autoincrement, timestamp long not null, objectsId text not null, value integer not null );");
        sqlitedatabase.execSQL("create table pendingDataTable (primery_key_id integer primary key autoincrement, timestamp long not null, objectsId text not null, objectsLocalId text, collectionName text, key text not null, value text );");
        sqlitedatabase.execSQL("create table serverDataTable (primery_key_id integer primary key autoincrement, timestamp long not null, objectsId text not null, objectsLocalId text, collectionName text, key text not null, value text );");
        sqlitedatabase.execSQL("create table searchRequestsTable (searchPredicat text, collectionName text,timestamp long not null, objectsId text primary key );");
        sqlitedatabase.execSQL("create table searchItemsTable (primery_key_id integer primary key autoincrement, objectsId text not null, objectsLocalId text not null, timestamp long not null );");
    }

    public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
    }
}
