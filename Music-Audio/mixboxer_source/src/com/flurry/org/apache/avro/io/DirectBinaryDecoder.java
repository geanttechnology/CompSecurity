// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.util.ByteBufferInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            BinaryDecoder

class DirectBinaryDecoder extends BinaryDecoder
{
    private class ByteReader
    {

        final DirectBinaryDecoder this$0;

        public ByteBuffer read(ByteBuffer bytebuffer, int i)
            throws IOException
        {
            if (bytebuffer != null && i <= bytebuffer.capacity())
            {
                bytebuffer.clear();
            } else
            {
                bytebuffer = ByteBuffer.allocate(i);
            }
            doReadBytes(bytebuffer.array(), bytebuffer.position(), i);
            bytebuffer.limit(i);
            return bytebuffer;
        }

        private ByteReader()
        {
            this$0 = DirectBinaryDecoder.this;
            super();
        }

    }

    private class ReuseByteReader extends ByteReader
    {

        private final ByteBufferInputStream bbi;
        final DirectBinaryDecoder this$0;

        public ByteBuffer read(ByteBuffer bytebuffer, int i)
            throws IOException
        {
            if (bytebuffer != null)
            {
                return super.read(bytebuffer, i);
            } else
            {
                return bbi.readBuffer(i);
            }
        }

        public ReuseByteReader(ByteBufferInputStream bytebufferinputstream)
        {
            this$0 = DirectBinaryDecoder.this;
            super();
            bbi = bytebufferinputstream;
        }
    }


    private final byte buf[] = new byte[8];
    private ByteReader byteReader;
    private InputStream in;

    DirectBinaryDecoder(InputStream inputstream)
    {
        configure(inputstream);
    }

    DirectBinaryDecoder configure(InputStream inputstream)
    {
        in = inputstream;
        if (inputstream instanceof ByteBufferInputStream)
        {
            inputstream = new ReuseByteReader((ByteBufferInputStream)inputstream);
        } else
        {
            inputstream = new ByteReader();
        }
        byteReader = inputstream;
        return this;
    }

    protected void doReadBytes(byte abyte0[], int i, int j)
        throws IOException
    {
        do
        {
            int k = in.read(abyte0, i, j);
            if (k == j || j == 0)
            {
                return;
            }
            if (k < 0)
            {
                throw new EOFException();
            }
            i += k;
            j -= k;
        } while (true);
    }

    protected void doSkipBytes(long l)
        throws IOException
    {
        long l1;
        for (; l > 0L; l -= l1)
        {
            l1 = in.skip(l);
            if (l1 <= 0L)
            {
                throw new EOFException();
            }
        }

    }

    public InputStream inputStream()
    {
        return in;
    }

    public boolean isEnd()
        throws IOException
    {
        throw new UnsupportedOperationException();
    }

    public boolean readBoolean()
        throws IOException
    {
        int i = in.read();
        if (i < 0)
        {
            throw new EOFException();
        }
        return i == 1;
    }

    public ByteBuffer readBytes(ByteBuffer bytebuffer)
        throws IOException
    {
        int i = readInt();
        return byteReader.read(bytebuffer, i);
    }

    public double readDouble()
        throws IOException
    {
        doReadBytes(buf, 0, 8);
        return Double.longBitsToDouble((long)buf[0] & 255L | ((long)buf[1] & 255L) << 8 | ((long)buf[2] & 255L) << 16 | ((long)buf[3] & 255L) << 24 | ((long)buf[4] & 255L) << 32 | ((long)buf[5] & 255L) << 40 | ((long)buf[6] & 255L) << 48 | ((long)buf[7] & 255L) << 56);
    }

    public float readFloat()
        throws IOException
    {
        doReadBytes(buf, 0, 4);
        return Float.intBitsToFloat(buf[0] & 0xff | (buf[1] & 0xff) << 8 | (buf[2] & 0xff) << 16 | (buf[3] & 0xff) << 24);
    }

    public int readInt()
        throws IOException
    {
        int j = 0;
        int i = 0;
        int k;
        do
        {
            k = in.read();
            if (k >= 0)
            {
                j |= (k & 0x7f) << i;
                if ((k & 0x80) == 0)
                {
                    return j >>> 1 ^ -(j & 1);
                }
            } else
            {
                throw new EOFException();
            }
            k = i + 7;
            i = k;
        } while (k < 32);
        throw new IOException("Invalid int encoding");
    }

    public long readLong()
        throws IOException
    {
        long l = 0L;
        int i = 0;
        int j;
        do
        {
            j = in.read();
            if (j >= 0)
            {
                l |= ((long)j & 127L) << i;
                if ((j & 0x80) == 0)
                {
                    return l >>> 1 ^ -(1L & l);
                }
            } else
            {
                throw new EOFException();
            }
            j = i + 7;
            i = j;
        } while (j < 64);
        throw new IOException("Invalid long encoding");
    }
}
