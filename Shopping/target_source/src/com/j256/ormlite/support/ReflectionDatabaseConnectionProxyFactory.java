// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.support;

import com.j256.ormlite.misc.SqlExceptionUtil;
import java.lang.reflect.Constructor;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.support:
//            DatabaseConnectionProxyFactory, DatabaseConnection

public class ReflectionDatabaseConnectionProxyFactory
    implements DatabaseConnectionProxyFactory
{

    private final Constructor constructor;
    private final Class proxyClass;

    public ReflectionDatabaseConnectionProxyFactory(Class class1)
        throws IllegalArgumentException
    {
        proxyClass = class1;
        try
        {
            constructor = class1.getConstructor(new Class[] {
                com/j256/ormlite/support/DatabaseConnection
            });
            return;
        }
        catch (Exception exception)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("Could not find constructor with DatabaseConnection argument in ").append(class1).toString());
        }
    }

    public DatabaseConnection createProxy(DatabaseConnection databaseconnection)
        throws SQLException
    {
        try
        {
            databaseconnection = (DatabaseConnection)constructor.newInstance(new Object[] {
                databaseconnection
            });
        }
        // Misplaced declaration of an exception variable
        catch (DatabaseConnection databaseconnection)
        {
            throw SqlExceptionUtil.create((new StringBuilder()).append("Could not create a new instance of ").append(proxyClass).toString(), databaseconnection);
        }
        return databaseconnection;
    }
}
