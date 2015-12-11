// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.datamapping.gson;

import android.text.TextUtils;
import com.ebay.nautilus.domain.EbaySite;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class EbaySiteAdapter
    implements JsonDeserializer, JsonSerializer
{

    public EbaySiteAdapter()
    {
    }

    public EbaySite deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        jsonelement = jsonelement.getAsString();
        if (TextUtils.isEmpty(jsonelement))
        {
            return null;
        } else
        {
            return EbaySite.getInstanceFromId(jsonelement);
        }
    }

    public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        return deserialize(jsonelement, type, jsondeserializationcontext);
    }

    public JsonElement serialize(EbaySite ebaysite, Type type, JsonSerializationContext jsonserializationcontext)
    {
        return new JsonPrimitive(ebaysite.idString);
    }

    public volatile JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonserializationcontext)
    {
        return serialize((EbaySite)obj, type, jsonserializationcontext);
    }
}
