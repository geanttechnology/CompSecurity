// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache;

import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import java.sql.SQLException;

public abstract class a
{

    private static SQLException mSqlException;

    public a()
    {
    }

    protected static SQLException getSqlError()
    {
        return mSqlException;
    }

    public static void setSqlException(SQLException sqlexception)
    {
        mSqlException = sqlexception;
    }

    public Dao getDao()
        throws SQLException
    {
        if (mSqlException != null)
        {
            throw mSqlException;
        } else
        {
            return null;
        }
    }

    public abstract void onCreate(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource)
        throws SQLException;

    public abstract void onDowngrade(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource, int i, int j)
        throws SQLException;

    public abstract void onUpgrade(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource, int i, int j)
        throws SQLException;
}
