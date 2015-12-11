// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bitstrips.imoji.deserializers;

import com.bitstrips.imoji.models.AvatarInfo;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.List;

public class AvatarInfoDeserializer
    implements JsonDeserializer
{

    private static final String BODY_KEY = "body";
    private static final String BODY_TYPE_KEY = "body_type";
    private static final String BREAST_TYPE_KEY = "breast_type";
    private static final String CHAR_DATA_KEY = "styled_char_data";
    private static final String CLOTHES_KEY = "clothes";
    private static final String NEW_CLOTHES_KEY = "new_clothes";
    private static final String NEW_UNDERWEAR_ART[] = {
        "barebm0a"
    };
    private static final String SKIN_TONE_KEY = "ffcc99";
    private static final String STYLE_KEY = "style";
    private static final String TONE_KEY = "colours";
    private static final String UNDERWEAR_ART[] = {
        "bare", "shirt04", "pants05"
    };

    public AvatarInfoDeserializer()
    {
    }

    private boolean containsClothingPieces(JsonArray jsonarray, String as[])
    {
        as = Arrays.asList(as);
        for (int i = 0; i < jsonarray.size(); i++)
        {
            if (as.indexOf(jsonarray.get(i).getAsString()) == -1)
            {
                return true;
            }
        }

        return false;
    }

    private boolean getIsDressed(JsonObject jsonobject)
    {
        JsonElement jsonelement = jsonobject.get("new_clothes");
        if (jsonelement != null)
        {
            return containsClothingPieces(jsonelement.getAsJsonArray(), NEW_UNDERWEAR_ART);
        } else
        {
            return containsClothingPieces(jsonobject.get("clothes").getAsJsonArray(), UNDERWEAR_ART);
        }
    }

    public AvatarInfo deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        jsonelement = jsonelement.getAsJsonObject();
        int i = jsonelement.get("style").getAsInt();
        jsondeserializationcontext = jsonelement.get("styled_char_data").getAsJsonObject().get(Integer.toString(i)).getAsJsonObject();
        type = jsondeserializationcontext.get("colours").getAsJsonObject();
        jsondeserializationcontext = jsondeserializationcontext.get("body").getAsJsonObject();
        i = type.get("ffcc99").getAsInt();
        int j = jsondeserializationcontext.get("body_type").getAsInt();
        int k = jsondeserializationcontext.get("breast_type").getAsInt();
        jsonelement.addProperty("skinTone", Integer.valueOf(i));
        jsonelement.addProperty("bodyType", Integer.valueOf(j));
        jsonelement.addProperty("breastType", Integer.valueOf(k));
        jsonelement.addProperty("isDressed", Boolean.valueOf(getIsDressed(jsondeserializationcontext)));
        jsonelement.remove("styled_char_data");
        return (AvatarInfo)(new Gson()).fromJson(jsonelement, com/bitstrips/imoji/models/AvatarInfo);
    }

    public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
        throws JsonParseException
    {
        return deserialize(jsonelement, type, jsondeserializationcontext);
    }

}
