// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;


public final class SourceName extends Enum
{

    private static final SourceName $VALUES[];
    public static final SourceName AssetsSRDSRequest;
    public static final SourceName Engagement;
    public static final SourceName Filter;
    public static final SourceName ISS;
    public static final SourceName PersonalizedISSSRDSRequest;
    public static final SourceName Prefetching;
    public static final SourceName SRDSRequest;
    public static final SourceName Search;
    public static final SourceName SearchInit;
    public static final SourceName ShopByDepartment;

    private SourceName(String s, int i)
    {
        super(s, i);
    }

    public static SourceName valueOf(String s)
    {
        return (SourceName)Enum.valueOf(com/amazon/retailsearch/metrics/SourceName, s);
    }

    public static SourceName[] values()
    {
        return (SourceName[])$VALUES.clone();
    }

    static 
    {
        Search = new SourceName("Search", 0);
        SearchInit = new SourceName("SearchInit", 1);
        SRDSRequest = new SourceName("SRDSRequest", 2);
        AssetsSRDSRequest = new SourceName("AssetsSRDSRequest", 3);
        Filter = new SourceName("Filter", 4);
        ISS = new SourceName("ISS", 5);
        PersonalizedISSSRDSRequest = new SourceName("PersonalizedISSSRDSRequest", 6);
        ShopByDepartment = new SourceName("ShopByDepartment", 7);
        Engagement = new SourceName("Engagement", 8);
        Prefetching = new SourceName("Prefetching", 9);
        $VALUES = (new SourceName[] {
            Search, SearchInit, SRDSRequest, AssetsSRDSRequest, Filter, ISS, PersonalizedISSSRDSRequest, ShopByDepartment, Engagement, Prefetching
        });
    }
}
