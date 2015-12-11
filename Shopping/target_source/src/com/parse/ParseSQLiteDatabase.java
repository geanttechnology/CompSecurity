// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Referenced classes of package com.parse:
//            TaskQueue, ParseSQLiteCursor

class ParseSQLiteDatabase
{

    private static final ExecutorService dbExecutor = Executors.newSingleThreadExecutor();
    private static final TaskQueue taskQueue = new TaskQueue();
    private j current;
    private final Object currentLock = new Object();
    private SQLiteDatabase db;
    private int openFlags;
    private final a.j.a tcs = j.a();

    private ParseSQLiteDatabase(int i)
    {
        current = null;
        openFlags = i;
        taskQueue.enqueue(new i() {

            final ParseSQLiteDatabase this$0;

            public j then(j j1)
                throws Exception
            {
                synchronized (currentLock)
                {
                    current = j1;
                }
                return tcs.a();
                j1;
                obj;
                JVM INSTR monitorexit ;
                throw j1;
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
        });
    }

    static j openDatabaseAsync(SQLiteOpenHelper sqliteopenhelper, int i)
    {
        ParseSQLiteDatabase parsesqlitedatabase = new ParseSQLiteDatabase(i);
        return parsesqlitedatabase.open(sqliteopenhelper).b(new i(parsesqlitedatabase) {

            final ParseSQLiteDatabase val$db;

            public j then(j j1)
                throws Exception
            {
                return j.a(db);
            }

            public volatile Object then(j j1)
                throws Exception
            {
                return then(j1);
            }

            
            {
                db = parsesqlitedatabase;
                super();
            }
        });
    }

    public j beginTransactionAsync()
    {
        j j1;
        synchronized (currentLock)
        {
            current = current.b(new i() {

                final ParseSQLiteDatabase this$0;

                public j then(j j2)
                    throws Exception
                {
                    db.beginTransaction();
                    return j2;
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, dbExecutor);
            j1 = current.b(new i() {

                final ParseSQLiteDatabase this$0;

                public j then(j j2)
                    throws Exception
                {
                    return j2;
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, j.a);
        }
        return j1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public j closeAsync()
    {
        j j1;
        synchronized (currentLock)
        {
            current = current.b(new i() {

                final ParseSQLiteDatabase this$0;

                public j then(j j2)
                    throws Exception
                {
                    db.close();
                    tcs.b(null);
                    return tcs.a();
                    j2;
                    tcs.b(null);
                    throw j2;
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, dbExecutor);
            j1 = current.b(new i() {

                final ParseSQLiteDatabase this$0;

                public j then(j j2)
                    throws Exception
                {
                    return j2;
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, j.a);
        }
        return j1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public j deleteAsync(final String table, final String where, final String args[])
    {
        synchronized (currentLock)
        {
            table = current.c(new i() {

                final ParseSQLiteDatabase this$0;
                final String val$args[];
                final String val$table;
                final String val$where;

                public Integer then(j j1)
                    throws Exception
                {
                    j1 = db;
                    String s = table;
                    String s1 = where;
                    String as[] = args;
                    int k;
                    if (!(j1 instanceof SQLiteDatabase))
                    {
                        k = j1.delete(s, s1, as);
                    } else
                    {
                        k = SQLiteInstrumentation.delete((SQLiteDatabase)j1, s, s1, as);
                    }
                    return Integer.valueOf(k);
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
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
            table = table.b(new i() {

                final ParseSQLiteDatabase this$0;

                public j then(j j1)
                    throws Exception
                {
                    return j1;
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, j.a).j();
        }
        return table;
        table;
        obj;
        JVM INSTR monitorexit ;
        throw table;
    }

    public j endTransactionAsync()
    {
        j j1;
        synchronized (currentLock)
        {
            current = current.a(new i() {

                final ParseSQLiteDatabase this$0;

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

                public Void then(j j2)
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
            j1 = current.b(new i() {

                final ParseSQLiteDatabase this$0;

                public j then(j j2)
                    throws Exception
                {
                    return j2;
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, j.a);
        }
        return j1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public boolean inTransaction()
    {
        return db.inTransaction();
    }

    public j insertOrThrowAsync(final String table, final ContentValues values)
    {
        synchronized (currentLock)
        {
            table = current.c(new i() {

                final ParseSQLiteDatabase this$0;
                final String val$table;
                final ContentValues val$values;

                public Long then(j j1)
                    throws Exception
                {
                    j1 = db;
                    String s = table;
                    ContentValues contentvalues = values;
                    long l;
                    if (!(j1 instanceof SQLiteDatabase))
                    {
                        l = j1.insertOrThrow(s, null, contentvalues);
                    } else
                    {
                        l = SQLiteInstrumentation.insertOrThrow((SQLiteDatabase)j1, s, null, contentvalues);
                    }
                    return Long.valueOf(l);
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                table = s;
                values = contentvalues;
                super();
            }
            }, dbExecutor);
            current = table.j();
            table = table.b(new i() {

                final ParseSQLiteDatabase this$0;

                public j then(j j1)
                    throws Exception
                {
                    return j1;
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, j.a).j();
        }
        return table;
        table;
        obj;
        JVM INSTR monitorexit ;
        throw table;
    }

    public j insertWithOnConflict(final String table, final ContentValues values, final int conflictAlgorithm)
    {
        synchronized (currentLock)
        {
            table = current.c(new i() {

                final ParseSQLiteDatabase this$0;
                final int val$conflictAlgorithm;
                final String val$table;
                final ContentValues val$values;

                public Long then(j j1)
                    throws Exception
                {
                    j1 = db;
                    String s = table;
                    ContentValues contentvalues = values;
                    int k = conflictAlgorithm;
                    long l;
                    if (!(j1 instanceof SQLiteDatabase))
                    {
                        l = j1.insertWithOnConflict(s, null, contentvalues, k);
                    } else
                    {
                        l = SQLiteInstrumentation.insertWithOnConflict((SQLiteDatabase)j1, s, null, contentvalues, k);
                    }
                    return Long.valueOf(l);
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                table = s;
                values = contentvalues;
                conflictAlgorithm = k;
                super();
            }
            }, dbExecutor);
            current = table.j();
            table = table.b(new i() {

                final ParseSQLiteDatabase this$0;

                public j then(j j1)
                    throws Exception
                {
                    return j1;
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, j.a).j();
        }
        return table;
        table;
        obj;
        JVM INSTR monitorexit ;
        throw table;
    }

    public j isOpenAsync()
    {
        j j1;
        synchronized (currentLock)
        {
            j1 = current.a(new i() {

                final ParseSQLiteDatabase this$0;

                public Boolean then(j j2)
                    throws Exception
                {
                    return Boolean.valueOf(db.isOpen());
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            });
            current = j1.j();
        }
        return j1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public j isReadOnlyAsync()
    {
        j j1;
        synchronized (currentLock)
        {
            j1 = current.a(new i() {

                final ParseSQLiteDatabase this$0;

                public Boolean then(j j2)
                    throws Exception
                {
                    return Boolean.valueOf(db.isReadOnly());
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            });
            current = j1.j();
        }
        return j1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    j open(final SQLiteOpenHelper helper)
    {
        synchronized (currentLock)
        {
            current = current.a(new i() {

                final ParseSQLiteDatabase this$0;
                final SQLiteOpenHelper val$helper;

                public SQLiteDatabase then(j j1)
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

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                helper = sqliteopenhelper;
                super();
            }
            }, dbExecutor).b(new i() {

                final ParseSQLiteDatabase this$0;

                public j then(j j1)
                    throws Exception
                {
                    db = (SQLiteDatabase)j1.e();
                    return j1.j();
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, j.a);
            helper = current;
        }
        return helper;
        helper;
        obj;
        JVM INSTR monitorexit ;
        throw helper;
    }

    public j queryAsync(final String table, final String select[], final String where, final String args[])
    {
        synchronized (currentLock)
        {
            table = current.c(new i() {

                final ParseSQLiteDatabase this$0;
                final String val$args[];
                final String val$select[];
                final String val$table;
                final String val$where;

                public Cursor then(j j1)
                    throws Exception
                {
                    j1 = db;
                    String s = table;
                    String as[] = select;
                    String s1 = where;
                    String as1[] = args;
                    if (!(j1 instanceof SQLiteDatabase))
                    {
                        return j1.query(s, as, s1, as1, null, null, null);
                    } else
                    {
                        return SQLiteInstrumentation.query((SQLiteDatabase)j1, s, as, s1, as1, null, null, null);
                    }
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                table = s;
                select = as;
                where = s1;
                args = as1;
                super();
            }
            }, dbExecutor).c(new i() {

                final ParseSQLiteDatabase this$0;

                public Cursor then(j j1)
                    throws Exception
                {
                    j1 = ParseSQLiteCursor.create((Cursor)j1.e(), ParseSQLiteDatabase.dbExecutor);
                    j1.getCount();
                    return j1;
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, dbExecutor);
            current = table.j();
            table = table.b(new i() {

                final ParseSQLiteDatabase this$0;

                public j then(j j1)
                    throws Exception
                {
                    return j1;
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, j.a);
        }
        return table;
        table;
        obj;
        JVM INSTR monitorexit ;
        throw table;
    }

    public j rawQueryAsync(final String sql, final String args[])
    {
        synchronized (currentLock)
        {
            sql = current.c(new i() {

                final ParseSQLiteDatabase this$0;
                final String val$args[];
                final String val$sql;

                public Cursor then(j j1)
                    throws Exception
                {
                    j1 = db;
                    String s = sql;
                    String as[] = args;
                    if (!(j1 instanceof SQLiteDatabase))
                    {
                        return j1.rawQuery(s, as);
                    } else
                    {
                        return SQLiteInstrumentation.rawQuery((SQLiteDatabase)j1, s, as);
                    }
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                sql = s;
                args = as;
                super();
            }
            }, dbExecutor).c(new i() {

                final ParseSQLiteDatabase this$0;

                public Cursor then(j j1)
                    throws Exception
                {
                    j1 = ParseSQLiteCursor.create((Cursor)j1.e(), ParseSQLiteDatabase.dbExecutor);
                    j1.getCount();
                    return j1;
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, dbExecutor);
            current = sql.j();
            sql = sql.b(new i() {

                final ParseSQLiteDatabase this$0;

                public j then(j j1)
                    throws Exception
                {
                    return j1;
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, j.a);
        }
        return sql;
        sql;
        obj;
        JVM INSTR monitorexit ;
        throw sql;
    }

    public j setTransactionSuccessfulAsync()
    {
        j j1;
        synchronized (currentLock)
        {
            current = current.d(new i() {

                final ParseSQLiteDatabase this$0;

                public j then(j j2)
                    throws Exception
                {
                    db.setTransactionSuccessful();
                    return j2;
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, dbExecutor);
            j1 = current.b(new i() {

                final ParseSQLiteDatabase this$0;

                public j then(j j2)
                    throws Exception
                {
                    return j2;
                }

                public volatile Object then(j j2)
                    throws Exception
                {
                    return then(j2);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, j.a);
        }
        return j1;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public j updateAsync(final String table, final ContentValues values, final String where, final String args[])
    {
        synchronized (currentLock)
        {
            table = current.c(new i() {

                final ParseSQLiteDatabase this$0;
                final String val$args[];
                final String val$table;
                final ContentValues val$values;
                final String val$where;

                public Integer then(j j1)
                    throws Exception
                {
                    j1 = db;
                    String s = table;
                    ContentValues contentvalues = values;
                    String s1 = where;
                    String as[] = args;
                    int k;
                    if (!(j1 instanceof SQLiteDatabase))
                    {
                        k = j1.update(s, contentvalues, s1, as);
                    } else
                    {
                        k = SQLiteInstrumentation.update((SQLiteDatabase)j1, s, contentvalues, s1, as);
                    }
                    return Integer.valueOf(k);
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
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
            table = table.b(new i() {

                final ParseSQLiteDatabase this$0;

                public j then(j j1)
                    throws Exception
                {
                    return j1;
                }

                public volatile Object then(j j1)
                    throws Exception
                {
                    return then(j1);
                }

            
            {
                this$0 = ParseSQLiteDatabase.this;
                super();
            }
            }, j.a);
        }
        return table;
        table;
        obj;
        JVM INSTR monitorexit ;
        throw table;
    }




/*
    static j access$102(ParseSQLiteDatabase parsesqlitedatabase, j j1)
    {
        parsesqlitedatabase.current = j1;
        return j1;
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
