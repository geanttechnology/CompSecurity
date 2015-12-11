// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.i.b.ah;

import android.content.Context;
import com.shazam.i.b.c;

public final class a
{

    private static com.shazam.android.persistence.c a = null;

    public static com.shazam.android.persistence.c a()
    {
        com/shazam/i/b/ah/a;
        JVM INSTR monitorenter ;
        com.shazam.android.persistence.c c1 = a(c.a());
        com/shazam/i/b/ah/a;
        JVM INSTR monitorexit ;
        return c1;
        Exception exception;
        exception;
        throw exception;
    }

    public static com.shazam.android.persistence.c a(Context context)
    {
        com/shazam/i/b/ah/a;
        JVM INSTR monitorenter ;
        if (a == null)
        {
            context = new com.shazam.android.persistence.c(context);
            a = context;
            context.a();
        }
        context = a;
        com/shazam/i/b/ah/a;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

}
