// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.penthera.virtuososdk.database.impl;

import android.database.sqlite.SQLiteCursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQuery;

// Referenced classes of package com.penthera.virtuososdk.database.impl:
//            VSdkDb

class VirtuosoSDKSQLiteCursor extends SQLiteCursor
{

    private static String LOG_TAG = com/penthera/virtuososdk/database/impl/VirtuosoSDKSQLiteCursor.getName();
    private static int counter = 0;

    public VirtuosoSDKSQLiteCursor(SQLiteDatabase sqlitedatabase, SQLiteCursorDriver sqlitecursordriver, String s, SQLiteQuery sqlitequery)
    {
        super(sqlitedatabase, sqlitecursordriver, s, sqlitequery);
        int i = incCounter();
        if (i > 25)
        {
            com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("Cursor created, open: ")).append(i).toString());
        }
    }

    private int decCounter()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        counter--;
        if (counter == 0 && VSdkDb.getHelper() != null)
        {
            VSdkDb.getHelper().setCloseRequested(true);
        }
        i = counter;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    private int incCounter()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        if (counter == 0)
        {
            VSdkDb.getHelper().setCloseRequested(false);
        }
        i = counter + 1;
        counter = i;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public void close()
    {
        this;
        JVM INSTR monitorenter ;
        int i;
        if (isClosed())
        {
            break MISSING_BLOCK_LABEL_46;
        }
        super.close();
        i = decCounter();
        if (i <= 25)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        com.penthera.virtuososdk.utility.CommonUtil.Log.d(LOG_TAG, (new StringBuilder("Cursor closed, open: ")).append(i).toString());
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

}
