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
//            ListingBuyingContext

public static final class Deserializer extends Enum
{
    public static class Deserializer
        implements JsonDeserializer
    {

        public ListingBuyingContext.ListingHotnessEnum deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            jsonelement = jsonelement.getAsString();
            if (!TextUtils.isEmpty(jsonelement))
            {
                type = ListingBuyingContext.ListingHotnessEnum.values();
                int j = type.length;
                for (int i = 0; i < j; i++)
                {
                    jsondeserializationcontext = type[i];
                    if (jsondeserializationcontext.name().equals(jsonelement))
                    {
                        return jsondeserializationcontext;
                    }
                }

            }
            return ListingBuyingContext.ListingHotnessEnum.UNKNOWN;
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


    private static final CHARITY_DONATION_SIGNAL $VALUES[];
    public static final CHARITY_DONATION_SIGNAL ALMOST_GONE_SIGNAL;
    public static final CHARITY_DONATION_SIGNAL AUTO_IDENTIFIED_DEAL_SIGNAL;
    public static final CHARITY_DONATION_SIGNAL CHARITY_DONATION_SIGNAL;
    public static final CHARITY_DONATION_SIGNAL COUNTDOWN_URGENCY_SIGNAL;
    public static final CHARITY_DONATION_SIGNAL DEAL_TIMER_SIGNAL;
    public static final CHARITY_DONATION_SIGNAL LAST_ONE_SIGNAL;
    public static final CHARITY_DONATION_SIGNAL OVER_X_SOLD_SIGNAL;
    public static final CHARITY_DONATION_SIGNAL QTY_SOLD_1_HOUR_SIGNAL;
    public static final CHARITY_DONATION_SIGNAL QTY_SOLD_24_HOUR_SIGNAL;
    public static final CHARITY_DONATION_SIGNAL QTY_SOLD_TOTAL_SIGNAL;
    public static final CHARITY_DONATION_SIGNAL UNKNOWN;

    public static Deserializer.deserialize valueOf(String s)
    {
        return (Deserializer.deserialize)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/ListingBuyingContext$ListingHotnessEnum, s);
    }

    public static Deserializer.deserialize[] values()
    {
        return (Deserializer.deserialize[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0);
        COUNTDOWN_URGENCY_SIGNAL = new <init>("COUNTDOWN_URGENCY_SIGNAL", 1);
        ALMOST_GONE_SIGNAL = new <init>("ALMOST_GONE_SIGNAL", 2);
        LAST_ONE_SIGNAL = new <init>("LAST_ONE_SIGNAL", 3);
        QTY_SOLD_1_HOUR_SIGNAL = new <init>("QTY_SOLD_1_HOUR_SIGNAL", 4);
        QTY_SOLD_24_HOUR_SIGNAL = new <init>("QTY_SOLD_24_HOUR_SIGNAL", 5);
        QTY_SOLD_TOTAL_SIGNAL = new <init>("QTY_SOLD_TOTAL_SIGNAL", 6);
        DEAL_TIMER_SIGNAL = new <init>("DEAL_TIMER_SIGNAL", 7);
        OVER_X_SOLD_SIGNAL = new <init>("OVER_X_SOLD_SIGNAL", 8);
        AUTO_IDENTIFIED_DEAL_SIGNAL = new <init>("AUTO_IDENTIFIED_DEAL_SIGNAL", 9);
        CHARITY_DONATION_SIGNAL = new <init>("CHARITY_DONATION_SIGNAL", 10);
        $VALUES = (new .VALUES[] {
            UNKNOWN, COUNTDOWN_URGENCY_SIGNAL, ALMOST_GONE_SIGNAL, LAST_ONE_SIGNAL, QTY_SOLD_1_HOUR_SIGNAL, QTY_SOLD_24_HOUR_SIGNAL, QTY_SOLD_TOTAL_SIGNAL, DEAL_TIMER_SIGNAL, OVER_X_SOLD_SIGNAL, AUTO_IDENTIFIED_DEAL_SIGNAL, 
            CHARITY_DONATION_SIGNAL
        });
    }

    private Deserializer(String s, int i)
    {
        super(s, i);
    }
}
