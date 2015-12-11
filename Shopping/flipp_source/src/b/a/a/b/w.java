// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.b;

import b.a.a.c;
import b.a.a.c.b;
import b.a.a.i;
import b.a.a.l;
import b.a.a.o;
import b.a.a.p;
import java.util.Locale;

// Referenced classes of package b.a.a.b:
//            v

final class w extends b
{

    final c a;
    final i b;
    final l c;
    final boolean d;
    final l e;
    final l f;

    w(c c1, i k, l l, l l1, l l2)
    {
        super(c1.a());
        if (!c1.c())
        {
            throw new IllegalArgumentException();
        } else
        {
            a = c1;
            b = k;
            c = l;
            d = v.a(l);
            e = l1;
            f = l2;
            return;
        }
    }

    private int j(long l)
    {
        int k = b.b(l);
        if (((long)k + l ^ l) < 0L && ((long)k ^ l) >= 0L)
        {
            throw new ArithmeticException("Adding time zone offset caused overflow");
        } else
        {
            return k;
        }
    }

    public final int a(long l)
    {
        l = b.d(l);
        return a.a(l);
    }

    public final int a(Locale locale)
    {
        return a.a(locale);
    }

    public final long a(long l, int k)
    {
        if (d)
        {
            int i1 = j(l);
            return a.a((long)i1 + l, k) - (long)i1;
        } else
        {
            long l1 = b.d(l);
            l1 = a.a(l1, k);
            return b.a(l1, l);
        }
    }

    public final long a(long l, long l1)
    {
        if (d)
        {
            int k = j(l);
            return a.a((long)k + l, l1) - (long)k;
        } else
        {
            long l2 = b.d(l);
            l1 = a.a(l2, l1);
            return b.a(l1, l);
        }
    }

    public final long a(long l, String s, Locale locale)
    {
        long l1 = b.d(l);
        l1 = a.a(l1, s, locale);
        return b.a(l1, l);
    }

    public final String a(int k, Locale locale)
    {
        return a.a(k, locale);
    }

    public final String a(long l, Locale locale)
    {
        l = b.d(l);
        return a.a(l, locale);
    }

    public final int b(long l, long l1)
    {
        int i1 = j(l1);
        c c1 = a;
        int k;
        if (d)
        {
            k = i1;
        } else
        {
            k = j(l);
        }
        return c1.b((long)k + l, (long)i1 + l1);
    }

    public final long b(long l, int k)
    {
        long l1 = b.d(l);
        l1 = a.b(l1, k);
        l = b.a(l1, l);
        if (a(l) != k)
        {
            p p1 = new p(l1, b.c);
            o o1 = new o(a.a(), Integer.valueOf(k), p1.getMessage());
            o1.initCause(p1);
            throw o1;
        } else
        {
            return l;
        }
    }

    public final String b(int k, Locale locale)
    {
        return a.b(k, locale);
    }

    public final String b(long l, Locale locale)
    {
        l = b.d(l);
        return a.b(l, locale);
    }

    public final boolean b(long l)
    {
        l = b.d(l);
        return a.b(l);
    }

    public final int c(long l)
    {
        l = b.d(l);
        return a.c(l);
    }

    public final long c(long l, long l1)
    {
        int i1 = j(l1);
        c c1 = a;
        int k;
        if (d)
        {
            k = i1;
        } else
        {
            k = j(l);
        }
        return c1.c((long)k + l, (long)i1 + l1);
    }

    public final long d(long l)
    {
        if (d)
        {
            int k = j(l);
            return a.d((long)k + l) - (long)k;
        } else
        {
            long l1 = b.d(l);
            l1 = a.d(l1);
            return b.a(l1, l);
        }
    }

    public final l d()
    {
        return c;
    }

    public final long e(long l)
    {
        if (d)
        {
            int k = j(l);
            return a.e((long)k + l) - (long)k;
        } else
        {
            long l1 = b.d(l);
            l1 = a.e(l1);
            return b.a(l1, l);
        }
    }

    public final l e()
    {
        return e;
    }

    public final l f()
    {
        return f;
    }

    public final int g()
    {
        return a.g();
    }

    public final int h()
    {
        return a.h();
    }

    public final long i(long l)
    {
        l = b.d(l);
        return a.i(l);
    }
}
