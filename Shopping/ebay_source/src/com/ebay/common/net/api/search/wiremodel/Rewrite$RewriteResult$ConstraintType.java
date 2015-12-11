// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search.wiremodel;


// Referenced classes of package com.ebay.common.net.api.search.wiremodel:
//            Rewrite

public static final class apiName extends Enum
{

    private static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY $VALUES[];
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY AUTHORIZED_SELLER_ONLY;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY AVAILABLE_TO;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY BEST_OFFER_ONLY;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY CASH_ON_DELIVERY;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY CHARITY_ONLY;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY COMPLETED_LISTINGS_ONLY;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY EBAY_NOW_DELIVERY;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY END_EVENT_DATE;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY END_TIME_FROM;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY END_TIME_MORE_THAN_HOURS;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY END_TIME_TO;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY END_TIME_WITHIN_HOURS;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY EPID;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY EXCLUDE_LOCAL_PICKUP_ITEMS;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY EXCLUDE_SELLER;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY EXPEDITED_SHIPPING_TYPE;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY FREE_SHIPPING_ONLY;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY GET_IT_FAST_ONLY;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY INCLUDE_LOCAL_ONLY_ITEMS;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY INCLUDE_SELLER;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY INTERMEDIATED_SHIPPING_ONLY;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY ISBN;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY ITEM_CONDITION;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY LISTING_TYPE;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY LOCAL_MERCHANT_STORE_PICKUP_ONLY;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY LOCAL_PICKUP_ONLY;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY LOCATED_IN;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY LOCKER_PICKUP_OPTION;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY LOTS_ONLY;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY MAX_BIDS;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY MAX_DISTANCE;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY MAX_HANDLING_TIME;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY MAX_PRICE;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY MAX_QUANTITY;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY MIN_BIDS;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY MIN_PRICE;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY MIN_QUANTITY;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY MPN;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY NOT_LOCATED_IN;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY NO_RESERVE_PRICE;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY NUMBER_OF_RETURN_DAYS;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY ONE_DAY_HANDLING;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY ONE_PAISA_AUCTION;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY OUTLET_SELLER_ONLY;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY PAYMENT_METHOD;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY PREFERED_LOCATION;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY PREFERRED_ITEM_LOCATION;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY PROMOTIONAL_REBATES;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY PROMOTION_SALE;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY RETURNS_ACCEPTED_ONLY;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY SELLER_BUSINESS_TYPE;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY SELLER_OFFER;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY SELLER_PRODUCT_ID;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY SELLER_WITH_STORE;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY SOLD_ITEMS_ONLY;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY START_EVENT_DATE;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY START_TIME_FROM;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY START_TIME_TO;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY START_TIME_WITHIN_HOURS;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY TOP_RATED_SELLERS_ONLY;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY UNKOWN;
    public static final EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY UPC;
    String apiName;

    public static apiName valueOf(String s)
    {
        return (apiName)Enum.valueOf(com/ebay/common/net/api/search/wiremodel/Rewrite$RewriteResult$ConstraintType, s);
    }

    public static apiName[] values()
    {
        return (apiName[])$VALUES.clone();
    }

