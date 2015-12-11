// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.if;

import android.content.Context;
import io.presage.actions.AddAdShortcut;
import io.presage.ads.NewAd;
import java.lang.reflect.Type;
import shared_presage.com.google.gson.JsonDeserializationContext;
import shared_presage.com.google.gson.JsonDeserializer;
import shared_presage.com.google.gson.JsonElement;
import shared_presage.com.google.gson.JsonObject;

public final class a
    implements JsonDeserializer
{

    private Context a;

    public a(Context context)
    {
        a = context;
    }

    public final Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
    {
        type = null;
        if (jsonelement.getAsJsonObject().has("ad"))
        {
            type = (NewAd)jsondeserializationcontext.deserialize(jsonelement.getAsJsonObject().getAsJsonObject("ad"), io/presage/ads/NewAd);
        }
        return new AddAdShortcut(a, type);
    }
}
