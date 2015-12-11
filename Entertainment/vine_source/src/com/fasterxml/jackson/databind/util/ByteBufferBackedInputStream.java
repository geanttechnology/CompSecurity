// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.util;

import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class ByteBufferBackedInputStream extends InputStream
{

    protected final ByteBuffer _buffer;

    public ByteBufferBackedInputStream(ByteBuffer bytebuffer)
    {
        _buffer = bytebuffer;
    }

    public int available()
    {
        return _buffer.remaining();
    }

    public int read()
        throws IOException
    {
        if (_buffer.hasRemaining())
        {
            return _buffer.get() & 0xff;
        } else
        {
            return -1;
        }
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        if (!_buffer.hasRemaining())
        {
            return -1;
        } else
        {
            j = Math.min(j, _buffer.remaining());
            _buffer.get(abyte0, i, j);
            return j;
        }
    }
}
