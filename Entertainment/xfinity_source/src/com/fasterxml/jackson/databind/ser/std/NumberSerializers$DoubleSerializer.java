// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.ser.std;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.jsonFormatVisitors.JsonFormatVisitorWrapper;
import java.io.IOException;
import java.lang.reflect.Type;

// Referenced classes of package com.fasterxml.jackson.databind.ser.std:
//            NonTypedScalarSerializerBase, NumberSerializers

public static final class  extends NonTypedScalarSerializerBase
{

    static final serialize instance = new <init>();

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonformatvisitorwrapper, JavaType javatype)
    {
        jsonformatvisitorwrapper.expectNumberFormat(javatype);
    }

    public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
    {
        return createSchemaNode("number", true);
    }

    public void serialize(Double double1, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        jsongenerator.writeNumber(double1.doubleValue());
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        serialize((Double)obj, jsongenerator, serializerprovider);
    }


    public ()
    {
        super(java/lang/Double);
    }
}
