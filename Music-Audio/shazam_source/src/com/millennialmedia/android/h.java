// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia.android;

import java.util.Arrays;

final class h
{

    private static final char a[];
    private static final int b[];

    public static final String a(byte abyte0[])
    {
        return new String(b(abyte0));
    }

    public static final byte[] a(String s)
    {
        int i;
        if (s != null)
        {
            i = s.length();
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            return new byte[0];
        }
        int i1 = 0;
        int k;
        int j1;
        for (k = 0; i1 < i; k = j1)
        {
            j1 = k;
            if (b[s.charAt(i1)] < 0)
            {
                j1 = k + 1;
            }
            i1++;
        }

        if ((i - k) % 4 != 0)
        {
            return null;
        }
        i1 = i;
        int k1 = 0;
        do
        {
            if (i1 <= 1)
            {
                break;
            }
            int ai[] = b;
            int i2 = i1 - 1;
            if (ai[s.charAt(i2)] > 0)
            {
                break;
            }
            i1 = i2;
            if (s.charAt(i2) == '=')
            {
                k1++;
                i1 = i2;
            }
        } while (true);
        int k2 = ((i - k) * 6 >> 3) - k1;
        byte abyte0[] = new byte[k2];
        i1 = 0;
        int l;
        for (int j = 0; i1 < k2; j = l)
        {
            int l1 = 0;
            int j2 = 0;
            l = j;
            j = j2;
            while (j < 4) 
            {
                j2 = b[s.charAt(l)];
                if (j2 >= 0)
                {
                    l1 |= j2 << 18 - j * 6;
                } else
                {
                    j--;
                }
                j++;
                l++;
            }
            j2 = i1 + 1;
            abyte0[i1] = (byte)(l1 >> 16);
            j = j2;
            if (j2 < k2)
            {
                j = j2 + 1;
                abyte0[j2] = (byte)(l1 >> 8);
                if (j < k2)
                {
                    i1 = j + 1;
                    abyte0[j] = (byte)l1;
                    j = i1;
                }
            }
            i1 = j;
        }

        return abyte0;
    }

    private static char[] b(byte abyte0[])
    {
        boolean flag = false;
        int i;
        if (abyte0 != null)
        {
            i = abyte0.length;
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            return new char[0];
        }
        int k1 = (i / 3) * 3;
        int j1 = ((i - 1) / 3 + 1 << 2) + 0;
        char ac[] = new char[j1];
        int j = 0;
        for (int l = 0; l < k1;)
        {
            int j2 = l + 1;
            int l1 = abyte0[l];
            int i2 = j2 + 1;
            j2 = abyte0[j2];
            l = i2 + 1;
            l1 = (j2 & 0xff) << 8 | (l1 & 0xff) << 16 | abyte0[i2] & 0xff;
            i2 = j + 1;
            ac[j] = a[l1 >>> 18 & 0x3f];
            j = i2 + 1;
            ac[i2] = a[l1 >>> 12 & 0x3f];
            i2 = j + 1;
            ac[j] = a[l1 >>> 6 & 0x3f];
            j = i2 + 1;
            ac[i2] = a[l1 & 0x3f];
        }

        int i1 = i - k1;
        if (i1 > 0)
        {
            k1 = abyte0[k1];
            int k = ((flag) ? 1 : 0);
            if (i1 == 2)
            {
                k = (abyte0[i - 1] & 0xff) << 2;
            }
            i = k | (k1 & 0xff) << 10;
            ac[j1 - 4] = a[i >> 12];
            ac[j1 - 3] = a[i >>> 6 & 0x3f];
            char c;
            if (i1 == 2)
            {
                c = a[i & 0x3f];
            } else
            {
                c = '=';
            }
            ac[j1 - 2] = c;
            ac[j1 - 1] = '=';
        }
        return ac;
    }

    static 
    {
        a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();
        int ai[] = new int[256];
        b = ai;
        Arrays.fill(ai, -1);
        int j = a.length;
        for (int i = 0; i < j; i++)
        {
            b[a[i]] = i;
        }

        b[61] = 0;
    }
}
