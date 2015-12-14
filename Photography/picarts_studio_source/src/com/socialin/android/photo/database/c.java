// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.socialin.android.photo.database;

import android.content.Context;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public final class c extends SQLiteOpenHelper
{

    private String a;
    private String b;
    private String c;
    private String d;
    private String e;
    private String f;

    public c(Context context)
    {
        super(context, "picsart.db", null, 16);
        a = "create table notifications (_id integer primary key, notification_id text unique not null,  notification_item blob not null, created_at integer not null, read integer default 0)";
        b = "CREATE TRIGGER notification_row_limit AFTER INSERT ON notifications BEGIN DELETE FROM notifications WHERE _id IN (SELECT _id FROM notifications ORDER BY _id DESC LIMIT 200, -1);END";
        c = "create table uploads (_id integer primary key AUTOINCREMENT, upload_status integer not null,  upload_item blob not null, created_at integer not null)";
        d = "create table addtext (_id integer primary key AUTOINCREMENT, addtext_addedtext text unique not null,  addtext_usage integer not null default 1, addtext_created_at integer default null)";
        e = "CREATE TRIGGER addtext_row_limit AFTER INSERT ON addtext BEGIN DELETE FROM addtext WHERE _id IN (SELECT _id FROM addtext ORDER BY _id DESC LIMIT 100, -1);END";
        f = null;
        context = context.getResources().getStringArray(0x7f090006);
        f = (new StringBuilder("insert into addtext (addtext_addedtext)  SELECT '")).append(context[0]).append("' AS addtext_addedtext").toString();
        for (int i = 1; i < context.length; i++)
        {
            f = (new StringBuilder()).append(f).append(" UNION SELECT '").append(context[i]).append("'").toString();
        }

    }

    public final void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL(a);
        sqlitedatabase.execSQL(b);
        sqlitedatabase.execSQL(c);
        sqlitedatabase.execSQL(d);
        sqlitedatabase.execSQL(e);
        sqlitedatabase.execSQL(f);
    }

    public final void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
label0:
        {
            (new StringBuilder("oldVersion: ")).append(i).append(" newVersion: ").append(j).append(" dbVersion: 16");
            if (i != j)
            {
                if (j < 8)
                {
                    break label0;
                }
                sqlitedatabase.execSQL("DROP TABLE IF EXISTS uploads");
                sqlitedatabase.execSQL(c);
                sqlitedatabase.execSQL("DROP TABLE IF EXISTS addtext");
                sqlitedatabase.execSQL(d);
                sqlitedatabase.execSQL(f);
            }
            return;
        }
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS notifications");
        sqlitedatabase.execSQL("DROP TRIGGER IF EXISTS notification_row_limit");
        sqlitedatabase.execSQL("DROP TABLE IF EXISTS uploads");
        onCreate(sqlitedatabase);
    }
}
