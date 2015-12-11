// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.datamapping.gson;

import android.text.TextUtils;
import android.util.Log;
import com.ebay.nautilus.domain.net.EbayDateUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import java.lang.reflect.Type;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateWithTimeZoneDeserializer
    implements JsonDeserializer
{

    private static final Pattern DATE_WITHOUT_TIMEZONE_PATTERN = Pattern.compile("\\d\\d\\d\\d-\\d\\d-\\d\\d");
    private static final String LOG_TAG = "DateWithTimeZoneAdapter";

    public DateWithTimeZoneDeserializer()
    {
    }

    private static com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCart.DateWithTimeZone parseDateWithTimeZone(String s)
        throws ParseException
    {
        s = DATE_WITHOUT_TIMEZONE_PATTERN.matcher(s);
        if (s.find())
        {
            return new com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCart.DateWithTimeZone(EbayDateUtils.parseIso8601Date(s.group()));
        } else
        {
            return null;
        }
    }

    public com.ebay.nautilus.domain.net.api.ecas.models.EcasShoppingCart.DateWithTimeZone deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        jsonelement = jsonelement.getAsJsonPrimitive().getAsString();
        if (TextUtils.isEmpty(jsonelement))
        {
            return null;
        }
        try
        {
            type = parseDateWithTimeZone(jsonelement);
        }
        // Misplaced declaration of an exception variable
        catch (Type type)
        {
            Log.e("DateWithTimeZoneAdapter", String.format("Unable to parse %s into DateWithTimeZone", new Object[] {
                jsonelement
            }));
            return null;
        }
        return type;
    }

    public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        return deserialize(jsonelement, type, jsondeserializationcontext);
    }

}
