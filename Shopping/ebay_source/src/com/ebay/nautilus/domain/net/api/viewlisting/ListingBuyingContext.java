// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;

import android.text.TextUtils;
import com.ebay.nautilus.domain.data.BaseCommonType;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ListingBuyingContext extends BaseCommonType
{
    public static final class ListingHotnessCategoryEnum extends Enum
    {

        private static final ListingHotnessCategoryEnum $VALUES[];
        public static final ListingHotnessCategoryEnum ACTIVITY;
        public static final ListingHotnessCategoryEnum DEALNESS;
        public static final ListingHotnessCategoryEnum DELIVERY;
        public static final ListingHotnessCategoryEnum MISC;
        public static final ListingHotnessCategoryEnum POPULARITY;
        public static final ListingHotnessCategoryEnum PRICE;
        public static final ListingHotnessCategoryEnum QUANTITY;
        public static final ListingHotnessCategoryEnum RETURNS;
        public static final ListingHotnessCategoryEnum SELLER;
        public static final ListingHotnessCategoryEnum SHIPPING;
        public static final ListingHotnessCategoryEnum URGENCY;

        public static ListingHotnessCategoryEnum valueOf(String s)
        {
            return (ListingHotnessCategoryEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/ListingBuyingContext$ListingHotnessCategoryEnum, s);
        }

        public static ListingHotnessCategoryEnum[] values()
        {
            return (ListingHotnessCategoryEnum[])$VALUES.clone();
        }

        static 
        {
            ACTIVITY = new ListingHotnessCategoryEnum("ACTIVITY", 0);
            MISC = new ListingHotnessCategoryEnum("MISC", 1);
            PRICE = new ListingHotnessCategoryEnum("PRICE", 2);
            QUANTITY = new ListingHotnessCategoryEnum("QUANTITY", 3);
            RETURNS = new ListingHotnessCategoryEnum("RETURNS", 4);
            SELLER = new ListingHotnessCategoryEnum("SELLER", 5);
            SHIPPING = new ListingHotnessCategoryEnum("SHIPPING", 6);
            DELIVERY = new ListingHotnessCategoryEnum("DELIVERY", 7);
            URGENCY = new ListingHotnessCategoryEnum("URGENCY", 8);
            POPULARITY = new ListingHotnessCategoryEnum("POPULARITY", 9);
            DEALNESS = new ListingHotnessCategoryEnum("DEALNESS", 10);
            $VALUES = (new ListingHotnessCategoryEnum[] {
                ACTIVITY, MISC, PRICE, QUANTITY, RETURNS, SELLER, SHIPPING, DELIVERY, URGENCY, POPULARITY, 
                DEALNESS
            });
        }

        private ListingHotnessCategoryEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ListingHotnessDetail
        implements Comparable
    {

        public int hotnessLevel;
        public String hotnessMessage;
        public int hotnessRank;
        public List properties;
        protected transient Map propertyMap;
        public ListingHotnessEnum signal;
        public ListingHotnessCategoryEnum signalCategory;

        public int compareTo(ListingHotnessDetail listinghotnessdetail)
        {
            return hotnessRank - listinghotnessdetail.hotnessRank;
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((ListingHotnessDetail)obj);
        }

        public Map getPropertyMap()
        {
            if (propertyMap == null)
            {
                propertyMap = new HashMap();
                if (properties != null)
                {
                    Iterator iterator = properties.iterator();
                    do
                    {
                        if (!iterator.hasNext())
                        {
                            break;
                        }
                        com.ebay.nautilus.domain.data.BaseCommonType.Property property = (com.ebay.nautilus.domain.data.BaseCommonType.Property)iterator.next();
                        if (property != null)
                        {
                            propertyMap.put(property.propertyName, property.propertyValues);
                        }
                    } while (true);
                }
            }
            return propertyMap;
        }

        public ListingHotnessDetail()
        {
        }
    }

    public static final class ListingHotnessEnum extends Enum
    {

        private static final ListingHotnessEnum $VALUES[];
        public static final ListingHotnessEnum ALMOST_GONE_SIGNAL;
        public static final ListingHotnessEnum AUTO_IDENTIFIED_DEAL_SIGNAL;
        public static final ListingHotnessEnum CHARITY_DONATION_SIGNAL;
        public static final ListingHotnessEnum COUNTDOWN_URGENCY_SIGNAL;
        public static final ListingHotnessEnum DEAL_TIMER_SIGNAL;
        public static final ListingHotnessEnum LAST_ONE_SIGNAL;
        public static final ListingHotnessEnum OVER_X_SOLD_SIGNAL;
        public static final ListingHotnessEnum QTY_SOLD_1_HOUR_SIGNAL;
        public static final ListingHotnessEnum QTY_SOLD_24_HOUR_SIGNAL;
        public static final ListingHotnessEnum QTY_SOLD_TOTAL_SIGNAL;
        public static final ListingHotnessEnum UNKNOWN;

        public static ListingHotnessEnum valueOf(String s)
        {
            return (ListingHotnessEnum)Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/ListingBuyingContext$ListingHotnessEnum, s);
        }

        public static ListingHotnessEnum[] values()
        {
            return (ListingHotnessEnum[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new ListingHotnessEnum("UNKNOWN", 0);
            COUNTDOWN_URGENCY_SIGNAL = new ListingHotnessEnum("COUNTDOWN_URGENCY_SIGNAL", 1);
            ALMOST_GONE_SIGNAL = new ListingHotnessEnum("ALMOST_GONE_SIGNAL", 2);
            LAST_ONE_SIGNAL = new ListingHotnessEnum("LAST_ONE_SIGNAL", 3);
            QTY_SOLD_1_HOUR_SIGNAL = new ListingHotnessEnum("QTY_SOLD_1_HOUR_SIGNAL", 4);
            QTY_SOLD_24_HOUR_SIGNAL = new ListingHotnessEnum("QTY_SOLD_24_HOUR_SIGNAL", 5);
            QTY_SOLD_TOTAL_SIGNAL = new ListingHotnessEnum("QTY_SOLD_TOTAL_SIGNAL", 6);
            DEAL_TIMER_SIGNAL = new ListingHotnessEnum("DEAL_TIMER_SIGNAL", 7);
            OVER_X_SOLD_SIGNAL = new ListingHotnessEnum("OVER_X_SOLD_SIGNAL", 8);
            AUTO_IDENTIFIED_DEAL_SIGNAL = new ListingHotnessEnum("AUTO_IDENTIFIED_DEAL_SIGNAL", 9);
            CHARITY_DONATION_SIGNAL = new ListingHotnessEnum("CHARITY_DONATION_SIGNAL", 10);
            $VALUES = (new ListingHotnessEnum[] {
                UNKNOWN, COUNTDOWN_URGENCY_SIGNAL, ALMOST_GONE_SIGNAL, LAST_ONE_SIGNAL, QTY_SOLD_1_HOUR_SIGNAL, QTY_SOLD_24_HOUR_SIGNAL, QTY_SOLD_TOTAL_SIGNAL, DEAL_TIMER_SIGNAL, OVER_X_SOLD_SIGNAL, AUTO_IDENTIFIED_DEAL_SIGNAL, 
                CHARITY_DONATION_SIGNAL
            });
        }

        private ListingHotnessEnum(String s, int i)
        {
            super(s, i);
        }
    }

    public static class ListingHotnessEnum.Deserializer
        implements JsonDeserializer
    {

        public ListingHotnessEnum deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            jsonelement = jsonelement.getAsString();
            if (!TextUtils.isEmpty(jsonelement))
            {
                type = ListingHotnessEnum.values();
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
            return ListingHotnessEnum.UNKNOWN;
        }

        public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            return deserialize(jsonelement, type, jsondeserializationcontext);
        }

        public ListingHotnessEnum.Deserializer()
        {
        }
    }

    public static final class StatusMessageDetail
    {

        public List actions;
        public List properties;
        public int rank;
        public String statusMsgCode;

        public StatusMessageDetail()
        {
        }
    }


    public List signals;
    public List statusMessages;

    public ListingBuyingContext()
    {
    }
}
