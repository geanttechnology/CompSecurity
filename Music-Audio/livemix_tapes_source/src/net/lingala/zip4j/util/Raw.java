// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.lingala.zip4j.util;

import java.io.DataInput;
import java.io.IOException;
import net.lingala.zip4j.exception.ZipException;

public class Raw
{

    public Raw()
    {
    }

    public static byte bitArrayToByte(int ai[])
        throws ZipException
    {
        if (ai == null)
        {
            throw new ZipException("bit array is null, cannot calculate byte from bits");
        }
        if (ai.length != 8)
        {
            throw new ZipException("invalid bit array length, cannot calculate byte");
        }
        if (!checkBits(ai))
        {
            throw new ZipException("invalid bits provided, bits contain other values than 0 or 1");
        }
        int j = 0;
        int i = 0;
        do
        {
            if (i >= ai.length)
            {
                return (byte)j;
            }
            j = (int)((double)j + Math.pow(2D, i) * (double)ai[i]);
            i++;
        } while (true);
    }

    private static boolean checkBits(int ai[])
    {
        int i = 0;
        do
        {
            if (i >= ai.length)
            {
                return true;
            }
            if (ai[i] != 0 && ai[i] != 1)
            {
                return false;
            }
            i++;
        } while (true);
    }

    public static byte[] convertCharArrayToByteArray(char ac[])
    {
        if (ac == null)
        {
            throw new NullPointerException();
        }
        byte abyte0[] = new byte[ac.length];
        int i = 0;
        do
        {
            if (i >= ac.length)
            {
                return abyte0;
            }
            abyte0[i] = (byte)ac[i];
            i++;
        } while (true);
    }

    public static void prepareBuffAESIVBytes(byte abyte0[], int i, int j)
    {
        abyte0[0] = (byte)i;
        abyte0[1] = (byte)(i >> 8);
        abyte0[2] = (byte)(i >> 16);
        abyte0[3] = (byte)(i >> 24);
        abyte0[4] = 0;
        abyte0[5] = 0;
        abyte0[6] = 0;
        abyte0[7] = 0;
        abyte0[8] = 0;
        abyte0[9] = 0;
        abyte0[10] = 0;
        abyte0[11] = 0;
        abyte0[12] = 0;
        abyte0[13] = 0;
        abyte0[14] = 0;
        abyte0[15] = 0;
    }

    public static int readIntLittleEndian(byte abyte0[], int i)
    {
        return abyte0[i] & 0xff | (abyte0[i + 1] & 0xff) << 8 | (abyte0[i + 2] & 0xff | (abyte0[i + 3] & 0xff) << 8) << 16;
    }

    public static int readLeInt(DataInput datainput, byte abyte0[])
        throws ZipException
    {
        try
        {
            datainput.readFully(abyte0, 0, 4);
        }
        // Misplaced declaration of an exception variable
        catch (DataInput datainput)
        {
            throw new ZipException(datainput);
        }
        return abyte0[0] & 0xff | (abyte0[1] & 0xff) << 8 | (abyte0[2] & 0xff | (abyte0[3] & 0xff) << 8) << 16;
    }

    public static long readLongLittleEndian(byte abyte0[], int i)
    {
        return (((((((0L | (long)(abyte0[i + 7] & 0xff)) << 8 | (long)(abyte0[i + 6] & 0xff)) << 8 | (long)(abyte0[i + 5] & 0xff)) << 8 | (long)(abyte0[i + 4] & 0xff)) << 8 | (long)(abyte0[i + 3] & 0xff)) << 8 | (long)(abyte0[i + 2] & 0xff)) << 8 | (long)(abyte0[i + 1] & 0xff)) << 8 | (long)(abyte0[i] & 0xff);
    }

    public static final short readShortBigEndian(byte abyte0[], int i)
    {
        short word0 = (short)((short)(abyte0[i] & 0xff | 0) << 8);
        return (short)(abyte0[i + 1] & 0xff | word0);
    }

    public static int readShortLittleEndian(byte abyte0[], int i)
    {
        return abyte0[i] & 0xff | (abyte0[i + 1] & 0xff) << 8;
    }

    public static byte[] toByteArray(int i)
    {
        return (new byte[] {
            (byte)i, (byte)(i >> 8), (byte)(i >> 16), (byte)(i >> 24)
        });
    }

    public static byte[] toByteArray(int i, int j)
    {
        byte abyte0[] = new byte[j];
        byte abyte1[] = toByteArray(i);
        i = 0;
        do
        {
            if (i >= abyte1.length || i >= j)
            {
                return abyte0;
            }
            abyte0[i] = abyte1[i];
            i++;
        } while (true);
    }

    public static final void writeIntLittleEndian(byte abyte0[], int i, int j)
    {
        abyte0[i + 3] = (byte)(j >>> 24);
        abyte0[i + 2] = (byte)(j >>> 16);
        abyte0[i + 1] = (byte)(j >>> 8);
        abyte0[i] = (byte)(j & 0xff);
    }

    public static void writeLongLittleEndian(byte abyte0[], int i, long l)
    {
        abyte0[i + 7] = (byte)(int)(l >>> 56);
        abyte0[i + 6] = (byte)(int)(l >>> 48);
        abyte0[i + 5] = (byte)(int)(l >>> 40);
        abyte0[i + 4] = (byte)(int)(l >>> 32);
        abyte0[i + 3] = (byte)(int)(l >>> 24);
        abyte0[i + 2] = (byte)(int)(l >>> 16);
        abyte0[i + 1] = (byte)(int)(l >>> 8);
        abyte0[i] = (byte)(int)(255L & l);
    }

    public static final void writeShortLittleEndian(byte abyte0[], int i, short word0)
    {
        abyte0[i + 1] = (byte)(word0 >>> 8);
        abyte0[i] = (byte)(word0 & 0xff);
    }
}
