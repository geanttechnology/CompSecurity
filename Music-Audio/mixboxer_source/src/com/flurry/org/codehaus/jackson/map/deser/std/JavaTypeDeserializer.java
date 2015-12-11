// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.deser.std;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.type.TypeFactory;
import com.flurry.org.codehaus.jackson.type.JavaType;
import java.io.IOException;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.deser.std:
//            StdScalarDeserializer

public class JavaTypeDeserializer extends StdScalarDeserializer
{

    public JavaTypeDeserializer()
    {
        super(com/flurry/org/codehaus/jackson/type/JavaType);
    }

    public JavaType deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken == JsonToken.VALUE_STRING)
        {
            jsonparser = jsonparser.getText().trim();
            if (jsonparser.length() == 0)
            {
                return (JavaType)getEmptyValue();
            } else
            {
                return deserializationcontext.getTypeFactory().constructFromCanonical(jsonparser);
            }
        }
        if (jsontoken == JsonToken.VALUE_EMBEDDED_OBJECT)
        {
            return (JavaType)jsonparser.getEmbeddedObject();
        } else
        {
            throw deserializationcontext.mappingException(_valueClass);
        }
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }
}
