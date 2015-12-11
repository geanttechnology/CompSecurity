// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.file;

import com.flurry.org.apache.avro.AvroRuntimeException;
import java.util.HashMap;
import java.util.Map;

// Referenced classes of package com.flurry.org.apache.avro.file:
//            NullCodec, Codec

public abstract class CodecFactory
{

    private static final int DEFAULT_DEFLATE_LEVEL = -1;
    private static final Map REGISTERED = new HashMap();

    public CodecFactory()
    {
    }

    public static CodecFactory addCodec(String s, CodecFactory codecfactory)
    {
        return (CodecFactory)REGISTERED.put(s, codecfactory);
    }

    public static CodecFactory deflateCodec(int i)
    {
        return new DeflateCodec.Option(i);
    }

    public static CodecFactory fromString(String s)
    {
        CodecFactory codecfactory = (CodecFactory)REGISTERED.get(s);
        if (codecfactory == null)
        {
            throw new AvroRuntimeException((new StringBuilder()).append("Unrecognized codec: ").append(s).toString());
        } else
        {
            return codecfactory;
        }
    }

    public static CodecFactory nullCodec()
    {
        return NullCodec.OPTION;
    }

    public static CodecFactory snappyCodec()
    {
        return new SnappyCodec.Option();
    }

    protected abstract Codec createInstance();

    public String toString()
    {
        return createInstance().toString();
    }

    static 
    {
        addCodec("null", nullCodec());
        addCodec("deflate", deflateCodec(-1));
        addCodec("snappy", snappyCodec());
    }
}
