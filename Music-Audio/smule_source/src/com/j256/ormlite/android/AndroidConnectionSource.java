// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.android;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.db.SqliteAndroidDatabaseType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.BaseConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;

// Referenced classes of package com.j256.ormlite.android:
//            AndroidDatabaseConnection

public class AndroidConnectionSource extends BaseConnectionSource
    implements ConnectionSource
{

    private static final Logger logger = LoggerFactory.getLogger(com/j256/ormlite/android/AndroidConnectionSource);
    private AndroidDatabaseConnection connection;
    private final DatabaseType databaseType;
    private final SQLiteOpenHelper helper;
    private volatile boolean isOpen;
    private final SQLiteDatabase sqliteDatabase;

    public AndroidConnectionSource(SQLiteDatabase sqlitedatabase)
    {
        connection = null;
        isOpen = true;
        databaseType = new SqliteAndroidDatabaseType();
        helper = null;
        sqliteDatabase = sqlitedatabase;
    }

    public AndroidConnectionSource(SQLiteOpenHelper sqliteopenhelper)
    {
        connection = null;
        isOpen = true;
        databaseType = new SqliteAndroidDatabaseType();
        helper = sqliteopenhelper;
        sqliteDatabase = null;
    }

    public void clearSpecialConnection(DatabaseConnection databaseconnection)
    {
        clearSpecial(databaseconnection, logger);
    }

    public void close()
    {
        isOpen = false;
    }

    public DatabaseType getDatabaseType()
    {
        return databaseType;
    }

    public DatabaseConnection getReadOnlyConnection()
    {
        return getReadWriteConnection();
    }

    public DatabaseConnection getReadWriteConnection()
    {
        DatabaseConnection databaseconnection = getSavedConnection();
        if (databaseconnection != null)
        {
            return databaseconnection;
        }
        if (connection == null)
        {
            if (sqliteDatabase == null)
            {
                connection = new AndroidDatabaseConnection(helper.getWritableDatabase(), true);
            } else
            {
                connection = new AndroidDatabaseConnection(sqliteDatabase, true);
            }
        }
        return connection;
    }

    public boolean isOpen()
    {
        return isOpen;
    }

    public void releaseConnection(DatabaseConnection databaseconnection)
    {
    }

    public boolean saveSpecialConnection(DatabaseConnection databaseconnection)
    {
        return saveSpecial(databaseconnection);
    }

}
