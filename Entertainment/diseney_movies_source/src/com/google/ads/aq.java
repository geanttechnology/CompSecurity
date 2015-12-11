// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.ads;


// Referenced classes of package com.google.ads:
//            ap

public final class aq
{

    private static final char a[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
    private static final char b[] = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_".toCharArray();
    private static final byte c[] = {
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
        -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, 62, -9, -9, -9, 63, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -9, -9, 
        -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -9, -9, -9, -9, -9, -9, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -9, -9, -9, -9, -9
    };
    private static final byte d[] = {
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -5, 
        -5, -9, -9, -5, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -5, -9, -9, -9, -9, -9, -9, -9, 
        -9, -9, -9, -9, -9, 62, -9, -9, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -9, -9, 
        -9, -1, -9, -9, -9, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -9, -9, -9, -9, 63, -9, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -9, -9, -9, -9, -9
    };

    private static int a(char ac[], int i, byte abyte0[], int j, byte abyte1[])
    {
        if (ac[i + 2] == '=')
        {
            abyte0[j] = (byte)(((abyte1[ac[i]] << 24) >>> 6 | (abyte1[ac[i + 1]] << 24) >>> 12) >>> 16);
            return 1;
        }
        if (ac[i + 3] == '=')
        {
            i = (abyte1[ac[i]] << 24) >>> 6 | (abyte1[ac[i + 1]] << 24) >>> 12 | (abyte1[ac[i + 2]] << 24) >>> 18;
            abyte0[j] = (byte)(i >>> 16);
            abyte0[j + 1] = (byte)(i >>> 8);
            return 2;
        } else
        {
            i = (abyte1[ac[i]] << 24) >>> 6 | (abyte1[ac[i + 1]] << 24) >>> 12 | (abyte1[ac[i + 2]] << 24) >>> 18 | (abyte1[ac[i + 3]] << 24) >>> 24;
            abyte0[j] = (byte)(i >> 16);
            abyte0[j + 1] = (byte)(i >> 8);
            abyte0[j + 2] = (byte)i;
            return 3;
        }
    }

    public static String a(byte abyte0[], int i, int j, char ac[], boolean flag)
    {
        abyte0 = a(abyte0, i, j, ac, 0x7fffffff);
        i = abyte0.length;
        do
        {
            if (flag || i <= 0 || abyte0[i - 1] != 61)
            {
                return new String(abyte0, 0, i);
            }
            i--;
        } while (true);
    }

    public static String a(byte abyte0[], boolean flag)
    {
        return a(abyte0, 0, abyte0.length, b, flag);
    }

    public static byte[] a(String s)
        throws ap
    {
        s = s.toCharArray();
        return a(((char []) (s)), 0, s.length);
    }

    public static byte[] a(char ac[], int i, int j)
        throws ap
    {
        return a(ac, i, j, c);
    }

    public static byte[] a(char ac[], int i, int j, byte abyte0[])
        throws ap
    {
        byte abyte1[];
        char ac1[];
        int k;
        int l;
        int i1;
        boolean flag;
        abyte1 = new byte[(j * 3) / 4 + 2];
        k = 0;
        ac1 = new char[4];
        flag = false;
        i1 = 0;
        l = 0;
_L2:
        char c1;
        if (i1 >= j)
        {
            break MISSING_BLOCK_LABEL_295;
        }
        char c2 = ac[i1 + i];
        c1 = (char)(c2 & 0x7f);
        byte byte0 = abyte0[c1];
        if (c1 == c2 && byte0 < -5)
        {
            throw new ap((new StringBuilder()).append("Bad Base64 input character at ").append(i1).append(": ").append(ac[i1 + i]).append("(decimal)").toString());
        }
        if (byte0 >= -1)
        {
            if (c1 != '=')
            {
                break MISSING_BLOCK_LABEL_221;
            }
            if (!flag)
            {
                break; /* Loop/switch isn't completed */
            }
        }
_L4:
        i1++;
        if (true) goto _L2; else goto _L1
_L1:
        char c3;
        if (i1 < 2)
        {
            throw new ap((new StringBuilder()).append("Invalid padding char found in position ").append(i1).toString());
        }
        flag = true;
        c3 = (char)(ac[(j - 1) + i] & 0x7f);
        if (c3 == '=' || c3 == '\n') goto _L4; else goto _L3
_L3:
        throw new ap("encoded value has invalid trailing char");
        if (flag)
        {
            throw new ap((new StringBuilder()).append("Data found after trailing padding char at index ").append(i1).toString());
        }
        int j1 = l + 1;
        ac1[l] = c1;
        if (j1 == 4)
        {
            k += a(ac1, 0, abyte1, k, abyte0);
            l = 0;
        } else
        {
            l = j1;
        }
          goto _L4
        i = k;
        if (l != 0)
        {
            if (l == 1)
            {
                throw new ap((new StringBuilder()).append("single trailing character at offset ").append(j - 1).toString());
            }
            ac1[l] = '=';
            i = k + a(ac1, 0, abyte1, k, abyte0);
        }
        ac = new byte[i];
        System.arraycopy(abyte1, 0, ac, 0, i);
        return ac;
    }

    public static char[] a(byte abyte0[], int i, int j, char ac[], int k)
    {
        int l = ((j + 2) / 3) * 4;
        char ac1[] = new char[l + l / k];
        int i1 = 0;
        l = 0;
        int j1;
        for (j1 = 0; j1 < j - 2;)
        {
            int k1 = (abyte0[j1 + i] << 24) >>> 8 | (abyte0[j1 + 1 + i] << 24) >>> 16 | (abyte0[j1 + 2 + i] << 24) >>> 24;
            ac1[l] = ac[k1 >>> 18];
            ac1[l + 1] = ac[k1 >>> 12 & 0x3f];
            ac1[l + 2] = ac[k1 >>> 6 & 0x3f];
            ac1[l + 3] = ac[k1 & 0x3f];
            int l1 = i1 + 4;
            i1 = l1;
            k1 = l;
            if (l1 == k)
            {
                ac1[l + 4] = '\n';
                k1 = l + 1;
                i1 = 0;
            }
            j1 += 3;
            l = k1 + 4;
        }

        if (j1 < j)
        {
            a(abyte0, j1 + i, j - j1, ac1, l, ac);
            i = l;
            if (i1 + 4 == k)
            {
                ac1[l + 4] = '\n';
                i = l + 1;
            }
        }
        return ac1;
    }

    private static char[] a(byte abyte0[], int i, int j, char ac[], int k, char ac1[])
    {
        int j1 = 0;
        int l;
        int i1;
        if (j > 0)
        {
            l = (abyte0[i] << 24) >>> 8;
        } else
        {
            l = 0;
        }
        if (j > 1)
        {
            i1 = (abyte0[i + 1] << 24) >>> 16;
        } else
        {
            i1 = 0;
        }
        if (j > 2)
        {
            j1 = (abyte0[i + 2] << 24) >>> 24;
        }
        i = j1 | (i1 | l);
        switch (j)
        {
        default:
            return ac;

        case 3: // '\003'
            ac[k] = ac1[i >>> 18];
            ac[k + 1] = ac1[i >>> 12 & 0x3f];
            ac[k + 2] = ac1[i >>> 6 & 0x3f];
            ac[k + 3] = ac1[i & 0x3f];
            return ac;

        case 2: // '\002'
            ac[k] = ac1[i >>> 18];
            ac[k + 1] = ac1[i >>> 12 & 0x3f];
            ac[k + 2] = ac1[i >>> 6 & 0x3f];
            ac[k + 3] = '=';
            return ac;

        case 1: // '\001'
            ac[k] = ac1[i >>> 18];
            ac[k + 1] = ac1[i >>> 12 & 0x3f];
            ac[k + 2] = '=';
            ac[k + 3] = '=';
            return ac;
        }
    }

}
