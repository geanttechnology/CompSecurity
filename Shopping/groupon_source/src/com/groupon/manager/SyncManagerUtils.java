// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import com.groupon.db.dao.DaoDeal;
import com.groupon.db.dao.DaoDealSummary;
import com.groupon.db.dao.DaoDeliveryEstimation;
import com.groupon.db.models.Deal;
import com.groupon.db.models.DealSummary;
import com.groupon.db.models.DeliveryEstimation;
import com.groupon.db.models.InAppMessage;
import com.groupon.db.models.WidgetSummary;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import java.sql.SQLException;
import java.util.Date;

public class SyncManagerUtils
{

    public SyncManagerUtils()
    {
    }

    public static void deleteRecordsForChannel(Dao dao, String s)
        throws SQLException
    {
        dao = dao.deleteBuilder();
        Where where = dao.where();
        where.eq("channel", s);
        dao.setWhere(where);
        dao.delete();
    }

    protected static void deleteRecordsForChannelAndSubchannels(Dao dao, String s)
        throws SQLException
    {
        dao = dao.deleteBuilder();
        Where where = dao.where();
        where.between("channel", s, (new StringBuilder()).append(s).append("~").toString());
        dao.setWhere(where);
        dao.delete();
    }

    protected static Deal getDeal(DaoDeal daodeal, String s)
        throws SQLException
    {
        QueryBuilder querybuilder = daodeal.queryBuilder();
        Where where = querybuilder.where();
        where.eq("remoteId", s);
        querybuilder.setWhere(where);
        return (Deal)daodeal.queryForFirst(querybuilder.prepare());
    }

    protected static DeliveryEstimation getEstimation(DaoDeliveryEstimation daodeliveryestimation, String s)
        throws SQLException
    {
        QueryBuilder querybuilder = daodeliveryestimation.queryBuilder();
        Where where = querybuilder.where();
        where.eq("dealUuid", s);
        querybuilder.setWhere(where);
        return (DeliveryEstimation)daodeliveryestimation.queryForFirst(querybuilder.prepare());
    }

    protected static long getLastUpdatedForChannel(DaoDealSummary daodealsummary, String s)
        throws SQLException
    {
        QueryBuilder querybuilder = daodealsummary.queryBuilder();
        Where where = querybuilder.where();
        where.eq("channel", s);
        querybuilder.setWhere(where);
        daodealsummary = (DealSummary)daodealsummary.queryForFirst(querybuilder.prepare());
        if (daodealsummary != null)
        {
            return ((DealSummary) (daodealsummary)).modificationDate.getTime();
        } else
        {
            return 0L;
        }
    }

    protected static long getLastUpdatedForInAppMessage(Dao dao)
        throws SQLException
    {
        dao = (InAppMessage)dao.queryForFirst(dao.queryBuilder().prepare());
        if (dao != null)
        {
            return ((InAppMessage) (dao)).modificationDate.getTime();
        } else
        {
            return 0L;
        }
    }

    protected static long getLastUpdatedForWidgetSummaries(Dao dao, String s)
        throws SQLException
    {
        QueryBuilder querybuilder = dao.queryBuilder();
        Where where = querybuilder.where();
        where.eq("channel", s);
        querybuilder.setWhere(where);
        dao = (WidgetSummary)dao.queryForFirst(querybuilder.prepare());
        if (dao != null)
        {
            return ((WidgetSummary) (dao)).modificationDate.getTime();
        } else
        {
            return 0L;
        }
    }
}
