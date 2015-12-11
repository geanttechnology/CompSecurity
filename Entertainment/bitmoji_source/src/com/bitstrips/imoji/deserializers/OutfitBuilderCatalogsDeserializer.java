// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.deserializers;

import com.bitstrips.imoji.models.OutfitBuilderCatalogs;
import com.bitstrips.outfitbuilder.models.OBCatalog;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class OutfitBuilderCatalogsDeserializer
    implements JsonDeserializer
{

    private static final String FEMALE = "female";
    private static final String MALE = "male";

    public OutfitBuilderCatalogsDeserializer()
    {
    }

    public OutfitBuilderCatalogs deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        type = jsonelement.getAsJsonObject().get("male").getAsJsonObject();
        jsonelement = jsonelement.getAsJsonObject().get("female").getAsJsonObject();
        return new OutfitBuilderCatalogs(OBCatalog.catalogFromJsonString(type.toString()), OBCatalog.catalogFromJsonString(jsonelement.toString()));
    }

    public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        return deserialize(jsonelement, type, jsondeserializationcontext);
    }
}
