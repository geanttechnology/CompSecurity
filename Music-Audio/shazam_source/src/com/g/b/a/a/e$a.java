// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.a;

import c.e;
import c.j;
import c.s;
import c.t;
import com.g.b.a.d;
import com.g.b.a.k;
import com.g.b.i;
import java.net.Socket;

// Referenced classes of package com.g.b.a.a:
//            e

private abstract class <init>
    implements s
{

    protected final j a;
    protected boolean b;
    final com.g.b.a.a.e c;

    protected final void a(boolean flag)
    {
        if (c.e != 5)
        {
            throw new IllegalStateException((new StringBuilder("state: ")).append(c.e).toString());
        }
        e.a(a);
        c.e = 0;
        if (flag && c.f == 1)
        {
            c.f = 0;
            d.b.a(c.a, c.b);
        } else
        if (c.f == 2)
        {
            c.e = 6;
            c.b.c.close();
            return;
        }
    }

    protected final void b()
    {
        k.a(c.b.c);
        c.e = 6;
    }

    public final t w_()
    {
        return a;
    }

    private Builder(com.g.b.a.a.e e1)
    {
        c = e1;
        super();
        a = new j(c.c.w_());
    }

    c(com.g.b.a.a.e e1, byte byte0)
    {
        this(e1);
    }
}
