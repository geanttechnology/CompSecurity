// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tapjoy.internal;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.tapjoy.internal:
//            du, dt, ee, dz, 
//            dx, dq, dn, do, 
//            dw, dr

public final class dp
{
    static interface a
    {
    }


    private final byte a[];
    private final boolean b;
    private int c;
    private int d;
    private int e;
    private final InputStream f;
    private int g;
    private boolean h;
    private int i;
    private int j;
    private int k;
    private int l;
    private int m;
    private a n;

    dp(InputStream inputstream)
    {
        h = false;
        j = 0x7fffffff;
        l = 64;
        m = 0x4000000;
        n = null;
        a = new byte[4096];
        c = 0;
        e = 0;
        i = 0;
        f = inputstream;
        b = false;
    }

    private dp(byte abyte0[], int i1)
    {
        h = false;
        j = 0x7fffffff;
        l = 64;
        m = 0x4000000;
        n = null;
        a = abyte0;
        c = i1 + 0;
        e = 0;
        i = 0;
        f = null;
        b = false;
    }

    public static dp a(byte abyte0[], int i1)
    {
        abyte0 = new dp(abyte0, i1);
        try
        {
            abyte0.b(i1);
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new IllegalArgumentException(abyte0);
        }
        return abyte0;
    }

    private int b(int i1)
    {
        if (i1 < 0)
        {
            throw du.b();
        }
        i1 = i + e + i1;
        int j1 = j;
        if (i1 > j1)
        {
            throw du.a();
        } else
        {
            j = i1;
            i();
            return j1;
        }
    }

    private void c(int i1)
    {
        if (!d(i1))
        {
            throw du.a();
        } else
        {
            return;
        }
    }

    private boolean d(int i1)
    {
_L6:
        if (e + i1 <= c)
        {
            throw new IllegalStateException((new StringBuilder(77)).append("refillBuffer() called when ").append(i1).append(" bytes were already available in buffer").toString());
        }
        if (i + e + i1 <= j) goto _L2; else goto _L1
_L1:
        return false;
_L2:
        a a1;
        if (n != null)
        {
            a1 = n;
        }
        if (f == null) goto _L1; else goto _L3
_L3:
        int j1;
        j1 = e;
        if (j1 > 0)
        {
            if (c > j1)
            {
                System.arraycopy(a, j1, a, 0, c - j1);
            }
            i = i + j1;
            c = c - j1;
            e = 0;
        }
        j1 = f.read(a, c, a.length - c);
        if (j1 == 0 || j1 < -1 || j1 > a.length)
        {
            throw new IllegalStateException((new StringBuilder(102)).append("InputStream#read(byte[]) returned invalid result: ").append(j1).append("\nThe InputStream implementation is buggy.").toString());
        }
        if (j1 <= 0) goto _L1; else goto _L4
_L4:
        c = j1 + c;
        if ((i + i1) - m > 0)
        {
            throw du.h();
        }
        i();
        if (c >= i1)
        {
            return true;
        }
        if (true) goto _L6; else goto _L5
_L5:
    }

    private byte[] e(int i1)
    {
        if (i1 <= 0)
        {
            if (i1 == 0)
            {
                return dt.a;
            } else
            {
                throw du.b();
            }
        }
        if (i + e + i1 > j)
        {
            f(j - i - e);
            throw du.a();
        }
        if (i1 < 4096)
        {
            byte abyte0[] = new byte[i1];
            int j1 = c - e;
            System.arraycopy(a, e, abyte0, 0, j1);
            e = c;
            i1 -= j1;
            if (c - e < i1)
            {
                c(i1);
            }
            System.arraycopy(a, 0, abyte0, j1, i1);
            e = i1;
            return abyte0;
        }
        int k2 = e;
        int l2 = c;
        i = i + c;
        e = 0;
        c = 0;
        Object obj = new ArrayList();
        int i2;
        for (int k1 = i1 - (l2 - k2); k1 > 0; k1 -= i2)
        {
            byte abyte1[] = new byte[Math.min(k1, 4096)];
            int j2;
            for (int l1 = 0; l1 < abyte1.length; l1 += j2)
            {
                if (f == null)
                {
                    j2 = -1;
                } else
                {
                    j2 = f.read(abyte1, l1, abyte1.length - l1);
                }
                if (j2 == -1)
                {
                    throw du.a();
                }
                i = i + j2;
            }

            i2 = abyte1.length;
            ((List) (obj)).add(abyte1);
        }

        byte abyte2[] = new byte[i1];
        i1 = l2 - k2;
        System.arraycopy(a, k2, abyte2, 0, i1);
        for (obj = ((List) (obj)).iterator(); ((Iterator) (obj)).hasNext();)
        {
            byte abyte3[] = (byte[])((Iterator) (obj)).next();
            System.arraycopy(abyte3, 0, abyte2, i1, abyte3.length);
            i1 = abyte3.length + i1;
        }

        return abyte2;
    }

