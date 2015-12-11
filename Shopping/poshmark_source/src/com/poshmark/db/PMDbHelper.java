// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

public class PMDbHelper extends SQLiteOpenHelper
{

    public static final String COLUMN_CANONICAL_NAME = "canonical_name";
    public static final String COLUMN_CATEGORY_ID = "category_id";
    public static final String COLUMN_DESCRIPTION = "description";
    public static final String COLUMN_FOLLOWING_STATUS = "following";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_INSERT_TIME = "insert_dtm";
    public static final String COLUMN_LAST_UPDATE = "last_update_dtm";
    public static final String COLUMN_LONG_NAME = "long_name";
    public static final String COLUMN_RGB = "rgb";
    public static final String COLUMN_SEARCH_KEYWORD = "keyword";
    public static final String COLUMN_SEARCH_TYPE = "type";
    public static final String COLUMN_SHORT_NAME = "short_name";
    public static final String COLUMN_SUBCATEGORY_NAME = "name";
    public static final String COLUMN_TIMESTAMP_TAG = "tag";
    public static final String COLUMN_USER_ID = "user";
    private static final String DATABASE_NAME = "poshmark_app_Database.db";
    private static final int DATABASE_VERSION = 3;
    public static final String INDEX_BRANDS_CANONICAL_NAME = "canonical_name_index";
    public static final String INDEX_KEYWORD = "search_keyword_index";
    public static final String TABLE_BRANDS = "brands";
    public static final String TABLE_CATEGORY = "category";
    public static final String TABLE_CATEGORY_SIZES = "sizes";
    public static final String TABLE_COLORS = "colors";
    public static final String TABLE_FOLLOWING_BRANDS = "following";
    public static final String TABLE_RECENT_BRANDS = "recent_brands";
    public static final String TABLE_SAVED_SEARCHES = "saved_searches";
    public static final String TABLE_SUBCATEGORY = "subcategory";
    public static final String TABLE_TIMESTAMPS = "timestamps";

    public PMDbHelper(Context context)
    {
        super(context, "poshmark_app_Database.db", null, 3);
    }

    private void createAllTablesAndIndexes(SQLiteDatabase sqlitedatabase)
    {
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("create table category(_id text primary key, canonical_name text not null collate nocase);");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "create table category(_id text primary key, canonical_name text not null collate nocase);");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("create table sizes(_id text not null, short_name text not null collate nocase, long_name text not null collate nocase,  FOREIGN KEY (_id) REFERENCES category (_id));");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "create table sizes(_id text not null, short_name text not null collate nocase, long_name text not null collate nocase,  FOREIGN KEY (_id) REFERENCES category (_id));");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("create table subcategory(_id text not null, name text not null, category_id text not null,  FOREIGN KEY (category_id) REFERENCES category (_id));");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "create table subcategory(_id text not null, name text not null, category_id text not null,  FOREIGN KEY (category_id) REFERENCES category (_id));");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("create table colors(_id text primary key, rgb text not null);");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "create table colors(_id text primary key, rgb text not null);");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("create table brands(_id integer primary key autoincrement, canonical_name text not null collate nocase, description text, following integer);");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "create table brands(_id integer primary key autoincrement, canonical_name text not null collate nocase, description text, following integer);");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("create table following(_id integer primary key autoincrement, user text not null, canonical_name text not null);");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "create table following(_id integer primary key autoincrement, user text not null, canonical_name text not null);");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("create table timestamps(tag text not null, last_update_dtm text not null);");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "create table timestamps(tag text not null, last_update_dtm text not null);");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("create table recent_brands(_id integer primary key autoincrement, user text not null, canonical_name text not null, insert_dtm text not null);");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "create table recent_brands(_id integer primary key autoincrement, user text not null, canonical_name text not null, insert_dtm text not null);");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("create index canonical_name_index on brands(canonical_name);");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "create index canonical_name_index on brands(canonical_name);");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("create table saved_searches(_id integer primary key autoincrement, user text not null, keyword text not null, type text, insert_dtm text not null);");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "create table saved_searches(_id integer primary key autoincrement, user text not null, keyword text not null, type text, insert_dtm text not null);");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("create index search_keyword_index on saved_searches(keyword);");
            return;
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "create index search_keyword_index on saved_searches(keyword);");
            return;
        }
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        createAllTablesAndIndexes(sqlitedatabase);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        switch (i)
        {
        default:
            return;

        case 2: // '\002'
        case 3: // '\003'
            break;
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("create table category(_id text primary key, canonical_name text not null collate nocase);");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "create table category(_id text primary key, canonical_name text not null collate nocase);");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("create table sizes(_id text not null, short_name text not null collate nocase, long_name text not null collate nocase,  FOREIGN KEY (_id) REFERENCES category (_id));");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "create table sizes(_id text not null, short_name text not null collate nocase, long_name text not null collate nocase,  FOREIGN KEY (_id) REFERENCES category (_id));");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("create table subcategory(_id text not null, name text not null, category_id text not null,  FOREIGN KEY (category_id) REFERENCES category (_id));");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "create table subcategory(_id text not null, name text not null, category_id text not null,  FOREIGN KEY (category_id) REFERENCES category (_id));");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("create table colors(_id text primary key, rgb text not null);");
            return;
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "create table colors(_id text primary key, rgb text not null);");
            return;
        }
    }
}
