// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            lh, kw, jl, kr, 
//            lk, kq

final class jn
    implements lh
{

    private final kw a;
    private boolean b;
    private jl c;

    private jn(jl jl1)
    {
        c = jl1;
        super();
        a = new kw(jl.a(c).a());
    }

    jn(jl jl1, byte byte0)
    {
        this(jl1);
    }

    public final lk a()
    {
        return a;
    }

    public final void a_(kq kq, long l)
    {
        if (b)
        {
            throw new IllegalStateException("closed");
        }
        if (l == 0L)
        {
            return;
        } else
        {
            jl.a(c).h(l);
            jl.a(c).b("\r\n");
            jl.a(c).a_(kq, l);
            jl.a(c).b("\r\n");
            return;
        }
    }

    public final void close()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = b;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        b = true;
        jl.a(c).b("0\r\n\r\n");
        jl.a(a);
        jl.a(c, 3);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final void flush()
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = b;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        jl.a(c).flush();
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }
}
