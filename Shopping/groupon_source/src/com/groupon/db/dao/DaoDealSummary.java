// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import com.groupon.db.GrouponOrmLiteHelper;
import com.groupon.db.models.DealSummary;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import com.j256.ormlite.table.TableUtils;
import java.sql.SQLException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao

public class DaoDealSummary extends GrouponBaseDao
{

    public DaoDealSummary(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        super(connectionsource, databasetableconfig);
    }

    public void clearDeals()
        throws Exception
    {
        callBatchTasks(new Callable() {

            final DaoDealSummary this$0;

            public volatile Object call()
                throws Exception
            {
                return call();
            }

            public Void call()
                throws Exception
            {
                Class class1;
                for (Iterator iterator = GrouponOrmLiteHelper.dealTables.iterator(); iterator.hasNext(); TableUtils.clearTable(getConnectionSource(), class1))
                {
                    class1 = (Class)iterator.next();
                }

                return null;
            }

            
            {
                this$0 = DaoDealSummary.this;
                super();
            }
        });
    }

    public int deleteByChannelId(String s)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().eq("channel", s);
        return deletebuilder.delete();
    }

    public int deleteByChannelPrefix(String s)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().like("channel", (new StringBuilder()).append(s).append('%').toString());
        return deletebuilder.delete();
    }

    public long getLastUpdated(String s)
        throws SQLException
    {
        QueryBuilder querybuilder = queryBuilder();
        querybuilder.where().eq("channel", s);
        s = (DealSummary)queryForFirst(querybuilder.prepare());
        if (s != null)
        {
            return ((DealSummary) (s)).modificationDate.getTime();
        } else
        {
            return 0L;
        }
    }

    public DealSummary getPullNotificationDealByChannelId(String s)
        throws SQLException
    {
        QueryBuilder querybuilder = queryBuilder();
        Where where = querybuilder.where();
        where.eq("channel", s);
        querybuilder.setWhere(where);
        return (DealSummary)queryForFirst(querybuilder.prepare());
    }

    public void save(DealSummary dealsummary)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().eq("remoteId", dealsummary.remoteId).and().eq("channel", dealsummary.channel);
        deletebuilder.delete();
        create(dealsummary);
    }
}
