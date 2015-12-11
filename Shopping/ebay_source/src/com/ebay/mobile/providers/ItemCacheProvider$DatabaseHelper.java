// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.providers;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

// Referenced classes of package com.ebay.mobile.providers:
//            ItemCacheProvider

private static class  extends SQLiteOpenHelper
{

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        Log.v("ItemCacheProvider", "Creating ItemCache database");
        try
        {
            sqlitedatabase.execSQL("CREATE TABLE item (_id INTEGER PRIMARY KEY AUTOINCREMENT, image_url TEXT, title TEXT NOT NULL,price TEXT, bid_count INTEGER, end_date INTEGER)");
            sqlitedatabase.execSQL("CREATE TABLE list (_id INTEGER PRIMARY KEY AUTOINCREMENT, type INTEGER NOT NULL, item_id INTEGER NOT NULL)");
            sqlitedatabase.execSQL("CREATE TABLE event (_id INTEGER PRIMARY KEY AUTOINCREMENT, type INTEGER NOT NULL, item_id INTEGER NOT NULL,timestamp INTEGER NOT NULL, title TEXT, viewed INTEGER, any_data TEXT, client_id TEXT, transaction_id TEXT, draft_id TEXT, listing_mode TEXT, site_id TEXT, rid TEXT, odr TEXT, currency_code TEXT, current_bid TEXT, item_end_time INTEGER DEFAULT 0, item_listing_type INTEGER, content TEXT, header TEXT)");
            sqlitedatabase.execSQL("CREATE TABLE saved_search (_id INTEGER PRIMARY KEY AUTOINCREMENT, search_id TEXT, name TEXT, count INTEGER, poll_time INTEGER, view_time INTEGER, since_time INTEGER)");
            sqlitedatabase.execSQL("CREATE TABLE name_value (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, value TEXT)");
            sqlitedatabase.execSQL("CREATE TABLE local_notifications (_id INTEGER PRIMARY KEY AUTOINCREMENT, item_id INTEGER, client_id TEXT, end_time INTEGER, title TEXT, type TEXT, device_id TEXT, from_user TEXT, username TEXT, galleryUrl TEXT, pictureUrl TEXT, itemType INTEGER)");
            Log.v("ItemCacheProvider", "Created ItemCache db, 6 tables created");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            Log.e("ItemCacheProvider", sqlitedatabase.toString(), sqlitedatabase);
        }
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        Log.v("ItemCacheProvider", (new StringBuilder()).append("onUpgrade: old=").append(i).append(", new=").append(j).append("  dropping tables").toString());
        try
        {
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS item");
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS list");
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS event");
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS saved_search");
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS name_value");
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS local_notifications");
            Log.v("ItemCacheProvider", "onUpgrade: tables dropped, calling onCreate");
            onCreate(sqlitedatabase);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            Log.e("ItemCacheProvider", sqlitedatabase.toString(), sqlitedatabase);
        }
    }

    (Context context)
    {
        super(context, "item_cache.db", null, 13);
    }
}
