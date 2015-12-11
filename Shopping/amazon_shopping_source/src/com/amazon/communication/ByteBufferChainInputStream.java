// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import java.io.IOException;
import java.io.InputStream;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;

// Referenced classes of package com.amazon.communication:
//            ByteBufferChain

public class ByteBufferChainInputStream extends InputStream
{

    private final ByteBuffer mBuffers[];
    private int mPosition;

    public ByteBufferChainInputStream(ByteBufferChain bytebufferchain)
    {
        mBuffers = bytebufferchain.getByteBuffers();
        mPosition = 0;
    }

    public int available()
    {
        int j = 0;
        for (int i = 0; i < mBuffers.length; i++)
        {
            j += mBuffers[i].remaining();
        }

        return j;
    }

    public int read()
        throws IOException
    {
        int i = -1;
        for (; mPosition < mBuffers.length && !mBuffers[mPosition].hasRemaining(); mPosition = mPosition + 1) { }
        if (mPosition < mBuffers.length)
        {
            try
            {
                i = mBuffers[mPosition].get();
            }
            catch (BufferUnderflowException bufferunderflowexception)
            {
                throw new IOException(bufferunderflowexception);
            }
            i &= 0xff;
        }
        return i;
    }

    public int read(byte abyte0[], int i, int j)
    {
        if (i < 0 || j < 0 || i > abyte0.length)
        {
            throw new ArrayIndexOutOfBoundsException((new StringBuilder()).append("length=").append(abyte0.length).append("; regionStart=").append(i).append("; regionLength=").append(j).toString());
        }
        if (j == 0)
        {
            i = 0;
        } else
        {
            for (; mPosition < mBuffers.length && !mBuffers[mPosition].hasRemaining(); mPosition = mPosition + 1) { }
            int k = 0;
            do
            {
                if (k >= j || mPosition >= mBuffers.length)
                {
                    break;
                }
                int l = Math.min(j - k, mBuffers[mPosition].remaining());
                mBuffers[mPosition].get(abyte0, i + k, l);
                l = k + l;
                k = l;
                if (l < j)
                {
                    mPosition = mPosition + 1;
                    k = l;
                }
            } while (true);
            i = k;
            if (k <= 0)
            {
                return -1;
            }
        }
        return i;
    }
}
