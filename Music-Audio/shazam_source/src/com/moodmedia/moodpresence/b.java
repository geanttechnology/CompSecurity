// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.moodmedia.moodpresence;

import java.util.Arrays;

class b
{
    class a
    {

        long a;
        int b;
        final b c;

        long a()
        {
            return a;
        }

        void a(long l)
        {
            a = l;
        }

        int b()
        {
            return b;
        }

        long c()
        {
            if (a == -1L || a == 0L)
            {
                return -1L;
            } else
            {
                return a >>> 63 - c.b;
            }
        }

        a(long l, int k)
        {
            c = b.this;
            super();
            a = l;
            b = k;
        }
    }


    private static final int i[] = {
        1, 2, 4, 8, 16, 32, 3, 6, 12, 24, 
        48, 35, 5, 10, 20, 40, 19, 38, 15, 30, 
        60, 59, 53, 41, 17, 34, 7, 14, 28, 56, 
        51, 37, 9, 18, 36, 11, 22, 44, 27, 54, 
        47, 29, 58, 55, 45, 25, 50, 39, 13, 26, 
        52, 43, 21, 42, 23, 46, 31, 62, 63, 61, 
        57, 49, 33
    };
    private static final int j[];
    int a;
    int b;
    private int c;
    private int d[];
    private int e[];
    private int f[];
    private int g[];
    private int h[];

    b(int k)
    {
        a = 0;
        b = 63;
        a = k;
        if (k != 1) goto _L2; else goto _L1
_L1:
        b = 57;
_L4:
        c = k * 2;
        d = new int[c];
        e = new int[c];
        f = new int[c];
        g = new int[c];
        h = new int[c];
        return;
_L2:
        if (k == 2)
        {
            b = 51;
            continue; /* Loop/switch isn't completed */
        }
        if (k == 3)
        {
            b = 45;
            continue; /* Loop/switch isn't completed */
        }
        if (k == 4)
        {
            b = 39;
            continue; /* Loop/switch isn't completed */
        }
        if (k == 5)
        {
            b = 36;
            continue; /* Loop/switch isn't completed */
        }
        if (k != 6)
        {
            break; /* Loop/switch isn't completed */
        }
        b = 30;
        if (true) goto _L4; else goto _L3
_L3:
        if (k == 0) goto _L4; else goto _L5
_L5:
        throw new IllegalArgumentException("'t' must be between 0 and 6 inclusive.");
    }

    private static int a(int k)
    {
        k = b(k, 63);
        return i[k];
    }

    private static int a(int k, int l)
    {
        if (k == 0 || l == 0)
        {
            return 0;
        } else
        {
            return a(j[k] + j[l]);
        }
    }

    private static int a(long l, long l1)
    {
        if (l1 == 0L)
        {
            throw new IllegalArgumentException("Argument 'divisor' is 0");
        }
        if (l == 0L)
        {
            return 0;
        } else
        {
            return a(j[(int)l] - j[(int)l1]);
        }
    }

    private static int b(int k, int l)
    {
        if (k < 0)
        {
            return k % l + l;
        } else
        {
            return k % l;
        }
    }

