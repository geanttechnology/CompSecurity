// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.utils;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import java.io.IOException;
import java.util.Date;

public class TimestampInSecondsDeserializer extends JsonDeserializer
{

    public TimestampInSecondsDeserializer()
    {
    }

    public volatile Object deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException, JsonProcessingException
    {
        return deserialize(jsonparser, deserializationcontext);
    }

    public Date deserialize(JsonParser jsonparser, DeserializationContext deserializationcontext)
        throws IOException
    {
        if (jsonparser.getCurrentToken() == JsonToken.VALUE_NUMBER_INT)
        {
            return new Date(jsonparser.getLongValue() * 1000L);
        } else
        {
            throw deserializationcontext.mappingException("Expected JSON number");
        }
    }
}
