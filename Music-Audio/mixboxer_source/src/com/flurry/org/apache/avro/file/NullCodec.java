// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.file;

import java.io.IOException;
import java.nio.ByteBuffer;

// Referenced classes of package com.flurry.org.apache.avro.file:
//            Codec, CodecFactory

final class NullCodec extends Codec
{
    static class Option extends CodecFactory
    {

        protected Codec createInstance()
        {
            return NullCodec.INSTANCE;
        }

        Option()
        {
        }
    }


    private static final NullCodec INSTANCE = new NullCodec();
    public static final CodecFactory OPTION = new Option();

    NullCodec()
    {
    }

    ByteBuffer compress(ByteBuffer bytebuffer)
        throws IOException
    {
        return bytebuffer;
    }

    ByteBuffer decompress(ByteBuffer bytebuffer)
        throws IOException
    {
        return bytebuffer;
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
        return "null";
    }

    public int hashCode()
    {
        return 2;
    }


}
