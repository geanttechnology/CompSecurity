// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.io;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class EndianUtils
{

    private static int read(InputStream inputstream)
        throws IOException
    {
        int i = inputstream.read();
        if (-1 == i)
        {
            throw new EOFException("Unexpected EOF reached");
        } else
        {
            return i;
        }
    }

    public static double readSwappedDouble(InputStream inputstream)
        throws IOException
    {
        return Double.longBitsToDouble(readSwappedLong(inputstream));
    }

    public static float readSwappedFloat(InputStream inputstream)
        throws IOException
    {
        return Float.intBitsToFloat(readSwappedInteger(inputstream));
    }

    public static int readSwappedInteger(InputStream inputstream)
        throws IOException
    {
        return ((read(inputstream) & 0xff) << 0) + ((read(inputstream) & 0xff) << 8) + ((read(inputstream) & 0xff) << 16) + ((read(inputstream) & 0xff) << 24);
    }

    public static long readSwappedLong(InputStream inputstream)
        throws IOException
    {
        byte abyte0[] = new byte[8];
        for (int i = 0; i < 8; i++)
        {
            abyte0[i] = (byte)read(inputstream);
        }

        return readSwappedLong(abyte0, 0);
    }

    public static long readSwappedLong(byte abyte0[], int i)
    {
        long l = ((abyte0[i + 0] & 0xff) << 0) + ((abyte0[i + 1] & 0xff) << 8) + ((abyte0[i + 2] & 0xff) << 16) + ((abyte0[i + 3] & 0xff) << 24);
        return ((long)(((abyte0[i + 4] & 0xff) << 0) + ((abyte0[i + 5] & 0xff) << 8) + ((abyte0[i + 6] & 0xff) << 16) + ((abyte0[i + 7] & 0xff) << 24)) << 32) + (0xffffffffL & l);
    }

    public static short readSwappedShort(InputStream inputstream)
        throws IOException
    {
        return (short)(((read(inputstream) & 0xff) << 0) + ((read(inputstream) & 0xff) << 8));
    }

    public static int readSwappedUnsignedShort(InputStream inputstream)
        throws IOException
    {
        return ((read(inputstream) & 0xff) << 0) + ((read(inputstream) & 0xff) << 8);
    }
}
