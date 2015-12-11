// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.dp.framework;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;

public class ByteBufferOutputStream extends OutputStream
{

    private final ByteBuffer mBuffer;

    public ByteBufferOutputStream(ByteBuffer bytebuffer)
    {
        mBuffer = bytebuffer;
    }

    public void write(int i)
        throws IOException
    {
        try
        {
            mBuffer.put((byte)i);
            return;
        }
        catch (BufferOverflowException bufferoverflowexception)
        {
            throw new IOException(bufferoverflowexception);
        }
    }

    public void write(byte abyte0[], int i, int j)
        throws IOException
    {
        if (abyte0 == null)
        {
            throw new NullPointerException("Array must not be null");
        }
        if (i < 0 || j < 0 || i + j > abyte0.length)
        {
            throw new ArrayIndexOutOfBoundsException((new StringBuilder()).append("array size:").append(abyte0.length).append(", offset:").append(i).append(", length:").append(j).toString());
        }
        try
        {
            mBuffer.put(abyte0, i, j);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (byte abyte0[])
        {
            throw new IOException(abyte0);
        }
    }
}
