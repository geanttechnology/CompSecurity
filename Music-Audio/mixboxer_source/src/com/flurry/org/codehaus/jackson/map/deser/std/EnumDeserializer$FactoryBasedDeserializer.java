// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.codehaus.jackson.map.deser.std;

import com.flurry.org.codehaus.jackson.JsonParser;
import com.flurry.org.codehaus.jackson.JsonProcessingException;
import com.flurry.org.codehaus.jackson.JsonToken;
import com.flurry.org.codehaus.jackson.map.DeserializationContext;
import com.flurry.org.codehaus.jackson.map.introspect.AnnotatedMethod;
import com.flurry.org.codehaus.jackson.map.util.ClassUtil;
import java.io.IOException;
import java.lang.reflect.Method;

// Referenced classes of package com.flurry.org.codehaus.jackson.map.deser.std:
//            StdScalarDeserializer, EnumDeserializer

protected static class _factory extends StdScalarDeserializer
{

    protected final Class _enumClass;
    protected final Method _factory;

    public Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        JsonToken jsontoken = jsonparser.getCurrentToken();
        if (jsontoken != JsonToken.VALUE_STRING && jsontoken != JsonToken.FIELD_NAME)
        {
            throw deserializationcontext.mappingException(_enumClass);
        }
        jsonparser = jsonparser.getText();
        try
        {
            jsonparser = ((JsonParser) (_factory.invoke(_enumClass, new Object[] {
                jsonparser
            })));
        }
        // Misplaced declaration of an exception variable
        catch (JsonParser jsonparser)
        {
            ClassUtil.unwrapAndThrowAsIAE(jsonparser);
            return null;
        }
        return jsonparser;
    }

    public (Class class1, AnnotatedMethod annotatedmethod)
    {
        super(java/lang/Enum);
        _enumClass = class1;
        _factory = annotatedmethod.getAnnotated();
    }
}
