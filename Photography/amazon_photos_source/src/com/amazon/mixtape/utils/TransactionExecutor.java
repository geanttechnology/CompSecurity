// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.utils;

import android.database.sqlite.SQLiteDatabase;

public class TransactionExecutor
{

    private final SQLiteDatabase mDatabase;

    public TransactionExecutor(SQLiteDatabase sqlitedatabase)
    {
        mDatabase = sqlitedatabase;
    }

    public void execute(Runnable runnable)
    {
        if (android.os.Build.VERSION.SDK_INT >= 11)
        {
            mDatabase.beginTransactionNonExclusive();
        } else
        {
            mDatabase.beginTransaction();
        }
        runnable.run();
        mDatabase.setTransactionSuccessful();
        mDatabase.endTransaction();
        return;
        runnable;
        mDatabase.endTransaction();
        throw runnable;
    }
}
