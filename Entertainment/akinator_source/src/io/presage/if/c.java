// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.if;

import io.presage.ads.NewAd;
import io.presage.model.Parameter;
import io.presage.model.Zone;
import java.lang.reflect.Type;
import shared_presage.com.google.gson.Gson;
import shared_presage.com.google.gson.JsonDeserializationContext;
import shared_presage.com.google.gson.JsonDeserializer;
import shared_presage.com.google.gson.JsonElement;
import shared_presage.com.google.gson.JsonObject;

// Referenced classes of package io.presage.if:
//            d

public final class c
    implements JsonDeserializer
{

    public c()
    {
    }

    public final Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
    {
        jsonelement = jsonelement.getAsJsonObject();
        jsondeserializationcontext = jsonelement.get("name").getAsString();
        JsonElement jsonelement1 = jsonelement.get("value");
        if ("zones".equals(jsondeserializationcontext))
        {
            return new Parameter(jsondeserializationcontext, (new Gson()).fromJson(jsonelement1, (new d(this)).getType()));
        }
        if ("frame".equals(jsondeserializationcontext))
        {
            return new Parameter(jsondeserializationcontext, (new Gson()).fromJson(jsonelement1, io/presage/model/Zone));
        }
        if ("ad".equals(jsondeserializationcontext))
        {
            return new Parameter(jsondeserializationcontext, (new Gson()).fromJson(jsonelement1, io/presage/ads/NewAd));
        } else
        {
            return (Parameter)(new Gson()).fromJson(jsonelement, type);
        }
    }
}
