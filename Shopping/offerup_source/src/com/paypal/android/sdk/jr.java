// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;


// Referenced classes of package com.paypal.android.sdk:
//            jm, jl, ks, kq

final class jr extends jm
{

    private boolean b;
    private jl c;

    private jr(jl jl1)
    {
        c = jl1;
        super(jl1, (byte)0);
    }

    jr(jl jl1, byte byte0)
    {
        this(jl1);
    }

    public final long a(kq kq, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
        }
        if (a)
        {
            throw new IllegalStateException("closed");
        }
        if (b)
        {
            return -1L;
        }
        l = jl.b(c).a(kq, l);
        if (l == -1L)
        {
            b = true;
            a(false);
            return -1L;
        } else
        {
            return l;
        }
    }

    public final void close()
    {
        if (a)
        {
            return;
        }
        if (!b)
        {
            b();
        }
        a = true;
    }
}
