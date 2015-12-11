// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.InputStream;
import java.util.Vector;

public final class eud
{

    private final byte a[];
    private int b;
    private int c;
    private int d;
    private final InputStream e;
    private int f;
    private int g;
    private int h;
    private int i;
    private int j;
    private int k;

    private eud(InputStream inputstream)
    {
        h = 0x7fffffff;
        j = 64;
        k = 0x4000000;
        a = new byte[4096];
        b = 0;
        d = 0;
        e = inputstream;
    }

    eud(byte abyte0[], int i1, int j1)
    {
        h = 0x7fffffff;
        j = 64;
        k = 0x4000000;
        a = abyte0;
        b = i1 + j1;
        d = i1;
        e = null;
    }

    public static eud a(InputStream inputstream)
    {
        return new eud(inputstream);
    }

    private boolean a(boolean flag)
    {
        if (d < b)
        {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        }
        if (g + b == h)
        {
            if (flag)
            {
                throw euf.a();
            } else
            {
                return false;
            }
        }
        g = g + b;
        d = 0;
        int i1;
        if (e == null)
        {
            i1 = -1;
        } else
        {
            i1 = e.read(a);
        }
        b = i1;
        if (b == 0 || b < -1)
        {
            i1 = b;
            throw new IllegalStateException((new StringBuilder(102)).append("InputStream#read(byte[]) returned invalid result: ").append(i1).append("\nThe InputStream implementation is buggy.").toString());
        }
        if (b == -1)
        {
            b = 0;
            if (flag)
            {
                throw euf.a();
            } else
            {
                return false;
            }
        }
        q();
        i1 = g + b + c;
        if (i1 > k || i1 < 0)
        {
            throw euf.h();
        } else
        {
            return true;
        }
    }

    private byte[] c(int i1)
    {
        if (i1 < 0)
        {
            throw euf.b();
        }
        if (g + d + i1 > h)
        {
            d(h - g - d);
            throw euf.a();
        }
        if (i1 <= b - d)
        {
            byte abyte0[] = new byte[i1];
            System.arraycopy(a, d, abyte0, 0, i1);
            d = d + i1;
            return abyte0;
        }
        if (i1 < 4096)
        {
            byte abyte1[] = new byte[i1];
            int j1 = b - d;
            System.arraycopy(a, d, abyte1, 0, j1);
            d = b;
            a(true);
            while (i1 - j1 > b) 
            {
                System.arraycopy(a, 0, abyte1, j1, b);
                j1 += b;
                d = b;
                a(true);
            }
            System.arraycopy(a, 0, abyte1, j1, i1 - j1);
            d = i1 - j1;
            return abyte1;
        }
        int l2 = d;
        int i3 = b;
        g = g + b;
        d = 0;
        b = 0;
        Vector vector = new Vector();
        int j2;
        for (int k1 = i1 - (i3 - l2); k1 > 0; k1 -= j2)
        {
            byte abyte2[] = new byte[Math.min(k1, 4096)];
            int k2;
            for (int i2 = 0; i2 < abyte2.length; i2 += k2)
            {
                if (e == null)
                {
                    k2 = -1;
                } else
                {
                    k2 = e.read(abyte2, i2, abyte2.length - i2);
                }
                if (k2 == -1)
                {
                    throw euf.a();
                }
                g = g + k2;
            }

            j2 = abyte2.length;
            vector.addElement(abyte2);
        }

        byte abyte3[] = new byte[i1];
        int l1 = i3 - l2;
        System.arraycopy(a, l2, abyte3, 0, l1);
        for (i1 = 0; i1 < vector.size(); i1++)
        {
            byte abyte4[] = (byte[])vector.elementAt(i1);
            System.arraycopy(abyte4, 0, abyte3, l1, abyte4.length);
            l1 += abyte4.length;
        }

        return abyte3;
    }

    private void d(int i1)
    {
        if (i1 < 0)
        {
            throw euf.b();
        }
        if (g + d + i1 > h)
        {
            d(h - g - d);
            throw euf.a();
        }
        if (i1 <= b - d)
        {
            d = d + i1;
        } else
        {
            int j1 = b - d;
            g = g + j1;
            d = 0;
            b = 0;
            while (j1 < i1) 
            {
                int k1;
                if (e == null)
                {
                    k1 = -1;
                } else
                {
                    k1 = (int)e.skip(i1 - j1);
                }
                if (k1 <= 0)
                {
                    throw euf.a();
                }
                j1 += k1;
                g = k1 + g;
            }
        }
    }

    private int o()
    {
        return r() & 0xff | (r() & 0xff) << 8 | (r() & 0xff) << 16 | (r() & 0xff) << 24;
    }

