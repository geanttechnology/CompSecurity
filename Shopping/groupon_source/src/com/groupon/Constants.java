// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon;

import com.groupon.models.country.Country;
import com.groupon.models.country.EnabledFeatures;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public final class Constants
{
    public static class ActivityRequestCodes
    {

        public static final int ALIPAY_PURCHASE = 10150;
        public static final int CANCEL_ORDER = 10146;
        public static final int CATEGORIES_BASE = 10101;
        public static final int CITIES = 10125;
        public static final int DEAL_IMAGE_CAROUSEL = 10149;
        public static final int DELIVERY_ADDRESSES = 10122;
        public static final int DOTPAY_PURCHASE = 10138;
        public static final int EDIT_CREDIT_CARD = 10102;
        public static final int EXTERNAL_PURCHASE = 10139;
        public static final int FACEBOOK_LOGIN = 30000;
        public static final int GIFTING2 = 10107;
        public static final int GIFT_CODES = 10105;
        public static final int GOOGLE_LOG_IN = 40000;
        public static final int GOOGLE_SIGN_UP = 40001;
        public static final int GROUPON = 10108;
        public static final int GROUPON_LOCATION_SELECTION = 10141;
        public static final int GROUPON_SSO_REQUEST_CODE = 10142;
        public static final int IDEAL_PURCHASE = 10109;
        public static final int INCENTIVE_TICKETS = 10126;
        public static final int IPAY88_PURCHASE = 10133;
        public static final int JP_AU_EASYPAY_PURCHASE = 10127;
        public static final int LOGIN = 10110;
        public static final int MAESTRO_PURCHASE = 10111;
        public static final int MASTERCARD_PE_PURCHASE = 10144;
        public static final int MOBILE_SCHEDULER = 10140;
        public static final int MULTI_OPTION_ACTIVITY = 10134;
        public static final int MY_CREDIT_CARDS = 10112;
        public static final int ONE_CLICK_PAYMENT_PURCHASE = 10135;
        public static final int PAYPAL_PURCHASE = 10113;
        public static final int PRECONFIGED_ABTESTS = 10148;
        public static final int PSE_PURCHASE = 10145;
        public static final int REDCOMPRA_PURCHASE = 10136;
        public static final int REDEEM = 10115;
        public static final int SECURE_3D_PURCHASE = 10123;
        public static final int SHIPPING_ADDRESS = 10119;
        public static final int SHIPPING_ADDRESS_EU = 10120;
        public static final int STOCK_CATEGORIES = 10121;
        public static final int VISA_PE_PURCHASE = 10143;
        public static final int WEBPAY_PURCHASE = 10137;

        public ActivityRequestCodes()
        {
        }
    }

    public static class AttrKey
    {

        public static final String IS_SHOW_BADGE_AB_TEST_ON = "is_show_badge_ab_test_on";
        public static final String POSITION = "position";

        public AttrKey()
        {
        }
    }

    public static class Breakdowns
    {

        public static final String ADJUSTMENTS_DISCOUNT = "discount";
        public static final String ADJUSTMENTS_TAX = "tax";
        public static final String TENDER_CASH = "cash";
        public static final String TENDER_CREDITS = "credit";

        public Breakdowns()
        {
        }
    }

    public static class BusinessDetailAvailableImageSizes
    {

        public static final String MEDIUM = "t670x147.jpg";

        public BusinessDetailAvailableImageSizes()
        {
        }
    }

    public static class CacheManagement
    {

        public static final String CACHE_ACTION = "restart";
        public static final String CACHE_BUST = "cacheBust";
        public static final String CACHE_EVENT_CATEGORY = "CacheBusting";
        public static final String CACHE_KEY = "X-Groupon-Cache-Token";
        public static final String CLEAR_CACHE = "clearCache";
        public static final String EXIT = "EXIT";
        public static final String FIRST_INTERCEPT = "firstIntercept";

        public CacheManagement()
        {
        }
    }

    public static class CancelOrder
    {

        public static final String CANCEL_ORDER_CLICK = "cancel_order_click";
        public static final String CANCEL_ORDER_CONFIRM_CLICK = "confirm_cancellation_click";
        public static final String CANCEL_ORDER_FROM_THANK_YOU = "cancel_order_from_thank_you";
        public static final String CANCEL_ORDER_REASON_OTHER = "cancel_other_reason_done";
        public static final String CANCEL_ORDER_REASON_PREDEFINED = "cancel_order_cause_click";
        public static final String CANCEL_ORDER_SPECIFIER = "cancel_order";
        public static final String CANCEL_ORDER_URL = "https:/users/%s/orders/%s";
        public static final String CANCEL_REASON_URL = "https:/resignation_reasons";
        public static final String DEAL_DETAILS_URL = "https:/deals/%s";
        public static final String FROM_CANCEL_ORDER = "from_cancel_order";
        public static final String ORDER_DETAILS_REQUEST_URL = "https:/users/%s/orders/%s";
        public static final String OTHER_DESCRIPTION = "Other";
        public static final String REASON_LIST_RESPONSE = "reason_list_response";
        public static final String REASON_SELECTED_KEY = "reason_selected_key";

        public CancelOrder()
        {
        }
    }

    public static class CountriesCodes
    {

        public static final String BE = "be";
        public static final String CA = "ca";
        public static final String CA_EU = "ca_eu";
        public static final String CO = "co";
        public static final String IE = "ie";
        public static final String IL = "il";
        public static final String JP = "jp";
        public static final String MX = "mx";
        public static final String NZ = "nz";
        public static final String PE = "pe";
        public static final String RU = "ru";
        public static final String SE = "se";
        public static final String UAE = "ae";
        public static final String UK = "uk";
        public static final String US = "us";

        public CountriesCodes()
        {
        }
    }

    public static class CountriesCodesISO3166
    {

        public static final String CA = "CA";
        public static final String GB = "GB";

        public CountriesCodesISO3166()
        {
        }
    }

    public static class CouponAvailableImageSizes
    {

        public static final String MEDIUM = "/v1/t300x300.png";
        public static final String SMALL = "/v1/t200x200.png";

        public CouponAvailableImageSizes()
        {
        }
    }

    public static class CreditCards
    {

        public static final String ID_ALIPAY = "alipay";
        public static final String ID_AMERICAN_EXPRESS = "american express";
        public static final String ID_AMEX = "amex";
        public static final String ID_ARGENCARD = "argencard";
        public static final String ID_ASIA_PLAY = "asiaplay";
        public static final String ID_AU_EASYPAY = "auEasyPay";
        public static final String ID_CABAL = "cabal";
        public static final String ID_DINERO_MAIL = "dineromail";
        public static final String ID_DINERSCLUB = "diners club";
        public static final String ID_DISCOVER = "discover";
        public static final String ID_DOTPAY = "dotpay";
        public static final String ID_ELV = "elv";
        public static final String ID_GOOGLE_WALLET = "google-wallet";
        public static final String ID_HIPERCARD = "hipercard";
        public static final String ID_IDEAL = "ideal";
        public static final String ID_IPAY88 = "ipay88";
        public static final String ID_ISRACARD = "isracard";
        public static final String ID_ITALCRED = "italcred";
        public static final String ID_JCB = "jcb";
        public static final String ID_MAESTRO = "maestro";
        public static final String ID_MAESTRO_UK = "maestrouk";
        public static final String ID_MASTER = "master";
        public static final String ID_MASTERCARD = "mastercard";
        public static final String ID_MASTERCARD_PE = "mastercard-pe";
        public static final String ID_MASTER_CARD = "MasterCard";
        public static final String ID_MONE_CLICK_CL = "m-oneclick-cl";
        public static final String ID_MONE_DEBIT_CL = "m-debit-cl";
        public static final String ID_MONE_WEBPAY_CL = "m-webpay-cl";
        public static final String ID_MULTI_PLUS_POINTS = "multipluspoints";
        public static final String ID_NARANJA = "naranja";
        public static final String ID_ONE_CLICK_PAYMENT = "m-oneclick-cl";
        public static final String ID_PAYPAL = "paypal";
        public static final String ID_PAYPAL_MX = "paypal-mx";
        public static final String ID_PSE = "pse-mobile-co";
        public static final String ID_REDCOMPRA_PAYMENT = "m-debit-cl";
        public static final String ID_SEPA = "sepadirectdebit";
        public static final String ID_VISA = "visa";
        public static final String ID_VISA_PE = "visanet-pe";
        public static final String ID_VOLATILE = "volatile";
        public static final String ID_WEBPAY_PAYMENT = "m-webpay-cl";
        public static final String MASTERCARD_PE_TYPE = "mastercard-pe";
        public static final String PAYMENT_TYPE_CREDITCARD = "CreditCard";
        public static final String PAYMENT_TYPE_ECOMMERCE = "ECommerce";

        public CreditCards()
        {
        }
    }

    public static class DailySyncService extends Service
    {

        public static final String LOG_ACTION_SYNC_TIMEOUT = "sync_timeout";
        public static final String LOG_CATEGORY = "daily_syncer";
        public static final String LOG_LABEL_COMPLETED_FEATURED_SYNC = "completed_featured_sync";
        public static final String LOG_LABEL_COMPLETED_PULL_NOTIFICATION_SYNC = "completed_pull_notification_sync";
        public static final String LOG_LABEL_COMPLETED_STARTUP_SYNC = "completed_startup_sync";
        public static final String LOG_LABEL_NO_LOCATION_SET = "no_location_set";
        public static final String LOG_RETRY_CATEGORY = "daily_syncer_retry";
        public static final String LOG_TOO_MANY_RETRIES = "too_many_retries";

        public DailySyncService()
        {
        }
    }

    public static final class DatabaseV2
    {

        public static final String BUSINESS_CHANNEL_ID = "businessChannelId";
        public static final String CATEGORY_FIELD_NAME = "category";
        public static final String CHANNEL_FIELD_NAME = "channel";
        public static final String DEALID_FIELD_NAME = "dealId";
        public static final String DEALUUID_FIELD_NAME = "dealUuid";
        public static final String END_AT_FIELD_NAME = "endAt";
        public static final String GROUPON_NUMBER_FIELD_NAME = "grouponNumber";
        public static final String IS_EXACT_MATCH = "isExactMatch";
        public static final String LOCAL_BOOKING_INFO_STATUS = "localBookingInfoStatus";
        public static final String LOCATED_FIELD_NAME = "located";
        public static final String MODIFICATION_DATE_FIELD_NAME = "modificationDate";
        public static final String OPTIONID_FIELD_NAME = "optionId";
        public static final String PRIMARY_KEY_FIELD_NAME = "_id";
        public static final String REMOTEID_FIELD_NAME = "remoteId";
        public static final String START_AT_FIELD_NAME = "startAt";
        public static final String TIMESTAMP_FIELD_NAME = "timestamp";
        public static final String TITLE_FIELD_NAME = "title";
        public static final String UPDATED_AT = "updatedAt";

        public DatabaseV2()
        {
        }
    }

    public static class DealTypes
    {

        public static final String LOG_ACTION_PAGE_VIEW = "page_view";
        public static final String LOG_ACTION_SEE_PERSONALIZED_DEALS_CLICK = "see_personalized_deals_click";
        public static final String LOG_ACTION_TURN_HEART_OFF = "turn_heart_off";
        public static final String LOG_ACTION_TURN_HEART_ON = "turn_heart_on";
        public static final String LOG_CATEGORY = "deal_types";
        public static final String LOG_LABEL_PAGE = "page";
        public static final int LOG_VALUE_DEALTYPES_PAGE = 2;

        public DealTypes()
        {
        }
    }

    public static class Extra
    {

        public static final String ACTIVITY_NAME = "activity_name";
        public static final String AVAILABLE_CC_PAYMENT_METHODS_FOR_DEAL = "available_cc_payment_methods_for_deal";
        public static final String AVAILABLE_PAYMENT_METHODS_FOR_DEAL = "available_payment_methods_for_deal";
        public static final String BILLING_RECORD_CARD_NUMER = "billingRecordNumber";
        public static final String BILLING_RECORD_CITY = "billingRecordCity";
        public static final String BILLING_RECORD_ID = "billingRecordId";
        public static final String BILLING_RECORD_POSTAL_CODE = "billingRecordPostalCode";
        public static final String BILLING_RECORD_STATE = "billingRecordState";
        public static final String BILLING_RECORD_STREET_ADDRESS_ONE = "billingRecordStreetAddressOne";
        public static final String BITMAP = "bitmap";
        public static final String BOOKED = "booked";
        public static final String BOOKING_ENGINE = "booking_engine";
        public static final String BUSINESS_ID = "business_id";
        public static final String CARD_TYPE = "card_type";
        public static final String CAROUSEL_ORIGIN_CHANNEL = "carousel_origin_channel";
        public static final String CART_DEAL_IMAGE_URL = "cart_deal_image_url";
        public static final String CART_UUID = "cart_uuid";
        public static final String CHANNEL = "channel";
        public static final String CHANNEL_OPTIONS = "channelOptions";
        public static final String COMING_FROM_CHECKOUT = "comingFromCheckout";
        public static final String COMING_FROM_LOGIN = "comingFromLogin";
        public static final String CONFIGURATION = "configuration";
        public static final String CONTEXT = "context";
        public static final String COUPON_FILTER_ID = "couponFilterId";
        public static final String COUPON_FILTER_ITEM_TYPE = "couponFilterItemType";
        public static final String COUPON_FILTER_PAGER_SLUG = "couponFilterPagerSlug";
        public static final String COUPON_FILTER_PAGER_TITLE = "couponFilterPagerTitle";
        public static final String COUPON_FILTER_STARTER_TAB = "couponFilterStarterTab";
        public static final String COUPON_ID = "couponId";
        public static final String COUPON_TOAST_MESSAGE = "coupon_toast_message";
        public static final String CREDENTIAL = "credential";
        public static final String CREDIT_CARD = "CREDIT_CARD";
        public static final String CREDIT_CARD_LAST_FOUR_DIGITS = "cc_four_digits";
        public static final String CREDIT_CARD_TYPE = "cc_type";
        public static final String CREDIT_CARD_VALIDATION_STATE = "cc_validation_state";
        public static final String CURRENT_STEP = "currentStep";
        public static final String DB_CHANNEL = "db_channel";
        public static final String DEAL_DETAILS_IMAGE_CURRENT_POSITION = "deal_details_image_current_position";
        public static final String DEAL_ID = "dealId";
        public static final String DEAL_IDS = "dealIds";
        public static final String DEAL_IMAGE_BIG_URLS = "deal_image_big_urls";
        public static final String DEAL_TITLE = "dealTitle";
        public static final String DEAL_UUID = "dealUuid";
        public static final String DEEP_LINK_WITH_API_PARAMETERS = "deep_link_with_api_parameters";
        public static final String DISCOUNT_VALUE = "discount";
        public static final String DISMISS_KEYGUARD = "dismissKeyguard";
        public static final String DISPLAY_COACH_MARK = "display_coach_mark";
        public static final String DIVISION_OBJECT = "division_object";
        public static final String EXIT_ON_BACK_PRESSED = "exit_on_back_pressed";
        public static final String EXPLICIT_OPTION_SELECTED = "explicit_option_selected";
        public static final String FACET_GROUP_FILTER = "facet_group_filter";
        public static final String FACET_GROUP_FILTERS = "facet_group_filters";
        public static final String FIRST_SHIPPING_ADDRESS = "firstShippingAddress";
        public static final String FLOW = "flow";
        public static final String FROM_GLOBAL_SEARCH = "fromGlobalSearch";
        public static final String FROM_MY_GROUPONS = "isFromMyGroupons";
        public static final String FROM_SHOPPING_CART = "isFromShoppingCart";
        public static final String FROM_THANK_YOU = "from_thank_you";
        public static final String GDT_THANKS_PAGE_REACHED = "gdt_thanks_page_reached";
        public static final String GETAWAYS_BOOKING = "getaways_booking";
        public static final String GIFTING_RECORD = "giftingRecord";
        public static final String GIFTING_RECORD_BUNDLE = "gifting_record_bundle";
        public static final String GIFT_CODE = "gift_code";
        public static final String GLOBAL_SEARCH_CHANNEL_FILTER = "global_search_channel_filter";
        public static final String GLOBAL_SEARCH_GEOPOINT = "global_search_geopoint";
        public static final String GLOBAL_SEARCH_QUERY = "global_search_query";
        public static final String GROUPON_ID = "groupon_id";
        public static final String HIDE_HEADER = "hide_header";
        public static final String HIDE_PURCHASED_DEAL_INFO = "hide_purchased_deal_info";
        public static final String IMAGE_CAROUSEL_CURRENT_POSITION = "image_carousel_current_position";
        public static final String IMAGE_URL = "imageUrl";
        public static final String IMPRESSION_METADATA = "impression_metadata";
        public static final String INCENTIVE_TICKET_TYPE = "incentive_ticket_type";
        public static final String INCLUDE_EMAIL = "includeEmail";
        public static final String INTEREST = "interest";
        public static final String IN_APP_NEW_MESSAGES = "new_in_app_messages";
        public static final String IN_APP_SHOW_MESSAGE_BOX = "show_message_box";
        public static final String IS_BILLING_RECORD = "is_billing_record";
        public static final String IS_CLAIM_SPECIAL_CLICKED = "is_claim_special_clicked";
        public static final String IS_CURRENCY_CODE_USD = "is_currency_code_usd";
        public static final String IS_DEAL_PRE_PURCHASE_BOOKED = "is_deal_pre_purchase_booked";
        public static final String IS_DEEP_LINKED = "isDeepLinked";
        public static final String IS_GDT = "is_gdt";
        public static final String IS_LIST_OFFERS = "is_list_offers";
        public static final String IS_LOGGED = "isLogged";
        public static final String IS_LOTTERY_DEAL = "is_lottery_deal";
        public static final String IS_MARKET_RATE_DEAL = "is_market_rate_deal";
        public static final String IS_MASTER_ADDRESS = "is_master_address";
        public static final String IS_PREPURCHASE_BOOKING = "is_prepurchase_booking";
        public static final String IS_RATINGS_CLICKED = "is_ratings_clicked";
        public static final String IS_REQUEST_DEAL_CLICKED = "is_request_deal_clicked";
        public static final String IS_SHIPPING_ADDRESS = "isShippingAddress";
        public static final String IS_SHIPPING_ADDRESS_REQUIRED = "isShippingAddressRequired";
        public static final String IS_SHOPPING_CART_FLOW = "is_shopping_cart_flow";
        public static final String IS_USED_MY_GROUPON = "isUsedMyGroupon";
        public static final String IS_USING_GIFTCODES = "isUsingGiftCodes";
        public static final String IS_WEARABLE_OPEN = "is_wearable";
        public static final String IS_WEARABLE_PREVIEW_PURCHASE = "is_wearable_preview_purchase";
        public static final String JSON = "json";
        public static final String LARGE_CARDS = "LargeCard";
        public static final String LAT = "lat";
        public static final String LNG = "lng";
        public static final String LOCATION = "location";
        public static final String LOCATION_ADDRESS_ID_PAIRS = "location_address_id_pairs";
        public static final String LOCATION_ALTERNATIVE = "location_alternative";
        public static final String LOCATION_IDS = "locationIds";
        public static final String LOCATION_INDEX = "locationIndex";
        public static final String MAP = "map";
        public static final String MAX_CART_DISCOUNT = "max_cart_discount";
        public static final String MOBILE_ONLY = "mobile_only";
        public static final String MULTI_ITEM_ORDER_ID = "multiItemOrderId";
        public static final String MULTI_OPTION_SELECTION = "multi_option_selection";
        public static final String MULTI_USE_PROMO_CODE = "multi_use_promo_code";
        public static final String NEARBY_CONFIGURATION = "nearbyConfiguration";
        public static final String NEEDS_LOCATION = "needs_location";
        public static final String NEEDS_X_COOKIES = "needs_x_cookies";
        public static final String NEXT = "next";
        public static final String NID = "nid";
        public static final String NOTIFICATION_TYPE = "notificationType";
        public static final String NST_CHANNEL = "nstChannel";
        public static final String NUM_DEAL_ACTIVITIES_ON_STACK = "num_deal_activities_on_stack";
        public static final String NUM_DEAL_SUBSET_ACTIVITIES_ON_STACK = "num_deal_subset_activities_on_stack";
        public static final String NUM_ITEMS_IN_CART = "num_items_in_cart";
        public static final String OPEN_NAVIGATION_DRAWER = "open_navigation_drawer";
        public static final String OPTION_ID = "optionId";
        public static final String OPTION_UUID = "optionUuid";
        public static final String ORDER_ID = "orderID";
        public static final String ORIGINATING_CHANNEL = "originating_channel";
        public static final String PARTIAL_DEAL_SUBSET_URL = "partial_deal_subset_url";
        public static final String PAYMENT_METHOD_PREVIOUSLY_DISPLAYED = "payment_method_previously_displayed";
        public static final String PAYMENT_QUANTITY = "payment_quantity";
        public static final String PAYMENT_RES = "payment_res";
        public static final String PENDING = "pending";
        public static final String PLACE = "place";
        public static final String PLACE_ID = "placeId";
        public static final String QUANTITY = "quantity";
        public static final String QUERY = "query";
        public static final String REDIRECT_TO_ENTER_CODE = "redirect_to_enter_code";
        public static final String REFERRER = "referrer";
        public static final String REFERRER_LOCAL_NOTIFICATION = "local_notification";
        public static final String REFRESH = "refresh";
        public static final String REFRESH_CAROUSEL = "refreshCarousel";
        public static final String REGION = "region";
        public static final String REGION_ALTERNATIVE = "region_alternative";
        public static final String REMOVE_GIFT_CODES = "removeGiftCodes";
        public static final String REQUEST_RETRIES = "request_retries";
        public static final String RESERVATION_BUNDLE = "reservation_bundle";
        public static final String RESERVATION_EXTRA = "reservation_extra";
        public static final String RESERVATION_ID = "reservation_id";
        public static final String RESULT_FALSE = "result=False";
        public static final String RETURN_SELECTED_DIVISION = "return_selected_division";
        public static final String SEARCH_RESULTS_ONLY = "search_results_only";
        public static final String SEARCH_TERM = "search_term";
        public static final String SECOND_SHIPPING_ADDRESS = "secondShippingAddress";
        public static final String SELECTED_LOCATION_ID = "selected_location_id";
        public static final String SELECTED_PLACE = "selected_place";
        public static final String SELECTED_PLACE_BUNDLE = "selected_place_bundle";
        public static final String SELECTION_INDEX = "selectionIndex";
        public static final String SHARED_DEAL_INFO = "shared_deal_info";
        public static final String SHIPPING_ADDRESS = "shippingAddress";
        public static final String SHOULD_DISPLAY_DISCOUNT = "should_display_discount";
        public static final String SHOULD_LAUNCH_PURCHASE_PAGE = "should_launch_purchase_page";
        public static final String SHOULD_SHOW_MULTI_USE_PROMO_CODE_SUCCESS_MESSAGE = "should_show_multi_use_promo_code_success_message";
        public static final String SHOW_REQUEST_APPOINTMENT_POPUP = "show_request_appointment_popup";
        public static final String SHOW_SHIPPING_ADDRESS = "show_shipping_address";
        public static final String SLOT_ID = "slot_id";
        public static final String SOURCE_CHANNEL = "sourceChannel";
        public static final String SPECIAL_ID = "special_id";
        public static final String SUBSET_ID = "subset_id";
        public static final String SURVEY_ID = "survey_id";
        public static final String THANKS_HIDE_MY_GROUPONS = "thanks_hide_my_groupons";
        public static final String TITLE = "title";
        public static final String TRACKING = "tracking";
        public static final String TRAIT_COUNT = "traitCount";
        public static final String UNBOOKED = "unbooked";
        public static final String URL = "url";
        public static final String VALIDATION_CARD_NUMBER = "validationCardNumber";
        public static final String VENDOR_NAME = "vendorName";
        public static final String WIDGET_CAMPAIGN = "widget_campaign";
        public static final String WIDGET_REQUEST_ID = "widget_request_id";
        public static final String WIDGET_SCENARIO_ID = "widget_scenario_id";
        public static final String WIDGET_TREATMENT = "widget_treatment";
        public static final String ZIP_CODE = "zip_code";

        private Extra()
        {
        }
    }

    public static class FileName
    {

        public static final String EXPERIMENTS_FILE_NAME = "experiments.json";
        public static final String SCREENSHOT_CACHE = "screenshot-cache";

        private FileName()
        {
        }
    }

    public static class GeneralEvent
    {

        public static final String ACTION_DEAL_DETAILS_ONCREATE = "deal_details_onCreate";
        public static final String ACTION_DEAL_JSON_PARSING = "deal_json_parsing";
        public static final String ACTION_DEAL_POST_PROCESS = "deal_post_process";
        public static final String ACTION_DEAL_REQUEST_DURATION = "deal_request_duration";
        public static final String ACTION_LOAD_DEAL_FROM_DB = "load_deal_from_db";
        public static final String ACTION_ON_DEAL_DETAILS_LOADED = "on_deal_detals_loaded";
        public static final String ACTION_STORE_DEAL_TO_DB = "store_deal_to_db";
        public static final String ACTIVITY_ON_CREATE = "activity_on_create";
        public static final String ADVERTISING_ID_CATEGORY = "aid";
        public static final String ADVERTISING_ID_NST_STATUS = "status";
        public static final String ADVERTISING_ID_VALUE = "aidv";
        public static final String ANDROID_EVENT = "android_events";
        public static final String CATEGORY_DEAL_PERFORMANCE = "deal_performance";
        public static final String DATABASE = "databaseV2";
        public static final String DEAL_SIZE = "dealsize";
        public static final String ENABLE_WRITE_AHEAD_LOGGING = "enableWriteAheadLogging";
        public static final String FIRST_COUNTRY_SELECTION_ACTION = "first_country_selection";
        public static final String GEOCODE_FAILED = "geocode_failed";
        public static final String GPS_ACTION_FIRST_TIME_EXPERIENCE = "fte";
        public static final String GPS_EVENT_CATEGORY = "gps";
        public static final int GPS_FTE_ERROR = 0;
        public static final int GPS_FTE_SUCCESS = 1;
        public static final String GPS_LABEL_ERROR_ADDRESSES = "addr";
        public static final String GPS_LABEL_ERROR_COUNTRY = "cntry";
        public static final String GPS_LABEL_ERROR_LOCATION = "loc";
        public static final String LC_APPLICATION_CATEGORY = "application";
        public static final String LIST_LOADING_PERFORMANCE = "list_loading_performance";
        public static final String MAP_SETUP = "map_setup";
        public static final String PROCESS_CATEGORY = "process";
        public static final String PROCESS_STARTUP = "startup";
        public static final String WINDOW_DRAWN = "window_drawn";

        private GeneralEvent()
        {
        }
    }

    public static class Geofence
    {

        public static final String GEOFENCE_ENTERED = "Entered";
        public static final String GEOFENCE_EXITED = "Exited";
        public static final CharSequence GEOFENCE_ID_DELIMITER = ",";
        public static final String GEOFENCE_TRANSITION_UNKNOWN = "Unknown";
        public static final String LOG_LABEL_GEOFENCES_COUNT = "geofences_count";


        public Geofence()
        {
        }
    }

    public static class Gifting
    {

        public static final String EMAIL = "email";
        public static final String PRINT = "print";

        public Gifting()
        {
        }
    }

    public static class GlobalSearch
    {

        public static final String GLOBAL_SEARCH_CHANNEL_FILTER_GOODS = "goods";
        public static final String GLOBAL_SEARCH_CHANNEL_FILTER_LOCAL = "local";
        public static final String GLOBAL_SEARCH_CHANNEL_FILTER_TRAVEL = "travel";
        public static final String GLOBAL_SEARCH_QUERY_PARAM_FILTERS = "filters";
        public static final String GLOBAL_SEARCH_SORT_POPULARITY = "popularity";
        public static final int GLOBAL_SEARCH_SUGGESTIONS_LIMIT_VALUE = 5;
        public static final String GLOBAL_SEARCH_TOP_CATEGORY_FORMAT = "topcategory:%1$s";
        public static final String RELEVANCE_CONTEXT_MOBILE_ALL = "mobile_all";
        public static final String RELEVANCE_CONTEXT_MOBILE_SEARCH = "mobile_search";
        public static final String RELEVANCE_CONTEXT_MOBILE_SEARCH_INTL = "mobile_search_intl";

        public GlobalSearch()
        {
        }
    }

    public static class Http
    {

        public static final String ACCURACY = "accuracy";
        public static final String ACTION = "action";
        public static final String ACTIVITY = "activity";
        public static final String ADDRESS1 = "address1";
        public static final String ALL = "all";
        public static final String ANDCON_EXTRA = "andcon_extra";
        public static final String ANDROID = "android";
        public static final String API_AUTH_TOKEN = "api_auth_token";
        public static final String AREA = "area";
        public static final String AREA_ID = "area_id";
        public static final String AUTOLOCATE = "autolocate";
        public static final String BCOOKIE = "bcookie";
        public static final String BILLING_ID = "billingId";
        public static final String BILLING_RECORD_ADDRESS = "billing_record[address]";
        public static final String BILLING_RECORD_CARD_NUMBER = "billing_record[card_number]";
        public static final String BILLING_RECORD_CARD_TYPE = "billing_record[card_type]";
        public static final String BILLING_RECORD_CPF = "cpf";
        public static final String BILLING_RECORD_CVV = "billing_record[cvv]";
        public static final String BILLING_RECORD_CVV_PURCHASED_BEFORE = "billing_record_cvv";
        public static final String BILLING_RECORD_ELV_ACCOUNT_NUMBER = "billing_record[elv_account_number]";
        public static final String BILLING_RECORD_ELV_BANK_CODE = "billing_record[elv_blz]";
        public static final String BILLING_RECORD_EXPIRATION_MONTH = "billing_record[expiration_month]";
        public static final String BILLING_RECORD_EXPIRATION_YEAR = "billing_record[expiration_year]";
        public static final String BILLING_RECORD_FIRST_NAME = "billing_record[first_name]";
        public static final String BILLING_RECORD_ID = "billing_record_id";
        public static final String BILLING_RECORD_ID_EU = "billing_record[id]";
        public static final String BILLING_RECORD_ISSUER_NUMBER = "billing_record[issuer_number]";
        public static final String BILLING_RECORD_LAST_NAME = "billing_record[last_name]";
        public static final String BILLING_RECORD_POSTAL_CODE = "billing_record[postal_code]";
        public static final String BILLING_RECORD_SEPA_BIC = "billing_record[bic]";
        public static final String BILLING_RECORD_SEPA_IBAN = "billing_record[iban]";
        public static final String BILLING_RECORD_TYPE = "billing_record[type]";
        public static final String BILLING_RECORD_VALID_FROM_MONTH = "billing_record[valid_from_month]";
        public static final String BILLING_RECORD_VALID_FROM_YEAR = "billing_record[valid_from_year]";
        public static final String BILLING_RECORD_VALID_TO_MONTH = "billing_record[valid_to_month]";
        public static final String BILLING_RECORD_VALID_TO_YEAR = "billing_record[valid_to_year]";
        public static final String BOOKING_RESERVATION_ID = "booking_reservation_id";
        public static final String CANCEL_ORDER_FAILED = "Cancel Order request failed";
        public static final String CANCEL_ORDER_GET_DEAL_DETAILS_FAILED = "GET deal details for Cancel Order failed";
        public static final String CANCEL_ORDER_GET_ORDER_DETAILS_FAILED = "GET order details for Cancel Order failed";
        public static final String CANCEL_ORDER_GET_REQUEST_REASONS_FAILED = "GET request for Cancel Order Reasons failed";
        public static final String CARD_NUMBER = "card_number";
        public static final String CATEGORIES = "categories";
        public static final String CATEGORY = "category";
        public static final String CATEGORY_0 = "category0";
        public static final String CHANNEL_ID = "channel_id";
        public static final String CHECK_IN = "check_in";
        public static final String CHECK_OUT = "check_out";
        public static final String CITY = "city";
        public static final String CLIENT_EMAIL = "client_email";
        public static final String CLIENT_FIRST_NAME = "client_first_name";
        public static final String CLIENT_ID = "client_id";
        public static final String CLIENT_LAST_NAME = "client_last_name";
        public static final String CLIENT_VERSION = "client_version";
        public static final String CLIENT_VERSION_ID = "client_version_id";
        public static final String CODE = "code";
        public static final String CONSUMER_ID = "consumer_id";
        public static final String CONTEXT = "context";
        public static final String COUNTRY = "country";
        public static final String CREDIT_CARD = "creditcard";
        public static final String CUSTOM_FIELD_VALUE = "custom_field_value";
        public static final String CUSTOM_FIELD_VALUE_LATAM = "custom_field[%s]";
        public static final String CVV = "cvv";
        public static final String DATETIME = "datetime";
        public static final String DEALS_URL = "https:/deals";
        public static final String DEAL_ID = "deal_id";
        public static final String DEAL_IDS = "deal_ids";
        public static final String DEAL_OPTION_ID = "deal_option_id";
        public static final String DEAL_RECOMMENDATIONS = "deal_recommendations";
        public static final String DEFAULT = "default";
        public static final String DELETE = "DELETE";
        public static final String DEVICE_ID = "device_id";
        public static final String DIVISIONS = "divisions[]";
        public static final String DIVISION_ID = "division_id";
        public static final String EAGERLY_APPLY_REWARD_POINTS = "eagerly_apply_reward_points";
        public static final String EMAIL_ADDRESS = "email_address";
        public static final String END_DATE = "end_date";
        public static final String ERROR_504_GATEWAY_TIMEOUT = "504";
        public static final String ERROR_MESSAGE = "errorMessage";
        public static final String EVENT_NAME = "event_name";
        public static final String FACEBOOK_ACCESS_TOKEN = "facebook_access_token";
        public static final String FACETS = "facets";
        public static final String FACET_FILTERS = "facet_filters";
        public static final String FACET_GROUP_FILTERS = "facet_group_filters";
        public static final String FILTERS = "filters";
        public static final String FIRST_NAME = "first_name";
        public static final String FULL_NAME = "full_name";
        public static final String GEOFENCE_UUID = "geofenceUUID";
        public static final String GEO_SOURCE = "geo_source";
        public static final String GET = "GET";
        public static final String GETAWAYS_BOOKING_SEGMENT = "getaways_booking_segment";
        public static final String GIFT_CODE_ID = "gift_code_id";
        public static final String GIFT_CODE_TYPE = "gift_code_type";
        public static final String GIFT_DELIVERY_METHOD = "gift_delivery_method";
        public static final String GIFT_EMAIL_DELIVERY_TIME = "gift_email_delivery_time";
        public static final String GIFT_FROM_NAME = "gift_from_name";
        public static final String GIFT_MESSAGE = "gift_message";
        public static final String GIFT_RECIPIENT_EMAIL_ADDRESS = "gift_recipient_email_address";
        public static final String GIFT_TO_NAME = "gift_to_name";
        public static final String GIFT_WRAP = "gift_wrap";
        public static final String GLOBAL_SEARCH_QUERY = "query";
        public static final String GLOBAL_SEARCH_SORT = "sort";
        public static final String GLOBAL_SEARCH_SUGGESTIONS_LIMIT = "limit";
        public static final String GOODS_FACET = "goods";
        public static final String GOOGLE_WALLET_TYPE = "googlewallet";
        public static final String GPS_SEARCH = "gps-search";
        public static final String GRANT_TYPE = "grant_type";
        public static final String GROUPON_CODE = "groupon_code";
        public static final String HEIGHT_IN_PIXELS = "height_in_pixels";
        public static final String HIDE_HEADER = "hide_header";
        public static final String HTTPS_PROTOCOL = "https://";
        public static final String HTTPS_SCHEME = "https";
        public static final String HTTP_PROTOCOL = "http://";
        public static final String HTTP_SCHEME = "http";
        public static final String ID = "id";
        public static final String INCENTIVE_TICKET_TYPE = "incentive_ticket_type";
        public static final String INCLUDE_PURCHASED_GIFTS = "include_purchased_gifts";
        public static final String INCLUDE_TRAVEL_BOOKABLE_DEALS = "include_travel_bookable_deals";
        public static final String INSTALLMENTS = "installments";
        public static final String IN_STORE_OFFER = "instore_offer";
        public static final String IOVATION_BLACKBOX = "iovation_blackbox";
        public static final String IS_EDITABLE = "isEditable";
        public static final String IS_GIFT = "is_gift";
        public static final String JP_AU_EASY_PAY_TERM_URL_PATH = "http://%s/?jb=interface-aueasypay_result";
        public static final String JP_AU_SUCCESS_CODE = "2010";
        public static final String LANGUAGE = "lang";
        public static final String LAST_NAME = "last_name";
        public static final String LAT = "lat";
        public static final String LATAM_PAYMENT_DUMMY_URL = "dummy://paymentResult";
        public static final String LIMIT = "limit";
        public static final String LNG = "lng";
        public static final String LOCALE = "locale";
        public static final String LOCAL_FACET = "local";
        public static final String LOCATION_QUERY = "location-query";
        public static final String LOCATION_QUERY_SEARCH = "location-query-search";
        public static final String LOC_TIME = "loc_time";
        public static final String MAXGEOFENCES = "maxGeofences";
        public static final String MEGAMIND_PREVIEW = "megamind_preview";
        public static final String MERCHANT_ID = "merchant_id";
        public static final String MERCHANT_ID_SHORT = "mid";
        public static final String MERCHANT_SLUG = "merchant_slug";
        public static final String MERCHANT_TIPS_LIMIT = "merchantTipsLimit";
        public static final String METADATA = "metadata";
        public static final String MOBILE = "mobile";
        public static final String MOBILE_FEATURED_INTL = "mobile_featured_intl";
        public static final String MOBILE_GETAWAYS_INTL = "mobile_getaways_intl";
        public static final String MOBILE_GOODS = "mobile_goods";
        public static final String MOBILE_GOODS_INTL = "mobile_goods_intl";
        public static final String MOBILE_LOCAL = "mobile_local";
        public static final String MONTH = "month";
        public static final String MULTI_ITEM_GIFT_DETAILS_KEY = "gift0";
        public static final String MULTI_ITEM_SHIPPING_ADDRESS_KEY = "shippingAddress";
        public static final String NAME = "name";
        public static final String OCCASION = "occasion";
        public static final String OFFSET = "offset";
        public static final String ONLINE_OFFER = "online_offer";
        public static final String OPTION_ID = "option_id";
        public static final String ORDER = "order";
        public static final String ORDER_ID = "order_id";
        public static final String OTHER_COMMENTS = "other_comments";
        public static final String OTHER_DEALS = "other_deals";
        public static final String PAGE = "page";
        public static final String PASSWORD = "password";
        public static final String PER_PAGE = "per_page";
        public static final String PHONE_NUMBER = "phone_number";
        public static final String PIN = "pin";
        public static final String PLACE = "place";
        public static final String PLACE_ID = "placeId";
        public static final String POST = "POST";
        public static final String POSTAL_CODE = "postal_code";
        public static final String POST_PURCHASE = "post_purchase";
        public static final String PROMO_CODE = "promo_code";
        public static final String PUT = "PUT";
        public static final String QUANTITY = "quantity";
        public static final String QUERY = "query";
        public static final String RADIUS = "radius";
        public static final String REASON_ID = "resignation_reason_id";
        public static final String REDEEMED_BY_MERCHANT = "redeemed_by_merchant";
        public static final String REFERRAL_ID = "referral_id";
        public static final String REFERRER = "referrer";
        public static final String REFRESH_AUTO = "refresh-auto";
        public static final String REFRESH_RELOAD_ACTIVITY = "refresh-reload-activity";
        public static final String REFRESH_USER_INITIATED = "refresh-user-initiated";
        public static final String RELEVANCE_CONTEXT = "relevance_context";
        public static final String RELEVANCE_CONTEXT_MOBILE_PUSH = "mobile_push";
        public static final String RESPONSE_VERSION = "responseVersion";
        public static final String RES_URL = "resURL";
        public static final String SEARCH_ORIGIN = "search_origin";
        public static final String SECURE_3D_TERM_URL_PATH = "%s/users/%s/orders/%s/%s/completeByPost";
        public static final String SECURE_ASSETS = "secure_assets";
        public static final String SESSION_KEY = "_thepoint";
        public static final String SHIPPING_ADDRESS1 = "shipping_address1";
        public static final String SHIPPING_ADDRESS2 = "shipping_address2";
        public static final String SHIPPING_ADDRESSES = "shippingAddresses";
        public static final String SHIPPING_CITY = "shipping_city";
        public static final String SHIPPING_COUNTRY = "shipping_country";
        public static final String SHIPPING_COUNTRY_EU = "country";
        public static final String SHIPPING_DISTRICT_LATAM = "shipping_district";
        public static final String SHIPPING_LOCATION_ID_EU = "shipping_location_id";
        public static final String SHIPPING_NAME = "shipping_name";
        public static final String SHIPPING_POSTAL_CODE = "shipping_postal_code";
        public static final String SHIPPING_PREFECTURE_JAPAN = "shipping_pref";
        public static final String SHIPPING_PREFECTURE_JAPAN_ALT = "pref";
        public static final String SHIPPING_STATE = "shipping_state";
        public static final String SHIPPING_STATE_LATAM = "shipping_state";
        public static final String SHIPPING_STREET_TYPE_LATAM = "shipping_street_type";
        public static final String SHIPPING_TITLE_EU = "title";
        public static final String SHIPPING_TOWNSHIP_LATAM = "shipping_township";
        public static final String SHOW = "show";
        public static final String SHOW_AREAS = "show_areas";
        public static final String SHOW_CLOSE = "show_close";
        public static final String SHOW_FACETS = "show_facets";
        public static final String SHOW_VALUE_DELIMITER = ",";
        public static final String STANDARD = "standard";
        public static final String START_DATE = "start_date";
        public static final String STATE = "state";
        public static final String STATUS_CODE = "status_code";
        public static final int STATUS_CODE_ERROR = 900;
        public static final Object STOCK_ID = "stock_id";
        public static final String STREET_ADDRESS_1 = "street_address_1";
        public static final String STREET_NUMBER = "street_number";
        public static final String SUBSCRIBE_TO_NEWSLETTER = "subscribe_to_newsletter";
        public static final String SURVEY_ID = "surveyId";
        public static final String TERM_URL = "TermUrl";
        public static final String TEXT = "text";
        public static final String TICKET = "ticket";
        public static final String TIME = "time";
        public static final String TOPLEVEL = "toplevel";
        public static final String TRAVELER_FIRST_NAME = "traveler_first_name";
        public static final String TRAVELER_LAST_NAME = "traveler_last_name";
        public static final String TRUE = "true";
        public static final String TYPE = "type";
        public static final String UPDATE_COMMENTS = "update_comments";
        public static final String UPDATE_REASON = "update_reason";
        public static final String USERNAME = "username";
        public static final String USER_DASH_ID = "user-id";
        public static final String USER_DIVISION_ID = "user_division_id";
        public static final String USER_ID = "user_id";
        public static final String USE_CREDITS = "use_credits";
        public static final String VALIDATE_SHIPPING_ADDRESS = "validate_shipping_address";
        public static final String VALIDATION_CARD_NUMBER = "validation_card_number";
        public static final String VERSION_NUMBER = "version_number";
        public static final String VIEW = "view";
        public static final String VIEWED = "viewed";
        public static final String VISITOR_ID = "visitor_id";
        public static final String XDIM = "xdim";
        public static final String X_AUTH_TOKEN = "x-auth-token";
        public static final String X_COOKIES = "x-cookies";
        public static final String YEAR = "year";
        public static final String ZERO_DAY = "zero_day";
        public static final String ZIP = "zip";
        public static final List hiddenList = Collections.unmodifiableList(Arrays.asList(new String[] {
            "card_number", "billing_record[card_number]", "cvv", "billing_record[cvv]", "password", "client_id", "validation_card_number"
        }));


        private Http()
        {
        }
    }

    public static class ImageServiceAvailableImageSizes
    {

        public static final String EXTRA_LARGE = "t954x610.jpg";
        public static final String LARGE = "t440x300.jpg";

        public ImageServiceAvailableImageSizes()
        {
        }
    }

    public static class Inject
    {

        public static final String COLLECTIONS_STORE = "CollectionsService";
        public static final String CONFIG_CHANGE_PROVIDERS = "configChangeProviders";
        public static final String COOKIE_STORE = "okHttpCookieStore3";
        public static final String DEVICE_ID = "deviceId";
        public static final String DIVISIONS_STORE = "DivisionsService";
        public static final String DTF_DATE_TIME = "dtfDateTime";
        public static final String ENGLISH_GEOCODER = "ENGLISH_GEOCODER";
        public static final String FEATURED_CHANNEL = "FEATURED";
        public static final String FULL_DATE_TIME = "fullDateTime";
        public static final String GETAWAYS_CHANNEL = "GETAWAYS";
        public static final String GOODS_CHANNEL = "GOODS";
        public static final String HOTELS_CHANNEL = "HOTELS";
        public static final String LOCALIZED_STORE = "localizedStore";
        public static final String LOCAL_DATE = "localDate";
        public static final String LOCAL_LONG_DATE = "localLongDate";
        public static final String LOCAL_TIME = "localTime";
        public static final String MARKET_RATE_CHANNEL = "MARKET_RATE";
        public static final String NEARBY_CHANNEL = "NEARBY";
        public static final String OCCASIONS_CHANNEL = "OCCASIONS";
        public static final String PULLNOTIFICATION_CHANNEL = "PULLNOTIFICATION";
        public static final String REFERRER = "referrer";
        public static final String SEARCH_CHANNEL = "GLOBAL_SEARCH";
        public static final String SECURE_STORE = "loginStore";
        public static final String SHOPPING_CHANNEL = "SHOPPING";
        public static final String STATUS_STORE = "StatusService";
        public static final String SUPPORT_INFO_STORE = "SupportInfoService";
        public static final String TIME_LEFT_B = "timeLeftB";
        public static final String TIME_LEFT_C = "timeLeftC";
        public static final String USER_AGENT = "USER_AGENT";
        public static final String VERSION_CODE = "versionCode";
        public static final String VERSION_NAME = "versionName";
        public static final String WITHOUT_PROXY = "withoutProxy";
        public static final String ZONED_DATE_TIME = "zonedDateTime";

        private Inject()
        {
        }
    }

    public static class Intent
    {

        public static final String ACTION_DEAL_INFO = "dealInfo";
        public static final String ACTION_NEXT_DEAL_BACK = "nextDealBack";
        public static final String ACTION_NEXT_DEAL_FORWARD = "nextDealForward";
        public static final String ACTION_OPT_IN = "actionOptIn";
        public static final String ACTION_SHOW_CITY_SELECTOR = "actionShowCitySelector";
        public static final String ACTION_TRY_AGAIN = "tryAgain";
        public static final String ACTION_VIEW_NEARBY_DIVISION = "actionViewNearbyDivision";
        public static final String DEAL_INDEX = "dealIndex";
        public static final String NEARBY_DIVISION_JSON = "nearbyDivisionJson";

        private Intent()
        {
        }
    }

    public static class Json
    {

        public static final String AMEX = "amex";
        public static final String CHANNEL = "channel";
        public static final String CITY = "city";
        public static final String CLOSED = "closed";
        public static final String CREDITS_AVAILABLE = "creditsAvailable";
        public static final String DEAL_ID = "dealId";
        public static final String DISPLAY_BOUGHT = "quantity";
        public static final String DISPLAY_DISCOUNT = "discount";
        public static final String DISPLAY_PLATFORM_EXCLUSIVE = "platformExclusive";
        public static final String DISPLAY_TIMER = "timer";
        public static final String GOODS = "goods";
        public static final String GROUPON_REDEEMED = "redeemed";
        public static final String LAT = "lat";
        public static final String LNG = "lng";
        public static final String MARKETPLACE_DEAL = "marketplace_deal";
        public static final String MASTERCARD = "mc";
        public static final String NAME = "name";
        public static final String NOT_NULL_LINK = "not_null_link";
        public static final String ORDER = "order";
        public static final String PAYMENT_AMERICAN_EXPRESS = "american_express";
        public static final String PAYMENT_AU_EASY_PAY = "aueasypay";
        public static final String PAYMENT_CREDITCARD = "creditcard";
        public static final String PAYMENT_DINERS = "diners";
        public static final String PAYMENT_JCB = "jcb";
        public static final String SHIPPING = "shipping";
        public static final String SHIPPING_DISTRICT = "shipping_district";
        public static final String SHIPPING_POSTAL_CODE_JP = "shippingPostalCodeJP";
        public static final String SHIPPING_STATE = "shipping_state";
        public static final String SHIPPING_TITLE = "shippingTitle";
        public static final String SHIPPING_TITLE_CODE_MR = "m";
        public static final String STATE = "state";
        public static final String STOCK_VALUE = "stockValue";

        private Json()
        {
        }
    }

    public static class Json.Nonstandard
    {

        public static final String DEAL_OFFSET = "ns:DealOffset";
        public static final String DISTANCE_AWAY = "ns:distanceAway";
        public static final String WIDGET_OFFSET = "ns:widgetOffset";

        private Json.Nonstandard()
        {
        }
    }

    public static class Location
    {

        public static final List APAC_MIGRATE_COUNTRIES = Collections.unmodifiableList(Arrays.asList(new String[] {
            "my", "sg", "hk", "tw", "id", "in", "za", "jp"
        }));
        public static final List AS_API_COUNTRIES = Collections.unmodifiableList(Arrays.asList(new String[] {
            "sg", "au", "hk", "nz", "my"
        }));
        public static final List CL_API_COUNTRIES = Collections.unmodifiableList(Arrays.asList(new String[] {
            "mx", "cl", "co", "pe"
        }));
        public static final String DEFAULT_COUNTRY_CODE = "US";
        public static final List EU_API_COUNTRIES = Collections.unmodifiableList(Arrays.asList(new String[] {
            "br", "de", "fr", "gb", "uk", "es", "it", "ie", "nl", "be", 
            "pl", "za", "se", "fi", "no", "ca_eu", "at", "ch", "pt", "dk", 
            "ar", "il", "ae"
        }));
        public static final List IN_API_COUNTRIES = Collections.unmodifiableList(Arrays.asList(new String[] {
            "in"
        }));
        public static final List JP_API_COUNTRIES = Collections.unmodifiableList(Arrays.asList(new String[] {
            "jp"
        }));
        public static final String LAST_KNOWN_LAT = "lastKnownLat";
        public static final String LAST_KNOWN_LNG = "lastKnownLng";
        public static final List LUP1_API_COUNTRIES = Collections.unmodifiableList(Arrays.asList(new String[] {
            "uk", "fr", "es", "it", "de", "ie", "at", "pt", "dk", "no", 
            "se", "nl", "pl", "fi", "br", "za", "ca", "ch", "ar", "ae", 
            "be", "il", "au", "nz"
        }));
        public static final List RU_API_COUNTRIES = Collections.unmodifiableList(Arrays.asList(new String[] {
            "ru"
        }));
        public static final List US_API_COUNTRIES = Collections.unmodifiableList(Arrays.asList(new String[] {
            "us", "ca"
        }));


        private Location()
        {
        }
    }

    public static class Logging
    {

        public static final String EVENT_TRACKER_IMAGE_PATH = "logs/analytic/event.gif";
        public static final String LOGGING_ENDPOINT = "logging.groupon.com";
        public static final String VIEW_TRACKER_IMAGE_PATH = "logs/analytic/view.gif";

        public Logging()
        {
        }
    }

    public static class Logging.Search
    {

        public static final String TAB_ALL = "GPSearchTabAll";
        public static final String TAB_GETAWAYS = "GPSearchTabGetaways";
        public static final String TAB_GOODS = "GPSearchTabGoods";
        public static final String TAB_LOCAL = "GPSearchTabLocal";

        public Logging.Search()
        {
        }
    }

    public class MarketRateConstants
    {

        public static final int DEFAULT_FILTER_ADULTS = 2;
        public static final int DEFAULT_FILTER_CHILDREN = 0;
        public static final int MAXIMUM_NIGHTS = 14;
        public static final int MAX_ADULTS = 4;
        public static final int MAX_CHILDREN = 3;
        public static final int MAX_CHILD_AGE = 17;
        public static final int MINIMUM_NIGHTS = 1;
        public static final int MIN_CHILD_AGE = 0;
        public static final String REQUEST_DATE_FORMAT = "yyyy-MM-dd";
        final Constants this$0;

        public MarketRateConstants()
        {
            this$0 = Constants.this;
            super();
        }
    }

    public class MarketRateConstants.Endpoint
    {

        public static final String HOTELS = "/getaways/hotels/%s";
        public static final String HOTEL_CREATE_RESERVATION = "/getaways/systems/%s/hotel_reservations";
        public static final String HOTEL_IMAGES = "/getaways/hotels/%s/images";
        public static final String HOTEL_INVENTORY = "/getaways/hotels/%s/inventory";
        public static final String HOTEL_UPDATE_RESERVATION = "/getaways/systems/%s/hotel_reservations/%s";
        public static final String RESERVATION_DETAILS = "/getaways/systems/%s/users/%s/hotel_reservations/%s";
        public static final String SEARCH = "/getaways/systems/%s/search";
        final MarketRateConstants this$1;

        public MarketRateConstants.Endpoint()
        {
            this$1 = MarketRateConstants.this;
            super();
        }
    }

    public class MarketRateConstants.Extra
    {

        public static final String ADULTS = "adults";
        public static final String CHANNEL = "channel";
        public static final String CHANNEL_ID = "channel_id";
        public static final String CHECK_IN_DATE = "check_in_date";
        public static final String CHECK_OUT_DATE = "check_out_date";
        public static final String CHILDREN = "children";
        public static final String CHILDREN_AGES = "children_ages";
        public static final String DESTINATION_ID = "destination_id";
        public static final String DESTINATION_NAME = "destination_name";
        public static final String G_BUCKS = "g_bucks";
        public static final String G_BUCKS_DISCLAIMER = "g_bucks_disclaimer";
        public static final String HOTEL_IMAGE_URL = "hotel_image_url";
        public static final String HOTEL_INVENTORY = "hotel_inventory";
        public static final String HOTEL_LOCATION = "hotel_location";
        public static final String HOTEL_NAME = "hotel_name";
        public static final String HOTEL_TIMEZONE_IDENTIFIER = "hotel_timezone_identifier";
        public static final String ID = "id";
        public static final String MARKET_RATE_SEARCH_FLOW = "search_flow";
        public static final String ORDER_STILL_PROCESSING = "order_still_processing";
        public static final String PRODUCT_TYPE = "productType";
        public static final String RESERVATION_ID = "reservation_id";
        public static final String ROOM_TOKEN = "room_token";
        final MarketRateConstants this$1;

        public MarketRateConstants.Extra()
        {
            this$1 = MarketRateConstants.this;
            super();
        }
    }

    public class MarketRateConstants.Http
    {

        public static final String ADULTS = "adults";
        public static final String ALL_FIELDS = "*";
        public static final String BILLING_RECORD_ID = "billing_record_id";
        public static final String CHECK_IN = "check_in";
        public static final String CHECK_OUT = "check_out";
        public static final String CHILDREN = "children";
        public static final String DEAL = "DEAL";
        public static final String DESTINATION_ID = "destination_id";
        public static final String FIELDS_HOTEL = "fields[hotel]";
        public static final String HOTEL = "HOTEL";
        public static final String INCLUDE_MARKET_RATE = "include_market_rate";
        public static final String INVENTORY_TYPE = "inventory_type";
        public static final String LAST_MINUTE = "lastMinute";
        public static final String LAST_MINUTE_TYPE = "LASTMINUTE";
        public static final String LATITUDE = "latitude";
        public static final String LIMIT = "limit";
        public static final String LIMIT_VALUE = "10";
        public static final String LONGITUDE = "longitude";
        public static final String MARKET_RATE_DESTINATIONS_PREFIX = "prefix";
        public static final String ROOM_TOKEN = "room_token";
        public static final String SYSTEM_ID = "system_id";
        public static final String TRAVELER_FIRST_NAME = "traveler_first_name";
        public static final String TRAVELER_LAST_NAME = "traveler_last_name";
        public static final String USER_ID = "user_id";
        final MarketRateConstants this$1;

        public MarketRateConstants.Http()
        {
            this$1 = MarketRateConstants.this;
            super();
        }
    }

    public class MarketRateConstants.JsonFieldValue
    {

        public static final String CANCELED_REGEX = "cancell?ed";
        public static final String CONFIRMED = "confirmed";
        public static final String FAILED = "failed";
        public static final String PROCESSING = "processing";
        final MarketRateConstants this$1;

        public MarketRateConstants.JsonFieldValue()
        {
            this$1 = MarketRateConstants.this;
            super();
        }
    }

    public class MarketRateConstants.TrackingValues
    {

        public static final String CONFIRM_PURCHASE_CLICK = "confirm_purchase_click";
        public static final String CURRENT_LOCATION_HOTELS_CLICK = "current_location_hotels_click";
        public static final String GROUPON_BUCKS_BACK_CLICK = "groupon_bucks_back_click";
        public static final String GUEST_SELECTION_CLICK = "guest_selection_click";
        public static final String GUEST_SELECTION_DONE = "guest_selection_done";
        public static final String HOTEL_MAP_CAROUSEL_SWIPE_CLICK = "map_carousel_swipe_click";
        public static final String HOTEL_MAP_DEAL_ICON_CLICK = "map_deal_icon_click";
        public static final String HOTEL_MAP_LANDSCAPE_VIEW = "hotel_map_landscape_view";
        public static final String HOTEL_MAP_SHOW_FULL_MAP_CLICK = "show_full_map_click";
        public static final String HOTEL_MAP_SHOW_FULL_MAP_FLOATING_BUTTON_CLICK = "show_full_map_floating_button_click";
        public static final String HOTEL_MAP_SHOW_MINI_MAP_CLICK = "show_mini_map_click";
        public static final String HOTEL_MAP_VIEW = "hotel_map_view";
        public static final String SEARCH_BUTTON_CLICK = "search_button_click";
        public static final String SEARCH_ICON_CLICK = "search_icon_click";
        public static final String SELECT_ROOM_CLICK = "select_room_click";
        public static final String SPECIFIER = "market_rate";
        final MarketRateConstants this$1;

        public MarketRateConstants.TrackingValues()
        {
            this$1 = MarketRateConstants.this;
            super();
        }
    }

    public static class MerchantPages
    {

        public static final String AFFILIATE_LINK = "affiliateLink";
        public static final String BUSINESSES_SEARCH_URL = "https:/businesses/search";
        public static final String IN_PERSON = "inPerson";
        public static final String PRINTABLE = "printable";
        public static final String PROMO_CODE = "promoCode";

        public MerchantPages()
        {
        }
    }

    public static class Notification extends Service
    {

        public static final String ACTION_NOTIFICATION_OPENED = "com.groupon.NOTIFICATION_OPENED";
        public static final String ACTION_PUSH_NOTIFICATION_OPENED = "com.groupon.PUSH_NOTIFICATION_OPENED";
        public static final String ACTION_PUSH_RECEIVED = "com.google.android.c2dm.intent.RECEIVE";
        public static final String ACTION_REGISTER = "com.groupon.REGISTER";
        public static final String ACTION_UNSUBSCRIBE_PUSH = "com.groupon.UNSUBSCRIBE_PUSH";
        public static final String ACTION_UPLOAD_REG_ID = "com.groupon.UPLOAD_REG_ID";
        public static final String ALERT = "alert";
        public static final int DEAL_NOTIFICATION_ID;
        public static final String LOG_ACTION_CLEAR_SUBSCRIPTION_COMPLETED = "clear_subscription_completed";
        public static final String LOG_ACTION_ERROR_MESSAGE_TYPE = "message_send_error";
        public static final String LOG_ACTION_HTTP_EXCEPTION = "http_exception";
        public static final String LOG_ACTION_LOCATION_REFRESH_DURATION = "location_refresh_duration";
        public static final String LOG_ACTION_MESSAGE_DELETED = "message_deleted";
        public static final String LOG_ACTION_NOTIFICATION_DELIVER = "deliver";
        public static final String LOG_ACTION_NOTIFICATION_NOT_DELIVERED = "not_delivered";
        public static final String LOG_ACTION_NO_UPDATES = "no_updates";
        public static final String LOG_ACTION_REGISTRATION_COMPLETED = "registration_completed";
        public static final String LOG_ACTION_REGISTRATION_COMPLETED_WITHOUT_LOCATION = "registration_completed_without_location";
        public static final String LOG_ACTION_REGISTRATION_ERROR = "registration_error";
        public static final String LOG_CATEGORY = "notifications";
        public static final String LOG_CLICK_SPECIFIER = "view";
        public static final String LOG_CLICK_TYPE = "push_notification_alert";
        public static final String LOG_DEVICE_TOKEN_POST = "device_token_post";
        public static final String LOG_DEVICE_TOKEN_PUT = "device_token_put";
        public static final String LOG_FUNNEL_ID_PROXIMITY = "{\"pushType\" : \"proximity\"}";
        public static final String LOG_FUNNEL_ID_PULL = "{\"pushType\" : \"pull\"}";
        public static final String LOG_FUNNEL_ID_PUSH = "{\"pushType\" : \"GCM\"}";
        public static final String LOG_IMAGE_URI_REQUEST = "image_uri_request";
        public static final String LOG_LABEL_DEAL = "deal";
        public static final String LOG_LABEL_NON_DEAL = "non_deal";
        public static final String LOG_LABEL_NOTIFICATION_SERVICE = "n10n";
        public static final String LOG_LABEL_PUSH_NOTIFICATIONS_SERVICE = "push_n10n";
        public static final String LOG_MESSAGE_BLOCK_ERROR = "message_block_error";
        public static final String LOG_MISSING_MSG = "missing_msg";
        public static final String LOG_PUSH_NOTIFICATION_CATEGORY = "push_notifications";
        public static final String LOG_UNKNOWN_ERROR = "unknown";
        public static final String LOG_UPDATE_PUSH_SUBSCRIPTION = "update_push_subscription";
        public static final int NON_DEAL_NOTIFICATION_ID;
        public static final String NOTIFICATION_STRING = "notification";
        public static final String PUSH_CONTRACT_VERSION = "push_contract_version";
        public static final String PUSH_COUNTRY = "push_country";
        public static final String PUSH_DEVICE_ID = "device_id";
        public static final String PUSH_DIVISION = "push_division";
        public static final String PUSH_EVENT = "event";
        public static final String PUSH_EVENT_ACTIVATE = "activate";
        public static final String PUSH_EVENT_DEACTIVATE = "deactivate";
        public static final String PUSH_NOTIFICATION_ENABLED = "pushNotificationEnabled";
        public static final String PUSH_SUBSCRIPTION_ID = "pushSubscriptionID";
        public static final String PUSH_TOKEN = "token";
        public static final String REGISTRATION_EXPIRED = "com.google.android.c2dm.intent.REGISTRATION";
        public static final String REGISTRATION_ID = "registration_id";
        public static final int SUGGESTED_UPGRADE_AVAILABLE;
        public static final String USER_ID = "user_id";

        static 
        {
            DEAL_NOTIFICATION_ID = NotificationType.DEAL_NOTIFICATION.getId();
            SUGGESTED_UPGRADE_AVAILABLE = NotificationType.SOFTWARE_UPDATE_NOTIFICATION.getId();
            NON_DEAL_NOTIFICATION_ID = NotificationType.NON_DEAL_NOTIFICATION.getId();
        }

        private Notification()
        {
        }
    }

    public static final class Notification.NotificationType extends Enum
    {

        private static final Notification.NotificationType $VALUES[];
        public static final Notification.NotificationType DEAL_NOTIFICATION;
        public static final Notification.NotificationType LOCALIZED_MOBILE_APP_NOTIFICATION;
        public static final Notification.NotificationType NON_DEAL_NOTIFICATION;
        public static final Notification.NotificationType SOFTWARE_UPDATE_NOTIFICATION;
        private final int notificationId;

        public static Notification.NotificationType valueOf(String s)
        {
            return (Notification.NotificationType)Enum.valueOf(com/groupon/Constants$Notification$NotificationType, s);
        }

        public static Notification.NotificationType[] values()
        {
            return (Notification.NotificationType[])$VALUES.clone();
        }

        public int getId()
        {
            return notificationId;
        }

        static 
        {
            DEAL_NOTIFICATION = new Notification.NotificationType("DEAL_NOTIFICATION", 0, 1);
            NON_DEAL_NOTIFICATION = new Notification.NotificationType("NON_DEAL_NOTIFICATION", 1, 100);
            LOCALIZED_MOBILE_APP_NOTIFICATION = new Notification.NotificationType("LOCALIZED_MOBILE_APP_NOTIFICATION", 2, 3);
            SOFTWARE_UPDATE_NOTIFICATION = new Notification.NotificationType("SOFTWARE_UPDATE_NOTIFICATION", 3, 2);
            $VALUES = (new Notification.NotificationType[] {
                DEAL_NOTIFICATION, NON_DEAL_NOTIFICATION, LOCALIZED_MOBILE_APP_NOTIFICATION, SOFTWARE_UPDATE_NOTIFICATION
            });
        }

        private Notification.NotificationType(String s, int i, int j)
        {
            super(s, i);
            notificationId = j;
        }
    }

    public static class Preference
    {

        public static final String ACCESS_TOKEN = "accessToken";
        public static final String ACCESS_TOKEN_CONFIGURED = "accessTokenConfigured";
        public static final String ADD_PRECONFIGURED_VARIANT = "addPreconfiguredVariant";
        public static final String ADMIN_MENU_ENABLED = "adminMenuEnabled";
        public static final String ADVERTISING_ID = "advertisingId";
        public static final String ADVERTISING_ID_LAST_UPDATE = "advertisingIdLastUpdate";
        public static final String APP_LAUNCHED = "appLaunched";
        public static final String APP_STARTUP_COUNTER = "skipCounter";
        public static final String ATTRIBUTION_CID = "attributionCid";
        public static final String ATTRIBUTION_DEEPLINK_TIMESTAMP = "attributionDeepLinkTimestamp";
        public static final String ATTRIBUTION_DOWNLOAD_CID = "attributionDownloadCid";
        public static final String ATTRIBUTION_DOWNLOAD_ID = "attributionDownloadId";
        public static final String ATTRIBUTION_DOWNLOAD_URL = "attributionDownloadUrl";
        public static final String ATTRIBUTION_FIRST_LAUNCH_RECORDED = "attributionFirstLaunchRecorded";
        public static final String ATTRIBUTION_ID = "attributionId";
        public static final String ATTRIBUTION_LAST_APP_OPEN_TIMESTAMP = "attributionLastAppOpenTimestamp";
        public static final String ATTRIBUTION_TYPE = "attributionType";
        public static final String BASE_PAYMENT_URL_RU = "base_payment_url_ru";
        public static final String BASE_URL = "baseUrl";
        public static final String BASE_URL_AS = "base_url_as";
        public static final String BASE_URL_BOOKING_ENGINE = "base_url_booking_engine";
        public static final String BASE_URL_CL = "base_url_cl";
        public static final String BASE_URL_EU = "base_url_eu";
        public static final String BASE_URL_GDT = "base_url_gdt";
        public static final String BASE_URL_IN = "base_url_in";
        public static final String BASE_URL_JP = "base_url_jp";
        public static final String BASE_URL_MARKET_RATE = "base_url_market_rate";
        public static final String BASE_URL_RAPI = "baseRapiUrl";
        public static final String BASE_URL_RU = "base_url_ru";
        public static final String CATEGORIES_CONTAINER_VISIBILITY = "categoriesContainerVisibility";
        public static final String CATEGORY_FACET_GROUP_FILTERS = "categoryFacetGroupFilters";
        public static final String CATEGORY_ID = "categoryId";
        public static final String CATEGORY_MODE = "categoryMode";
        public static final String CATEGORY_NAME = "categoryName";
        public static final String CHECK_FOR_LEAKED_ACTIVITIES = "checkForLeakedActivities";
        public static final String CONSUMER_ID = "consumerId";
        public static final String COUNTRY_SELECTED = "countrySelected";
        public static final String CREDITS_AVAILABLE_AMOUNT = "amount";
        public static final String CREDITS_AVAILABLE_FORMATTED_AMOUNT = "formattedAmount";
        public static final String CURRENT_BILLING_RECORD_ID = "currentBillingRecordId";
        public static final String CUSTOM_FIELDS = "customFields";
        public static final String DEALTYPES = "dealTypes";
        public static final String DEAL_NOTIFICATION = "dealNotification";
        public static final String DEAL_TYPE_SUCCESS_TOOLTIP_COUNT = "dealTypeSuccessTooltipCount";
        public static final String DEBUG_LOGGING = "debugLogging";
        public static final String DEFAULT_PREFERENCE_FILE_NAME = "default";
        public static final String EAGERLY_APPLY_REWARD_POINTS = "eagerlyApplyRewardPoints";
        public static final String EMAIL = "email";
        public static final String EMAIL_PREFILL = "emailPrefill";
        public static final String ENABLE_POG_TEST_WEBVIEW = "enable_pog_test_webview";
        public static final String FACEBOOK_LOGIN_ENABLED = "facebookLoginEnabled";
        public static final String FIRST_NAME = "firstName";
        public static final String FIRST_TIME_USER = "first_time_user";
        public static final String FORCE_SHOW_ONBOARDING = "forceShowOnBoarding";
        public static final String FRESH_INSTALL = "freshInstall";
        public static final String FRESH_INSTALL_VERSION = "freshInstallVersion";
        public static final String G1_PUSH_TOKEN_UPLOADED = "g1PushTokenUploaded";
        public static final String GCM_APP_INFO = "gcmAppInfo";
        public static final String GCM_APP_VERSION = "gcmAppVersion";
        public static final String GCM_HAD_TOKEN = "gcmHadToken";
        public static final String GCM_REG_ID = "gcmRegId";
        public static final String GCM_TOKEN_UPLOADED = "gcmTokenUploaded";
        public static final String GCM_UPLOADED_TOKEN = "gcmUploadedToken";
        public static final String GENDER = "gender";
        public static final String GOOGLE_WALLET_SANDBOX_ENABLED = "googleWalletSandboxEnabled";
        public static final String HAS_LOGGED_IN_ATLEAST_ONCE = "hasLoggedInAtleastOnce";
        public static final String HAS_SEEN_COUPONS_INTRO_SCREEN = "hasSeenCouponsIntroScreen";
        public static final String HAS_SEEN_WIDGET_DIALOG = "hasSeenWidgetDialog";
        public static final String HIDE_PREVIOUSLY_SEEN_DEALS_FROM_NOTIFICATIONS = "hidePreviouslySeenDealsFromNotifications";
        public static final String INCLUDE_API_LOGS = "includeApiLogs";
        public static final String INSTALL_DATE = "InstallDate";
        public static final String IN_APP_MESSAGE_FORCE_UPDATE = "inAppMessageForceUpdate";
        public static final String IN_APP_MESSAGE_HISTORY = "inAppMessageHistory";
        public static final String IS_AUTO_REFUND_ENABLED = "isAutoRefundEnabled";
        public static final String IS_FEED_ENABLED = "isFeedEnabled";
        public static final String LAST_DEAL_SHORT_TITLE_NOTIFIED = "lastDealShortTitleNotified";
        public static final String LAST_NAME = "lastName";
        public static final String LAST_SUGGESTED_UPGRADE_ALERT_TIME = "lastSuggestedUpgradeAlertTime";
        public static final String LAST_VERSION = "lastVersion";
        public static final String LIMIT_AD_TRACKING = "limitAdTracking";
        public static final String LOCALIZED_MOBILE_APP_ENABLED_BY_USER = "localizedMobileApp";
        public static final String LOCALIZED_MOBILE_APP_NOTIFICATION_TIMER = "localiizedMobileAppNotificationTimer";
        public static final String LOCATION_CHANGED_INFO_JSON = "locationChangedInfoJson";
        public static final String LOCATION_CHANGED_IN_APP_MESSAGE_ID = "locationChangedInAppMessageId";
        public static final String LOCATION_CHANGED_NEEDS_TO_SHOW_DIALOG = "locationChangedNeedsToShowDialog";
        public static final String LOCATION_CHANGED_POSSIBLE_NEW_DIVISION = "locationChangedPossibleNewDivision";
        public static final String LOCATION_CHANGED_TIMER = "locationChangedTimer";
        public static final String LOGIN_SPLASH_TARGET = "skipTarget";
        public static final String NOTIFICATION_TIME = "notificationTime";
        public static final String NST_URL = "nst_url";
        public static final String ONBOARD_FACEBOOK = "onboardFacebook";
        public static final String OPT_IN_VIA_WIDGET = "optInViaWidget";
        public static final String PREFERRED_SHIPPING_ADDR1 = "preferredShippingAddr1";
        public static final String PREFERRED_SHIPPING_ADDR2 = "preferredShippingAddr2";
        public static final String PREFERRED_SHIPPING_CITY = "preferredShippingCity";
        public static final String PREFERRED_SHIPPING_COUNTRY = "preferredShippingCountry";
        public static final String PREFERRED_SHIPPING_LOCATION_ID = "preferredShippingLocationId";
        public static final String PREFERRED_SHIPPING_NAME = "preferredShippingName";
        public static final String PREFERRED_SHIPPING_POSTAL_CODE = "preferredShippingPostalCode";
        public static final String PREFERRED_SHIPPING_STATE = "preferredShippingState";
        public static final String PREFILLED_ZIPCODE = "prefilledZipcode";
        public static final String PREF_KEY_ADVANCED = "pref_key_advanced";
        public static final String PREF_KEY_CORE_SERVICES_TIMESTAMP = "coreServicesTimestamp";
        public static final String PREF_KEY_DIVISION_SERVICE = "DivisionsService";
        public static final String PREF_KEY_DIVISION_SERVICE_V2 = "DivisionServiceV2";
        public static final String PREF_KEY_GENERAL = "pref_key_general";
        public static final String PREF_KEY_REPORT_A_BUG = "pref_key_report_a_bug";
        public static final String PREF_KEY_SETTINGS_SCREEN_ROOT = "pref_screen_root";
        public static final String PRIMARY_EMAIL_ADDRESS = "primaryEmailAddress";
        public static final String PROXIMITY_ACTIVITY_POLL_TIME = "proximityActivityPollTime";
        public static final String PROXIMITY_ENDPOINT_MUTE_UNTIL = "proximityEndpointMuteUntil";
        public static final String PROXIMITY_ENDPOINT_MUTE_UNTIL_IN_LONG = "proximityEndpointMuteUntilInLong";
        public static final String PROXIMITY_GEOFENCE_SET_TIME = "proximityGeofenceSetTime";
        public static final String PROXIMITY_LOCATION_INFO_JSON = "proximityLocationInfoJson";
        public static final String PROXIMITY_NOTIFICATION_ENABLED_BY_USER = "proximityNotificationEnabled";
        public static final String PROXIMITY_NOTIFICATION_SEEN_BY_USER = "proximityNotificationSeenByUser";
        public static final String PROXY_CLIENT_HEADER = "Odo-Client-UUID";
        public static final String PROXY_CLIENT_UUID = "proxyClientUUID";
        public static final String PROXY_IP = "proxyIp";
        public static final String PROXY_PORT = "proxyPort";
        public static final String PULL_NOTIFICATION_DOWNLOADED = "pullNotificationDownloaded";
        public static final String RECENTLY_SEARCHED_TERMS = "recentlySearchedTerms_";
        public static final String RECENTLY_SEARCHED_TERMS_CATEGORIES = "recentlySearchedTermsCategories_";
        public static final String RECENTLY_SEARCHED_TERMS_COUNT = "recentlySearchedTermsCount";
        public static final String REFERRAL_CODE = "referralCode";
        public static final String REPORT_A_BUG_EMAIL = "reportABugEmail";
        public static final String SELECTED_SHIPPING_ADDRESS = "selectedShippingAddress";
        public static final String SHIPPING_INFO_INVALID = "shippingInfoInvalid";
        public static final String SHOW_ACTIVITY_REFRESH_MENU_ITEM = "showActivityRefreshMenuItem";
        public static final String SHOW_ONBOARDING = "showOnBoarding";
        public static final String SHOW_TRACKING_INFO = "showTrackingInfo";
        public static final String SILENT_NOTIFICATIONS = "silentNotifications";
        public static final String SUBCATEGORY_ID = "subcategoryId";
        public static final String USER_ID = "userId";
        public static final String VALID_BILLING_RECORD_COUNT_AT_LOGIN = "billingRecordCountAtLogin";
        public static final String VIEW_LOGS = "viewLogs";
        public static final String WEB_BASE_URL_GDT = "web_base_url_gdt";
        public static final String WIDGET_DATETIME = "widgetDatetime";
        public static final String WIDGET_HAS_BEEN_INSTALLED = "widgetHasBeenInstalled";
        public static final String WIDGET_PREVIEW = "widgetPreview";
        public static final String WIDGET_PREVIEW_FALSE = "false";
        public static final String WIDGET_PREVIEW_TRUE = "true";
        public static final String WIDGET_PREVIEW_UNDEFINED = "";
        public static final String WIDGET_TYPE = "widgetType";
        public static final String WIDGET_TYPE_DEFAULT = "default";
        public static final String WIDGET_TYPE_GOODS = "goods";
        public static final String WIDGET_TYPE_NONE = "none";
        public static final String WIDGET_TYPE_SMALL_DEAL_CARD_LIST = "smallDealCardList";
        public static final String ZIP_CODE = "zip_code";

        private Preference()
        {
        }
    }

    public static class ProximityNotifications
    {

        public static final String ACTION_CLEAR_GEOFENCE_ON_ABTEST_CHANGE = "com.groupon.CLEAR_GEOFENCE_ABTEST_CHANGE";
        public static final String ACTION_DISTANCE_ACTIVITY_CHECK = "com.groupon.DISTANCE_ACTIVITY_CHECK";
        public static final String ACTION_GEOFENCE_TRIGGERED = "com.groupon.GEOFENCE_TRIGGERED";
        public static final String ACTION_SET_GEOFENCE = "com.groupon.SET_GEOFENCE";
        public static final String ACTIVITY_CONFIDENCE = "activity_confidence";
        public static final String ACTIVITY_NAME = "activity_name";
        public static final String LOG_ACTION_API_CALL_EXCEPTION = "api_call_exception";
        public static final String LOG_ACTION_PARSING_TIME_EXCEPTION = "parsing_time_exception";
        public static final String LOG_ACTION_RECEIVE_GEOFENCE = "receive_geofences";
        public static final String LOG_ACTION_SET_GEOFENCE = "set_geofences";
        public static final String LOG_ACTION_SET_MUTE_UNTIL = "set_mute_until";
        public static final String LOG_ACTION_START_SERVICE = "start_service";
        public static final String LOG_ACTION_SUPPRESS = "suppress";
        public static final String LOG_ACTION_TRIGGER_NO_API = "trigger_no_api_call";
        public static final String LOG_ACTION_TRIGGER_NO_API_INVALID_ACTIVITY = "no_api_call_invalid_activity";
        public static final String LOG_ACTION_TRIGGER_NO_API_NO_CONFIDENCE = "no_api_call_no_confidence";
        public static final String LOG_ACTION_USER_PREF = "user_pref";
        public static final String LOG_CATEGORY_PROXIMITY_NOTIFICATION = "proximity_notification";
        public static final String LOG_LABEL_ACTIVITY_FOUND = "activity_found";
        public static final String LOG_LABEL_DISTANCE_ACTIVITY_CHECK = "distance_activity_check";
        public static final String LOG_LABEL_DISTANCE_CHECK_FAILED = "distance_check_failed";
        public static final String LOG_LABEL_EXCEPTION = "set_geofence_exception";
        public static final String LOG_LABEL_GEOFENCE_TRANSITION = "geofence_transition";
        public static final String LOG_LABEL_NO_LOCATION = "no_location_found";
        public static final String LOG_LABEL_USER_DISABLED = "user_disabled";
        public static final String LOG_LABEL_USER_ENABLED = "user_enabled";
        public static final double MAX_DISTANCE_VALUE = 2D;
        public static final int MAX_GEOFENCES = 10;
        public static final int THRESHOLD_ACTIVITY_CONFIDENCE_VALUE = 50;
        public static final int THRESHOLD_ACTIVITY_POLL_TIME = 10000;
        public static final int THRESHOLD_GEOFENCE_HIT_TIME = 10000;
        public static final String TRANSITION_GEOFENCE_UUID = "transition_geofence_uuid";
        public static final String TRANSITION_TYPE = "transition_type";

        public ProximityNotifications()
        {
        }
    }

    public static class PullNotificationService extends Service
    {

        public static final String LOG_LABEL_NO_LOCATION_SET = "no_location_set";

        public PullNotificationService()
        {
        }
    }

    public static class RegularExpressions
    {

        public static final Pattern EMAIL_ADDRESS = Pattern.compile("[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}\\@[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}(\\.[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25})+");


        private RegularExpressions()
        {
        }
    }

    public static class ReportABug
    {

        public static final String DATA = "data";
        public static final int MAX_PAYLOAD = 0xf4240;
        public static final String TITLE = "title";

        public ReportABug()
        {
        }
    }

    public static class ServerErrorMessages
    {

        public static final String ORDERS_API_CREDIT_CARD_VALIDATION_FAILED_MESSAGE = "unknown shipping address, billing record validation failed";
        public static final String ORDERS_API_CREDIT_CARD_VALIDATION_REQUIRED_MESSAGE = "unknown shipping address, billing record validation required";

        public ServerErrorMessages()
        {
        }
    }

    public static class Service
    {

        public static final int DELAY_SERVICES_FOR_STARTUP_IN_MS = 3000;
        public static final String LOG_ACTION_PROGRESS = "progress";
        public static final String LOG_ACTION_SERVICE_START = "service_start";
        public static final String LOG_ACTION_SUCCESS = "success";
        public static final String LOG_ACTION_SUPPRESS = "suppress";
        public static final String LOG_DEAL_TIMESTAMP = "deal_timestamp";
        public static final String LOG_LABEL_EMPTY = "";

        public Service()
        {
        }
    }

    public static class ShortURL
    {

        public static final String FORMAT_JSON = "json";
        public static final String PARAM_API_KEY = "apiKey";
        public static final String PARAM_FORMAT = "format";
        public static final String PARAM_LOGIN = "login";
        public static final String PARAM_LONG_URL = "longUrl";
        public static final String SHORTEN_SERVICE_URL = "http://api.bitly.com/v3/shorten";
        public static final String SHORTURL_ACTION = "url_shortening";
        public static final String SHORTURL_CATEGORY = "short_url";
        public static final String SHORTURL_LABEL = "exception";

        public ShortURL()
        {
        }
    }

    public static class Slot
    {

        public static final String MIDDLE_SLOT = "middleSlot";
        public static final String TOP_SLOT = "topSlot";

        private Slot()
        {
        }
    }

    public static class Startup
    {

        public static final String ACTIVITY_DURATION = "activityDuration";
        public static final String CAROUSEL = "carousel";
        public static final String FEATURED = "featured";
        public static final String IMAGES = "images";
        public static final String ON_CREATE = "onCreate";
        public static final String PLAY_SERVICE_CHECK = "playServiceCheck";
        public static final String PLAY_SERVICE_CHECK_CATEGORY = "play_service_check";
        public static final String PLAY_SERVICE_ERROR = "play_service_error";
        public static final String SPLASH = "splash";
        public static final String STARTUP_CATEGORY = "startup";
        public static final String STARTUP_SERVICES = "startupServices";
        public static final String VIEW_DISPLAYED = "viewDisplayed";

        public Startup()
        {
        }
    }

    public static class TrackingValues
    {

        public static final String ABOUT_GROUPON_CLICK = "about_groupon_click";
        public static final String ACTION_BACK = "back";
        public static final String ADD_PAYMENT_METHOD_CLICK = "add_payment_method_click";
        public static final String ALL_CATEGORIES = "all_categories";
        public static final String AUTOCOMPLETE_SELECTION_CLICK = "autocomplete_selection_click";
        public static final String BACK_APPOINTMENT = "back_appointment";
        public static final String BACK_CLICK_TYPE = "back_arrow_click";
        public static final String BELL_ICON_CLICK = "bell_icon_click";
        public static final String BOOKING_DEAL = "bookingDeal";
        public static final String BOOK_LATER_CLICK = "book_later_click";
        public static final String BOOK_NOW_CLICK = "book_now_click";
        public static final String BOTTOM_CENTER = "bottom_center";
        public static final String BUY_BUTTON_STATUS_AVAILABLE = "available";
        public static final String BUY_BUTTON_STATUS_EXPIRED = "expired";
        public static final String BUY_BUTTON_STATUS_IMPRESSION_TYPE = "buy_button_status";
        public static final String BUY_BUTTON_STATUS_SOLD_OUT = "sold_out";
        public static final String BUY_NOW_CLICK = "buy_now_click";
        public static final String BUY_WITH_GOOGLE = "buy_with_google";
        public static final String BUY_WITH_GOOGLE_CLICK = "buy_with_google_click";
        public static final String BUY_WITH_GOOGLE_PLACEMENT_BOTTOM = "bottom";
        public static final String CANCEL = "cancel";
        public static final String CANCEL_CC_INFO = "cancel_cc_info";
        public static final String CANCEL_SHIPPING_ADDRESS_CLICK = "cancel_shipping_address_click";
        public static final String CARD_SCAN_CLICK = "card_scan_click";
        public static final String CATEGORY_EXPANSION_CLICK = "category_expansion_click";
        public static final String CATEGORY_SELECTION_X_CLICK = "category_selection_x_click";
        public static final String CC_BILLING_ADDRESS = "cc_billing_address";
        public static final String CHECKOUT = "checkout";
        public static final String CLICK_BUY = "click_buy";
        public static final String CLICK_SKIP = "click_skip";
        public static final String CLOSED = "closed";
        public static final String CONFIRM_LOCATION_SWITCH_CLICK = "localization_switch_accepted";
        public static final String CONFIRM_PURCHASE_BUTTON = "confirm_purchase_button";
        public static final String CONFIRM_PURCHASE_SPECIFIER = "confirm_purhcase";
        public static final String COUPON_CLICK = "coupon_click";
        public static final String COUPON_INSTORE_CLICK = "coupon_instore_click";
        public static final String COUPON_INSTORE_VIEW = "coupon_instore_view";
        public static final String COUPON_LANDING = "coupon_landing";
        public static final String COUPON_ONLINE_CLICK = "coupon_online_click";
        public static final String COUPON_ONLINE_VIEW = "coupon_online_view";
        public static final String COUPON_SEE_ALL_CATEGORY_CLICK = "coupon_see_all_category_click";
        public static final String CREDIT_CARD_MANUAL_CLICK = "credit_card_manual_click";
        public static final String CUSTOMER_SUPPORT_CLICK = "customer_support_click";
        public static final String DD_RECOMMENDATION_SEE_ALL = "dd_recommendation_see_all";
        public static final String DD_UGC_RECOMMENDATION = "dd_ugc_recommendation";
        public static final String DEALS_LIST = "Deals_list\u200B";
        public static final String DEAL_CLICK = "deal_click";
        public static final String DEAL_DETAIL_SPECIFIER = "deal_details";
        public static final String DEAL_IMAGE = "deal_image";
        public static final String DEAL_IMAGE_DEAL_DETAILS_SPECIFICER = "deal_details";
        public static final String DEAL_IMAGE_IMAGE_CAROUSEL_SPECIFICER = "image_carousel";
        public static final String DEAL_LIST_SPECIFIER = "deal_list";
        public static final String DEAL_OPTION_CLICK = "deal_option_click";
        public static final String DELIVERY_TAKEOUT = "delivery & takeout";
        public static final String DID_NOT_ASK = "did_not_ask";
        public static final String DIRECTIONS_CLICK = "directions_click";
        public static final String DONE_CLICK = "done_click";
        public static final String EDIT_CITY = "edit_city";
        public static final String EDIT_STATE = "edit_state";
        public static final String EMAIL_NOW_CLICK = "email_now_click";
        public static final String EMAIL_SPECIAL_CLICK = "email_special_click";
        public static final String END_OF_DEAL_DETAILS = "end_of_deal_details";
        public static final String ENTER_PROMO_CODE = "enter_promo_code";
        public static final String FACEBOOK = "fb";
        public static final String FACEBOOK_SIGN_IN_CLICK = "facebook_signin_click";
        public static final String FACEBOOK_SIGN_UP_CLICK = "facebook_signup_click";
        public static final String FAVORITE_DEAL_TYPES_CLICK = "favorite_deal_types_click";
        public static final String FORGOT_PASSWORD_CLICK = "forgot_password_click";
        public static final String FREEBIES_IMPRESSION = "freebies_impression";
        public static final String FREEBIES_NO_RESULTS = "freebies_no_results";
        public static final String GDT_FLAG_OFF = "off";
        public static final String GDT_FLAG_ON = "on";
        public static final String GETAWAYS_DEAL = "getawaysDeal";
        public static final String GET_CODE_CLICK = "get_code_click";
        public static final String GLOBAL_SEARCH = "global_search";
        public static final String GOODS_CONNECTED_MARKETPLACE = "goods_connected_marketplace";
        public static final String GOODS_MULTI_IMAGE_OPTION_CLICK = "select_multioption";
        public static final String GOODS_MULTI_IMAGE_OPTION_SPECIFIER = "goods_multioption";
        public static final String GOODS_MULTI_IMAGE_STARTUP_CLICK = "user_interaction_multioption_2_traits";
        public static final String GOODS_MULTI_IMAGE_STARTUP_SPECIFIER = "goods_multioption_2_tier";
        public static final String GOOGLE_WALLET_CANCEL = "google_wallet_cancel";
        public static final String GOOGLE_WALLET_CONTINUE = "google_wallet_continue";
        public static final String GOOGLE_WALLET_DIALOG = "google_wallet_dialog";
        public static final String GOOGLE_WALLET_FUTURE_USE_FLAG = "google_wallet_future_use_flag";
        public static final String GOOGLE_WALLET_FUTURE_USE_NO = "no";
        public static final String GOOGLE_WALLET_FUTURE_USE_YES = "yes";
        public static final String GOOGLE_WALLET_OPTION = "google_wallet_option";
        public static final String GOOGLE_WALLET_ORDER_FIELD_CARD = "card";
        public static final String GOOGLE_WALLET_SELECTION = "google_wallet_selection";
        public static final String GROUPON_LIST_PAGE = "groupon_list_page";
        public static final String GTG = "GTG";
        public static final String GTG_MY_GROUPONS_PLACEMENT_HEADER = "header";
        public static final String GTG_ON_FEATURED_CLICK = "gtg_on_featured_click";
        public static final String GTG_ON_FEATURED_IMPRESSION = "gtg_on_featured_imp";
        public static final String GTG_ON_NEARBY_CLICK = "gtg_on_nearby_click";
        public static final String HAMBURGER_BUTTON_CLICK = "hamburger_button_click";
        public static final String HEADER = "header";
        public static final String IMPRESSION_CLICK = "impression_click";
        public static final String IMPRESSION_TYPE_DEAL = "deal";
        public static final String IMPRESSION_TYPE_HOTEL = "hotel";
        public static final String INCENTIVE_TICKET = "incentive_ticket";
        public static final String INCENTIVE_TICKET_PROFILE = "incentive_ticket_profile";
        public static final String INCENTIVE_TICKET_SELECTION = "incentive_ticket_selection";
        public static final String INCENTIVE_TICKET_SELECT_OPTION_CLICK = "incentive_ticket_select_option_click";
        public static final String INVALID_BREAKDOWNS_PAYMENT_METHOD = "invalid_breakdowns_payment_method";
        public static final String IN_APP_MESSAGE = "in_app_message";
        public static final String LOCALIZED_MOBILE_APP_NST_INAPP_FUNNEL_ID = "localization_switch_confirm";
        public static final String LOCALIZED_MOBILE_APP_NST_SPECIFIER = "localization";
        public static final String LOCATION_BOX_CLICK = "location_box_click";
        public static final String LOGIN_PAGE = "login_page";
        public static final String LOG_IN_SIGN_UP = "login/signup";
        public static final String LOLLIPOP_TOOLBAR = "lollipop_toolbar";
        public static final String MAP = "map";
        public static final String MAP_CLICK = "map_click";
        public static final String MAP_LIST_VIEW_CLICK = "map_list_view_click";
        public static final String MAP_TOOL_BAR = "Map\u200B";
        public static final String MARKETPLACE_SECTION_COLLAPSE = "marketplace_section_collapse";
        public static final String MARKETPLACE_SECTION_EXPAND = "marketplace_section_expand";
        public static final String MATCHING_STORES = "matching_stores";
        public static final String MERCHANT = "merchant";
        public static final String MERCHANT_IMPRESSION_CLICK = "merchant_impression_click";
        public static final String MERCHANT_OFFERS_PAGE = "merchant_offers_page";
        public static final String MERCHANT_SPECIALS_PAGE = "merchant_specials_page";
        public static final String MERCHANT_SPECIALS_SAVED_PAGE = "merchant_specials_saved_page";
        public static final String MERCHANT_TIPS_PAGE = "merchant_tips_page";
        public static final String MINIMUM_INCENTIVE_PURCHASE_ERROR = "minimum_incentive_purchase_error";
        public static final String MOBILE_ONLY_DEAL = "mobile_only_deal";
        public static final String MOVE_MAP = "move_map\u200B";
        public static final String MP_ADDRESS = "mp_address";
        public static final String MP_ADDRESS_CLICK = "mp_address_click";
        public static final String MP_HEADER = "mp_header";
        public static final String MP_MAP = "mp_map";
        public static final String MP_MAP_CLICK = "mp_map_click";
        public static final String MP_OFFERS_SEE_ALL = "mp_offers_see_all";
        public static final String MP_PHONE = "mp_phone";
        public static final String MP_PHONE_CLICK = "mp_phone_click";
        public static final String MP_RAD = "mp_rad";
        public static final String MP_SPECIAL = "mp_special";
        public static final String MP_TIPS_SEE_ALL = "mp_tips_see_all";
        public static final String MP_UGC = "mp_ugc";
        public static final String MP_UGC_HOURS = "mp_ugc_hours";
        public static final String MP_UGC_RATING = "mp_ugc_rating";
        public static final String MP_UGC_RATING_DOWN = "mp_ugc_rating_down";
        public static final String MP_UGC_RATING_UP = "mp_ugc_rating_up";
        public static final String MP_UGC_TIPS = "mp_ugc_tips";
        public static final String MP_WEBSITE = "mp_website";
        public static final String MP_WEBSITE_CLICK = "mp_website_click";
        public static final String MY_GROUPONS = "mygroupons";
        public static final String MY_GROUPONS_CARD = "mygroupons_card";
        public static final String MY_GROUPONS_CLICK = "my_groupons_click";
        public static final String MY_GROUPONS_MY_FOOD = "mygroupons_myfood";
        public static final String MY_GROUPONS_MY_FOOD_CLICK = "mygroupons_myfood_click";
        public static final String MY_GROUPON_AVAILABLE_TAB = "mygroupon_available_tab";
        public static final String MY_SUBSCRIPTIONS_CLICK = "my_subscriptions_click";
        public static final String NAVIGATION_DRAWER_SPECIFIER = "navigation_drawer";
        public static final String NAVIGATION_DRAWER_SWIPE_OPEN = "swipe_open";
        public static final String NEARBY = "nearby";
        public static final String NEARBY_MAP = "nearby_map";
        public static final String NEARBY_STORES = "nearby_stores";
        public static final String NEARBY_STORES_CLICK = "nearby_stores_click";
        public static final String NEARBY_TAB = "nearby_tab";
        public static final String NEWSLETTER_OPT_CHECK = "newsletter_opt_check";
        public static final String OFFER_SCREEN_DEAL_CLICK = "offer_screen_deal_click";
        public static final String OFFER_SCREEN_SPECIAL = "offer_screen_special";
        public static final String OFFER_SCREEN_SPECIAL_CLICK = "offer_screen_special_click";
        public static final String ONBOARDING_COMPLETE = "onboarding_complete";
        public static final String ONBOARDING_CONTINUE_BUTTON_CLICK = "zipcode_continue_button_click";
        public static final String ONBOARDING_FLOW = "onboarding_flow";
        public static final String OPEN = "open";
        public static final String ORDER_FOOD_GDT = "order_food_gdt";
        public static final String ORGANIC = "organic";
        public static final String PAYMENT_METHODS_CLICK = "payment_methods_click";
        public static final String PHONE_NUMBER_CLICK = "phone_number_click";
        public static final String PINCH_TO_ZOOM = "pinch_to_zoom";
        public static final String POG_AUTOCOMPLETE_SELECTION_CLICK = "pog_autocomplete_selection_click";
        public static final String POG_LOCATION_BOX_CLICK = "pog_location_box_click";
        public static final String POG_LOCATION_SELECTION_CLICK = "pog_location_selection_click";
        public static final String POG_MODAL_ONE = "pog_modal_one";
        public static final String POG_MODAL_ONE_CLOSE = "pog_modal_one_close";
        public static final String POG_MODAL_ONE_OK = "pog_modal_one_ok";
        public static final String POG_MODAL_TWO = "pog_modal_two";
        public static final String POG_MODAL_TWO_CLOSE = "pog_modal_two_close";
        public static final String POG_MODAL_TWO_OK = "pog_modal_two_ok";
        public static final String POG_POPULAR_NEARBY_SELECTION_CLICK = "pog_popular_nearby_selection_click";
        public static final String POG_SEARCH_ICON_CLICK = "pog_search_icon_click";
        public static final String POPULAR_SEARCH_CLICK = "popular_category_click";
        public static final String POST_PURCHASE_BOOKING_PAGE = "post_purchase_booking_page";
        public static final String PRINT_LATER_CLICK = "print_later_click";
        public static final String PURCHASE = "purchase";
        public static final String PURCHASE_FLOW = "purchase_flow";
        public static final String RAD_CLICK = "rad_click";
        public static final String RECENT_SEARCH_CLICK = "recent_search_click";
        public static final String REDEEM_VOUCHER_CANCEL_CLICK = "redeem_voucher_cancel";
        public static final String REDEEM_VOUCHER_CLICK = "redeem_voucher";
        public static final String REDEEM_VOUCHER_CONFIRM_CLICK = "redeem_voucher_confirm";
        public static final String REDO_SEARCH_AREA_CLICK = "redo_search_area_click";
        public static final String REDO_SEARCH_AREA_IMP = "redo_search_area_imp";
        public static final String REDO_SEARCH_LIST_CLICK_JSON = "{Page:Deals_list}\u200B";
        public static final String REDO_SEARCH_MAP_CLICK_JSON = "{Page:Map}\u200B";
        public static final String REENTER_CC_CANCEL_CLICK = "reenter_cc_cancel_click";
        public static final String REENTER_CC_CONFIRM_CLICK = "reenter_cc_confirm_click";
        public static final String REQUEST_APPOINTMENT_CLICK = "request_appointment_click";
        public static final String SAVE_CC_INFO = "save_cc_info";
        public static final String SAVE_SHIPPING_ADDRESS_CLICK = "save_shipping_address_click";
        public static final String SAVE_SPECIAL_CLICK = "save_special_click";
        public static final String SEARCH = "search";
        public static final String SEARCH_BUTTON_CLICK = "search_button_click";
        public static final String SEARCH_ICON_CLICK = "search_icon_click";
        public static final String SEARCH_RESULT_CLICK = "search_result_click";
        public static final String SEARCH_STORE_CLICK = "search_store_click";
        public static final String SEARCH_SUGGESTION_SELECTION_CLICK = "suggestion_selection_click";
        public static final String SEE_ALL_CLICK = "see_all_click";
        public static final String SEND_AS_GIFT = "send_as_gift";
        public static final String SEND_AS_GIFT_PAGE = "send_as_gift_page";
        public static final String SETTINGS_CLICK = "settings_click";
        public static final String SHARE_MEDIUM_CLICK = "share_medium_click";
        public static final String SHARE_MERCHANT = "share_merchant";
        public static final String SHARE_SPECIAL = "share_special";
        public static final String SHIPPING_ADDRESS = "shipping_address";
        public static final String SHOW_VOUCHER_CLICK = "show_voucher_click";
        public static final String SIGNOUT_BUTTON_CLICK = "signout_button_click";
        public static final String SIGN_IN_CLICK = "signin_click";
        public static final String SIGN_UP_CLICK = "signUp_click";
        public static final String SIGN_UP_PAGE = "signup_page";
        public static final String SKIPPED = "skipped";
        public static final String SNAP = "snap";
        public static final String SPECIALS_AFFILIATELINK = "specials_affiliatelink";
        public static final String SPECIALS_AFFILIATELINK_SAVED = "specials_affiliatelink_saved";
        public static final String SPECIALS_INPERSON = "specials_inperson";
        public static final String SPECIALS_INPERSON_SAVED = "specials_inperson_saved";
        public static final String SPECIALS_PRINTABLE = "specials_printable";
        public static final String SPECIALS_PRINTABLE_SAVED = "specials_printable_saved";
        public static final String SPECIALS_PROMO_CODE = "specials_promocode";
        public static final String SPECIALS_PROMO_CODE_SAVED = "specials_promocode_saved";
        public static final String SPECIAL_AFFILIATE_CLICK = "special_affiliate_click";
        public static final String SPECIAL_CLICK = "special_click";
        public static final String SSO_CONTINUE_CLICK = "sso_continue_click";
        public static final String SSO_SWITCH_USER_CLICK = "sso_switchuser_click";
        public static final String SUCCESS = "success";
        public static final String SUGGESTION_SELECTED = "suggestion_selected";
        public static final String TAP_TO_ZOOM = "tap_to_zoom";
        public static final String TOOLBAR = "toolbar\u200B";
        public static final String TOP_CATEGORIES = "top_categories";
        public static final String TOP_CATEGORY_CLICK = "top_category_click";
        public static final String TOP_MERCHANT_CLICK = "top_merchant_click";
        public static final String TOP_STORES = "top_stores";
        public static final String USER_INPUT = "user_input";
        public static final String VIEW_APPOINTMENT_CLICK = "view_appointment_click";
        public static final String VIEW_INCENTIVE_TICKETS = "view_incentive_tickets";
        public static final String VIEW_ORDER_GDT = "view_order_gdt";
        public static final String VIEW_REQUEST_CLICK = "view_request_click";
        public static final String VIEW_RESERVATION_CLICK = "view_reservation_click";
        public static final String WEAR = "wear";
        public static final String WEBSITE_CLICK = "website_click";
        public static final String WIDGET_DEAL_CARD_CLICK = "widget_deal_card_click";
        public static final String WIDGET_FEATURED_CHANNEL = "personalized_featured";
        public static final String WIDGET_GOODS_CHANNEL = "goods";
        public static final String WIDGET_MM_DEAL_DETAILS = "mm_deal_details";
        public static final String WIDGET_SHOPPING_CART = "shopping_cart";

        private TrackingValues()
        {
        }
    }

    public static class UniversalAdapterExtra
    {

        public static final String HIDE_WIDGET_SUBSET_NAVIGATION = "hideWidgetSubsetNavigation";

        public UniversalAdapterExtra()
        {
        }
    }

    public static class UpgradeService extends Service
    {

        public static final String LOG_CATEGORY = "upgrade_service";

        public UpgradeService()
        {
        }
    }

    public static class Widget
    {

        public static final String LAYOUT_PARAMETER_NO_HEADER = "no_header";
        public static final String LAYOUT_TYPE_DEAL_CARDS = "deal_cards_layout";
        public static final String LAYOUT_TYPE_DEAL_CARDS_NO_HEADER = "deal_cards_layout_no_header";
        public static final String LAYOUT_TYPE_ROTATING_IMAGE = "rotating_image_layout";
        public static final String LAYOUT_TYPE_SMALL_DEAL_LIST_CARDS = "small_deal_list_cards_layout";

        private Widget()
        {
        }
    }


    public static final String BROKEN_ANDROID_ID = "9774d56d682e549c";
    public static final int CRITICAL = 0;
    public static final String CSS_STYLE_BUSINESS_EDITORS = "<style type=text/css>p{color:#75787b;}</style>";
    public static final String CSS_STYLE_BUSINESS_SPECIALS = "<style type=text/css>ol{padding-left: %s;} li{color:#75787b;} p{color:#75787b; font-size:%s}</style>";
    public static final String CSS_STYLE_INTERSTITIAL_SIGNUP = "<style type=text/css>body{background-color:#eeeeee; padding:15px;}</style>";
    public static final String CSS_STYLING = "<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{margin:0px;} ul{padding-left:25px} blockquote{margin:0px;}</style>";
    public static final String CSS_STYLING_GREY_TEXT_NO_LEFT_RIGHT_MARGIN = "<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{margin:10px 0px 0px 0px; color:#75787b;} a:link {color:#369ec1;} ul{padding-left:25px} blockquote{margin:0px;}</style>";
    public static final String CSS_STYLING_NEW_DEAL_DETAILS = "<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{margin:10px 0px 0px 0px; color:#75787b;} a:link {color:#369ec1; text-decoration: none;} hr{border-bottom:solid 1px #ddd; border-top:none; border-left:none; border-right:none;} ul{padding-left:25px} blockquote{margin:0px;}</style>";
    public static final String CSS_STYLING_RTL = "<style type=text/css> img{max-width: 100%; height: auto; display: block; margin: auto;} table{width: 100%; height: auto;} div{max-width: 100%; height: auto;} object{max-width: 100%; height: auto;} body{ direction: rtl; margin:0px; } ul{padding-left:25px} blockquote{margin:0px;}</style>";
    public static final String DEALS_SEARCH_PATH = "/deals/search";
    public static final String DEAL_SEARCH_URL = "https:/deals/search";
    public static final Country DEFAULT_CA_COUNTRY = new Country() {

            
            {
                shortName = "ca";
                isoName = "ca";
                defaultLocale = "ca";
                localeLanguages = Arrays.asList(new String[] {
                    "en"
                });
                enabledFeatures = new EnabledFeatures();
            }
    };
    public static final int DEFAULT_MAXIMUM_PURCHASE = 10;
    public static final int DEFAULT_MINIMUM_PURCHASE = 1;
    public static final Country DEFAULT_US_COUNTRY = new Country() {

            
            {
                shortName = "us";
                isoName = "us";
                defaultLocale = "us";
                localeLanguages = Arrays.asList(new String[] {
                    "en"
                });
                enabledFeatures = new EnabledFeatures();
            }
    };
    public static final String GMT_TIMEZONE = "GMT";
    public static final String ISO_8601_DATE_FORMAT = "yyyy-MM-dd";
    public static final int MAX_CHANNEL_NAME_LENGTH = 20;
    public static final int MAX_GPS_WAIT_MS = 10000;
    public static final int MINIMUM_PURCHASE_QUANTITY_SOLD_OUT = 1;
    public static final String NOW_CATEGORIES_URL = "https:/now/categories";
    public static final String NOW_DEALS_URL = "https:/now/deals";
    public static final String NULL_STRING = "";
    public static final String OOYALA_PROVIDER = "ooyala";
    public static final String PAYMENT_METHOD_TYPE_CREDITCARD = "payment_method_type_credit_card";
    public static final String PAYMENT_METHOD_TYPE_OTHER = "payment_method_type_other";
    public static final String PAYMENT_URL = "%1$s/mobile_app_payment/deals/%2$s/%3$s/buy/%4$s";
    public static final String SHIPPING_ADDRESS_SEPARATOR_COMMA = ", ";
    public static final String UTF8 = "UTF-8";
    public static final String locationChangedInAppMessageId = "7834";

    private Constants()
    {
    }

}
