// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;

import android.text.TextUtils;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;

// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class Deserializer extends Enum
{
    public static class Deserializer
        implements JsonDeserializer
    {

        public Listing.DeliveryEstimateTreatmentEnum deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            jsonelement = jsonelement.getAsString();
            if (!TextUtils.isEmpty(jsonelement))
            {
                type = Listing.DeliveryEstimateTreatmentEnum.values();
                int j = type.length;
                for (int i = 0; i < j; i++)
                {
                    jsondeserializationcontext = type[i];
                    if (TextUtils.equals(jsondeserializationcontext.name(), jsonelement))
                    {
                        return jsondeserializationcontext;
                    }
                }

            }
            if ("EBAY_FAST_AND_FREE".equals(jsonelement))
            {
                return Listing.DeliveryEstimateTreatmentEnum.FAST_AND_FREE;
            } else
            {
                return Listing.DeliveryEstimateTreatmentEnum.UNKNOWN;
            }
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


    private static final UNKNOWN $VALUES[];
    public static final UNKNOWN ANALYTICAL_TWO_DAY_SHIPPING;
    public static final UNKNOWN EBAY_NOW_IMMEDIATE;
    public static final UNKNOWN EBAY_NOW_NEXT_DAY;
    public static final UNKNOWN EBAY_NOW_SAME_DAY;
    public static final UNKNOWN EBAY_NOW_SCHEDULED;
    public static final UNKNOWN FAST_AND_FREE;
    public static final UNKNOWN GURANTEED_HOLIDAY_DELIVERY;
    public static final UNKNOWN NONE;
    public static final UNKNOWN ONE_DAY_DISPATCH;
    public static final UNKNOWN SHIPMENT_DELIVERY_ESTIMATE_ACCURACY;
    public static final UNKNOWN TWO_DAY_SHIPPING;
    public static final UNKNOWN UNKNOWN;

    public static Deserializer.deserialize valueOf(String s)
    {
        return (Deserializer.deserialize)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$DeliveryEstimateTreatmentEnum, s);
    }

    public static Deserializer.deserialize[] values()
    {
        return (Deserializer.deserialize[])$VALUES.clone();
    }

    static 
    {
        NONE = new <init>("NONE", 0);
        GURANTEED_HOLIDAY_DELIVERY = new <init>("GURANTEED_HOLIDAY_DELIVERY", 1);
        FAST_AND_FREE = new <init>("FAST_AND_FREE", 2);
        SHIPMENT_DELIVERY_ESTIMATE_ACCURACY = new <init>("SHIPMENT_DELIVERY_ESTIMATE_ACCURACY", 3);
        ONE_DAY_DISPATCH = new <init>("ONE_DAY_DISPATCH", 4);
        TWO_DAY_SHIPPING = new <init>("TWO_DAY_SHIPPING", 5);
        ANALYTICAL_TWO_DAY_SHIPPING = new <init>("ANALYTICAL_TWO_DAY_SHIPPING", 6);
        EBAY_NOW_IMMEDIATE = new <init>("EBAY_NOW_IMMEDIATE", 7);
        EBAY_NOW_SCHEDULED = new <init>("EBAY_NOW_SCHEDULED", 8);
        EBAY_NOW_NEXT_DAY = new <init>("EBAY_NOW_NEXT_DAY", 9);
        EBAY_NOW_SAME_DAY = new <init>("EBAY_NOW_SAME_DAY", 10);
        UNKNOWN = new <init>("UNKNOWN", 11);
        $VALUES = (new .VALUES[] {
            NONE, GURANTEED_HOLIDAY_DELIVERY, FAST_AND_FREE, SHIPMENT_DELIVERY_ESTIMATE_ACCURACY, ONE_DAY_DISPATCH, TWO_DAY_SHIPPING, ANALYTICAL_TWO_DAY_SHIPPING, EBAY_NOW_IMMEDIATE, EBAY_NOW_SCHEDULED, EBAY_NOW_NEXT_DAY, 
            EBAY_NOW_SAME_DAY, UNKNOWN
        });
    }

    private Deserializer(String s, int i)
    {
        super(s, i);
    }
}
