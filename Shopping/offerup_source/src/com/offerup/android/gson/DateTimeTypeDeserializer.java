// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.offerup.android.gson;

import android.util.Log;
import b.a.a;
import com.b.a.a.g;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.offerup.android.utils.m;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;

public class DateTimeTypeDeserializer
    implements JsonDeserializer
{

    static String oldPattern;
    static SimpleDateFormat oldSimpleDateFormat;
    String TAG;

    public DateTimeTypeDeserializer()
    {
        TAG = "DateTimeTypeDeserializer";
    }

    public a deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
    {
        String s = jsonelement.getAsString();
        if (!StringUtils.isNumeric(s)) goto _L2; else goto _L1
_L1:
        type = a.a(Long.parseLong(s) * 1000L, m.a);
_L4:
        if (type == null && jsonelement != null)
        {
            g.d("DateTimeTypeDeserializer", (new StringBuilder("Can't translate the following ")).append(jsonelement.toString()).toString());
        }
        return type;
_L2:
        try
        {
            jsondeserializationcontext = new a(s.substring(0, s.length() - 1));
        }
        // Misplaced declaration of an exception variable
        catch (Type type)
        {
            jsondeserializationcontext = null;
        }
        type = jsondeserializationcontext;
        if (jsondeserializationcontext == null)
        {
            try
            {
                type = a.a(oldSimpleDateFormat.parse(s).getTime(), m.a);
            }
            // Misplaced declaration of an exception variable
            catch (Type type)
            {
                type = jsondeserializationcontext;
            }
        }
        continue; /* Loop/switch isn't completed */
        type;
        g.c(TAG, Log.getStackTraceString(type));
        type = null;
        if (true) goto _L4; else goto _L3
_L3:
    }

    public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
    {
        return deserialize(jsonelement, type, jsondeserializationcontext);
    }

    static 
    {
        oldPattern = "yyyy-MM-dd HH:mm:ss";
        oldSimpleDateFormat = new SimpleDateFormat(oldPattern, Locale.ENGLISH);
    }
}
