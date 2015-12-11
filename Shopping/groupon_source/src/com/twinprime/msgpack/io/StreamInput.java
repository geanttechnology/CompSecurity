// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.twinprime.msgpack.io;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

// Referenced classes of package com.twinprime.msgpack.io:
//            BufferReferer

public class StreamInput
    implements Closeable
{

    private byte castBuffer[];
    private ByteBuffer castByteBuffer;
    private int filled;
    private final InputStream in;
    private int readByteCount;

    public StreamInput(InputStream inputstream)
    {
        readByteCount = 0;
        in = inputstream;
        castBuffer = new byte[8];
        castByteBuffer = ByteBuffer.wrap(castBuffer);
        filled = 0;
    }

    private void require(int i)
        throws IOException
    {
        int j;
        for (; filled < i; filled = filled + j)
        {
            j = in.read(castBuffer, filled, i - filled);
            if (j < 0)
            {
                throw new EOFException();
            }
        }

    }

    public void advance()
    {
        incrReadByteCount(filled);
        filled = 0;
    }

    public void close()
        throws IOException
    {
        in.close();
    }

    public byte getByte()
        throws IOException
    {
        require(1);
        return castBuffer[0];
    }

    public double getDouble()
        throws IOException
    {
        require(8);
        return castByteBuffer.getDouble(0);
    }

    public float getFloat()
        throws IOException
    {
        require(4);
        return castByteBuffer.getFloat(0);
    }

    public int getInt()
        throws IOException
    {
        require(4);
        return castByteBuffer.getInt(0);
    }

    public long getLong()
        throws IOException
    {
        require(8);
        return castByteBuffer.getLong(0);
    }

    public short getShort()
        throws IOException
    {
        require(2);
        return castByteBuffer.getShort(0);
    }

    protected final void incrReadByteCount(int i)
    {
        readByteCount = readByteCount + i;
    }

    protected final void incrReadOneByteCount()
    {
        readByteCount = readByteCount + 1;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        for (int k = j; k > 0;)
        {
            int l = in.read(abyte0, i, k);
            if (l <= 0)
            {
                throw new EOFException();
            }
            incrReadByteCount(l);
            k -= l;
            i += l;
        }

        return j;
    }

    public byte readByte()
        throws IOException
    {
        int i = in.read();
        if (i < 0)
        {
            throw new EOFException();
        } else
        {
            incrReadOneByteCount();
            return (byte)i;
        }
    }

    public boolean tryRefer(BufferReferer bufferreferer, int i)
        throws IOException
    {
        return false;
    }
}
