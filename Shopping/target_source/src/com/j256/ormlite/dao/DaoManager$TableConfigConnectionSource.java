// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.dao;

import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTableConfig;

// Referenced classes of package com.j256.ormlite.dao:
//            DaoManager

private static class tableConfig
{

    ConnectionSource connectionSource;
    DatabaseTableConfig tableConfig;

    public boolean equals(Object obj)
    {
        if (obj != null && getClass() == obj.getClass())
        {
            if (tableConfig.equals(((tableConfig) (obj = (tableConfig)obj)).tableConfig) && connectionSource.equals(((connectionSource) (obj)).connectionSource))
            {
                return true;
            }
        }
        return false;
    }

    public int hashCode()
    {
        return (tableConfig.hashCode() + 31) * 31 + connectionSource.hashCode();
    }

    public A(ConnectionSource connectionsource, DatabaseTableConfig databasetableconfig)
    {
        connectionSource = connectionsource;
        tableConfig = databasetableconfig;
    }
}
