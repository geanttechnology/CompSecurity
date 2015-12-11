// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.model.cart;

import android.text.TextUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

// Referenced classes of package com.ebay.common.model.cart:
//            LogisticsPlans

public static final class altName extends Enum
{
    public static class Deserializer
        implements JsonDeserializer
    {

        public LogisticsPlans.LogisticsPlan.Type deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            return LogisticsPlans.LogisticsPlan.Type.fromToken(jsonelement.getAsString());
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


    private static final PUDO $VALUES[];
    public static final PUDO EBAY_NOW;
    public static final PUDO GLOBAL_SHIPPING;
    public static final PUDO ISPU;
    public static final PUDO PUDO;
    public static final PUDO SHIP_TO_HOME;
    public static final PUDO UNKNOWN;
    public final String altName;
    public final String longName;

    public static Deserializer.deserialize fromOrdinal(int i)
    {
        Deserializer.deserialize adeserialize[] = values();
        int k = adeserialize.length;
        for (int j = 0; j < k; j++)
        {
            Deserializer.deserialize deserialize = adeserialize[j];
            if (deserialize.ordinal() == i)
            {
                return deserialize;
            }
        }

        return UNKNOWN;
    }

    public static final UNKNOWN fromToken(String s)
    {
        UNKNOWN aunknown[] = values();
        int j = aunknown.length;
        for (int i = 0; i < j; i++)
        {
            UNKNOWN unknown = aunknown[i];
            if (TextUtils.equals(s, unknown.longName) || TextUtils.equals(s, unknown.altName))
            {
                return unknown;
            }
        }

        return UNKNOWN;
    }

    public static UNKNOWN valueOf(String s)
    {
        return (UNKNOWN)Enum.valueOf(com/ebay/common/model/cart/LogisticsPlans$LogisticsPlan$Type, s);
    }

    public static UNKNOWN[] values()
    {
        return (UNKNOWN[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0, "Unknown");
        SHIP_TO_HOME = new <init>("SHIP_TO_HOME", 1, "ShipToHome");
        EBAY_NOW = new <init>("EBAY_NOW", 2, "ValetService");
        ISPU = new <init>("ISPU", 3, "InStorePickup");
        GLOBAL_SHIPPING = new <init>("GLOBAL_SHIPPING", 4, "GlobalShipping");
        PUDO = new <init>("PUDO", 5, "PickupAndDropoff", "PickUpDropOff");
        $VALUES = (new .VALUES[] {
            UNKNOWN, SHIP_TO_HOME, EBAY_NOW, ISPU, GLOBAL_SHIPPING, PUDO
        });
    }

    private Deserializer(String s, int i, String s1)
    {
        super(s, i);
        longName = s1;
        altName = s1;
    }

    private altName(String s, int i, String s1, String s2)
    {
        super(s, i);
        longName = s1;
        altName = s2;
    }
}
