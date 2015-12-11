// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.g.b.a.a;

import c.c;
import c.d;
import c.e;
import c.s;
import c.t;
import com.g.b.a.k;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.g.b.a.a:
//            g, b

final class 
    implements s
{

    boolean a;
    final e b;
    final b c;
    final d d;
    final g e;

    public final long a(c c1, long l)
    {
        try
        {
            l = b.a(c1, l);
        }
        // Misplaced declaration of an exception variable
        catch (c c1)
        {
            if (!a)
            {
                a = true;
                c.a();
            }
            throw c1;
        }
        if (l == -1L)
        {
            if (!a)
            {
                a = true;
                d.close();
            }
            return -1L;
        } else
        {
            c1.a(d.b(), c1.b - l, l);
            d.s();
            return l;
        }
    }

    public final void close()
    {
        if (!a && !k.a(this, TimeUnit.MILLISECONDS))
        {
            a = true;
            c.a();
        }
        b.close();
    }

    public final t w_()
    {
        return b.w_();
    }

    ion(g g1, e e1, b b1, d d1)
    {
        e = g1;
        b = e1;
        c = b1;
        d = d1;
        super();
    }
}
