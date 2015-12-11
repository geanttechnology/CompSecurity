// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 


public final class eui
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

    eui(byte abyte0[], int i1, int j1)
    {
        d = 0x7fffffff;
        i = 64;
        a = abyte0;
        b = i1;
        e = i1 + j1;
        c = i1;
    }

    private byte[] c(int i1)
    {
        if (i1 < 0)
        {
            throw eum.b();
        }
        if (c + i1 > d)
        {
            d(d - c);
            throw eum.a();
        }
        if (i1 <= e - c)
        {
            byte abyte0[] = new byte[i1];
            System.arraycopy(a, c, abyte0, 0, i1);
            c = c + i1;
            return abyte0;
        } else
        {
            throw eum.a();
        }
    }

    private void d(int i1)
    {
        if (i1 < 0)
        {
            throw eum.b();
        }
        if (c + i1 > d)
        {
            d(d - c);
            throw eum.a();
        }
        if (i1 <= e - c)
        {
            c = c + i1;
            return;
        } else
        {
            throw eum.a();
        }
    }

    private int l()
    {
        int i1 = o();
        if (i1 < 0) goto _L2; else goto _L1
_L1:
        return i1;
_L2:
        i1 &= 0x7f;
        byte byte0 = o();
        if (byte0 >= 0)
        {
            return i1 | byte0 << 7;
        }
        i1 |= (byte0 & 0x7f) << 7;
        byte0 = o();
        if (byte0 >= 0)
        {
            return i1 | byte0 << 14;
        }
        i1 |= (byte0 & 0x7f) << 14;
        int k1 = o();
        if (k1 >= 0)
        {
            return i1 | k1 << 21;
        }
        byte0 = o();
        k1 = i1 | (k1 & 0x7f) << 21 | byte0 << 28;
        i1 = k1;
        if (byte0 < 0)
        {
            int j1 = 0;
label0:
            do
            {
label1:
                {
                    if (j1 >= 5)
                    {
                        break label1;
                    }
                    i1 = k1;
                    if (o() >= 0)
                    {
                        break label0;
                    }
                    j1++;
                }
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
        throw eum.c();
    }

    private long m()
    {
        int i1 = 0;
        long l1 = 0L;
        for (; i1 < 64; i1 += 7)
        {
            byte byte0 = o();
            l1 |= (long)(byte0 & 0x7f) << i1;
            if ((byte0 & 0x80) == 0)
            {
                return l1;
            }
        }

        throw eum.c();
    }

    private void n()
    {
        e = e + f;
        int i1 = e;
        if (i1 > d)
        {
            f = i1 - d;
            e = e - f;
            return;
        } else
        {
            f = 0;
            return;
        }
    }

    private byte o()
    {
        if (c == e)
        {
            throw eum.a();
        } else
        {
            byte abyte0[] = a;
            int i1 = c;
            c = i1 + 1;
            return abyte0[i1];
        }
    }

    public final int a()
    {
        boolean flag;
        if (c == e)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            g = 0;
            return 0;
        }
        g = l();
        if (g == 0)
        {
            throw eum.d();
        } else
        {
            return g;
        }
    }

    public final void a(int i1)
    {
        if (g != i1)
        {
            throw eum.e();
        } else
        {
            return;
        }
    }

    public final void a(eun eun1)
    {
        int i1 = l();
        if (h >= i)
        {
            throw eum.g();
        }
        if (i1 < 0)
        {
            throw eum.b();
        }
        i1 += c;
        int j1 = d;
        if (i1 > j1)
        {
            throw eum.a();
        } else
        {
            d = i1;
            n();
            h = h + 1;
            eun1.a(this);
            a(0);
            h = h - 1;
            d = j1;
            n();
            return;
        }
    }

    public final long b()
    {
        return m();
    }

    public final boolean b(int i1)
    {
        switch (eup.a(i1))
        {
        default:
            throw eum.f();

        case 0: // '\0'
            l();
            return true;

        case 1: // '\001'
            j();
            return true;

        case 2: // '\002'
            d(l());
            return true;

        case 3: // '\003'
            int j1;
            do
            {
                j1 = a();
            } while (j1 != 0 && b(j1));
            a(eup.a(eup.b(i1), 4));
            return true;

        case 4: // '\004'
            return false;

        case 5: // '\005'
            i();
            return true;
        }
    }

    public final long c()
    {
        return m();
    }

    public final int d()
    {
        return l();
    }

    public final boolean e()
    {
        return l() != 0;
    }

    public final String f()
    {
        int i1 = l();
        if (i1 <= e - c && i1 > 0)
        {
            String s = new String(a, c, i1, "UTF-8");
            c = i1 + c;
            return s;
        } else
        {
            return new String(c(i1), "UTF-8");
        }
    }

    public final byte[] g()
    {
        int i1 = l();
        if (i1 <= e - c && i1 > 0)
        {
            byte abyte0[] = new byte[i1];
            System.arraycopy(a, c, abyte0, 0, i1);
            c = i1 + c;
            return abyte0;
        } else
        {
            return c(i1);
        }
    }

    public final int h()
    {
        return l();
    }

    public final int i()
    {
        return o() & 0xff | (o() & 0xff) << 8 | (o() & 0xff) << 16 | (o() & 0xff) << 24;
    }

    public final long j()
    {
        int i1 = o();
        int j1 = o();
        int k1 = o();
        int l1 = o();
        int i2 = o();
        int j2 = o();
        int k2 = o();
        int l2 = o();
        long l3 = i1;
        return ((long)j1 & 255L) << 8 | l3 & 255L | ((long)k1 & 255L) << 16 | ((long)l1 & 255L) << 24 | ((long)i2 & 255L) << 32 | ((long)j2 & 255L) << 40 | ((long)k2 & 255L) << 48 | ((long)l2 & 255L) << 56;
    }

    public final int k()
    {
        return c - b;
    }
}
