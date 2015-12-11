// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.codehaus.jackson.map.deser.std;

import java.io.IOException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.JsonToken;
import org.codehaus.jackson.map.DeserializationContext;

// Referenced classes of package org.codehaus.jackson.map.deser.std:
//            StdScalarDeserializer

public class ClassDeserializer extends StdScalarDeserializer
{

    public ClassDeserializer()
    {
        super(java/lang/Class);
    }

    public Class deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        Object obj = jsonparser.getCurrentToken();
        if (obj == JsonToken.VALUE_STRING)
        {
            obj = jsonparser.getText();
            if (((String) (obj)).indexOf('.') < 0)
            {
                if ("int".equals(obj))
                {
                    return Integer.TYPE;
                }
                if ("long".equals(obj))
                {
                    return Long.TYPE;
                }
                if ("float".equals(obj))
                {
                    return Float.TYPE;
                }
                if ("double".equals(obj))
                {
                    return Double.TYPE;
                }
                if ("boolean".equals(obj))
                {
                    return Boolean.TYPE;
                }
                if ("byte".equals(obj))
                {
                    return Byte.TYPE;
                }
                if ("char".equals(obj))
                {
                    return Character.TYPE;
                }
                if ("short".equals(obj))
                {
                    return Short.TYPE;
                }
                if ("void".equals(obj))
                {
                    return Void.TYPE;
                }
            }
            try
            {
                jsonparser = Class.forName(jsonparser.getText());
            }
            // Misplaced declaration of an exception variable
            catch (JsonParser jsonparser)
            {
                throw deserializationcontext.instantiationException(_valueClass, jsonparser);
            }
            return jsonparser;
        } else
        {
            throw deserializationcontext.mappingException(_valueClass, ((JsonToken) (obj)));
        }
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }
}
