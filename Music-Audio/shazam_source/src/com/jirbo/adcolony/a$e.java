// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


// Referenced classes of package com.jirbo.adcolony:
//            a, w

static final class a extends a
{

    double a;

    final void a(w w1)
    {
        double d2;
        d2 = a;
        if (w1.a)
        {
            w1.a();
        }
        if (!Double.isNaN(d2) && !Double.isInfinite(d2)) goto _L2; else goto _L1
_L1:
        w1.a("0.0");
_L4:
        return;
_L2:
        long l2;
        long l3;
        double d1 = d2;
        if (d2 < 0.0D)
        {
            d1 = -d2;
            w1.a('-');
        }
        l2 = (long)Math.pow(10D, 4D);
        long l = Math.round(d1 * (double)l2);
        w1.a(l / l2);
        w1.a('.');
        l3 = l % l2;
        if (l3 != 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        int j = 0;
        while (j < 4) 
        {
            w1.a('0');
            j++;
        }
        if (true) goto _L4; else goto _L3
_L3:
        for (long l1 = l3 * 10L; l1 < l2; l1 *= 10L)
        {
            w1.a('0');
        }

        w1.a(l3);
        return;
    }

    final double d()
    {
        return a;
    }

    final int e()
    {
        return (int)a;
    }

    final boolean i()
    {
        return true;
    }

    (double d1)
    {
        a = d1;
    }
}
