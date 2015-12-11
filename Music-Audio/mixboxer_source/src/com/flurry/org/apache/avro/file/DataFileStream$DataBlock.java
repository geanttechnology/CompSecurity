// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.file;

import com.flurry.org.apache.avro.io.BinaryEncoder;
import java.io.IOException;
import java.nio.ByteBuffer;

// Referenced classes of package com.flurry.org.apache.avro.file:
//            DataFileStream, Codec

static class numEntries
{

    private int blockSize;
    private byte data[];
    private long numEntries;
    private int offset;

    void compressUsing(Codec codec)
        throws IOException
    {
        codec = codec.compress(getAsByteBuffer());
        data = codec.array();
        blockSize = codec.remaining();
    }

    void decompressUsing(Codec codec)
        throws IOException
    {
        codec = codec.decompress(getAsByteBuffer());
        data = codec.array();
        blockSize = codec.remaining();
    }

    ByteBuffer getAsByteBuffer()
    {
        return ByteBuffer.wrap(data, offset, blockSize);
    }

    int getBlockSize()
    {
        return blockSize;
    }

    byte[] getData()
    {
        return data;
    }

    long getNumEntries()
    {
        return numEntries;
    }

    void writeBlockTo(BinaryEncoder binaryencoder, byte abyte0[])
        throws IOException
    {
        binaryencoder.writeLong(numEntries);
        binaryencoder.writeLong(blockSize);
        binaryencoder.writeFixed(data, offset, blockSize);
        binaryencoder.writeFixed(abyte0);
        binaryencoder.flush();
    }



/*
    static long access$402( , long l)
    {
        .numEntries = l;
        return l;
    }

*/



/*
    static int access$502(numEntries numentries, int i)
    {
        numentries.blockSize = i;
        return i;
    }

*/

    private blockSize(long l, int i)
    {
        offset = 0;
        data = new byte[i];
        numEntries = l;
        blockSize = i;
    }

    blockSize(long l, int i, blockSize blocksize)
    {
        this(l, i);
    }

    <init>(ByteBuffer bytebuffer, long l)
    {
        offset = 0;
        data = bytebuffer.array();
        blockSize = bytebuffer.remaining();
        offset = bytebuffer.arrayOffset() + bytebuffer.position();
        numEntries = l;
    }
}
