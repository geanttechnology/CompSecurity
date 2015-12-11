// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.type.TypeFactory;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

public class ObjectMapperWrapper
{

    private ObjectMapper mapper;

    public ObjectMapperWrapper()
    {
        mapper = new ObjectMapper();
        mapper.enable(new org.codehaus.jackson.map.DeserializationConfig.Feature[] {
            org.codehaus.jackson.map.DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY
        });
    }

    public ObjectMapperWrapper(ObjectMapper objectmapper)
    {
        mapper = objectmapper;
    }

    public TypeFactory getTypeFactory()
    {
        return mapper.getTypeFactory();
    }

    public Object readValue(InputStream inputstream, Class class1)
        throws IOException, JsonParseException, JsonMappingException
    {
        return mapper.readValue(inputstream, class1);
    }

    public Object readValue(InputStream inputstream, TypeReference typereference)
        throws IOException, JsonParseException, JsonMappingException
    {
        return mapper.readValue(inputstream, typereference);
    }

    public Object readValue(Reader reader, Class class1)
        throws IOException, JsonParseException, JsonMappingException
    {
        return mapper.readValue(reader, class1);
    }

    public Object readValue(String s, Class class1)
        throws IOException, JsonParseException, JsonMappingException
    {
        return mapper.readValue(s, class1);
    }

    public Object readValue(String s, JavaType javatype)
        throws IOException, JsonParseException, JsonMappingException
    {
        return mapper.readValue(s, javatype);
    }

    public Object readValue(String s, TypeReference typereference)
        throws IOException, JsonParseException, JsonMappingException
    {
        return mapper.readValue(s, typereference);
    }

    public Object readValue(JsonParser jsonparser, Class class1)
        throws IOException, JsonParseException, JsonMappingException
    {
        return mapper.readValue(jsonparser, class1);
    }

    public Object readValue(byte abyte0[], TypeReference typereference)
        throws IOException, JsonMappingException
    {
        return mapper.readValue(abyte0, typereference);
    }

    public String writeValueAsString(Object obj)
        throws IOException, JsonGenerationException, JsonMappingException
    {
        return mapper.writeValueAsString(obj);
    }
}
