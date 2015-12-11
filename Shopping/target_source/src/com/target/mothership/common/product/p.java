// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.common.product;


public final class p extends Enum
{

    private static final p $VALUES[];
    public static final p BEST_SELLING;
    public static final p NEWEST;
    public static final p PRICE_HIGH;
    public static final p PRICE_LOW;
    public static final p RATING_HIGH;
    public static final p RELEVANCE;
    public static final p UNKNOWN;
    private String mValue;

    private p(String s, int i, String s1)
    {
        super(s, i);
        mValue = s1;
    }

    public static p valueOf(String s)
    {
        return (p)Enum.valueOf(com/target/mothership/common/product/p, s);
    }

    public static p[] values()
    {
        return (p[])$VALUES.clone();
    }

    public String toString()
    {
        return mValue;
    }

    static 
    {
        RELEVANCE = new p("RELEVANCE", 0, "relevance");
        PRICE_LOW = new p("PRICE_LOW", 1, "PriceLow");
        PRICE_HIGH = new p("PRICE_HIGH", 2, "PriceHigh");
        BEST_SELLING = new p("BEST_SELLING", 3, "bestselling");
        RATING_HIGH = new p("RATING_HIGH", 4, "RatingHigh");
        NEWEST = new p("NEWEST", 5, "newest");
        UNKNOWN = new p("UNKNOWN", 6, "");
        $VALUES = (new p[] {
            RELEVANCE, PRICE_LOW, PRICE_HIGH, BEST_SELLING, RATING_HIGH, NEWEST, UNKNOWN
        });
    }
}
