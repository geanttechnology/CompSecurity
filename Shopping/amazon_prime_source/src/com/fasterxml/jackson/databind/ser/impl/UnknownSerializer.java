// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser.impl;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import java.io.IOException;
import java.lang.reflect.Type;

public class UnknownSerializer extends StdSerializer
{

    public UnknownSerializer()
    {
        super(java/lang/Object);
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonformatvisitorwrapper, JavaType javatype)
    {
        jsonformatvisitorwrapper.expectAnyFormat(javatype);
    }

    protected void failForEmpty(Object obj)
        throws JsonMappingException
    {
        throw new JsonMappingException((new StringBuilder()).append("No serializer found for class ").append(obj.getClass().getName()).append(" and no properties discovered to create BeanSerializer (to avoid exception, disable SerializationConfig.SerializationFeature.FAIL_ON_EMPTY_BEANS) )").toString());
    }

    public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
        throws JsonMappingException
    {
        return null;
    }

    public void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonMappingException
    {
        if (serializerprovider.isEnabled(SerializationFeature.FAIL_ON_EMPTY_BEANS))
        {
            failForEmpty(obj);
        }
        jsongenerator.writeStartObject();
        jsongenerator.writeEndObject();
    }

    public final void serializeWithType(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider, TypeSerializer typeserializer)
        throws IOException, JsonGenerationException
    {
        if (serializerprovider.isEnabled(SerializationFeature.FAIL_ON_EMPTY_BEANS))
        {
            failForEmpty(obj);
        }
        typeserializer.writeTypePrefixForObject(obj, jsongenerator);
        typeserializer.writeTypeSuffixForObject(obj, jsongenerator);
    }
}
