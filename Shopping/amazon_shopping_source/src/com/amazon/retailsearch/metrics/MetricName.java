// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.metrics;


final class MetricName extends Enum
{

    private static final MetricName $VALUES[];
    public static final MetricName AlternateDetailPageInvokedForcedPrime;
    public static final MetricName AlternateDetailPageInvokedNeva;
    public static final MetricName AlternateDetailPageInvokedTwister;
    public static final MetricName AssetFetchType;
    public static final MetricName BadResponse;
    public static final MetricName BarcodeInvoked;
    public static final MetricName BrowseActivityRefinementMenuClicked;
    public static final MetricName BrowsePageLoaded;
    public static final MetricName ClientATF;
    public static final MetricName ClientVisibleImpression;
    public static final MetricName Deprecated;
    public static final MetricName DetailPageInvoked;
    public static final MetricName DetailPagePogo;
    public static final MetricName EndOfResults;
    public static final MetricName EntryVoiceInvoked;
    public static final MetricName Error;
    public static final MetricName FirstByte;
    public static final MetricName FlowInvoked;
    public static final MetricName ImageInvoked;
    public static final MetricName Info;
    public static final MetricName InitTime;
    public static final MetricName JsonError;
    public static final MetricName MarketAppVersion;
    public static final MetricName MenuInvoked;
    public static final MetricName NavActivityRefinementMenuClicked;
    public static final MetricName NetworkError;
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
    public static final MetricName StreamingRefinementsLatency;
    public static final MetricName StreamingResultsLatency;
    public static final MetricName TapToATF;
    public static final MetricName TapToATFCell;
    public static final MetricName TapToATFGrid;
    public static final MetricName TapToATFImage;
    public static final MetricName TapToATFList;
    public static final MetricName TapToATFSplit;
    public static final MetricName TapToATFWifi;
    public static final MetricName TapToFirstByte;
    public static final MetricName TimeToFirstSuggestion;
    public static final MetricName Timeout;
    public static final MetricName ValueSelected;

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
        TapToATF = new MetricName("TapToATF", 0);
        TapToFirstByte = new MetricName("TapToFirstByte", 1);
        ClientATF = new MetricName("ClientATF", 2);
        TapToATFList = new MetricName("TapToATFList", 3);
        TapToATFGrid = new MetricName("TapToATFGrid", 4);
        TapToATFImage = new MetricName("TapToATFImage", 5);
        TapToATFSplit = new MetricName("TapToATFSplit", 6);
        TapToATFWifi = new MetricName("TapToATFWifi", 7);
        TapToATFCell = new MetricName("TapToATFCell", 8);
        FirstByte = new MetricName("FirstByte", 9);
        RequestLatency = new MetricName("RequestLatency", 10);
        ResponseParseTime = new MetricName("ResponseParseTime", 11);
        StreamingResultsLatency = new MetricName("StreamingResultsLatency", 12);
        StreamingRefinementsLatency = new MetricName("StreamingRefinementsLatency", 13);
        Timeout = new MetricName("Timeout", 14);
        Error = new MetricName("Error", 15);
        BadResponse = new MetricName("BadResponse", 16);
        Deprecated = new MetricName("Deprecated", 17);
        DetailPageInvoked = new MetricName("DetailPageInvoked", 18);
        AlternateDetailPageInvokedForcedPrime = new MetricName("AlternateDetailPageInvokedForcedPrime", 19);
        AlternateDetailPageInvokedNeva = new MetricName("AlternateDetailPageInvokedNeva", 20);
        AlternateDetailPageInvokedTwister = new MetricName("AlternateDetailPageInvokedTwister", 21);
        DetailPagePogo = new MetricName("DetailPagePogo", 22);
        MenuInvoked = new MetricName("MenuInvoked", 23);
        ValueSelected = new MetricName("ValueSelected", 24);
        SearchesPerFilterAccess = new MetricName("SearchesPerFilterAccess", 25);
        RelatedSearchesInvoked = new MetricName("RelatedSearchesInvoked", 26);
        RecentSearchesClear = new MetricName("RecentSearchesClear", 27);
        QueryBuilder = new MetricName("QueryBuilder", 28);
        ScrollDepth = new MetricName("ScrollDepth", 29);
        TimeToFirstSuggestion = new MetricName("TimeToFirstSuggestion", 30);
        Info = new MetricName("Info", 31);
        InitTime = new MetricName("InitTime", 32);
        EntryVoiceInvoked = new MetricName("EntryVoiceInvoked", 33);
        BarcodeInvoked = new MetricName("BarcodeInvoked", 34);
        ImageInvoked = new MetricName("ImageInvoked", 35);
        FlowInvoked = new MetricName("FlowInvoked", 36);
        SearchList = new MetricName("SearchList", 37);
        SearchGrid = new MetricName("SearchGrid", 38);
        SearchImage = new MetricName("SearchImage", 39);
        SearchSplit = new MetricName("SearchSplit", 40);
        SearchWifi = new MetricName("SearchWifi", 41);
        SearchCell = new MetricName("SearchCell", 42);
        SearchLandscape = new MetricName("SearchLandscape", 43);
        SearchPortrait = new MetricName("SearchPortrait", 44);
        ClientVisibleImpression = new MetricName("ClientVisibleImpression", 45);
        NetworkError = new MetricName("NetworkError", 46);
        JsonError = new MetricName("JsonError", 47);
        EndOfResults = new MetricName("EndOfResults", 48);
        AssetFetchType = new MetricName("AssetFetchType", 49);
        MarketAppVersion = new MetricName("MarketAppVersion", 50);
        BrowsePageLoaded = new MetricName("BrowsePageLoaded", 51);
        BrowseActivityRefinementMenuClicked = new MetricName("BrowseActivityRefinementMenuClicked", 52);
        NavActivityRefinementMenuClicked = new MetricName("NavActivityRefinementMenuClicked", 53);
        $VALUES = (new MetricName[] {
            TapToATF, TapToFirstByte, ClientATF, TapToATFList, TapToATFGrid, TapToATFImage, TapToATFSplit, TapToATFWifi, TapToATFCell, FirstByte, 
            RequestLatency, ResponseParseTime, StreamingResultsLatency, StreamingRefinementsLatency, Timeout, Error, BadResponse, Deprecated, DetailPageInvoked, AlternateDetailPageInvokedForcedPrime, 
            AlternateDetailPageInvokedNeva, AlternateDetailPageInvokedTwister, DetailPagePogo, MenuInvoked, ValueSelected, SearchesPerFilterAccess, RelatedSearchesInvoked, RecentSearchesClear, QueryBuilder, ScrollDepth, 
            TimeToFirstSuggestion, Info, InitTime, EntryVoiceInvoked, BarcodeInvoked, ImageInvoked, FlowInvoked, SearchList, SearchGrid, SearchImage, 
            SearchSplit, SearchWifi, SearchCell, SearchLandscape, SearchPortrait, ClientVisibleImpression, NetworkError, JsonError, EndOfResults, AssetFetchType, 
            MarketAppVersion, BrowsePageLoaded, BrowseActivityRefinementMenuClicked, NavActivityRefinementMenuClicked
        });
    }
}
