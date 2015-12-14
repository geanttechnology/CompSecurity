// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import android.content.ContentValues;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            ReadOnlySQLiteDatabase

public class ReadWriteSQLiteDatabase extends ReadOnlySQLiteDatabase
{
    public static class ReadWriteSQLiteStatement extends ReadOnlySQLiteDatabase.ReadOnlySQLiteStatement
    {

        public volatile void bindAllArgsAsStrings(String as[])
        {
            super.bindAllArgsAsStrings(as);
        }

        public volatile void bindLong(int i, long l)
        {
            super.bindLong(i, l);
        }

        public volatile void bindNull(int i)
        {
            super.bindNull(i);
        }

        public volatile void bindObject(int i, Object obj)
        {
            super.bindObject(i, obj);
        }

        public volatile void bindString(int i, String s)
        {
            super.bindString(i, s);
        }

        public volatile void clearBindings()
        {
            super.clearBindings();
        }

        public volatile void close()
        {
            super.close();
        }

        public long executeInsert()
        {
            return statement.executeInsert();
        }

        public int executeUpdateDelete()
        {
            return statement.executeUpdateDelete();
        }

        public volatile long simpleQueryForLong()
        {
            return super.simpleQueryForLong();
        }

        public ReadWriteSQLiteStatement(SQLiteStatement sqlitestatement)
        {
            super(sqlitestatement);
        }
    }


    ReadWriteSQLiteDatabase(SQLiteDatabase sqlitedatabase)
    {
        super(sqlitedatabase);
    }

    public void beginTransaction()
    {
        database.beginTransaction();
    }

    public volatile ReadOnlySQLiteDatabase.ReadOnlySQLiteStatement compileStatement(String s)
        throws SQLException
    {
        return compileStatement(s);
    }

    public ReadWriteSQLiteStatement compileStatement(String s)
        throws SQLException
    {
        return new ReadWriteSQLiteStatement(database.compileStatement(s));
    }

    public int delete(String s, String s1, String as[])
    {
        return database.delete(s, s1, as);
    }

    public void endTransaction()
    {
        database.endTransaction();
    }

    public SQLiteDatabase getDatabase()
    {
        return database;
    }

    public boolean inTransaction()
    {
        return database.inTransaction();
    }

    public long insert(String s, String s1, ContentValues contentvalues)
    {
        return database.insert(s, s1, contentvalues);
    }

    public long replaceOrThrow(String s, String s1, ContentValues contentvalues)
        throws SQLException
    {
        return database.replaceOrThrow(s, s1, contentvalues);
    }

    public void setTransactionSuccessful()
    {
        database.setTransactionSuccessful();
    }

    public int update(String s, ContentValues contentvalues, String s1, String as[])
    {
        return database.update(s, contentvalues, s1, as);
    }
}
