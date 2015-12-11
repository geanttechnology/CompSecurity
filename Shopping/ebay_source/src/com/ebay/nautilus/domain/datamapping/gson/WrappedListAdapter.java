// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.datamapping.gson;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class WrappedListAdapter
    implements JsonDeserializer, JsonSerializer
{

    private final String innerElementName;

    public WrappedListAdapter(String s)
    {
        innerElementName = s;
    }

    private static Type getGenericType(Type type)
    {
        Type type1 = type;
        if (type instanceof ParameterizedType)
        {
            Type atype[] = ((ParameterizedType)type).getActualTypeArguments();
            type1 = type;
            if (atype != null)
            {
                type1 = type;
                if (atype.length > 0)
                {
                    type1 = atype[0];
                }
            }
        }
        return type1;
    }

    public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        return deserialize(jsonelement, type, jsondeserializationcontext);
    }

    public List deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
label0:
        {
            jsonelement = jsonelement.getAsJsonObject();
            if (jsonelement.has(innerElementName))
            {
                jsonelement = jsonelement.getAsJsonArray(innerElementName);
                if (jsonelement != null && jsonelement.isJsonArray())
                {
                    ArrayList arraylist = new ArrayList(jsonelement.size());
                    type = getGenericType(type);
                    Iterator iterator = jsonelement.iterator();
                    do
                    {
                        jsonelement = arraylist;
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        arraylist.add(jsondeserializationcontext.deserialize((JsonElement)iterator.next(), type));
                    } while (true);
                    break label0;
                }
            }
            jsonelement = Collections.emptyList();
        }
        return jsonelement;
    }

    public volatile JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonserializationcontext)
    {
        return serialize((List)obj, type, jsonserializationcontext);
    }

    public JsonElement serialize(List list, Type type, JsonSerializationContext jsonserializationcontext)
    {
        JsonObject jsonobject = new JsonObject();
        if (list != null)
        {
            JsonArray jsonarray = new JsonArray();
            type = getGenericType(type);
            for (list = list.iterator(); list.hasNext(); jsonarray.add(jsonserializationcontext.serialize(list.next(), type))) { }
            jsonobject.add(innerElementName, jsonarray);
        }
        return jsonobject;
    }
}
