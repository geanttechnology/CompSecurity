// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;


final class MetricName extends Enum
{

    private static final MetricName $VALUES[];
    public static final MetricName AddToCart;
    public static final MetricName AlternateDetailPageInvokedForcedPrime;
    public static final MetricName AlternateDetailPageInvokedNeva;
    public static final MetricName AlternateDetailPageInvokedTwister;
    public static final MetricName AlternateDetailPageInvokedViewOptions;
    public static final MetricName AssetFetchType;
    public static final MetricName BadResponse;
    public static final MetricName BarcodeInvoked;
    public static final MetricName BrowseActivityRefinementMenuClicked;
    public static final MetricName BrowsePageLoaded;
    public static final MetricName CacheHit;
    public static final MetricName ClickToATFCell;
    public static final MetricName ClickToATFGrid;
    public static final MetricName ClickToATFImage;
    public static final MetricName ClickToATFList;
    public static final MetricName ClickToATFSplit;
    public static final MetricName ClickToATFWifi;
    public static final MetricName ClickToFirstByte;
    public static final MetricName ClientATF;
    public static final MetricName ClientVisibleImpression;
    public static final MetricName Deprecated;
    public static final MetricName DetailPageInvoked;
    public static final MetricName DetailPagePogo;
    public static final MetricName EndOfResults;
    public static final MetricName EntryVoiceInvoked;
    public static final MetricName Error;
    public static final MetricName FirstByte;
    public static final MetricName FlowInvokedT1;
    public static final MetricName FlowInvokedT2;
    public static final MetricName ImageInvoked;
    public static final MetricName Info;
    public static final MetricName InitTime;
    public static final MetricName JsonError;
    public static final MetricName MarketAppVersion;
    public static final MetricName MenuInvoked;
    public static final MetricName NavActivityRefinementMenuClicked;
    public static final MetricName NetworkError;
    public static final MetricName Prefetched;
    public static final MetricName QueryBuilder;
    public static final MetricName RecentSearchesClear;
    public static final MetricName RelatedSearchesInvoked;
    public static final MetricName RequestLatency;
    public static final MetricName ResponseParseTime;
    public static final MetricName ScrollDepth;
    public static final MetricName SearchCell;
    public static final MetricName SearchGrid;
    public static final MetricName SearchImage;
    public static final MetricName SearchLandscape;
    public static final MetricName SearchList;
    public static final MetricName SearchPortrait;
    public static final MetricName SearchSplit;
    public static final MetricName SearchWifi;
    public static final MetricName SearchesPerFilterAccess;
    public static final MetricName SimInteraction;
    public static final MetricName StreamingRefinementsLatency;
    public static final MetricName TimeToFirstSuggestion;
    public static final MetricName Timeout;
    public static final MetricName ValueSelected;
    public static final MetricName clickToATF;
    public static final MetricName trueClickToATF;

    private MetricName(String s, int i)
    {
        super(s, i);
    }

    public static MetricName valueOf(String s)
    {
        return (MetricName)Enum.valueOf(com/amazon/retailsearch/metrics/MetricName, s);
    }

    public static MetricName[] values()
    {
        return (MetricName[])$VALUES.clone();
    }

