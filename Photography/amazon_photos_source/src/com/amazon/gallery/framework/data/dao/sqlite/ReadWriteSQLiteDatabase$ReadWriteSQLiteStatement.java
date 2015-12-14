// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.gallery.framework.data.dao.sqlite;

import android.database.sqlite.SQLiteStatement;

// Referenced classes of package com.amazon.gallery.framework.data.dao.sqlite:
//            ReadWriteSQLiteDatabase

public static class nit> extends nit>
{

    public volatile void bindAllArgsAsStrings(String as[])
    {
        super.ndAllArgsAsStrings(as);
    }

    public volatile void bindLong(int i, long l)
    {
        super.ndLong(i, l);
    }

    public volatile void bindNull(int i)
    {
        super.ndNull(i);
    }

    public volatile void bindObject(int i, Object obj)
    {
        super.ndObject(i, obj);
    }

    public volatile void bindString(int i, String s)
    {
        super.ndString(i, s);
    }

    public volatile void clearBindings()
    {
        super.earBindings();
    }

    public volatile void close()
    {
        super.ose();
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
        return super.mpleQueryForLong();
    }

    public (SQLiteStatement sqlitestatement)
    {
        super(sqlitestatement);
    }
}
