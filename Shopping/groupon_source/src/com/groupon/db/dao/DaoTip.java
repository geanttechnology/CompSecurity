// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import com.groupon.db.models.Tip;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao

public class DaoTip extends GrouponBaseDao
{

    public DaoTip(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        super(connectionsource, databasetableconfig);
    }

    public void clearByBusinessChannelId(String s)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        Where where = deletebuilder.where();
        where.eq("businessChannelId", s);
        deletebuilder.setWhere(where);
        delete(deletebuilder.prepare());
    }

    public void clearByTipIdAndBusinessTipId(String s, String s1)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        Where where = deletebuilder.where();
        where.eq("remoteId", s).and().eq("businessChannelId", s1);
        deletebuilder.setWhere(where);
        delete(deletebuilder.prepare());
    }

    public void saveList(Collection collection)
        throws SQLException
    {
        for (collection = collection.iterator(); collection.hasNext(); create((Tip)collection.next())) { }
    }
}
