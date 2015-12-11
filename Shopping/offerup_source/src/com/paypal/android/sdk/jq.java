// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.paypal.android.sdk:
//            jm, jl, ks, hl, 
//            kq

final class jq extends jm
{

    private long b;
    private jl c;

    public jq(jl jl1, long l)
    {
        c = jl1;
        super(jl1, (byte)0);
        b = l;
        if (b == 0L)
        {
            a(true);
        }
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
        if (b == 0L)
        {
            return -1L;
        }
        l = jl.b(c).a(kq, Math.min(b, l));
        if (l == -1L)
        {
            b();
            throw new ProtocolException("unexpected end of stream");
        }
        b = b - l;
        if (b == 0L)
        {
            a(true);
        }
        return l;
    }

    public final void close()
    {
        if (a)
        {
            return;
        }
        if (b != 0L && !hl.a(this, TimeUnit.MILLISECONDS))
        {
            b();
        }
        a = true;
    }
}
