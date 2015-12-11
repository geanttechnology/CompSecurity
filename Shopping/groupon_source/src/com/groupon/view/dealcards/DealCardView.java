// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.dealcards;

import com.groupon.util.ImageUrl;

public interface DealCardView
{
    public static final class DisplayOption extends Enum
    {

        private static final DisplayOption $VALUES[];
        public static final DisplayOption BADGES;
        public static final DisplayOption BOUGHTS;
        public static final DisplayOption DATE_TIME_SEARCH_TIME_PILLS;
        public static final DisplayOption GOODS_CONNECTED_MARKETPLACE;
        public static final DisplayOption G_BUCKS;
        public static final DisplayOption INCENTIVE;
        public static final DisplayOption LOCATION;
        public static final DisplayOption MOBILE_ONLY;
        public static final DisplayOption PRICE;
        public static final DisplayOption RAO_DISCOUNT;
        public static final DisplayOption RAO_OFFER;
        public static final DisplayOption RATING;
        public static final DisplayOption REFERENCE_PRICE;
        public static final DisplayOption SOLD_OUT;
        public static final DisplayOption URGENT_INFO;

        public static DisplayOption valueOf(String s)
        {
            return (DisplayOption)Enum.valueOf(com/groupon/view/dealcards/DealCardView$DisplayOption, s);
        }

        public static DisplayOption[] values()
        {
            return (DisplayOption[])$VALUES.clone();
        }

        static 
        {
            LOCATION = new DisplayOption("LOCATION", 0);
            INCENTIVE = new DisplayOption("INCENTIVE", 1);
            PRICE = new DisplayOption("PRICE", 2);
            REFERENCE_PRICE = new DisplayOption("REFERENCE_PRICE", 3);
            G_BUCKS = new DisplayOption("G_BUCKS", 4);
            RAO_OFFER = new DisplayOption("RAO_OFFER", 5);
            RAO_DISCOUNT = new DisplayOption("RAO_DISCOUNT", 6);
            MOBILE_ONLY = new DisplayOption("MOBILE_ONLY", 7);
            URGENT_INFO = new DisplayOption("URGENT_INFO", 8);
            RATING = new DisplayOption("RATING", 9);
            BOUGHTS = new DisplayOption("BOUGHTS", 10);
            SOLD_OUT = new DisplayOption("SOLD_OUT", 11);
            GOODS_CONNECTED_MARKETPLACE = new DisplayOption("GOODS_CONNECTED_MARKETPLACE", 12);
            DATE_TIME_SEARCH_TIME_PILLS = new DisplayOption("DATE_TIME_SEARCH_TIME_PILLS", 13);
            BADGES = new DisplayOption("BADGES", 14);
            $VALUES = (new DisplayOption[] {
                LOCATION, INCENTIVE, PRICE, REFERENCE_PRICE, G_BUCKS, RAO_OFFER, RAO_DISCOUNT, MOBILE_ONLY, URGENT_INFO, RATING, 
                BOUGHTS, SOLD_OUT, GOODS_CONNECTED_MARKETPLACE, DATE_TIME_SEARCH_TIME_PILLS, BADGES
            });
        }

        private DisplayOption(String s, int i)
        {
            super(s, i);
        }
    }


    public abstract void displayOption(DisplayOption displayoption, boolean flag);

    public abstract void setBadges(CharSequence charsequence, int i, int j);

    public abstract void setBoughts(CharSequence charsequence);

    public abstract void setGBucks(CharSequence charsequence);

    public abstract void setGoodsConnectedMarketPlaceText(CharSequence charsequence);

    public abstract void setImage(ImageUrl imageurl);

    public abstract void setIncentiveText(CharSequence charsequence);

    public abstract void setLocation(CharSequence charsequence);

    public abstract void setPrice(CharSequence charsequence);

    public abstract void setPriceColor(int i);

    public abstract void setRating(double d);

    public abstract void setReferencePrice(CharSequence charsequence);

    public abstract void setSoldOutText(CharSequence charsequence);

    public abstract void setTitle(CharSequence charsequence);

    public abstract void setUrgentInfo(CharSequence charsequence);

    public abstract void strikePrice(boolean flag);

    public abstract void strikeReferencePrice(boolean flag);
}
