// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import com.groupon.db.models.mygroupons.MyGrouponItemSummary;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao

public class DaoMyGrouponItemSummary extends GrouponBaseDao
{

    public DaoMyGrouponItemSummary(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        super(connectionsource, databasetableconfig);
    }

    public void clearAll()
        throws SQLException
    {
        delete(deleteBuilder().prepare());
    }

    public void deleteRecordsForCategory(String s)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        Where where = deletebuilder.where();
        where.eq("category", s);
        deletebuilder.setWhere(where);
        deletebuilder.delete();
    }

    public void removeMyGrouponItem(String s)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().eq("remoteId", s);
        deletebuilder.delete();
    }

    public void save(MyGrouponItemSummary mygrouponitemsummary)
        throws SQLException
    {
        removeMyGrouponItem(mygrouponitemsummary.remoteId);
        create(mygrouponitemsummary);
    }
}
