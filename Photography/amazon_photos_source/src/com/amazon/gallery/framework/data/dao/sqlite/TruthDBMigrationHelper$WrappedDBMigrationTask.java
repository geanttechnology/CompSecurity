// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.sqlite.migration.DatabaseMigrationTask;
import java.util.concurrent.Callable;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            TruthDBMigrationHelper, ReadOnlySQLiteDatabase

private static class MigrationTaskCallback
    implements Callable
{
    public static interface MigrationTaskCallback
    {

        public abstract void onError(DatabaseMigrationTask databasemigrationtask);

        public abstract void onSuccess(DatabaseMigrationTask databasemigrationtask);
    }


    private final MigrationTaskCallback callback;
    private final SQLiteDatabase sourceDB;
    private final DatabaseMigrationTask task;

    public volatile Object call()
        throws Exception
    {
        return call();
    }

    public Void call()
    {
        task.executeTask(sourceDB);
        if (callback != null)
        {
            callback.onSuccess(task);
        }
_L2:
        return null;
        SQLiteException sqliteexception;
        sqliteexception;
        GLogger.ex(TruthDBMigrationHelper.access$200(), "Migration task failed", sqliteexception);
        if (callback != null)
        {
            callback.onError(task);
        }
        if (true) goto _L2; else goto _L1
_L1:
    }

    private MigrationTaskCallback(DatabaseMigrationTask databasemigrationtask, ReadOnlySQLiteDatabase readonlysqlitedatabase, MigrationTaskCallback migrationtaskcallback)
    {
        task = databasemigrationtask;
        sourceDB = readonlysqlitedatabase.database;
        callback = migrationtaskcallback;
    }

    MigrationTaskCallback(DatabaseMigrationTask databasemigrationtask, ReadOnlySQLiteDatabase readonlysqlitedatabase, MigrationTaskCallback migrationtaskcallback, MigrationTaskCallback migrationtaskcallback1)
    {
        this(databasemigrationtask, readonlysqlitedatabase, migrationtaskcallback);
    }
}