    private long p()
    {
        int i1 = r();
        int j1 = r();
        int k1 = r();
        int l1 = r();
        int i2 = r();
        int j2 = r();
        int k2 = r();
        int l2 = r();
        long l3 = i1;
        return ((long)j1 & 255L) << 8 | l3 & 255L | ((long)k1 & 255L) << 16 | ((long)l1 & 255L) << 24 | ((long)i2 & 255L) << 32 | ((long)j2 & 255L) << 40 | ((long)k2 & 255L) << 48 | ((long)l2 & 255L) << 56;
    }

    private void q()
    {
        b = b + c;
        int i1 = g + b;
        if (i1 > h)
        {
            c = i1 - h;
            b = b - c;
            return;
        } else
        {
            c = 0;
            return;
        }
    }

    private byte r()
    {
        if (d == b)
        {
            a(true);
        }
        byte abyte0[] = a;
        int i1 = d;
        d = i1 + 1;
        return abyte0[i1];
    }

    public final int a()
    {
        boolean flag;
        if (d == b && !a(false))
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
        f = m();
        if (f == 0)
        {
            throw euf.d();
        } else
        {
            return f;
        }
    }

    public final void a(int i1)
    {
        if (f != i1)
        {
            throw euf.e();
        } else
        {
            return;
        }
    }

    public final void a(eug eug1)
    {
        int i1 = m();
        if (i >= j)
        {
            throw euf.g();
        }
        if (i1 < 0)
        {
            throw euf.b();
        }
        i1 += g + d;
        int j1 = h;
        if (i1 > j1)
        {
            throw euf.a();
        } else
        {
            h = i1;
            q();
            i = i + 1;
            eug1.a(this);
            a(0);
            i = i - 1;
            h = j1;
            q();
            return;
        }
    }

    public final void a(eug eug1, int i1)
    {
        if (i >= j)
        {
            throw euf.g();
        } else
        {
            i = i + 1;
            eug1.a(this);
            a(euh.a(5, 4));
            i = i - 1;
            return;
        }
    }

    public final double b()
    {
        return Double.longBitsToDouble(p());
    }

    public final boolean b(int i1)
    {
        switch (euh.a(i1))
        {
        default:
            throw euf.f();

        case 0: // '\0'
            m();
            return true;

        case 1: // '\001'
            p();
            return true;

        case 2: // '\002'
            d(m());
            return true;

        case 3: // '\003'
            int j1;
            do
            {
                j1 = a();
            } while (j1 != 0 && b(j1));
            a(euh.a(euh.b(i1), 4));
            return true;

        case 4: // '\004'
            return false;

        case 5: // '\005'
            o();
            return true;
        }
    }

    public final float c()
    {
        return Float.intBitsToFloat(o());
    }

    public final long d()
    {
        return n();
    }

    public final long e()
    {
        return n();
    }

    public final int f()
    {
        return m();
    }

    public final long g()
    {
        return p();
    }

    public final boolean h()
    {
        return m() != 0;
    }

    public final String i()
    {
        int i1 = m();
        if (i1 <= b - d && i1 > 0)
        {
            String s = new String(a, d, i1, "UTF-8");
            d = i1 + d;
            return s;
        } else
        {
            return new String(c(i1), "UTF-8");
        }
    }

    public final euc j()
    {
        int i1 = m();
        if (i1 <= b - d && i1 > 0)
        {
            euc euc1 = euc.a(a, d, i1);
            d = i1 + d;
            return euc1;
        } else
        {
            return euc.a(c(i1));
        }
    }

    public final int k()
    {
        return m();
    }

    public final int l()
    {
        return o();
    }

    public final int m()
    {
        int i1 = r();
        if (i1 < 0) goto _L2; else goto _L1
_L1:
        return i1;
_L2:
        i1 &= 0x7f;
        byte byte0 = r();
        if (byte0 >= 0)
        {
            return i1 | byte0 << 7;
        }
        i1 |= (byte0 & 0x7f) << 7;
        byte0 = r();
        if (byte0 >= 0)
        {
            return i1 | byte0 << 14;
        }
        i1 |= (byte0 & 0x7f) << 14;
        int k1 = r();
        if (k1 >= 0)
        {
            return i1 | k1 << 21;
        }
        byte0 = r();
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
                    if (r() >= 0)
                    {
                        break label0;
                    }
                    j1++;
                }
            } while (true);
        }
        if (true) goto _L1; else goto _L3
_L3:
        throw euf.c();
    }

    public final long n()
    {
        int i1 = 0;
        long l1 = 0L;
        for (; i1 < 64; i1 += 7)
        {
            byte byte0 = r();
            l1 |= (long)(byte0 & 0x7f) << i1;
            if ((byte0 & 0x80) == 0)
            {
                return l1;
            }
        }

        throw euf.c();
    }
}
