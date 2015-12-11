// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.b;

import b.a.a.c;
import b.a.a.c.g;
import b.a.a.c.h;
import b.a.a.d;
import b.a.a.l;

// Referenced classes of package b.a.a.b:
//            d, a

class j extends h
{

    private final b.a.a.b.d a;
    private final int c = b.a.a.b.d.P();
    private final int d = 2;

    j(b.a.a.b.d d1)
    {
        super(b.a.a.d.r(), d1.R());
        a = d1;
    }

    public final int a(long l)
    {
        b.a.a.b.d d1 = a;
        return d1.a(l, d1.a(l));
    }

    public final long a(long l, int k)
    {
        int i1;
        int j2;
        int k2;
        long l2;
        if (k == 0)
        {
            return l;
        }
        l2 = b.a.a.b.d.e(l);
        j2 = a.a(l);
        k2 = a.a(l, j2);
        i1 = (k2 - 1) + k;
        if (i1 < 0) goto _L2; else goto _L1
_L1:
        k = i1 / c + j2;
        i1 = i1 % c + 1;
_L4:
        int j1 = a.a(l, j2, k2);
        int l1 = a.b(k, i1);
        if (j1 > l1)
        {
            j1 = l1;
        }
        return a.a(k, i1, j1) + l2;
_L2:
        int k1 = (i1 / c + j2) - 1;
        i1 = Math.abs(i1) % c;
        k = i1;
        if (i1 == 0)
        {
            k = c;
        }
        int i2 = (c - k) + 1;
        i1 = i2;
        k = k1;
        if (i2 == 1)
        {
            k = k1 + 1;
            i1 = i2;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public final long a(long l, long l1)
    {
        int l2;
        int i3;
        long l4;
        long l7;
        int k = (int)l1;
        if ((long)k == l1)
        {
            return a(l, k);
        }
        l7 = b.a.a.b.d.e(l);
        l2 = a.a(l);
        i3 = a.a(l, l2);
        l4 = (long)(i3 - 1) + l1;
        if (l4 < 0L) goto _L2; else goto _L1
_L1:
        long l3;
        l3 = (long)l2 + l4 / (long)c;
        l4 = l4 % (long)c + 1L;
_L4:
        a.N();
        if (l3 >= 0xffffffffee943c92L)
        {
            a.O();
            if (l3 <= 0x116bd2d1L)
            {
                break; /* Loop/switch isn't completed */
            }
        }
        throw new IllegalArgumentException((new StringBuilder("Magnitude of add amount is too large: ")).append(l1).toString());
_L2:
        long l5 = ((long)l2 + l4 / (long)c) - 1L;
        int k1 = (int)(Math.abs(l4) % (long)c);
        int i1 = k1;
        if (k1 == 0)
        {
            i1 = c;
        }
        long l6 = (c - i1) + 1;
        l4 = l6;
        l3 = l5;
        if (l6 == 1L)
        {
            l3 = l5 + 1L;
            l4 = l6;
        }
        if (true) goto _L4; else goto _L3
_L3:
        int j2 = (int)l3;
        int k2 = (int)l4;
        int j1 = a.a(l, l2, i3);
        int i2 = a.b(j2, k2);
        if (j1 > i2)
        {
            j1 = i2;
        }
        return a.a(j2, k2, j1) + l7;
    }

    public final long b(long l, int k)
    {
        b.a.a.c.g.a(this, k, 1, c);
        int k1 = a.a(l);
        b.a.a.b.d d1 = a;
        int i1 = d1.a(l, k1, d1.a(l, k1));
        int j1 = a.b(k1, k);
        if (i1 > j1)
        {
            i1 = j1;
        }
        return a.a(k1, k, i1) + (long)b.a.a.b.d.e(l);
    }

    public final boolean b(long l)
    {
        boolean flag1 = false;
        int k = a.a(l);
        boolean flag = flag1;
        if (a.c(k))
        {
            flag = flag1;
            if (a.a(l, k) == d)
            {
                flag = true;
            }
        }
        return flag;
    }

    public final long c(long l, long l1)
    {
        if (l < l1)
        {
            l1 = -b(l1, l);
        } else
        {
            int k = a.a(l);
            int i1 = a.a(l, k);
            int j1 = a.a(l1);
            int k1 = a.a(l1, j1);
            long l3 = ((long)(k - j1) * (long)c + (long)i1) - (long)k1;
            int i2 = a.a(l, k, i1);
            long l2 = l1;
            if (i2 == a.b(k, i1))
            {
                l2 = l1;
                if (a.a(l1, j1, k1) > i2)
                {
                    l2 = ((a) (a)).i.b(l1, i2);
                }
            }
            l1 = l3;
            if (l - a.a(k, i1) < l2 - a.a(j1, k1))
            {
                return l3 - 1L;
            }
        }
        return l1;
    }

    public final long d(long l)
    {
        int k = a.a(l);
        int i1 = a.a(l, k);
        return a.a(k, i1);
    }

    public final l e()
    {
        return ((a) (a)).g;
    }

    public final l f()
    {
        return ((a) (a)).c;
    }

    public final int g()
    {
        return 1;
    }

    public final int h()
    {
        return c;
    }

    public final long i(long l)
    {
        return l - d(l);
    }
}
