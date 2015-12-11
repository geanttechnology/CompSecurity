// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.net.ProtocolException;

// Referenced classes of package com.paypal.android.sdk:
//            lh, kw, jl, kr, 
//            kq, hl, lk

final class jp
    implements lh
{

    private final kw a;
    private boolean b;
    private long c;
    private jl d;

    private jp(jl jl1, long l)
    {
        d = jl1;
        super();
        a = new kw(jl.a(d).a());
        c = l;
    }

    jp(jl jl1, long l, byte byte0)
    {
        this(jl1, l);
    }

    public final lk a()
    {
        return a;
    }

    public final void a_(kq kq1, long l)
    {
        if (b)
        {
            throw new IllegalStateException("closed");
        }
        hl.a(kq1.b, 0L, l);
        if (l > c)
        {
            throw new ProtocolException((new StringBuilder("expected ")).append(c).append(" bytes but received ").append(l).toString());
        } else
        {
            jl.a(d).a_(kq1, l);
            c = c - l;
            return;
        }
    }

    public final void close()
    {
        if (b)
        {
            return;
        }
        b = true;
        if (c > 0L)
        {
            throw new ProtocolException("unexpected end of stream");
        } else
        {
            jl.a(a);
            jl.a(d, 3);
            return;
        }
    }

    public final void flush()
    {
        if (b)
        {
            return;
        } else
        {
            jl.a(d).flush();
            return;
        }
    }
}
