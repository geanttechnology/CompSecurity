// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.gson;

import android.net.Uri;
import com.b.a.a.g;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

public class AndroidUriTypeSerializer
    implements JsonDeserializer, JsonSerializer
{

    public AndroidUriTypeSerializer()
    {
    }

    public Uri deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
    {
        try
        {
            jsonelement = Uri.parse(jsonelement.getAsString());
        }
        // Misplaced declaration of an exception variable
        catch (JsonElement jsonelement)
        {
            g.a(this, jsonelement);
            return null;
        }
        return jsonelement;
    }

    public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
    {
        return deserialize(jsonelement, type, jsondeserializationcontext);
    }

    public JsonElement serialize(Uri uri, Type type, JsonSerializationContext jsonserializationcontext)
    {
        if (uri != null)
        {
            try
            {
                uri = new JsonPrimitive(uri.toString());
            }
            // Misplaced declaration of an exception variable
            catch (Uri uri)
            {
                g.a(this, uri);
                return null;
            }
            return uri;
        } else
        {
            return null;
        }
    }

    public volatile JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonserializationcontext)
    {
        return serialize((Uri)obj, type, jsonserializationcontext);
    }
}
