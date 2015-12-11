// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;

import android.text.TextUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
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
        jsonelement = jsonelement.getAsString();
        if (!TextUtils.isEmpty(jsonelement))
        {
            type = ();
            int j = type.length;
            for (int i = 0; i < j; i++)
            {
                jsondeserializationcontext = type[i];
                if (TextUtils.equals(jsondeserializationcontext.(), jsonelement))
                {
                    return jsondeserializationcontext;
                }
            }

        }
        if ("EBAY_FAST_AND_FREE".equals(jsonelement))
        {
            return ;
        } else
        {
            return ;
        }
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
