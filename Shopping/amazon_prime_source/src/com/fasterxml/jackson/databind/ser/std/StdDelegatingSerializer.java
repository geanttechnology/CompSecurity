// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitable;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsonschema.SchemaAware;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.ser.ContextualSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;
import java.io.IOException;
import java.lang.reflect.Type;

// Referenced classes of package com.fasterxml.jackson.databind.ser.std:
//            StdSerializer

public class StdDelegatingSerializer extends StdSerializer
    implements JsonFormatVisitable, SchemaAware, ContextualSerializer
{

    protected final Converter _converter;
    protected final JsonSerializer _delegateSerializer;
    protected final JavaType _delegateType;

    public StdDelegatingSerializer(Converter converter)
    {
        super(java/lang/Object);
        _converter = converter;
        _delegateType = null;
        _delegateSerializer = null;
    }

    protected StdDelegatingSerializer(Converter converter, JavaType javatype, JsonSerializer jsonserializer)
    {
        super(javatype);
        _converter = converter;
        _delegateType = javatype;
        _delegateSerializer = jsonserializer;
    }

    public StdDelegatingSerializer(Class class1, Converter converter)
    {
        super(class1, false);
        _converter = converter;
        _delegateType = null;
        _delegateSerializer = null;
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonformatvisitorwrapper, JavaType javatype)
        throws JsonMappingException
    {
        _delegateSerializer.acceptJsonFormatVisitor(jsonformatvisitorwrapper, javatype);
    }

    protected Object convertValue(Object obj)
    {
        return _converter.convert(obj);
    }

    public JsonSerializer createContextual(SerializerProvider serializerprovider, BeanProperty beanproperty)
        throws JsonMappingException
    {
        TypeFactory typefactory = serializerprovider.getTypeFactory();
        JavaType javatype = typefactory.constructType(_converter.getClass());
        JavaType ajavatype[] = typefactory.findTypeParameters(javatype, com/fasterxml/jackson/databind/util/Converter);
        if (ajavatype == null || ajavatype.length != 2)
        {
            throw new JsonMappingException((new StringBuilder()).append("Could not determine Converter parameterization for ").append(javatype).toString());
        } else
        {
            JavaType javatype1 = ajavatype[1];
            return withDelegate(_converter, javatype1, serializerprovider.findValueSerializer(javatype1, beanproperty));
        }
    }

    protected Converter getConverter()
    {
        return _converter;
    }

    public JsonSerializer getDelegatee()
    {
        return _delegateSerializer;
    }

    public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
        throws JsonMappingException
    {
        if (_delegateSerializer instanceof SchemaAware)
        {
            return ((SchemaAware)_delegateSerializer).getSchema(serializerprovider, type);
        } else
        {
            return super.getSchema(serializerprovider, type);
        }
    }

    public JsonNode getSchema(SerializerProvider serializerprovider, Type type, boolean flag)
        throws JsonMappingException
    {
        if (_delegateSerializer instanceof SchemaAware)
        {
            return ((SchemaAware)_delegateSerializer).getSchema(serializerprovider, type, flag);
        } else
        {
            return super.getSchema(serializerprovider, type);
        }
    }

    public boolean isEmpty(Object obj)
    {
        obj = convertValue(obj);
        return _delegateSerializer.isEmpty(obj);
    }

    public void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonProcessingException
    {
        obj = convertValue(obj);
        if (obj == null)
        {
            serializerprovider.defaultSerializeNull(jsongenerator);
            return;
        } else
        {
            _delegateSerializer.serialize(obj, jsongenerator, serializerprovider);
            return;
        }
    }

    public void serializeWithType(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider, TypeSerializer typeserializer)
        throws IOException, JsonProcessingException
    {
        obj = convertValue(obj);
        _delegateSerializer.serializeWithType(obj, jsongenerator, serializerprovider, typeserializer);
    }

    protected StdDelegatingSerializer withDelegate(Converter converter, JavaType javatype, JsonSerializer jsonserializer)
    {
        if (getClass() != com/fasterxml/jackson/databind/ser/std/StdDelegatingSerializer)
        {
            throw new IllegalStateException((new StringBuilder()).append("Sub-class ").append(getClass().getName()).append(" must override 'withDelegate'").toString());
        } else
        {
            return new StdDelegatingSerializer(converter, javatype, jsonserializer);
        }
    }
}
