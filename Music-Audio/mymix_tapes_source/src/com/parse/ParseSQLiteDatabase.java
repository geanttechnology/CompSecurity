// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import bolts.Continuation;
import bolts.Task;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.parse:
//            TaskQueue

class ParseSQLiteDatabase
{

    private static final ExecutorService dbExecutor = Executors.newSingleThreadExecutor();
    private static final TaskQueue taskQueue = new TaskQueue();
    private Task current;
    private final Object currentLock = new Object();
    private SQLiteDatabase db;
    private final bolts.Task.TaskCompletionSource tcs = Task.create();
    private boolean writable;

    ParseSQLiteDatabase(boolean flag)
    {
        current = null;
        writable = flag;
        taskQueue.enqueue(new Continuation() {

            final ParseSQLiteDatabase this$0;

            public Task then(Task task)
                throws Exception
            {
                synchronized (currentLock)
                {
                    current = task;
                }
                return tcs.getTask();
                task;
                obj;
                JVM INSTR monitorexit ;
                throw task;
            }

            public volatile Object then(Task task)
                throws Exception
            {
                return then(task);
            }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
        });
    }

    public Task beginTransactionAsync()
    {
        Task task;
        synchronized (currentLock)
        {
            current = current.continueWithTask(new Continuation() {

                final ParseSQLiteDatabase this$0;

                public Task then(Task task1)
                    throws Exception
                {
                    db.beginTransaction();
                    return task1;
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, dbExecutor);
            task = current.continueWithTask(new Continuation() {

                final ParseSQLiteDatabase this$0;

                public Task then(Task task1)
                    throws Exception
                {
                    return task1;
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, Task.BACKGROUND_EXECUTOR);
        }
        return task;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Task close()
    {
        Task task;
        synchronized (currentLock)
        {
            current = current.continueWithTask(new Continuation() {

                final ParseSQLiteDatabase this$0;

                public Task then(Task task1)
                    throws Exception
                {
                    db.close();
                    tcs.setResult(null);
                    return tcs.getTask();
                    task1;
                    tcs.setResult(null);
                    throw task1;
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, dbExecutor);
            task = current.continueWithTask(new Continuation() {

                final ParseSQLiteDatabase this$0;

                public Task then(Task task1)
                    throws Exception
                {
                    return task1;
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, Task.BACKGROUND_EXECUTOR);
        }
        return task;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Task deleteAsync(final String table, final String where, final String args[])
    {
        synchronized (currentLock)
        {
            table = current.onSuccessTask(new Continuation() {

                final ParseSQLiteDatabase this$0;
                final String val$args[];
                final String val$table;
                final String val$where;

                public Task then(Task task)
                    throws Exception
                {
                    return Task.forResult(Integer.valueOf(db.delete(table, where, args)));
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                table = s;
                where = s1;
                args = as;
                super();
            }
            }, dbExecutor);
            current = table.makeVoid();
            table = table.continueWithTask(new Continuation() {

                final ParseSQLiteDatabase this$0;

                public Task then(Task task)
                    throws Exception
                {
                    return task;
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, Task.BACKGROUND_EXECUTOR).makeVoid();
        }
        return table;
        table;
        obj;
        JVM INSTR monitorexit ;
        throw table;
    }

    public Task endTransactionAsync()
    {
        Task task;
        synchronized (currentLock)
        {
            current = current.continueWithTask(new Continuation() {

                final ParseSQLiteDatabase this$0;

                public Task then(Task task1)
                    throws Exception
                {
                    db.endTransaction();
                    return Task.forResult(null);
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, dbExecutor);
            task = current.continueWithTask(new Continuation() {

                final ParseSQLiteDatabase this$0;

                public Task then(Task task1)
                    throws Exception
                {
                    return task1;
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, Task.BACKGROUND_EXECUTOR);
        }
        return task;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean inTransaction()
    {
        return db.inTransaction();
    }

    public Task insertOrThrowAsync(final String table, final ContentValues values)
    {
        synchronized (currentLock)
        {
            table = current.onSuccessTask(new Continuation() {

                final ParseSQLiteDatabase this$0;
                final String val$table;
                final ContentValues val$values;

                public Task then(Task task)
                    throws Exception
                {
                    return Task.forResult(Long.valueOf(db.insertOrThrow(table, null, values)));
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                table = s;
                values = contentvalues;
                super();
            }
            }, dbExecutor);
            current = table.makeVoid();
            table = table.continueWithTask(new Continuation() {

                final ParseSQLiteDatabase this$0;

                public Task then(Task task)
                    throws Exception
                {
                    return task;
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, Task.BACKGROUND_EXECUTOR).makeVoid();
        }
        return table;
        table;
        obj;
        JVM INSTR monitorexit ;
        throw table;
    }

    public Task insertWithOnConflict(final String table, final ContentValues values, final int conflictAlgorithm)
    {
        synchronized (currentLock)
        {
            table = current.onSuccessTask(new Continuation() {

                final ParseSQLiteDatabase this$0;
                final int val$conflictAlgorithm;
                final String val$table;
                final ContentValues val$values;

                public Task then(Task task)
                    throws Exception
                {
                    return Task.forResult(Long.valueOf(db.insertWithOnConflict(table, null, values, conflictAlgorithm)));
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                table = s;
                values = contentvalues;
                conflictAlgorithm = i;
                super();
            }
            }, dbExecutor);
            current = table.makeVoid();
            table = table.continueWithTask(new Continuation() {

                final ParseSQLiteDatabase this$0;

                public Task then(Task task)
                    throws Exception
                {
                    return task;
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, Task.BACKGROUND_EXECUTOR).makeVoid();
        }
        return table;
        table;
        obj;
        JVM INSTR monitorexit ;
        throw table;
    }

    public boolean isOpen()
    {
        return db.isOpen();
    }

    public boolean isWritable()
    {
        return writable;
    }

    Task open(final SQLiteOpenHelper helper)
    {
        synchronized (currentLock)
        {
            current = current.continueWithTask(new Continuation() {

                final ParseSQLiteDatabase this$0;
                final SQLiteOpenHelper val$helper;

                public Task then(Task task)
                    throws Exception
                {
                    if (writable)
                    {
                        task = helper.getWritableDatabase();
                    } else
                    {
                        task = helper.getReadableDatabase();
                    }
                    return Task.forResult(task);
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                helper = sqliteopenhelper;
                super();
            }
            }, dbExecutor).continueWithTask(new Continuation() {

                final ParseSQLiteDatabase this$0;

                public Task then(Task task)
                    throws Exception
                {
                    db = (SQLiteDatabase)task.getResult();
                    return task.makeVoid();
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, Task.BACKGROUND_EXECUTOR);
            helper = current;
        }
        return helper;
        helper;
        obj;
        JVM INSTR monitorexit ;
        throw helper;
    }

    public Task queryAsync(final String table, final String select[], final String where, final String args[])
    {
        synchronized (currentLock)
        {
            table = current.onSuccessTask(new Continuation() {

                final ParseSQLiteDatabase this$0;
                final String val$args[];
                final String val$select[];
                final String val$table;
                final String val$where;

                public Task then(Task task)
                    throws Exception
                {
                    return Task.forResult(db.query(table, select, where, args, null, null, null));
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                table = s;
                select = as;
                where = s1;
                args = as1;
                super();
            }
            }, dbExecutor).onSuccessTask(new Continuation() {

                final ParseSQLiteDatabase this$0;

                public Task then(Task task)
                    throws Exception
                {
                    task = (Cursor)task.getResult();
                    return Task.forResult(Integer.valueOf(task.getCount())).continueWithTask(task. new Continuation() {

                        final _cls12 this$1;
                        final Cursor val$cursor;

                        public Task then(Task task)
                            throws Exception
                        {
                            return Task.forResult(cursor);
                        }

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

            
            {
                this$1 = final__pcls12;
                cursor = Cursor.this;
                super();
            }
                    });
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, dbExecutor);
            current = table.makeVoid();
            table = table.continueWithTask(new Continuation() {

                final ParseSQLiteDatabase this$0;

                public Task then(Task task)
                    throws Exception
                {
                    return task;
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, Task.BACKGROUND_EXECUTOR);
        }
        return table;
        table;
        obj;
        JVM INSTR monitorexit ;
        throw table;
    }

    public Task rawQueryAsync(final String sql, final String args[])
    {
        synchronized (currentLock)
        {
            sql = current.onSuccessTask(new Continuation() {

                final ParseSQLiteDatabase this$0;
                final String val$args[];
                final String val$sql;

                public Task then(Task task)
                    throws Exception
                {
                    return Task.forResult(db.rawQuery(sql, args));
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                sql = s;
                args = as;
                super();
            }
            }, dbExecutor).onSuccessTask(new Continuation() {

                final ParseSQLiteDatabase this$0;

                public Task then(Task task)
                    throws Exception
                {
                    task = (Cursor)task.getResult();
                    return Task.forResult(Integer.valueOf(task.getCount())).continueWithTask(task. new Continuation() {

                        final _cls23 this$1;
                        final Cursor val$cursor;

                        public Task then(Task task)
                            throws Exception
                        {
                            return Task.forResult(cursor);
                        }

                        public volatile Object then(Task task)
                            throws Exception
                        {
                            return then(task);
                        }

            
            {
                this$1 = final__pcls23;
                cursor = Cursor.this;
                super();
            }
                    });
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, dbExecutor);
            current = sql.makeVoid();
            sql = sql.continueWithTask(new Continuation() {

                final ParseSQLiteDatabase this$0;

                public Task then(Task task)
                    throws Exception
                {
                    return task;
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, Task.BACKGROUND_EXECUTOR);
        }
        return sql;
        sql;
        obj;
        JVM INSTR monitorexit ;
        throw sql;
    }

    public Task setTransactionSuccessfulAsync()
    {
        Task task;
        synchronized (currentLock)
        {
            current = current.onSuccessTask(new Continuation() {

                final ParseSQLiteDatabase this$0;

                public Task then(Task task1)
                    throws Exception
                {
                    db.setTransactionSuccessful();
                    return task1;
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, dbExecutor);
            task = current.continueWithTask(new Continuation() {

                final ParseSQLiteDatabase this$0;

                public Task then(Task task1)
                    throws Exception
                {
                    return task1;
                }

                public volatile Object then(Task task1)
                    throws Exception
                {
                    return then(task1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, Task.BACKGROUND_EXECUTOR);
        }
        return task;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public Task updateAsync(final String table, final ContentValues values, final String where, final String args[])
    {
        synchronized (currentLock)
        {
            table = current.onSuccessTask(new Continuation() {

                final ParseSQLiteDatabase this$0;
                final String val$args[];
                final String val$table;
                final ContentValues val$values;
                final String val$where;

                public Task then(Task task)
                    throws Exception
                {
                    return Task.forResult(Integer.valueOf(db.update(table, values, where, args)));
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                table = s;
                values = contentvalues;
                where = s1;
                args = as;
                super();
            }
            }, dbExecutor);
            current = table.makeVoid();
            table = table.continueWithTask(new Continuation() {

                final ParseSQLiteDatabase this$0;

                public Task then(Task task)
                    throws Exception
                {
                    return task;
                }

                public volatile Object then(Task task)
                    throws Exception
                {
                    return then(task);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, Task.BACKGROUND_EXECUTOR);
        }
        return table;
        table;
        obj;
        JVM INSTR monitorexit ;
        throw table;
    }




/*
    static Task access$102(ParseSQLiteDatabase parsesqlitedatabase, Task task)
    {
        parsesqlitedatabase.current = task;
        return task;
    }

*/




/*
    static SQLiteDatabase access$302(ParseSQLiteDatabase parsesqlitedatabase, SQLiteDatabase sqlitedatabase)
    {
        parsesqlitedatabase.db = sqlitedatabase;
        return sqlitedatabase;
    }

*/

}
