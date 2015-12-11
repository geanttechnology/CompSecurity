// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.util;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ByteBufferOutputStream extends OutputStream
{

    public static final int BUFFER_SIZE = 8192;
    private List buffers;

    public ByteBufferOutputStream()
    {
        reset();
    }

    public void append(List list)
    {
        ByteBuffer bytebuffer;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); bytebuffer.position(bytebuffer.limit()))
        {
            bytebuffer = (ByteBuffer)iterator.next();
        }

        buffers.addAll(list);
    }

    public List getBufferList()
    {
        List list = buffers;
        reset();
        for (Iterator iterator = list.iterator(); iterator.hasNext(); ((ByteBuffer)iterator.next()).flip()) { }
        return list;
    }

    public void prepend(List list)
    {
        ByteBuffer bytebuffer;
        for (Iterator iterator = list.iterator(); iterator.hasNext(); bytebuffer.position(bytebuffer.limit()))
        {
            bytebuffer = (ByteBuffer)iterator.next();
        }

        buffers.addAll(0, list);
    }

    public void reset()
    {
        buffers = new LinkedList();
        buffers.add(ByteBuffer.allocate(8192));
    }

    public void write(int i)
    {
        ByteBuffer bytebuffer1 = (ByteBuffer)buffers.get(buffers.size() - 1);
        ByteBuffer bytebuffer = bytebuffer1;
        if (bytebuffer1.remaining() < 1)
        {
            bytebuffer = ByteBuffer.allocate(8192);
            buffers.add(bytebuffer);
        }
        bytebuffer.put((byte)i);
    }

    public void write(ByteBuffer bytebuffer)
    {
        buffers.add(bytebuffer);
    }

    public void write(byte abyte0[], int i, int j)
    {
        ByteBuffer bytebuffer = (ByteBuffer)buffers.get(buffers.size() - 1);
        int l = bytebuffer.remaining();
        int k = j;
        j = i;
        for (i = l; k > i; i = bytebuffer.remaining())
        {
            bytebuffer.put(abyte0, j, i);
            k -= i;
            j += i;
            bytebuffer = ByteBuffer.allocate(8192);
            buffers.add(bytebuffer);
        }

        bytebuffer.put(abyte0, j, k);
    }

    public void writeBuffer(ByteBuffer bytebuffer)
        throws IOException
    {
        if (bytebuffer.remaining() < 8192)
        {
            write(bytebuffer.array(), bytebuffer.position(), bytebuffer.remaining());
            return;
        } else
        {
            ByteBuffer bytebuffer1 = bytebuffer.duplicate();
            bytebuffer1.position(bytebuffer.limit());
            buffers.add(bytebuffer1);
            return;
        }
    }
}
