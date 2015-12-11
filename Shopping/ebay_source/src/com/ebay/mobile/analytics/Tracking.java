// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.analytics;

import java.util.Iterator;
import java.util.List;

public class Tracking
{
    public static class EventName
    {

        public static final String ACTIVITY_START_SELLING = "StartSelling";
        public static final String ACTIVITY_START_SHOPPING = "StartShopping";
        public static final String ADD_ADDRESS_IMPRESSION = "CheckoutNewShippingAddress";
        public static final String ADD_TO_CART_CLICK = "AddToCart";
        public static final String ADS_CLICK = "AdClick";
        public static final String ADS_IMPRESSION = "RTMImpression";
        public static final String ADS_OPT_OUT_PAGE = "AdvertisingOptOut";
        public static final String AFTER_SALES = "ClosedItemOptions";
        public static final String APP_FIRST_LAUNCH = "FirstLaunch";
        public static final String APP_LAUNCH = "Launch";
        public static final String AUTOPAY_STARTED = "Autopay";
        public static final String BACKGROUNDED = "Background";
        public static final String BARCODE_SCANNING = "BarcodeScanning";
        public static final String BARCODE_SCANNING_LISTING_EVENTS = "BarcodeScanningList";
        public static final String BID_INCREASE_BID = "IncreaseBid";
        public static final String BID_PLACE_BID = "PlaceBid";
        public static final String BID_STATES = "BidState";
        public static final String BUY_IT_NOW_TAP = "BuyItNowTap";
        public static final String CART_QUANTITY_CHANGED_EVENT = "ShoppingCartItemCount";
        public static final String CHANGE_ADDRESS_IMPRESSION = "ChangeChangeShippingAddress";
        public static final String CHANGE_SHIPPING_METHOD_IMPRESSION = "CheckoutShippingMethodPicker";
        public static final String CHECKOUT_ALTERNATE_CHECKOUT_SUCCESS = "CheckoutPaymentSuccess";
        public static final String CHECKOUT_CANCELED = "CheckoutCanceled";
        public static final String CHECKOUT_DONATIONS_PAGE_IMPRESSION = "MakeADonation";
        public static final String CHECKOUT_GIFT_CARD_REDEEMED = "CheckoutGiftCardReedemed";
        public static final String CHECKOUT_MESSAGE_SENT_EVENT = "CheckoutMessageSent";
        public static final String CHECKOUT_OUT_OF_STOCK = "CheckoutOutOfStock";
        public static final String CHECKOUT_PAGE_IMPRESSION = "CheckoutPage";
        public static final String COLLECTIONS_BROWSE = "CollectionsBrowse";
        public static final String COLLECTION_DETAILS = "CollectionDetails";
        public static final String CONFIRM_LISTING = "ConfirmListing";
        public static final String CONFIRM_SAVED_SEARCH = "SavedSearchSave";
        public static String CONTACT_SELLER = "AskSellerQuestion";
        public static final String DEALS = "Deals";
        public static final String DEALS_BROWSE = "DealsBrowse";
        public static final String EBAY_PLUS_SIGNUP_TAP = "EPlusSignupTap";
        public static final String EBN_ORDER_DETAILS = "EbnOrderDetails";
        public static final String EULA_ACCEPT = "EulaAccept";
        public static final String FAVORITE_SELLERS = "FavoriteSellers";
        public static final String FEED = "Feed";
        public static final String FOREGROUNDED = "Foreground";
        public static final String GBH_CHANGED = "GbhChanged";
        public static final String GBH_SETTINGS = "SettingsGbh";
        public static final String GIVING_WORKS_CHARITY_DETAIL = "GivingWorksCharityDetail";
        public static final String GIVING_WORKS_HOME = "GivingWorksHome";
        public static final String GIVING_WORKS_MY_CHARITIES = "MyCharities";
        public static final String GIVING_WORKS_SEARCH = "GivingWorksSearch";
        public static final String GUARANTEED_PRICE_CLEARED = "spgClear";
        public static final String HOME_PAGE = "HomePage";
        public static final String HYPERBIDDING_ENTERED = "StartRealTimeBidding";
        public static final String INCENTIVES_IMPRESSION = "CheckoutIncentiveEntry";
        public static final String INCENTIVE_APPLIED_EVENT = "CheckoutIncentiveApplied";
        public static final String INSTALL = "Install";
        public static final String INSTORE_PICKUP = "InstorePickup";
        public static final String INSTORE_PICKUP_SELECTION = "InstorePickupSelection";
        public static final String ITEM_VIEW_BIDDING_ACTIVITY = "BiddingEnterBidAmount";
        public static final String ITEM_VIEW_CONFIRM_BID_DIALOG = "ViewItemConfirmBidDialog";
        public static final String ITEM_VIEW_DESCRIPTION = "ViewItemDescription";
        public static final String ITEM_VIEW_PHOTO_GALLERY = "ViewItemPhoto";
        public static final String ITEM_VIEW_SELLER_NOTES = "SellerNotes";
        public static final String ITEM_VIEW_SHIP_PAY_RETURN = "ViewItemShipping";
        public static final String ITEM_VIEW_TRACK_PACKAGE = "TrackPackage";
        public static final String LEAVE_FEEDBACK = "LeaveFeedback";
        public static final String LISTING_CATEGORIES = "SellingCategory";
        public static final String LISTING_CONDITION = "RefineItemCondition";
        public static final String LISTING_DETAILS = "SellingItemDetails";
        public static final String LISTING_FORMAT = "SellingItemFormatAndPrice";
        public static final String LISTING_ITEM_SPECIFICS = "SellingItemSpecifics";
        public static final String LISTING_PHOTOS = "SellingItemPhoto";
        public static final String LISTING_RECOMMENDED_PRICE = "SellingPriceRecommendation";
        public static final String LISTING_SHIPPING = "SellingShippingService";
        public static final String LISTING_SMART_BOX = "SmartSelling";
        public static final String LISTING_TITLE = "SellingItemTitleAndSubtitle";
        public static final String LISTING_USER_PREFS = "SellingUserPrefs";
        public static final String MEMBER_TO_MEMBER_MESSAGE = "M2M";
        public static final String MENU = "Menu";
        public static final String MERCH_FEED = "MerchFeed";
        public static final String MERCH_ITEM_SELECTED = "MerchItemSelected";
        public static final String MESSAGES_ARCHIVE_FOLDER = "MsgArchive";
        public static final String MESSAGES_CUSTOM_FOLDER = "MsgMyFolder";
        public static final String MESSAGES_INBOX = "MsgInbox";
        public static final String MESSAGES_INBOX_DATA = "MsgData";
        public static final String MESSAGES_SENT_FOLDER = "MsgSent";
        public static final String MESSAGE_EDIT = "MsgEdit";
        public static final String MY_EBAY_BUYING = "MyEbayBuying";
        public static final String MY_EBAY_ITEM_REMOVE = "MyEbayItemRemove";
        public static final String MY_EBAY_SCHEDULED = "MyEbayScheduledList";
        public static final String MY_EBAY_SELLER_TOTALS = "MyEbaySellerTotals";
        public static final String MY_EBAY_SELLING_DRAFTS = "MyEbaySellingDrafts";
        public static final String MY_EBAY_SELLING_LIST = "MyEbaySellingList";
        public static final String MY_EBAY_SOLD = "MyEbaySoldList";
        public static final String MY_EBAY_UNSOLD = "MyEbayUnsoldList";
        public static final String MY_EBAY_WATCHING = "MyEbayWatching";
        public static final String NOTIFICATION_ACTION_EVENT = "NotificationAction";
        public static final String NOTIFICATION_BUNDLED = "BundledNotificationsReceived";
        public static final String NOTIFICATION_ERROR = "NotificationError";
        public static final String NOTIFICATION_MODE_CHANGE = "NotificationModeChange";
        public static final String NOTIFICATION_RECEIVED_EVENT = "NotificationReceived";
        public static final String NOTIFICATION_SETTINGS_CHANGED_EVENT = "SettingsNotificationsChanged";
        public static final String NO_SEARCH_RESULTS_EVENTS = "NullSearch";
        public static final String OCS = "ContactEbaySupport";
        public static final String OFFER_BUYER_MAKE_OPENED = "BestOfferBuyerMake";
        public static final String OFFER_BUYER_RESPOND_OPENED = "BestOfferBuyerRespond";
        public static final String OFFER_EVENTS = "BestOfferEvents";
        public static final String OFFER_SELLER_RESPOND_OPENED = "BestOfferSellerRespond";
        public static final String OFFER_SELLER_REVIEW_OPENED = "BestOfferSellerReview";
        public static final String ONE_OFF_APPLICATION_EVENTS = "AppEvents";
        public static final String ORDER_SUMMARY = "OrderSummary";
        public static final String PAGE_BROWSE_CATEGORIES = "Browse";
        public static final String PAGE_BROWSE_FOLLOWING = "Following";
        public static final String PAGE_CHECKOUT_REVIEW_ORDER = "ReviewOrder";
        public static final String PAGE_REMINDERS = "Reminders";
        public static final String PAGE_REMINDERS_ITEMS = "RemindersItems";
        public static final String PAYMENT_METHOD_IMPRESSION = "PaymentOptions";
        public static final String PAYMENT_SENT = "PaymentSent";
        public static final String PAYPAL_ERROR = "PayPalError";
        public static final String PREFERRED_COUNTRY_SELECTION = "PreferredCountrySelection";
        public static final String PREFS_ACCESS_DENIED = "PrefsAccessDenied";
        public static final String PROCEED_TO_CHECKOUT_IMPRESSION = "ProceedToCheckout";
        public static final String PRODUCT_REVIEWS = "ProductReviews";
        public static final String PROX_CREDIT_CARD = "CreditCard";
        public static final String PROX_DIRECT_DEBIT = "DirectDebit";
        public static final String PROX_DIRECT_DEBIT_EULA = "DirectDebitEULA";
        public static final String PROX_DIRECT_DEBIT_IBAN = "DirectDebitIBAN";
        public static final String PROX_PAYMENT_METHOD = "PaymentMethod";
        public static final String PROX_PUI = "PayUponInvoice";
        public static final String PSL_SHIPPING_LABEL = "ShippingLabel";
        public static final String PSL_SHIPPING_LABEL_ERROR = "ShippingLabelError";
        public static final String PSL_SHIPPING_LABEL_SUCCESS = "ShippingLabelSuccess";
        public static final String PSL_SHIPPING_LABEL_VOID = "ShippingLabelVoid";
        public static final String RECENT_ITEMS_IMPRESSION = "RecentItemsList";
        public static final String REFERRAL = "Referral";
        public static final String REFINE_ASPECT = "RefineAspect";
        public static final String REFINE_AUCTION_TYPE = "RefineAuctionType";
        public static final String REFINE_CATEGORY = "RefineCategory";
        public static final String REFINE_ITEM_CONDITION = "RefineItemCondition";
        public static final String REFINE_MAX_DISTANCE = "RefineMaxDistance";
        public static final String REFINE_NEAR = "RefineNear";
        public static final String REFINE_PRICE_RANGE = "RefinePriceRange";
        public static final String REFINE_SEARCH = "RefineSearch";
        public static final String REFINE_SEARCH_PREFERRED_LOCATION = "RefineSearchPreferredLocation";
        public static final String REFINE_SORT_CAROUSEL = "SortOptions";
        public static final String REFINE_SORT_PANEL = "RefineSort";
        public static final String RELATED_SEARCH_EVENT = "RelatedSearchAvailable";
        public static final String RELATED_SEARCH_IMPRESSION = "RelatedSearchScroll";
        public static final String REQUEST_DETAILS = "SeeRequestDetails";
        public static final String REVIEW_LISTING = "ReviewListing";
        public static final String RTM_DOWNLOAD_PAGE = "RtmDownload";
        public static final String RTM_HTML_PAGE = "RtmHtml";
        public static final String RTM_ITEM_LIST_PAGE = "RTMItemList";
        public static final String RTM_THEMED_SEARCH_PAGE = "RtmThemedSearch";
        public static final String SALES_EVENTS_BROWSE = "SalesEventsBrowse";
        public static final String SALES_EVENTS_DETAIL = "SalesEventsDetail";
        public static final String SAVED_FOR_LATER = "ShoppingCartSaved";
        public static final String SAVED_SEARCH_FROM_NOTIFICATION = "SearchResultsFromSSNotification";
        public static final String SAVED_SEARCH_LIST = "SavedSearchList";
        public static final String SAVED_SEARCH_REFINE = "SavedSearchRefine";
        public static final String SAVE_SEARCH_FROM_BAR = "SavedSearchResults";
        public static final String SAVE_SEARCH_FROM_CAROUSEL = "NewSavedSearch";
        public static final String SCHEDULER = "Scheduler";
        public static final String SCHEDULER_DAYS = "ScheduleDays";
        public static final String SEARCH_ENTERED = "EnterSearch";
        public static final String SEARCH_PROMOTED_LISTING_CLICK = "PromotedListingClick";
        public static final String SEARCH_PROMOTED_LISTING_IMPRESSION = "PromotedListingImp";
        public static final String SEARCH_REFINEMENT_EVENT = "SearchRefinements";
        public static final String SEARCH_RESULTS_PAGE_IMPRESSION = "SearchResultsViewed";
        public static final String SEE_SELLERS_OTHER_ITEMS = "SeeSellersOtherItems";
        public static final String SELECT_COUNTRY_IMPRESSION = "AddNewCountryAddress";
        public static final String SELECT_MSKU_OPTIONS = "SelectMskuOptions";
        public static final String SELECT_MY_OWN_FORMAT_PRICE = "SelectMyOwnFP";
        public static final String SELLER_INSPIRATION = "SellerInspiration";
        public static final String SELLER_OFFER_PAGE = "SellerOfferPage";
        public static final String SELLING_EVENTS = "SellingEvents";
        public static final String SELLING_LANDING = "Selling";
        public static final String SELLING_NEW_LISTING = "NewListing";
        public static final String SELLING_SAVE_AS_DRAFT = "SellSaveAsDraft";
        public static final String SELLING_VERIFY_ITEM_SUCCESS = "SellVerifyAddItemSuccess";
        public static final String SELL_CATALOG_ITEM_FOR_LISTING = "SellCatalogItemSelectedForListing";
        public static final String SETTINGS = "Settings";
        public static final String SETTINGS_ABOUT = "SettingsAbout";
        public static final String SETTINGS_EVENTS = "SettingsEvents";
        public static final String SETTINGS_NOTIFICATIONS = "SettingsNotifications";
        public static final String SHARE_BEAM = "ShareBeam";
        public static final String SHARE_ITEM = "Sharing";
        public static final String SHOPPING_CART_EVENT = "ShoppingCartAction";
        public static final String SHOPPING_CART_IMPRESSION = "ShoppingCart";
        public static final String SIGNIN_FAILURE = "SignInFailure";
        public static final String SIGNIN_SUCCESS = "SignInSuccess";
        public static final String SIGN_IN_ENTRY = "SignInEntry";
        public static final String SIGN_IN_EXIT = "SignInExit";
        public static final String SIGN_OUT = "UserSignOut";
        public static final String SOP_INFO = "SOPInfo";
        public static final String SUB_DEPARTMENT = "SubDepartment";
        public static final String SYMBAN_BADGE_NOTIFICATION_ACTION = "BadgeNotificationAction";
        public static final String SYMBAN_BELL_NOTIFICATION = "BellNotification";
        public static final String TRENDING_CARD = "TrendingCard";
        public static final String TRENDING_HUB = "TrendingHub";
        public static final String USER_PROFILE = "UserProfile";
        public static final String VIEW_FEEDBACK = "ViewFeedback";
        public static final String VIEW_IN_CART_TAP = "ViewInCart";
        public static final String VIEW_ITEM = "ViewItem";
        public static final String VIEW_ITEM_BID_LAYER_CLOSE_TAP = "ViewItemBidCloseTap";
        public static final String VIEW_ITEM_BID_LAYER_CONFIRM_BID_TAP = "ViewItemConfirmBidTap";
        public static final String VIEW_ITEM_BID_LAYER_REVIEW_BID_TAP = "ViewItemReviewBidTap";
        public static final String VIEW_ITEM_COMPATIBILITY_BROWSED_VEHICLE = "CompatibilityBrowsedVehicle";
        public static final String VIEW_ITEM_COMPATIBILITY_LIST = "CompatibilityList";
        public static final String VIEW_ITEM_CONTAINER_EXPANSION = "ViewItemContainerExpansion";
        public static final String VIEW_ITEM_INCREASE_BID_TAP = "VIewItemIncreaseBidTap";
        public static final String VIEW_ITEM_PBV = "ViewItemPowerBidValue";
        public static final String VIEW_ITEM_UNWATCH = "UnwatchItem";
        public static final String VIEW_ITEM_WATCH = "WatchItem";
        public static final String VIEW_MESSAGE = "ViewMessage";
        public static final String WEBSOCKET = "Websocket";
        public static final String WEBVIEW_BUYER_PROTECTION = "EBayBuyerProtection";
        public static final String WEBVIEW_BUYER_REG = "BuyerRegistrationStart";
        public static final String WEBVIEW_EFT_DETAILS = "SellerEftDetails";
        public static final String WEBVIEW_EULA = "EULAAbout";
        public static final String WEBVIEW_FORGOT_PASSWORD = "ForgotPassword";
        public static final String WEBVIEW_GIVINGWORKS_CREDIT = "SellerGivingWorksCredit";
        public static final String WEBVIEW_GIVINGWORKS_TERMS = "SellerGivingWorksTerms";
        public static final String WEBVIEW_GSP = "ViewItemGSPTermsAndConditions";
        public static final String WEBVIEW_INCENTIVE_FAQ = "IncentiveFaqInfo";
        public static final String WEBVIEW_LEGAL = "LegalInfo";
        public static final String WEBVIEW_SALE_PRICE_GUARANTEE_TERMS = "spgLearnMore";
        public static final String WEBVIEW_SELLER_FEES = "SellerFeesInfo";
        public static final String WEBVIEW_SELLER_REG = "SellerRegistrationStart";
        public static final String WEBVIEW_SHIP_TO_FUND = "ShipToFundInfo";
        public static final String WEB_LANDING = "WebViewLandingPage";


