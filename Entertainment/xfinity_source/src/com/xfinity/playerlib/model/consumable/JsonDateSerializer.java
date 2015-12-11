// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.model.consumable;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class JsonDateSerializer extends JsonSerializer
{

    private static final SimpleDateFormat sdf;

    public JsonDateSerializer()
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
        if (date != null)
        {
            jsongenerator.writeString((new StringBuilder()).append(sdf.format(date)).append(" UTC").toString());
        }
    }

    static 
    {
        sdf = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("UTC"));
    }
}
