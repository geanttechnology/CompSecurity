// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            BinaryDecoder

static abstract class sor extends InputStream
{

    protected sor ba;

    protected void attach(int i, BinaryDecoder binarydecoder)
    {
        BinaryDecoder.access$302(binarydecoder, new byte[i]);
        BinaryDecoder.access$402(binarydecoder, 0);
        BinaryDecoder.access$602(binarydecoder, 0);
        BinaryDecoder.access$502(binarydecoder, 0);
        ba = new sor(binarydecoder, null);
    }

    public int available()
        throws IOException
    {
        return ba.getLim() - ba.getPos();
    }

    protected void compactAndFill(byte abyte0[], int i, int j, int k)
        throws IOException
    {
        System.arraycopy(abyte0, i, abyte0, j, k);
        ba.setPos(j);
        i = tryReadRaw(abyte0, j + k, abyte0.length - k);
        ba.setLimit(k + i);
    }

    protected void detach()
    {
        ba.detach();
    }

    abstract boolean isEof();

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        int l = ba.getLim();
        int k = ba.getPos();
        byte abyte1[] = ba.getBuf();
        l -= k;
        if (l >= j)
        {
            System.arraycopy(abyte1, k, abyte0, i, j);
            ba.setPos(k + j);
            return j;
        }
        System.arraycopy(abyte1, k, abyte0, i, l);
        ba.setPos(k + l);
        i = l + tryReadRaw(abyte0, i + l, j - l);
        if (i == 0)
        {
            return -1;
        } else
        {
            return i;
        }
    }

    protected abstract void readRaw(byte abyte0[], int i, int j)
        throws IOException;

    public long skip(long l)
        throws IOException
    {
        int i = ba.getLim();
        int j = ba.getPos();
        int k = i - j;
        if ((long)k > l)
        {
            i = (int)((long)j + l);
            ba.setPos(i);
            return l;
        } else
        {
            ba.setPos(i);
            return trySkipBytes(l - (long)k) + (long)k;
        }
    }

    protected abstract void skipSourceBytes(long l)
        throws IOException;

    protected abstract int tryReadRaw(byte abyte0[], int i, int j)
        throws IOException;

    protected abstract long trySkipBytes(long l)
        throws IOException;

    protected sor()
    {
    }
}
