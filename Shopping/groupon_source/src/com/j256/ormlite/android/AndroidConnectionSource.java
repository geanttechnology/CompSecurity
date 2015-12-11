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
import com.j256.ormlite.misc.SqlExceptionUtil;
import com.j256.ormlite.support.BaseConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.android:
//            AndroidDatabaseConnection

public class AndroidConnectionSource extends BaseConnectionSource
    implements ConnectionSource
{

    private static final Logger logger = LoggerFactory.getLogger(com/j256/ormlite/android/AndroidConnectionSource);
    private AndroidDatabaseConnection connection;
    private final DatabaseType databaseType = new SqliteAndroidDatabaseType();
    private final SQLiteOpenHelper helper;
    private volatile boolean isOpen;
    private final SQLiteDatabase sqliteDatabase = null;

    public AndroidConnectionSource(SQLiteOpenHelper sqliteopenhelper)
    {
        connection = null;
        isOpen = true;
        helper = sqliteopenhelper;
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
        throws SQLException
    {
        return getReadWriteConnection();
    }

    public DatabaseConnection getReadWriteConnection()
        throws SQLException
    {
        DatabaseConnection databaseconnection = getSavedConnection();
        if (databaseconnection != null)
        {
            return databaseconnection;
        }
        if (connection == null)
        {
            Object obj;
            if (sqliteDatabase == null)
            {
                try
                {
                    obj = helper.getWritableDatabase();
                }
                // Misplaced declaration of an exception variable
                catch (Object obj)
                {
                    throw SqlExceptionUtil.create((new StringBuilder()).append("Getting a writable database from helper ").append(helper).append(" failed").toString(), ((Throwable) (obj)));
                }
            } else
            {
                obj = sqliteDatabase;
            }
            connection = new AndroidDatabaseConnection(((SQLiteDatabase) (obj)), true);
            logger.trace("created connection {} for db {}, helper {}", connection, obj, helper);
        } else
        {
            logger.trace("{}: returning read-write connection {}, helper {}", this, connection, helper);
        }
        return connection;
    }

    public void releaseConnection(DatabaseConnection databaseconnection)
    {
    }

    public boolean saveSpecialConnection(DatabaseConnection databaseconnection)
        throws SQLException
    {
        return saveSpecial(databaseconnection);
    }

    public String toString()
    {
        return (new StringBuilder()).append(getClass().getSimpleName()).append("@").append(Integer.toHexString(super.hashCode())).toString();
    }

}
