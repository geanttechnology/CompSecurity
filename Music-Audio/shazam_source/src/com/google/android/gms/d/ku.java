// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;


// Referenced classes of package com.google.android.gms.d:
//            lb, lc, lg

public final class ku
{

    final byte a[];
    int b;
    int c;
    int d;
    private int e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;

    ku(byte abyte0[], int l)
    {
        g = 0x7fffffff;
        i = 64;
        j = 0x4000000;
        a = abyte0;
        b = 0;
        c = l + 0;
        d = 0;
    }

    private void g(int l)
    {
        if (l < 0)
        {
            throw lb.b();
        }
        if (d + l > g)
        {
            g(g - d);
            throw lb.a();
        }
        if (l <= c - d)
        {
            d = d + l;
            return;
        } else
        {
            throw lb.a();
        }
    }

    private void j()
    {
        c = c + e;
        int l = c;
        if (l > g)
        {
            e = l - g;
            c = c - e;
            return;
        } else
        {
            e = 0;
            return;
        }
    }

    private byte k()
    {
        if (d == c)
        {
            throw lb.a();
        } else
        {
            byte abyte0[] = a;
            int l = d;
            d = l + 1;
            return abyte0[l];
        }
    }

    public final int a()
    {
        boolean flag;
        if (d == c)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            f = 0;
            return 0;
        }
        f = e();
        if (f == 0)
        {
            throw lb.d();
        } else
        {
            return f;
        }
    }

    public final void a(int l)
    {
        if (f != l)
        {
            throw lb.e();
        } else
        {
            return;
        }
    }

    public final void a(lc lc1)
    {
        int l = e();
        if (h >= i)
        {
            throw lb.g();
        } else
        {
            l = c(l);
            h = h + 1;
            lc1.a(this);
            a(0);
            h = h - 1;
            d(l);
            return;
        }
    }

    public final long b()
    {
        int l = 0;
        long l1 = 0L;
        for (; l < 64; l += 7)
        {
            byte byte0 = k();
            l1 |= (long)(byte0 & 0x7f) << l;
            if ((byte0 & 0x80) == 0)
            {
                return l1;
            }
        }

        throw lb.c();
    }

    public final boolean b(int l)
    {
        switch (lg.a(l))
        {
        default:
            throw lb.f();

        case 0: // '\0'
            e();
            return true;

        case 1: // '\001'
            g();
            return true;

        case 2: // '\002'
            g(e());
            return true;

        case 3: // '\003'
            int i1;
            do
            {
                i1 = a();
            } while (i1 != 0 && b(i1));
            a(lg.a(lg.b(l), 4));
            return true;

        case 4: // '\004'
            return false;

        case 5: // '\005'
            f();
            return true;
        }
    }

    public final int c(int l)
    {
        if (l < 0)
        {
            throw lb.b();
        }
        l = d + l;
        int i1 = g;
        if (l > i1)
        {
            throw lb.a();
        } else
        {
            g = l;
            j();
            return i1;
        }
    }

    public final boolean c()
    {
        return e() != 0;
    }

    public final String d()
    {
        int l = e();
        if (l <= c - d && l > 0)
        {
            String s = new String(a, d, l, "UTF-8");
            d = l + d;
            return s;
        } else
        {
            return new String(f(l), "UTF-8");
        }
    }

    public final void d(int l)
    {
        g = l;
        j();
    }

    public final int e()
    {
        int l = k();
        if (l < 0) goto _L2; else goto _L1
_L1:
        return l;
_L2:
        l &= 0x7f;
        byte byte0 = k();
        if (byte0 >= 0)
        {
            return l | byte0 << 7;
        }
        l |= (byte0 & 0x7f) << 7;
        byte0 = k();
        if (byte0 >= 0)
        {
            return l | byte0 << 14;
        }
        l |= (byte0 & 0x7f) << 14;
        int j1 = k();
        if (j1 >= 0)
        {
            return l | j1 << 21;
        }
        byte0 = k();
        j1 = l | (j1 & 0x7f) << 21 | byte0 << 28;
        l = j1;
        if (byte0 < 0)
        {
            int i1 = 0;
label0:
            do
            {
label1:
                {
                    if (i1 >= 5)
                    {
                        break label1;
                    }
                    l = j1;
                    if (k() >= 0)
                    {
                        break label0;
                    }
                    i1++;
                }
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
        throw lb.c();
    }

    public final void e(int l)
    {
        if (l > d - b)
        {
            throw new IllegalArgumentException((new StringBuilder("Position ")).append(l).append(" is beyond current ").append(d - b).toString());
        }
        if (l < 0)
        {
            throw new IllegalArgumentException((new StringBuilder("Bad position ")).append(l).toString());
        } else
        {
            d = b + l;
            return;
        }
    }

    public final int f()
    {
        return k() & 0xff | (k() & 0xff) << 8 | (k() & 0xff) << 16 | (k() & 0xff) << 24;
    }

    public final byte[] f(int l)
    {
        if (l < 0)
        {
            throw lb.b();
        }
        if (d + l > g)
        {
            g(g - d);
            throw lb.a();
        }
        if (l <= c - d)
        {
            byte abyte0[] = new byte[l];
            System.arraycopy(a, d, abyte0, 0, l);
            d = d + l;
            return abyte0;
        } else
        {
            throw lb.a();
        }
    }

    public final long g()
    {
        int l = k();
        int i1 = k();
        int j1 = k();
        int k1 = k();
        int l1 = k();
        int i2 = k();
        int j2 = k();
        int k2 = k();
        long l2 = l;
        return ((long)i1 & 255L) << 8 | l2 & 255L | ((long)j1 & 255L) << 16 | ((long)k1 & 255L) << 24 | ((long)l1 & 255L) << 32 | ((long)i2 & 255L) << 40 | ((long)j2 & 255L) << 48 | ((long)k2 & 255L) << 56;
    }

    public final int h()
    {
        if (g == 0x7fffffff)
        {
            return -1;
        } else
        {
            int l = d;
            return g - l;
        }
    }

    public final int i()
    {
        return d - b;
    }
}
