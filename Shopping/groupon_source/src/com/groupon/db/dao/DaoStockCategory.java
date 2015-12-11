// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import android.app.Application;
import android.content.Context;
import com.groupon.db.models.StockCategory;
import com.groupon.db.models.StockValue;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import roboguice.inject.Lazy;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao, DaoStockValue

public class DaoStockCategory extends GrouponBaseDao
{

    private Lazy stockValueDao;

    public DaoStockCategory(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        super(connectionsource, databasetableconfig);
    }

    public StockCategory getByDealIdAndOptionId(String s, String s1)
        throws SQLException
    {
        QueryBuilder querybuilder = queryBuilder();
        Where where = querybuilder.where();
        where.eq("dealId", s).and().eq("optionId", s1);
        querybuilder.setWhere(where);
        return (StockCategory)queryForFirst(querybuilder.prepare());
    }

    public List getListByDealIdAndOptionId(String s, String s1)
        throws SQLException
    {
        QueryBuilder querybuilder = queryBuilder();
        Where where = querybuilder.where();
        where.eq("dealId", s).and().eq("optionId", s1);
        querybuilder.setWhere(where);
        return querybuilder.query();
    }

    public void saveList(List list)
        throws SQLException
    {
        for (list = list.iterator(); list.hasNext();)
        {
            Object obj = (StockCategory)list.next();
            create(obj);
            obj = ((StockCategory) (obj)).stockValues.iterator();
            while (((Iterator) (obj)).hasNext()) 
            {
                StockValue stockvalue = (StockValue)((Iterator) (obj)).next();
                ((DaoStockValue)stockValueDao.get()).create(stockvalue);
            }
        }

    }

    public void setApplication(Application application)
    {
        super.setApplication(application);
        stockValueDao = new Lazy(application) {

            final DaoStockCategory this$0;

            
            {
                this$0 = DaoStockCategory.this;
                super(context);
            }
        };
    }
}
