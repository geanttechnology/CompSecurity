// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.ct;
import android.support.v7.cu;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.parse:
//            TaskQueue, ParseSQLiteCursor

class ParseSQLiteDatabase
{

    private static final ExecutorService dbExecutor = Executors.newSingleThreadExecutor();
    private static final TaskQueue taskQueue = new TaskQueue();
    private cu current;
    private final Object currentLock = new Object();
    private SQLiteDatabase db;
    private int openFlags;
    private final android.support.v7.cu.a tcs = cu.a();

    private ParseSQLiteDatabase(int i)
    {
        current = null;
        openFlags = i;
        taskQueue.enqueue(new ct() {

            final ParseSQLiteDatabase this$0;

            public cu then(cu cu1)
                throws Exception
            {
                synchronized (currentLock)
                {
                    current = cu1;
                }
                return tcs.a();
                cu1;
                obj;
                JVM INSTR monitorexit ;
                throw cu1;
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
        });
    }

    static cu openDatabaseAsync(SQLiteOpenHelper sqliteopenhelper, int i)
    {
        ParseSQLiteDatabase parsesqlitedatabase = new ParseSQLiteDatabase(i);
        return parsesqlitedatabase.open(sqliteopenhelper).b(new ct(parsesqlitedatabase) {

            final ParseSQLiteDatabase val$db;

            public cu then(cu cu1)
                throws Exception
            {
                return cu.a(db);
            }

            public volatile Object then(cu cu1)
                throws Exception
            {
                return then(cu1);
            }

            
            {
                db = parsesqlitedatabase;
                super();
            }
        });
    }

    public cu beginTransactionAsync()
    {
        cu cu1;
        synchronized (currentLock)
        {
            current = current.b(new ct() {

                final ParseSQLiteDatabase this$0;

                public cu then(cu cu2)
                    throws Exception
                {
                    db.beginTransaction();
                    return cu2;
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, dbExecutor);
            cu1 = current.b(new ct() {

                final ParseSQLiteDatabase this$0;

                public cu then(cu cu2)
                    throws Exception
                {
                    return cu2;
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, cu.a);
        }
        return cu1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public cu closeAsync()
    {
        cu cu1;
        synchronized (currentLock)
        {
            current = current.b(new ct() {

                final ParseSQLiteDatabase this$0;

                public cu then(cu cu2)
                    throws Exception
                {
                    db.close();
                    tcs.b(null);
                    return tcs.a();
                    cu2;
                    tcs.b(null);
                    throw cu2;
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, dbExecutor);
            cu1 = current.b(new ct() {

                final ParseSQLiteDatabase this$0;

                public cu then(cu cu2)
                    throws Exception
                {
                    return cu2;
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, cu.a);
        }
        return cu1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public cu deleteAsync(final String table, final String where, final String args[])
    {
        synchronized (currentLock)
        {
            table = current.c(new ct() {

                final ParseSQLiteDatabase this$0;
                final String val$args[];
                final String val$table;
                final String val$where;

                public Integer then(cu cu1)
                    throws Exception
                {
                    cu1 = db;
                    String s = table;
                    String s1 = where;
                    String as[] = args;
                    int i;
                    if (!(cu1 instanceof SQLiteDatabase))
                    {
                        i = cu1.delete(s, s1, as);
                    } else
                    {
                        i = SQLiteInstrumentation.delete((SQLiteDatabase)cu1, s, s1, as);
                    }
                    return Integer.valueOf(i);
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                table = s;
                where = s1;
                args = as;
                super();
            }
            }, dbExecutor);
            current = table.j();
            table = table.b(new ct() {

                final ParseSQLiteDatabase this$0;

                public cu then(cu cu1)
                    throws Exception
                {
                    return cu1;
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, cu.a).j();
        }
        return table;
        table;
        obj;
        JVM INSTR monitorexit ;
        throw table;
    }

    public cu endTransactionAsync()
    {
        cu cu1;
        synchronized (currentLock)
        {
            current = current.a(new ct() {

                final ParseSQLiteDatabase this$0;

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

                public Void then(cu cu2)
                    throws Exception
                {
                    db.endTransaction();
                    return null;
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, dbExecutor);
            cu1 = current.b(new ct() {

                final ParseSQLiteDatabase this$0;

                public cu then(cu cu2)
                    throws Exception
                {
                    return cu2;
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, cu.a);
        }
        return cu1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean inTransaction()
    {
        return db.inTransaction();
    }

    public cu insertOrThrowAsync(final String table, final ContentValues values)
    {
        synchronized (currentLock)
        {
            table = current.c(new ct() {

                final ParseSQLiteDatabase this$0;
                final String val$table;
                final ContentValues val$values;

                public Long then(cu cu1)
                    throws Exception
                {
                    cu1 = db;
                    String s = table;
                    ContentValues contentvalues = values;
                    long l;
                    if (!(cu1 instanceof SQLiteDatabase))
                    {
                        l = cu1.insertOrThrow(s, null, contentvalues);
                    } else
                    {
                        l = SQLiteInstrumentation.insertOrThrow((SQLiteDatabase)cu1, s, null, contentvalues);
                    }
                    return Long.valueOf(l);
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                table = s;
                values = contentvalues;
                super();
            }
            }, dbExecutor);
            current = table.j();
            table = table.b(new ct() {

                final ParseSQLiteDatabase this$0;

                public cu then(cu cu1)
                    throws Exception
                {
                    return cu1;
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, cu.a).j();
        }
        return table;
        table;
        obj;
        JVM INSTR monitorexit ;
        throw table;
    }

    public cu insertWithOnConflict(final String table, final ContentValues values, final int conflictAlgorithm)
    {
        synchronized (currentLock)
        {
            table = current.c(new ct() {

                final ParseSQLiteDatabase this$0;
                final int val$conflictAlgorithm;
                final String val$table;
                final ContentValues val$values;

                public Long then(cu cu1)
                    throws Exception
                {
                    cu1 = db;
                    String s = table;
                    ContentValues contentvalues = values;
                    int i = conflictAlgorithm;
                    long l;
                    if (!(cu1 instanceof SQLiteDatabase))
                    {
                        l = cu1.insertWithOnConflict(s, null, contentvalues, i);
                    } else
                    {
                        l = SQLiteInstrumentation.insertWithOnConflict((SQLiteDatabase)cu1, s, null, contentvalues, i);
                    }
                    return Long.valueOf(l);
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                table = s;
                values = contentvalues;
                conflictAlgorithm = i;
                super();
            }
            }, dbExecutor);
            current = table.j();
            table = table.b(new ct() {

                final ParseSQLiteDatabase this$0;

                public cu then(cu cu1)
                    throws Exception
                {
                    return cu1;
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, cu.a).j();
        }
        return table;
        table;
        obj;
        JVM INSTR monitorexit ;
        throw table;
    }

    public cu isOpenAsync()
    {
        cu cu1;
        synchronized (currentLock)
        {
            cu1 = current.a(new ct() {

                final ParseSQLiteDatabase this$0;

                public Boolean then(cu cu2)
                    throws Exception
                {
                    return Boolean.valueOf(db.isOpen());
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            });
            current = cu1.j();
        }
        return cu1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public cu isReadOnlyAsync()
    {
        cu cu1;
        synchronized (currentLock)
        {
            cu1 = current.a(new ct() {

                final ParseSQLiteDatabase this$0;

                public Boolean then(cu cu2)
                    throws Exception
                {
                    return Boolean.valueOf(db.isReadOnly());
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            });
            current = cu1.j();
        }
        return cu1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    cu open(final SQLiteOpenHelper helper)
    {
        synchronized (currentLock)
        {
            current = current.a(new ct() {

                final ParseSQLiteDatabase this$0;
                final SQLiteOpenHelper val$helper;

                public SQLiteDatabase then(cu cu1)
                    throws Exception
                {
                    if ((openFlags & 1) == 1)
                    {
                        return helper.getReadableDatabase();
                    } else
                    {
                        return helper.getWritableDatabase();
                    }
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                helper = sqliteopenhelper;
                super();
            }
            }, dbExecutor).b(new ct() {

                final ParseSQLiteDatabase this$0;

                public cu then(cu cu1)
                    throws Exception
                {
                    db = (SQLiteDatabase)cu1.e();
                    return cu1.j();
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, cu.a);
            helper = current;
        }
        return helper;
        helper;
        obj;
        JVM INSTR monitorexit ;
        throw helper;
    }

    public cu queryAsync(final String table, final String select[], final String where, final String args[])
    {
        synchronized (currentLock)
        {
            table = current.c(new ct() {

                final ParseSQLiteDatabase this$0;
                final String val$args[];
                final String val$select[];
                final String val$table;
                final String val$where;

                public Cursor then(cu cu1)
                    throws Exception
                {
                    cu1 = db;
                    String s = table;
                    String as[] = select;
                    String s1 = where;
                    String as1[] = args;
                    if (!(cu1 instanceof SQLiteDatabase))
                    {
                        return cu1.query(s, as, s1, as1, null, null, null);
                    } else
                    {
                        return SQLiteInstrumentation.query((SQLiteDatabase)cu1, s, as, s1, as1, null, null, null);
                    }
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                table = s;
                select = as;
                where = s1;
                args = as1;
                super();
            }
            }, dbExecutor).c(new ct() {

                final ParseSQLiteDatabase this$0;

                public Cursor then(cu cu1)
                    throws Exception
                {
                    cu1 = ParseSQLiteCursor.create((Cursor)cu1.e(), ParseSQLiteDatabase.dbExecutor);
                    cu1.getCount();
                    return cu1;
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, dbExecutor);
            current = table.j();
            table = table.b(new ct() {

                final ParseSQLiteDatabase this$0;

                public cu then(cu cu1)
                    throws Exception
                {
                    return cu1;
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, cu.a);
        }
        return table;
        table;
        obj;
        JVM INSTR monitorexit ;
        throw table;
    }

    public cu rawQueryAsync(final String sql, final String args[])
    {
        synchronized (currentLock)
        {
            sql = current.c(new ct() {

                final ParseSQLiteDatabase this$0;
                final String val$args[];
                final String val$sql;

                public Cursor then(cu cu1)
                    throws Exception
                {
                    cu1 = db;
                    String s = sql;
                    String as[] = args;
                    if (!(cu1 instanceof SQLiteDatabase))
                    {
                        return cu1.rawQuery(s, as);
                    } else
                    {
                        return SQLiteInstrumentation.rawQuery((SQLiteDatabase)cu1, s, as);
                    }
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                sql = s;
                args = as;
                super();
            }
            }, dbExecutor).c(new ct() {

                final ParseSQLiteDatabase this$0;

                public Cursor then(cu cu1)
                    throws Exception
                {
                    cu1 = ParseSQLiteCursor.create((Cursor)cu1.e(), ParseSQLiteDatabase.dbExecutor);
                    cu1.getCount();
                    return cu1;
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, dbExecutor);
            current = sql.j();
            sql = sql.b(new ct() {

                final ParseSQLiteDatabase this$0;

                public cu then(cu cu1)
                    throws Exception
                {
                    return cu1;
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, cu.a);
        }
        return sql;
        sql;
        obj;
        JVM INSTR monitorexit ;
        throw sql;
    }

    public cu setTransactionSuccessfulAsync()
    {
        cu cu1;
        synchronized (currentLock)
        {
            current = current.d(new ct() {

                final ParseSQLiteDatabase this$0;

                public cu then(cu cu2)
                    throws Exception
                {
                    db.setTransactionSuccessful();
                    return cu2;
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, dbExecutor);
            cu1 = current.b(new ct() {

                final ParseSQLiteDatabase this$0;

                public cu then(cu cu2)
                    throws Exception
                {
                    return cu2;
                }

                public volatile Object then(cu cu2)
                    throws Exception
                {
                    return then(cu2);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, cu.a);
        }
        return cu1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public cu updateAsync(final String table, final ContentValues values, final String where, final String args[])
    {
        synchronized (currentLock)
        {
            table = current.c(new ct() {

                final ParseSQLiteDatabase this$0;
                final String val$args[];
                final String val$table;
                final ContentValues val$values;
                final String val$where;

                public Integer then(cu cu1)
                    throws Exception
                {
                    cu1 = db;
                    String s = table;
                    ContentValues contentvalues = values;
                    String s1 = where;
                    String as[] = args;
                    int i;
                    if (!(cu1 instanceof SQLiteDatabase))
                    {
                        i = cu1.update(s, contentvalues, s1, as);
                    } else
                    {
                        i = SQLiteInstrumentation.update((SQLiteDatabase)cu1, s, contentvalues, s1, as);
                    }
                    return Integer.valueOf(i);
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
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
            current = table.j();
            table = table.b(new ct() {

                final ParseSQLiteDatabase this$0;

                public cu then(cu cu1)
                    throws Exception
                {
                    return cu1;
                }

                public volatile Object then(cu cu1)
                    throws Exception
                {
                    return then(cu1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, cu.a);
        }
        return table;
        table;
        obj;
        JVM INSTR monitorexit ;
        throw table;
    }




/*
    static cu access$102(ParseSQLiteDatabase parsesqlitedatabase, cu cu1)
    {
        parsesqlitedatabase.current = cu1;
        return cu1;
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
