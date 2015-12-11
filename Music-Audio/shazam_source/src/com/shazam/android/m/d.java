// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.m;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.b.a.a;

// Referenced classes of package com.shazam.android.m:
//            b, a, c

public final class d
    implements b
{

    private final Object b;
    private final SQLiteDatabase c;
    private final SQLiteDatabase d;

    public d(Object obj, SQLiteDatabase sqlitedatabase, SQLiteDatabase sqlitedatabase1)
    {
        b = obj;
        c = sqlitedatabase;
        d = sqlitedatabase1;
    }

    public final Cursor a(com.shazam.android.m.a a1)
    {
        synchronized (b)
        {
            a1 = a1.a(d);
        }
        return a1;
        a1;
        obj;
        JVM INSTR monitorexit ;
        throw a1;
    }

    public final Object a(com.shazam.android.m.a a1, a a2)
    {
        synchronized (b)
        {
            a1 = a1.a(d);
        }
        return a2.a(a1);
        a1;
        obj;
        JVM INSTR monitorexit ;
        throw a1;
    }

    public final void a(c c1)
    {
        Object obj = b;
        obj;
        JVM INSTR monitorenter ;
        c.beginTransaction();
        c1.a(c);
        c.setTransactionSuccessful();
        c.endTransaction();
        obj;
        JVM INSTR monitorexit ;
        return;
        c1;
        c.endTransaction();
        throw c1;
        c1;
        obj;
        JVM INSTR monitorexit ;
        throw c1;
    }
}
