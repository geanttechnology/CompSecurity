// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import com.groupon.db.models.BusinessSummary;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;
import java.util.Date;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao

public class DaoBusinessSummary extends GrouponBaseDao
{

    public DaoBusinessSummary(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
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

    public long getLastUpdated(String s)
        throws SQLException
    {
        QueryBuilder querybuilder = queryBuilder();
        querybuilder.where().eq("channel", s);
        s = (BusinessSummary)queryForFirst(querybuilder.prepare());
        if (s != null)
        {
            return ((BusinessSummary) (s)).modificationDate.getTime();
        } else
        {
            return 0L;
        }
    }

    public void save(BusinessSummary businesssummary)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().eq("remoteId", businesssummary.remoteId).and().eq("channel", businesssummary.channel);
        deletebuilder.delete();
        create(businesssummary);
    }
}
