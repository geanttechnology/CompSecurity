// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.a;

import c.c;
import c.e;
import com.g.b.a.k;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.g.b.a.a:
//            e

private final class a extends a
{

    final com.g.b.a.a.e d;
    private long e;

    public final long a(c c, long l)
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder("byteCount < 0: ")).append(l).toString());
        }
        if (b)
        {
            throw new IllegalStateException("closed");
        }
        if (e == 0L)
        {
            return -1L;
        }
        l = d.c.a(c, Math.min(e, l));
        if (l == -1L)
        {
            b();
            throw new ProtocolException("unexpected end of stream");
        }
        e = e - l;
        if (e == 0L)
        {
            a(true);
        }
        return l;
    }

    public final void close()
    {
        if (b)
        {
            return;
        }
        if (e != 0L && !k.a(this, TimeUnit.MILLISECONDS))
        {
            b();
        }
        b = true;
    }

    public rent.TimeUnit(com.g.b.a.a.e e1, long l)
    {
        d = e1;
        super(e1, (byte)0);
        e = l;
        if (e == 0L)
        {
            a(true);
        }
    }
}
