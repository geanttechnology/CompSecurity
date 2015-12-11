// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager.deserializer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

public class JsonDateTimeSearchDeserializer extends JsonDeserializer
{

    public JsonDateTimeSearchDeserializer()
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
        deserializationcontext = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
        jsonparser = jsonparser.getText();
        try
        {
            jsonparser = deserializationcontext.parse(jsonparser);
        }
        // Misplaced declaration of an exception variable
        catch (JsonParser jsonparser)
        {
            throw new RuntimeException(jsonparser);
        }
        return jsonparser;
    }
}
