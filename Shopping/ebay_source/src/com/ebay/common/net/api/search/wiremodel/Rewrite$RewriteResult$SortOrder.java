// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search.wiremodel;


// Referenced classes of package com.ebay.common.net.api.search.wiremodel:
//            Rewrite

public static final class apiName extends Enum
{

    private static final END_DATE_RECENT $VALUES[];
    public static final END_DATE_RECENT BEST_MATCH;
    public static final END_DATE_RECENT BID_COUNT_FEWEST;
    public static final END_DATE_RECENT BID_COUNT_MOST;
    public static final END_DATE_RECENT CONDITION_NEW_FIRST;
    public static final END_DATE_RECENT CONDITION_USED_FIRST;
    public static final END_DATE_RECENT COUNTRY_ASCENDING;
    public static final END_DATE_RECENT COUNTRY_DESCENDING;
    public static final END_DATE_RECENT COUNTRY_REGION_DOWN;
    public static final END_DATE_RECENT COUNTRY_REGION_UP;
    public static final END_DATE_RECENT CURRENT_PRICE_HIGHEST;
    public static final END_DATE_RECENT CURRENT_PRICE_LOWEST;
    public static final END_DATE_RECENT DATE_LISTED_OLDEST_FIRST;
    public static final END_DATE_RECENT DISTANCE_NEAREST;
    public static final END_DATE_RECENT END_DATE_RECENT;
    public static final END_DATE_RECENT END_TIME_SOONEST;
    public static final END_DATE_RECENT MILEAGE_HIGHEST;
    public static final END_DATE_RECENT MILEAGE_LOWEST;
    public static final END_DATE_RECENT PRICE_PLUS_SHIPPING_HIGHEST;
    public static final END_DATE_RECENT PRICE_PLUS_SHIPPING_LOWEST;
    public static final END_DATE_RECENT START_TIME_NEWEST;
    public static final END_DATE_RECENT UNKNOWN;
    public static final END_DATE_RECENT YEAR_HIGHEST;
    public static final END_DATE_RECENT YEAR_LOWEST;
    String apiName;

    public static apiName valueOf(String s)
    {
        return (apiName)Enum.valueOf(com/ebay/common/net/api/search/wiremodel/Rewrite$RewriteResult$SortOrder, s);
    }

    public static apiName[] values()
    {
        return (apiName[])$VALUES.clone();
    }

    static 
    {
        UNKNOWN = new <init>("UNKNOWN", 0, "Unknown");
        BEST_MATCH = new <init>("BEST_MATCH", 1, "BestMatch");
        CURRENT_PRICE_LOWEST = new <init>("CURRENT_PRICE_LOWEST", 2, "CurrentPriceLowest");
        CURRENT_PRICE_HIGHEST = new <init>("CURRENT_PRICE_HIGHEST", 3, "CurrentPriceHighest");
        DISTANCE_NEAREST = new <init>("DISTANCE_NEAREST", 4, "DistanceNearest");
        END_TIME_SOONEST = new <init>("END_TIME_SOONEST", 5, "EndTimeSoonest");
        PRICE_PLUS_SHIPPING_LOWEST = new <init>("PRICE_PLUS_SHIPPING_LOWEST", 6, "PricePlusShippingLowest");
        PRICE_PLUS_SHIPPING_HIGHEST = new <init>("PRICE_PLUS_SHIPPING_HIGHEST", 7, "PricePlusShippingHighest");
        START_TIME_NEWEST = new <init>("START_TIME_NEWEST", 8, "StartTimeNewest");
        BID_COUNT_MOST = new <init>("BID_COUNT_MOST", 9, "BidCountMost");
        BID_COUNT_FEWEST = new <init>("BID_COUNT_FEWEST", 10, "BidCountFewest");
        COUNTRY_ASCENDING = new <init>("COUNTRY_ASCENDING", 11, "CountryAscending");
        COUNTRY_DESCENDING = new <init>("COUNTRY_DESCENDING", 12, "CountryDescending");
        CONDITION_NEW_FIRST = new <init>("CONDITION_NEW_FIRST", 13, "ConditionNewFirst");
        CONDITION_USED_FIRST = new <init>("CONDITION_USED_FIRST", 14, "ConditionUsedFirst");
        COUNTRY_REGION_DOWN = new <init>("COUNTRY_REGION_DOWN", 15, "CountryRegionDown");
        COUNTRY_REGION_UP = new <init>("COUNTRY_REGION_UP", 16, "CountryRegionUp");
        MILEAGE_LOWEST = new <init>("MILEAGE_LOWEST", 17, "MileageLowest");
        MILEAGE_HIGHEST = new <init>("MILEAGE_HIGHEST", 18, "MileageHighest");
        YEAR_LOWEST = new <init>("YEAR_LOWEST", 19, "YearLowest");
        YEAR_HIGHEST = new <init>("YEAR_HIGHEST", 20, "YearHighest");
        DATE_LISTED_OLDEST_FIRST = new <init>("DATE_LISTED_OLDEST_FIRST", 21, "DateListedOldestFirst");
        END_DATE_RECENT = new <init>("END_DATE_RECENT", 22, "EndDateRecent");
        $VALUES = (new .VALUES[] {
            UNKNOWN, BEST_MATCH, CURRENT_PRICE_LOWEST, CURRENT_PRICE_HIGHEST, DISTANCE_NEAREST, END_TIME_SOONEST, PRICE_PLUS_SHIPPING_LOWEST, PRICE_PLUS_SHIPPING_HIGHEST, START_TIME_NEWEST, BID_COUNT_MOST, 
            BID_COUNT_FEWEST, COUNTRY_ASCENDING, COUNTRY_DESCENDING, CONDITION_NEW_FIRST, CONDITION_USED_FIRST, COUNTRY_REGION_DOWN, COUNTRY_REGION_UP, MILEAGE_LOWEST, MILEAGE_HIGHEST, YEAR_LOWEST, 
            YEAR_HIGHEST, DATE_LISTED_OLDEST_FIRST, END_DATE_RECENT
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        apiName = s1;
    }
}
