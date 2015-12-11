// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.ser.impl;

import com.flurry.org.codehaus.jackson.JsonGenerationException;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonNode;
import com.flurry.org.codehaus.jackson.map.JsonMappingException;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import com.flurry.org.codehaus.jackson.map.TypeSerializer;
import com.flurry.org.codehaus.jackson.map.ser.std.SerializerBase;
import java.io.IOException;
import java.lang.reflect.Type;

public class UnknownSerializer extends SerializerBase
{

    public UnknownSerializer()
    {
        super(java/lang/Object);
    }

    protected void failForEmpty(Object obj)
        throws JsonMappingException
    {
        throw new JsonMappingException((new StringBuilder()).append("No serializer found for class ").append(obj.getClass().getName()).append(" and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS) )").toString());
    }

    public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
        throws JsonMappingException
    {
        return null;
    }

    public void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonMappingException
    {
        if (serializerprovider.isEnabled(com.flurry.org.codehaus.jackson.map.SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS))
        {
            failForEmpty(obj);
        }
        jsongenerator.writeStartObject();
        jsongenerator.writeEndObject();
    }

    public final void serializeWithType(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider, TypeSerializer typeserializer)
        throws IOException, JsonGenerationException
    {
        if (serializerprovider.isEnabled(com.flurry.org.codehaus.jackson.map.SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS))
        {
            failForEmpty(obj);
        }
        typeserializer.writeTypePrefixForObject(obj, jsongenerator);
        typeserializer.writeTypeSuffixForObject(obj, jsongenerator);
    }
}