    static 
    {
        UNKOWN = new <init>("UNKOWN", 0, "Unknown");
        ITEM_CONDITION = new <init>("ITEM_CONDITION", 1, "ItemCondition");
        END_TIME_FROM = new <init>("END_TIME_FROM", 2, "EndTimeFrom");
        END_TIME_TO = new <init>("END_TIME_TO", 3, "EndTimeTo");
        BEST_OFFER_ONLY = new <init>("BEST_OFFER_ONLY", 4, "BestOfferOnly");
        FREE_SHIPPING_ONLY = new <init>("FREE_SHIPPING_ONLY", 5, "FreeShippingOnly");
        GET_IT_FAST_ONLY = new <init>("GET_IT_FAST_ONLY", 6, "GetItFastOnly");
        AVAILABLE_TO = new <init>("AVAILABLE_TO", 7, "AvailableTo");
        LOCATED_IN = new <init>("LOCATED_IN", 8, "LocatedIn");
        PREFERED_LOCATION = new <init>("PREFERED_LOCATION", 9, "PreferredLocation");
        LOCAL_PICKUP_ONLY = new <init>("LOCAL_PICKUP_ONLY", 10, "LocalPickupOnly");
        LISTING_TYPE = new <init>("LISTING_TYPE", 11, "ListingType");
        LOTS_ONLY = new <init>("LOTS_ONLY", 12, "LotsOnly");
        MAX_BIDS = new <init>("MAX_BIDS", 13, "MaxBids");
        MIN_BIDS = new <init>("MIN_BIDS", 14, "MinBids");
        MAX_PRICE = new <init>("MAX_PRICE", 15, "MaxPrice");
        MIN_PRICE = new <init>("MIN_PRICE", 16, "MinPrice");
        PAYMENT_METHOD = new <init>("PAYMENT_METHOD", 17, "PaymentMethod");
        MAX_QUANTITY = new <init>("MAX_QUANTITY", 18, "MaxQuantity");
        MIN_QUANTITY = new <init>("MIN_QUANTITY", 19, "MinQuantity");
        INCLUDE_SELLER = new <init>("INCLUDE_SELLER", 20, "IncludeSeller");
        EXCLUDE_SELLER = new <init>("EXCLUDE_SELLER", 21, "ExcludeSeller");
        SELLER_WITH_STORE = new <init>("SELLER_WITH_STORE", 22, "SellersWithStore");
        MAX_DISTANCE = new <init>("MAX_DISTANCE", 23, "MaxDistance");
        SELLER_BUSINESS_TYPE = new <init>("SELLER_BUSINESS_TYPE", 24, "SellerBusinessType");
        TOP_RATED_SELLERS_ONLY = new <init>("TOP_RATED_SELLERS_ONLY", 25, "TopRatedSellersOnly");
        SOLD_ITEMS_ONLY = new <init>("SOLD_ITEMS_ONLY", 26, "SoldItemsOnly");
        CHARITY_ONLY = new <init>("CHARITY_ONLY", 27, "CharityOnly");
        ONE_DAY_HANDLING = new <init>("ONE_DAY_HANDLING", 28, "OneDayHandling");
        EXPEDITED_SHIPPING_TYPE = new <init>("EXPEDITED_SHIPPING_TYPE", 29, "ExpeditedShippingType");
        MAX_HANDLING_TIME = new <init>("MAX_HANDLING_TIME", 30, "MaxHandlingTime");
        RETURNS_ACCEPTED_ONLY = new <init>("RETURNS_ACCEPTED_ONLY", 31, "ReturnsAcceptedOnly");
        OUTLET_SELLER_ONLY = new <init>("OUTLET_SELLER_ONLY", 32, "OutletSellerOnly");
        AUTHORIZED_SELLER_ONLY = new <init>("AUTHORIZED_SELLER_ONLY", 33, "AuthorizedSellerOnly");
        START_TIME_FROM = new <init>("START_TIME_FROM", 34, "StartTimeFrom");
        START_TIME_TO = new <init>("START_TIME_TO", 35, "StartTimeTo");
        COMPLETED_LISTINGS_ONLY = new <init>("COMPLETED_LISTINGS_ONLY", 36, "CompletedListingsOnly");
        CASH_ON_DELIVERY = new <init>("CASH_ON_DELIVERY", 37, "CashOnDelivery");
        ONE_PAISA_AUCTION = new <init>("ONE_PAISA_AUCTION", 38, "OnePaisaAuction");
        PROMOTION_SALE = new <init>("PROMOTION_SALE", 39, "PromotionSale");
        END_TIME_WITHIN_HOURS = new <init>("END_TIME_WITHIN_HOURS", 40, "EndTimeWithinHours");
        END_TIME_MORE_THAN_HOURS = new <init>("END_TIME_MORE_THAN_HOURS", 41, "EndTimeMoreThanHours");
        START_TIME_WITHIN_HOURS = new <init>("START_TIME_WITHIN_HOURS", 42, "StartTimeWithinHours");
        START_EVENT_DATE = new <init>("START_EVENT_DATE", 43, "StartEventDate");
        END_EVENT_DATE = new <init>("END_EVENT_DATE", 44, "EndEventDate");
        PROMOTIONAL_REBATES = new <init>("PROMOTIONAL_REBATES", 45, "PromotionalRebates");
        NO_RESERVE_PRICE = new <init>("NO_RESERVE_PRICE", 46, "NoReservePrice");
        LOCAL_MERCHANT_STORE_PICKUP_ONLY = new <init>("LOCAL_MERCHANT_STORE_PICKUP_ONLY", 47, "LocalMerchantStorePickupOnly");
        EBAY_NOW_DELIVERY = new <init>("EBAY_NOW_DELIVERY", 48, "EbayNowDelivery");
        PREFERRED_ITEM_LOCATION = new <init>("PREFERRED_ITEM_LOCATION", 49, "PreferredItemLocation");
        NOT_LOCATED_IN = new <init>("NOT_LOCATED_IN", 50, "NotLocatedIn");
        SELLER_OFFER = new <init>("SELLER_OFFER", 51, "SellerOffer");
        INCLUDE_LOCAL_ONLY_ITEMS = new <init>("INCLUDE_LOCAL_ONLY_ITEMS", 52, "IncludeLocalOnlyItems");
        EXCLUDE_LOCAL_PICKUP_ITEMS = new <init>("EXCLUDE_LOCAL_PICKUP_ITEMS", 53, "ExcludeLocalPickupItems");
        INTERMEDIATED_SHIPPING_ONLY = new <init>("INTERMEDIATED_SHIPPING_ONLY", 54, "IntermediatedShippingOnly");
        LOCKER_PICKUP_OPTION = new <init>("LOCKER_PICKUP_OPTION", 55, "LockerPickUpOption");
        NUMBER_OF_RETURN_DAYS = new <init>("NUMBER_OF_RETURN_DAYS", 56, "NumberOfReturnDays");
        EPID = new <init>("EPID", 57, "EPID");
        UPC = new <init>("UPC", 58, "UPC");
        MPN = new <init>("MPN", 59, "MPN");
        ISBN = new <init>("ISBN", 60, "ISBN");
        SELLER_PRODUCT_ID = new <init>("SELLER_PRODUCT_ID", 61, "SellerProductId");
        EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY = new <init>("EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY", 62, "ExtendedHolidayReturnsEligibleOnly");
        $VALUES = (new .VALUES[] {
            UNKOWN, ITEM_CONDITION, END_TIME_FROM, END_TIME_TO, BEST_OFFER_ONLY, FREE_SHIPPING_ONLY, GET_IT_FAST_ONLY, AVAILABLE_TO, LOCATED_IN, PREFERED_LOCATION, 
            LOCAL_PICKUP_ONLY, LISTING_TYPE, LOTS_ONLY, MAX_BIDS, MIN_BIDS, MAX_PRICE, MIN_PRICE, PAYMENT_METHOD, MAX_QUANTITY, MIN_QUANTITY, 
            INCLUDE_SELLER, EXCLUDE_SELLER, SELLER_WITH_STORE, MAX_DISTANCE, SELLER_BUSINESS_TYPE, TOP_RATED_SELLERS_ONLY, SOLD_ITEMS_ONLY, CHARITY_ONLY, ONE_DAY_HANDLING, EXPEDITED_SHIPPING_TYPE, 
            MAX_HANDLING_TIME, RETURNS_ACCEPTED_ONLY, OUTLET_SELLER_ONLY, AUTHORIZED_SELLER_ONLY, START_TIME_FROM, START_TIME_TO, COMPLETED_LISTINGS_ONLY, CASH_ON_DELIVERY, ONE_PAISA_AUCTION, PROMOTION_SALE, 
            END_TIME_WITHIN_HOURS, END_TIME_MORE_THAN_HOURS, START_TIME_WITHIN_HOURS, START_EVENT_DATE, END_EVENT_DATE, PROMOTIONAL_REBATES, NO_RESERVE_PRICE, LOCAL_MERCHANT_STORE_PICKUP_ONLY, EBAY_NOW_DELIVERY, PREFERRED_ITEM_LOCATION, 
            NOT_LOCATED_IN, SELLER_OFFER, INCLUDE_LOCAL_ONLY_ITEMS, EXCLUDE_LOCAL_PICKUP_ITEMS, INTERMEDIATED_SHIPPING_ONLY, LOCKER_PICKUP_OPTION, NUMBER_OF_RETURN_DAYS, EPID, UPC, MPN, 
            ISBN, SELLER_PRODUCT_ID, EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY
        });
    }

    private (String s, int i, String s1)
    {
        super(s, i);
        apiName = s1;
    }
}
