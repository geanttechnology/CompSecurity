// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.node;

import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonNode;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import com.flurry.org.codehaus.jackson.map.TypeSerializer;
import java.io.IOException;

// Referenced classes of package com.flurry.org.codehaus.jackson.node:
//            BaseJsonNode

public final class MissingNode extends BaseJsonNode
{

    private static final MissingNode instance = new MissingNode();

    private MissingNode()
    {
    }

    public static MissingNode getInstance()
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
        return "";
    }

    public JsonToken asToken()
    {
        return JsonToken.NOT_AVAILABLE;
    }

    public boolean equals(Object obj)
    {
        return obj == this;
    }

    public boolean isMissingNode()
    {
        return true;
    }

    public JsonNode path(int i)
    {
        return this;
    }

    public JsonNode path(String s)
    {
        return this;
    }

    public final void serialize(JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonProcessingException
    {
        jsongenerator.writeNull();
    }

    public void serializeWithType(JsonGenerator jsongenerator, SerializerProvider serializerprovider, TypeSerializer typeserializer)
        throws IOException, JsonProcessingException
    {
        jsongenerator.writeNull();
    }

    public String toString()
    {
        return "";
    }

}
