// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.file;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;
import java.util.zip.InflaterOutputStream;

// Referenced classes of package com.flurry.org.apache.avro.file:
//            Codec, CodecFactory

class DeflateCodec extends Codec
{
    static class Option extends CodecFactory
    {

        private int compressionLevel;

        protected Codec createInstance()
        {
            return new DeflateCodec(compressionLevel);
        }

        Option(int i)
        {
            compressionLevel = i;
        }
    }


    private int compressionLevel;
    private Deflater deflater;
    private Inflater inflater;
    private boolean nowrap;
    private ByteArrayOutputStream outputBuffer;

    public DeflateCodec(int i)
    {
        nowrap = true;
        compressionLevel = i;
    }

    private Deflater getDeflater()
    {
        if (deflater == null)
        {
            deflater = new Deflater(compressionLevel, nowrap);
        }
        deflater.reset();
        return deflater;
    }

    private Inflater getInflater()
    {
        if (inflater == null)
        {
            inflater = new Inflater(nowrap);
        }
        inflater.reset();
        return inflater;
    }

    private ByteArrayOutputStream getOutputBuffer(int i)
    {
        if (outputBuffer == null)
        {
            outputBuffer = new ByteArrayOutputStream(i);
        }
        outputBuffer.reset();
        return outputBuffer;
    }

    private void writeAndClose(ByteBuffer bytebuffer, OutputStream outputstream)
        throws IOException
    {
        byte abyte0[];
        int i;
        int j;
        int k;
        abyte0 = bytebuffer.array();
        i = bytebuffer.arrayOffset();
        j = bytebuffer.position();
        k = bytebuffer.remaining();
        outputstream.write(abyte0, i + j, k);
        outputstream.close();
        return;
        bytebuffer;
        outputstream.close();
        throw bytebuffer;
    }

    ByteBuffer compress(ByteBuffer bytebuffer)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = getOutputBuffer(bytebuffer.remaining());
        writeAndClose(bytebuffer, new DeflaterOutputStream(bytearrayoutputstream, getDeflater()));
        return ByteBuffer.wrap(bytearrayoutputstream.toByteArray());
    }

    ByteBuffer decompress(ByteBuffer bytebuffer)
        throws IOException
    {
        ByteArrayOutputStream bytearrayoutputstream = getOutputBuffer(bytebuffer.remaining());
        writeAndClose(bytebuffer, new InflaterOutputStream(bytearrayoutputstream, getInflater()));
        return ByteBuffer.wrap(bytearrayoutputstream.toByteArray());
    }

    public boolean equals(Object obj)
    {
        if (this != obj)
        {
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (DeflateCodec)obj;
            if (nowrap != ((DeflateCodec) (obj)).nowrap)
            {
                return false;
            }
        }
        return true;
    }

    String getName()
    {
        return "deflate";
    }

    public int hashCode()
    {
        return !nowrap ? 1 : 0;
    }

    public String toString()
    {
        return (new StringBuilder()).append(getName()).append("-").append(compressionLevel).toString();
    }
}
