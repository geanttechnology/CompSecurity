// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import java.io.UnsupportedEncodingException;

public final class euj
{

    final int a;
    int b;
    private final byte c[];

    euj(byte abyte0[], int i, int j)
    {
        c = abyte0;
        b = i;
        a = i + j;
    }

    public static int a(int i)
    {
        if (i >= 0)
        {
            return c(i);
        } else
        {
            return 10;
        }
    }

    public static int a(long l)
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

    public static int a(String s)
    {
        int i;
        int j;
        try
        {
            s = s.getBytes("UTF-8");
            i = c(s.length);
            j = s.length;
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("UTF-8 not supported.");
        }
        return j + i;
    }

    public static int a(byte abyte0[])
    {
        return c(abyte0.length) + abyte0.length;
    }

    public static int b(int i)
    {
        return c(eup.a(i, 0));
    }

    public static int b(int i, eun eun1)
    {
        i = b(i);
        int j = eun1.a();
        return i + (j + c(j));
    }

    public static int b(int i, String s)
    {
        return b(i) + a(s);
    }

    public static int b(int i, byte abyte0[])
    {
        return b(i) + a(abyte0);
    }

    private void b(long l)
    {
        do
        {
            if ((-128L & l) == 0L)
            {
                d((int)l);
                return;
            }
            d((int)l & 0x7f | 0x80);
            l >>>= 7;
        } while (true);
    }

    public static int c(int i)
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

    public static int c(int i, int j)
    {
        return b(i) + a(j);
    }

    public static int c(int i, long l)
    {
        return b(i) + a(l);
    }

    public static int d(int i, int j)
    {
        return b(i) + c(j);
    }

    public static int d(int i, long l)
    {
        return b(i) + a(l);
    }

    private void d(int i)
    {
        byte byte0 = (byte)i;
        if (b == a)
        {
            throw new euk(b, a);
        } else
        {
            byte abyte0[] = c;
            i = b;
            b = i + 1;
            abyte0[i] = byte0;
            return;
        }
    }

    private void e(int i)
    {
        do
        {
            if ((i & 0xffffff80) == 0)
            {
                d(i);
                return;
            }
            d(i & 0x7f | 0x80);
            i >>>= 7;
        } while (true);
    }

    public final void a(int i, double d1)
    {
        e(i, 1);
        long l = Double.doubleToLongBits(d1);
        d((int)l & 0xff);
        d((int)(l >> 8) & 0xff);
        d((int)(l >> 16) & 0xff);
        d((int)(l >> 24) & 0xff);
        d((int)(l >> 32) & 0xff);
        d((int)(l >> 40) & 0xff);
        d((int)(l >> 48) & 0xff);
        d((int)(l >> 56) & 0xff);
    }

    public final void a(int i, float f)
    {
        e(i, 5);
        i = Float.floatToIntBits(f);
        d(i & 0xff);
        d(i >> 8 & 0xff);
        d(i >> 16 & 0xff);
        d(i >>> 24);
    }

    public final void a(int i, int j)
    {
        e(i, 0);
        if (j >= 0)
        {
            e(j);
            return;
        } else
        {
            b(j);
            return;
        }
    }

    public final void a(int i, long l)
    {
        e(i, 0);
        b(l);
    }

    public final void a(int i, eun eun1)
    {
        e(i, 2);
        if (eun1.P < 0)
        {
            eun1.a();
        }
        e(eun1.P);
        eun1.a(this);
    }

    public final void a(int i, String s)
    {
        e(i, 2);
        s = s.getBytes("UTF-8");
        e(s.length);
        b(s);
    }

    public final void a(int i, boolean flag)
    {
        boolean flag1 = false;
        e(i, 0);
        i = ((flag1) ? 1 : 0);
        if (flag)
        {
            i = 1;
        }
        d(i);
    }

    public final void a(int i, byte abyte0[])
    {
        e(i, 2);
        e(abyte0.length);
        b(abyte0);
    }

    public final void b(int i, int j)
    {
        e(i, 0);
        e(j);
    }

    public final void b(int i, long l)
    {
        e(i, 0);
        b(l);
    }

    public final void b(byte abyte0[])
    {
        int i = abyte0.length;
        if (a - b >= i)
        {
            System.arraycopy(abyte0, 0, c, b, i);
            b = i + b;
            return;
        } else
        {
            throw new euk(b, a);
        }
    }

    public final void e(int i, int j)
    {
        e(eup.a(i, j));
    }
}
