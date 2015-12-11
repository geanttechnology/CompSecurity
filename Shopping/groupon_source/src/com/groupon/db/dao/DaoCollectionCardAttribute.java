// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import com.groupon.db.models.CollectionCardAttribute;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;
import java.util.Collection;
import java.util.Iterator;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao

public class DaoCollectionCardAttribute extends GrouponBaseDao
{

    public DaoCollectionCardAttribute(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        super(connectionsource, databasetableconfig);
    }

    public void clearByParentUUID(String s)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().eq("parentUUID", s);
        deletebuilder.delete();
    }

    public void save(Collection collection)
        throws SQLException
    {
        for (collection = collection.iterator(); collection.hasNext(); createOrUpdate((CollectionCardAttribute)collection.next())) { }
    }
}
