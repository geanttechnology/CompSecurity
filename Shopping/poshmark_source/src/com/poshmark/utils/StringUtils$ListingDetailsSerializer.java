// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.poshmark.data_model.models.ListingDetails;
import java.lang.reflect.Type;

// Referenced classes of package com.poshmark.utils:
//            StringUtils

public static class 
    implements JsonSerializer
{

    public JsonElement serialize(ListingDetails listingdetails, Type type, JsonSerializationContext jsonserializationcontext)
    {
        return new JsonObject();
    }

    public volatile JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonserializationcontext)
    {
        return serialize((ListingDetails)obj, type, jsonserializationcontext);
    }

    public ()
    {
    }
}
