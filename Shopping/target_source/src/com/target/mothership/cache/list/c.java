// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.cache.list;

import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.target.a.a.b;
import com.target.mothership.cache.a;
import com.target.mothership.cache.g;
import com.target.mothership.cache.h;
import java.sql.SQLException;

// Referenced classes of package com.target.mothership.cache.list:
//            CacheListItem, d

public class c extends a
{

    private static final String TAG = com/target/mothership/cache/list/c.getSimpleName();
    private Dao mDao;

    public c()
    {
    }

    private void createDao(ConnectionSource connectionsource)
    {
        try
        {
            mDao = DaoManager.createDao(connectionsource, com/target/mothership/cache/list/CacheListItem);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ConnectionSource connectionsource)
        {
            b.a(TAG, (new StringBuilder()).append("unable to create the DAO. Exception: ").append(connectionsource.getMessage()).toString());
        }
    }

    public Dao getDao()
        throws SQLException
    {
        super.getDao();
        if (mDao == null)
        {
            createDao(h.getInstance().getConnectionSource());
        }
        return mDao;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource)
        throws SQLException
    {
        TableUtils.createTable(connectionsource, com/target/mothership/cache/list/CacheListItem);
        createDao(connectionsource);
    }

    public void onDowngrade(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource, int i, int j)
        throws SQLException
    {
        d.getMigrationSet().revert(sqlitedatabase, i, j);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource, int i, int j)
        throws SQLException
    {
        d.getMigrationSet().apply(sqlitedatabase, i, j);
    }

}
