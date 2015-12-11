// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.ser.std;

import com.flurry.org.codehaus.jackson.JsonGenerationException;
import com.flurry.org.codehaus.jackson.JsonGenerator;
import com.flurry.org.codehaus.jackson.JsonNode;
import com.flurry.org.codehaus.jackson.map.JsonMappingException;
import com.flurry.org.codehaus.jackson.map.SerializerProvider;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Date;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.ser.std:
//            SerializerBase

public class StdKeySerializer extends SerializerBase
{

    static final StdKeySerializer instace = new StdKeySerializer();

    public StdKeySerializer()
    {
        super(java/lang/Object);
    }

    public JsonNode getSchema(SerializerProvider serializerprovider, Type type)
        throws JsonMappingException
    {
        return createSchemaNode("string");
    }

    public void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonGenerationException
    {
        if (obj instanceof Date)
        {
            serializerprovider.defaultSerializeDateKey((Date)obj, jsongenerator);
            return;
        } else
        {
            jsongenerator.writeFieldName(obj.toString());
            return;
        }
    }

}
