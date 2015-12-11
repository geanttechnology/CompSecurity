// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.AndroidConnectionSource;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.support.ConnectionSource;
import com.target.a.a.b;
import com.target.mothership.c;
import com.target.mothership.cache.guest.a;
import com.target.mothership.cache.list.f;
import com.target.mothership.model.list.i;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

public class h extends OrmLiteSqliteOpenHelper
{
    public static interface a
    {

        public abstract void onCreate();

        public abstract void onDowngrade();

        public abstract void onUpgrade();
    }


    private static final String DATABASE_NAME = "mothership_ormlite.db";
    private static final int DATABASE_VERSION = 6;
    private static String sDatabaseName = "mothership_ormlite.db";
    private static h sInstance;
    private ConnectionSource mConnectionSource;
    private com.target.mothership.cache.guest.a mGuestAccessor;
    private com.target.mothership.cache.list.c mListItemAccessor;
    private i mListMostRecentAccessor;
    private f mListSummaryAccessor;
    private ArrayList mListeners;

    private h()
    {
        super(c.c(), sDatabaseName, null, 6);
        mConnectionSource = new AndroidConnectionSource(this);
        mListSummaryAccessor = new f();
        mListItemAccessor = new com.target.mothership.cache.list.c();
        mListMostRecentAccessor = new i();
        mGuestAccessor = new com.target.mothership.cache.guest.a();
        mListeners = new ArrayList();
    }

    public static void deleteDatabase()
    {
        c.c().deleteDatabase("mothership_ormlite.db");
    }

    public static h getInstance()
    {
        if (sInstance == null)
        {
            sInstance = new h();
        }
        return sInstance;
    }

    public static void update(Dao dao, Object obj, Object obj1)
        throws SQLException
    {
        dao.delete(obj);
        dao.create(obj);
        dao.updateId(obj, obj1);
    }

    public void addSessionListener(a a1)
    {
        if (a1 == null)
        {
            throw new IllegalArgumentException("listener must not be null");
        } else
        {
            mListeners.add(a1);
            return;
        }
    }

    public void close()
    {
        super.close();
        sInstance = null;
    }

    public ConnectionSource getConnectionSource()
    {
        return mConnectionSource;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource)
    {
        try
        {
            b.c(getClass().getName(), "onCreate");
            mListSummaryAccessor.onCreate(sqlitedatabase, connectionsource);
            mListItemAccessor.onCreate(sqlitedatabase, connectionsource);
            mListMostRecentAccessor.onCreate(sqlitedatabase, connectionsource);
            mGuestAccessor.onCreate(sqlitedatabase, connectionsource);
            break MISSING_BLOCK_LABEL_48;
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase) { }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase) { }
        b.a(getClass().getName(), "Can't create database", sqlitedatabase);
        throw new RuntimeException(sqlitedatabase);
        if (mListeners != null)
        {
            for (sqlitedatabase = mListeners.iterator(); sqlitedatabase.hasNext(); ((a)sqlitedatabase.next()).onCreate()) { }
        }
        return;
    }

    public void onDowngrade(SQLiteDatabase sqlitedatabase, int j, int k)
    {
        try
        {
            mListSummaryAccessor.onDowngrade(sqlitedatabase, connectionSource, j, k);
            mListItemAccessor.onDowngrade(sqlitedatabase, connectionSource, j, k);
            mListMostRecentAccessor.onDowngrade(sqlitedatabase, connectionSource, j, k);
            mGuestAccessor.onDowngrade(sqlitedatabase, connectionSource, j, k);
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            b.a(getClass().getName(), "Can't create database", sqlitedatabase);
            throw new RuntimeException(sqlitedatabase);
        }
        if (mListeners != null)
        {
            for (sqlitedatabase = mListeners.iterator(); sqlitedatabase.hasNext(); ((a)sqlitedatabase.next()).onDowngrade()) { }
        }
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource, int j, int k)
    {
        try
        {
            mListSummaryAccessor.onUpgrade(sqlitedatabase, connectionsource, j, k);
            mListItemAccessor.onUpgrade(sqlitedatabase, connectionsource, j, k);
            mListMostRecentAccessor.onUpgrade(sqlitedatabase, connectionsource, j, k);
            mGuestAccessor.onUpgrade(sqlitedatabase, connectionsource, j, k);
        }
        // Misplaced declaration of an exception variable
        catch (SQLiteDatabase sqlitedatabase)
        {
            b.a(getClass().getName(), "Can't create database", sqlitedatabase);
            throw new RuntimeException(sqlitedatabase);
        }
        if (mListeners != null)
        {
            for (sqlitedatabase = mListeners.iterator(); sqlitedatabase.hasNext(); ((a)sqlitedatabase.next()).onUpgrade()) { }
        }
    }

    public void removeSessionListener(a a1)
    {
        mListeners.remove(a1);
    }

}
