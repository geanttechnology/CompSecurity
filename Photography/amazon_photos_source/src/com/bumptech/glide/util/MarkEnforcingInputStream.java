// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bumptech.glide.util;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MarkEnforcingInputStream extends FilterInputStream
{

    private int availableBytes;

    public MarkEnforcingInputStream(InputStream inputstream)
    {
        super(inputstream);
        availableBytes = 0x80000000;
    }

    private long getBytesToRead(long l)
    {
        long l1;
        if (availableBytes == 0)
        {
            l1 = -1L;
        } else
        {
            l1 = l;
            if (availableBytes != 0x80000000)
            {
                l1 = l;
                if (l > (long)availableBytes)
                {
                    return (long)availableBytes;
                }
            }
        }
        return l1;
    }

    private void updateAvailableBytesAfterRead(long l)
    {
        if (availableBytes != 0x80000000 && l != -1L)
        {
            availableBytes = (int)((long)availableBytes - l);
        }
    }

    public int available()
        throws IOException
    {
        if (availableBytes == 0x80000000)
        {
            return super.available();
        } else
        {
            return Math.min(availableBytes, super.available());
        }
    }

    public void mark(int i)
    {
        super.mark(i);
        availableBytes = i;
    }

    public int read()
        throws IOException
    {
        if (getBytesToRead(1L) == -1L)
        {
            return -1;
        } else
        {
            int i = super.read();
            updateAvailableBytesAfterRead(1L);
            return i;
        }
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        j = (int)getBytesToRead(j);
        if (j == -1)
        {
            return -1;
        } else
        {
            i = super.read(abyte0, i, j);
            updateAvailableBytesAfterRead(i);
            return i;
        }
    }

    public void reset()
        throws IOException
    {
        super.reset();
        availableBytes = 0x80000000;
    }

    public long skip(long l)
        throws IOException
    {
        l = getBytesToRead(l);
        if (l == -1L)
        {
            return -1L;
        } else
        {
            l = super.skip(l);
            updateAvailableBytesAfterRead(l);
            return l;
        }
    }
}
