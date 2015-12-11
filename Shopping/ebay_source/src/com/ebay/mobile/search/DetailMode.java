// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.search;


public final class DetailMode extends Enum
{

    private static final DetailMode $VALUES[];
    public static final DetailMode ASPECTS;
    public static final DetailMode AUCTION_FORMAT;
    public static final DetailMode CATEGORIES;
    public static final DetailMode CONDITION;
    public static final DetailMode DELIVERY_OPTIONS;
    public static final DetailMode NEAR;
    public static final DetailMode NONE;
    public static final DetailMode OTHER;
    public static final DetailMode PRICE;
    public static final DetailMode ROOT;
    public static final DetailMode SL_DISTANCE;
    public static final DetailMode SL_ITEMLOCATION;
    public static final DetailMode SORT;

    private DetailMode(String s, int i)
    {
        super(s, i);
    }

    public static DetailMode valueOf(String s)
    {
        return (DetailMode)Enum.valueOf(com/ebay/mobile/search/DetailMode, s);
    }

    public static DetailMode[] values()
    {
        return (DetailMode[])$VALUES.clone();
    }

    static 
    {
        NONE = new DetailMode("NONE", 0);
        CATEGORIES = new DetailMode("CATEGORIES", 1);
        ASPECTS = new DetailMode("ASPECTS", 2);
        AUCTION_FORMAT = new DetailMode("AUCTION_FORMAT", 3);
        CONDITION = new DetailMode("CONDITION", 4);
        PRICE = new DetailMode("PRICE", 5);
        ROOT = new DetailMode("ROOT", 6);
        DELIVERY_OPTIONS = new DetailMode("DELIVERY_OPTIONS", 7);
        SL_DISTANCE = new DetailMode("SL_DISTANCE", 8);
        SL_ITEMLOCATION = new DetailMode("SL_ITEMLOCATION", 9);
        SORT = new DetailMode("SORT", 10);
        OTHER = new DetailMode("OTHER", 11);
        NEAR = new DetailMode("NEAR", 12);
        $VALUES = (new DetailMode[] {
            NONE, CATEGORIES, ASPECTS, AUCTION_FORMAT, CONDITION, PRICE, ROOT, DELIVERY_OPTIONS, SL_DISTANCE, SL_ITEMLOCATION, 
            SORT, OTHER, NEAR
        });
    }
}
