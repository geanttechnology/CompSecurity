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
    {
        return callInTransaction(databaseconnection, false, databasetype, callable);
    }

    public static Object callInTransaction(DatabaseConnection databaseconnection, boolean flag, DatabaseType databasetype, Callable callable)
    {
        if (flag)
        {
            break MISSING_BLOCK_LABEL_13;
        }
        if (!databasetype.isNestedSavePointsSupported())
        {
            break MISSING_BLOCK_LABEL_281;
        }
        if (!databaseconnection.isAutoCommitSupported()) goto _L2; else goto _L1
_L1:
        boolean flag3 = databaseconnection.getAutoCommit();
        boolean flag2;
        flag2 = flag3;
        if (!flag3)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        flag = flag3;
        databaseconnection.setAutoCommit(false);
        flag = flag3;
        logger.debug("had to set auto-commit to false", new Object[0]);
        flag2 = flag3;
_L7:
        flag = flag2;
        databasetype = databaseconnection.setSavePoint((new StringBuilder()).append("ORMLITE").append(savePointCounter.incrementAndGet()).toString());
        if (databasetype != null) goto _L4; else goto _L3
_L3:
        flag = flag2;
        logger.debug("started savePoint transaction", new Object[0]);
_L5:
        boolean flag1 = true;
_L8:
        flag = flag2;
        callable = ((Callable) (callable.call()));
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_147;
        }
        flag = flag2;
        commit(databaseconnection, databasetype);
        if (flag2)
        {
            databaseconnection.setAutoCommit(true);
            logger.debug("restored auto-commit to true", new Object[0]);
        }
        return callable;
_L4:
        flag = flag2;
        logger.debug("started savePoint transaction {}", new Object[] {
            databasetype.getSavepointName()
        });
          goto _L5
        databasetype;
_L6:
        if (flag)
        {
            databaseconnection.setAutoCommit(true);
            logger.debug("restored auto-commit to true", new Object[0]);
        }
        throw databasetype;
        callable;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_240;
        }
        flag = flag2;
        rollBack(databaseconnection, databasetype);
        flag = flag2;
        throw callable;
        callable;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_259;
        }
        flag = flag2;
        rollBack(databaseconnection, databasetype);
        flag = flag2;
        throw SqlExceptionUtil.create("Operation in transaction threw non-SQL exception", callable);
        databasetype;
        flag = false;
        if (true) goto _L6; else goto _L2
_L2:
        flag2 = false;
          goto _L7
        databasetype = null;
        flag1 = false;
        flag2 = false;
          goto _L8
    }

    private static void commit(DatabaseConnection databaseconnection, Savepoint savepoint)
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
            logger.debug("committed savePoint transaction", new Object[0]);
            return;
        } else
        {
            logger.debug("committed savePoint transaction {}", new Object[] {
                s
            });
            return;
        }
    }

    private static void rollBack(DatabaseConnection databaseconnection, Savepoint savepoint)
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
            logger.debug("rolled back savePoint transaction", new Object[0]);
            return;
        } else
        {
            logger.debug("rolled back savePoint transaction {}", new Object[] {
                s
            });
            return;
        }
    }

    public Object callInTransaction(Callable callable)
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
