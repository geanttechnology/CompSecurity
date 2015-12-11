// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            EbayResponseError

public static class 
    implements JsonDeserializer
{

    public  deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        jsonelement = jsonelement.getAsString();
        type = ();
        int j = type.length;
        for (int i = 0; i < j; i++)
        {
            jsondeserializationcontext = type[i];
            if (jsondeserializationcontext.().equalsIgnoreCase(jsonelement))
            {
                return jsondeserializationcontext;
            }
        }

        return ;
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
