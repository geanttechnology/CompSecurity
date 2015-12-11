// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static class 
    implements JsonDeserializer
{

    public  deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        type = jsonelement.getAsJsonObject().get("type");
        if (type != null)
        {
            if ("FreightStepExtension".equals(type.getAsString()))
            {
                return ()jsondeserializationcontext.deserialize(jsonelement, com/ebay/nautilus/domain/net/api/viewlisting/Listing$FreightStepExtension);
            }
            if ("ShippingStepExtension".equals(type.getAsString()))
            {
                return ()jsondeserializationcontext.deserialize(jsonelement, com/ebay/nautilus/domain/net/api/viewlisting/Listing$ShippingStepExtension);
            }
            if ("PickupStepExtension".equals(type.getAsString()))
            {
                return ()jsondeserializationcontext.deserialize(jsonelement, com/ebay/nautilus/domain/net/api/viewlisting/Listing$PickupStepExtension);
            }
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