    private void f(int i1)
    {
        if (i1 <= c - e && i1 >= 0)
        {
            e = e + i1;
            return;
        }
        if (i1 < 0)
        {
            throw du.b();
        }
        if (i + e + i1 > j)
        {
            f(j - i - e);
            throw du.a();
        }
        int j1 = c - e;
        e = c;
        c(1);
        while (i1 - j1 > c) 
        {
            j1 += c;
            e = c;
            c(1);
        }
        e = i1 - j1;
    }

    private long h()
    {
        long l1 = 0L;
        for (int i1 = 0; i1 < 64; i1 += 7)
        {
            if (e == c)
            {
                c(1);
            }
            byte abyte0[] = a;
            int j1 = e;
            e = j1 + 1;
            j1 = abyte0[j1];
            l1 |= (long)(j1 & 0x7f) << i1;
            if ((j1 & 0x80) == 0)
            {
                return l1;
            }
        }

        throw du.c();
    }

    private void i()
    {
        c = c + d;
        int i1 = i + c;
        if (i1 > j)
        {
            d = i1 - j;
            c = c - d;
            return;
        } else
        {
            d = 0;
            return;
        }
    }

    public final int a()
    {
        boolean flag = true;
        if (e != c || d(1))
        {
            flag = false;
        }
        if (flag)
        {
            g = 0;
            return 0;
        }
        g = e();
        if (ee.b(g) == 0)
        {
            throw du.d();
        } else
        {
            return g;
        }
    }

    public final dx a(dz dz1, dr dr)
    {
        int i1 = e();
        if (k >= l)
        {
            throw du.g();
        } else
        {
            i1 = b(i1);
            k = k + 1;
            dz1 = (dx)dz1.a(this, dr);
            a(0);
            k = k - 1;
            j = i1;
            i();
            return dz1;
        }
    }

    public final void a(int i1)
    {
        if (g != i1)
        {
            throw du.e();
        } else
        {
            return;
        }
    }

    public final boolean a(int i1, dq dq1)
    {
        int k1;
        int l1;
        switch (ee.a(i1))
        {
        default:
            throw du.f();

        case 0: // '\0'
            long l2 = f();
            dq1.e(i1);
            dq1.a(l2);
            return true;

        case 1: // '\001'
            long l3 = g();
            dq1.e(i1);
            dq1.b(l3);
            return true;

        case 2: // '\002'
            do do1 = d();
            dq1.e(i1);
            dq1.a(do1);
            return true;

        case 3: // '\003'
            dq1.e(i1);
            int j1;
            do
            {
                j1 = a();
            } while (j1 != 0 && a(j1, dq1));
            i1 = ee.a(ee.b(i1), 4);
            a(i1);
            dq1.e(i1);
            return true;

        case 4: // '\004'
            return false;

        case 5: // '\005'
            l1 = e;
            k1 = l1;
            break;
        }
        if (c - l1 < 4)
        {
            c(4);
            k1 = e;
        }
        byte abyte0[] = a;
        e = k1 + 4;
        l1 = abyte0[k1];
        byte byte0 = abyte0[k1 + 1];
        byte byte1 = abyte0[k1 + 2];
        k1 = (abyte0[k1 + 3] & 0xff) << 24 | (l1 & 0xff | (byte0 & 0xff) << 8 | (byte1 & 0xff) << 16);
        dq1.e(i1);
        dq1.c(k1 & 0xff);
        dq1.c(k1 >> 8 & 0xff);
        dq1.c(k1 >> 16 & 0xff);
        dq1.c(k1 >> 24 & 0xff);
        return true;
    }

    public final long b()
    {
        return f();
    }

    public final boolean c()
    {
        return f() != 0L;
    }

    public final do d()
    {
        int i1 = e();
        if (i1 <= c - e && i1 > 0)
        {
            Object obj;
            if (b && h)
            {
                obj = new dn(a, e, i1);
            } else
            {
                obj = com.tapjoy.internal.do.a(a, e, i1);
            }
            e = i1 + e;
            return ((do) (obj));
        }
        if (i1 == 0)
        {
            return do.a;
        } else
        {
            return new dw(e(i1));
        }
    }

