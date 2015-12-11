// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import com.groupon.db.models.MarketRateResult;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao

public class DaoMarketRateResult extends GrouponBaseDao
{

    public DaoMarketRateResult(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        super(connectionsource, databasetableconfig);
    }

    public int deleteByChannelId(String s)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().eq("channel", s);
        return deletebuilder.delete();
    }

    public MarketRateResult getByIdAndChannelId(String s, String s1)
        throws SQLException
    {
        QueryBuilder querybuilder = queryBuilder();
        Where where = querybuilder.where();
        where.eq("remoteId", s).and().eq("channel", s1);
        querybuilder.setWhere(where);
        return (MarketRateResult)queryForFirst(querybuilder.prepare());
    }

    public void replace(MarketRateResult marketrateresult)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().eq("remoteId", marketrateresult.remoteId);
        deletebuilder.delete();
        create(marketrateresult);
    }
}
