// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.y.a;

import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.y.e.b;

// Referenced classes of package com.shazam.i.b.y.a:
//            b

final class d
{

    private static SQLiteDatabase a = null;
    private static SQLiteDatabase b = null;

    static SQLiteDatabase a()
    {
        com/shazam/i/b/y/a/d;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        if (a == null)
        {
            a = com.shazam.i.b.y.a.b.a().getWritableDatabase();
        }
        sqlitedatabase = a;
        com/shazam/i/b/y/a/d;
        JVM INSTR monitorexit ;
        return sqlitedatabase;
        Exception exception;
        exception;
        throw exception;
    }

    static SQLiteDatabase b()
    {
        com/shazam/i/b/y/a/d;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        if (b == null)
        {
            b = com.shazam.i.b.y.a.b.a().getReadableDatabase();
        }
        sqlitedatabase = b;
        com/shazam/i/b/y/a/d;
        JVM INSTR monitorexit ;
        return sqlitedatabase;
        Exception exception;
        exception;
        throw exception;
    }

}
