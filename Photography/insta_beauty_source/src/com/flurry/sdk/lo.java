// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            lp, kc, kb

public class lo
{

    private static long a = 100L;
    private static lo b = null;
    private final lp c = new lp();

    public lo()
    {
        c.a(a);
        c.a(true);
    }

    public static lo a()
    {
        com/flurry/sdk/lo;
        JVM INSTR monitorenter ;
        lo lo1;
        if (b == null)
        {
            b = new lo();
        }
        lo1 = b;
        com/flurry/sdk/lo;
        JVM INSTR monitorexit ;
        return lo1;
        Exception exception;
        exception;
        throw exception;
    }

    public static void b()
    {
        com/flurry/sdk/lo;
        JVM INSTR monitorenter ;
        if (b != null)
        {
            b.c();
            b = null;
        }
        com/flurry/sdk/lo;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void a(kb kb)
    {
        this;
        JVM INSTR monitorenter ;
        kc.a().a("com.flurry.android.sdk.TickEvent", kb);
        if (kc.a().b("com.flurry.android.sdk.TickEvent") > 0)
        {
            c.a();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        kb;
        throw kb;
    }

    public void b(kb kb)
    {
        this;
        JVM INSTR monitorenter ;
        kc.a().b("com.flurry.android.sdk.TickEvent", kb);
        if (kc.a().b("com.flurry.android.sdk.TickEvent") == 0)
        {
            c.b();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        kb;
        throw kb;
    }

    public void c()
    {
        this;
        JVM INSTR monitorenter ;
        kc.a().a("com.flurry.android.sdk.TickEvent");
        c.b();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

}
