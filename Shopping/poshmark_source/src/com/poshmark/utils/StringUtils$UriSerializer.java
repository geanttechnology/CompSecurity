// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.utils;

import android.net.Uri;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;

// Referenced classes of package com.poshmark.utils:
//            StringUtils

public static class 
    implements JsonSerializer
{

    public JsonElement serialize(Uri uri, Type type, JsonSerializationContext jsonserializationcontext)
    {
        type = new JsonObject();
        type.addProperty("path", uri.getPath());
        return type;
    }

    public volatile JsonElement serialize(Object obj, Type type, JsonSerializationContext jsonserializationcontext)
    {
        return serialize((Uri)obj, type, jsonserializationcontext);
    }

    public ()
    {
    }
}
