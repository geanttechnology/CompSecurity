// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j256.ormlite.misc;

import com.j256.ormlite.db.DatabaseType;
import com.j256.ormlite.logger.Logger;
import com.j256.ormlite.logger.LoggerFactory;
import com.j256.ormlite.support.DatabaseConnection;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.j256.ormlite.misc:
//            SqlExceptionUtil

public class TransactionManager
{

    private static final Logger logger = LoggerFactory.getLogger(com/j256/ormlite/misc/TransactionManager);
    private static AtomicInteger savePointCounter = new AtomicInteger();

    public TransactionManager()
    {
    }

    public static Object callInTransaction(DatabaseConnection databaseconnection, boolean flag, DatabaseType databasetype, Callable callable)
        throws SQLException
    {
        Savepoint savepoint;
        boolean flag1;
        boolean flag2;
        boolean flag3;
        boolean flag4;
        flag2 = false;
        flag3 = false;
        flag4 = false;
        flag1 = false;
        savepoint = null;
        if (flag) goto _L2; else goto _L1
_L1:
        flag = flag3;
        if (!databasetype.isNestedSavePointsSupported()) goto _L3; else goto _L2
_L2:
        flag2 = flag4;
        flag = flag3;
        if (!databaseconnection.isAutoCommitSupported())
        {
            break MISSING_BLOCK_LABEL_92;
        }
        flag = flag3;
        flag3 = databaseconnection.isAutoCommit();
        flag2 = flag3;
        if (!flag3)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        flag = flag3;
        databaseconnection.setAutoCommit(false);
        flag = flag3;
        logger.debug("had to set auto-commit to false");
        flag2 = flag3;
        flag = flag2;
        savepoint = databaseconnection.setSavePoint((new StringBuilder()).append("ORMLITE").append(savePointCounter.incrementAndGet()).toString());
        if (savepoint != null) goto _L5; else goto _L4
_L4:
        flag = flag2;
        logger.debug("started savePoint transaction");
_L7:
        flag1 = true;
_L3:
        flag = flag2;
        databasetype = ((DatabaseType) (callable.call()));
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_170;
        }
        flag = flag2;
        commit(databaseconnection, savepoint);
        if (flag2)
        {
            databaseconnection.setAutoCommit(true);
            logger.debug("restored auto-commit to true");
        }
        return databasetype;
_L5:
        flag = flag2;
        logger.debug("started savePoint transaction {}", savepoint.getSavepointName());
        if (true) goto _L7; else goto _L6
_L6:
        databasetype;
        if (flag)
        {
            databaseconnection.setAutoCommit(true);
            logger.debug("restored auto-commit to true");
        }
        throw databasetype;
        databasetype;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_250;
        }
        flag = flag2;
        rollBack(databaseconnection, savepoint);
_L9:
        flag = flag2;
        throw databasetype;
        callable;
        flag = flag2;
        logger.error(databasetype, "after commit exception, rolling back to save-point also threw exception");
        if (true) goto _L9; else goto _L8
_L8:
        databasetype;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_286;
        }
        flag = flag2;
        rollBack(databaseconnection, savepoint);
_L10:
        flag = flag2;
        throw SqlExceptionUtil.create("Transaction callable threw non-SQL exception", databasetype);
        callable;
        flag = flag2;
        logger.error(databasetype, "after commit exception, rolling back to save-point also threw exception");
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

}
