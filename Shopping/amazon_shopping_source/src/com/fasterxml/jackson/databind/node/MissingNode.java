// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.node;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;

// Referenced classes of package com.fasterxml.jackson.databind.node:
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

    public String asText()
    {
        return "";
    }

    public boolean equals(Object obj)
    {
        return obj == this;
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
