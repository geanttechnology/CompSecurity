// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.util;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;

public class ByteBufferBackedOutputStream extends OutputStream
{

    protected final ByteBuffer _buffer;

    public ByteBufferBackedOutputStream(ByteBuffer bytebuffer)
    {
        _buffer = bytebuffer;
    }

    public void write(int i)
        throws IOException
    {
        _buffer.put((byte)i);
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        _buffer.put(abyte0, i, j);
    }
}
