// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

final class ByteString
{

    public static final ByteString EMPTY = new ByteString(new byte[0]);
    private final byte bytes[];
    private volatile int hash;

    private ByteString(byte abyte0[])
    {
        hash = 0;
        bytes = abyte0;
    }

    public static ByteString copyFrom(byte abyte0[], int i, int j)
    {
        byte abyte1[] = new byte[j];
        System.arraycopy(abyte0, i, abyte1, 0, j);
        return new ByteString(abyte1);
    }

    public static ByteString copyFromUtf8(String s)
    {
        try
        {
            s = new ByteString(s.getBytes("UTF-8"));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            throw new RuntimeException("UTF-8 not supported.", s);
        }
        return s;
    }

    public void copyTo(byte abyte0[], int i, int j, int k)
    {
        System.arraycopy(bytes, i, abyte0, j, k);
    }

    public boolean equals(Object obj)
    {
        if (obj != this)
        {
            if (!(obj instanceof ByteString))
            {
                return false;
            }
            ByteString bytestring = (ByteString)obj;
            int j = bytes.length;
            if (j != bytestring.bytes.length)
            {
                return false;
            }
            obj = bytes;
            byte abyte0[] = bytestring.bytes;
            int i = 0;
            while (i < j) 
            {
                if (obj[i] != abyte0[i])
                {
                    return false;
                }
                i++;
            }
        }
        return true;
    }

    public int hashCode()
    {
        int i = hash;
        int k = i;
        if (i == 0)
        {
            byte abyte0[] = bytes;
            int l = bytes.length;
            int j = l;
            for (k = 0; k < l; k++)
            {
                j = j * 31 + abyte0[k];
            }

            k = j;
            if (j == 0)
            {
                k = 1;
            }
            hash = k;
        }
        return k;
    }

    public InputStream newInput()
    {
        return new ByteArrayInputStream(bytes);
    }

    public int size()
    {
        return bytes.length;
    }

}
