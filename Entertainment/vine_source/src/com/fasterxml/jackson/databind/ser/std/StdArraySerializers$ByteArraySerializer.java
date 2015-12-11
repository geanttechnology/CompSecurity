// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializationConfig;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonArrayFormatVisitor;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatTypes;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.IOException;
import java.lang.reflect.Type;

// Referenced classes of package com.fasterxml.jackson.databind.ser.std:
//            StdSerializer, StdArraySerializers

public static final class  extends StdSerializer
{

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonformatvisitorwrapper, JavaType javatype)
        throws JsonMappingException
    {
        if (jsonformatvisitorwrapper != null)
        {
            jsonformatvisitorwrapper = jsonformatvisitorwrapper.expectArrayFormat(javatype);
            if (jsonformatvisitorwrapper != null)
            {
                jsonformatvisitorwrapper.itemsFormat(JsonFormatTypes.STRING);
            }
        }
    }

    public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
    {
        serializerprovider = createSchemaNode("array", true);
        serializerprovider.put("items", createSchemaNode("string"));
        return serializerprovider;
    }

    public volatile boolean isEmpty(Object obj)
    {
        return isEmpty((byte[])obj);
    }

    public boolean isEmpty(byte abyte0[])
    {
        return abyte0 == null || abyte0.length == 0;
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        serialize((byte[])obj, jsongenerator, serializerprovider);
    }

    public void serialize(byte abyte0[], JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        jsongenerator.writeBinary(serializerprovider.getConfig().getBase64Variant(), abyte0, 0, abyte0.length);
    }

    public volatile void serializeWithType(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider, TypeSerializer typeserializer)
        throws IOException, JsonProcessingException
    {
        serializeWithType((byte[])obj, jsongenerator, serializerprovider, typeserializer);
    }

    public void serializeWithType(byte abyte0[], JsonGenerator jsongenerator, SerializerProvider serializerprovider, TypeSerializer typeserializer)
        throws IOException, JsonGenerationException
    {
        typeserializer.writeTypePrefixForScalar(abyte0, jsongenerator);
        jsongenerator.writeBinary(serializerprovider.getConfig().getBase64Variant(), abyte0, 0, abyte0.length);
        typeserializer.writeTypeSuffixForScalar(abyte0, jsongenerator);
    }

    public ()
    {
        super([B);
    }
}
