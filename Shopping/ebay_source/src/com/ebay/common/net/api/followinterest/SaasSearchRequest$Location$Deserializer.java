// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import android.text.TextUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            SaasSearchRequest

public static class 
    implements JsonDeserializer
{

    public  deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        type = (JsonObject)jsonelement;
        jsonelement = new ();
        jsondeserializationcontext = type.get("country");
        if (jsondeserializationcontext != null)
        {
            jsonelement. = jsondeserializationcontext.getAsString();
            if (TextUtils.isEmpty((() (jsonelement)).) || (() (jsonelement))..equals("null") || (() (jsonelement))..equals("NONE"))
            {
                jsonelement. = null;
            }
        }
        type = type.get("postalCode");
        if (type != null)
        {
            jsonelement. = type.getAsString();
            if (TextUtils.isEmpty((() (jsonelement)).) || (() (jsonelement))..equals("null"))
            {
                jsonelement. = null;
            }
        }
        return jsonelement;
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
