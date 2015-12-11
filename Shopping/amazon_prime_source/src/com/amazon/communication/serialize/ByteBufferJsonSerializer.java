// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.serialize;

import com.amazon.org.codehaus.jackson.JsonGenerator;
import com.amazon.org.codehaus.jackson.JsonProcessingException;
import com.amazon.org.codehaus.jackson.map.JsonSerializer;
import com.amazon.org.codehaus.jackson.map.SerializerProvider;
import java.io.IOException;
import java.nio.ByteBuffer;

public class ByteBufferJsonSerializer extends JsonSerializer
{

    private static final JsonSerializer sByteArraySerializer = new com.amazon.org.codehaus.jackson.map.ser.std.StdArraySerializers.ByteArraySerializer();

    public ByteBufferJsonSerializer()
    {
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonProcessingException
    {
        serialize((ByteBuffer)obj, jsongenerator, serializerprovider);
    }

    public void serialize(ByteBuffer bytebuffer, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonProcessingException
    {
        sByteArraySerializer.serialize(bytebuffer.array(), jsongenerator, serializerprovider);
    }

}
