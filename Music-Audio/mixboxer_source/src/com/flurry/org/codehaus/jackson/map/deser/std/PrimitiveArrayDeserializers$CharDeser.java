// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.deser.std;

import com.flurry.org.codehaus.jackson.Base64Variant;
import com.flurry.org.codehaus.jackson.Base64Variants;
import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.JsonMappingException;
import java.io.IOException;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.deser.std:
//            PrimitiveArrayDeserializers

static final class > extends >
{

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }

    public char[] deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        Object obj = jsonparser.getCurrentToken();
        if (obj == JsonToken.VALUE_STRING)
        {
            deserializationcontext = jsonparser.getTextCharacters();
            int i = jsonparser.getTextOffset();
            int j = jsonparser.getTextLength();
            jsonparser = new char[j];
            System.arraycopy(deserializationcontext, i, jsonparser, 0, j);
            return jsonparser;
        }
        if (jsonparser.isExpectedStartArrayToken())
        {
            obj = new StringBuilder(64);
            do
            {
                Object obj1 = jsonparser.nextToken();
                if (obj1 != JsonToken.END_ARRAY)
                {
                    if (obj1 != JsonToken.VALUE_STRING)
                    {
                        throw deserializationcontext.mappingException(Character.TYPE);
                    }
                    obj1 = jsonparser.getText();
                    if (((String) (obj1)).length() != 1)
                    {
                        throw JsonMappingException.from(jsonparser, (new StringBuilder()).append("Can not convert a JSON String of length ").append(((String) (obj1)).length()).append(" into a char element of char array").toString());
                    }
                    ((StringBuilder) (obj)).append(((String) (obj1)).charAt(0));
                } else
                {
                    return ((StringBuilder) (obj)).toString().toCharArray();
                }
            } while (true);
        }
        if (obj == JsonToken.VALUE_EMBEDDED_OBJECT)
        {
            jsonparser = ((JsonParser) (jsonparser.getEmbeddedObject()));
            if (jsonparser == null)
            {
                return null;
            }
            if (jsonparser instanceof char[])
            {
                return (char[])(char[])jsonparser;
            }
            if (jsonparser instanceof String)
            {
                return ((String)jsonparser).toCharArray();
            }
            if (jsonparser instanceof byte[])
            {
                return Base64Variants.getDefaultVariant().encode((byte[])(byte[])jsonparser, false).toCharArray();
            }
        }
        throw deserializationcontext.mappingException(_valueClass);
    }

    public Y()
    {
        super([C);
    }
}
