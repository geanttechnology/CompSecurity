// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.b;

import b.a.a.c.b;
import b.a.a.c.g;
import b.a.a.c.r;
import b.a.a.d;
import b.a.a.l;
import b.a.a.m;
import java.util.Locale;
import java.util.TreeMap;

// Referenced classes of package b.a.a.b:
//            d, p

final class o extends b
{

    private final b.a.a.b.d a;

    o(b.a.a.b.d d1)
    {
        super(b.a.a.d.w());
        a = d1;
    }

    public final int a(long l)
    {
        return a.a(l) > 0 ? 1 : 0;
    }

    public final int a(Locale locale)
    {
        return p.a(locale).j;
    }

    public final long a(long l, String s, Locale locale)
    {
        locale = (Integer)p.a(locale).g.get(s);
        if (locale != null)
        {
            return b(l, locale.intValue());
        } else
        {
            throw new b.a.a.o(b.a.a.d.w(), s);
        }
    }

    public final String a(int i, Locale locale)
    {
        return p.a(locale).a[i];
    }

    public final long b(long l, int i)
    {
        b.a.a.c.g.a(this, i, 0, 1);
        long l1 = l;
        if (a(l) != i)
        {
            i = a.a(l);
            l1 = a.d(l, -i);
        }
        return l1;
    }

    public final long d(long l)
    {
        if (a(l) == 1)
        {
            return a.d(0L, 1);
        } else
        {
            return 0x8000000000000000L;
        }
    }

    public final l d()
    {
        return r.a(m.l());
    }

    public final long e(long l)
    {
        if (a(l) == 0)
        {
            return a.d(0L, 1);
        } else
        {
            return 0x7fffffffffffffffL;
        }
    }

    public final l e()
    {
        return null;
    }

    public final long f(long l)
    {
        return d(l);
    }

    public final int g()
    {
        return 0;
    }

    public final long g(long l)
    {
        return d(l);
    }

    public final int h()
    {
        return 1;
    }

    public final long h(long l)
    {
        return d(l);
    }
}
