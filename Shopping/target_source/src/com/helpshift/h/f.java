// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.h;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

public class f extends SQLiteOpenHelper
{

    public f(Context context)
    {
        super(context, "__hs__db_profiles", null, 1);
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("CREATE TABLE profiles(_id INTEGER PRIMARY KEY AUTOINCREMENT, identifier TEXT NOT NULL UNIQUE, profile_id TEXT UNIQUE, name TEXT, email TEXT, salt TEXT);");
            return;
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "CREATE TABLE profiles(_id INTEGER PRIMARY KEY AUTOINCREMENT, identifier TEXT NOT NULL UNIQUE, profile_id TEXT UNIQUE, name TEXT, email TEXT, salt TEXT);");
            return;
        }
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS profiles");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "DROP TABLE IF EXISTS profiles");
        }
        onCreate(sqlitedatabase);
    }
}
