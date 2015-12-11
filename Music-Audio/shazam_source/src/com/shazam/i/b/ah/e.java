// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.ah;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.shazam.android.persistence.l.a;

// Referenced classes of package com.shazam.i.b.ah:
//            d

public final class e
{

    private static SQLiteDatabase a = null;
    private static SQLiteDatabase b = null;

    public static SQLiteDatabase a(Context context)
    {
        com/shazam/i/b/ah/e;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            a = com.shazam.i.b.ah.d.a(context).getWritableDatabase();
        }
        context = a;
        com/shazam/i/b/ah/e;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static SQLiteDatabase b(Context context)
    {
        com/shazam/i/b/ah/e;
        JVM INSTR monitorenter ;
        if (b == null)
        {
            b = com.shazam.i.b.ah.d.a(context).getReadableDatabase();
        }
        context = b;
        com/shazam/i/b/ah/e;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

}
