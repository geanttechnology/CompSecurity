// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import java.io.IOException;

// Referenced classes of package com.fasterxml.jackson.databind.deser.std:
//            StdScalarDeserializer

public class JavaTypeDeserializer extends StdScalarDeserializer
{

    public static final JavaTypeDeserializer instance = new JavaTypeDeserializer();
    private static final long serialVersionUID = 1L;

    public JavaTypeDeserializer()
    {
        super(com/fasterxml/jackson/databind/JavaType);
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
