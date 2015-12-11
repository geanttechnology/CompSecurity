// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.file;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

class LengthLimitedInputStream extends FilterInputStream
{

    private long remaining;

    protected LengthLimitedInputStream(InputStream inputstream, long l)
    {
        super(inputstream);
        remaining = l;
    }

    private int remainingInt()
    {
        return (int)Math.min(remaining, 0x7fffffffL);
    }

    public int available()
        throws IOException
    {
        return Math.min(super.available(), remainingInt());
    }

    public int read()
        throws IOException
    {
        if (remaining > 0L)
        {
            int i = super.read();
            if (i != -1)
            {
                remaining = remaining - 1L;
            }
            return i;
        } else
        {
            return -1;
        }
    }

    public int read(byte abyte0[])
        throws IOException
    {
        return read(abyte0, 0, abyte0.length);
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        if (remaining == 0L)
        {
            i = -1;
        } else
        {
            int k = j;
            if ((long)j > remaining)
            {
                k = remainingInt();
            }
            j = super.read(abyte0, i, k);
            i = j;
            if (j != -1)
            {
                remaining = remaining - (long)j;
                return j;
            }
        }
        return i;
    }

    public long skip(long l)
        throws IOException
    {
        l = super.skip(Math.min(remaining, l));
        remaining = remaining - l;
        return l;
    }
}
