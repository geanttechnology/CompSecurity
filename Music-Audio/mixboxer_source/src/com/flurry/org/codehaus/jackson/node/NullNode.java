// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.node;

import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import java.io.IOException;

// Referenced classes of package com.flurry.org.codehaus.jackson.node:
//            ValueNode

public final class NullNode extends ValueNode
{

    public static final NullNode instance = new NullNode();

    private NullNode()
    {
    }

    public static NullNode getInstance()
    {
        return instance;
    }

    public double asDouble(double d)
    {
        return 0.0D;
    }

    public int asInt(int i)
    {
        return 0;
    }

    public long asLong(long l)
    {
        return 0L;
    }

    public String asText()
    {
        return "null";
    }

    public JsonToken asToken()
    {
        return JsonToken.VALUE_NULL;
    }

    public boolean equals(Object obj)
    {
        return obj == this;
    }

    public boolean isNull()
    {
        return true;
    }

    public final void serialize(JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonProcessingException
    {
        jsongenerator.writeNull();
    }

}
