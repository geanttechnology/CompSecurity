// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.b.e;


public final class b
{

    private static char a[];
    private static byte b[];

    public static char[] a(byte abyte0[])
    {
        int l1 = abyte0.length;
        int i2 = (l1 * 4 + 2) / 3;
        char ac[] = new char[((l1 + 2) / 3) * 4];
        int j = 0;
        int i = 0;
        while (i < l1) 
        {
            int k = i + 1;
            int j2 = abyte0[i] & 0xff;
            char c;
            int i1;
            int k1;
            if (k < l1)
            {
                i = abyte0[k] & 0xff;
                int l = k + 1;
                k = i;
                i = l;
            } else
            {
                i1 = 0;
                i = k;
                k = i1;
            }
            if (i < l1)
            {
                i1 = i + 1;
                int j1 = abyte0[i] & 0xff;
                i = i1;
                i1 = j1;
            } else
            {
                i1 = 0;
            }
            k1 = j + 1;
            ac[j] = a[j2 >>> 2];
            j = k1 + 1;
            ac[k1] = a[(j2 & 3) << 4 | k >>> 4];
            if (j < i2)
            {
                c = a[(k & 0xf) << 2 | i1 >>> 6];
            } else
            {
                c = '=';
            }
            ac[j] = c;
            j++;
            if (j < i2)
            {
                c = a[i1 & 0x3f];
            } else
            {
                c = '=';
            }
            ac[j] = c;
            j++;
        }
        return ac;
    }

    static 
    {
        boolean flag = false;
        a = new char[64];
        char c = 'A';
        int i;
        for (i = 0; c <= 'Z'; i++)
        {
            a[i] = c;
            c++;
        }

        for (char c1 = 'a'; c1 <= 'z';)
        {
            a[i] = c1;
            c1++;
            i++;
        }

        for (char c2 = '0'; c2 <= '9';)
        {
            a[i] = c2;
            c2++;
            i++;
        }

        a[i] = '+';
        a[i + 1] = '/';
        b = new byte[128];
        i = 0;
        int j;
        do
        {
            j = ((flag) ? 1 : 0);
            if (i >= b.length)
            {
                break;
            }
            b[i] = -1;
            i++;
        } while (true);
        for (; j < 64; j++)
        {
            b[a[j]] = (byte)j;
        }

    }
}
