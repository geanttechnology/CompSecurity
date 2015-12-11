// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.adobe.mobile;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import java.io.File;

// Referenced classes of package com.adobe.mobile:
//            StaticMethods

abstract class AbstractDatabaseBacking
{

    private File _dbFile;
    protected SQLiteDatabase database;
    protected final Object dbMutex = new Object();
    protected String fileName;
    protected String logPrefix;

    AbstractDatabaseBacking()
    {
        _dbFile = null;
    }

    private void openOrCreateDatabase()
    {
        try
        {
            database = SQLiteDatabase.openDatabase(_dbFile.getPath(), null, 0x10000010);
            return;
        }
        catch (SQLException sqlexception)
        {
            StaticMethods.logErrorFormat("%s - Unable to open database (%s).", new Object[] {
                logPrefix, sqlexception.getLocalizedMessage()
            });
        }
    }

    protected void initDatabaseBacking(File file)
    {
        _dbFile = file;
        synchronized (dbMutex)
        {
            preMigrate();
            openOrCreateDatabase();
            if (database != null)
            {
                postMigrate();
                initializeDatabase();
                prepareStatements();
            }
        }
        return;
        exception;
        file;
        JVM INSTR monitorexit ;
        throw exception;
    }

    protected void initializeDatabase()
    {
        throw new UnsupportedOperationException("initializeDatabase must be overwritten");
    }

    protected void postMigrate()
    {
    }

    protected void postReset()
    {
    }

    protected void preMigrate()
    {
    }

    protected void prepareStatements()
    {
        throw new UnsupportedOperationException("prepareStatements must be overwritten");
    }

    protected final void resetDatabase(Exception exception)
    {
        StaticMethods.logErrorFormat("%s - Database in unrecoverable state (%s), resetting.", new Object[] {
            logPrefix, exception.getLocalizedMessage()
        });
        exception = ((Exception) (dbMutex));
        exception;
        JVM INSTR monitorenter ;
        if (_dbFile.delete())
        {
            break MISSING_BLOCK_LABEL_85;
        }
        StaticMethods.logDebugFormat("%s - Database file(%s) was not found.", new Object[] {
            logPrefix, _dbFile.getAbsolutePath()
        });
_L2:
        openOrCreateDatabase();
        initializeDatabase();
        prepareStatements();
        postReset();
        return;
        StaticMethods.logDebugFormat("%s - Database file(%s) was corrupt and had to be deleted.", new Object[] {
            logPrefix, _dbFile.getAbsolutePath()
        });
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception1;
        exception1;
        exception;
        JVM INSTR monitorexit ;
        throw exception1;
    }
}
