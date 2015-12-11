// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import android.content.Context;
import com.groupon.db.dao.DaoDealSubsetAttribute;
import com.groupon.db.dao.DaoDealSummary;
import com.groupon.db.dao.DaoPagination;
import com.groupon.db.models.DealSubsetAttribute;
import com.groupon.db.models.Pagination;
import com.groupon.models.EndlessList;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.groupon.fragment:
//            DealCardListLoader, DealSubsetFragment

protected static class  extends DealCardListLoader
{

    private List getCachedDealSummaries()
        throws SQLException
    {
        long l = System.currentTimeMillis();
        QueryBuilder querybuilder = dealSummaryDao.queryBuilder();
        Where where = querybuilder.where();
        where.eq("channel", pagerChannelAndSubchannel).and().gt("modificationDate", new Date(l - 0xdbba0L));
        querybuilder.setWhere(where);
        return dealSummaryDao.query(querybuilder.prepare());
    }

    public volatile Object loadInBackground()
    {
        return loadInBackground();
    }

    public List loadInBackground()
    {
        Object obj;
        Pagination pagination;
        DealSubsetAttribute dealsubsetattribute;
        int i;
        int j;
        boolean flag;
        boolean flag1;
        try
        {
            obj = getCachedDealSummaries();
            pagination = (Pagination)paginationDao.queryForFirstEq("channel", pagerChannelAndSubchannel);
            dealsubsetattribute = (DealSubsetAttribute)dealSubsetAttributeDao.queryForFirstEq("channel", pagerChannelAndSubchannel);
        }
        catch (SQLException sqlexception)
        {
            throw new RuntimeException(sqlexception);
        }
        flag = false;
        flag1 = false;
        j = ((flag1) ? 1 : 0);
        i = ((flag) ? 1 : 0);
        if (pagination == null)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        j = ((flag1) ? 1 : 0);
        i = ((flag) ? 1 : 0);
        if (pagination.hasMorePages())
        {
            i = pagination.getCount();
            j = pagination.getCurrentOffset();
        }
        obj = new EndlessList(((List) (obj)), i, j, dealsubsetattribute);
        return ((List) (obj));
    }

    public (Class class1, Class class2, Context context, String s)
    {
        super(class1, class2, context, s);
    }
}
