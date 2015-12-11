// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.view.dealcards;


// Referenced classes of package com.groupon.view.dealcards:
//            DealCardView

public static final class  extends Enum
{

    private static final BADGES $VALUES[];
    public static final BADGES BADGES;
    public static final BADGES BOUGHTS;
    public static final BADGES DATE_TIME_SEARCH_TIME_PILLS;
    public static final BADGES GOODS_CONNECTED_MARKETPLACE;
    public static final BADGES G_BUCKS;
    public static final BADGES INCENTIVE;
    public static final BADGES LOCATION;
    public static final BADGES MOBILE_ONLY;
    public static final BADGES PRICE;
    public static final BADGES RAO_DISCOUNT;
    public static final BADGES RAO_OFFER;
    public static final BADGES RATING;
    public static final BADGES REFERENCE_PRICE;
    public static final BADGES SOLD_OUT;
    public static final BADGES URGENT_INFO;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/groupon/view/dealcards/DealCardView$DisplayOption, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        LOCATION = new <init>("LOCATION", 0);
        INCENTIVE = new <init>("INCENTIVE", 1);
        PRICE = new <init>("PRICE", 2);
        REFERENCE_PRICE = new <init>("REFERENCE_PRICE", 3);
        G_BUCKS = new <init>("G_BUCKS", 4);
        RAO_OFFER = new <init>("RAO_OFFER", 5);
        RAO_DISCOUNT = new <init>("RAO_DISCOUNT", 6);
        MOBILE_ONLY = new <init>("MOBILE_ONLY", 7);
        URGENT_INFO = new <init>("URGENT_INFO", 8);
        RATING = new <init>("RATING", 9);
        BOUGHTS = new <init>("BOUGHTS", 10);
        SOLD_OUT = new <init>("SOLD_OUT", 11);
        GOODS_CONNECTED_MARKETPLACE = new <init>("GOODS_CONNECTED_MARKETPLACE", 12);
        DATE_TIME_SEARCH_TIME_PILLS = new <init>("DATE_TIME_SEARCH_TIME_PILLS", 13);
        BADGES = new <init>("BADGES", 14);
        $VALUES = (new .VALUES[] {
            LOCATION, INCENTIVE, PRICE, REFERENCE_PRICE, G_BUCKS, RAO_OFFER, RAO_DISCOUNT, MOBILE_ONLY, URGENT_INFO, RATING, 
            BOUGHTS, SOLD_OUT, GOODS_CONNECTED_MARKETPLACE, DATE_TIME_SEARCH_TIME_PILLS, BADGES
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
