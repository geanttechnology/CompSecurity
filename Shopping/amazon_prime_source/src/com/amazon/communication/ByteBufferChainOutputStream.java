// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.BufferOverflowException;
import java.nio.ByteBuffer;

// Referenced classes of package com.amazon.communication:
//            ByteBufferChain

public class ByteBufferChainOutputStream extends OutputStream
{

    private final ByteBuffer mBuffers[];
    private int mPosition;

    public ByteBufferChainOutputStream(ByteBufferChain bytebufferchain)
    {
        mBuffers = bytebufferchain.getByteBuffers();
        mPosition = 0;
    }

    public void write(int i)
        throws IOException
    {
        try
        {
            for (; mPosition < mBuffers.length && !mBuffers[mPosition].hasRemaining(); mPosition = mPosition + 1) { }
        }
        catch (BufferOverflowException bufferoverflowexception)
        {
            throw new IOException(bufferoverflowexception);
        }
        if (mPosition < mBuffers.length)
        {
            mBuffers[mPosition].put((byte)i);
            return;
        }
        throw new IOException("Reached the end of the ByteBufferChain and did not manage to write the byte!");
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
        for (; mPosition < mBuffers.length && !mBuffers[mPosition].hasRemaining(); mPosition = mPosition + 1) { }
        if (mPosition == mBuffers.length)
        {
            throw new IOException((new StringBuilder()).append("No bytes could be written because we are already at the end of the ByteBufferChain.  mPosition = ").append(mPosition).append(", mBuffers.length = ").append(mBuffers.length).toString());
        }
        int k = 0;
        do
        {
            if (k >= j || mPosition >= mBuffers.length)
            {
                break;
            }
            int l = Math.min(j - k, mBuffers[mPosition].remaining());
            mBuffers[mPosition].put(abyte0, i + k, l);
            l = k + l;
            k = l;
            if (l < j)
            {
                mPosition = mPosition + 1;
                k = l;
            }
        } while (true);
        if (k < j)
        {
            throw new IOException((new StringBuilder()).append("Reached the end of the ByteBufferChain and only managed to write ").append(k).append(" bytes out of ").append(j).append(" requested").toString());
        } else
        {
            return;
        }
    }
}
