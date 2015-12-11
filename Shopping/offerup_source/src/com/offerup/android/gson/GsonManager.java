// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.gson;

import android.net.Uri;
import b.a.a;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.offerup.android.dto.OfferUpBoolean;

// Referenced classes of package com.offerup.android.gson:
//            DateTimeTypeDeserializer, OfferUpBooleanTypeDeserializer, AndroidUriTypeSerializer

public class GsonManager
{

    private static Gson gson;

    public GsonManager()
    {
    }

    public static Gson getGson()
    {
        if (gson == null)
        {
            GsonBuilder gsonbuilder = new GsonBuilder();
            FieldNamingPolicy fieldnamingpolicy = FieldNamingPolicy.IDENTITY;
            gsonbuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
            gsonbuilder.registerTypeAdapter(b/a/a, new DateTimeTypeDeserializer());
            gsonbuilder.registerTypeAdapter(com/offerup/android/dto/OfferUpBoolean, new OfferUpBooleanTypeDeserializer());
            gsonbuilder.registerTypeAdapter(android/net/Uri, new AndroidUriTypeSerializer());
            gson = gsonbuilder.create();
        }
        return gson;
    }
}
