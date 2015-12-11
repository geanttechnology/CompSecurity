// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.support;

import com.j256.ormlite.db.DatabaseType;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.support:
//            DatabaseConnection

public interface ConnectionSource
{

    public abstract void clearSpecialConnection(DatabaseConnection databaseconnection);

    public abstract DatabaseType getDatabaseType();

    public abstract DatabaseConnection getReadOnlyConnection()
        throws SQLException;

    public abstract DatabaseConnection getReadWriteConnection()
        throws SQLException;

    public abstract DatabaseConnection getSpecialConnection();

    public abstract void releaseConnection(DatabaseConnection databaseconnection)
        throws SQLException;

    public abstract boolean saveSpecialConnection(DatabaseConnection databaseconnection)
        throws SQLException;
}
