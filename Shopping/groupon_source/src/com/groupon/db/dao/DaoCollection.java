// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import android.app.Application;
import android.content.Context;
import com.groupon.db.models.DealCollection;
import com.j256.ormlite.dao.CloseableIterator;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao, DaoCollectionCardAttribute

public class DaoCollection extends GrouponBaseDao
{

    private Lazy cardAttributeDao;

    public DaoCollection(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        super(connectionsource, databasetableconfig);
    }

    private void remove(CloseableIterator closeableiterator)
        throws SQLException
    {
        for (; closeableiterator.hasNext(); delete((DealCollection)closeableiterator.nextThrow())) { }
        break MISSING_BLOCK_LABEL_35;
        Exception exception;
        exception;
        closeableiterator.close();
        throw exception;
        closeableiterator.close();
        return;
    }

    public int create(DealCollection dealcollection)
        throws SQLException
    {
        int i = super.create(dealcollection);
        if (i == 1)
        {
            ((DaoCollectionCardAttribute)cardAttributeDao.get()).save(dealcollection.getCardDetails());
        }
        return i;
    }

    public volatile int create(Object obj)
        throws SQLException
    {
        return create((DealCollection)obj);
    }

    public int delete(DealCollection dealcollection)
        throws SQLException
    {
        ((DaoCollectionCardAttribute)cardAttributeDao.get()).clearByParentUUID(dealcollection.getParentUUID());
        return super.delete(dealcollection);
    }

    public volatile int delete(Object obj)
        throws SQLException
    {
        return delete((DealCollection)obj);
    }

    public void deleteByChannelId(String s)
        throws SQLException
    {
        remove(queryBuilder().where().eq("channel", s).iterator());
    }

    public void deleteByChannelPrefix(String s)
        throws SQLException
    {
        remove(queryBuilder().where().eq("channel", (new StringBuilder()).append(s).append('%').toString()).iterator());
    }

    public void remove(DealCollection dealcollection)
        throws SQLException
    {
        remove(queryBuilder().where().eq("channel", dealcollection.channel).and().eq("uuid", dealcollection.uuid).iterator());
    }

    public void save(DealCollection dealcollection)
        throws SQLException
    {
        remove(dealcollection);
        create(dealcollection);
    }

    public void setApplication(Application application)
    {
        super.setApplication(application);
        cardAttributeDao = new Lazy(application) {

            final DaoCollection this$0;

            
            {
                this$0 = DaoCollection.this;
                super(context);
            }
        };
    }
}
