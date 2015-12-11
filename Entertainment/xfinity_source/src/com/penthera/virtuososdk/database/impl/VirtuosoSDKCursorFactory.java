// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.database.impl;

import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;

// Referenced classes of package com.penthera.virtuososdk.database.impl:
//            VirtuosoSDKSQLiteCursor

class VirtuosoSDKCursorFactory
    implements android.database.sqlite.SQLiteDatabase.CursorFactory
{

    VirtuosoSDKCursorFactory()
    {
    }

    public Cursor newCursor(SQLiteDatabase sqlitedatabase, SQLiteCursorDriver sqlitecursordriver, String s, SQLiteQuery sqlitequery)
    {
        return new VirtuosoSDKSQLiteCursor(sqlitedatabase, sqlitecursordriver, s, sqlitequery);
    }
}
