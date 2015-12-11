// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.a;

import c.c;
import c.d;
import c.j;
import c.r;
import c.t;
import com.g.b.a.k;
import java.net.ProtocolException;

// Referenced classes of package com.g.b.a.a:
//            e

private final class <init>
    implements r
{

    final e a;
    private final j b;
    private boolean c;
    private long d;

    public final void a_(c c1, long l)
    {
        if (c)
        {
            throw new IllegalStateException("closed");
        }
        k.a(c1.b, l);
        if (l > d)
        {
            throw new ProtocolException((new StringBuilder("expected ")).append(d).append(" bytes but received ").append(l).toString());
        } else
        {
            a.d.a_(c1, l);
            d = d - l;
            return;
        }
    }

    public final void close()
    {
        if (c)
        {
            return;
        }
        c = true;
        if (d > 0L)
        {
            throw new ProtocolException("unexpected end of stream");
        } else
        {
            e.a(b);
            a.e = 3;
            return;
        }
    }

    public final void flush()
    {
        if (c)
        {
            return;
        } else
        {
            a.d.flush();
            return;
        }
    }

    public final t w_()
    {
        return b;
    }

    private Builder(e e1, long l)
    {
        a = e1;
        super();
        b = new j(a.d.w_());
        d = l;
    }

    d(e e1, long l, byte byte0)
    {
        this(e1, l);
    }
}
