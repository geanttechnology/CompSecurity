// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import com.groupon.db.models.CouponDetail;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao

public class DaoCouponDetail extends GrouponBaseDao
{

    public DaoCouponDetail(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        super(connectionsource, databasetableconfig);
    }

    public CouponDetail getByCouponId(String s)
        throws SQLException
    {
        QueryBuilder querybuilder = queryBuilder();
        Where where = querybuilder.where();
        where.eq("remoteId", s);
        querybuilder.setWhere(where);
        return (CouponDetail)queryForFirst(querybuilder.prepare());
    }

    public void replace(CouponDetail coupondetail)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().eq("remoteId", coupondetail.remoteId);
        deletebuilder.delete();
        create(coupondetail);
    }
}
