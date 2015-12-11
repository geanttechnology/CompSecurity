// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
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
//            ArraySerializerBase, StdArraySerializers

public static final class  extends ArraySerializerBase
{

    private static final JavaType VALUE_TYPE;

    public ContainerSerializer _withValueTypeSerializer(TypeSerializer typeserializer)
    {
        return this;
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonformatvisitorwrapper, JavaType javatype)
    {
        jsonformatvisitorwrapper.expectArrayFormat(javatype).itemsFormat(JsonFormatTypes.INTEGER);
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
        serializerprovider.put("items", createSchemaNode("integer"));
        return serializerprovider;
    }

    public volatile boolean hasSingleElement(Object obj)
    {
        return hasSingleElement((int[])obj);
    }

    public boolean hasSingleElement(int ai[])
    {
        return ai.length == 1;
    }

    public volatile boolean isEmpty(Object obj)
    {
        return isEmpty((int[])obj);
    }

    public boolean isEmpty(int ai[])
    {
        return ai == null || ai.length == 0;
    }

    public volatile void serializeContents(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        serializeContents((int[])obj, jsongenerator, serializerprovider);
    }

    public void serializeContents(int ai[], JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        int i = 0;
        for (int j = ai.length; i < j; i++)
        {
            jsongenerator.writeNumber(ai[i]);
        }

    }

    static 
    {
        VALUE_TYPE = TypeFactory.defaultInstance().uncheckedSimpleType(Integer.TYPE);
    }

    public ()
    {
        super([I, null);
    }
}
