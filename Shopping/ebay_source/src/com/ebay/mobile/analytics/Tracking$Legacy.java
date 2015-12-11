// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics;


// Referenced classes of package com.ebay.mobile.analytics:
//            Tracking

public static class 
{

    public static final String BROWSE_CATEGORIES_NON_RTB_INC = "BNN";
    public static final String BROWSE_CATEGORIES_RTB_INC = "BHN";
    public static final String BROWSE_CATEGORIES_RTB_SPECIFIC_BID_AMT = "BHB";
    public static final String BROWSE_CATEGORIES_SPECIFIC_BID_AMT = "BUB";
    public static final String BUYING_REMINDER_BEST_OFFER = "RBBO";
    public static final String BUYING_REMINDER_BIDDING_ENDING = "RBBE";
    public static final String BUYING_REMINDER_FEEDBACK_TO_SEND = "RBF";
    public static final String BUYING_REMINDER_OUTBID = "RBO";
    public static final String BUYING_REMINDER_PAYMENT_TO_SEND = "RBP";
    public static final String BUYING_REMINDER_PICKUP_READY = "RBPU";
    public static final String BUYING_REMINDER_SECOND_CHANCE_OFFER = "RBSC";
    public static final String BUYING_REMINDER_WATCHING_ENDING = "RBWE";
    public static final String COUNTEROFFER_NON_RTB_INC = "CNN";
    public static final String COUNTEROFFER_RTB_INC = "CHN";
    public static final String COUNTEROFFER_RTB_SPECIFIC_BID_AMT = "CHB";
    public static final String COUNTEROFFER_SPECIFIC_BID_AMT = "CUB";
    public static final String LISTING_TYPE_AUCTION = "auction";
    public static final String LISTING_TYPE_FIXED_PRICE = "fixed_price";
    public static final String MOBILE_FLAGS = "mfls";
    public static final String OFFER_BUYER_MAKE_AUTO_ACCEPT = "OBMA";
    public static final String OFFER_BUYER_MAKE_AUTO_DECLINED = "OBMD";
    public static final String OFFER_BUYER_MAKE_ERROR = "OBME";
    public static final String OFFER_BUYER_MAKE_SENT = "OBMS";
    public static final String OFFER_BUYER_RESPOND_ACCEPT = "OBRA";
    public static final String OFFER_BUYER_RESPOND_COUNTER = "OBRC";
    public static final String OFFER_BUYER_RESPOND_COUNTER_AUTO_ACCEPT = "OBCA";
    public static final String OFFER_BUYER_RESPOND_COUNTER_AUTO_DECLINE = "OBCD";
    public static final String OFFER_BUYER_RESPOND_DECLINE = "OBRD";
    public static final String OFFER_BUYER_RESPOND_ERROR = "OBRE";
    public static final String OFFER_SELLER_RESPOND_ACCEPT = "OSRA";
    public static final String OFFER_SELLER_RESPOND_COUNTER = "OSRC";
    public static final String OFFER_SELLER_RESPOND_DECLINE = "OSRD";
    public static final String OFFER_SELLER_RESPOND_ERROR = "OSRE";
    public static final String ONE_OFF_EVENT_EMAIL_HELP = "HLP";
    public static final String ONE_OFF_EVENT_LOGOUT_ADDRESS_FAILURE = "ALAF";
    public static final String ONE_OFF_EVENT_LOGOUT_MENU = "ALM";
    public static final String ONE_OFF_EVENT_LOGOUT_PROFILE = "ALP";
    public static final String ONE_OFF_EVENT_ONLINE_HELP = "ACS";
    public static final String ONE_OFF_EVENT_PHONE_HELP = "PHO";
    public static final String ONE_OFF_EVENT_REGISTER_AS_SELLER = "ASR";
    public static final String ORGANIC_NON_RTB_INC = "NNN";
    public static final String ORGANIC_RTB_INC = "NHN";
    public static final String ORGANIC_RTB_SPECIFIC_BID_AMT = "NHB";
    public static final String ORGANIC_SPECIFIC_BID_AMT = "NUB";
    public static final String OUTBID_NON_RTB_INC = "ONN";
    public static final String OUTBID_RTB_INC = "OHN";
    public static final String OUTBID_RTB_SPECIFIC_BID_AMT = "OHB";
    public static final String OUTBID_SPECIFIC_BID_AMT = "OUB";
    public static final String SAVED_SEARCH_NON_RTB_INC = "SNN";
    public static final String SAVED_SEARCH_RTB_INC = "SHN";
    public static final String SAVED_SEARCH_RTB_SPECIFIC_BID_AMT = "SHB";
    public static final String SAVED_SEARCH_SPECIFIC_BID_AMT = "SUB";
    public static final String SELLING_LIST_ITEM = "SLIS";
    public static final String SELLING_PAYMENT_OTHER = "PMTO";
    public static final String SELLING_PAYMENT_PAYPAL = "PMTPP";
    public static final String SELLING_RELIST_ITEM = "SREL";
    public static final String SELLING_REMINDER_BEST_OFFER = "RSBO";
    public static final String SELLING_REMINDER_FEEDBACK_TO_SEND = "RSF";
    public static final String SELLING_REMINDER_PAYMENT_TO_RECEIVE = "RSP";
    public static final String SELLING_REMINDER_SELL_ENDING = "RSE";
    public static final String SELLING_REMINDER_SHIPPING_NEEDED = "RSS";
    public static final String SELLING_REVISE_ITEM = "SREV";
    public static final String SELLING_SELL_ONE_LIKE_THIS = "SOLT";
    public static final String SELLING_SELL_SIMILAR_ITEM = "SSSI";
    public static final String SELLING_SHIPPING_INTERNATIONAL = "SHI";
    public static final String SELLING_SHIPPING_OTHER = "SHO";
    public static final String SELLING_START_DELAYED = "SSD";
    public static final String SELLING_START_IMMEDIATE = "SSI";
    public static final String SETTINGS_EVENT_CLEAR_SEARCH_HISTORY = "ClearSearchHistory";
    public static final String SETTINGS_EVENT_SELECT_SITE = "SelectSite";
    public static final String SHOPPING_CART_NON_RTB_INC = "XNN";
    public static final String SHOPPING_CART_RTB_INC = "XHN";
    public static final String SHOPPING_CART_RTB_SPECIFIC_BID_AMT = "XHB";
    public static final String SHOPPING_CART_SPECIFIC_BID_AMT = "XUB";
    public static final String WATCHED_ITEM_ENDING_NON_RTB_INC = "ENN";
    public static final String WATCHED_ITEM_ENDING_RTB_INC = "EHN";
    public static final String WATCHED_ITEM_ENDING_RTB_SPECIFIC_BID_AMT = "EHB";
    public static final String WATCHED_ITEM_ENDING_SPECIFIC_BID_AMT = "EUB";
    public static final String WEBSOCKET_RTU_CONNECT_FAILED = "WRCF";
    public static final String WEBSOCKET_RTU_DISCONNECTED = "WRD";
    public static final String WEBSOCKET_RTU_HANDSHAKE = "WRC";
    public static final String WEBSOCKET_RTU_HANDSHAKE_FAILED = "WRHF";

    private ()
    {
    }
}
