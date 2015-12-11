// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

// Referenced classes of package com.google.android.gms.internal:
//            jb

public final class ix
{
    public static class a extends IOException
    {

        a(int k, int l)
        {
            super((new StringBuilder()).append("CodedOutputStream was writing to a flat byte array and ran out of space (pos ").append(k).append(" limit ").append(l).append(").").toString());
        }
    }


    private final int Hw;
    private final byte buffer[];
    private int position;

    private ix(byte abyte0[], int k, int l)
    {
        buffer = abyte0;
        position = k;
        Hw = k + l;
    }

    public static int aD(String s1)
    {
        int k;
        int l;
        try
        {
            s1 = s1.getBytes("UTF-8");
            k = bR(s1.length);
            l = s1.length;
        }
        // Misplaced declaration of an exception variable
        catch (String s1)
        {
            throw new RuntimeException("UTF-8 not supported.");
        }
        return l + k;
    }

    public static ix b(byte abyte0[], int k, int l)
    {
        return new ix(abyte0, k, l);
    }

    public static int bN(int k)
    {
        if (k >= 0)
        {
            return bR(k);
        } else
        {
            return 10;
        }
    }

    public static int bP(int k)
    {
        return bR(jb.g(k, 0));
    }

    public static int bR(int k)
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

    public static int d(int k, long l)
    {
        return bP(k) + q(l);
    }

    public static int e(int k, int l)
    {
        return bP(k) + bN(l);
    }

    public static int e(int k, String s1)
    {
        return bP(k) + aD(s1);
    }

    public static ix i(byte abyte0[])
    {
        return b(abyte0, 0, abyte0.length);
    }

    public static int q(long l)
    {
        return s(t(l));
    }

    public static int s(long l)
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

    public static long t(long l)
    {
        return l << 1 ^ l >> 63;
    }

    public void aC(String s1)
        throws IOException
    {
        s1 = s1.getBytes("UTF-8");
        bQ(s1.length);
        j(s1);
    }

    public void b(byte byte0)
        throws IOException
    {
        if (position == Hw)
        {
            throw new a(position, Hw);
        } else
        {
            byte abyte0[] = buffer;
            int k = position;
            position = k + 1;
            abyte0[k] = byte0;
            return;
        }
    }

    public void b(int k, long l)
        throws IOException
    {
        f(k, 0);
        o(l);
    }

    public void b(int k, String s1)
        throws IOException
    {
        f(k, 2);
        aC(s1);
    }

    public void bM(int k)
        throws IOException
    {
        if (k >= 0)
        {
            bQ(k);
            return;
        } else
        {
            r(k);
            return;
        }
    }

    public void bO(int k)
        throws IOException
    {
        b((byte)k);
    }

    public void bQ(int k)
        throws IOException
    {
        do
        {
            if ((k & 0xffffff80) == 0)
            {
                bO(k);
                return;
            }
            bO(k & 0x7f | 0x80);
            k >>>= 7;
        } while (true);
    }

    public void c(int k, long l)
        throws IOException
    {
        f(k, 0);
        p(l);
    }

    public void c(byte abyte0[], int k, int l)
        throws IOException
    {
        if (Hw - position >= l)
        {
            System.arraycopy(abyte0, k, buffer, position, l);
            position = position + l;
            return;
        } else
        {
            throw new a(position, Hw);
        }
    }

    public void d(int k, int l)
        throws IOException
    {
        f(k, 0);
        bM(l);
    }

    public void f(int k, int l)
        throws IOException
    {
        bQ(jb.g(k, l));
    }

    public int ge()
    {
        return Hw - position;
    }

    public void gf()
    {
        if (ge() != 0)
        {
            throw new IllegalStateException("Did not write as much data as expected.");
        } else
        {
            return;
        }
    }

    public void j(byte abyte0[])
        throws IOException
    {
        c(abyte0, 0, abyte0.length);
    }

    public void o(long l)
        throws IOException
    {
        r(l);
    }

    public void p(long l)
        throws IOException
    {
        r(t(l));
    }

    public void r(long l)
        throws IOException
    {
        do
        {
            if ((-128L & l) == 0L)
            {
                bO((int)l);
                return;
            }
            bO((int)l & 0x7f | 0x80);
            l >>>= 7;
        } while (true);
    }
}
