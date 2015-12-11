// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.tracking.mobile.internal;

import java.io.IOException;
import java.io.OutputStream;

public class ByteCountedOutputStream extends OutputStream
{

    private long byteCount;
    private final OutputStream stream;

    public ByteCountedOutputStream(OutputStream outputstream)
    {
        stream = outputstream;
        byteCount = 0L;
    }

    public void close()
        throws IOException
    {
        stream.close();
    }

    public void flush()
        throws IOException
    {
        stream.flush();
    }

    public long getByteCount()
    {
        return byteCount;
    }

    public void write(int i)
        throws IOException
    {
        stream.write(i);
        byteCount = byteCount + 1L;
    }

    public void write(byte abyte0[])
        throws IOException
    {
        stream.write(abyte0);
        byteCount = byteCount + (long)abyte0.length;
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        stream.write(abyte0, i, j);
        byteCount = byteCount + (long)j;
    }
}
