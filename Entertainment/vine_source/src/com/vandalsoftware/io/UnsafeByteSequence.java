// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.vandalsoftware.io;

import java.io.UnsupportedEncodingException;

public class UnsafeByteSequence
{

    private byte bytes[];
    private int count;

    public UnsafeByteSequence(int i)
    {
        bytes = new byte[i];
    }

    public void rewind()
    {
        count = 0;
    }

    public int size()
    {
        return count;
    }

    public byte[] toByteArray()
    {
        if (count == bytes.length)
        {
            return bytes;
        } else
        {
            byte abyte0[] = new byte[count];
            System.arraycopy(bytes, 0, abyte0, 0, count);
            return abyte0;
        }
    }

    public String toString(String s)
    {
        try
        {
            s = new String(bytes, 0, count, s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return new String(bytes, 0, count);
        }
        return s;
    }

    public void write(int i)
    {
        if (count == bytes.length)
        {
            byte abyte0[] = new byte[count * 2];
            System.arraycopy(bytes, 0, abyte0, 0, count);
            bytes = abyte0;
        }
        byte abyte1[] = bytes;
        int j = count;
        count = j + 1;
        abyte1[j] = (byte)i;
    }

    public void write(byte abyte0[], int i, int j)
    {
        if (count + j >= bytes.length)
        {
            byte abyte1[] = new byte[(count + j) * 2];
            System.arraycopy(bytes, 0, abyte1, 0, count);
            bytes = abyte1;
        }
        System.arraycopy(abyte0, i, bytes, count, j);
        count = count + j;
    }
}
