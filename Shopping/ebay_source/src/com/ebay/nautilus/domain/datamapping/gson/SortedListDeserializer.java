// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.datamapping.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class SortedListDeserializer
    implements JsonDeserializer
{

    private final Comparator comparator;

    public SortedListDeserializer()
    {
        this(null);
    }

    public SortedListDeserializer(Comparator comparator1)
    {
        comparator = comparator1;
    }

    public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        return deserialize(jsonelement, type, jsondeserializationcontext);
    }

    public List deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        Object obj = jsonelement.getAsJsonArray();
        if (obj != null && ((JsonArray) (obj)).isJsonArray())
        {
            jsonelement = new ArrayList(((JsonArray) (obj)).size());
            for (obj = ((JsonArray) (obj)).iterator(); ((Iterator) (obj)).hasNext(); jsonelement.add((Comparable)jsondeserializationcontext.deserialize((JsonElement)((Iterator) (obj)).next(), ((ParameterizedType)type).getActualTypeArguments()[0]))) { }
            if (comparator != null)
            {
                Collections.sort(jsonelement, comparator);
                return jsonelement;
            } else
            {
                Collections.sort(jsonelement);
                return jsonelement;
            }
        } else
        {
            return null;
        }
    }
}
