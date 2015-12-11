// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.AvroRuntimeException;
import com.flurry.org.apache.avro.Schema;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            BufferedBinaryEncoder, BlockingBinaryEncoder, DirectBinaryEncoder, JsonEncoder, 
//            ValidatingEncoder, BinaryEncoder, Encoder

public class EncoderFactory
{
    private static class DefaultEncoderFactory extends EncoderFactory
    {

        public EncoderFactory configureBlockSize(int i)
        {
            throw new AvroRuntimeException("Default EncoderFactory cannot be configured");
        }

        public EncoderFactory configureBufferSize(int i)
        {
            throw new AvroRuntimeException("Default EncoderFactory cannot be configured");
        }

        private DefaultEncoderFactory()
        {
        }

    }


    private static final int DEFAULT_BLOCK_BUFFER_SIZE = 0x10000;
    private static final int DEFAULT_BUFFER_SIZE = 2048;
    private static final EncoderFactory DEFAULT_FACTORY = new DefaultEncoderFactory();
    private static final int MAX_BLOCK_BUFFER_SIZE = 0x40000000;
    private static final int MIN_BLOCK_BUFFER_SIZE = 64;
    protected int binaryBlockSize;
    protected int binaryBufferSize;

    public EncoderFactory()
    {
        binaryBufferSize = 2048;
        binaryBlockSize = 0x10000;
    }

    public static EncoderFactory get()
    {
        return DEFAULT_FACTORY;
    }

    public BinaryEncoder binaryEncoder(OutputStream outputstream, BinaryEncoder binaryencoder)
    {
        if (binaryencoder == null || !binaryencoder.getClass().equals(com/flurry/org/apache/avro/io/BufferedBinaryEncoder))
        {
            return new BufferedBinaryEncoder(outputstream, binaryBufferSize);
        } else
        {
            return ((BufferedBinaryEncoder)binaryencoder).configure(outputstream, binaryBufferSize);
        }
    }

    public BinaryEncoder blockingBinaryEncoder(OutputStream outputstream, BinaryEncoder binaryencoder)
    {
        if (binaryencoder == null || !binaryencoder.getClass().equals(com/flurry/org/apache/avro/io/BlockingBinaryEncoder))
        {
            return new BlockingBinaryEncoder(outputstream, binaryBlockSize, 32);
        } else
        {
            return ((BlockingBinaryEncoder)binaryencoder).configure(outputstream, binaryBlockSize, 32);
        }
    }

    public EncoderFactory configureBlockSize(int i)
    {
        int j = i;
        if (i < 64)
        {
            j = 64;
        }
        i = j;
        if (j > 0x40000000)
        {
            i = 0x40000000;
        }
        binaryBufferSize = i;
        return this;
    }

    public EncoderFactory configureBufferSize(int i)
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
        binaryBufferSize = i;
        return this;
    }

    public BinaryEncoder directBinaryEncoder(OutputStream outputstream, BinaryEncoder binaryencoder)
    {
        if (binaryencoder == null || !binaryencoder.getClass().equals(com/flurry/org/apache/avro/io/DirectBinaryEncoder))
        {
            return new DirectBinaryEncoder(outputstream);
        } else
        {
            return ((DirectBinaryEncoder)binaryencoder).configure(outputstream);
        }
    }

    public int getBlockSize()
    {
        return binaryBlockSize;
    }

    public int getBufferSize()
    {
        return binaryBufferSize;
    }

    public JsonEncoder jsonEncoder(Schema schema, JsonGenerator jsongenerator)
        throws IOException
    {
        return new JsonEncoder(schema, jsongenerator);
    }

    public JsonEncoder jsonEncoder(Schema schema, OutputStream outputstream)
        throws IOException
    {
        return new JsonEncoder(schema, outputstream);
    }

    public ValidatingEncoder validatingEncoder(Schema schema, Encoder encoder)
        throws IOException
    {
        return new ValidatingEncoder(schema, encoder);
    }

}
