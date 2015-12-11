// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.paypal.android.sdk;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Referenced classes of package com.paypal.android.sdk:
//            ii, kz, ik, ks, 
//            is, kt, lj

final class il
{

    private final List a = new ArrayList();
    private final ks b;
    private int c;
    private int d;
    private ii e[];
    private int f;
    private int g;
    private int h;

    il(int i, lj lj)
    {
        e = new ii[8];
        f = e.length - 1;
        g = 0;
        h = 0;
        c = 4096;
        d = 4096;
        b = kz.a(lj);
    }

    private int a(int i, int j)
    {
        i &= j;
        if (i < j)
        {
            return i;
        }
        i = 0;
        do
        {
            int k = e();
            if ((k & 0x80) != 0)
            {
                j += (k & 0x7f) << i;
                i += 7;
            } else
            {
                return (k << i) + j;
            }
        } while (true);
    }

    private void a(ii ii1)
    {
        a.add(ii1);
        int i = ii1.j;
        if (i > d)
        {
            d();
            return;
        }
        b((h + i) - d);
        if (g + 1 > e.length)
        {
            ii aii[] = new ii[e.length << 1];
            System.arraycopy(e, 0, aii, e.length, e.length);
            f = e.length - 1;
            e = aii;
        }
        int j = f;
        f = j - 1;
        e[j] = ii1;
        g = g + 1;
        h = i + h;
    }

    private int b(int i)
    {
        int j = 0;
        boolean flag = false;
        if (i > 0)
        {
            j = e.length - 1;
            int k = i;
            i = ((flag) ? 1 : 0);
            for (; j >= f && k > 0; j--)
            {
                k -= e[j].j;
                h = h - e[j].j;
                g = g - 1;
                i++;
            }

            System.arraycopy(e, f + 1, e, f + 1 + i, g);
            f = f + i;
            j = i;
        }
        return j;
    }

    private int c(int i)
    {
        return f + 1 + i;
    }

    private void c()
    {
label0:
        {
            if (d < h)
            {
                if (d != 0)
                {
                    break label0;
                }
                d();
            }
            return;
        }
        b(h - d);
    }

    private kt d(int i)
    {
        if (e(i))
        {
            return ik.a()[i].h;
        } else
        {
            return e[c(i - ik.a().length)].h;
        }
    }

    private void d()
    {
        a.clear();
        Arrays.fill(e, null);
        f = e.length - 1;
        g = 0;
        h = 0;
    }

    private int e()
    {
        return b.d() & 0xff;
    }

    private static boolean e(int i)
    {
        return i >= 0 && i <= ik.a().length - 1;
    }

    private kt f()
    {
        int i = e();
        boolean flag;
        if ((i & 0x80) == 128)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        i = a(i, 127);
        if (flag)
        {
            return kt.a(is.a().a(b.e(i)));
        } else
        {
            return b.c(i);
        }
    }

    final void a()
    {
        while (!b.c()) 
        {
            int i = b.d() & 0xff;
            if (i == 128)
            {
                throw new IOException("index == 0");
            }
            if ((i & 0x80) == 128)
            {
                i = a(i, 127) - 1;
                if (e(i))
                {
                    ii ii1 = ik.a()[i];
                    a.add(ii1);
                } else
                {
                    int j = c(i - ik.a().length);
                    if (j < 0 || j > e.length - 1)
                    {
                        throw new IOException((new StringBuilder("Header index too large ")).append(i + 1).toString());
                    }
                    a.add(e[j]);
                }
            } else
            if (i == 64)
            {
                a(new ii(ik.a(f()), f()));
            } else
            if ((i & 0x40) == 64)
            {
                a(new ii(d(a(i, 63) - 1), f()));
            } else
            if ((i & 0x20) == 32)
            {
                d = a(i, 31);
                if (d < 0 || d > c)
                {
                    throw new IOException((new StringBuilder("Invalid dynamic table size update ")).append(d).toString());
                }
                c();
            } else
            if (i == 16 || i == 0)
            {
                kt kt1 = ik.a(f());
                kt kt3 = f();
                a.add(new ii(kt1, kt3));
            } else
            {
                kt kt2 = d(a(i, 15) - 1);
                kt kt4 = f();
                a.add(new ii(kt2, kt4));
            }
        }
    }

    final void a(int i)
    {
        c = i;
        d = i;
        c();
    }

    public final List b()
    {
        ArrayList arraylist = new ArrayList(a);
        a.clear();
        return arraylist;
    }
}
