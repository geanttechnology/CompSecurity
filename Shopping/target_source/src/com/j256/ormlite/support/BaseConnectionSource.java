// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.support;

import com.j256.ormlite.logger.Logger;
import java.sql.SQLException;

// Referenced classes of package com.j256.ormlite.support:
//            ConnectionSource, DatabaseConnection

public abstract class BaseConnectionSource
    implements ConnectionSource
{
    private static class NestedConnection
    {

        public final DatabaseConnection connection;
        private int nestedC;

        public int decrementAndGet()
        {
            nestedC = nestedC - 1;
            return nestedC;
        }

        public void increment()
        {
            nestedC = nestedC + 1;
        }

        public NestedConnection(DatabaseConnection databaseconnection)
        {
            connection = databaseconnection;
            nestedC = 1;
        }
    }


    private ThreadLocal specialConnection;

    public BaseConnectionSource()
    {
        specialConnection = new ThreadLocal();
    }

    protected boolean clearSpecial(DatabaseConnection databaseconnection, Logger logger)
    {
        NestedConnection nestedconnection = (NestedConnection)specialConnection.get();
        if (databaseconnection == null)
        {
            return false;
        }
        if (nestedconnection == null)
        {
            logger.error("no connection has been saved when clear() called");
            return false;
        }
        if (nestedconnection.connection == databaseconnection)
        {
            if (nestedconnection.decrementAndGet() == 0)
            {
                specialConnection.set(null);
            }
            return true;
        } else
        {
            logger.error("connection saved {} is not the one being cleared {}", nestedconnection.connection, databaseconnection);
            return false;
        }
    }

    protected DatabaseConnection getSavedConnection()
    {
        NestedConnection nestedconnection = (NestedConnection)specialConnection.get();
        if (nestedconnection == null)
        {
            return null;
        } else
        {
            return nestedconnection.connection;
        }
    }

    public DatabaseConnection getSpecialConnection()
    {
        NestedConnection nestedconnection = (NestedConnection)specialConnection.get();
        if (nestedconnection == null)
        {
            return null;
        } else
        {
            return nestedconnection.connection;
        }
    }

    protected boolean isSavedConnection(DatabaseConnection databaseconnection)
    {
        NestedConnection nestedconnection = (NestedConnection)specialConnection.get();
        if (nestedconnection == null)
        {
            return false;
        }
        return nestedconnection.connection == databaseconnection;
    }

    protected boolean saveSpecial(DatabaseConnection databaseconnection)
        throws SQLException
    {
        NestedConnection nestedconnection = (NestedConnection)specialConnection.get();
        if (nestedconnection == null)
        {
            specialConnection.set(new NestedConnection(databaseconnection));
            return true;
        }
        if (nestedconnection.connection != databaseconnection)
        {
            throw new SQLException((new StringBuilder()).append("trying to save connection ").append(databaseconnection).append(" but already have saved connection ").append(nestedconnection.connection).toString());
        } else
        {
            nestedconnection.increment();
            return false;
        }
    }
}