        private EventName()
        {
        }
    }

    public static class Flag
    {

        public static final int GBH_COUNTRY_IS_SITE = 15;
        public static final String GBH_FLAG_NAME = "cflags";
        public static final int VIEW_ITEM_CARTABLE_FLAG = 117;
        public static final int VIEW_ITEM_FAST_N_FREE_FLAG = 145;
        public static final String VIEW_ITEM_FLAG_NAME = "ViewItemFlags";
        public static final int VIEW_ITEM_IS_GSP_ITEM = 161;
        public static final int VIEW_ITEM_IS_ITEM_ACTIVE = 23;

        private Flag()
        {
        }
    }

    public static class Formatters
    {

        public Formatters()
        {
        }
    }

    public static final class Formatters.SellerOfferItem
    {

        private static final String RECORD_DELIMITER = ";";
        private static final String VALUE_DELIMITER = "-";
        public final long itemId;
        public final String offerId;
        public final String offerType;

        public static String format(List list)
        {
            if (list == null || list.isEmpty())
            {
                return "";
            }
            StringBuilder stringbuilder = new StringBuilder();
            Formatters.SellerOfferItem sellerofferitem;
            for (list = list.iterator(); list.hasNext(); stringbuilder.append(sellerofferitem.itemId).append("-").append(sellerofferitem.offerId).append("-").append(sellerofferitem.offerType).append(";"))
            {
                sellerofferitem = (Formatters.SellerOfferItem)list.next();
            }

            stringbuilder.deleteCharAt(stringbuilder.length() - ";".length());
            return stringbuilder.toString();
        }