    a a(long l)
    {
        this;
        JVM INSTR monitorenter ;
        if (a != 0) goto _L2; else goto _L1
_L1:
        Object obj = new a(l, 0);
_L6:
        this;
        JVM INSTR monitorexit ;
        return ((a) (obj));
_L2:
        b(l);
        int i1 = 1;
        int j1;
        obj = d;
        j1 = obj.length;
        int k = 0;
          goto _L3
_L9:
        if (k == 0) goto _L5; else goto _L4
_L4:
        obj = new a(l, 0);
          goto _L6
        obj;
        throw obj;
_L43:
        if (obj[k] == 0) goto _L8; else goto _L7
_L7:
        k = 0;
          goto _L9
_L5:
        i1 = 0;
        k = -1;
        Arrays.fill(e, 0);
        e[0] = 1;
        Arrays.fill(f, 0);
        f[1] = 1;
        j1 = 0;
_L24:
        if (j1 < c) goto _L11; else goto _L10
_L10:
        if (i1 <= a) goto _L13; else goto _L12
_L12:
        obj = new a(-1L, i1);
          goto _L6
_L25:
        int l1;
        if (l1 < c) goto _L15; else goto _L14
_L14:
        if (i1 >= j1 - k) goto _L17; else goto _L16
_L16:
        l1 = j1 - k;
        i1 = j1 - i1;
        k = 0;
_L26:
        if (k < c) goto _L19; else goto _L18
_L18:
        k = i1;
        i1 = l1;
          goto _L17
_L27:
        int k1;
        if (k1 < c) goto _L21; else goto _L20
_L20:
        k1 = c - 1;
_L28:
        if (k1 > 0) goto _L23; else goto _L22
_L22:
        f[0] = 0;
        j1++;
          goto _L24
_L45:
        int i2 = a(e[l1], d[j1 - l1]);
        l1++;
        k1 = i2 ^ k1;
        continue; /* Loop/switch isn't completed */
_L15:
        int j2 = a(k1, f[l1]);
        g[l1] = j2 ^ e[l1];
        l1++;
          goto _L25
_L19:
        f[k] = a(e[k], k1);
        k++;
          goto _L26
_L21:
        e[k1] = g[k1];
        k1++;
          goto _L27
_L23:
        f[k1] = f[k1 - 1];
        k1--;
          goto _L28
_L35:
        if (k < c) goto _L30; else goto _L29
_L29:
        long l2;
        l2 = 0L;
        j1 = 0;
        k = 63;
_L48:
        if (k > 0) goto _L32; else goto _L31
_L31:
        if (j1 != i1) goto _L34; else goto _L33
_L33:
        obj = new a(l2 ^ l, i1);
          goto _L6
_L30:
        h[k] = j[e[k]];
        k++;
          goto _L35
_L47:
        if (k1 < c) goto _L37; else goto _L36
_L36:
        long l3;
        if (l3 != 0L) goto _L39; else goto _L38
_L38:
        long l4;
        if (k == 63)
        {
            k1 = 0;
        } else
        {
            k1 = k;
        }
        l2 = (1L << k1) + l2;
        l1 = j1 + 1;
        k1 = l1;
        if (j1 <= a)
        {
            break MISSING_BLOCK_LABEL_720;
        }
        obj = new a(-1L, l1);
          goto _L6
_L37:
        l4 = l3;
        if (h[k1] == -1) goto _L41; else goto _L40
_L40:
        l4 = l3 ^ (long)a(h[k1]);
        obj = h;
        obj[k1] = obj[k1] + k1;
          goto _L41
_L34:
        obj = new a(-1L, j1);
          goto _L6
_L3:
        if (k < j1) goto _L43; else goto _L42
_L42:
        k = i1;
          goto _L9
_L8:
        k++;
          goto _L3
_L11:
        l1 = 0;
        k1 = 0;
        if (l1 <= i1) goto _L45; else goto _L44
_L44:
        if (k1 == 0) goto _L20; else goto _L46
_L46:
        l1 = 0;
          goto _L25
_L17:
        k1 = 0;
          goto _L27
_L13:
        k = 0;
          goto _L35
_L32:
        l3 = 0L;
        k1 = 0;
          goto _L47
_L41:
        k1++;
        l3 = l4;
          goto _L47
_L39:
        k1 = j1;
        k--;
        j1 = k1;
          goto _L48
    }

    void b(long l)
    {
        Arrays.fill(d, 0);
        if (l != 0L) goto _L2; else goto _L1
_L1:
        return;
_L2:
        int k = 0;
_L4:
        if (k >= a * 2) goto _L1; else goto _L3
_L3:
        int i1 = 0;
_L5:
label0:
        {
            if (i1 < 63)
            {
                break label0;
            }
            k++;
        }
          goto _L4
          goto _L1
        if ((l >> i1 & 1L) != 1L)
        {
            int j1 = a((k + 1) * i1);
            int ai[] = d;
            ai[k] = j1 ^ ai[k];
        }
        i1++;
          goto _L5
    }

    static 
    {
        int ai[] = new int[64];
        ai[0] = -1;
        ai[2] = 1;
        ai[3] = 6;
        ai[4] = 2;
        ai[5] = 12;
        ai[6] = 7;
        ai[7] = 26;
        ai[8] = 3;
        ai[9] = 32;
        ai[10] = 13;
        ai[11] = 35;
        ai[12] = 8;
        ai[13] = 48;
        ai[14] = 27;
        ai[15] = 18;
        ai[16] = 4;
        ai[17] = 24;
        ai[18] = 33;
        ai[19] = 16;
        ai[20] = 14;
        ai[21] = 52;
        ai[22] = 36;
        ai[23] = 54;
        ai[24] = 9;
        ai[25] = 45;
        ai[26] = 49;
        ai[27] = 38;
        ai[28] = 28;
        ai[29] = 41;
        ai[30] = 19;
        ai[31] = 56;
        ai[32] = 5;
        ai[33] = 62;
        ai[34] = 25;
        ai[35] = 11;
        ai[36] = 34;
        ai[37] = 31;
        ai[38] = 17;
        ai[39] = 47;
        ai[40] = 15;
        ai[41] = 23;
        ai[42] = 53;
        ai[43] = 51;
        ai[44] = 37;
        ai[45] = 44;
        ai[46] = 55;
        ai[47] = 40;
        ai[48] = 10;
        ai[49] = 61;
        ai[50] = 46;
        ai[51] = 30;
        ai[52] = 50;
        ai[53] = 22;
        ai[54] = 39;
        ai[55] = 43;
        ai[56] = 29;
        ai[57] = 60;
        ai[58] = 42;
        ai[59] = 21;
        ai[60] = 20;
        ai[61] = 59;
        ai[62] = 57;
        ai[63] = 58;
        j = ai;
    }
}
