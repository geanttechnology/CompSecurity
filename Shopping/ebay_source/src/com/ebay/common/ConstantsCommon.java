// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common;


public class ConstantsCommon
{
    public static final class FeedbackState extends Enum
    {

        private static final FeedbackState $VALUES[];
        public static final FeedbackState Left;
        public static final FeedbackState NotLeft;
        public static final FeedbackState NotTransactioned;

        public static FeedbackState valueOf(String s)
        {
            return (FeedbackState)Enum.valueOf(com/ebay/common/ConstantsCommon$FeedbackState, s);
        }

        public static FeedbackState[] values()
        {
            return (FeedbackState[])$VALUES.clone();
        }

        static 
        {
            Left = new FeedbackState("Left", 0);
            NotLeft = new FeedbackState("NotLeft", 1);
            NotTransactioned = new FeedbackState("NotTransactioned", 2);
            $VALUES = (new FeedbackState[] {
                Left, NotLeft, NotTransactioned
            });
        }

        private FeedbackState(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ItemKind extends Enum
    {

        private static final ItemKind $VALUES[];
        public static final ItemKind Bidding;
        public static final ItemKind CustomList;
        public static final ItemKind Deals;
        public static final ItemKind Found;
        public static final ItemKind Lost;
        public static final ItemKind RecentlyViewed;
        public static final ItemKind Scheduled;
        public static final ItemKind SellersOther;
        public static final ItemKind Selling;
        public static final ItemKind Selling_Offers;
        public static final ItemKind Sold;
        public static final ItemKind Unknown;
        public static final ItemKind Unsold;
        public static final ItemKind Watched;
        public static final ItemKind WishList;
        public static final ItemKind Won;

        public static ItemKind valueOf(String s)
        {
            return (ItemKind)Enum.valueOf(com/ebay/common/ConstantsCommon$ItemKind, s);
        }

        public static ItemKind[] values()
        {
            return (ItemKind[])$VALUES.clone();
        }

        static 
        {
            Found = new ItemKind("Found", 0);
            Deals = new ItemKind("Deals", 1);
            SellersOther = new ItemKind("SellersOther", 2);
            Watched = new ItemKind("Watched", 3);
            Bidding = new ItemKind("Bidding", 4);
            Won = new ItemKind("Won", 5);
            Lost = new ItemKind("Lost", 6);
            Scheduled = new ItemKind("Scheduled", 7);
            Selling = new ItemKind("Selling", 8);
            Sold = new ItemKind("Sold", 9);
            Unsold = new ItemKind("Unsold", 10);
            Selling_Offers = new ItemKind("Selling_Offers", 11);
            WishList = new ItemKind("WishList", 12);
            CustomList = new ItemKind("CustomList", 13);
            RecentlyViewed = new ItemKind("RecentlyViewed", 14);
            Unknown = new ItemKind("Unknown", 15);
            $VALUES = (new ItemKind[] {
                Found, Deals, SellersOther, Watched, Bidding, Won, Lost, Scheduled, Selling, Sold, 
                Unsold, Selling_Offers, WishList, CustomList, RecentlyViewed, Unknown
            });
        }

        private ItemKind(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ItemSource extends Enum
    {

        private static final ItemSource $VALUES[];
        public static final ItemSource FindItemRequest;
        public static final ItemSource GetMyeBayBuyingBiddingRequest;
        public static final ItemSource GetMyeBayBuyingRequest;
        public static final ItemSource GetMyeBaySellingRequest;
        public static final ItemSource GetSingleItemDescriptionRequest;
        public static final ItemSource GetSingleItemRequest;
        public static final ItemSource None;

        public static ItemSource valueOf(String s)
        {
            return (ItemSource)Enum.valueOf(com/ebay/common/ConstantsCommon$ItemSource, s);
        }

        public static ItemSource[] values()
        {
            return (ItemSource[])$VALUES.clone();
        }

        static 
        {
            None = new ItemSource("None", 0);
            FindItemRequest = new ItemSource("FindItemRequest", 1);
            GetMyeBayBuyingRequest = new ItemSource("GetMyeBayBuyingRequest", 2);
            GetMyeBayBuyingBiddingRequest = new ItemSource("GetMyeBayBuyingBiddingRequest", 3);
            GetMyeBaySellingRequest = new ItemSource("GetMyeBaySellingRequest", 4);
            GetSingleItemRequest = new ItemSource("GetSingleItemRequest", 5);
            GetSingleItemDescriptionRequest = new ItemSource("GetSingleItemDescriptionRequest", 6);
            $VALUES = (new ItemSource[] {
                None, FindItemRequest, GetMyeBayBuyingRequest, GetMyeBayBuyingBiddingRequest, GetMyeBaySellingRequest, GetSingleItemRequest, GetSingleItemDescriptionRequest
            });
        }

        private ItemSource(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class MyeBaySort extends Enum
    {

        private static final MyeBaySort $VALUES[];
        public static final MyeBaySort EndTime;
        public static final MyeBaySort EndTimeDescending;
        public static final MyeBaySort None;

        public static MyeBaySort valueOf(String s)
        {
            return (MyeBaySort)Enum.valueOf(com/ebay/common/ConstantsCommon$MyeBaySort, s);
        }

        public static MyeBaySort[] values()
        {
            return (MyeBaySort[])$VALUES.clone();
        }

        static 
        {
            None = new MyeBaySort("None", 0);
            EndTime = new MyeBaySort("EndTime", 1);
            EndTimeDescending = new MyeBaySort("EndTimeDescending", 2);
            $VALUES = (new MyeBaySort[] {
                None, EndTime, EndTimeDescending
            });
        }

        private MyeBaySort(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String ACTION_EBAY_APPLICATION_LAUNCH = "com.ebay.mobile.APPLICATION_LAUNCH";
    public static final int API_VERSION = 639;
    public static final String APP_NAME = "com.ebay.dataservice";
    public static final int BEST_QUALITY = 2;
    public static final String Bullet = "\u2022";
    public static final String CLIENT_ID = "AEAPP";
    public static final String Colon = ":";
    public static final String DASH = "-";
    public static final String EBAY_ERROR_ALREADY_IN_WATCH_LIST = "21003";
    public static final String EBAY_ERROR_NOT_IN_WATCH_LIST = "21002";
    public static final String EBAY_MOBILE_ACTION_WAKEUP = "com.ebay.mobile.WAKEUP";
    public static final String EBAY_MOBILE_ACTION_WAKEUP_NOTIFICATION = "com.ebay.mobile.WAKEUP_NOTIFICATION";
    public static final String ERROR_BACKGROUND_NETWORK_ACTIVITY_PROHIBITED = "5006";
    public static final String ERROR_BAD_IMAGE = "5016";
    public static final String ERROR_CLIENTALERT_FAILURE = "5017";
    public static final String ERROR_CONNECTION_CLOSED = "5019";
    public static final String ERROR_DEFAULT_ERROR = "5000";
    public static final String ERROR_GENERAL_EXCEPTION = "5010";
    public static final String ERROR_IMAGE_TOO_LARGE = "5015";
    public static final String ERROR_IO_EXCEPTION = "5009";
    public static final String ERROR_JSON_EXCEPTION = "2000";
    public static final String ERROR_MALFORMED_JSON = "5021";
    public static final String ERROR_MALFORMED_URL = "5007";
    public static final String ERROR_MALFORMED_XML = "5013";
    public static final String ERROR_NETWORK_ACTIVITY_WHILE_ROAMING_IS_DISABLED = "5005";
    public static final String ERROR_NETWORK_UNAVAILABLE = "5004";
    public static final String ERROR_NGVI_SERVER_ERROR = "2001";
    public static final String ERROR_NO_AUTO_FILL_VERSION = "5050";
    public static final String ERROR_NO_SERVER_RESPONSE = "5001";
    public static final String ERROR_OUT_OF_MEMORY = "5008";
    public static final String ERROR_PASSWORD_DOES_NOT_MATCH_SIGNIN = "5012";
    public static final String ERROR_SOCKET_TIMEOUT = "5003";
    public static final String ERROR_UNEXPECTED_RESPONSE = "5018";
    public static final String ERROR_UNKNOWN_HOST = "5002";
    public static final String EmptyString = "";
    public static final int GOOD_QUALITY = 1;
    public static final int IMAGE_CACHE_SIZE_LIMIT = 200;
    public static final int IMAGE_STREAM_LENGTH_MAX = 0x3d090;
    public static final int ITEMS_IN_SEARCH_RESULTS_LIST = 25;
    public static final int ITEM_CACHE_SIZE_LIMIT = 400;
    public static boolean LOG_SERVER_REPLIES = false;
    public static final int LOWEST_KNOWN_QUALITY = 0;
    public static final int MSG_CLIENT_UNBOUND = 1;
    public static final int MSG_DATA_SERVICE_CLIENT_CONNECTED = 2;
    public static final int MSG_DATA_SERVICE_SERVER_REPLY = 4;
    public static final int MSG_DELAY_ENDED = 5;
    public static final int MyeBayItemsPerPage = 25;
    public static final int MyeBayWatchListItemsPerPage = 100;
    public static final String NewLine = "\n";
    public static final String PARAM_BOOLEAN_GO_PREV = "paramGoPrev";
    public static final String PARAM_QUANTITY = "paramQty";
    public static final String PARAM_VARIATION_ID = "paramVarId";
    public static final String ROOT_CATEGORY = "Root";
    public static final String ROOT_CATEGORY_ID = "-1";
    public static final boolean RemoveDeadCode = true;
    public static final int SHOPPING_API_VERSION = 723;
    public static final String Site_AU = "EBAY-AU";
    public static final String Site_US = "EBAY-US";
    public static final String Space = " ";
    public static final char TRANSACTION_ITEM_TAG = 42;
    public static final int UNKNOWN_QUALITY = -1;
    public static final boolean USING_VIEW_ITEM_SELLING = false;
    public static final String X_EBAY3PP_DEVICE_ID = "X-EBAY3PP-DEVICE-ID";
    public static final String param_kill = "kill";

    public ConstantsCommon()
    {
    }

    static 
    {
        LOG_SERVER_REPLIES = true;
    }
}
