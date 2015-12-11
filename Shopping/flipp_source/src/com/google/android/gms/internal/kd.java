// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.UnsupportedEncodingException;

// Referenced classes of package com.google.android.gms.internal:
//            ki, ke

public final class kd
{

    private final byte a[];
    private final int b;
    private int c;

    private kd(byte abyte0[], int i)
    {
        a = abyte0;
        c = 0;
        b = i + 0;
    }

    public static int a(int i)
    {
        return c(ki.a(i, 0));
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

    public static kd a(byte abyte0[], int i)
    {
        return new kd(abyte0, i);
    }

    public static int b(int i, long l)
    {
        int j = a(i);
        l = b(l);
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
        if ((l & 0x8000000000000000L) == 0L)
        {
            i = 9;
        } else
        {
            i = 10;
        }
        return i + j;
    }

    private static long b(long l)
    {
        return l << 1 ^ l >> 63;
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

    private void d(int i)
    {
        byte byte0 = (byte)i;
        if (c == b)
        {
            throw new ke(c, b);
        } else
        {
            byte abyte0[] = a;
            i = c;
            c = i + 1;
            abyte0[i] = byte0;
            return;
        }
    }

    public final int a()
    {
        return b - c;
    }

    public final void a(int i, int j)
    {
        b(ki.a(i, j));
    }

    public final void a(int i, long l)
    {
        a(i, 0);
        a(b(l));
    }

    public final void a(int i, String s)
    {
        a(i, 2);
        s = s.getBytes("UTF-8");
        b(s.length);
        i = s.length;
        if (b - c >= i)
        {
            System.arraycopy(s, 0, a, c, i);
            c = c + i;
            return;
        } else
        {
            throw new ke(c, b);
        }
    }

    public final void a(long l)
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

    public final void b(int i)
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
}
