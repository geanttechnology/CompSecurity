// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.a;

import c.c;
import c.r;
import c.t;
import com.g.b.a.k;
import java.net.ProtocolException;

public final class n
    implements r
{

    final c a;
    private boolean b;
    private final int c;

    public n()
    {
        this(-1);
    }

    public n(int i)
    {
        a = new c();
        c = i;
    }

    public final void a(r r1)
    {
        c c1 = new c();
        a.a(c1, 0L, a.b);
        r1.a_(c1, c1.b);
    }

    public final void a_(c c1, long l)
    {
        if (b)
        {
            throw new IllegalStateException("closed");
        }
        k.a(c1.b, l);
        if (c != -1 && a.b > (long)c - l)
        {
            throw new ProtocolException((new StringBuilder("exceeded content-length limit of ")).append(c).append(" bytes").toString());
        } else
        {
            a.a_(c1, l);
            return;
        }
    }

    public final void close()
    {
        if (!b)
        {
            b = true;
            if (a.b < (long)c)
            {
                throw new ProtocolException((new StringBuilder("content-length promised ")).append(c).append(" bytes, but received ").append(a.b).toString());
            }
        }
    }

    public final void flush()
    {
    }

    public final t w_()
    {
        return t.b;
    }
}
