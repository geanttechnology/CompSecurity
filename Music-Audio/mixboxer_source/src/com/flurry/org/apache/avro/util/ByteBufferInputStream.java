// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.util;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;

public class ByteBufferInputStream extends InputStream
{

    private List buffers;
    private int current;

    public ByteBufferInputStream(List list)
    {
        buffers = list;
    }

    private ByteBuffer getBuffer()
        throws IOException
    {
        for (; current < buffers.size(); current = current + 1)
        {
            ByteBuffer bytebuffer = (ByteBuffer)buffers.get(current);
            if (bytebuffer.hasRemaining())
            {
                return bytebuffer;
            }
        }

        throw new EOFException();
    }

    public int read()
        throws IOException
    {
        return getBuffer().get() & 0xff;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        if (j == 0)
        {
            return 0;
        }
        ByteBuffer bytebuffer = getBuffer();
        int k = bytebuffer.remaining();
        if (j > k)
        {
            bytebuffer.get(abyte0, i, k);
            return k;
        } else
        {
            bytebuffer.get(abyte0, i, j);
            return j;
        }
    }

    public ByteBuffer readBuffer(int i)
        throws IOException
    {
        if (i == 0)
        {
            return ByteBuffer.allocate(0);
        }
        ByteBuffer bytebuffer = getBuffer();
        if (bytebuffer.remaining() == i)
        {
            current = current + 1;
            return bytebuffer;
        }
        bytebuffer = ByteBuffer.allocate(i);
        for (int j = 0; j < i; j += read(bytebuffer.array(), j, i - j)) { }
        return bytebuffer;
    }
}
