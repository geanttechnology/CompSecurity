// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.file;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.zip.CRC32;
import org.xerial.snappy.Snappy;

// Referenced classes of package com.flurry.org.apache.avro.file:
//            Codec, CodecFactory

class SnappyCodec extends Codec
{
    static class Option extends CodecFactory
    {

        protected Codec createInstance()
        {
            return new SnappyCodec();
        }

        Option()
        {
        }
    }


    private CRC32 crc32;

    private SnappyCodec()
    {
        crc32 = new CRC32();
    }


    ByteBuffer compress(ByteBuffer bytebuffer)
        throws IOException
    {
        ByteBuffer bytebuffer1 = ByteBuffer.allocate(Snappy.maxCompressedLength(bytebuffer.remaining()) + 4);
        int i = Snappy.compress(bytebuffer.array(), bytebuffer.position(), bytebuffer.remaining(), bytebuffer1.array(), 0);
        crc32.reset();
        crc32.update(bytebuffer.array(), bytebuffer.position(), bytebuffer.remaining());
        bytebuffer1.putInt(i, (int)crc32.getValue());
        bytebuffer1.limit(i + 4);
        return bytebuffer1;
    }

    ByteBuffer decompress(ByteBuffer bytebuffer)
        throws IOException
    {
        ByteBuffer bytebuffer1 = ByteBuffer.allocate(Snappy.uncompressedLength(bytebuffer.array(), bytebuffer.position(), bytebuffer.remaining() - 4));
        int i = Snappy.uncompress(bytebuffer.array(), bytebuffer.position(), bytebuffer.remaining() - 4, bytebuffer1.array(), 0);
        bytebuffer1.limit(i);
        crc32.reset();
        crc32.update(bytebuffer1.array(), 0, i);
        if (bytebuffer.getInt(bytebuffer.limit() - 4) != (int)crc32.getValue())
        {
            throw new IOException("Checksum failure");
        } else
        {
            return bytebuffer1;
        }
    }

    public boolean equals(Object obj)
    {
        while (this == obj || getClass() == obj.getClass()) 
        {
            return true;
        }
        return false;
    }

    String getName()
    {
        return "snappy";
    }

    public int hashCode()
    {
        return getName().hashCode();
    }
}
