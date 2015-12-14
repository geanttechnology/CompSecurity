// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AccountsDatabaseHelper extends SQLiteOpenHelper
{

    public AccountsDatabaseHelper(Context context)
    {
        super(context, "mixtape_accounts.db", null, 1);
    }

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        sqlitedatabase.execSQL("CREATE TABLE accounts (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, type TEXT, directed_id TEXT UNIQUE)");
        sqlitedatabase.execSQL("CREATE INDEX idx_accounts_n_t ON accounts (name, type)");
        sqlitedatabase.execSQL("CREATE INDEX idx_accounts_did ON accounts (directed_id)");
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
    }
}
