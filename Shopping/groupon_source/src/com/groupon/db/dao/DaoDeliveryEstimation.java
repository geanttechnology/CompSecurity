// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.db.dao;

import com.groupon.db.models.DeliveryEstimation;
import com.j256.ormlite.stmt.DeleteBuilder;
import com.j256.ormlite.stmt.Where;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;
import java.sql.SQLException;

// Referenced classes of package com.groupon.db.dao:
//            GrouponBaseDao

public class DaoDeliveryEstimation extends GrouponBaseDao
{

    public DaoDeliveryEstimation(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
        throws SQLException
    {
        super(connectionsource, databasetableconfig);
    }

    public void save(DeliveryEstimation deliveryestimation)
        throws SQLException
    {
        DeleteBuilder deletebuilder = deleteBuilder();
        deletebuilder.where().eq("dealUuid", deliveryestimation.dealUuid);
        deletebuilder.delete();
        create(deliveryestimation);
    }
}
