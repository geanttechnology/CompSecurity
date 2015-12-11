// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.common;


public class ConstantsMobile
{

    public static final int ACTIVITY_MY_EBAY_EDIT_LIST = 531;
    public static final int ACTIVITY_REQUEST_ACCEPTLICENSE = 63;
    public static final int ACTIVITY_REQUEST_ALERTTIME = 59;
    public static final int ACTIVITY_REQUEST_BARCODE = 58;
    public static final int ACTIVITY_REQUEST_CATEGORY = 52;
    public static final int ACTIVITY_REQUEST_EXIT = 68;
    public static final int ACTIVITY_REQUEST_LOCALPICKUP = 79;
    public static final int ACTIVITY_REQUEST_MAXDISTANCE = 55;
    public static final int ACTIVITY_REQUEST_MYEBAY_DELETE_ITEM = 78;
    public static final int ACTIVITY_REQUEST_MY_EBAY_LONG_CLICK = 67;
    public static final int ACTIVITY_REQUEST_PRICERANGE = 54;
    public static final int ACTIVITY_REQUEST_QUERY = 57;
    public static final int ACTIVITY_REQUEST_SHIPSTOZIPCODE = 61;
    public static final int ACTIVITY_REQUEST_SIGN_IN = 65;
    public static final int ACTIVITY_REQUEST_SIGN_IN_BEFORE_ACTION = 77;
    public static final int ACTIVITY_REQUEST_SUBCATEGORY = 56;
    public static final int ACTIVITY_SAVE_SEARCH = 527;
    public static final int ACTIVITY_TRACK_PACKAGE = 530;
    public static final int ACTIVITY_USER_INPUT_DIALOG_COMPLETED = 74;
    public static final int ACTIVITY_VIEW_MESSAGE = 75;
    public static final int AboutActivity = 521;
    public static final int BrowseCategoriesActivity = 541;
    public static final int EBAY_HOME = 542;
    public static final String EBAY_MOBILE_ACTION_WAKEUP = "com.ebay.mobile.WAKEUP";
    public static final String EBAY_MOBILE_ACTION_WAKEUP_NOTIFICATION = "com.ebay.mobile.WAKEUP_NOTIFICATION";
    public static final int HOT_ITEMS_FROM_FAVORITE_SEARCHES = 5;
    public static final int HOT_ITEMS_FROM_LOCAL_SEARCHES = 5;
    public static final int HOT_ITEMS_FROM_POPULAR_SEARCHES = 5;
    public static final String LOADING_LABEL = "L,Loading...";
    public static final int MAIN_EBAY_SITE = 0;
    public static final int MAX_RECENT_SEARCHES = 10;
    public static final int MSG_TIMER_TICK = 71;
    public static final int MyEbayActivity = 512;
    public static final int MyEbaySeeAllActivity = 539;
    public static final int MyEbaySellerLandingSelection = 560;
    public static final int MyEbayWebViewActivity = 533;
    public static final int MyeBayActivity = 504;
    public static final int PAYPAL_INDETERMINATE = 1;
    public static final String POPULAR_KEYWORDS_FILE = "popular_keywords";
    public static final String PREF_MAXIMUM_DISTANCE_DEFAULT = "0";
    public static final int PREF_MAXIMUM_DISTANCE_DEFAULT_INT = 0;
    public static final String PREF_NAME = "com.ebay.mobile.prefs";
    public static final String PREF_ZIP_CODE_DEFAULT = "66952";
    public static final int PreferencesActivity = 508;
    public static final int PreferredSiteActivity = 514;
    public static final int RECENTLY_VIEWED_HISTORY_MAX_ITEMS = 100;
    public static final String SDistanceStrings[] = {
        "None", "10", "25", "50", "75", "100", "150", "200", "500", "750", 
        "1000", "1500", "2000"
    };
    public static final String SEARCH_ENABLE_DEBUG_KEYWORD = "4f37292d53e41eb687dc617e4a021a7cd01f91ed";
    public static final int SearchResultListActivity = 526;
    public static final int SellerLandingActivity = 540;
    public static final int USE_PREVIOUS_SEARCH_RESULTS_THRESHOLD_MS = 0x1d4c0;
    public static final int ViewFeedbackActivity = 518;
    public static final int ViewItemSellingActivity = 500;
    public static final String WAKEEUP_ORIGINAL_INTENT_BUNDLE = "original_intent_bundle";
    public static final String WAKEUP_ORIGINAL_INTENT = "original_intent";
    public static final String WIDGET_DESTINATION_FLAG = "widget_destination";
    public static final long auctionEndingWarningTime = 0x36ee80L;
    public static final long auctionEndingWarningTimeMyEbay = 0x5265c00L;
    public static final long itemEndingWarningTimeShoppingCart = 0x5265c00L;

    public ConstantsMobile()
    {
    }

    public static int SMapPrefMaxDistanceToIndex(String s)
    {
        if (s.compareToIgnoreCase("None") != 0)
        {
            if (s.compareToIgnoreCase("10") == 0)
            {
                return 1;
            }
            if (s.compareToIgnoreCase("25") == 0)
            {
                return 2;
            }
            if (s.compareToIgnoreCase("50") == 0)
            {
                return 3;
            }
            if (s.compareToIgnoreCase("75") == 0)
            {
                return 4;
            }
            if (s.compareToIgnoreCase("100") == 0)
            {
                return 5;
            }
            if (s.compareToIgnoreCase("150") == 0)
            {
                return 6;
            }
            if (s.compareToIgnoreCase("200") == 0)
            {
                return 7;
            }
            if (s.compareToIgnoreCase("500") == 0)
            {
                return 8;
            }
            if (s.compareToIgnoreCase("750") == 0)
            {
                return 9;
            }
            if (s.compareToIgnoreCase("1000") == 0)
            {
                return 10;
            }
            if (s.compareToIgnoreCase("1500") == 0)
            {
                return 11;
            }
            if (s.compareToIgnoreCase("2000") == 0)
            {
                return 12;
            }
        }
        return 0;
    }

}
