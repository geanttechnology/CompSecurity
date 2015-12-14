// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.model.database;

import android.database.sqlite.SQLiteDatabase;
import com.cyberlink.beautycircle.Globals;
import com.cyberlink.beautycircle.model.database.a.a;

// Referenced classes of package com.cyberlink.beautycircle.model.database:
//            c

public abstract class b
{

    private static c a;
    private static SQLiteDatabase b;
    private static SQLiteDatabase c;
    private static a d;

    public static SQLiteDatabase a()
    {
        com/cyberlink/beautycircle/model/database/b;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        if (b == null)
        {
            b = d().getReadableDatabase();
        }
        sqlitedatabase = b;
        com/cyberlink/beautycircle/model/database/b;
        JVM INSTR monitorexit ;
        return sqlitedatabase;
        Exception exception;
        exception;
        throw exception;
    }

    public static SQLiteDatabase b()
    {
        com/cyberlink/beautycircle/model/database/b;
        JVM INSTR monitorenter ;
        SQLiteDatabase sqlitedatabase;
        if (c == null)
        {
            c = d().getWritableDatabase();
        }
        sqlitedatabase = c;
        com/cyberlink/beautycircle/model/database/b;
        JVM INSTR monitorexit ;
        return sqlitedatabase;
        Exception exception;
        exception;
        throw exception;
    }

    public static a c()
    {
        com/cyberlink/beautycircle/model/database/b;
        JVM INSTR monitorenter ;
        a a1;
        if (d == null)
        {
            d = new a();
        }
        a1 = d;
        com/cyberlink/beautycircle/model/database/b;
        JVM INSTR monitorexit ;
        return a1;
        Exception exception;
        exception;
        throw exception;
    }

    private static c d()
    {
        com/cyberlink/beautycircle/model/database/b;
        JVM INSTR monitorenter ;
        c c1;
        if (a == null)
        {
            a = new c(Globals.n());
        }
        c1 = a;
        com/cyberlink/beautycircle/model/database/b;
        JVM INSTR monitorexit ;
        return c1;
        Exception exception;
        exception;
        throw exception;
    }
}
