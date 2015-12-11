// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.ser.ContainerSerializer;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;
import java.lang.reflect.Type;

// Referenced classes of package com.fasterxml.jackson.databind.ser.std:
//            StdArraySerializers

public static final class rializer extends rializer
{

    private static final JavaType VALUE_TYPE;

    public ContainerSerializer _withValueTypeSerializer(TypeSerializer typeserializer)
    {
        return new <init>(this, _property, typeserializer);
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonformatvisitorwrapper, JavaType javatype)
    {
        jsonformatvisitorwrapper.expectArrayFormat(javatype).itemsFormat(JsonFormatTypes.NUMBER);
    }

    public JsonSerializer getContentSerializer()
    {
        return null;
    }

    public JavaType getContentType()
    {
        return VALUE_TYPE;
    }

    public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
    {
        serializerprovider = createSchemaNode("array", true);
        serializerprovider.put("items", createSchemaNode("number"));
        return serializerprovider;
    }

    public volatile boolean hasSingleElement(Object obj)
    {
        return hasSingleElement((float[])obj);
    }

    public boolean hasSingleElement(float af[])
    {
        return af.length == 1;
    }

    public volatile boolean isEmpty(Object obj)
    {
        return isEmpty((float[])obj);
    }

    public boolean isEmpty(float af[])
    {
        return af == null || af.length == 0;
    }

    public volatile void serializeContents(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        serializeContents((float[])obj, jsongenerator, serializerprovider);
    }

    public void serializeContents(float af[], JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        if (_valueTypeSerializer != null)
        {
            int i = 0;
            for (int k = af.length; i < k; i++)
            {
                _valueTypeSerializer.writeTypePrefixForScalar(null, jsongenerator, Float.TYPE);
                jsongenerator.writeNumber(af[i]);
                _valueTypeSerializer.writeTypeSuffixForScalar(null, jsongenerator);
            }

        } else
        {
            int j = 0;
            for (int l = af.length; j < l; j++)
            {
                jsongenerator.writeNumber(af[j]);
            }

        }
    }

    static 
    {
        VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Float.TYPE);
    }

    public rializer()
    {
        super([F);
    }

    public rializer(rializer rializer, BeanProperty beanproperty, TypeSerializer typeserializer)
    {
        super(rializer, beanproperty, typeserializer);
    }
}
