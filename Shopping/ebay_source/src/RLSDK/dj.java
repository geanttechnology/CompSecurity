// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package RLSDK;


// Referenced classes of package RLSDK:
//            di

final class dj
{

    private static final int a[][];
    private static final int b[] = {
        0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 
        2, 3, 2, 3, 3, 4
    };
    private final di c;
    private final byte d;

    private dj(int i)
    {
        c = di.a(i >> 3 & 3);
        d = (byte)(i & 7);
    }

    static int a(int i, int j)
    {
        i ^= j;
        j = b[i & 0xf];
        int k = b[i >>> 4 & 0xf];
        int l = b[i >>> 8 & 0xf];
        int i1 = b[i >>> 12 & 0xf];
        int j1 = b[i >>> 16 & 0xf];
        int k1 = b[i >>> 20 & 0xf];
        int l1 = b[i >>> 24 & 0xf];
        return b[i >>> 28 & 0xf] + (j + k + l + i1 + j1 + k1 + l1);
    }

    static dj b(int i, int j)
    {
        dj dj1 = c(i, j);
        if (dj1 != null)
        {
            return dj1;
        } else
        {
            return c(i ^ 0x5412, j ^ 0x5412);
        }
    }

    private static dj c(int i, int j)
    {
        int k = 0;
        int l = 0x7fffffff;
        for (int i1 = 0; i1 < a.length; i1++)
        {
            int ai[] = a[i1];
            int k1 = ai[0];
            if (k1 == i || k1 == j)
            {
                return new dj(ai[1]);
            }
            int j1 = a(i, k1);
            if (j1 < l)
            {
                k = ai[1];
                l = j1;
            }
            if (i == j)
            {
                continue;
            }
            j1 = a(j, k1);
            if (j1 < l)
            {
                k = ai[1];
                l = j1;
            }
        }

        if (l <= 3)
        {
            return new dj(k);
        } else
        {
            return null;
        }
    }

    final di a()
    {
        return c;
    }

    final byte b()
    {
        return d;
    }

    public final boolean equals(Object obj)
    {
        if (obj instanceof dj)
        {
            if (c == ((dj) (obj = (dj)obj)).c && d == ((dj) (obj)).d)
            {
                return true;
            }
        }
        return false;
    }

    public final int hashCode()
    {
        return c.a() << 3 | d;
    }

    static 
    {
        int ai[] = {
            17913, 4
        };
        int ai1[] = {
            19104, 7
        };
        int ai2[] = {
            30660, 8
        };
        int ai3[] = {
            29427, 9
        };
        int ai4[] = {
            26998, 15
        };
        int ai5[] = {
            5054, 17
        };
        int ai6[] = {
            6608, 19
        };
        int ai7[] = {
            2107, 23
        };
        int ai8[] = {
            13663, 24
        };
        int ai9[] = {
            12392, 25
        };
        int ai10[] = {
            16177, 26
        };
        int ai11[] = {
            14854, 27
        };
        int ai12[] = {
            8579, 29
        };
        a = (new int[][] {
            new int[] {
                21522, 0
            }, new int[] {
                20773, 1
            }, new int[] {
                24188, 2
            }, new int[] {
                23371, 3
            }, ai, new int[] {
                16590, 5
            }, new int[] {
                20375, 6
            }, ai1, ai2, ai3, new int[] {
                32170, 10
            }, new int[] {
                30877, 11
            }, new int[] {
                26159, 12
            }, new int[] {
                25368, 13
            }, new int[] {
                27713, 14
            }, ai4, new int[] {
                5769, 16
            }, ai5, new int[] {
                7399, 18
            }, ai6, new int[] {
                1890, 20
            }, new int[] {
                597, 21
            }, new int[] {
                3340, 22
            }, ai7, ai8, ai9, ai10, ai11, new int[] {
                9396, 28
            }, ai12, new int[] {
                11994, 30
            }, new int[] {
                11245, 31
            }
        });
    }
}
