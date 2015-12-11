// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.poshmark.data_model.models.ListingDetails;
import java.lang.reflect.Type;

// Referenced classes of package com.poshmark.utils:
//            StringUtils

public static class 
    implements JsonDeserializer
{

    public ListingDetails deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        if (jsonelement.isJsonObject())
        {
            ((JsonObject)jsonelement).get("path");
        }
        return null;
    }

    public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        return deserialize(jsonelement, type, jsondeserializationcontext);
    }

    public ()
    {
    }
}
