// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.misc;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.j256.ormlite.misc:
//            SqlExceptionUtil

public class TransactionManager
{

    private static final String SAVE_POINT_PREFIX = "ORMLITE";
    private static final Logger logger = LoggerFactory.getLogger(com/j256/ormlite/misc/TransactionManager);
    private static AtomicInteger savePointCounter = new AtomicInteger();
    private ConnectionSource connectionSource;

    public TransactionManager()
    {
    }

    public TransactionManager(ConnectionSource connectionsource)
    {
        connectionSource = connectionsource;
        initialize();
    }

    public static Object callInTransaction(ConnectionSource connectionsource, Callable callable)
        throws SQLException
    {
        DatabaseConnection databaseconnection = connectionsource.getReadWriteConnection();
        callable = ((Callable) (callInTransaction(databaseconnection, connectionsource.saveSpecialConnection(databaseconnection), connectionsource.getDatabaseType(), callable)));
        connectionsource.clearSpecialConnection(databaseconnection);
        connectionsource.releaseConnection(databaseconnection);
        return callable;
        callable;
        connectionsource.clearSpecialConnection(databaseconnection);
        connectionsource.releaseConnection(databaseconnection);
        throw callable;
    }

    public static Object callInTransaction(DatabaseConnection databaseconnection, DatabaseType databasetype, Callable callable)
        throws SQLException
    {
        return callInTransaction(databaseconnection, false, databasetype, callable);
    }

    public static Object callInTransaction(DatabaseConnection databaseconnection, boolean flag, DatabaseType databasetype, Callable callable)
        throws SQLException
    {
        boolean flag2;
        boolean flag3;
        boolean flag4;
        flag4 = false;
        flag3 = false;
        flag2 = false;
        if (flag) goto _L2; else goto _L1
_L1:
        flag = flag3;
        if (!databasetype.isNestedSavePointsSupported()) goto _L3; else goto _L2
_L2:
        flag = flag3;
        if (!databaseconnection.isAutoCommitSupported())
        {
            break MISSING_BLOCK_LABEL_82;
        }
        flag = flag3;
        flag3 = databaseconnection.isAutoCommit();
        flag2 = flag3;
        if (!flag3)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        flag = flag3;
        databaseconnection.setAutoCommit(false);
        flag = flag3;
        logger.debug("had to set auto-commit to false");
        flag2 = flag3;
        flag = flag2;
        databasetype = databaseconnection.setSavePoint((new StringBuilder()).append("ORMLITE").append(savePointCounter.incrementAndGet()).toString());
        if (databasetype != null) goto _L5; else goto _L4
_L4:
        flag = flag2;
        logger.debug("started savePoint transaction");
_L6:
        boolean flag1 = true;
_L10:
        flag = flag2;
        callable = ((Callable) (callable.call()));
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        flag = flag2;
        commit(databaseconnection, databasetype);
        if (flag2)
        {
            databaseconnection.setAutoCommit(true);
            logger.debug("restored auto-commit to true");
        }
        return callable;
_L5:
        flag = flag2;
        logger.debug("started savePoint transaction {}", databasetype.getSavepointName());
          goto _L6
        databasetype;
        if (flag)
        {
            databaseconnection.setAutoCommit(true);
            logger.debug("restored auto-commit to true");
        }
        throw databasetype;
        callable;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_235;
        }
        flag = flag2;
        rollBack(databaseconnection, databasetype);
_L8:
        flag = flag2;
        throw callable;
        databasetype;
        flag = flag2;
        logger.error(callable, "after commit exception, rolling back to save-point also threw exception");
        if (true) goto _L8; else goto _L7
_L7:
        callable;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_270;
        }
        flag = flag2;
        rollBack(databaseconnection, databasetype);
_L9:
        flag = flag2;
        throw SqlExceptionUtil.create("Transaction callable threw non-SQL exception", callable);
        databasetype;
        flag = flag2;
        logger.error(callable, "after commit exception, rolling back to save-point also threw exception");
        if (true) goto _L9; else goto _L3
_L3:
        databasetype = null;
        flag1 = false;
        flag2 = flag4;
          goto _L10
    }

    private static void commit(DatabaseConnection databaseconnection, Savepoint savepoint)
        throws SQLException
    {
        String s;
        if (savepoint == null)
        {
            s = null;
        } else
        {
            s = savepoint.getSavepointName();
        }
        databaseconnection.commit(savepoint);
        if (s == null)
        {
            logger.debug("committed savePoint transaction");
            return;
        } else
        {
            logger.debug("committed savePoint transaction {}", s);
            return;
        }
    }

    private static void rollBack(DatabaseConnection databaseconnection, Savepoint savepoint)
        throws SQLException
    {
        String s;
        if (savepoint == null)
        {
            s = null;
        } else
        {
            s = savepoint.getSavepointName();
        }
        databaseconnection.rollback(savepoint);
        if (s == null)
        {
            logger.debug("rolled back savePoint transaction");
            return;
        } else
        {
            logger.debug("rolled back savePoint transaction {}", s);
            return;
        }
    }

    public Object callInTransaction(Callable callable)
        throws SQLException
    {
        return callInTransaction(connectionSource, callable);
    }

    public void initialize()
    {
        if (connectionSource == null)
        {
            throw new IllegalStateException((new StringBuilder()).append("dataSource was not set on ").append(getClass().getSimpleName()).toString());
        } else
        {
            return;
        }
    }

    public void setConnectionSource(ConnectionSource connectionsource)
    {
        connectionSource = connectionsource;
    }

}
