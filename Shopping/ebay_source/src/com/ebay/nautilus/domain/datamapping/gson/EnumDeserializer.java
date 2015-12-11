// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.datamapping.gson;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

public class EnumDeserializer
    implements JsonDeserializer
{

    private final Enum defaultValue;

    public EnumDeserializer(Enum enum)
    {
        defaultValue = enum;
    }

    public Enum deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        jsonelement = jsonelement.getAsString();
        try
        {
            jsonelement = Enum.valueOf(defaultValue.getDeclaringClass(), jsonelement);
        }
        // Misplaced declaration of an exception variable
        catch (JsonElement jsonelement)
        {
            return defaultValue;
        }
        return jsonelement;
    }

    public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        return deserialize(jsonelement, type, jsondeserializationcontext);
    }
}
