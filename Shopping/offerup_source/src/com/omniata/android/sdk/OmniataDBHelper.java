// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.omniata.android.sdk;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

class OmniataDBHelper extends SQLiteOpenHelper
{

    private static final String DATABASE_NAME = "omniata.db";
    private static final int DATABASE_VERSION = 1;
    private String name;

    public OmniataDBHelper(Context context, String s)
    {
        super(context, "omniata.db", null, 1);
        name = s;
    }

    public static Cursor all(SQLiteDatabase sqlitedatabase, String s)
    {
        return sqlitedatabase.rawQuery((new StringBuilder("SELECT id, data FROM ")).append(s).append(";").toString(), null);
    }

    public static int delete(SQLiteDatabase sqlitedatabase, String s, int i)
    {
        return sqlitedatabase.delete(s, "id = ?", new String[] {
            String.valueOf(i)
        });
    }

    public static void deleteAll(SQLiteDatabase sqlitedatabase, String s)
    {
        sqlitedatabase.delete(s, null, null);
    }

    public static Cursor first(SQLiteDatabase sqlitedatabase, String s)
    {
        return sqlitedatabase.rawQuery((new StringBuilder("SELECT id, data FROM ")).append(s).append(" LIMIT 1;").toString(), null);
    }

    public static long insert(SQLiteDatabase sqlitedatabase, String s, String s1)
    {
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("data", s1);
        return sqlitedatabase.insert(s, null, contentvalues);
    }

    public static void resetAutoIncrement(SQLiteDatabase sqlitedatabase, String s)
    {
        sqlitedatabase.delete("sqlite_sequence", "name = ?", new String[] {
            s
        });
    }

    public static int size(SQLiteDatabase sqlitedatabase, String s)
    {
        sqlitedatabase = sqlitedatabase.rawQuery((new StringBuilder("SELECT count(id) FROM ")).append(s).append(";").toString(), null);
        sqlitedatabase.moveToFirst();
        int i = sqlitedatabase.getInt(0);
        sqlitedatabase.close();
        return i;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL((new StringBuilder("CREATE TABLE ")).append(name).append("(id INTEGER PRIMARY KEY AUTOINCREMENT,data TEXT);").toString());
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
    }
}
