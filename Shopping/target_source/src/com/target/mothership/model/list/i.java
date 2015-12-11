// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.list;

import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.SelectArg;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.target.a.a.b;
import com.target.mothership.cache.a;
import com.target.mothership.cache.h;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// Referenced classes of package com.target.mothership.model.list:
//            CacheListMostRecent

public class i extends a
{

    public static final long MAX_MOST_RECENT_COUNT = 20L;
    private static final String TAG = com/target/mothership/model/list/i.getSimpleName();
    private Dao mDao;

    public i()
    {
    }

    private List a(com.target.mothership.model.list.interfaces.ListMostRecent.a a1, long l)
        throws SQLException
    {
        Object obj;
        if (l == -1L)
        {
            obj = null;
        } else
        {
            obj = Long.valueOf(l);
        }
        obj = getDao().queryBuilder().orderBy("mLastModifiedDate", false).limit(((Long) (obj)));
        if (a1 == null)
        {
            a1 = ((QueryBuilder) (obj)).prepare();
        } else
        {
            a1 = ((QueryBuilder) (obj)).where().eq("mType", a1).prepare();
        }
        return getDao().query(a1);
    }

    private void a(ConnectionSource connectionsource)
    {
        try
        {
            mDao = DaoManager.createDao(connectionsource, com/target/mothership/model/list/CacheListMostRecent);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ConnectionSource connectionsource)
        {
            com.target.a.a.b.a(TAG, (new StringBuilder()).append("Unable to create DAO").append(connectionsource.getMessage()).toString());
        }
    }

    private void c(CacheListMostRecent cachelistmostrecent)
        throws SQLException
    {
        getDao().create(cachelistmostrecent);
        long l = getDao().countOf();
        if (getDao().countOf() > 20L)
        {
            cachelistmostrecent = getDao().queryBuilder().orderBy("mLastModifiedDate", true).limit(Long.valueOf(l - 20L)).prepare();
            cachelistmostrecent = getDao().query(cachelistmostrecent);
            getDao().delete(cachelistmostrecent);
        }
    }

    public transient List a(long l, com.target.mothership.model.list.interfaces.ListMostRecent.a aa[])
        throws SQLException
    {
        ArrayList arraylist = new ArrayList();
        int k = aa.length;
        for (int j = 0; j < k; j++)
        {
            arraylist.addAll(a(aa[j], l));
        }

        if (l == -1L || l > (long)arraylist.size())
        {
            return arraylist;
        } else
        {
            return arraylist.subList(0, (int)l);
        }
    }

    public transient List a(com.target.mothership.model.list.interfaces.ListMostRecent.a aa[])
        throws SQLException
    {
        Dao dao = getDao();
        aa = dao.queryBuilder().where().in("mType", aa).query();
        dao.delete(aa);
        return aa;
    }

    public void a(CacheListMostRecent cachelistmostrecent)
        throws SQLException
    {
        cachelistmostrecent.a(null);
        h.update(getDao(), cachelistmostrecent, Integer.valueOf(cachelistmostrecent.a()));
    }

    public void b(CacheListMostRecent cachelistmostrecent)
        throws SQLException
    {
        Object obj = new SelectArg(cachelistmostrecent.b());
        obj = (CacheListMostRecent)getDao().queryBuilder().where().eq("mTitle", obj).and().eq("mType", cachelistmostrecent.c()).queryForFirst();
        if (obj == null)
        {
            c(cachelistmostrecent);
            return;
        } else
        {
            a(((CacheListMostRecent) (obj)));
            return;
        }
    }

    public Dao getDao()
        throws SQLException
    {
        super.getDao();
        if (mDao == null)
        {
            a(h.getInstance().getConnectionSource());
        }
        return mDao;
    }

    public void onCreate(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource)
        throws SQLException
    {
        TableUtils.createTable(connectionsource, com/target/mothership/model/list/CacheListMostRecent);
        a(connectionsource);
    }

    public void onDowngrade(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource, int j, int k)
        throws SQLException
    {
    }

    public void onUpgrade(SQLiteDatabase sqlitedatabase, ConnectionSource connectionsource, int j, int k)
        throws SQLException
    {
    }

}
