// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.analytics;


public class CommonTrackingConstants
{
    public static class Tag
    {

        public static final String RTM_TRACKING_CLICK_ID = "trkp";

        public Tag()
        {
        }
    }


    public static final String ACTION_SEND_ANALYTICS = "com.ebay.common.analytics.ACTION_SEND_ANALYTICS";
    public static final String BOPIS_GEO_CODE_COUNT = "gccount";
    public static final String CATEGORY = "cat";
    public static final String CATEGORY_DOMINANT = "tcatid";
    public static final String EVENT_FLAGS = "keyFlagsetId";
    public static final String EVENT_FLAGSET_NAME = "keyFlagsetName";
    public static final String GEO_CODE_EVENT = "GeoCodeEvent";
    public static final String ITEM_ID = "itm";
    public static final String PAGINATION = "cpnip";
    public static final String PASS_THRU_SERVICE_TRACKING = "trknvpsvc";
    public static final String REQUEST_CORRELATION_ID = "rq";
    public static final String SEARCH_APPLIED_ASPECTS = "aa";
    public static final String SEARCH_EBAYNOW_ITEM_COUNT = "ebnc";
    public static final String SEARCH_EBAY_PLUS_REFINEMENT = "plusfilter";
    public static final String SEARCH_GLOBAL_FILTERS = "gf";
    public static final String SEARCH_KEYWORD = "sQr";
    public static final String SEARCH_MAX_PRICE = "mxprc";
    public static final String SEARCH_MIN_PRICE = "mnprc";
    public static final String SEARCH_RESULT_AUCTION_COUNT = "nai";
    public static final String SEARCH_RESULT_COUNT = "sHit";
    public static final String SEARCH_RESULT_FIXED_PRICE_COUNT = "nbi";
    public static final String SEARCH_RESULT_SORT = "sort";
    public static final String TRACKING_EVENT_NAME = "eventName";

    private CommonTrackingConstants()
    {
    }
}
