// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import android.app.Application;
import com.j256.ormlite.dao.BaseDaoImpl;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;

public abstract class GrouponBaseDao extends BaseDaoImpl
{

    protected Application application;

    public GrouponBaseDao(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        super(connectionsource, databasetableconfig);
    }

    public Object queryForFirstEq(String s, Object obj)
        throws SQLException
    {
        return queryForFirst(queryBuilder().limit(Long.valueOf(1L)).where().eq(s, obj).prepare());
    }

    public void setApplication(Application application1)
    {
        application = application1;
    }
}
