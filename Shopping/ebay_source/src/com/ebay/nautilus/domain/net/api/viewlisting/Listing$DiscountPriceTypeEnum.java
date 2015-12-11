// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;


// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            Listing

public static final class  extends Enum
{

    private static final CATEGORY_DEALS_PRICE $VALUES[];
    public static final CATEGORY_DEALS_PRICE CATEGORY_DEALS_PRICE;
    public static final CATEGORY_DEALS_PRICE DAILY_DEALS_PRICE;
    public static final CATEGORY_DEALS_PRICE MADE_FOR_OUTLET_PRICE;
    public static final CATEGORY_DEALS_PRICE MARK_DOWN_MANAGER_PRICE;
    public static final CATEGORY_DEALS_PRICE MINIMUM_ADVERTISED_PRICE;
    public static final CATEGORY_DEALS_PRICE ORIGINAL_PRICE;
    public static final CATEGORY_DEALS_PRICE STRIKE_THROUGH_PRICE;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/viewlisting/Listing$DiscountPriceTypeEnum, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        STRIKE_THROUGH_PRICE = new <init>("STRIKE_THROUGH_PRICE", 0);
        MINIMUM_ADVERTISED_PRICE = new <init>("MINIMUM_ADVERTISED_PRICE", 1);
        ORIGINAL_PRICE = new <init>("ORIGINAL_PRICE", 2);
        MADE_FOR_OUTLET_PRICE = new <init>("MADE_FOR_OUTLET_PRICE", 3);
        MARK_DOWN_MANAGER_PRICE = new <init>("MARK_DOWN_MANAGER_PRICE", 4);
        DAILY_DEALS_PRICE = new <init>("DAILY_DEALS_PRICE", 5);
        CATEGORY_DEALS_PRICE = new <init>("CATEGORY_DEALS_PRICE", 6);
        $VALUES = (new .VALUES[] {
            STRIKE_THROUGH_PRICE, MINIMUM_ADVERTISED_PRICE, ORIGINAL_PRICE, MADE_FOR_OUTLET_PRICE, MARK_DOWN_MANAGER_PRICE, DAILY_DEALS_PRICE, CATEGORY_DEALS_PRICE
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
