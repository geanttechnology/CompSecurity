// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.providers;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.ebay.mobile.AppSettings;
import java.util.List;

public class ItemCacheProvider extends ContentProvider
{
    private static class DatabaseHelper extends SQLiteOpenHelper
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

        DatabaseHelper(Context context)
        {
            super(context, "item_cache.db", null, 13);
        }
    }

    private static class SqlArguments
    {

        public final String args[];
        public final String table;
        public final String where;

        SqlArguments(Uri uri)
        {
            if (uri.getPathSegments().size() == 1)
            {
                table = (String)uri.getPathSegments().get(0);
                where = null;
                args = null;
                return;
            } else
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid URI: ").append(uri).toString());
            }
        }

        SqlArguments(Uri uri, String s, String as[])
        {
            if (uri.getPathSegments().size() == 1)
            {
                table = (String)uri.getPathSegments().get(0);
                where = s;
                args = as;
                return;
            }
            if (uri.getPathSegments().size() != 2)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("Invalid URI: ").append(uri).toString());
            }
            if (!TextUtils.isEmpty(s))
            {
                throw new UnsupportedOperationException((new StringBuilder()).append("WHERE clause not supported: ").append(uri).toString());
            } else
            {
                table = (String)uri.getPathSegments().get(0);
                where = (new StringBuilder()).append("id=").append(ContentUris.parseId(uri)).toString();
                args = null;
                return;
            }
        }
    }


    public static final String ANY_DATA = "any_data";
    public static final String AUTHORITY = "com.ebay.mobile.providers.itemcacheprovider";
    private static final String BID_COUNT = "bid_count";
    public static final String CLIENT_ID = "client_id";
    public static final String CONTENT = "content";
    public static final Uri CONTENT_URI = Uri.parse("content://com.ebay.mobile.providers.itemcacheprovider");
    private static final String CREATE_EVENT_TABLE = "CREATE TABLE event (_id INTEGER PRIMARY KEY AUTOINCREMENT, type INTEGER NOT NULL, item_id INTEGER NOT NULL,timestamp INTEGER NOT NULL, title TEXT, viewed INTEGER, any_data TEXT, client_id TEXT, transaction_id TEXT, draft_id TEXT, listing_mode TEXT, site_id TEXT, rid TEXT, odr TEXT, currency_code TEXT, current_bid TEXT, item_end_time INTEGER DEFAULT 0, item_listing_type INTEGER, content TEXT, header TEXT)";
    private static final String CREATE_LIST_TABLE = "CREATE TABLE list (_id INTEGER PRIMARY KEY AUTOINCREMENT, type INTEGER NOT NULL, item_id INTEGER NOT NULL)";
    private static final String CREATE_LN_TABLE = "CREATE TABLE local_notifications (_id INTEGER PRIMARY KEY AUTOINCREMENT, item_id INTEGER, client_id TEXT, end_time INTEGER, title TEXT, type TEXT, device_id TEXT, from_user TEXT, username TEXT, galleryUrl TEXT, pictureUrl TEXT, itemType INTEGER)";
    private static final String CREATE_MISC_TABLE = "CREATE TABLE name_value (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, value TEXT)";
    private static final String CREATE_SEARCH_TABLE = "CREATE TABLE saved_search (_id INTEGER PRIMARY KEY AUTOINCREMENT, search_id TEXT, name TEXT, count INTEGER, poll_time INTEGER, view_time INTEGER, since_time INTEGER)";
    private static final String CREATE_TABLE = "CREATE TABLE item (_id INTEGER PRIMARY KEY AUTOINCREMENT, image_url TEXT, title TEXT NOT NULL,price TEXT, bid_count INTEGER, end_date INTEGER)";
    public static final String CURRENCY_CODE = "currency_code";
    public static final String CURRENT_BID = "current_bid";
    private static final String DB_NAME = "item_cache.db";
    private static final int DB_VERSION = 13;
    public static final String DRAFT_ID = "draft_id";
    private static final String END_DATE = "end_date";
    public static final int EVENT_ANYDATA_COLUMN = 6;
    public static final int EVENT_CLIENT_ID_COLUMN = 7;
    public static final String EVENT_COLUMNS[] = {
        "_id", "type", "item_id", "timestamp", "title", "viewed", "any_data", "client_id", "transaction_id", "draft_id", 
        "listing_mode", "site_id", "rid", "odr", "currency_code", "current_bid", "item_end_time", "item_listing_type", "content", "header"
    };
    public static final int EVENT_CONTENT_COLUMN = 18;
    public static final Uri EVENT_CONTENT_URI = Uri.parse("content://com.ebay.mobile.providers.itemcacheprovider/event");
    public static final int EVENT_CURRENCY_CODE_COLUMN = 14;
    public static final int EVENT_CURRENT_BID_COLUMN = 15;
    public static final int EVENT_DRAFT_ID_COLUMN = 9;
    public static final int EVENT_HEADER_COLUMN = 19;
    public static final int EVENT_ID_COLUMN = 0;
    public static final int EVENT_ITEM_END_TIME_COLUMN = 16;
    public static final int EVENT_ITEM_ID_COLUMN = 2;
    public static final int EVENT_ITEM_LISTING_TYPE_COLUMN = 17;
    public static final int EVENT_LISTING_MODE_COLUMN = 10;
    public static final int EVENT_ORDER_ID_COLUMN = 13;
    public static final int EVENT_REF_ID_COLUMN = 12;
    public static final int EVENT_SITE_ID_COLUMN = 11;
    public static final String EVENT_SORT_CLAUSE = "timestamp DESC";
    private static final int EVENT_TABLE = 3;
    private static final String EVENT_TABLE_NAME = "event";
    public static final int EVENT_TIMESTAMP_COLUMN = 3;
    public static final int EVENT_TITLE_COLUMN = 4;
    public static final int EVENT_TRANSACTION_ID_COLUMN = 8;
    public static final int EVENT_TYPE_COLUMN = 1;
    public static final int EVENT_VIEWED_COLUMN = 5;
    public static final int HAS_BEEN_VIEWED = 1;
    public static final int HAS_NOT_BEEN_VIEWED = 0;
    public static final String HEADER = "header";
    private static final String ID = "_id";
    private static final String IMAGE_URL = "image_url";
    public static final Uri ITEM_CONTENT_URI = Uri.parse("content://com.ebay.mobile.providers.itemcacheprovider/item");
    public static final String ITEM_END_TIME = "item_end_time";
    public static final String ITEM_ID = "item_id";
    public static final String ITEM_LISTING_TYPE = "item_listing_type";
    private static final int ITEM_TABLE = 1;
    private static final String ITEM_TABLE_NAME = "item";
    public static final String LISTING_MODE = "listing_mode";
    public static final Uri LIST_CONTENT_URI = Uri.parse("content://com.ebay.mobile.providers.itemcacheprovider/list");
    private static final int LIST_TABLE = 2;
    private static final String LIST_TABLE_NAME = "list";
    public static final String LN_CLIENT_ID = "client_id";
    public static final int LN_CLIENT_ID_COLUMN = 1;
    public static final String LN_COLUMNS[] = {
        "item_id", "client_id", "end_time", "title", "type", "device_id", "from_user", "username", "galleryUrl", "pictureUrl", 
        "itemType"
    };
    public static final Uri LN_CONTENT_URI = Uri.parse("content://com.ebay.mobile.providers.itemcacheprovider/local_notifications");
    public static final String LN_DEVICE_ID = "device_id";
    public static final int LN_DEVICE_ID_COLUMN = 5;
    public static final String LN_END_TIME = "end_time";
    public static final int LN_END_TIME_COLUMN = 2;
    public static final String LN_FROM = "from_user";
    public static final int LN_FROM_COLUMN = 6;
    public static final String LN_GALLERYURL = "galleryUrl";
    public static final int LN_GALLERYURL_COLUMN = 8;
    public static final String LN_ITEMTYPE = "itemType";
    public static final int LN_ITEMTYPE_COLUMN = 10;
    public static final String LN_ITEM_ID = "item_id";
    public static final int LN_ITEM_ID_COLUMN = 0;
    public static final String LN_PICTUREURL = "pictureUrl";
    public static final int LN_PICTUREURL_COLUMN = 9;
    public static final String LN_SORT_CLAUSE = "end_time DESC";
    private static final int LN_TABLE = 6;
    private static final String LN_TABLE_NAME = "local_notifications";
    public static final String LN_TITLE = "title";
    public static final int LN_TITLE_COLUMN = 3;
    public static final String LN_TYPE = "type";
    public static final int LN_TYPE_COLUMN = 4;
    public static final String LN_USER = "username";
    public static final int LN_USER_COLUMN = 7;
    public static final String MISC_COLUMNS[] = {
        "value"
    };
    public static final Uri MISC_CONTENT_URI = Uri.parse("content://com.ebay.mobile.providers.itemcacheprovider/name_value");
    public static final String MISC_NAME = "name";
    public static final int MISC_NAME_COLUMN = 1;
    private static final int MISC_TABLE = 5;
    private static final String MISC_TABLE_NAME = "name_value";
    public static final String MISC_VALUE = "value";
    public static final int MISC_VALUE_COLUMN = 2;
    public static final String ORDER_ID = "odr";
    static final String PARAMETER_NOTIFY = "notify";
    private static final String PRICE = "price";
    public static final String REF_ID = "rid";
    public static final String SEARCH_COLUMNS[] = {
        "search_id", "name", "count", "poll_time", "view_time", "since_time"
    };
    public static final Uri SEARCH_CONTENT_URI = Uri.parse("content://com.ebay.mobile.providers.itemcacheprovider/saved_search");
    public static final String SEARCH_ID = "search_id";
    public static final int SEARCH_ID_COLUMN = 0;
    public static final String SEARCH_NAME = "name";
    public static final int SEARCH_NAME_COLUMN = 1;
    public static final String SEARCH_NEW_ITEM_COUNT = "count";
    public static final int SEARCH_NEW_ITEM_COUNT_COLUMN = 2;
    public static final String SEARCH_POLL_TIMESTAMP = "poll_time";
    public static final int SEARCH_POLL_TIMESTAMP_COLUMN = 3;
    public static final String SEARCH_SINCE_TIMESTAMP = "since_time";
    public static final int SEARCH_SINCE_TIMESTAMP_COLUMN = 5;
    private static final int SEARCH_TABLE = 4;
    private static final String SEARCH_TABLE_NAME = "saved_search";
    public static final String SEARCH_VIEW_TIMESTAMP = "view_time";
    public static final int SEARCH_VIEW_TIMESTAMP_COLUMN = 4;
    public static final String SITE_ID = "site_id";
    private static final String TAG = "ItemCacheProvider";
    public static final String TIMESTAMP = "timestamp";
    public static final String TITLE = "title";
    public static final String TRANSACTION_ID = "transaction_id";
    public static final String TYPE = "type";
    public static final String VIEWED = "viewed";
    private static final UriMatcher sUriMatcher;
    private DatabaseHelper dbHelper;

    public ItemCacheProvider()
    {
    }

    private void sendNotify(Uri uri)
    {
        String s = uri.getQueryParameter("notify");
        if (s == null || "true".equals(s))
        {
            getContext().getContentResolver().notifyChange(uri, null);
        }
    }

    private void validateUri(Uri uri)
    {
        switch (sUriMatcher.match(uri))
        {
        default:
            throw new IllegalArgumentException((new StringBuilder()).append("unknown URI = ").append(uri).toString());

        case 1: // '\001'
        case 2: // '\002'
        case 3: // '\003'
        case 4: // '\004'
        case 5: // '\005'
        case 6: // '\006'
            return;
        }
    }

    public int delete(Uri uri, String s, String as[])
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        s = new SqlArguments(uri, s, as);
        i = dbHelper.getWritableDatabase().delete(((SqlArguments) (s)).table, ((SqlArguments) (s)).where, ((SqlArguments) (s)).args);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_47;
        }
        sendNotify(uri);
        this;
        JVM INSTR monitorexit ;
        return i;
        uri;
        throw uri;
    }

    public String getType(Uri uri)
    {
        uri = new SqlArguments(uri, null, null);
        if (TextUtils.isEmpty(((SqlArguments) (uri)).where))
        {
            return (new StringBuilder()).append("vnd.android.cursor.dir/").append(((SqlArguments) (uri)).table).toString();
        } else
        {
            return (new StringBuilder()).append("vnd.android.cursor.item/").append(((SqlArguments) (uri)).table).toString();
        }
    }

    public Uri insert(Uri uri, ContentValues contentvalues)
    {
        Object obj = null;
        this;
        JVM INSTR monitorenter ;
        validateUri(uri);
        if (contentvalues != null) goto _L2; else goto _L1
_L1:
        contentvalues = new ContentValues();
_L5:
        long l;
        SqlArguments sqlarguments = new SqlArguments(uri);
        l = dbHelper.getWritableDatabase().insert(sqlarguments.table, null, contentvalues);
        if (l >= 0L) goto _L4; else goto _L3
_L3:
        uri = obj;
_L6:
        this;
        JVM INSTR monitorexit ;
        return uri;
_L2:
        contentvalues = new ContentValues(contentvalues);
          goto _L5
_L4:
        uri = ContentUris.withAppendedId(uri, l);
        sendNotify(uri);
          goto _L6
        uri;
        throw uri;
          goto _L5
    }

    public boolean onCreate()
    {
        AppSettings.init(getContext());
        dbHelper = new DatabaseHelper(getContext());
        return true;
    }

    public Cursor query(Uri uri, String as[], String s, String as1[], String s1)
    {
        s = new SqlArguments(uri, s, as1);
        as1 = new SQLiteQueryBuilder();
        as1.setTables(((SqlArguments) (s)).table);
        as = as1.query(dbHelper.getReadableDatabase(), as, ((SqlArguments) (s)).where, ((SqlArguments) (s)).args, null, null, s1);
        as.setNotificationUri(getContext().getContentResolver(), uri);
        return as;
    }

    public int update(Uri uri, ContentValues contentvalues, String s, String as[])
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        validateUri(uri);
        s = new SqlArguments(uri, s, as);
        i = dbHelper.getWritableDatabase().update(((SqlArguments) (s)).table, contentvalues, ((SqlArguments) (s)).where, ((SqlArguments) (s)).args);
        if (i <= 0)
        {
            break MISSING_BLOCK_LABEL_54;
        }
        sendNotify(uri);
        this;
        JVM INSTR monitorexit ;
        return i;
        uri;
        throw uri;
    }

    static 
    {
        sUriMatcher = new UriMatcher(-1);
        sUriMatcher.addURI("com.ebay.mobile.providers.itemcacheprovider", "item", 1);
        sUriMatcher.addURI("com.ebay.mobile.providers.itemcacheprovider", "list", 2);
        sUriMatcher.addURI("com.ebay.mobile.providers.itemcacheprovider", "event", 3);
        sUriMatcher.addURI("com.ebay.mobile.providers.itemcacheprovider", "saved_search", 4);
        sUriMatcher.addURI("com.ebay.mobile.providers.itemcacheprovider", "name_value", 5);
        sUriMatcher.addURI("com.ebay.mobile.providers.itemcacheprovider", "local_notifications", 6);
    }
}