    static 
    {
        clickToATF = new MetricName("clickToATF", 0);
        trueClickToATF = new MetricName("trueClickToATF", 1);
        ClickToFirstByte = new MetricName("ClickToFirstByte", 2);
        ClientATF = new MetricName("ClientATF", 3);
        ClickToATFList = new MetricName("ClickToATFList", 4);
        ClickToATFGrid = new MetricName("ClickToATFGrid", 5);
        ClickToATFImage = new MetricName("ClickToATFImage", 6);
        ClickToATFSplit = new MetricName("ClickToATFSplit", 7);
        ClickToATFWifi = new MetricName("ClickToATFWifi", 8);
        ClickToATFCell = new MetricName("ClickToATFCell", 9);
        FirstByte = new MetricName("FirstByte", 10);
        RequestLatency = new MetricName("RequestLatency", 11);
        ResponseParseTime = new MetricName("ResponseParseTime", 12);
        StreamingRefinementsLatency = new MetricName("StreamingRefinementsLatency", 13);
        Timeout = new MetricName("Timeout", 14);
        Error = new MetricName("Error", 15);
        BadResponse = new MetricName("BadResponse", 16);
        Deprecated = new MetricName("Deprecated", 17);
        DetailPageInvoked = new MetricName("DetailPageInvoked", 18);
        AlternateDetailPageInvokedForcedPrime = new MetricName("AlternateDetailPageInvokedForcedPrime", 19);
        AlternateDetailPageInvokedNeva = new MetricName("AlternateDetailPageInvokedNeva", 20);
        AlternateDetailPageInvokedTwister = new MetricName("AlternateDetailPageInvokedTwister", 21);
        AlternateDetailPageInvokedViewOptions = new MetricName("AlternateDetailPageInvokedViewOptions", 22);
        DetailPagePogo = new MetricName("DetailPagePogo", 23);
        MenuInvoked = new MetricName("MenuInvoked", 24);
        ValueSelected = new MetricName("ValueSelected", 25);
        SearchesPerFilterAccess = new MetricName("SearchesPerFilterAccess", 26);
        RelatedSearchesInvoked = new MetricName("RelatedSearchesInvoked", 27);
        AddToCart = new MetricName("AddToCart", 28);
        RecentSearchesClear = new MetricName("RecentSearchesClear", 29);
        QueryBuilder = new MetricName("QueryBuilder", 30);
        ScrollDepth = new MetricName("ScrollDepth", 31);
        TimeToFirstSuggestion = new MetricName("TimeToFirstSuggestion", 32);
        Info = new MetricName("Info", 33);
        InitTime = new MetricName("InitTime", 34);
        EntryVoiceInvoked = new MetricName("EntryVoiceInvoked", 35);
        BarcodeInvoked = new MetricName("BarcodeInvoked", 36);
        ImageInvoked = new MetricName("ImageInvoked", 37);
        FlowInvokedT1 = new MetricName("FlowInvokedT1", 38);
        FlowInvokedT2 = new MetricName("FlowInvokedT2", 39);
        SearchList = new MetricName("SearchList", 40);
        SearchGrid = new MetricName("SearchGrid", 41);
        SearchImage = new MetricName("SearchImage", 42);
        SearchSplit = new MetricName("SearchSplit", 43);
        SearchWifi = new MetricName("SearchWifi", 44);
        SearchCell = new MetricName("SearchCell", 45);
        SearchLandscape = new MetricName("SearchLandscape", 46);
        SearchPortrait = new MetricName("SearchPortrait", 47);
        ClientVisibleImpression = new MetricName("ClientVisibleImpression", 48);
        NetworkError = new MetricName("NetworkError", 49);
        JsonError = new MetricName("JsonError", 50);
        EndOfResults = new MetricName("EndOfResults", 51);
        AssetFetchType = new MetricName("AssetFetchType", 52);
        MarketAppVersion = new MetricName("MarketAppVersion", 53);
        BrowsePageLoaded = new MetricName("BrowsePageLoaded", 54);
        BrowseActivityRefinementMenuClicked = new MetricName("BrowseActivityRefinementMenuClicked", 55);
        NavActivityRefinementMenuClicked = new MetricName("NavActivityRefinementMenuClicked", 56);
        Prefetched = new MetricName("Prefetched", 57);
        CacheHit = new MetricName("CacheHit", 58);
        SimInteraction = new MetricName("SimInteraction", 59);
        $VALUES = (new MetricName[] {
            clickToATF, trueClickToATF, ClickToFirstByte, ClientATF, ClickToATFList, ClickToATFGrid, ClickToATFImage, ClickToATFSplit, ClickToATFWifi, ClickToATFCell, 
            FirstByte, RequestLatency, ResponseParseTime, StreamingRefinementsLatency, Timeout, Error, BadResponse, Deprecated, DetailPageInvoked, AlternateDetailPageInvokedForcedPrime, 
            AlternateDetailPageInvokedNeva, AlternateDetailPageInvokedTwister, AlternateDetailPageInvokedViewOptions, DetailPagePogo, MenuInvoked, ValueSelected, SearchesPerFilterAccess, RelatedSearchesInvoked, AddToCart, RecentSearchesClear, 
            QueryBuilder, ScrollDepth, TimeToFirstSuggestion, Info, InitTime, EntryVoiceInvoked, BarcodeInvoked, ImageInvoked, FlowInvokedT1, FlowInvokedT2, 
            SearchList, SearchGrid, SearchImage, SearchSplit, SearchWifi, SearchCell, SearchLandscape, SearchPortrait, ClientVisibleImpression, NetworkError, 
            JsonError, EndOfResults, AssetFetchType, MarketAppVersion, BrowsePageLoaded, BrowseActivityRefinementMenuClicked, NavActivityRefinementMenuClicked, Prefetched, CacheHit, SimInteraction
        });
    }
}
