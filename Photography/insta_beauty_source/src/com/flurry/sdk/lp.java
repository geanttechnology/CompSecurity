// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.sdk;


// Referenced classes of package com.flurry.sdk:
//            js, ly

public class lp
{

    private static final String a = com/flurry/sdk/lp.getSimpleName();
    private long b;
    private boolean c;
    private boolean d;
    private ly e;

    public lp()
    {
        b = 1000L;
        c = true;
        d = false;
        e = new _cls1();
    }

    static boolean a(lp lp1)
    {
        return lp1.c;
    }

    static boolean b(lp lp1)
    {
        return lp1.d;
    }

    static ly c(lp lp1)
    {
        return lp1.e;
    }

    static long d(lp lp1)
    {
        return lp1.b;
    }

    public void a()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = d;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        js.a().b(e, b);
        d = true;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void a(long l)
    {
        b = l;
    }

    public void a(boolean flag)
    {
        c = flag;
    }

    public void b()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = d;
        if (flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        js.a().c(e);
        d = false;
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }


    private class _cls1 extends ly
    {

        final lp a;

        public void a()
        {
            (new ln()).b();
            if (lp.a(a) && lp.b(a))
            {
                js.a().b(lp.c(a), lp.d(a));
            }
        }

        _cls1()
        {
            a = lp.this;
            super();
        }
    }

}
