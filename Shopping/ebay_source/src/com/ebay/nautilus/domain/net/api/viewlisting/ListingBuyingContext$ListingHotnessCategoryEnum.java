// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            ListingBuyingContext

public static final class  extends Enum
{

    private static final DEALNESS $VALUES[];
    public static final DEALNESS ACTIVITY;
    public static final DEALNESS DEALNESS;
    public static final DEALNESS DELIVERY;
    public static final DEALNESS MISC;
    public static final DEALNESS POPULARITY;
    public static final DEALNESS PRICE;
    public static final DEALNESS QUANTITY;
    public static final DEALNESS RETURNS;
    public static final DEALNESS SELLER;
    public static final DEALNESS SHIPPING;
    public static final DEALNESS URGENCY;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/ListingBuyingContext$ListingHotnessCategoryEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ACTIVITY = new <init>("ACTIVITY", 0);
        MISC = new <init>("MISC", 1);
        PRICE = new <init>("PRICE", 2);
        QUANTITY = new <init>("QUANTITY", 3);
        RETURNS = new <init>("RETURNS", 4);
        SELLER = new <init>("SELLER", 5);
        SHIPPING = new <init>("SHIPPING", 6);
        DELIVERY = new <init>("DELIVERY", 7);
        URGENCY = new <init>("URGENCY", 8);
        POPULARITY = new <init>("POPULARITY", 9);
        DEALNESS = new <init>("DEALNESS", 10);
        $VALUES = (new .VALUES[] {
            ACTIVITY, MISC, PRICE, QUANTITY, RETURNS, SELLER, SHIPPING, DELIVERY, URGENCY, POPULARITY, 
            DEALNESS
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