        public Formatters.SellerOfferItem(long l, String s, String s1)
        {
            itemId = l;
            offerId = s;
            offerType = s1;
        }
    }

    public static class Legacy
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

        private Legacy()
        {
        }
    }

    public static class Tag
    {

        public static final String ACTIVE_SELLING_COUNT = "aselling";
        public static final String ADS_AD_ID = "adid";
        public static final String ADS_AD_TYPE = "adtype";
        public static final String ADS_CAMPAIGN_ID = "campID";
        public static final String APP_ID = "ai";
        public static final String BARCODE = "bcd";
        public static final String BARCODE_TYPE = "bct";
        public static final String BELL_COUNT = "aiBellCnt";
        public static final String BEST_OFFER_ID = "ofid";
        public static final String BIDS_COUNT = "bids";
        public static final String BID_COUNT = "bc";
        public static final String BID_IS_HIGHER_THAN_MIN_BID = "pxybid";
        public static final String BID_IS_ITEM_HAS_BIN = "abin";
        public static final String BID_IS_REBID = "rebid";
        public static final String BID_IS_RESERVE_MET = "resmet";
        public static final String BID_IS_USER_WATCHED_ITEM = "watcher";
        public static final String BID_ITEM_HAS_RESERVE = "resprice";
        public static final String BID_REQUIRES_PAYPAL = "ppreq";
        public static final String BID_STATE_TYPE = "type";
        public static final String BID_TRANSACTION_ID = "bti";
        public static final String BOPIS_CHECKOUT_IN_STORE_SHOWN = "recoisp";
        public static final String BOPIS_NO_STORES_FOUND = "nsf";
        public static final String BOPIS_OUT_OF_STOCK = "ostk";
        public static final String BOPIS_OUT_OF_STOCK_ITEMS = "ostkitms";
        public static final String BOPIS_OVERRIDE_ADDRESS = "overridesa";
        public static final String BOPIS_OVERRIDE_GPS = "overridegps";
        public static final String BOPIS_SHIPPING_ADDRESS_AVAILABLE = "saa";
        public static final String BOPIS_STORE_AVAILABLE = "storeavlbl";
        public static final String BOPIS_STORE_PICKER_FIRST = "ispfshow";
        public static final String BOPIS_STORE_PICKER_TYPE = "stpicker";
        public static final String BROWSE_FILTER = "filter";
        public static final String BROWSE_ITEM = "itm";
        public static final String BUCKS = "eBayBucks";
        public static final String CART_ADD_TO_CART = "addtocart";
        public static final String CART_ID = "ebc";
        public static final String CART_ITEMS_ACTED_ON = "itm";
        public static final String CART_ITEMS_IN_CART = "cart_itm";
        public static final String CART_REMOVE_FROM_CART = "rmvcart";
        public static final String CART_REMOVE_FROM_SAVE_FOR_LATER = "rmvsfl";
        public static final String CART_SIZE = "crtsz";
        public static final String CART_TO_CART_FROM_SAVE_FOR_LATER = "move2cart";
        public static final String CART_TO_SAVE_FOR_LATER = "svfl";
        public static final String CART_UNAVAILABLE_ITEMS_IN_CART = "itm_unavbl";
        public static final String CATEGORY_KEYWORD_SEARCH = "kscat";
        public static final String CATEGORY_LABEL = "catlbl";
        public static final String CHARITY_DONATE = "donate";
        public static final String CHARITY_DONATE_ID = "donatecharityID";
        public static final String CHARITY_FAVORITE = "favchar";
        public static final String CHARITY_IDS = "charityID";
        public static final String CHECKOUT_CARD_OR_COUPON_REDEEMED = "credeemed";
        public static final String CHECKOUT_CART_CURRENCY = "chtpc";
        public static final String CHECKOUT_CART_FLOW = "ckfl";
        public static final String CHECKOUT_CART_FLOW_IMMEDIATE_PAY = "ip";
        public static final String CHECKOUT_CART_FLOW_REGULAR_CHECKOUT = "rc";
        public static final String CHECKOUT_CART_FLOW_SHOPPING_CART = "sc";
        public static final String CHECKOUT_CART_ID = "cart_id";
        public static final String CHECKOUT_CART_TOTAL_PRICE = "chtp";
        public static final String CHECKOUT_EFT_EMAIL = "eftemail";
        public static final String CHECKOUT_MEC_VERSION = "mecv";
        public static final String CHECKOUT_PAYMENT_DRAWER_OPEN = "opo";
        public static final String COLLECTION_FOLLOWERS = "followers";
        public static final String COLLECTION_ID = "collectionID";
        public static final String CONTAINER_EXPAND_STATE = "ces";
        public static final String CONTAINER_EXPAND_STATE_NAME = "cesn";
        public static final String CURRENT_PRICE = "curprice";
        public static final String DEPARTMENT = "dept";
        public static final String DRAFT_COUNT = "drafts";
        public static final String DRAFT_ID = "draft_id";
        public static final String DRAFT_ITEM_REMOVAL = "draftitem";
        public static final String DROP_DOWN = "dd";
        public static final String EBAY_NOW_AVAILABLE = "ebn";
        public static final String EBN_PHONE_REMINDER_SURFACED = "chkphchg";
        public static final String EBN_REFINEMENT_POSTAL_MISMATCH = "chkaddrchg";
        public static final String EBN_XO_RECOMMENDATION_SHOWN = "recoebn";
        public static final String ERR_CODE = "errCode";
        public static final String ERR_DESC = "errDesc";
        public static final String FEED_INTEREST_ID = "iid";
        public static final String FILTERBY = "filterby";
        public static final String FLOATING_BAR = "FL_bar";
        public static final String FOLLOWING_COLLECTIONS_COUNT = "colcnt";
        public static final String FOLLOWING_INTERESTS_COUNT = "intrstcnt";
        public static final String FOLLOWING_MEMBERS_COUNT = "memcnt";
        public static final String GBH_AUTO_DETECT = "ad";
        public static final String GBH_BUYERS_SITE = "bs";
        public static final String GBH_COUNTRY = "uc";
        public static final String GENERIC_SUCCESS = "succ";
        public static final String GEO_ACCURACY = "mlocacc";
        public static final String GEO_AGE = "mlocage";
        public static final String GEO_ALTITUDE = "mlocalt";
        public static final String GEO_COORDINATES = "mloc";
        public static final String GEO_ERROR = "mlocerr";
        public static final String GEO_GRANULARITY = "mlocgran";
        public static final String GEO_GRANULARITY_VALUE_HIGH = "high";
        public static final String GEO_GRANULARITY_VALUE_LOW = "low";
        public static final String GEO_HEADING = "mlocdir";
        public static final String GEO_SETTINGS = "mlocset";
        public static final String GEO_SETTINGS_VALUE_ALL_DISABLED = "0";
        public static final String GEO_SETTINGS_VALUE_ALL_ENABLED = "3";
        public static final String GEO_SETTINGS_VALUE_GPS_ENABLED = "4";
        public static final String GEO_SETTINGS_VALUE_NETWORK_ENABLED = "5";
        public static final String GEO_SPEED = "mlocspeed";
        public static final String GUARANTEE_SELECTED = "spg";
        public static final String HOMEPAGE_CHANNEL = "chnl";
        public static final String HOMEPAGE_SUBCHANNEL = "subchnl";
        public static final String IAF_TOKEN = "iafToken";
        public static final String IMMEDIATE_PAY = "ipay";
        public static final String INVALID_POSTAL_CODE_EBAY_NOW = "uzc";
        public static final String INVOICE_COUNT = "invoices";
        public static final String ITEM_VIEW_BID_INCREMENT = "bi";
        public static final String ITEM_VIEW_ITEM_TITLE = "itmtitle";
        public static final String ITEM_VIEW_PRODUCT_REF_ID = "pri";
        public static final String ITEM_VIEW_PRODUCT_REVIEW_AVAILABLE = "PR";
        public static final String ITEM_VIEW_QUANTITY_AVAILABLE = "qtya";
        public static final String ITEM_VIEW_QUANTITY_SOLD = "qtys";
        public static final String ITEM_VIEW_SNIPPET_SHOWN = "snp";
        public static final String ITEM_VIEW_TIME_REMAINING_SEC = "tr";
        public static final String ITEM_VIEW_VARIATION_ID = "var";
        public static final String LANDSCAPE = "l";
        public static final String LEAF = "leaf";
        public static final String LISTED_ITEM_ID = "liid";
        public static final String LISTING_ACTUAL_AUCTION_PRICE = "actsprice";
        public static final String LISTING_ACTUAL_BIN_PRICE = "actbprice";
        public static final String LISTING_CHECKED_SPOKES = "chk_spokes";
        public static final String LISTING_ITEM_ID = "itemId";
        public static final String LISTING_REC_AUCTION_PRICE = "recsprice";
        public static final String LISTING_REC_BIN_PRICE = "recbprice";
        public static final String LISTING_TYPE = "smd";
        public static final String LISTING_TYPE_NEW_LISTING = "0";
        public static final String LISTING_TYPE_RELIST_ITEM = "2";
        public static final String LISTING_TYPE_REVISE_ITEM = "1";
        public static final String LISTING_TYPE_SELL_ONE_LIKE = "6";
        public static final String LISTING_TYPE_SELL_SIMILAR_ITEM = "3";
        public static final String LOST_COUNT = "lost";
        public static final String LOST_ITEM_REMOVAL = "lostitem";
        public static final String MAX_PBV = "maxPBV";
        public static final String MEC_VERSION_MEC2 = "mec2";
        public static final String MEC_VERSION_PLUS = "mec+";
        public static final String MENU_HOME = "Home";
        public static final String MENU_MOTORS_HOME = "MotorsHome";
        public static final String MENU_MYEBAY = "MyEbay";
        public static final String MENU_SYMBAN = "Symban";
        public static final String MERCH_SVC_DATA = "svcdata";
        public static final String MESSAGES_ACTION = "msgact";
        public static final String MESSAGES_EBAY_MSG = "eBaymes";
        public static final String MESSAGES_MEMBER_MSG = "memmes";
        public static String MESSAGE_DIRECTION = "Msgdir";
        public static final String MES_QTAGS = "qTags";
        public static final String MET_SELLER_OFFERS = "mo";
        public static final String MIMS_IDS_TAG = "ids";
        public static final String MPPID = "mppid";
        public static final String MULTY_QUANTITY = "mqty";
        public static final String NECTAR = "Nectar";
        public static final String NOTIFICATION_ACTION_STATUS = "pnact";
        public static final String NOTIFICATION_COUNT = "NotificationCnt";
        public static final String NOTIFICATION_ITEM_ID = "itm";
        public static final String NOTIFICATION_ROW = "nRow";
        public static final String NOTIFICATION_STATUS = "nStatus";
        public static final String NOTIFICATION_TYPE = "ntype";
        public static final String NUM_BIDDERS = "bdrs";
        public static final String NUM_PBV = "numPBV";
        public static final String NUM_WATCHERS = "nw";
        public static final String OFFERS_COUNT = "offers";
        public static final String OFFER_ID = "offer_id";
        public static final String OFFER_TYPE = "offer_type";
        public static final String ORIGINAL_ITEM_ID = "origItemId";
        public static final String PAID_ITEM_REMOVAL = "paiditem";
        public static final String PAYMENT_METHOD = "paywith";
        public static final String PAYMENT_REMINDER_STATE = "SPR";
        public static final String PBV_AMOUNT = "PBVamount";
        public static final String PLUS_LOGO_VIP = "Epm";
        public static final String PORTRAIT = "p";
        public static final String PRM_USE_CASE = "prm";
        public static final String PROX = "prox";
        public static final String PSL_ERROR = "ERR_MSG";
        public static final String PSL_VOID = "rsn";
        public static final String PUDO = "pudo";
        public static final String PURCHASE_COUNT = "purchases";
        public static final String QUANTITY = "quan";
        public static final String RELATED_SEARCH_AVAILABLE = "sra";
        public static final String RELATED_SEARCH_SELECTED = "srs";
        public static final String REMEMBER_ME = "rmbrme";
        public static final String REMEMBER_PAYMENT = "spm";
        public static final String REQUEST_CORRELATION_ID = "rq";
        public static final String RLU_TYPE = "rlutype";
        public static final String SALES_EVENT_GROUP_ID = "egid";
        public static final String SALES_EVENT_ID = "eid";
        public static final String SAVED_SEARCH_RESULT_ID = "ssrid";
        public static final String SAVE_FOR_LATER_ITEMS = "itm_sfl";
        public static final String SCHEDULED_COUNT = "scheduled";
        public static final String SCHEDULER_COMPLETED = "scheLoad";
        public static final String SCHEDULER_DAYS_TABS = "tabs";
        public static final String SCHEDULER_DELIVERY_INSTRUCTIONS = "scheDI";
        public static final String SCREEN_ORIENTATION = "ort";
        public static final String SEARCH_QUERY_PREFIX = "sqp";
        public static final String SEARCH_RESULTS_RANK = "srrank";
        public static final String SECOND_CHANGE_OFFER_COUNT = "sco";
        public static final String SELLER_INSPIRATION_VARIATION_ID = "variationID";
        public static final String SELLER_NAME = "sn";
        public static final String SELLER_OFFER_ID = "offer_id";
        public static final String SELLER_OFFER_PAGE = "sop";
        public static final String SELLER_OFFER_TYPE = "offer_type";
        public static final String SELLER_QUERY_NAME = "sQr";
        public static final String SELL_CHARITY = "scu";
        public static final String SELL_CHARITY_DONATION = "scdv";
        public static final String SELL_CHARITY_DONATION_CHANGE = "scdc";
        public static final String SELL_CHARITY_LOADED = "scload";
        public static final String SELL_CHARITY_VENDOR_CHANGED = "scvc";
        public static final String SHIP_SITE = "shipsiteid";
        public static final String SIGNIN_TYPE = "sgnType";
        public static final String SIGN_IN_EXIT_BACK = "isBack";
        public static final String SIGN_OUT_REASON = "sor";
        public static final String SIGN_OUT_REASON_IAF = "iaf";
        public static final String SIGN_OUT_REASON_USER_INITIATED = "user";
        public static final String SITE = "site";
        public static final String SOLD_COUNT = "sold";
        public static final String SOLD_ITEM_REMOVAL = "solditem";
        public static final String SUB_DEPARTMENT = "subdept";
        public static final String TIMEZONE_OFFSET = "tz";
        public static final String TREND_RANK = "tcrank";
        public static final String UNIQUE_DEVICE_ID = "udid";
        public static final String UNMET_SELLER_OFFERS = "umo";
        public static final String UNPAID_ITEM_COUNT = "ui";
        public static final String UNSOLD_COUNT = "unsold";
        public static final String UNSOLD_ITEM_REMOVAL = "unsolditem";
        public static final String UNWATCH_ACTION = "action";
        public static final String UNWATCH_ACTION_EDIT_AND_DELETE = "1";
        public static final String USERNAME = "user_name";
        public static final String USE_CASE = "usecase";
        public static final String VALUE_SCANNED_ITEM_FOUND = "SF";
        public static final String VALUE_SCANNED_ITEM_NOT_FOUND = "SN";
        public static final String VALUE_SCANNED_RL_FALLBACK = "RLFB";
        public static final String VLS_ENABLED = "vls";
        public static final String WATCH_ITEM_COUNT = "wi";
        public static final String WEBVIEW_APP_SESSION_GUID = "asguid";
        public static final String WEBVIEW_URL = "url";


        private Tag()
        {
        }
    }


    public static final String TRACKING_APP_ID = "2571";

    public Tracking()
    {
    }
}
