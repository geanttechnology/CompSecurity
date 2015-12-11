// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.c;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

// Referenced classes of package com.facebook.c:
//            g, d, e, f

public class b
{

    public final Map a = new HashMap();
    public final Set b = new CopyOnWriteArraySet();
    public final CopyOnWriteArraySet c = new CopyOnWriteArraySet();
    private final g d;
    private boolean e;

    public b(g g1)
    {
        e = true;
        if (g1 == null)
        {
            throw new IllegalArgumentException("springLooper is required");
        } else
        {
            d = g1;
            d.a(this);
            return;
        }
    }

    public final d a()
    {
        d d1 = new d(this);
        if (a.containsKey(d1.c))
        {
            throw new IllegalArgumentException("spring is already registered");
        } else
        {
            a.put(d1.c, d1);
            return d1;
        }
    }

    public final void a(double d1)
    {
        for (Iterator iterator = c.iterator(); iterator.hasNext(); iterator.next()) { }
        Iterator iterator1 = b.iterator();
label0:
        do
        {
            d d16;
label1:
            {
label2:
                {
                    if (!iterator1.hasNext())
                    {
                        break label0;
                    }
                    d16 = (d)iterator1.next();
                    double d2;
                    double d4;
                    double d6;
                    double d7;
                    double d8;
                    double d9;
                    boolean flag;
                    boolean flag3;
                    if (!d16.a() || !d16.i)
                    {
                        flag = true;
                    } else
                    {
                        flag = false;
                    }
                    if (!flag)
                    {
                        break label1;
                    }
                    d4 = d1 / 1000D;
                    flag3 = d16.a();
                    if (flag3 && d16.i)
                    {
                        continue;
                    }
                    d2 = d4;
                    if (d4 > 0.064000000000000001D)
                    {
                        d2 = 0.064000000000000001D;
                    }
                    d16.k = d2 + d16.k;
                    d8 = d16.a.b;
                    d9 = d16.a.a;
                    d4 = d16.d.a;
                    d2 = d16.d.b;
                    d7 = d16.f.a;
                    d6 = d16.f.b;
                    while (d16.k >= 0.001D) 
                    {
                        d16.k = d16.k - 0.001D;
                        if (d16.k < 0.001D)
                        {
                            d16.e.a = d4;
                            d16.e.b = d2;
                        }
                        double d10 = (d16.h - d7) * d8 - d9 * d2;
                        double d14 = d2 + 0.001D * d10 * 0.5D;
                        double d11 = (d16.h - (0.001D * d2 * 0.5D + d4)) * d8 - d9 * d14;
                        double d15 = d2 + 0.001D * d11 * 0.5D;
                        double d12 = (d16.h - (0.001D * d14 * 0.5D + d4)) * d8 - d9 * d15;
                        d7 = d4 + 0.001D * d15;
                        d6 = 0.001D * d12 + d2;
                        double d13 = d16.h;
                        d4 += ((d14 + d15) * 2D + d2 + d6) * 0.16666666666666666D * 0.001D;
                        d2 += (d10 + (d11 + d12) * 2D + ((d13 - d7) * d8 - d9 * d6)) * 0.16666666666666666D * 0.001D;
                    }
                    d16.f.a = d7;
                    d16.f.b = d6;
                    d16.d.a = d4;
                    d16.d.b = d2;
                    if (d16.k > 0.0D)
                    {
                        double d3 = d16.k / 0.001D;
                        d16.d.a = d16.d.a * d3 + d16.e.a * (1.0D - d3);
                        d.a a1 = d16.d;
                        double d5 = d16.d.b;
                        a1.b = (1.0D - d3) * d16.e.b + d5 * d3;
                    }
                    if (!d16.a())
                    {
                        boolean flag2 = flag3;
                        if (!d16.b)
                        {
                            break label2;
                        }
                        Iterator iterator3;
                        f f1;
                        boolean flag1;
                        if (d16.a.b > 0.0D && (d16.g < d16.h && d16.d.a > d16.h || d16.g > d16.h && d16.d.a < d16.h))
                        {
                            flag1 = true;
                        } else
                        {
                            flag1 = false;
                        }
                        flag2 = flag3;
                        if (!flag1)
                        {
                            break label2;
                        }
                    }
                    if (d8 > 0.0D)
                    {
                        d16.g = d16.h;
                        d16.d.a = d16.h;
                    } else
                    {
                        d16.h = d16.d.a;
                        d16.g = d16.h;
                    }
                    if (0.0D != d16.d.b)
                    {
                        d16.d.b = 0.0D;
                        d16.l.a(d16.c);
                    }
                    flag2 = true;
                }
                if (d16.i)
                {
                    d16.i = false;
                }
                flag1 = false;
                if (flag2)
                {
                    d16.i = true;
                    flag1 = true;
                }
                iterator3 = d16.j.iterator();
                do
                {
                    do
                    {
                        if (!iterator3.hasNext())
                        {
                            continue label0;
                        }
                        f1 = (f)iterator3.next();
                        f1.a(d16);
                    } while (!flag1);
                    f1.a();
                } while (true);
            }
            b.remove(d16);
        } while (true);
        if (b.isEmpty())
        {
            e = true;
        }
        for (Iterator iterator2 = c.iterator(); iterator2.hasNext(); iterator2.next()) { }
        if (e)
        {
            d.b();
        }
    }

    final void a(String s)
    {
        d d1 = (d)a.get(s);
        if (d1 == null)
        {
            throw new IllegalArgumentException((new StringBuilder("springId ")).append(s).append(" does not reference a registered spring").toString());
        }
        b.add(d1);
        if (e)
        {
            e = false;
            d.a();
        }
    }
}
