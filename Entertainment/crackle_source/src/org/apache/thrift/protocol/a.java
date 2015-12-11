// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.thrift.protocol;


final class a
{

    private static final byte a[] = {
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 
        54, 55, 56, 57, 58, 59, 60, 61, -1, -1, 
        -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 
        5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 
        15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 
        25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 
        29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 
        39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 
        49, 50, 51, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 
        -1, -1, -1, -1, -1, -1
    };

    a()
    {
    }

    static final void a(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        abyte1[0] = (byte)"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(abyte0[i] >> 2 & 0x3f);
        if (j == 3)
        {
            abyte1[1] = (byte)"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((abyte0[i] << 4) + (abyte0[i + 1] >> 4) & 0x3f);
            abyte1[2] = (byte)"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((abyte0[i + 1] << 2) + (abyte0[i + 2] >> 6) & 0x3f);
            abyte1[3] = (byte)"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(abyte0[i + 2] & 0x3f);
            return;
        }
        if (j == 2)
        {
            abyte1[1] = (byte)"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt((abyte0[i] << 4) + (abyte0[i + 1] >> 4) & 0x3f);
            abyte1[2] = (byte)"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(abyte0[i + 1] << 2 & 0x3f);
            return;
        } else
        {
            abyte1[1] = (byte)"ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".charAt(abyte0[i] << 4 & 0x3f);
            return;
        }
    }

    static final void b(byte abyte0[], int i, int j, byte abyte1[], int k)
    {
        abyte1[k] = (byte)(a[abyte0[i] & 0xff] << 2 | a[abyte0[i + 1] & 0xff] >> 4);
        if (j > 2)
        {
            abyte1[k + 1] = (byte)(a[abyte0[i + 1] & 0xff] << 4 & 0xf0 | a[abyte0[i + 2] & 0xff] >> 2);
            if (j > 3)
            {
                abyte1[k + 2] = (byte)(a[abyte0[i + 2] & 0xff] << 6 & 0xc0 | a[abyte0[i + 3] & 0xff]);
            }
        }
    }

}
