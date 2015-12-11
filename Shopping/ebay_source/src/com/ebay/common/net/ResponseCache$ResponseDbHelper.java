// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

// Referenced classes of package com.ebay.common.net:
//            ResponseCache

private static class y extends SQLiteOpenHelper
{

    public static final String DB_NAME = "responses_db";
    public static final int DB_VERSION = 1;

    public void onCreate(SQLiteDatabase sqlitedatabase)
    {
        try
        {
            sqlitedatabase.execSQL("CREATE TABLE responses( id INTEGER PRIMARY KEY, name TEXT NOT NULL, response TEXT NOT NULL, expiration DATETIME)");
            sqlitedatabase.execSQL("CREATE INDEX responses_name ON responses (name)");
            sqlitedatabase.execSQL("CREATE INDEX responses_expiration ON responses (expiration)");
            return;
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            Log.e("ResponseCache", sqlitedatabase.toString());
        }
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, int i, int j)
    {
        throw new UnsupportedOperationException();
    }

    public y(Context context)
    {
        super(context, "responses_db", null, 1);
    }
}