    public final int e()
    {
        int i1 = e;
        if (c == i1) goto _L2; else goto _L1
_L1:
        byte abyte0[];
        int j1;
        int k1;
        abyte0 = a;
        j1 = i1 + 1;
        k1 = abyte0[i1];
        if (k1 >= 0)
        {
            e = j1;
            return k1;
        }
        if (c - j1 < 9) goto _L2; else goto _L3
_L3:
        i1 = j1 + 1;
        k1 ^= abyte0[j1] << 7;
        if ((long)k1 >= 0L) goto _L5; else goto _L4
_L4:
        j1 = (int)((long)k1 ^ -128L);
_L11:
        e = i1;
        return j1;
_L5:
        int l1;
        j1 = i1 + 1;
        k1 ^= abyte0[i1] << 14;
        if ((long)k1 >= 0L)
        {
            k1 = (int)((long)k1 ^ 16256L);
            i1 = j1;
            j1 = k1;
            continue; /* Loop/switch isn't completed */
        }
        i1 = j1 + 1;
        k1 ^= abyte0[j1] << 21;
        if ((long)k1 < 0L)
        {
            j1 = (int)((long)k1 ^ 0xffffffffffe03f80L);
            continue; /* Loop/switch isn't completed */
        }
        l1 = i1 + 1;
        j1 = abyte0[i1];
        k1 = (int)((long)(k1 ^ j1 << 28) ^ 0xfe03f80L);
        i1 = l1;
        if (j1 >= 0) goto _L7; else goto _L6
_L6:
        int i2;
        i2 = l1 + 1;
        j1 = k1;
        i1 = i2;
        if (abyte0[l1] >= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        l1 = i2 + 1;
        i1 = l1;
        if (abyte0[i2] >= 0) goto _L7; else goto _L8
_L8:
        i2 = l1 + 1;
        j1 = k1;
        i1 = i2;
        if (abyte0[l1] >= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
        l1 = i2 + 1;
        i1 = l1;
        if (abyte0[i2] >= 0) goto _L7; else goto _L9
_L9:
        i1 = l1 + 1;
        j1 = k1;
        if (abyte0[l1] >= 0)
        {
            continue; /* Loop/switch isn't completed */
        }
_L2:
        return (int)h();
_L7:
        j1 = k1;
        if (true) goto _L11; else goto _L10
_L10:
    }

    public final long f()
    {
        int i1 = e;
        if (c == i1) goto _L2; else goto _L1
_L1:
        byte abyte0[];
        int j1;
        int k1;
        abyte0 = a;
        j1 = i1 + 1;
        k1 = abyte0[i1];
        if (k1 >= 0)
        {
            e = j1;
            return (long)k1;
        }
        if (c - j1 < 9) goto _L2; else goto _L3
_L3:
        long l1;
        i1 = j1 + 1;
        l1 = k1 ^ abyte0[j1] << 7;
        if (l1 >= 0L) goto _L5; else goto _L4
_L4:
        l1 ^= -128L;
_L9:
        e = i1;
        return l1;
_L5:
        j1 = i1 + 1;
        l1 ^= abyte0[i1] << 14;
        if (l1 >= 0L)
        {
            l1 ^= 16256L;
            i1 = j1;
            continue; /* Loop/switch isn't completed */
        }
        i1 = j1 + 1;
        l1 ^= abyte0[j1] << 21;
        if (l1 < 0L)
        {
            l1 ^= 0xffffffffffe03f80L;
            continue; /* Loop/switch isn't completed */
        }
        j1 = i1 + 1;
        l1 ^= (long)abyte0[i1] << 28;
        if (l1 >= 0L)
        {
            l1 ^= 0xfe03f80L;
            i1 = j1;
            continue; /* Loop/switch isn't completed */
        }
        i1 = j1 + 1;
        l1 ^= (long)abyte0[j1] << 35;
        if (l1 < 0L)
        {
            l1 ^= 0xfffffff80fe03f80L;
            continue; /* Loop/switch isn't completed */
        }
        j1 = i1 + 1;
        l1 ^= (long)abyte0[i1] << 42;
        if (l1 >= 0L)
        {
            l1 ^= 0x3f80fe03f80L;
            i1 = j1;
            continue; /* Loop/switch isn't completed */
        }
        i1 = j1 + 1;
        l1 ^= (long)abyte0[j1] << 49;
        if (l1 < 0L)
        {
            l1 ^= 0xfffe03f80fe03f80L;
            continue; /* Loop/switch isn't completed */
        }
        j1 = i1 + 1;
        l1 = l1 ^ (long)abyte0[i1] << 56 ^ 0xfe03f80fe03f80L;
        if (l1 >= 0L) goto _L7; else goto _L6
_L6:
        i1 = j1 + 1;
        if ((long)abyte0[j1] >= 0L)
        {
            continue; /* Loop/switch isn't completed */
        }
_L2:
        return h();
_L7:
        i1 = j1;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public final long g()
    {
        int j1 = e;
        int i1 = j1;
        if (c - j1 < 8)
        {
            c(8);
            i1 = e;
        }
        byte abyte0[] = a;
        e = i1 + 8;
        long l1 = abyte0[i1];
        long l2 = abyte0[i1 + 1];
        long l3 = abyte0[i1 + 2];
        long l4 = abyte0[i1 + 3];
        long l5 = abyte0[i1 + 4];
        long l6 = abyte0[i1 + 5];
        long l7 = abyte0[i1 + 6];
        return ((long)abyte0[i1 + 7] & 255L) << 56 | (l1 & 255L | (l2 & 255L) << 8 | (l3 & 255L) << 16 | (l4 & 255L) << 24 | (l5 & 255L) << 32 | (l6 & 255L) << 40 | (l7 & 255L) << 48);
    }
}
