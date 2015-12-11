// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package io.presage.if;

import io.presage.model.Parameter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import shared_presage.com.google.gson.JsonArray;
import shared_presage.com.google.gson.JsonDeserializationContext;
import shared_presage.com.google.gson.JsonDeserializer;
import shared_presage.com.google.gson.JsonElement;

public final class b
    implements JsonDeserializer
{

    public b()
    {
    }

    public final Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
    {
label0:
        {
            type = new ArrayList();
            if (jsonelement.isJsonArray())
            {
                for (jsonelement = jsonelement.getAsJsonArray().iterator(); jsonelement.hasNext(); type.add((Parameter)jsondeserializationcontext.deserialize((JsonElement)jsonelement.next(), io/presage/model/Parameter))) { }
            } else
            {
                if (!jsonelement.isJsonObject())
                {
                    break label0;
                }
                type.add((Parameter)jsondeserializationcontext.deserialize(jsonelement, io/presage/model/Parameter));
            }
            return type;
        }
        throw new RuntimeException((new StringBuilder("Unexpected JSON type: ")).append(jsonelement.getClass()).toString());
    }
}
