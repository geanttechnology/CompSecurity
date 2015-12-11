// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.c;

import b.a.a.aa;
import b.a.a.c;
import b.a.a.d;
import b.a.a.l;
import b.a.a.o;
import java.util.Locale;

public abstract class b extends c
{

    final d g;

    public b(d d1)
    {
        if (d1 == null)
        {
            throw new IllegalArgumentException("The type must not be null");
        } else
        {
            g = d1;
            return;
        }
    }

    public abstract int a(long l1);

    public int a(String s, Locale locale)
    {
        int j;
        try
        {
            j = Integer.parseInt(s);
        }
        // Misplaced declaration of an exception variable
        catch (Locale locale)
        {
            throw new o(g, s);
        }
        return j;
    }

    public int a(Locale locale)
    {
        int j = h();
        if (j >= 0)
        {
            if (j < 10)
            {
                return 1;
            }
            if (j < 100)
            {
                return 2;
            }
            if (j < 1000)
            {
                return 3;
            }
        }
        return Integer.toString(j).length();
    }

    public long a(long l1, int j)
    {
        return d().a(l1, j);
    }

    public long a(long l1, long l2)
    {
        return d().a(l1, l2);
    }

    public long a(long l1, String s, Locale locale)
    {
        return b(l1, a(s, locale));
    }

    public final d a()
    {
        return g;
    }

    public String a(int j, Locale locale)
    {
        return Integer.toString(j);
    }

    public String a(long l1, Locale locale)
    {
        return a(a(l1), locale);
    }

    public final String a(aa aa1, Locale locale)
    {
        return a(aa1.a(g), locale);
    }

    public int b(long l1, long l2)
    {
        return d().b(l1, l2);
    }

    public abstract long b(long l1, int j);

    public final String b()
    {
        return g.a;
    }

    public String b(int j, Locale locale)
    {
        return a(j, locale);
    }

    public String b(long l1, Locale locale)
    {
        return b(a(l1), locale);
    }

    public final String b(aa aa1, Locale locale)
    {
        return b(aa1.a(g), locale);
    }

    public boolean b(long l1)
    {
        return false;
    }

    public int c(long l1)
    {
        return h();
    }

    public long c(long l1, long l2)
    {
        return d().c(l1, l2);
    }

    public final boolean c()
    {
        return true;
    }

    public abstract long d(long l1);

    public abstract l d();

    public long e(long l1)
    {
        long l3 = d(l1);
        long l2 = l1;
        if (l3 != l1)
        {
            l2 = a(l3, 1);
        }
        return l2;
    }

    public long f(long l1)
    {
        long l2 = d(l1);
        long l3 = e(l1);
        if (l1 - l2 <= l3 - l1)
        {
            return l2;
        } else
        {
            return l3;
        }
    }

    public l f()
    {
        return null;
    }

    public long g(long l1)
    {
        long l2 = d(l1);
        long l3 = e(l1);
        if (l3 - l1 <= l1 - l2)
        {
            return l3;
        } else
        {
            return l2;
        }
    }

    public abstract int h();

    public long h(long l1)
    {
        long l2 = d(l1);
        long l3 = e(l1);
        long l4 = l1 - l2;
        l1 = l3 - l1;
        if (l4 >= l1)
        {
            if (l1 < l4)
            {
                return l3;
            }
            if ((a(l3) & 1) == 0)
            {
                return l3;
            }
        }
        return l2;
    }

    public long i(long l1)
    {
        return l1 - d(l1);
    }

    public String toString()
    {
        return (new StringBuilder("DateTimeField[")).append(g.a).append(']').toString();
    }
}
