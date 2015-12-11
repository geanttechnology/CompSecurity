// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.solr;


public final class SolrSortOrder extends Enum
{

    private static final SolrSortOrder $VALUES[];
    public static final SolrSortOrder SOLRSortBestSelling;
    public static final SolrSortOrder SOLRSortBrandAZ;
    public static final SolrSortOrder SOLRSortBrandZA;
    public static final SolrSortOrder SOLRSortHighestRatings;
    public static final SolrSortOrder SOLRSortNewArrivals;
    public static final SolrSortOrder SOLRSortNone;
    public static final SolrSortOrder SOLRSortPriceHighToLow;
    public static final SolrSortOrder SOLRSortPriceLowToHigh;
    public static final SolrSortOrder SOLRSortReleaseData;
    public static final SolrSortOrder SOLRSortTitleAZ;
    public static final SolrSortOrder SOLRSortTitleZA;
    private final String sortDesc;
    private final String sortOrder;

    private SolrSortOrder(String s, int i, String s1, String s2)
    {
        super(s, i);
        sortOrder = s1;
        sortDesc = s2;
    }

    public static SolrSortOrder valueOf(String s)
    {
        return (SolrSortOrder)Enum.valueOf(com/bestbuy/android/api/lib/models/solr/SolrSortOrder, s);
    }

    public static SolrSortOrder[] values()
    {
        return (SolrSortOrder[])$VALUES.clone();
    }

    public String getSortDesc()
    {
        return sortDesc;
    }

    public String getSortOrder()
    {
        return sortOrder;
    }

    static 
    {
        SOLRSortPriceLowToHigh = new SolrSortOrder("SOLRSortPriceLowToHigh", 0, "&sort=Price-Low-To-High", "Price Low to High");
        SOLRSortPriceHighToLow = new SolrSortOrder("SOLRSortPriceHighToLow", 1, "&sort=Price-High-To-Low", "Price High to Low");
        SOLRSortBrandAZ = new SolrSortOrder("SOLRSortBrandAZ", 2, "&sort=Brand-A-Z", "Brand A-Z");
        SOLRSortBrandZA = new SolrSortOrder("SOLRSortBrandZA", 3, "&sort=Brand-Z-A", "Brand Z-A");
        SOLRSortTitleAZ = new SolrSortOrder("SOLRSortTitleAZ", 4, "&sort=Title-A-Z", "Title A-Z");
        SOLRSortTitleZA = new SolrSortOrder("SOLRSortTitleZA", 5, "&sort=Title-Z-A", "Title Z-A");
        SOLRSortBestSelling = new SolrSortOrder("SOLRSortBestSelling", 6, "&sort=Best-Selling", "Best Selling");
        SOLRSortReleaseData = new SolrSortOrder("SOLRSortReleaseData", 7, "&sort=Release-Date", "Release Date");
        SOLRSortNewArrivals = new SolrSortOrder("SOLRSortNewArrivals", 8, "&sort=New-Arrivals", "Newest Arrivals");
        SOLRSortHighestRatings = new SolrSortOrder("SOLRSortHighestRatings", 9, "&sort=Highest-Rated", "Highest Rated");
        SOLRSortNone = new SolrSortOrder("SOLRSortNone", 10, "", "");
        $VALUES = (new SolrSortOrder[] {
            SOLRSortPriceLowToHigh, SOLRSortPriceHighToLow, SOLRSortBrandAZ, SOLRSortBrandZA, SOLRSortTitleAZ, SOLRSortTitleZA, SOLRSortBestSelling, SOLRSortReleaseData, SOLRSortNewArrivals, SOLRSortHighestRatings, 
            SOLRSortNone
        });
    }
}
