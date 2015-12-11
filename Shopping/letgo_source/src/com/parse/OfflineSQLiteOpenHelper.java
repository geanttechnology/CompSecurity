// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

// Referenced classes of package com.parse:
//            ParseSQLiteOpenHelper

class OfflineSQLiteOpenHelper extends ParseSQLiteOpenHelper
{

    private static final String DATABASE_NAME = "ParseOfflineStore";
    private static final int DATABASE_VERSION = 4;
    static final String KEY_CLASS_NAME = "className";
    static final String KEY_IS_DELETING_EVENTUALLY = "isDeletingEventually";
    static final String KEY_JSON = "json";
    static final String KEY_KEY = "key";
    static final String KEY_OBJECT_ID = "objectId";
    static final String KEY_UUID = "uuid";
    static final String TABLE_DEPENDENCIES = "Dependencies";
    static final String TABLE_OBJECTS = "ParseObjects";

    public OfflineSQLiteOpenHelper(Context context)
    {
        super(context, "ParseOfflineStore", null, 4);
    }

    private void createSchema(SQLiteDatabase sqlitedatabase)
    {
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("CREATE TABLE ParseObjects (uuid TEXT PRIMARY KEY, className TEXT NOT NULL, objectId TEXT, json TEXT, isDeletingEventually INTEGER DEFAULT 0, UNIQUE(className, objectId));");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "CREATE TABLE ParseObjects (uuid TEXT PRIMARY KEY, className TEXT NOT NULL, objectId TEXT, json TEXT, isDeletingEventually INTEGER DEFAULT 0, UNIQUE(className, objectId));");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("CREATE TABLE Dependencies (key TEXT NOT NULL, uuid TEXT NOT NULL, PRIMARY KEY(key, uuid));");
            return;
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "CREATE TABLE Dependencies (key TEXT NOT NULL, uuid TEXT NOT NULL, PRIMARY KEY(key, uuid));");
            return;
        }
    }

    public void clearDatabase(Context context)
    {
        context.deleteDatabase("ParseOfflineStore");
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        createSchema(sqlitedatabase);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
    }
}
