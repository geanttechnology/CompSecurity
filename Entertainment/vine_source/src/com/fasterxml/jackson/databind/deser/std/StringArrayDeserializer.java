// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.fasterxml.jackson.databind.util.ObjectBuffer;
import java.io.IOException;

// Referenced classes of package com.fasterxml.jackson.databind.deser.std:
//            StdDeserializer

public final class StringArrayDeserializer extends StdDeserializer
    implements ContextualDeserializer
{

    public static final StringArrayDeserializer instance = new StringArrayDeserializer();
    private static final long serialVersionUID = 0x96aca308ea9cc20bL;
    protected JsonDeserializer _elementDeserializer;

    public StringArrayDeserializer()
    {
        super([Ljava/lang/String;);
        _elementDeserializer = null;
    }

    protected StringArrayDeserializer(JsonDeserializer jsondeserializer)
    {
        super([Ljava/lang/String;);
        _elementDeserializer = jsondeserializer;
    }

    private final String[] handleNonArray(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        Object obj = null;
        if (!deserializationcontext.isEnabled(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY))
        {
            if (jsonparser.getCurrentToken() == JsonToken.VALUE_STRING && deserializationcontext.isEnabled(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT) && jsonparser.getText().length() == 0)
            {
                return null;
            } else
            {
                throw deserializationcontext.mappingException(_valueClass);
            }
        }
        if (jsonparser.getCurrentToken() == JsonToken.VALUE_NULL)
        {
            jsonparser = obj;
        } else
        {
            jsonparser = _parseString(jsonparser, deserializationcontext);
        }
        return (new String[] {
            jsonparser
        });
    }

    protected final String[] _deserializeCustom(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        ObjectBuffer objectbuffer = deserializationcontext.leaseObjectBuffer();
        Object aobj[] = objectbuffer.resetAndStart();
        JsonDeserializer jsondeserializer = _elementDeserializer;
        int i = 0;
        do
        {
            Object obj = jsonparser.nextToken();
            if (obj != JsonToken.END_ARRAY)
            {
                if (obj == JsonToken.VALUE_NULL)
                {
                    obj = null;
                } else
                {
                    obj = (String)jsondeserializer.deserialize(jsonparser, deserializationcontext);
                }
                if (i >= aobj.length)
                {
                    aobj = objectbuffer.appendCompletedChunk(aobj);
                    i = 0;
                }
                aobj[i] = obj;
                i++;
            } else
            {
                jsonparser = (String[])objectbuffer.completeAndClearBuffer(aobj, i, java/lang/String);
                deserializationcontext.returnObjectBuffer(objectbuffer);
                return jsonparser;
            }
        } while (true);
    }

    public JsonDeserializer createContextual(DeserializationContext deserializationcontext, BeanProperty beanproperty)
        throws JsonMappingException
    {
        JsonDeserializer jsondeserializer = findConvertingContentDeserializer(deserializationcontext, beanproperty, _elementDeserializer);
        if (jsondeserializer == null)
        {
            deserializationcontext = deserializationcontext.findContextualValueDeserializer(deserializationcontext.constructType(java/lang/String), beanproperty);
        } else
        {
            deserializationcontext = deserializationcontext.handleSecondaryContextualization(jsondeserializer, beanproperty);
        }
        beanproperty = deserializationcontext;
        if (deserializationcontext != null)
        {
            beanproperty = deserializationcontext;
            if (isDefaultDeserializer(deserializationcontext))
            {
                beanproperty = null;
            }
        }
        deserializationcontext = this;
        if (_elementDeserializer != beanproperty)
        {
            deserializationcontext = new StringArrayDeserializer(beanproperty);
        }
        return deserializationcontext;
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }

    public String[] deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        if (!jsonparser.isExpectedStartArrayToken())
        {
            return handleNonArray(jsonparser, deserializationcontext);
        }
        if (_elementDeserializer != null)
        {
            return _deserializeCustom(jsonparser, deserializationcontext);
        }
        ObjectBuffer objectbuffer = deserializationcontext.leaseObjectBuffer();
        Object aobj[] = objectbuffer.resetAndStart();
        int i = 0;
        do
        {
            Object obj = jsonparser.nextToken();
            if (obj != JsonToken.END_ARRAY)
            {
                int j;
                if (obj == JsonToken.VALUE_STRING)
                {
                    obj = jsonparser.getText();
                } else
                if (obj == JsonToken.VALUE_NULL)
                {
                    obj = null;
                } else
                {
                    obj = _parseString(jsonparser, deserializationcontext);
                }
                if (i >= aobj.length)
                {
                    aobj = objectbuffer.appendCompletedChunk(aobj);
                    i = 0;
                }
                j = i + 1;
                aobj[i] = obj;
                i = j;
            } else
            {
                jsonparser = (String[])objectbuffer.completeAndClearBuffer(aobj, i, java/lang/String);
                deserializationcontext.returnObjectBuffer(objectbuffer);
                return jsonparser;
            }
        } while (true);
    }

    public Object deserializeWithType(JsonParser jsonparser, DeserializationContext deserializationcontext, TypeDeserializer typedeserializer)
        throws IOException, JsonProcessingException
    {
        return typedeserializer.deserializeTypedFromArray(jsonparser, deserializationcontext);
    }

}
