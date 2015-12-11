// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import java.io.EOFException;
import java.io.IOException;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            BinaryDecoder

private static class <init> extends <init>
{

    private boolean compacted;
    private byte data[];
    private int max;
    private int position;

    protected void attach(int i, BinaryDecoder binarydecoder)
    {
        BinaryDecoder.access$302(binarydecoder, data);
        BinaryDecoder.access$402(binarydecoder, position);
        BinaryDecoder.access$602(binarydecoder, position);
        BinaryDecoder.access$502(binarydecoder, max);
        ba = new >(binarydecoder, null);
    }

    public void close()
        throws IOException
    {
        ba.s(ba.m());
    }

    protected void compactAndFill(byte abyte0[], int i, int j, int k)
        throws IOException
    {
        if (!compacted)
        {
            byte abyte1[] = new byte[k + 16];
            System.arraycopy(abyte0, i, abyte1, 0, k);
            ba.f(abyte1, 0, k);
            compacted = true;
        }
    }

    public boolean isEof()
    {
        return ba.m() - ba.s() == 0;
    }

    public int read()
        throws IOException
    {
        max = ba.m();
        position = ba.s();
        if (position >= max)
        {
            return -1;
        } else
        {
            byte abyte0[] = ba.f();
            int i = position;
            position = i + 1;
            i = abyte0[i];
            ba.s(position);
            return i & 0xff;
        }
    }

    protected void readRaw(byte abyte0[], int i, int j)
        throws IOException
    {
        if (tryReadRaw(abyte0, i, j) < j)
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }

    protected void skipSourceBytes(long l)
        throws IOException
    {
        if (trySkipBytes(l) < l)
        {
            throw new EOFException();
        } else
        {
            return;
        }
    }

    protected int tryReadRaw(byte abyte0[], int i, int j)
        throws IOException
    {
        return 0;
    }

    protected long trySkipBytes(long l)
        throws IOException
    {
        max = ba.m();
        position = ba.s();
        long l1 = max - position;
        if (l1 >= l)
        {
            position = (int)((long)position + l);
            ba.s(position);
            return l;
        } else
        {
            position = (int)((long)position + l1);
            ba.s(position);
            return l1;
        }
    }

    private (byte abyte0[], int i, int j)
    {
        compacted = false;
        if (abyte0.length < 16 || j < 16)
        {
            data = new byte[16];
            System.arraycopy(abyte0, i, data, 0, j);
            position = 0;
            max = j;
            return;
        } else
        {
            data = abyte0;
            position = i;
            max = i + j;
            return;
        }
    }

    max(byte abyte0[], int i, int j, max max1)
    {
        this(abyte0, i, j);
    }
}
