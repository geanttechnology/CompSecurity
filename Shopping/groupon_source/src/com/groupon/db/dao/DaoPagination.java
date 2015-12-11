// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;
import java.util.List;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao

public class DaoPagination extends GrouponBaseDao
{

    public DaoPagination(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
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

    public void deleteByChannelIds(List list)
        throws SQLException
    {
        if (!list.isEmpty())
        {
            DeleteBuilder deletebuilder = deleteBuilder();
            deletebuilder.where().in("channel", list);
            deletebuilder.delete();
        }
    }

    public int deleteByChannelPrefix(String s)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().like("channel", (new StringBuilder()).append(s).append('%').toString());
        return deletebuilder.delete();
    }
}
