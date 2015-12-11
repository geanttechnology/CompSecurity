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
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonIntegerFormatVisitor;
import java.io.IOException;
import java.lang.reflect.Type;

// Referenced classes of package com.fasterxml.jackson.databind.ser.std:
//            StdScalarSerializer, NumberSerializers

public static final class r extends StdScalarSerializer
{

    static final serialize instance = new <init>();

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonformatvisitorwrapper, JavaType javatype)
        throws JsonMappingException
    {
        jsonformatvisitorwrapper = jsonformatvisitorwrapper.expectIntegerFormat(javatype);
        if (jsonformatvisitorwrapper != null)
        {
            jsonformatvisitorwrapper.numberType(com.fasterxml.jackson.core.FormatVisitor.numberType);
        }
    }

    public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
    {
        return createSchemaNode("number", true);
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        serialize((Short)obj, jsongenerator, serializerprovider);
    }

    public void serialize(Short short1, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        jsongenerator.writeNumber(short1.shortValue());
    }


    public r()
    {
        super(java/lang/Short);
    }
}
