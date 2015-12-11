// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.CancellationSignal;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.Arrays;

// Referenced classes of package com.newrelic.agent.android.instrumentation:
//            MetricCategory

public class SQLiteInstrumentation
{

    private static final ArrayList categoryParams = new ArrayList(Arrays.asList(new String[] {
        "category", com/newrelic/agent/android/instrumentation/MetricCategory.getName(), "DATABASE"
    }));

    SQLiteInstrumentation()
    {
    }

    public static int delete(SQLiteDatabase sqlitedatabase, String s, String s1, String as[])
    {
        TraceMachine.enterMethod("SQLiteDatabase#delete", categoryParams);
        int i = sqlitedatabase.delete(s, s1, as);
        TraceMachine.exitMethod();
        return i;
    }

    public static void execSQL(SQLiteDatabase sqlitedatabase, String s)
        throws SQLException
    {
        TraceMachine.enterMethod("SQLiteDatabase#execSQL", categoryParams);
        sqlitedatabase.execSQL(s);
        TraceMachine.exitMethod();
    }

    public static void execSQL(SQLiteDatabase sqlitedatabase, String s, Object aobj[])
        throws SQLException
    {
        TraceMachine.enterMethod("SQLiteDatabase#execSQL", categoryParams);
        sqlitedatabase.execSQL(s, aobj);
        TraceMachine.exitMethod();
    }

    public static long insert(SQLiteDatabase sqlitedatabase, String s, String s1, ContentValues contentvalues)
    {
        TraceMachine.enterMethod("SQLiteDatabase#insert", categoryParams);
        long l = sqlitedatabase.insert(s, s1, contentvalues);
        TraceMachine.exitMethod();
        return l;
    }

    public static long insertOrThrow(SQLiteDatabase sqlitedatabase, String s, String s1, ContentValues contentvalues)
        throws SQLException
    {
        TraceMachine.enterMethod("SQLiteDatabase#insertOrThrow", categoryParams);
        long l = sqlitedatabase.insertOrThrow(s, s1, contentvalues);
        TraceMachine.exitMethod();
        return l;
    }

    public static long insertWithOnConflict(SQLiteDatabase sqlitedatabase, String s, String s1, ContentValues contentvalues, int i)
    {
        TraceMachine.enterMethod("SQLiteDatabase#insertWithOnConflict", categoryParams);
        long l = sqlitedatabase.insertWithOnConflict(s, s1, contentvalues, i);
        TraceMachine.exitMethod();
        return l;
    }

    public static Cursor query(SQLiteDatabase sqlitedatabase, String s, String as[], String s1, String as1[], String s2, String s3, String s4)
    {
        TraceMachine.enterMethod("SQLiteDatabase#query", categoryParams);
        sqlitedatabase = sqlitedatabase.query(s, as, s1, as1, s2, s3, s4);
        TraceMachine.exitMethod();
        return sqlitedatabase;
    }

    public static Cursor query(SQLiteDatabase sqlitedatabase, String s, String as[], String s1, String as1[], String s2, String s3, String s4, 
            String s5)
    {
        TraceMachine.enterMethod("SQLiteDatabase#query", categoryParams);
        sqlitedatabase = sqlitedatabase.query(s, as, s1, as1, s2, s3, s4, s5);
        TraceMachine.exitMethod();
        return sqlitedatabase;
    }

    public static Cursor query(SQLiteDatabase sqlitedatabase, boolean flag, String s, String as[], String s1, String as1[], String s2, String s3, 
            String s4, String s5)
    {
        TraceMachine.enterMethod("SQLiteDatabase#query", categoryParams);
        sqlitedatabase = sqlitedatabase.query(flag, s, as, s1, as1, s2, s3, s4, s5);
        TraceMachine.exitMethod();
        return sqlitedatabase;
    }

    public static Cursor query(SQLiteDatabase sqlitedatabase, boolean flag, String s, String as[], String s1, String as1[], String s2, String s3, 
            String s4, String s5, CancellationSignal cancellationsignal)
    {
        TraceMachine.enterMethod("SQLiteDatabase#query", categoryParams);
        sqlitedatabase = sqlitedatabase.query(flag, s, as, s1, as1, s2, s3, s4, s5, cancellationsignal);
        TraceMachine.exitMethod();
        return sqlitedatabase;
    }

