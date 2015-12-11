// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package b.a.a.b;

import b.a.a.a;

// Referenced classes of package b.a.a.b:
//            d

abstract class i extends d
{

    private static final int l[] = {
        31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 
        30, 31
    };
    private static final int m[] = {
        31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 
        30, 31
    };
    private static final long n[];
    private static final long o[];

    i(a a1, int j)
    {
        super(a1, j);
    }

    final int a(long l1, int j)
    {
        int k = (int)(l1 - b(j) >> 10);
        if (!c(j)) goto _L2; else goto _L1
_L1:
        if (k >= 0xea515a) goto _L4; else goto _L3
_L3:
        if (k >= 0x7528ad) goto _L6; else goto _L5
_L5:
        if (k >= 0x27e949) goto _L8; else goto _L7
_L7:
        return 1;
_L8:
        return k >= 0x4d3f64 ? 3 : 2;
_L6:
        if (k < 0x9bc85f)
        {
            return 4;
        }
        return k >= 0xc3b1a8 ? 6 : 5;
_L4:
        if (k < 0x160c39e)
        {
            if (k < 0x1123aa3)
            {
                return 7;
            }
            return k >= 0x13a23ec ? 9 : 8;
        }
        if (k < 0x188ace7)
        {
            return 10;
        }
        return k >= 0x1af4c99 ? 12 : 11;
_L2:
        if (k < 0xe907c3)
        {
            if (k < 0x73df16)
            {
                if (k >= 0x27e949)
                {
                    return k >= 0x4bf5cd ? 3 : 2;
                }
            } else
            {
                if (k < 0x9a7ec8)
                {
                    return 4;
                }
                return k >= 0xc26811 ? 6 : 5;
            }
        } else
        {
            if (k < 0x15f7a07)
            {
                if (k < 0x110f10c)
                {
                    return 7;
                }
                return k >= 0x138da55 ? 9 : 8;
            }
            if (k < 0x1876350)
            {
                return 10;
            }
            return k >= 0x1ae0302 ? 12 : 11;
        }
        if (true) goto _L7; else goto _L9
_L9:
    }

    final long a(long l1, long l2)
    {
        int j;
        int k;
        long l3;
        j = a(l1);
        k = a(l2);
        l3 = l1 - b(j);
        l1 = l2 - b(k);
        if (l1 < 0x12fd73400L) goto _L2; else goto _L1
_L1:
        if (!c(k)) goto _L4; else goto _L3
_L3:
        if (c(j)) goto _L2; else goto _L5
_L5:
        l2 = l3;
        l1 -= 0x5265c00L;
_L7:
        k = j - k;
        j = k;
        if (l2 < l1)
        {
            j = k - 1;
        }
        return (long)j;
_L4:
        if (l3 >= 0x12fd73400L && c(j))
        {
            l2 = l3 - 0x5265c00L;
            continue; /* Loop/switch isn't completed */
        }
_L2:
        l2 = l3;
        if (true) goto _L7; else goto _L6
_L6:
    }

    final int b(int j, int k)
    {
        if (c(j))
        {
            return m[k - 1];
        } else
        {
            return l[k - 1];
        }
    }

    final int c(long l1, int j)
    {
        int k = 28;
        if (j > 28 || j <= 0)
        {
            k = f(l1);
        }
        return k;
    }

    final long c(int j, int k)
    {
        if (c(j))
        {
            return o[k - 1];
        } else
        {
            return n[k - 1];
        }
    }

    final long d(long l1, int j)
    {
        int k;
        int i1;
        int j1;
        int k1;
        k1 = a(l1);
        i1 = b(l1, k1);
        j1 = e(l1);
        k = i1;
        if (i1 <= 59) goto _L2; else goto _L1
_L1:
        if (!c(k1)) goto _L4; else goto _L3
_L3:
        k = i1;
        if (!c(j))
        {
            k = i1 - 1;
        }
_L2:
        return a(j, 1, k) + (long)j1;
_L4:
        k = i1;
        if (c(j))
        {
            k = i1 + 1;
        }
        if (true) goto _L2; else goto _L5
_L5:
    }

    static 
    {
        long l1 = 0L;
        n = new long[12];
        o = new long[12];
        int j = 0;
        long l2 = 0L;
        for (; j < 11; j++)
        {
            l2 += (long)l[j] * 0x5265c00L;
            n[j + 1] = l2;
            l1 += (long)m[j] * 0x5265c00L;
            o[j + 1] = l1;
        }

    }
}
