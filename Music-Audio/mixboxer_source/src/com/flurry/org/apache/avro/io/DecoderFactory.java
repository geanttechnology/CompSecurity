// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.Schema;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            BinaryDecoder, DirectBinaryDecoder, JsonDecoder, ResolvingDecoder, 
//            ValidatingDecoder, Decoder

public class DecoderFactory
{
    private static class DefaultDecoderFactory extends DecoderFactory
    {

        public DecoderFactory configureDecoderBufferSize(int i)
        {
            throw new IllegalArgumentException("This Factory instance is Immutable");
        }

        private DefaultDecoderFactory()
        {
        }

    }


    static final int DEFAULT_BUFFER_SIZE = 8192;
    private static final DecoderFactory DEFAULT_FACTORY = new DefaultDecoderFactory();
    int binaryDecoderBufferSize;

    public DecoderFactory()
    {
        binaryDecoderBufferSize = 8192;
    }

    public static DecoderFactory defaultFactory()
    {
        return get();
    }

    public static DecoderFactory get()
    {
        return DEFAULT_FACTORY;
    }

    public BinaryDecoder binaryDecoder(InputStream inputstream, BinaryDecoder binarydecoder)
    {
        if (binarydecoder == null || !binarydecoder.getClass().equals(com/flurry/org/apache/avro/io/BinaryDecoder))
        {
            return new BinaryDecoder(inputstream, binaryDecoderBufferSize);
        } else
        {
            return binarydecoder.configure(inputstream, binaryDecoderBufferSize);
        }
    }

    public BinaryDecoder binaryDecoder(byte abyte0[], int i, int j, BinaryDecoder binarydecoder)
    {
        if (binarydecoder == null || !binarydecoder.getClass().equals(com/flurry/org/apache/avro/io/BinaryDecoder))
        {
            return new BinaryDecoder(abyte0, i, j);
        } else
        {
            return binarydecoder.configure(abyte0, i, j);
        }
    }

    public BinaryDecoder binaryDecoder(byte abyte0[], BinaryDecoder binarydecoder)
    {
        return binaryDecoder(abyte0, 0, abyte0.length, binarydecoder);
    }

    public DecoderFactory configureDecoderBufferSize(int i)
    {
        int j = i;
        if (i < 32)
        {
            j = 32;
        }
        i = j;
        if (j > 0x1000000)
        {
            i = 0x1000000;
        }
        binaryDecoderBufferSize = i;
        return this;
    }

    public BinaryDecoder createBinaryDecoder(InputStream inputstream, BinaryDecoder binarydecoder)
    {
        return binaryDecoder(inputstream, binarydecoder);
    }

    public BinaryDecoder createBinaryDecoder(byte abyte0[], int i, int j, BinaryDecoder binarydecoder)
    {
        if (binarydecoder == null || !binarydecoder.getClass().equals(com/flurry/org/apache/avro/io/BinaryDecoder))
        {
            return new BinaryDecoder(abyte0, i, j);
        } else
        {
            return binarydecoder.configure(abyte0, i, j);
        }
    }

    public BinaryDecoder createBinaryDecoder(byte abyte0[], BinaryDecoder binarydecoder)
    {
        return binaryDecoder(abyte0, 0, abyte0.length, binarydecoder);
    }

    public BinaryDecoder directBinaryDecoder(InputStream inputstream, BinaryDecoder binarydecoder)
    {
        if (binarydecoder == null || !binarydecoder.getClass().equals(com/flurry/org/apache/avro/io/DirectBinaryDecoder))
        {
            return new DirectBinaryDecoder(inputstream);
        } else
        {
            return ((DirectBinaryDecoder)binarydecoder).configure(inputstream);
        }
    }

    public int getConfiguredBufferSize()
    {
        return binaryDecoderBufferSize;
    }

    public JsonDecoder jsonDecoder(Schema schema, InputStream inputstream)
        throws IOException
    {
        return new JsonDecoder(schema, inputstream);
    }

    public JsonDecoder jsonDecoder(Schema schema, String s)
        throws IOException
    {
        return new JsonDecoder(schema, s);
    }

    public ResolvingDecoder resolvingDecoder(Schema schema, Schema schema1, Decoder decoder)
        throws IOException
    {
        return new ResolvingDecoder(schema, schema1, decoder);
    }

    public ValidatingDecoder validatingDecoder(Schema schema, Decoder decoder)
        throws IOException
    {
        return new ValidatingDecoder(schema, decoder);
    }

}
