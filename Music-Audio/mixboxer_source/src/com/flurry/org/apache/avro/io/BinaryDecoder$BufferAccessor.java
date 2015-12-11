// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;


// Referenced classes of package com.flurry.org.apache.avro.io:
//            BinaryDecoder

static class <init>
{

    private byte buf[];
    private final BinaryDecoder decoder;
    boolean detached;
    private int limit;
    private int pos;

    void detach()
    {
        buf = BinaryDecoder.access$300(decoder);
        pos = BinaryDecoder.access$400(decoder);
        limit = BinaryDecoder.access$500(decoder);
        detached = true;
    }

    byte[] getBuf()
    {
        if (detached)
        {
            return buf;
        } else
        {
            return BinaryDecoder.access$300(decoder);
        }
    }

    int getLim()
    {
        if (detached)
        {
            return limit;
        } else
        {
            return BinaryDecoder.access$500(decoder);
        }
    }

    int getPos()
    {
        if (detached)
        {
            return pos;
        } else
        {
            return BinaryDecoder.access$400(decoder);
        }
    }

    void setBuf(byte abyte0[], int i, int j)
    {
        if (detached)
        {
            buf = abyte0;
            limit = i + j;
            pos = i;
            return;
        } else
        {
            BinaryDecoder.access$302(decoder, abyte0);
            BinaryDecoder.access$502(decoder, i + j);
            BinaryDecoder.access$402(decoder, i);
            BinaryDecoder.access$602(decoder, i);
            return;
        }
    }

    void setLimit(int i)
    {
        if (detached)
        {
            limit = i;
            return;
        } else
        {
            BinaryDecoder.access$502(decoder, i);
            return;
        }
    }

    void setPos(int i)
    {
        if (detached)
        {
            pos = i;
            return;
        } else
        {
            BinaryDecoder.access$402(decoder, i);
            return;
        }
    }

    private (BinaryDecoder binarydecoder)
    {
        detached = false;
        decoder = binarydecoder;
    }

    decoder(BinaryDecoder binarydecoder, decoder decoder1)
    {
        this(binarydecoder);
    }
}
