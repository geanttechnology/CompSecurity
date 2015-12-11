// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon;


// Referenced classes of package com.groupon:
//            Constants

public class this._cls0
{
    public class Endpoint
    {

        public static final String HOTELS = "/getaways/hotels/%s";
        public static final String HOTEL_CREATE_RESERVATION = "/getaways/systems/%s/hotel_reservations";
        public static final String HOTEL_IMAGES = "/getaways/hotels/%s/images";
        public static final String HOTEL_INVENTORY = "/getaways/hotels/%s/inventory";
        public static final String HOTEL_UPDATE_RESERVATION = "/getaways/systems/%s/hotel_reservations/%s";
        public static final String RESERVATION_DETAILS = "/getaways/systems/%s/users/%s/hotel_reservations/%s";
        public static final String SEARCH = "/getaways/systems/%s/search";
        final Constants.MarketRateConstants this$1;

        public Endpoint()
        {
            this$1 = Constants.MarketRateConstants.this;
            super();
        }
    }

    public class Extra
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
        final Constants.MarketRateConstants this$1;

        public Extra()
        {
            this$1 = Constants.MarketRateConstants.this;
            super();
        }
    }

    public class Http
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
        final Constants.MarketRateConstants this$1;

        public Http()
        {
            this$1 = Constants.MarketRateConstants.this;
            super();
        }
    }

    public class JsonFieldValue
    {

        public static final String CANCELED_REGEX = "cancell?ed";
        public static final String CONFIRMED = "confirmed";
        public static final String FAILED = "failed";
        public static final String PROCESSING = "processing";
        final Constants.MarketRateConstants this$1;

        public JsonFieldValue()
        {
            this$1 = Constants.MarketRateConstants.this;
            super();
        }
    }

    public class TrackingValues
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
        final Constants.MarketRateConstants this$1;

        public TrackingValues()
        {
            this$1 = Constants.MarketRateConstants.this;
            super();
        }
    }


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

    public TrackingValues.this._cls1()
    {
        this$0 = Constants.this;
        super();
    }
}
