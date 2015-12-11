// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.net.Socket;

// Referenced classes of package com.paypal.android.sdk:
//            lj, kw, jl, ks, 
//            ha, fy, hl, lk

abstract class jm
    implements lj
{

    protected boolean a;
    private kw b;
    private jl c;

    private jm(jl jl1)
    {
        c = jl1;
        super();
        b = new kw(jl.b(c).a());
    }

    jm(jl jl1, byte byte0)
    {
        this(jl1);
    }

    public final lk a()
    {
        return b;
    }

    protected final void a(boolean flag)
    {
        if (jl.c(c) != 5)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(jl.c(c)).toString());
        }
        jl.a(b);
        jl.a(c, 0);
        if (flag && jl.d(c) == 1)
        {
            jl.e(c);
            ha.b.a(jl.f(c), jl.g(c));
        } else
        if (jl.d(c) == 2)
        {
            jl.a(c, 6);
            jl.g(c).c().close();
            return;
        }
    }

    protected final void b()
    {
        hl.a(jl.g(c).c());
        jl.a(c, 6);
    }
}
