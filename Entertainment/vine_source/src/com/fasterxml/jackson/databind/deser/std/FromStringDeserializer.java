// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

// Referenced classes of package com.fasterxml.jackson.databind.deser.std:
//            StdScalarDeserializer

public abstract class FromStringDeserializer extends StdScalarDeserializer
{

    private static final long serialVersionUID = 1L;

    protected FromStringDeserializer(Class class1)
    {
        super(class1);
    }

    protected abstract Object _deserialize(String s, DeserializationContext deserializationcontext)
        throws IOException;

    protected Object _deserializeEmbedded(Object obj, DeserializationContext deserializationcontext)
        throws IOException
    {
        throw deserializationcontext.mappingException((new StringBuilder()).append("Don't know how to convert embedded Object of type ").append(obj.getClass().getName()).append(" into ").append(_valueClass.getName()).toString());
    }

    protected Object _deserializeFromEmptyString()
    {
        return null;
    }

    public final Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException
    {
        Object obj;
        String s1;
        String s2;
        obj = null;
        s1 = null;
        s2 = jsonparser.getValueAsString();
        if (s2 == null) goto _L2; else goto _L1
_L1:
        if (s2.length() == 0) goto _L4; else goto _L3
_L3:
        s1 = s2.trim();
        if (s1.length() != 0) goto _L5; else goto _L4
_L4:
        jsonparser = ((JsonParser) (_deserializeFromEmptyString()));
_L7:
        return jsonparser;
_L5:
        Object obj2;
        try
        {
            obj2 = _deserialize(s1, deserializationcontext);
        }
        // Misplaced declaration of an exception variable
        catch (JsonParser jsonparser)
        {
            String s = "not a valid textual representation";
            if (jsonparser != null)
            {
                s = (new StringBuilder()).append("not a valid textual representation").append(" problem: ").append(jsonparser.getMessage()).toString();
            }
            deserializationcontext = deserializationcontext.weirdStringException(s1, _valueClass, s);
            if (jsonparser != null)
            {
                deserializationcontext.initCause(jsonparser);
            }
            throw deserializationcontext;
        }
label0:
        {
            jsonparser = obj;
            if (obj2 != null)
            {
                return obj2;
            }
            break label0;
        }
_L2:
        if (jsonparser.getCurrentToken() == JsonToken.VALUE_EMBEDDED_OBJECT)
        {
            Object obj1 = jsonparser.getEmbeddedObject();
            jsonparser = s1;
            if (obj1 != null)
            {
                if (_valueClass.isAssignableFrom(obj1.getClass()))
                {
                    return obj1;
                } else
                {
                    return _deserializeEmbedded(obj1, deserializationcontext);
                }
            }
        } else
        {
            throw deserializationcontext.mappingException(_valueClass);
        }
        if (true) goto _L7; else goto _L6
_L6:
    }
}
