// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.serialize;

import com.amazon.org.codehaus.jackson.JsonParser;
import com.amazon.org.codehaus.jackson.JsonProcessingException;
import com.amazon.org.codehaus.jackson.JsonToken;
import com.amazon.org.codehaus.jackson.map.DeserializationContext;
import com.amazon.org.codehaus.jackson.map.JsonDeserializer;
import com.amazon.org.codehaus.jackson.map.JsonMappingException;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferJsonDeserializer extends JsonDeserializer
{

    public ByteBufferJsonDeserializer()
    {
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }

    public ByteBuffer deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (JsonToken.VALUE_STRING == jsontoken)
        {
            return ByteBuffer.wrap(jsonparser.getBinaryValue(deserializationcontext.getBase64Variant()));
        } else
        {
            throw new JsonMappingException((new StringBuilder()).append("Unexpected token: ").append(jsontoken).toString(), jsonparser.getCurrentLocation());
        }
    }
}
