// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.tapjoy.internal:
//            do, dx, ee

public final class dq
{
    public static final class a extends IOException
    {

        a()
        {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }


    final int a;
    int b;
    final OutputStream c;
    private final byte d[];
    private int e;

    private dq(OutputStream outputstream, byte abyte0[])
    {
        e = 0;
        c = outputstream;
        d = abyte0;
        b = 0;
        a = abyte0.length;
    }

    dq(byte abyte0[], int i)
    {
        e = 0;
        c = null;
        d = abyte0;
        b = 0;
        a = i + 0;
    }

    public static dq a(OutputStream outputstream, int i)
    {
        return new dq(outputstream, new byte[i]);
    }

    public static int b(int i)
    {
        return d(1) + g(i);
    }

    public static int b(int i, int j)
    {
        return d(i) + g(j);
    }

    public static int b(int i, long l)
    {
        int j = d(i);
        if ((-128L & l) == 0L)
        {
            i = 1;
        } else
        if ((-16384L & l) == 0L)
        {
            i = 2;
        } else
        if ((0xffffffffffe00000L & l) == 0L)
        {
            i = 3;
        } else
        if ((0xfffffffff0000000L & l) == 0L)
        {
            i = 4;
        } else
        if ((0xfffffff800000000L & l) == 0L)
        {
            i = 5;
        } else
        if ((0xfffffc0000000000L & l) == 0L)
        {
            i = 6;
        } else
        if ((0xfffe000000000000L & l) == 0L)
        {
            i = 7;
        } else
        if ((0xff00000000000000L & l) == 0L)
        {
            i = 8;
        } else
        if ((0x8000000000000000L & l) == 0L)
        {
            i = 9;
        } else
        {
            i = 10;
        }
        return i + j;
    }

    public static int b(int i, do do1)
    {
        return d(i) + (h(do1.a()) + do1.a());
    }

    public static int b(int i, dx dx1)
    {
        i = d(i);
        int j = dx1.b();
        return i + (j + h(j));
    }

    private void b()
    {
        if (c == null)
        {
            throw new a();
        } else
        {
            c.write(d, 0, b);
            b = 0;
            return;
        }
    }

    private void c(int i, int j)
    {
        e(ee.a(i, j));
    }

    public static int d(int i)
    {
        return h(ee.a(i, 0));
    }

    private void f(int i)
    {
        if (i >= 0)
        {
            e(i);
            return;
        } else
        {
            a(i);
            return;
        }
    }

    private static int g(int i)
    {
        if (i >= 0)
        {
            return h(i);
        } else
        {
            return 10;
        }
    }

    private static int h(int i)
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

    public final void a()
    {
        if (c != null)
        {
            b();
        }
    }

    public final void a(int i)
    {
        c(1, 0);
        f(i);
    }

    public final void a(int i, double d1)
    {
        c(i, 1);
        b(Double.doubleToRawLongBits(d1));
    }

    public final void a(int i, int j)
    {
        c(i, 0);
        f(j);
    }

    public final void a(int i, long l)
    {
        c(i, 0);
        a(l);
    }

    public final void a(int i, do do1)
    {
        c(i, 2);
        a(do1);
    }

    public final void a(int i, dx dx1)
    {
        c(i, 2);
        e(dx1.b());
        dx1.a(this);
    }

    public final void a(int i, boolean flag)
    {
        boolean flag1 = false;
        c(i, 0);
        i = ((flag1) ? 1 : 0);
        if (flag)
        {
            i = 1;
        }
        c(i);
    }

    public final void a(long l)
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

    public final void a(do do1)
    {
        e(do1.a());
        b(do1);
    }

    public final void b(long l)
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

    public final void b(do do1)
    {
        int i = do1.a();
        if (a - b >= i)
        {
            do1.b(d, 0, b, i);
            b = b + i;
        } else
        {
            int j = a - b;
            do1.b(d, 0, b, j);
            int k = j + 0;
            i -= j;
            b = a;
            e = j + e;
            b();
            if (i <= a)
            {
                do1.b(d, k, 0, i);
                b = i;
            } else
            {
                do1.a(c, k, i);
            }
        }
        e = i + e;
    }

    public final void c(int i)
    {
        byte byte0 = (byte)i;
        if (b == a)
        {
            b();
        }
        byte abyte0[] = d;
        i = b;
        b = i + 1;
        abyte0[i] = byte0;
        e = e + 1;
    }

    public final void e(int i)
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
}
