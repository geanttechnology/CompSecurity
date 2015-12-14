// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.tencent.mm.algorithm;


public final class TypeTransform
{

    private TypeTransform()
    {
    }

    private static byte[] a(byte abyte0[])
    {
        int j = abyte0.length;
        byte abyte1[] = new byte[j];
        for (int i = 0; i < j; i++)
        {
            abyte1[i] = abyte0[j - 1 - i];
        }

        return abyte1;
    }

    public static int byteArrayHLToInt(byte abyte0[])
    {
        return byteArrayHLToInt(abyte0, 0);
    }

    public static int byteArrayHLToInt(byte abyte0[], int i)
    {
        return (abyte0[i] & 0xff) << 24 | (abyte0[i + 1] & 0xff) << 16 | (abyte0[i + 2] & 0xff) << 8 | (abyte0[i + 3] & 0xff) << 0;
    }

    public static long byteArrayHLToLong(byte abyte0[])
    {
        return byteArrayHLToLong(abyte0, 0);
    }

    public static long byteArrayHLToLong(byte abyte0[], int i)
    {
        return ((long)abyte0[i] & 255L) << 56 | ((long)abyte0[i + 1] & 255L) << 48 | ((long)abyte0[i + 2] & 255L) << 40 | ((long)abyte0[i + 3] & 255L) << 32 | ((long)abyte0[i + 4] & 255L) << 24 | ((long)abyte0[i + 5] & 255L) << 16 | ((long)abyte0[i + 6] & 255L) << 8 | ((long)abyte0[i + 7] & 255L) << 0;
    }

    public static int byteArrayLHToInt(byte abyte0[])
    {
        return byteArrayLHToInt(abyte0, 0);
    }

    public static int byteArrayLHToInt(byte abyte0[], int i)
    {
        return (abyte0[i + 3] & 0xff) << 24 | (abyte0[i + 2] & 0xff) << 16 | (abyte0[i + 1] & 0xff) << 8 | (abyte0[i] & 0xff) << 0;
    }

    public static long byteArrayLHToLong(byte abyte0[])
    {
        return byteArrayLHToLong(abyte0, 0);
    }

    public static long byteArrayLHToLong(byte abyte0[], int i)
    {
        return ((long)abyte0[i + 7] & 255L) << 56 | ((long)abyte0[i + 6] & 255L) << 48 | ((long)abyte0[5] & 255L) << 40 | ((long)abyte0[i + 4] & 255L) << 32 | ((long)abyte0[i + 3] & 255L) << 24 | ((long)abyte0[i + 2] & 255L) << 16 | ((long)abyte0[i + 1] & 255L) << 8 | ((long)abyte0[i] & 255L) << 0;
    }

    public static byte[] intToByteArrayHL(int i)
    {
        return a(intToByteArrayLH(i));
    }

    public static byte[] intToByteArrayLH(int i)
    {
        byte abyte0[] = new byte[4];
        for (int j = 0; j < 4; j++)
        {
            abyte0[j] = (byte)(i >> j * 8 & 0xff);
        }

        return abyte0;
    }

    public static byte[] longToByteArrayHL(long l)
    {
        return a(longToByteArrayLH(l));
    }

    public static byte[] longToByteArrayLH(long l)
    {
        byte abyte0[] = new byte[8];
        for (int i = 0; i < 8; i++)
        {
            abyte0[i] = (byte)(int)(l >> i * 8);
        }

        return abyte0;
    }
}
