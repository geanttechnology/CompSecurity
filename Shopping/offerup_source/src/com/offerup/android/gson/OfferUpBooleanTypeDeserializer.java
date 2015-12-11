// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.gson;

import com.b.a.a.g;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.offerup.android.dto.OfferUpBoolean;
import java.lang.reflect.Type;
import org.apache.commons.lang3.StringUtils;

public class OfferUpBooleanTypeDeserializer
    implements JsonDeserializer
{

    public OfferUpBooleanTypeDeserializer()
    {
    }

    public OfferUpBoolean deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
    {
        type = new OfferUpBoolean();
        jsonelement = jsonelement.getAsString();
        if (!StringUtils.isNumeric(jsonelement))
        {
            break MISSING_BLOCK_LABEL_35;
        }
        if (Integer.parseInt(jsonelement) != 1)
        {
            break MISSING_BLOCK_LABEL_55;
        }
        type.value = true;
        return type;
        type.value = Boolean.parseBoolean(jsonelement);
        return type;
        jsonelement;
        g.a(com/offerup/android/gson/OfferUpBooleanTypeDeserializer.getSimpleName(), jsonelement);
        return type;
    }

    public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
    {
        return deserialize(jsonelement, type, jsondeserializationcontext);
    }
}
