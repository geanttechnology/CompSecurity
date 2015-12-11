// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.UnsupportedEncodingException;

public final class ags
{

    private final byte a[];
    private final int b;
    private int c;

    private ags(byte abyte0[], int k, int l)
    {
        a = abyte0;
        c = k;
        b = k + l;
    }

    public static ags a(byte abyte0[])
    {
        return a(abyte0, 0, abyte0.length);
    }

    public static ags a(byte abyte0[], int k, int l)
    {
        return new ags(abyte0, k, l);
    }

    public static int b(double d1)
    {
        return 8;
    }

    public static int b(float f1)
    {
        return 4;
    }

    public static int b(int k, double d1)
    {
        return f(k) + b(d1);
    }

    public static int b(int k, float f1)
    {
        return f(k) + b(f1);
    }

    public static int b(int k, long l)
    {
        return f(k) + b(l);
    }

    public static int b(int k, aha aha1)
    {
        return f(k) * 2 + c(aha1);
    }

    public static int b(int k, String s)
    {
        return f(k) + b(s);
    }

    public static int b(int k, boolean flag)
    {
        return f(k) + b(flag);
    }

    public static int b(int k, byte abyte0[])
    {
        return f(k) + c(abyte0);
    }

    public static int b(long l)
    {
        return d(l);
    }

    public static int b(String s)
    {
        int k;
        int l;
        try
        {
            s = s.getBytes("UTF-8");
            k = h(s.length);
            l = s.length;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("UTF-8 not supported.");
        }
        return l + k;
    }

    public static int b(boolean flag)
    {
        return 1;
    }

    public static int c(int k)
    {
        if (k >= 0)
        {
            return h(k);
        } else
        {
            return 10;
        }
    }

    public static int c(int k, int l)
    {
        return f(k) + c(l);
    }

    public static int c(int k, aha aha1)
    {
        return f(k) + d(aha1);
    }

    public static int c(aha aha1)
    {
        return aha1.f();
    }

    public static int c(byte abyte0[])
    {
        return h(abyte0.length) + abyte0.length;
    }

    public static int d(int k)
    {
        return h(j(k));
    }

    public static int d(int k, int l)
    {
        return f(k) + d(l);
    }

    public static int d(long l)
    {
        if ((-128L & l) == 0L)
        {
            return 1;
        }
        if ((-16384L & l) == 0L)
        {
            return 2;
        }
        if ((0xffffffffffe00000L & l) == 0L)
        {
            return 3;
        }
        if ((0xfffffffff0000000L & l) == 0L)
        {
            return 4;
        }
        if ((0xfffffff800000000L & l) == 0L)
        {
            return 5;
        }
        if ((0xfffffc0000000000L & l) == 0L)
        {
            return 6;
        }
        if ((0xfffe000000000000L & l) == 0L)
        {
            return 7;
        }
        if ((0xff00000000000000L & l) == 0L)
        {
            return 8;
        }
        return (0x8000000000000000L & l) != 0L ? 10 : 9;
    }

    public static int d(aha aha1)
    {
        int k = aha1.f();
        return k + h(k);
    }

    public static int f(int k)
    {
        return h(ahd.a(k, 0));
    }

    public static int h(int k)
    {
        if ((k & 0xffffff80) == 0)
        {
            return 1;
        }
        if ((k & 0xffffc000) == 0)
        {
            return 2;
        }
        if ((0xffe00000 & k) == 0)
        {
            return 3;
        }
        return (0xf0000000 & k) != 0 ? 5 : 4;
    }

    public static int j(int k)
    {
        return k << 1 ^ k >> 31;
    }

    public int a()
    {
        return b - c;
    }

    public void a(byte byte0)
    {
        if (c == b)
        {
            throw new agt(c, b);
        } else
        {
            byte abyte0[] = a;
            int k = c;
            c = k + 1;
            abyte0[k] = byte0;
            return;
        }
    }

    public void a(double d1)
    {
        e(Double.doubleToLongBits(d1));
    }

    public void a(float f1)
    {
        i(Float.floatToIntBits(f1));
    }

    public void a(int k)
    {
        if (k >= 0)
        {
            g(k);
            return;
        } else
        {
            c(k);
            return;
        }
    }

    public void a(int k, double d1)
    {
        e(k, 1);
        a(d1);
    }

    public void a(int k, float f1)
    {
        e(k, 5);
        a(f1);
    }

    public void a(int k, int l)
    {
        e(k, 0);
        a(l);
    }

    public void a(int k, long l)
    {
        e(k, 0);
        a(l);
    }

    public void a(int k, aha aha1)
    {
        e(k, 2);
        b(aha1);
    }

    public void a(int k, String s)
    {
        e(k, 2);
        a(s);
    }

    public void a(int k, boolean flag)
    {
        e(k, 0);
        a(flag);
    }

    public void a(int k, byte abyte0[])
    {
        e(k, 2);
        b(abyte0);
    }

    public void a(long l)
    {
        c(l);
    }

    public void a(aha aha1)
    {
        aha1.a(this);
    }

    public void a(String s)
    {
        s = s.getBytes("UTF-8");
        g(s.length);
        d(s);
    }

    public void a(boolean flag)
    {
        int k;
        if (flag)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        e(k);
    }

    public void b()
    {
        if (a() != 0)
        {
            throw new IllegalStateException("Did not write as much data as expected.");
        } else
        {
            return;
        }
    }

    public void b(int k)
    {
        g(j(k));
    }

    public void b(int k, int l)
    {
        e(k, 0);
        b(l);
    }

    public void b(aha aha1)
    {
        g(aha1.e());
        aha1.a(this);
    }

    public void b(byte abyte0[])
    {
        g(abyte0.length);
        d(abyte0);
    }

    public void b(byte abyte0[], int k, int l)
    {
        if (b - c >= l)
        {
            System.arraycopy(abyte0, k, a, c, l);
            c = c + l;
            return;
        } else
        {
            throw new agt(c, b);
        }
    }

    public void c(long l)
    {
        do
        {
            if ((-128L & l) == 0L)
            {
                e((int)l);
                return;
            }
            e((int)l & 0x7f | 0x80);
            l >>>= 7;
        } while (true);
    }

    public void d(byte abyte0[])
    {
        b(abyte0, 0, abyte0.length);
    }

    public void e(int k)
    {
        a((byte)k);
    }

    public void e(int k, int l)
    {
        g(ahd.a(k, l));
    }

    public void e(long l)
    {
        e((int)l & 0xff);
        e((int)(l >> 8) & 0xff);
        e((int)(l >> 16) & 0xff);
        e((int)(l >> 24) & 0xff);
        e((int)(l >> 32) & 0xff);
        e((int)(l >> 40) & 0xff);
        e((int)(l >> 48) & 0xff);
        e((int)(l >> 56) & 0xff);
    }

    public void g(int k)
    {
        do
        {
            if ((k & 0xffffff80) == 0)
            {
                e(k);
                return;
            }
            e(k & 0x7f | 0x80);
            k >>>= 7;
        } while (true);
    }

    public void i(int k)
    {
        e(k & 0xff);
        e(k >> 8 & 0xff);
        e(k >> 16 & 0xff);
        e(k >> 24 & 0xff);
    }
}
