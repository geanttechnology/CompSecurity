// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

// Referenced classes of package com.ebay.nautilus.domain.net:
//            EbayResponseError

public static final class Deserializer extends Enum
{
    public static class Deserializer
        implements JsonDeserializer
    {

        public EbayResponseError.RecommendedAction deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            jsonelement = jsonelement.getAsString();
            type = EbayResponseError.RecommendedAction.values();
            int j = type.length;
            for (int i = 0; i < j; i++)
            {
                jsondeserializationcontext = type[i];
                if (jsondeserializationcontext.name().equalsIgnoreCase(jsonelement))
                {
                    return jsondeserializationcontext;
                }
            }

            return EbayResponseError.RecommendedAction.NONE;
        }

        public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            return deserialize(jsonelement, type, jsondeserializationcontext);
        }

        public Deserializer()
        {
        }
    }


    private static final CONSULTTECHSUPPORT $VALUES[];
    public static final CONSULTTECHSUPPORT CONSULTTECHSUPPORT;
    public static final CONSULTTECHSUPPORT CORRECTINPUTDATA;
    public static final CONSULTTECHSUPPORT NONE;
    public static final CONSULTTECHSUPPORT RETRY;

    public static Deserializer.deserialize valueOf(String s)
    {
        return (Deserializer.deserialize)Enum.valueOf(com/ebay/nautilus/domain/net/EbayResponseError$RecommendedAction, s);
    }

    public static Deserializer.deserialize[] values()
    {
        return (Deserializer.deserialize[])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        RETRY = new <init>("RETRY", 1);
        CORRECTINPUTDATA = new <init>("CORRECTINPUTDATA", 2);
        CONSULTTECHSUPPORT = new <init>("CONSULTTECHSUPPORT", 3);
        $VALUES = (new .VALUES[] {
            NONE, RETRY, CORRECTINPUTDATA, CONSULTTECHSUPPORT
        });
    }

    private Deserializer(String s, int i)
    {
        super(s, i);
    }
}
