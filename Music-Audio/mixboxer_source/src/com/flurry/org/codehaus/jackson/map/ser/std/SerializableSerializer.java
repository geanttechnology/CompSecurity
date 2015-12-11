// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.ser.std;

import com.flurry.org.codehaus.jackson.JsonGenerationException;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonNode;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.map.JsonMappingException;
import com.flurry.org.codehaus.jackson.map.JsonSerializable;
import com.flurry.org.codehaus.jackson.map.JsonSerializableWithType;
import com.flurry.org.codehaus.jackson.map.ObjectMapper;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import com.flurry.org.codehaus.jackson.map.TypeSerializer;
import com.flurry.org.codehaus.jackson.map.ser.SerializerBase;
import com.flurry.org.codehaus.jackson.map.type.TypeFactory;
import com.flurry.org.codehaus.jackson.node.ObjectNode;
import com.flurry.org.codehaus.jackson.schema.JsonSerializableSchema;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.io.IOException;
import java.lang.reflect.Type;

public class SerializableSerializer extends SerializerBase
{

    public static final SerializableSerializer instance = new SerializableSerializer();

    protected SerializableSerializer()
    {
        super(com/flurry/org/codehaus/jackson/map/JsonSerializable);
    }

    public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
        throws JsonMappingException
    {
        ObjectNode objectnode = createObjectNode();
        String s1 = "any";
        Object obj2 = null;
        serializerprovider = null;
        Object obj1 = null;
        String s = obj1;
        SerializerProvider serializerprovider1 = obj2;
        Object obj = s1;
        if (type != null)
        {
            type = TypeFactory.type(type).getRawClass();
            s = obj1;
            serializerprovider1 = obj2;
            obj = s1;
            if (type.isAnnotationPresent(com/flurry/org/codehaus/jackson/schema/JsonSerializableSchema))
            {
                JsonSerializableSchema jsonserializableschema = (JsonSerializableSchema)type.getAnnotation(com/flurry/org/codehaus/jackson/schema/JsonSerializableSchema);
                type = jsonserializableschema.schemaType();
                if (!"##irrelevant".equals(jsonserializableschema.schemaObjectPropertiesDefinition()))
                {
                    serializerprovider = jsonserializableschema.schemaObjectPropertiesDefinition();
                }
                s = obj1;
                serializerprovider1 = serializerprovider;
                obj = type;
                if (!"##irrelevant".equals(jsonserializableschema.schemaItemDefinition()))
                {
                    s = jsonserializableschema.schemaItemDefinition();
                    obj = type;
                    serializerprovider1 = serializerprovider;
                }
            }
        }
        objectnode.put("type", ((String) (obj)));
        if (serializerprovider1 != null)
        {
            try
            {
                objectnode.put("properties", (JsonNode)(new ObjectMapper()).readValue(serializerprovider1, com/flurry/org/codehaus/jackson/JsonNode));
            }
            // Misplaced declaration of an exception variable
            catch (SerializerProvider serializerprovider)
            {
                throw new IllegalStateException(serializerprovider);
            }
        }
        if (s != null)
        {
            try
            {
                objectnode.put("items", (JsonNode)(new ObjectMapper()).readValue(s, com/flurry/org/codehaus/jackson/JsonNode));
            }
            // Misplaced declaration of an exception variable
            catch (SerializerProvider serializerprovider)
            {
                throw new IllegalStateException(serializerprovider);
            }
        }
        return objectnode;
    }

    public void serialize(JsonSerializable jsonserializable, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        jsonserializable.serialize(jsongenerator, serializerprovider);
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        serialize((JsonSerializable)obj, jsongenerator, serializerprovider);
    }

    public final void serializeWithType(JsonSerializable jsonserializable, JsonGenerator jsongenerator, SerializerProvider serializerprovider, TypeSerializer typeserializer)
        throws IOException, JsonGenerationException
    {
        if (jsonserializable instanceof JsonSerializableWithType)
        {
            ((JsonSerializableWithType)jsonserializable).serializeWithType(jsongenerator, serializerprovider, typeserializer);
            return;
        } else
        {
            serialize(jsonserializable, jsongenerator, serializerprovider);
            return;
        }
    }

    public volatile void serializeWithType(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider, TypeSerializer typeserializer)
        throws IOException, JsonProcessingException
    {
        serializeWithType((JsonSerializable)obj, jsongenerator, serializerprovider, typeserializer);
    }

}
