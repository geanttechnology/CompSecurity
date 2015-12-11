// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import roboguice.util.Strings;

public class Channel extends Enum
    implements Parcelable
{

    private static final Channel $VALUES[];
    public static final Channel ALLDEALS;
    public static final Channel ALL_CHANNELS;
    public static final Channel COUPONS;
    public static final Channel COUPON_CATEGORY;
    public static final Channel COUPON_DETAIL;
    public static final android.os.Parcelable.Creator CREATOR = new android.os.Parcelable.Creator() {

        public Channel createFromParcel(Parcel parcel)
        {
            return Channel.values()[parcel.readInt()];
        }

        public volatile Object createFromParcel(Parcel parcel)
        {
            return createFromParcel(parcel);
        }

        public Channel[] newArray(int i)
        {
            return new Channel[i];
        }

        public volatile Object[] newArray(int i)
        {
            return newArray(i);
        }

    };
    public static final Channel DEAL_SUBSET_MM;
    public static final Channel DEAL_SUBSET_SEARCH;
    public static final Channel DEAL_WIDGET;
    public static final Channel DETAIL;
    public static final Channel FEATURED;
    public static final Channel GETAWAYS;
    public static final Channel GLOBAL_SEARCH;
    public static final Channel GOODS;
    public static final Channel HOTELS;
    public static final Channel MARKET_RATE;
    public static final Channel MERCHANT_PAGE;
    public static final Channel MERCHANT_SPECIAL;
    public static final Channel NEARBY;
    public static final Channel OCCASIONS;
    private static String PATH_SEPARATOR = ":";
    public static final Channel POST_PURCHASE;
    public static final Channel POT_OF_GOLD;
    public static final Channel PULLNOTIFICATION;
    public static final Channel RAPI_SEARCH;
    public static final Channel SHOPPING;
    public static final Channel SHOPPING_CART;
    public static final Channel SNAP_GROCERY;
    public static final Channel TRAVEL;
    public static final Channel UNKNOWN;
    public static final Channel WIDGET;
    private static final Map nstChannelToChannelMap = Collections.unmodifiableMap(initializeNstToChannelMapping());

    private Channel(String s, int i)
    {
        super(s, i);
    }


    public static String channelDealIdsExtraKey(String s)
    {
        return String.format("%s_%s", new Object[] {
            safeValueOf(s).name(), "dealIds"
        });
    }

    public static Channel channelForNstChannel(String s)
    {
        return (Channel)nstChannelToChannelMap.get(s);
    }

    public static String[] decodePath(String s)
    {
        return s.split(PATH_SEPARATOR);
    }

    public static transient String encodePath(String as[])
    {
        String s = "";
        boolean flag = true;
        int j = as.length;
        int i = 0;
        while (i < j) 
        {
            String s1 = as[i];
            if (flag)
            {
                flag = false;
            } else
            {
                s = (new StringBuilder()).append(s).append(PATH_SEPARATOR).toString();
            }
            s = (new StringBuilder()).append(s).append(s1).toString();
            i++;
        }
        return s;
    }

    protected static Map initializeNstToChannelMapping()
    {
        HashMap hashmap = new HashMap();
        Channel achannel[] = values();
        int j = achannel.length;
        for (int i = 0; i < j; i++)
        {
            Channel channel = achannel[i];
            hashmap.put(channel.toString(), channel);
        }

        return hashmap;
    }

    public static boolean isChannelNavigableTo(String s)
    {
        s = safeValueOf(s);
        return s != null && s.isNavigableTo();
    }

    private void readObject(ObjectInputStream objectinputstream)
        throws IOException, ClassNotFoundException
    {
        throw new RuntimeException("Please use the Parcelable methods");
    }

    public static Channel safeValueOf(String s)
    {
        if (Strings.notEmpty(s))
        {
            Channel achannel[] = values();
            int j = achannel.length;
            for (int i = 0; i < j; i++)
            {
                Channel channel = achannel[i];
                if (channel.name().equalsIgnoreCase(s) || channel.compressedName().equalsIgnoreCase(s))
                {
                    return channel;
                }
            }

        }
        return null;
    }

    public static Channel valueOf(String s)
    {
        return (Channel)Enum.valueOf(com/groupon/Channel, s);
    }

    public static Channel[] values()
    {
        return (Channel[])$VALUES.clone();
    }

    private void writeObject(ObjectOutputStream objectoutputstream)
        throws IOException
    {
        throw new RuntimeException("Please use the Parcelable methods");
    }

    public String compressedName()
    {
        return name().substring(0, 3);
    }

    public int describeContents()
    {
        return 0;
    }

    public String extendedDatabaseChannel(String s)
    {
        return name();
    }

    public String extendedDatabaseChannel(String as[])
    {
        return name();
    }

    public boolean isNavigableTo()
    {
        return true;
    }

    public boolean supportsCategories()
    {
        return false;
    }

    public String toString()
    {
        return name().toLowerCase(Locale.ENGLISH);
    }

    public void writeToParcel(Parcel parcel, int i)
    {
        parcel.writeInt(ordinal());
    }

    static 
    {
        SHOPPING = new Channel("SHOPPING", 0);
        GETAWAYS = new Channel("GETAWAYS", 1);
        TRAVEL = new Channel("TRAVEL", 2);
        OCCASIONS = new Channel("OCCASIONS", 3);
        FEATURED = new Channel("FEATURED", 4);
        HOTELS = new Channel("HOTELS", 5);
        COUPONS = new Channel("COUPONS", 6);
        POT_OF_GOLD = new Channel("POT_OF_GOLD", 7);
        SNAP_GROCERY = new Channel("SNAP_GROCERY", 8);
        NEARBY = new Channel("NEARBY", 9) {

            public boolean supportsCategories()
            {
                return true;
            }

        };
        GOODS = new Channel("GOODS", 10) {

            public boolean supportsCategories()
            {
                return true;
            }

        };
        DETAIL = new Channel("DETAIL", 11) {

            public boolean isNavigableTo()
            {
                return false;
            }

        };
        COUPON_DETAIL = new Channel("COUPON_DETAIL", 12) {

            public boolean isNavigableTo()
            {
                return false;
            }

        };
        COUPON_CATEGORY = new Channel("COUPON_CATEGORY", 13) {

            public boolean isNavigableTo()
            {
                return false;
            }

        };
        POST_PURCHASE = new Channel("POST_PURCHASE", 14) {

            public boolean isNavigableTo()
            {
                return false;
            }

        };
        GLOBAL_SEARCH = new Channel("GLOBAL_SEARCH", 15) {

            public boolean isNavigableTo()
            {
                return false;
            }

            public boolean supportsCategories()
            {
                return true;
            }

        };
        RAPI_SEARCH = new Channel("RAPI_SEARCH", 16) {

            public boolean isNavigableTo()
            {
                return false;
            }

            public boolean supportsCategories()
            {
                return true;
            }

        };
        WIDGET = new Channel("WIDGET", 17) {

            public boolean isNavigableTo()
            {
                return false;
            }

        };
        UNKNOWN = new Channel("UNKNOWN", 18) {

            public boolean isNavigableTo()
            {
                return false;
            }

        };
        MARKET_RATE = new Channel("MARKET_RATE", 19) {

            public boolean isNavigableTo()
            {
                return false;
            }

        };
        ALLDEALS = new Channel("ALLDEALS", 20) {

            public boolean isNavigableTo()
            {
                return false;
            }

        };
        DEAL_SUBSET_MM = new Channel("DEAL_SUBSET_MM", 21) {

            public boolean isNavigableTo()
            {
                return false;
            }

        };
        DEAL_SUBSET_SEARCH = new Channel("DEAL_SUBSET_SEARCH", 22) {

            public boolean isNavigableTo()
            {
                return false;
            }

        };
        DEAL_WIDGET = new Channel("DEAL_WIDGET", 23) {

            public String extendedDatabaseChannel(String s)
            {
                return encodePath(new String[] {
                    name(), s
                });
            }

            public boolean isNavigableTo()
            {
                return false;
            }

        };
        PULLNOTIFICATION = new Channel("PULLNOTIFICATION", 24) {

            public boolean isNavigableTo()
            {
                return false;
            }

        };
        SHOPPING_CART = new Channel("SHOPPING_CART", 25) {

            public String extendedDatabaseChannel(String as[])
            {
                String s = "";
                int j = as.length;
                for (int i = 0; i < j; i++)
                {
                    String s1 = as[i];
                    s = (new StringBuilder()).append(s).append(s1).toString();
                }

                return encodePath(new String[] {
                    name(), Strings.md5(s)
                });
            }

            public boolean isNavigableTo()
            {
                return false;
            }

        };
        ALL_CHANNELS = new Channel("ALL_CHANNELS", 26) {

            public boolean isNavigableTo()
            {
                return false;
            }

        };
        MERCHANT_SPECIAL = new Channel("MERCHANT_SPECIAL", 27) {

            public boolean isNavigableTo()
            {
                return false;
            }

            public String toString()
            {
                return "merchant special";
            }

        };
        MERCHANT_PAGE = new Channel("MERCHANT_PAGE", 28) {

            public boolean isNavigableTo()
            {
                return false;
            }

        };
        $VALUES = (new Channel[] {
            SHOPPING, GETAWAYS, TRAVEL, OCCASIONS, FEATURED, HOTELS, COUPONS, POT_OF_GOLD, SNAP_GROCERY, NEARBY, 
            GOODS, DETAIL, COUPON_DETAIL, COUPON_CATEGORY, POST_PURCHASE, GLOBAL_SEARCH, RAPI_SEARCH, WIDGET, UNKNOWN, MARKET_RATE, 
            ALLDEALS, DEAL_SUBSET_MM, DEAL_SUBSET_SEARCH, DEAL_WIDGET, PULLNOTIFICATION, SHOPPING_CART, ALL_CHANNELS, MERCHANT_SPECIAL, MERCHANT_PAGE
        });
    }
}
