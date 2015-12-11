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

public static class Deserializer
{
    public static class Deserializer
        implements JsonDeserializer
    {

        public SaasSearchRequest.Location deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            type = (JsonObject)jsonelement;
            jsonelement = new SaasSearchRequest.Location();
            jsondeserializationcontext = type.get("country");
            if (jsondeserializationcontext != null)
            {
                jsonelement.country = jsondeserializationcontext.getAsString();
                if (TextUtils.isEmpty(((SaasSearchRequest.Location) (jsonelement)).country) || ((SaasSearchRequest.Location) (jsonelement)).country.equals("null") || ((SaasSearchRequest.Location) (jsonelement)).country.equals("NONE"))
                {
                    jsonelement.country = null;
                }
            }
            type = type.get("postalCode");
            if (type != null)
            {
                jsonelement.postalCode = type.getAsString();
                if (TextUtils.isEmpty(((SaasSearchRequest.Location) (jsonelement)).postalCode) || ((SaasSearchRequest.Location) (jsonelement)).postalCode.equals("null"))
                {
                    jsonelement.postalCode = null;
                }
            }
            return jsonelement;
        }

        public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            return deserialize(jsonelement, type, jsondeserializationcontext);
        }

        public Deserializer()
        {
        }
    }


    public String country;
    public String postalCode;

    public Deserializer()
    {
    }
}
