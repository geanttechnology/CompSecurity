// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.datamapping.gson;

import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.Date;

public class EbayDateAdapter
    implements JsonDeserializer, JsonSerializer
{

    public EbayDateAdapter()
    {
    }

    public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        return deserialize(jsonelement, type, jsondeserializationcontext);
    }

    public Date deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        jsonelement = jsonelement.getAsString();
        try
        {
            jsonelement = EbayDateUtils.parse(jsonelement);
        }
        // Misplaced declaration of an exception variable
        catch (JsonElement jsonelement)
        {
            throw new JsonParseException(jsonelement);
        }
        return jsonelement;
    }

    public volatile JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonserializationcontext)
    {
        return serialize((Date)obj, type, jsonserializationcontext);
    }

    public JsonElement serialize(Date date, Type type, JsonSerializationContext jsonserializationcontext)
    {
        return new JsonPrimitive(EbayDateUtils.format(date));
    }
}
