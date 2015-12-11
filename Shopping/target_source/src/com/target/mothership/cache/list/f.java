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
import com.target.mothership.cache.e;
import com.target.mothership.cache.g;
import com.target.mothership.cache.h;
import com.target.mothership.model.guest.interfaces.GuestBase;
import java.sql.SQLException;
import java.util.concurrent.Callable;

// Referenced classes of package com.target.mothership.cache.list:
//            CacheListSummary, g

public class f extends a
{

    private static final String TAG = com/target/mothership/cache/list/f.getSimpleName();
    private Dao mDao;

    public f()
    {
    }

    private void createDao(ConnectionSource connectionsource)
    {
        try
        {
            mDao = DaoManager.createDao(connectionsource, com/target/mothership/cache/list/CacheListSummary);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ConnectionSource connectionsource)
        {
            b.a(TAG, (new StringBuilder()).append("Unable to create DAO").append(connectionsource.getMessage()).toString());
        }
    }

    private void createDefaultListQueue(final GuestBase guest)
        throws SQLException
    {
        e.getInstance().add(new Callable() {

            final f this$0;
            final GuestBase val$guest;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                createDefaultList(guest);
                return null;
            }

            
            {
                this$0 = f.this;
                guest = guestbase;
                super();
            }
        });
    }

    void createDefaultList(GuestBase guestbase)
        throws SQLException
    {
        CacheListSummary cachelistsummary = new CacheListSummary();
        cachelistsummary.setChannel(com.target.mothership.common.c.b.MOBILE);
        cachelistsummary.setDefaultList(true);
        cachelistsummary.setDescription("Mobile Shopping List");
        cachelistsummary.setTitle("Mobile Shopping List");
        cachelistsummary.setResourceId("default_list_title");
        cachelistsummary.setGuestId(guestbase.getGuestId());
        getDao().create(cachelistsummary);
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
        TableUtils.createTable(connectionsource, com/target/mothership/cache/list/CacheListSummary);
        createDao(connectionsource);
        createDefaultListQueue(com.target.mothership.model.guest.b.a());
    }

    public void onDowngrade(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource, int i, int j)
        throws SQLException
    {
        g.getMigrationSet().revert(sqlitedatabase, i, j);
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource, int i, int j)
        throws SQLException
    {
        g.getMigrationSet().apply(sqlitedatabase, i, j);
    }

}
