// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

public class ReadOnlySQLiteDatabase
{
    protected static class ReadOnlySQLiteStatement
    {

        protected final SQLiteStatement statement;

        public void bindAllArgsAsStrings(String as[])
        {
            if (as != null)
            {
                int i = 0;
                while (i < as.length) 
                {
                    statement.bindString(i + 1, as[i]);
                    i++;
                }
            }
        }

        public void bindLong(int i, long l)
        {
            statement.bindLong(i, l);
        }

        public void bindNull(int i)
        {
            statement.bindNull(i);
        }

        public void bindObject(int i, Object obj)
        {
            DatabaseUtils.bindObjectToProgram(statement, i, obj);
        }

        public void bindString(int i, String s)
        {
            statement.bindString(i, s);
        }

        public void clearBindings()
        {
            statement.clearBindings();
        }

        public void close()
        {
            statement.close();
        }

        public long simpleQueryForLong()
        {
            return statement.simpleQueryForLong();
        }

        public ReadOnlySQLiteStatement(SQLiteStatement sqlitestatement)
        {
            statement = sqlitestatement;
        }
    }


    protected final SQLiteDatabase database;

    ReadOnlySQLiteDatabase(SQLiteDatabase sqlitedatabase)
    {
        database = sqlitedatabase;
    }

    public void close()
    {
        database.close();
    }

    public ReadOnlySQLiteStatement compileStatement(String s)
        throws SQLException
    {
        return new ReadOnlySQLiteStatement(database.compileStatement(s));
    }

    public transient long count(String s, String s1, String as[])
    {
        return DatabaseUtils.queryNumEntries(database, s, s1, as);
    }

    public boolean inTransaction()
    {
        return database.inTransaction();
    }

    public Cursor query(String s, String as[], String s1, String as1[], String s2, String s3, String s4)
    {
        return database.query(s, as, s1, as1, s2, s3, s4);
    }

    public Cursor query(String s, String as[], String s1, String as1[], String s2, String s3, String s4, 
            String s5)
    {
        return database.query(s, as, s1, as1, s2, s3, s4, s5);
    }

    public Cursor query(boolean flag, String s, String as[], String s1, String as1[], String s2, String s3, 
            String s4, String s5)
    {
        return database.query(flag, s, as, s1, as1, s2, s3, s4, s5);
    }

    public Cursor rawQuery(String s, String as[])
    {
        return database.rawQuery(s, as);
    }
}
