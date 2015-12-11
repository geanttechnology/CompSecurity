// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.paypal.android.sdk:
//            jm, jl, ks, gh, 
//            ju, hl, kq

final class jo extends jm
{

    private long b;
    private boolean c;
    private final ju d;
    private jl e;

    jo(jl jl1, ju ju1)
    {
        e = jl1;
        super(jl1, (byte)0);
        b = -1L;
        c = true;
        d = ju1;
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
        if (c) goto _L2; else goto _L1
_L1:
        return -1L;
_L2:
        if (b != 0L && b != -1L)
        {
            break; /* Loop/switch isn't completed */
        }
        if (b != -1L)
        {
            jl.b(e).l();
        }
        try
        {
            b = jl.b(e).i();
            String s = jl.b(e).l().trim();
            if (b < 0L || !s.isEmpty() && !s.startsWith(";"))
            {
                throw new ProtocolException((new StringBuilder("expected chunk size and optional extensions but was \"")).append(b).append(s).append("\"").toString());
            }
        }
        // Misplaced declaration of an exception variable
        catch (kq kq)
        {
            throw new ProtocolException(kq.getMessage());
        }
        if (b == 0L)
        {
            c = false;
            gh gh1 = new gh();
            e.a(gh1);
            d.a(gh1.a());
            a(true);
        }
        if (!c) goto _L1; else goto _L3
_L3:
        l = jl.b(e).a(kq, Math.min(l, b));
        if (l == -1L)
        {
            b();
            throw new ProtocolException("unexpected end of stream");
        } else
        {
            b = b - l;
            return l;
        }
    }

    public final void close()
    {
        if (a)
        {
            return;
        }
        if (c && !hl.a(this, TimeUnit.MILLISECONDS))
        {
            b();
        }
        a = true;
    }
}
