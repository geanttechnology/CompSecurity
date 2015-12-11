// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao

public class DaoSpecial extends GrouponBaseDao
{

    public DaoSpecial(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        super(connectionsource, databasetableconfig);
    }

    public void clear(String s)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        Where where = deletebuilder.where();
        where.eq("remoteId", s);
        deletebuilder.setWhere(where);
        delete(deletebuilder.prepare());
    }
}
