// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteStatement;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            ReadOnlySQLiteDatabase

protected static class statement
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

    public a(SQLiteStatement sqlitestatement)
    {
        statement = sqlitestatement;
    }
}
