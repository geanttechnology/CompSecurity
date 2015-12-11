// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.v3.processor;

import android.content.Context;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

// Referenced classes of package com.groupon.v3.processor:
//            DealLoader

public class FreshDealLoader extends DealLoader
{

    protected static final int DEALS_EXPIRED_IN_MS = 0xdbba0;

    public FreshDealLoader(Context context, String s)
    {
        super(context, s);
    }

    public List queryForDeals()
        throws SQLException
    {
        long l = System.currentTimeMillis();
        QueryBuilder querybuilder = dealDao.queryBuilder();
        Where where = querybuilder.where();
        where.eq("channel", dbChannel).and().gt("modificationDate", new Date(l - 0xdbba0L));
        querybuilder.setWhere(where);
        return dealDao.query(querybuilder.prepare());
    }
}
