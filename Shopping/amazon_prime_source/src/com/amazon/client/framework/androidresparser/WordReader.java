// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.client.framework.androidresparser;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

public class WordReader
{

    public static final int DWORD = 4;
    public static final int HWORD = 1;
    public static final int WORD = 2;
    private boolean mAtEndOfStream;
    private final byte mBuffer[];
    private int mBufferFill;
    private int mBufferOffset;
    private final InputStream mStream;

    public WordReader(InputStream inputstream)
    {
        this(inputstream, 1024);
    }

    public WordReader(InputStream inputstream, int i)
    {
        if (inputstream == null)
        {
            throw new IllegalArgumentException("null stream passed into reader.");
        } else
        {
            mBuffer = new byte[i];
            mBufferOffset = 0;
            mBufferFill = 0;
            mStream = inputstream;
            mAtEndOfStream = false;
            return;
        }
    }

    private final int readBytes(int i)
        throws IOException
    {
        if (i < 0 || i > 4)
        {
            throw new IllegalArgumentException();
        }
        int k = 0;
        for (int j = 0; j != i * 8; j += 8)
        {
            if (mBufferOffset >= mBufferFill)
            {
                readMore();
            }
            if (atEnd())
            {
                throw new EOFException();
            }
            k |= (mBuffer[mBufferOffset] & 0xff) << j;
            mBufferOffset = mBufferOffset + 1;
        }

        return k;
    }

    public static int readBytesFrom(byte abyte0[], int i, int j)
    {
        int l = 0;
        for (int k = 0; k != j * 8; k += 8)
        {
            l |= (abyte0[i] & 0xff) << k;
            i++;
        }

        return l;
    }

    private final void readMore()
        throws IOException
    {
        if (mAtEndOfStream)
        {
            throw new EOFException();
        }
        int i = mStream.read(mBuffer);
        mBufferFill = i;
        if (-1 == i)
        {
            mAtEndOfStream = true;
        }
        mBufferOffset = 0;
    }

    public final boolean atEnd()
    {
        return mAtEndOfStream && mBufferOffset >= mBufferFill;
    }

    public final void close()
        throws IOException
    {
        mStream.close();
    }

    public final int readByte()
        throws IOException
    {
        return readBytes(1) & 0xff;
    }

    public final int readByteArray(byte abyte0[])
        throws IOException
    {
        return readByteArray(abyte0, 0, abyte0.length);
    }

    public final int readByteArray(byte abyte0[], int i, int j)
        throws IOException
    {
        if (j > 0) goto _L2; else goto _L1
_L1:
        int k = 0;
_L4:
        return k;
_L2:
        i = 0;
_L6:
        k = i;
        if (i >= j) goto _L4; else goto _L3
_L3:
        k = i;
        if (atEnd()) goto _L4; else goto _L5
_L5:
        int l = Math.min(j - i, mBufferFill - mBufferOffset);
        if (l > 0)
        {
            System.arraycopy(mBuffer, mBufferOffset, abyte0, i, l);
            i += l;
            mBufferOffset = mBufferOffset + l;
        } else
        {
            readMore();
        }
          goto _L6
    }

    public final int readDWord()
        throws IOException
    {
        return readBytes(4);
    }

    public final int readIntArray(int ai[])
        throws IOException
    {
        return readIntArray(ai, 0, ai.length);
    }

    public final int readIntArray(int ai[], int i, int j)
        throws IOException
    {
        while (j > 0 && !atEnd()) 
        {
            ai[i] = readDWord();
            j--;
            i++;
        }
        return i * 4;
    }

    public final int readWord()
        throws IOException
    {
        return readBytes(2) & 0xffff;
    }

    public final int skip(int i)
        throws IOException
    {
        if (i <= 0)
        {
            i = 0;
        } else
        {
            int k = mBufferFill - (mBufferOffset + i);
            if (k > 0)
            {
                mBufferOffset = mBufferOffset + i;
                return i;
            }
            int j = mBufferFill - mBufferOffset;
            mBufferOffset = 0;
            mBufferFill = 0;
            k = Math.abs(k);
            i = j;
            if (k > 0)
            {
                long l = mStream.skip(k);
                if (l > 0x7fffffffL)
                {
                    throw new IOException("Stream skipped by an invalid amount.");
                }
                i = j;
                if (l > 0L)
                {
                    return j + (int)l;
                }
            }
        }
        return i;
    }
}
