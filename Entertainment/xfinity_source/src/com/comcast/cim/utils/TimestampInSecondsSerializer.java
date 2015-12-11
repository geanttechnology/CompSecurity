// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.utils;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.util.Date;

public class TimestampInSecondsSerializer extends JsonSerializer
{

    public TimestampInSecondsSerializer()
    {
    }

    public volatile void serialize(Object obj, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException, JsonProcessingException
    {
        serialize((Date)obj, jsongenerator, serializerprovider);
    }

    public void serialize(Date date, JsonGenerator jsongenerator, SerializerProvider serializerprovider)
        throws IOException
    {
        jsongenerator.writeNumber((int)(date.getTime() / 1000L));
    }
}
