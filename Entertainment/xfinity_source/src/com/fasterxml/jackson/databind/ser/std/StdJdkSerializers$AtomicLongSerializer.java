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
import java.util.concurrent.atomic.AtomicLong;

// Referenced classes of package com.fasterxml.jackson.databind.ser.std:
//            StdScalarSerializer, StdJdkSerializers

public static final class  extends StdScalarSerializer
{

    public void acceptJsonFormatVisitor(JsonFormatVisitorWrapper jsonformatvisitorwrapper, JavaType javatype)
    {
        jsonformatvisitorwrapper.expectIntegerFormat(javatype);
    }

    public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
    {
        return createSchemaNode("integer", true);
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        serialize((AtomicLong)obj, jsongenerator, serializerprovider);
    }

    public void serialize(AtomicLong atomiclong, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        jsongenerator.writeNumber(atomiclong.get());
    }

    public ()
    {
        super(java/util/concurrent/atomic/AtomicLong, false);
    }
}