    public static Cursor queryWithFactory(SQLiteDatabase sqlitedatabase, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory, boolean flag, String s, String as[], String s1, String as1[], String s2, 
            String s3, String s4, String s5)
    {
        TraceMachine.enterMethod("SQLiteDatabase#queryWithFactory", categoryParams);
        sqlitedatabase = sqlitedatabase.queryWithFactory(cursorfactory, flag, s, as, s1, as1, s2, s3, s4, s5);
        TraceMachine.exitMethod();
        return sqlitedatabase;
    }

    public static Cursor queryWithFactory(SQLiteDatabase sqlitedatabase, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory, boolean flag, String s, String as[], String s1, String as1[], String s2, 
            String s3, String s4, String s5, CancellationSignal cancellationsignal)
    {
        TraceMachine.enterMethod("SQLiteDatabase#queryWithFactory", categoryParams);
        sqlitedatabase = sqlitedatabase.queryWithFactory(cursorfactory, flag, s, as, s1, as1, s2, s3, s4, s5, cancellationsignal);
        TraceMachine.exitMethod();
        return sqlitedatabase;
    }

    public static Cursor rawQuery(SQLiteDatabase sqlitedatabase, String s, String as[])
    {
        TraceMachine.enterMethod("SQLiteDatabase#rawQuery", categoryParams);
        sqlitedatabase = sqlitedatabase.rawQuery(s, as);
        TraceMachine.exitMethod();
        return sqlitedatabase;
    }

    public static Cursor rawQuery(SQLiteDatabase sqlitedatabase, String s, String as[], CancellationSignal cancellationsignal)
    {
        TraceMachine.enterMethod("SQLiteDatabase#rawQuery", categoryParams);
        sqlitedatabase = sqlitedatabase.rawQuery(s, as, cancellationsignal);
        TraceMachine.exitMethod();
        return sqlitedatabase;
    }

    public static Cursor rawQueryWithFactory(SQLiteDatabase sqlitedatabase, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory, String s, String as[], String s1)
    {
        TraceMachine.enterMethod("SQLiteDatabase#rawQueryWithFactory", categoryParams);
        sqlitedatabase = sqlitedatabase.rawQueryWithFactory(cursorfactory, s, as, s1);
        TraceMachine.exitMethod();
        return sqlitedatabase;
    }

    public static Cursor rawQueryWithFactory(SQLiteDatabase sqlitedatabase, android.database.sqlite.SQLiteDatabase.CursorFactory cursorfactory, String s, String as[], String s1, CancellationSignal cancellationsignal)
    {
        TraceMachine.enterMethod("SQLiteDatabase#rawQueryWithFactory", categoryParams);
        sqlitedatabase = sqlitedatabase.rawQueryWithFactory(cursorfactory, s, as, s1, cancellationsignal);
        TraceMachine.exitMethod();
        return sqlitedatabase;
    }

    public static long replace(SQLiteDatabase sqlitedatabase, String s, String s1, ContentValues contentvalues)
    {
        TraceMachine.enterMethod("SQLiteDatabase#replace", categoryParams);
        long l = sqlitedatabase.replace(s, s1, contentvalues);
        TraceMachine.exitMethod();
        return l;
    }

    public static long replaceOrThrow(SQLiteDatabase sqlitedatabase, String s, String s1, ContentValues contentvalues)
        throws SQLException
    {
        TraceMachine.enterMethod("SQLiteDatabase#replaceOrThrow", categoryParams);
        long l = sqlitedatabase.replaceOrThrow(s, s1, contentvalues);
        TraceMachine.exitMethod();
        return l;
    }

    public static int update(SQLiteDatabase sqlitedatabase, String s, ContentValues contentvalues, String s1, String as[])
    {
        TraceMachine.enterMethod("SQLiteDatabase#update", categoryParams);
        int i = sqlitedatabase.update(s, contentvalues, s1, as);
        TraceMachine.exitMethod();
        return i;
    }

    public static int updateWithOnConflict(SQLiteDatabase sqlitedatabase, String s, ContentValues contentvalues, String s1, String as[], int i)
    {
        TraceMachine.enterMethod("SQLiteDatabase#updateWithOnConflict", categoryParams);
        i = sqlitedatabase.updateWithOnConflict(s, contentvalues, s1, as, i);
        TraceMachine.exitMethod();
        return i;
    }

}
