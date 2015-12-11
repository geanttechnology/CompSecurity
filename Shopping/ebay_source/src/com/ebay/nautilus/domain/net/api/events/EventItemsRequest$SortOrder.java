// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.events;


// Referenced classes of package com.ebay.nautilus.domain.net.api.events:
//            EventItemsRequest

public static final class I extends Enum
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
    public static final EndDateRecent None;
    public static final EndDateRecent PricePlusShippingHighest;
    public static final EndDateRecent PricePlusShippingLowest;
    public static final EndDateRecent StartTimeNewest;
    public static final EndDateRecent YearHighest;
    public static final EndDateRecent YearLowest;

    public static I valueOf(String s)
    {
        return (I)Enum.valueOf(com/ebay/nautilus/domain/net/api/events/EventItemsRequest$SortOrder, s);
    }

    public static I[] values()
    {
        return (I[])$VALUES.clone();
    }

    static 
    {
        None = new <init>("None", 0);
        BestMatch = new <init>("BestMatch", 1);
        CurrentPriceLowest = new <init>("CurrentPriceLowest", 2);
        CurrentPriceHighest = new <init>("CurrentPriceHighest", 3);
        DistanceNearest = new <init>("DistanceNearest", 4);
        EndTimeSoonest = new <init>("EndTimeSoonest", 5);
        PricePlusShippingLowest = new <init>("PricePlusShippingLowest", 6);
        PricePlusShippingHighest = new <init>("PricePlusShippingHighest", 7);
        StartTimeNewest = new <init>("StartTimeNewest", 8);
        BidCountMost = new <init>("BidCountMost", 9);
        BidCountFewest = new <init>("BidCountFewest", 10);
        CountryAscending = new <init>("CountryAscending", 11);
        CountryDescending = new <init>("CountryDescending", 12);
        ConditionNewFirst = new <init>("ConditionNewFirst", 13);
        ConditionUsedFirst = new <init>("ConditionUsedFirst", 14);
        CountryRegionDown = new <init>("CountryRegionDown", 15);
        CountryRegionUp = new <init>("CountryRegionUp", 16);
        MileageLowest = new <init>("MileageLowest", 17);
        MileageHighest = new <init>("MileageHighest", 18);
        YearLowest = new <init>("YearLowest", 19);
        YearHighest = new <init>("YearHighest", 20);
        DateListedOldestFirst = new <init>("DateListedOldestFirst", 21);
        EndDateRecent = new <init>("EndDateRecent", 22);
        $VALUES = (new .VALUES[] {
            None, BestMatch, CurrentPriceLowest, CurrentPriceHighest, DistanceNearest, EndTimeSoonest, PricePlusShippingLowest, PricePlusShippingHighest, StartTimeNewest, BidCountMost, 
            BidCountFewest, CountryAscending, CountryDescending, ConditionNewFirst, ConditionUsedFirst, CountryRegionDown, CountryRegionUp, MileageLowest, MileageHighest, YearLowest, 
            YearHighest, DateListedOldestFirst, EndDateRecent
        });
    }

    private I(String s, int i)
    {
        super(s, i);
    }
}
