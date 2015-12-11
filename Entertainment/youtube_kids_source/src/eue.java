// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

public final class eue
{

    final int a;
    int b;
    private final byte c[];
    private final OutputStream d = null;

    eue(byte abyte0[], int i, int j)
    {
        c = abyte0;
        b = i;
        a = i + j;
    }

    public static int a(int i)
    {
        if (i >= 0)
        {
            return e(i);
        } else
        {
            return 10;
        }
    }

    public static int a(long l)
    {
        return c(l);
    }

    public static int a(String s)
    {
        int i;
        int j;
        try
        {
            s = s.getBytes("UTF-8");
            i = e(s.length);
            j = s.length;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("UTF-8 not supported.");
        }
        return j + i;
    }

    private void a(byte abyte0[])
    {
        int i = abyte0.length;
        if (a - b >= i)
        {
            System.arraycopy(abyte0, 0, c, b, i);
            b = i + b;
            return;
        } else
        {
            int j = a - b;
            System.arraycopy(abyte0, 0, c, b, j);
            b = a;
            throw new arv();
        }
    }

    public static int b(int i)
    {
        return e(euh.a(i, 0));
    }

    public static int b(int i, double d1)
    {
        return b(i) + 8;
    }

    public static int b(int i, float f1)
    {
        return b(i) + 4;
    }

    public static int b(int i, euc euc1)
    {
        return b(i) + (e(euc1.a.length) + euc1.a.length);
    }

    public static int b(int i, String s)
    {
        return b(i) + a(s);
    }

    public static int b(int i, boolean flag)
    {
        return b(i) + 1;
    }

    private void b(long l)
    {
        do
        {
            if ((-128L & l) == 0L)
            {
                c((int)l);
                return;
            }
            c((int)l & 0x7f | 0x80);
            l >>>= 7;
        } while (true);
    }

    public static int c(int i, eug eug1)
    {
        return (b(5) << 1) + eug1.b();
    }

    private static int c(long l)
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

    private void c(int i)
    {
        byte byte0 = (byte)i;
        if (b == a)
        {
            throw new arv();
        } else
        {
            byte abyte0[] = c;
            i = b;
            b = i + 1;
            abyte0[i] = byte0;
            return;
        }
    }

    public static int d(int i, int j)
    {
        return b(i) + a(j);
    }

    public static int d(int i, long l)
    {
        return b(i) + c(l);
    }

    public static int d(int i, eug eug1)
    {
        i = b(i);
        int j = eug1.b();
        return i + (j + e(j));
    }

    private void d(int i)
    {
        do
        {
            if ((i & 0xffffff80) == 0)
            {
                c(i);
                return;
            }
            c(i & 0x7f | 0x80);
            i >>>= 7;
        } while (true);
    }

    private void d(long l)
    {
        c((int)l & 0xff);
        c((int)(l >> 8) & 0xff);
        c((int)(l >> 16) & 0xff);
        c((int)(l >> 24) & 0xff);
        c((int)(l >> 32) & 0xff);
        c((int)(l >> 40) & 0xff);
        c((int)(l >> 48) & 0xff);
        c((int)(l >> 56) & 0xff);
    }

    private static int e(int i)
    {
        if ((i & 0xffffff80) == 0)
        {
            return 1;
        }
        if ((i & 0xffffc000) == 0)
        {
            return 2;
        }
        if ((0xffe00000 & i) == 0)
        {
            return 3;
        }
        return (0xf0000000 & i) != 0 ? 5 : 4;
    }

    public static int e(int i, int j)
    {
        return b(i) + e(j);
    }

    public static int e(int i, long l)
    {
        return b(i) + c(l);
    }

    public static int f(int i, int j)
    {
        return b(i) + 4;
    }

    public static int f(int i, long l)
    {
        return b(i) + 8;
    }

    private void f(int i)
    {
        c(i & 0xff);
        c(i >> 8 & 0xff);
        c(i >> 16 & 0xff);
        c(i >>> 24);
    }

    private void g(int i, int j)
    {
        d(euh.a(i, j));
    }

    public final void a(int i, double d1)
    {
        g(i, 1);
        d(Double.doubleToLongBits(d1));
    }

    public final void a(int i, float f1)
    {
        g(i, 5);
        f(Float.floatToIntBits(f1));
    }

    public final void a(int i, int j)
    {
        g(i, 0);
        if (j >= 0)
        {
            d(j);
            return;
        } else
        {
            b(j);
            return;
        }
    }

    public final void a(int i, long l)
    {
        g(i, 0);
        b(l);
    }

    public final void a(int i, euc euc1)
    {
        g(i, 2);
        euc1 = euc1.b();
        d(euc1.length);
        a(((byte []) (euc1)));
    }

    public final void a(int i, eug eug1)
    {
        g(5, 3);
        eug1.a(this);
        g(5, 4);
    }

    public final void a(int i, String s)
    {
        g(i, 2);
        s = s.getBytes("UTF-8");
        d(s.length);
        a(((byte []) (s)));
    }

    public final void a(int i, boolean flag)
    {
        boolean flag1 = false;
        g(i, 0);
        i = ((flag1) ? 1 : 0);
        if (flag)
        {
            i = 1;
        }
        c(i);
    }

    public final void b(int i, int j)
    {
        g(i, 0);
        d(j);
    }

    public final void b(int i, long l)
    {
        g(i, 0);
        b(l);
    }

    public final void b(int i, eug eug1)
    {
        g(i, 2);
        d(eug1.a());
        eug1.a(this);
    }

    public final void c(int i, int j)
    {
        g(i, 5);
        f(j);
    }

    public final void c(int i, long l)
    {
        g(i, 1);
        d(l);
    }
}
