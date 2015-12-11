// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.jirbo.adcolony;


abstract class ax
{

    boolean a;
    int b;

    ax()
    {
        a = true;
        b = 0;
    }

    void a()
    {
        if (a)
        {
            a = false;
            int i = b;
            do
            {
                i--;
                if (i < 0)
                {
                    break;
                }
                a(' ');
            } while (true);
        }
    }

    abstract void a(char c1);

    void a(double d)
    {
        if (a)
        {
            a();
        }
        if (!Double.isNaN(d) && !Double.isInfinite(d)) goto _L2; else goto _L1
_L1:
        a("0.0");
_L4:
        return;
_L2:
        long l2;
        long l3;
        double d1 = d;
        if (d < 0.0D)
        {
            d1 = -d;
            a('-');
        }
        l2 = (long)Math.pow(10D, 4);
        long l = Math.round((double)l2 * d1);
        a(l / l2);
        a('.');
        l3 = l % l2;
        if (l3 != 0L)
        {
            break; /* Loop/switch isn't completed */
        }
        int i = 0;
        while (i < 4) 
        {
            a('0');
            i++;
        }
        if (true) goto _L4; else goto _L3
_L3:
        for (long l1 = l3 * 10L; l1 < l2; l1 *= 10L)
        {
            a('0');
        }

        a(l3);
        return;
    }

    void a(long l)
    {
        if (a)
        {
            a();
        }
        if (l == 0L)
        {
            a('0');
            return;
        }
        if (l == -l)
        {
            a("-9223372036854775808");
            return;
        }
        if (l < 0L)
        {
            a('-');
            a(-l);
            return;
        } else
        {
            b(l);
            return;
        }
    }

    void a(String s)
    {
        int j = s.length();
        for (int i = 0; i < j; i++)
        {
            b(s.charAt(i));
        }

    }

    void a(boolean flag)
    {
        if (flag)
        {
            a("true");
            return;
        } else
        {
            a("false");
            return;
        }
    }

    void b()
    {
        b('\n');
    }

    void b(char c1)
    {
        if (a)
        {
            a();
        }
        a(c1);
        if (c1 == '\n')
        {
            a = true;
        }
    }

    void b(long l)
    {
        if (l == 0L)
        {
            return;
        } else
        {
            b(l / 10L);
            a((char)(int)(48L + l % 10L));
            return;
        }
    }

    void b(String s)
    {
        a(s);
        b('\n');
    }

    void c(char c1)
    {
        b(c1);
        b('\n');
    }
}
