// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;


// Referenced classes of package com.ebay.common.net.api.followinterest:
//            SaasSearchRequest

public static final class  extends Enum
{

    private static final EndDateRecent $VALUES[];
    public static final EndDateRecent BestMatch;
    public static final EndDateRecent BidCountFewest;
    public static final EndDateRecent BidCountMost;
    public static final EndDateRecent ConditionNewFirst;
    public static final EndDateRecent ConditionUsedFirst;
    public static final EndDateRecent CountryAscending;
    public static final EndDateRecent CountryDescending;
    public static final EndDateRecent CountryRegionDown;
    public static final EndDateRecent CountryRegionUp;
    public static final EndDateRecent CurrentPriceHighest;
    public static final EndDateRecent CurrentPriceLowest;
    public static final EndDateRecent DateListedOldestFirst;
    public static final EndDateRecent DistanceNearest;
    public static final EndDateRecent EndDateRecent;
    public static final EndDateRecent EndTimeSoonest;
    public static final EndDateRecent MileageHighest;
    public static final EndDateRecent MileageLowest;
    public static final EndDateRecent PricePlusShippingHighest;
    public static final EndDateRecent PricePlusShippingLowest;
    public static final EndDateRecent StartTimeNewest;
    public static final EndDateRecent YearHighest;
    public static final EndDateRecent YearLowest;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/common/net/api/followinterest/SaasSearchRequest$SortOrder, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        BestMatch = new <init>("BestMatch", 0);
        CurrentPriceLowest = new <init>("CurrentPriceLowest", 1);
        CurrentPriceHighest = new <init>("CurrentPriceHighest", 2);
        DistanceNearest = new <init>("DistanceNearest", 3);
        EndTimeSoonest = new <init>("EndTimeSoonest", 4);
        PricePlusShippingLowest = new <init>("PricePlusShippingLowest", 5);
        PricePlusShippingHighest = new <init>("PricePlusShippingHighest", 6);
        StartTimeNewest = new <init>("StartTimeNewest", 7);
        BidCountMost = new <init>("BidCountMost", 8);
        BidCountFewest = new <init>("BidCountFewest", 9);
        CountryAscending = new <init>("CountryAscending", 10);
        CountryDescending = new <init>("CountryDescending", 11);
        ConditionNewFirst = new <init>("ConditionNewFirst", 12);
        ConditionUsedFirst = new <init>("ConditionUsedFirst", 13);
        CountryRegionDown = new <init>("CountryRegionDown", 14);
        CountryRegionUp = new <init>("CountryRegionUp", 15);
        MileageLowest = new <init>("MileageLowest", 16);
        MileageHighest = new <init>("MileageHighest", 17);
        YearLowest = new <init>("YearLowest", 18);
        YearHighest = new <init>("YearHighest", 19);
        DateListedOldestFirst = new <init>("DateListedOldestFirst", 20);
        EndDateRecent = new <init>("EndDateRecent", 21);
        $VALUES = (new .VALUES[] {
            BestMatch, CurrentPriceLowest, CurrentPriceHighest, DistanceNearest, EndTimeSoonest, PricePlusShippingLowest, PricePlusShippingHighest, StartTimeNewest, BidCountMost, BidCountFewest, 
            CountryAscending, CountryDescending, ConditionNewFirst, ConditionUsedFirst, CountryRegionDown, CountryRegionUp, MileageLowest, MileageHighest, YearLowest, YearHighest, 
            DateListedOldestFirst, EndDateRecent
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
