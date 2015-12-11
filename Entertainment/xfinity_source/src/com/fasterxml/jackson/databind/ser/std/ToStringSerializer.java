// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import com.fasterxml.jackson.databind.jsontype.TypeSerializer;
import java.io.IOException;
import java.lang.reflect.Type;

// Referenced classes of package com.fasterxml.jackson.databind.ser.std:
//            StdSerializer

public class ToStringSerializer extends StdSerializer
{

    public static final ToStringSerializer instance = new ToStringSerializer();

    public ToStringSerializer()
    {
        super(java/lang/Object);
    }

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonformatvisitorwrapper, JavaType javatype)
    {
        jsonformatvisitorwrapper.expectStringFormat(javatype);
    }

    public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
        throws JsonMappingException
    {
        return createSchemaNode("string", true);
    }

    public boolean isEmpty(Object obj)
    {
        if (obj != null)
        {
            if ((obj = obj.toString()) != null && ((String) (obj)).length() != 0)
            {
                return false;
            }
        }
        return true;
    }

    public void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        jsongenerator.writeString(obj.toString());
    }

    public void serializeWithType(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider, TypeSerializer typeserializer)
        throws IOException, JsonGenerationException
    {
        typeserializer.writeTypePrefixForScalar(obj, jsongenerator);
        serialize(obj, jsongenerator, serializerprovider);
        typeserializer.writeTypeSuffixForScalar(obj, jsongenerator);
    }

}
