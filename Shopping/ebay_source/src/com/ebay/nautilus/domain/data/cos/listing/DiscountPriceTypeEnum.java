// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.cos.listing;


public final class DiscountPriceTypeEnum extends Enum
{

    private static final DiscountPriceTypeEnum $VALUES[];
    public static final DiscountPriceTypeEnum CATEGORY_DEALS_PRICE;
    public static final DiscountPriceTypeEnum DAILY_DEALS_PRICE;
    public static final DiscountPriceTypeEnum MADE_FOR_OUTLET_PRICE;
    public static final DiscountPriceTypeEnum MARK_DOWN_MANAGER_PRICE;
    public static final DiscountPriceTypeEnum MINIMUM_ADVERTISED_PRICE;
    public static final DiscountPriceTypeEnum ORIGINAL_PRICE;
    public static final DiscountPriceTypeEnum STRIKE_THROUGH_PRICE;
    public static final DiscountPriceTypeEnum UNKNOWN;

    private DiscountPriceTypeEnum(String s, int i)
    {
        super(s, i);
    }

    public static DiscountPriceTypeEnum valueOf(String s)
    {
        return (DiscountPriceTypeEnum)Enum.valueOf(com/ebay/nautilus/domain/data/cos/listing/DiscountPriceTypeEnum, s);
    }

    public static DiscountPriceTypeEnum[] values()
    {
        return (DiscountPriceTypeEnum[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new DiscountPriceTypeEnum("UNKNOWN", 0);
        ORIGINAL_PRICE = new DiscountPriceTypeEnum("ORIGINAL_PRICE", 1);
        STRIKE_THROUGH_PRICE = new DiscountPriceTypeEnum("STRIKE_THROUGH_PRICE", 2);
        MINIMUM_ADVERTISED_PRICE = new DiscountPriceTypeEnum("MINIMUM_ADVERTISED_PRICE", 3);
        MADE_FOR_OUTLET_PRICE = new DiscountPriceTypeEnum("MADE_FOR_OUTLET_PRICE", 4);
        MARK_DOWN_MANAGER_PRICE = new DiscountPriceTypeEnum("MARK_DOWN_MANAGER_PRICE", 5);
        DAILY_DEALS_PRICE = new DiscountPriceTypeEnum("DAILY_DEALS_PRICE", 6);
        CATEGORY_DEALS_PRICE = new DiscountPriceTypeEnum("CATEGORY_DEALS_PRICE", 7);
        $VALUES = (new DiscountPriceTypeEnum[] {
            UNKNOWN, ORIGINAL_PRICE, STRIKE_THROUGH_PRICE, MINIMUM_ADVERTISED_PRICE, MADE_FOR_OUTLET_PRICE, MARK_DOWN_MANAGER_PRICE, DAILY_DEALS_PRICE, CATEGORY_DEALS_PRICE
        });
    }
}
