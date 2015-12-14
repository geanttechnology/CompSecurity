// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package it.sephiroth.android.library.exif2;

import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;

class CountedDataInputStream extends FilterInputStream
{

    static final boolean $assertionsDisabled;
    private final byte mByteArray[] = new byte[8];
    private final ByteBuffer mByteBuffer;
    private int mCount;
    private int mEnd;

    protected CountedDataInputStream(InputStream inputstream)
    {
        super(inputstream);
        mByteBuffer = ByteBuffer.wrap(mByteArray);
        mCount = 0;
        mEnd = 0;
    }

    public ByteOrder getByteOrder()
    {
        return mByteBuffer.order();
    }

    public int getEnd()
    {
        return mEnd;
    }

    public int getReadByteCount()
    {
        return mCount;
    }

    public int read()
        throws IOException
    {
        int j = in.read();
        int k = mCount;
        int i;
        if (j >= 0)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        mCount = i + k;
        return j;
    }

    public int read(byte abyte0[])
        throws IOException
    {
        int j = in.read(abyte0);
        int k = mCount;
        int i;
        if (j >= 0)
        {
            i = j;
        } else
        {
            i = 0;
        }
        mCount = i + k;
        return j;
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        j = in.read(abyte0, i, j);
        int k = mCount;
        if (j >= 0)
        {
            i = j;
        } else
        {
            i = 0;
        }
        mCount = i + k;
        return j;
    }

    public byte readByte()
        throws IOException
    {
        readOrThrow(mByteArray, 0, 1);
        mByteBuffer.rewind();
        return mByteBuffer.get();
    }

    public int readInt()
        throws IOException
    {
        readOrThrow(mByteArray, 0, 4);
        mByteBuffer.rewind();
        return mByteBuffer.getInt();
    }

    public long readLong()
        throws IOException
    {
        readOrThrow(mByteArray, 0, 8);
        mByteBuffer.rewind();
        return mByteBuffer.getLong();
    }

    public void readOrThrow(byte abyte0[])
        throws IOException
    {
        readOrThrow(abyte0, 0, abyte0.length);
    }

    public void readOrThrow(byte abyte0[], int i, int j)
        throws IOException
    {
        if (read(abyte0, i, j) != j)
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }

    public short readShort()
        throws IOException
    {
        readOrThrow(mByteArray, 0, 2);
        mByteBuffer.rewind();
        return mByteBuffer.getShort();
    }

    public String readString(int i)
        throws IOException
    {
        byte abyte0[] = new byte[i];
        readOrThrow(abyte0);
        return new String(abyte0, "UTF8");
    }

    public String readString(int i, Charset charset)
        throws IOException
    {
        byte abyte0[] = new byte[i];
        readOrThrow(abyte0);
        return new String(abyte0, charset);
    }

    public int readUnsignedByte()
        throws IOException
    {
        readOrThrow(mByteArray, 0, 1);
        mByteBuffer.rewind();
        return mByteBuffer.get() & 0xff;
    }

    public long readUnsignedInt()
        throws IOException
    {
        return (long)readInt() & 0xffffffffL;
    }

    public int readUnsignedShort()
        throws IOException
    {
        return readShort() & 0xffff;
    }

    public void setByteOrder(ByteOrder byteorder)
    {
        mByteBuffer.order(byteorder);
    }

    public void setEnd(int i)
    {
        mEnd = i;
    }

    public long skip(long l)
        throws IOException
    {
        l = in.skip(l);
        mCount = (int)((long)mCount + l);
        return l;
    }

    public void skipOrThrow(long l)
        throws IOException
    {
        if (skip(l) != l)
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }

    public void skipTo(long l)
        throws IOException
    {
        l -= mCount;
        if (!$assertionsDisabled && l < 0L)
        {
            throw new AssertionError();
        } else
        {
            skipOrThrow(l);
            return;
        }
    }

    static 
    {
        boolean flag;
        if (!it/sephiroth/android/library/exif2/CountedDataInputStream.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
