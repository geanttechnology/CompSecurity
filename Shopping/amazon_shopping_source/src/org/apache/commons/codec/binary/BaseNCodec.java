// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.codec.binary;


public abstract class BaseNCodec
{

    protected final byte PAD = 61;
    protected byte buffer[];
    private final int chunkSeparatorLength;
    protected int currentLinePos;
    private final int encodedBlockSize;
    protected boolean eof;
    protected final int lineLength;
    protected int modulus;
    protected int pos;
    private int readPos;
    private final int unencodedBlockSize;

    protected BaseNCodec(int i, int j, int k, int l)
    {
        unencodedBlockSize = i;
        encodedBlockSize = j;
        if (k > 0 && l > 0)
        {
            i = (k / j) * j;
        } else
        {
            i = 0;
        }
        lineLength = i;
        chunkSeparatorLength = l;
    }

    private void reset()
    {
        buffer = null;
        pos = 0;
        readPos = 0;
        currentLinePos = 0;
        modulus = 0;
        eof = false;
    }

    private void resizeBuffer()
    {
        if (buffer == null)
        {
            buffer = new byte[getDefaultBufferSize()];
            pos = 0;
            readPos = 0;
            return;
        } else
        {
            byte abyte0[] = new byte[buffer.length * 2];
            System.arraycopy(buffer, 0, abyte0, 0, buffer.length);
            buffer = abyte0;
            return;
        }
    }

    int available()
    {
        if (buffer != null)
        {
            return pos - readPos;
        } else
        {
            return 0;
        }
    }

    protected boolean containsAlphabetOrPad(byte abyte0[])
    {
        if (abyte0 != null)
        {
            int i = 0;
            while (i < abyte0.length) 
            {
                if (61 == abyte0[i] || isInAlphabet(abyte0[i]))
                {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    abstract void decode(byte abyte0[], int i, int j);

    public byte[] decode(byte abyte0[])
    {
        reset();
        if (abyte0 == null || abyte0.length == 0)
        {
            return abyte0;
        } else
        {
            decode(abyte0, 0, abyte0.length);
            decode(abyte0, 0, -1);
            abyte0 = new byte[pos];
            readResults(abyte0, 0, abyte0.length);
            return abyte0;
        }
    }

    abstract void encode(byte abyte0[], int i, int j);

    public byte[] encode(byte abyte0[])
    {
        reset();
        if (abyte0 == null || abyte0.length == 0)
        {
            return abyte0;
        } else
        {
            encode(abyte0, 0, abyte0.length);
            encode(abyte0, 0, -1);
            abyte0 = new byte[pos - readPos];
            readResults(abyte0, 0, abyte0.length);
            return abyte0;
        }
    }

    protected void ensureBufferSize(int i)
    {
        if (buffer == null || buffer.length < pos + i)
        {
            resizeBuffer();
        }
    }

    protected int getDefaultBufferSize()
    {
        return 8192;
    }

    public long getEncodedLength(byte abyte0[])
    {
        long l1 = (long)(((abyte0.length + unencodedBlockSize) - 1) / unencodedBlockSize) * (long)encodedBlockSize;
        long l = l1;
        if (lineLength > 0)
        {
            l = l1 + ((((long)lineLength + l1) - 1L) / (long)lineLength) * (long)chunkSeparatorLength;
        }
        return l;
    }

    protected abstract boolean isInAlphabet(byte byte0);

    int readResults(byte abyte0[], int i, int j)
    {
        if (buffer != null)
        {
            j = Math.min(available(), j);
            System.arraycopy(buffer, readPos, abyte0, i, j);
            readPos = readPos + j;
            if (readPos >= pos)
            {
                buffer = null;
            }
            return j;
        }
        if (eof)
        {
            i = -1;
        } else
        {
            i = 0;
        }
        return i;
    }
}
