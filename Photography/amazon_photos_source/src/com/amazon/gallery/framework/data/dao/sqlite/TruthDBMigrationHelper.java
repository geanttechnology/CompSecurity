// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import com.amazon.gallery.foundation.utils.log.GLogger;
import com.amazon.gallery.framework.data.dao.sqlite.migration.DatabaseMigrationHelper;
import com.amazon.gallery.framework.data.dao.sqlite.migration.DatabaseMigrationTask;
import com.amazon.gallery.framework.data.dao.sqlite.migration.DatabaseMigrationTaskFilter;
import com.amazon.gallery.thor.app.authentication.AospPreferences;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            TruthDBConnectionManager, ReadOnlySQLiteDatabase

public class TruthDBMigrationHelper
    implements DatabaseMigrationHelper
{
    private static class WrappedDBMigrationTask
        implements Callable
    {

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
            GLogger.ex(TruthDBMigrationHelper.TAG, "Migration task failed", sqliteexception);
            if (callback != null)
            {
                callback.onError(task);
            }
            if (true) goto _L2; else goto _L1
_L1:
        }

        private WrappedDBMigrationTask(DatabaseMigrationTask databasemigrationtask, ReadOnlySQLiteDatabase readonlysqlitedatabase, MigrationTaskCallback migrationtaskcallback)
        {
            task = databasemigrationtask;
            sourceDB = readonlysqlitedatabase.database;
            callback = migrationtaskcallback;
        }

    }

    public static interface WrappedDBMigrationTask.MigrationTaskCallback
    {

        public abstract void onError(DatabaseMigrationTask databasemigrationtask);

        public abstract void onSuccess(DatabaseMigrationTask databasemigrationtask);
    }


    private static final String TAG = com/amazon/gallery/framework/data/dao/sqlite/TruthDBMigrationHelper.getName();
    private final Context context;
    private final String databaseId;
    private TruthDBConnectionManager dbConnMgr;
    private ScheduledExecutorService executorService;
    private com.amazon.gallery.framework.data.TruthDataMigrationUtilities.MigrationCompleteCallback migrationCompleteCallback;
    private ReadOnlySQLiteDatabase readOnlyTruthDB;
    private final Set registeredMigrationTasks;

    public TruthDBMigrationHelper(Context context1)
    {
        registeredMigrationTasks = new HashSet();
        context = context1;
        databaseId = (new AospPreferences(context1)).getTruthDatabaseId();
    }

    public TruthDBMigrationHelper(Context context1, com.amazon.gallery.framework.data.TruthDataMigrationUtilities.MigrationCompleteCallback migrationcompletecallback)
    {
        this(context1);
        migrationCompleteCallback = migrationcompletecallback;
    }

    private void onPostExecuteTask(DatabaseMigrationTask databasemigrationtask, boolean flag)
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag) goto _L2; else goto _L1
_L1:
        registeredMigrationTasks.remove(databasemigrationtask);
        if (registeredMigrationTasks.isEmpty())
        {
            tearDown(true);
        }
_L4:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        GLogger.e(TAG, "Migration task - %s failed", new Object[] {
            databasemigrationtask.getClass().getSimpleName()
        });
        tearDown(false);
        if (true) goto _L4; else goto _L3
_L3:
        databasemigrationtask;
        throw databasemigrationtask;
    }

    private void onPreExecuteTask()
    {
        if (executorService == null)
        {
            executorService = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {

                final TruthDBMigrationHelper this$0;

                public Thread newThread(Runnable runnable)
                {
                    runnable = new Thread(runnable, "TruthDBMigrationThread");
                    runnable.setPriority(3);
                    return runnable;
                }

            
            {
                this$0 = TruthDBMigrationHelper.this;
                super();
            }
            });
        }
        if (dbConnMgr == null)
        {
            dbConnMgr = new TruthDBConnectionManager(context, databaseId);
            readOnlyTruthDB = dbConnMgr.initializeDBConn();
        }
    }

    private void tearDown(boolean flag)
    {
        readOnlyTruthDB = null;
        if (executorService != null)
        {
            executorService.shutdown();
            executorService = null;
        }
        if (flag)
        {
            dbConnMgr.deleteDatabase(context);
            (new AospPreferences(context)).setTruthDatabaseId("");
            if (migrationCompleteCallback != null)
            {
                migrationCompleteCallback.onMigrationComplete();
            }
        }
    }

    public void executeTasksForCategory(DatabaseMigrationTaskFilter databasemigrationtaskfilter)
    {
        this;
        JVM INSTR monitorenter ;
        onPreExecuteTask();
        if (readOnlyTruthDB != null)
        {
            Iterator iterator = registeredMigrationTasks.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                Object obj = (DatabaseMigrationTask)iterator.next();
                if (databasemigrationtaskfilter.doesTaskMatchFilter(((DatabaseMigrationTask) (obj))))
                {
                    obj = new WrappedDBMigrationTask(((DatabaseMigrationTask) (obj)), readOnlyTruthDB, new WrappedDBMigrationTask.MigrationTaskCallback() {

                        final TruthDBMigrationHelper this$0;

                        public void onError(DatabaseMigrationTask databasemigrationtask)
                        {
                            onPostExecuteTask(databasemigrationtask, false);
                        }

                        public void onSuccess(DatabaseMigrationTask databasemigrationtask)
                        {
                            onPostExecuteTask(databasemigrationtask, true);
                        }

            
            {
                this$0 = TruthDBMigrationHelper.this;
                super();
            }
                    });
                    executorService.submit(((Callable) (obj)));
                }
            } while (true);
            break MISSING_BLOCK_LABEL_105;
        }
        break MISSING_BLOCK_LABEL_93;
        databasemigrationtaskfilter;
        throw databasemigrationtaskfilter;
        GLogger.e(TAG, "TruthDBMigrationHelper initialization failed. Failed to acquire db connection", new Object[0]);
        this;
        JVM INSTR monitorexit ;
    }

    public void registerTaskForExecution(DatabaseMigrationTask databasemigrationtask)
    {
        this;
        JVM INSTR monitorenter ;
        registeredMigrationTasks.add(databasemigrationtask);
        this;
        JVM INSTR monitorexit ;
        return;
        databasemigrationtask;
        throw databasemigrationtask;
    }



}
