// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import com.groupon.db.models.SnapGroceryDetail;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;
import java.util.Date;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao

public class DaoSnapGroceryDetails extends GrouponBaseDao
{

    public DaoSnapGroceryDetails(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
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

    public SnapGroceryDetail getByGroceryId(String s)
        throws SQLException
    {
        QueryBuilder querybuilder = queryBuilder();
        Where where = querybuilder.where();
        where.eq("remoteId", s);
        querybuilder.setWhere(where);
        return (SnapGroceryDetail)queryForFirst(querybuilder.prepare());
    }

    public long getLastUpdated(String s)
        throws SQLException
    {
        QueryBuilder querybuilder = queryBuilder();
        querybuilder.where().eq("channel", s);
        s = (SnapGroceryDetail)queryForFirst(querybuilder.prepare());
        if (s != null && ((SnapGroceryDetail) (s)).modificationDate != null)
        {
            return ((SnapGroceryDetail) (s)).modificationDate.getTime();
        } else
        {
            return 0L;
        }
    }

    public void save(SnapGroceryDetail snapgrocerydetail)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().eq("remoteId", snapgrocerydetail.remoteId).and().eq("channel", snapgrocerydetail.channel);
        deletebuilder.delete();
        create(snapgrocerydetail);
    }
}
