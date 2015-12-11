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

public static final class  extends StdScalarSerializer
{

    static final serialize instance = new <init>();

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonformatvisitorwrapper, JavaType javatype)
        throws JsonMappingException
    {
        jsonformatvisitorwrapper = jsonformatvisitorwrapper.expectIntegerFormat(javatype);
        if (jsonformatvisitorwrapper != null)
        {
            jsonformatvisitorwrapper.numberType(com.fasterxml.jackson.core.rmatVisitor.numberType);
        }
    }

    public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
    {
        return createSchemaNode("integer", true);
    }

    public void serialize(Number number, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        jsongenerator.writeNumber(number.intValue());
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        serialize((Number)obj, jsongenerator, serializerprovider);
    }


    public ()
    {
        super(java/lang/Number);
    }
}
