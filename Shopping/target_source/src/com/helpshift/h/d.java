// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.helpshift.h;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;

public class d extends SQLiteOpenHelper
{

    private static final Integer a = Integer.valueOf(1);

    public d(Context context)
    {
        super(context, "__hs__db_issues", null, a.intValue());
    }

    public void a(SQLiteDatabase sqlitedatabase)
    {
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS issues");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "DROP TABLE IF EXISTS issues");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("DROP TABLE IF EXISTS messages");
            return;
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "DROP TABLE IF EXISTS messages");
            return;
        }
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("CREATE TABLE issues (_id INTEGER PRIMARY KEY AUTOINCREMENT,profile_id TEXT NOT NULL,issue_id TEXT NOT NULL UNIQUE,body TEXT,title TEXT NOT NULL,created_at TEXT NOT NULL,updated_at TEXT NOT NULL,status INTEGER NOT NULL,new_message_count INTEGER,show_agent_name INTEGER);");
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "CREATE TABLE issues (_id INTEGER PRIMARY KEY AUTOINCREMENT,profile_id TEXT NOT NULL,issue_id TEXT NOT NULL UNIQUE,body TEXT,title TEXT NOT NULL,created_at TEXT NOT NULL,updated_at TEXT NOT NULL,status INTEGER NOT NULL,new_message_count INTEGER,show_agent_name INTEGER);");
        }
        if (!(sqlitedatabase instanceof SQLiteDatabase))
        {
            sqlitedatabase.execSQL("CREATE TABLE messages (_id INTEGER PRIMARY KEY AUTOINCREMENT,issue_id TEXT NOT NULL,message_id TEXT NOT NULL UNIQUE,body TEXT,origin TEXT NOT NULL,type TEXT NOT NULL,created_at TEXT NOT NULL,author TEXT,meta TEXT,screenshot TEXT,message_seen INTEGER,invisible INTEGER,in_progress INTEGER);");
            return;
        } else
        {
            SQLiteInstrumentation.execSQL((SQLiteDatabase)sqlitedatabase, "CREATE TABLE messages (_id INTEGER PRIMARY KEY AUTOINCREMENT,issue_id TEXT NOT NULL,message_id TEXT NOT NULL UNIQUE,body TEXT,origin TEXT NOT NULL,type TEXT NOT NULL,created_at TEXT NOT NULL,author TEXT,meta TEXT,screenshot TEXT,message_seen INTEGER,invisible INTEGER,in_progress INTEGER);");
            return;
        }
    }

    public void onDowngrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        a(sqlitedatabase);
        onCreate(sqlitedatabase);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        a(sqlitedatabase);
        onCreate(sqlitedatabase);
    }

}
