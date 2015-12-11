// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import com.groupon.db.models.CouponCategory;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;
import java.util.Date;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao

public class DaoCouponCategory extends GrouponBaseDao
{

    public DaoCouponCategory(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        super(connectionsource, databasetableconfig);
    }

    public void deleteByChannelId(String s)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().eq("channel", s);
        deletebuilder.delete();
    }

    public CouponCategory getFirstByChannelId(String s)
        throws SQLException
    {
        QueryBuilder querybuilder = queryBuilder();
        querybuilder.where().eq("channel", s).prepare();
        return (CouponCategory)queryForFirst(querybuilder.prepare());
    }

    public long getLastUpdatedByChannelId(String s)
        throws SQLException
    {
        QueryBuilder querybuilder = queryBuilder();
        querybuilder.where().eq("channel", s);
        s = (CouponCategory)queryForFirst(querybuilder.prepare());
        if (s != null)
        {
            return ((CouponCategory) (s)).modificationDate.getTime();
        } else
        {
            return 0L;
        }
    }

    public void replace(CouponCategory couponcategory)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().eq("remoteId", couponcategory.getRemoteId()).and().eq("channel", couponcategory.channel);
        deletebuilder.delete();
        create(couponcategory);
    }
}
