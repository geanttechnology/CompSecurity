// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.e;

import b.a.a.i;

// Referenced classes of package b.a.a.e:
//            g

final class d extends i
{

    final int d;
    final g e;
    final g f;

    d(String s, int j, g g1, g g2)
    {
        super(s);
        d = j;
        e = g1;
        f = g2;
    }

    private g g(long l)
    {
        g g2;
        int j = d;
        g g1 = e;
        g2 = f;
        long l1;
        long l2;
        try
        {
            l1 = g1.a(l, j, g2.c);
        }
        catch (IllegalArgumentException illegalargumentexception)
        {
            l1 = l;
        }
        catch (ArithmeticException arithmeticexception)
        {
            l1 = l;
        }
        l2 = g2.a(l, j, g1.c);
        l = l2;
_L2:
        if (l1 > l)
        {
            return g1;
        } else
        {
            return g2;
        }
        Object obj;
        obj;
        continue; /* Loop/switch isn't completed */
        obj;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public final String a(long l)
    {
        return g(l).b;
    }

    public final int b(long l)
    {
        return d + g(l).c;
    }

    public final boolean c()
    {
        return false;
    }

    public final long e(long l)
    {
        g g1;
        g g2;
        int j;
        j = d;
        g1 = e;
        g2 = f;
        long l2 = g1.a(l, j, g2.c);
        long l1;
        l1 = l2;
        if (l > 0L)
        {
            l1 = l2;
            if (l2 < 0L)
            {
                l1 = l;
            }
        }
_L1:
label0:
        {
            Object obj;
            long l3;
            try
            {
                l3 = g2.a(l, j, g1.c);
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                break label0;
            }
            catch (ArithmeticException arithmeticexception)
            {
                break label0;
            }
            if (l <= 0L || l3 >= 0L)
            {
                l = l3;
            }
        }
        if (l1 > l)
        {
            return l;
        } else
        {
            return l1;
        }
        obj;
        l1 = l;
          goto _L1
        obj;
        l1 = l;
          goto _L1
    }

    public final boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (obj instanceof d)
            {
                if (!super.c.equals(((i) (obj = (d)obj)).c) || d != ((d) (obj)).d || !e.equals(((d) (obj)).e) || !f.equals(((d) (obj)).f))
                {
                    return false;
                }
            } else
            {
                return false;
            }
        }
        return true;
    }

    public final long f(long l)
    {
        g g1;
        g g2;
        int j;
        l++;
        j = d;
        g1 = e;
        g2 = f;
        long l2 = g1.b(l, j, g2.c);
        long l1;
        l1 = l2;
        if (l < 0L)
        {
            l1 = l2;
            if (l2 > 0L)
            {
                l1 = l;
            }
        }
_L1:
label0:
        {
            Object obj;
            long l3;
            try
            {
                l3 = g2.b(l, j, g1.c);
            }
            catch (IllegalArgumentException illegalargumentexception)
            {
                break label0;
            }
            catch (ArithmeticException arithmeticexception)
            {
                break label0;
            }
            if (l >= 0L || l3 <= 0L)
            {
                l = l3;
            }
        }
        l3 = l;
        if (l1 > l)
        {
            l3 = l1;
        }
        return l3 - 1L;
        obj;
        l1 = l;
          goto _L1
        obj;
        l1 = l;
          goto _L1
    }
}
