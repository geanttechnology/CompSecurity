// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache.guest;

import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.target.a.a.b;
import com.target.mothership.cache.h;
import com.target.mothership.model.guest.interfaces.Guest;
import java.sql.SQLException;

// Referenced classes of package com.target.mothership.cache.guest:
//            c, CacheAccountDetails, CacheGuest

public class a extends com.target.mothership.cache.a
{

    private static final String TAG = com/target/mothership/cache/guest/a.getSimpleName();
    private Dao mAccountDetailsDao;
    private Dao mGuestDao;
    private c mGuestDatabaseUtil;

    public a()
    {
        mGuestDatabaseUtil = new c();
    }

    private void createAccountDetailsDao(ConnectionSource connectionsource)
    {
        try
        {
            mAccountDetailsDao = DaoManager.createDao(connectionsource, com/target/mothership/cache/guest/CacheAccountDetails);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ConnectionSource connectionsource)
        {
            b.a(TAG, (new StringBuilder()).append("failed to create account details DAO.  Exception: ").append(connectionsource.getMessage()).toString());
        }
    }

    private void createGuestDao(ConnectionSource connectionsource)
    {
        try
        {
            mGuestDao = DaoManager.createDao(connectionsource, com/target/mothership/cache/guest/CacheGuest);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ConnectionSource connectionsource)
        {
            b.a(TAG, (new StringBuilder()).append("unable to create the DAO. Exception: ").append(connectionsource.getMessage()).toString());
        }
    }

    public void clearGuest(Guest guest, com.target.mothership.model.h h1)
    {
        mGuestDatabaseUtil.clearGuest(guest, h1);
    }

    public Dao getAccountDetailsDao()
        throws SQLException
    {
        if (mAccountDetailsDao == null)
        {
            createAccountDetailsDao(h.getInstance().getConnectionSource());
        }
        return mAccountDetailsDao;
    }

    public Dao getDao()
        throws SQLException
    {
        super.getDao();
        if (mGuestDao == null)
        {
            createGuestDao(h.getInstance().getConnectionSource());
        }
        return mGuestDao;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource)
        throws SQLException
    {
        TableUtils.createTable(connectionsource, com/target/mothership/cache/guest/CacheGuest);
        TableUtils.createTable(connectionsource, com/target/mothership/cache/guest/CacheAccountDetails);
        createGuestDao(connectionsource);
    }

    public void onDowngrade(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource, int i, int j)
        throws SQLException
    {
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource, int i, int j)
        throws SQLException
    {
    }

    public void readGuest(com.target.mothership.model.h h1)
    {
        mGuestDatabaseUtil.readGuest(h1);
    }

    public void writeGuest(Guest guest, com.target.mothership.model.h h1)
    {
        mGuestDatabaseUtil.writeGuest(guest, h1);
    }

}
