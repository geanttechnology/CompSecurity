// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.miginfocom.codec;

import java.util.Arrays;

public class Base64
{

    private static final char CA[];
    private static final int IA[];

    public Base64()
    {
    }

    public static final byte[] decodeFast(String s)
    {
        byte abyte0[];
        int i;
        int j;
        int k;
        int l;
        int i1;
        int k2;
        l = s.length();
        if (l == 0)
        {
            return new byte[0];
        }
        i = 0;
        j = l - 1;
        do
        {
            i1 = j;
            if (i >= j)
            {
                break;
            }
            i1 = j;
            if (IA[s.charAt(i) & 0xff] >= 0)
            {
                break;
            }
            i++;
        } while (true);
        for (; i1 > 0 && IA[s.charAt(i1) & 0xff] < 0; i1--) { }
        int j1;
        int j2;
        if (s.charAt(i1) == '=')
        {
            if (s.charAt(i1 - 1) == '=')
            {
                k = 2;
            } else
            {
                k = 1;
            }
        } else
        {
            k = 0;
        }
        j2 = (i1 - i) + 1;
        if (l > 76)
        {
            int ai[];
            int l2;
            int i3;
            int j3;
            int k3;
            if (s.charAt(76) == '\r')
            {
                j = j2 / 78;
            } else
            {
                j = 0;
            }
            j1 = j << 1;
        } else
        {
            j1 = 0;
        }
        k2 = ((j2 - j1) * 6 >> 3) - k;
        abyte0 = new byte[k2];
        l = 0;
        l2 = k2 / 3;
        j2 = 0;
        j = i;
        i = j2;
        if (i >= l2 * 3)
        {
            break; /* Loop/switch isn't completed */
        }
        ai = IA;
        i3 = j + 1;
        j2 = ai[s.charAt(j)];
        ai = IA;
        j = i3 + 1;
        i3 = ai[s.charAt(i3)];
        ai = IA;
        j3 = j + 1;
        k3 = ai[s.charAt(j)];
        ai = IA;
        j = j3 + 1;
        i3 = j2 << 18 | i3 << 12 | k3 << 6 | ai[s.charAt(j3)];
        j3 = i + 1;
        abyte0[i] = (byte)(i3 >> 16);
        j2 = j3 + 1;
        abyte0[j3] = (byte)(i3 >> 8);
        abyte0[j2] = (byte)i3;
        i = l;
        if (j1 <= 0)
        {
            break MISSING_BLOCK_LABEL_519;
        }
        l++;
        i = l;
        if (l != 19)
        {
            break MISSING_BLOCK_LABEL_519;
        }
        i = j + 2;
        l = 0;
_L4:
        j2++;
        j = i;
        i = j2;
        if (true) goto _L2; else goto _L1
_L2:
        break MISSING_BLOCK_LABEL_195;
_L1:
        int k1 = i;
        k1 = j;
        if (i < k2)
        {
            l = 0;
            int l1 = 0;
            for (; j <= i1 - k; j++)
            {
                l |= IA[s.charAt(j)] << 18 - l1 * 6;
                l1++;
            }

            k = 16;
            do
            {
                int i2 = i;
                i2 = j;
                if (i >= k2)
                {
                    break;
                }
                abyte0[i] = (byte)(l >> k);
                k -= 8;
                i++;
            } while (true);
        }
        return abyte0;
        l = i;
        i = j;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static final char[] encodeToChar(byte abyte0[], boolean flag)
    {
        char ac[];
        int k;
        if (abyte0 != null)
        {
            k = abyte0.length;
        } else
        {
            k = 0;
        }
        if (k != 0) goto _L2; else goto _L1
_L1:
        ac = new char[0];
_L5:
        return ac;
_L2:
        char ac1[];
        int i;
        int j;
        int l;
        int i1;
        int j1;
        j1 = (k / 3) * 3;
        j = (k - 1) / 3 + 1 << 2;
        int k1;
        int l1;
        int i2;
        if (flag)
        {
            i = (j - 1) / 76 << 1;
        } else
        {
            i = 0;
        }
        i1 = j + i;
        ac1 = new char[i1];
        i = 0;
        j = 0;
        l = 0;
        if (l >= j1)
        {
            break; /* Loop/switch isn't completed */
        }
        l1 = l + 1;
        l = abyte0[l];
        k1 = l1 + 1;
        l1 = (l & 0xff) << 16 | (abyte0[l1] & 0xff) << 8 | abyte0[k1] & 0xff;
        l = j + 1;
        ac1[j] = CA[l1 >>> 18 & 0x3f];
        j = l + 1;
        ac1[l] = CA[l1 >>> 12 & 0x3f];
        i2 = j + 1;
        ac1[j] = CA[l1 >>> 6 & 0x3f];
        l = i2 + 1;
        ac1[i2] = CA[l1 & 0x3f];
        j = i;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_448;
        }
        i++;
        j = i;
        if (i != 19)
        {
            break MISSING_BLOCK_LABEL_448;
        }
        j = i;
        if (l >= i1 - 2)
        {
            break MISSING_BLOCK_LABEL_448;
        }
        j = l + 1;
        ac1[l] = '\r';
        ac1[j] = '\n';
        i = 0;
        j++;
_L6:
        l = k1 + 1;
        if (true) goto _L4; else goto _L3
_L4:
        break MISSING_BLOCK_LABEL_82;
_L3:
        j = k - j1;
        ac = ac1;
        if (j > 0)
        {
            l = abyte0[j1];
            char c;
            if (j == 2)
            {
                i = (abyte0[k - 1] & 0xff) << 2;
            } else
            {
                i = 0;
            }
            i = (l & 0xff) << 10 | i;
            ac1[i1 - 4] = CA[i >> 12];
            ac1[i1 - 3] = CA[i >>> 6 & 0x3f];
            if (j == 2)
            {
                c = CA[i & 0x3f];
            } else
            {
                c = '=';
            }
            ac1[i1 - 2] = c;
            ac1[i1 - 1] = '=';
            return ac1;
        }
          goto _L5
        i = j;
        j = l;
          goto _L6
    }

    public static final String encodeToString(byte abyte0[], boolean flag)
    {
        return new String(encodeToChar(abyte0, flag));
    }

    static 
    {
        CA = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        IA = new int[256];
        Arrays.fill(IA, -1);
        int i = 0;
        for (int j = CA.length; i < j; i++)
        {
            IA[CA[i]] = i;
        }

        IA[61] = 0;
    }
}
