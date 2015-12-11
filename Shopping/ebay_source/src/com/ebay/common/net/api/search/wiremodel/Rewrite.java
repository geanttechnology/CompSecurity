// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search.wiremodel;

import java.util.List;

public class Rewrite
{
    public static class RewriteResult
    {

        public com.ebay.common.net.api.search.SearchExpansion.ExpansionResult expansionResult;
        public List items;
        public long matchCount;
        public SearchRequest modifiedRequest;
        public SearchRequestDifference requestDifference;
        public RewriteInfo rewriteInfo;

        public RewriteResult()
        {
        }
    }

    public static class RewriteResult.AspectContstraint
    {

        String name;
        List value;

        public RewriteResult.AspectContstraint()
        {
        }
    }

    public static class RewriteResult.AspectScope
    {

        String type;
        String value;

        public RewriteResult.AspectScope()
        {
        }
    }

    public static class RewriteResult.AttributeNameValue
    {

        String name;
        String value;

        public RewriteResult.AttributeNameValue()
        {
        }
    }

    public static class RewriteResult.Category
    {

        String applied;
        RewriteResult.CategoryGroup categoryGroup;
        public long id;
        String leafCategory;
        int level;
        public String localizedName;
        public String name;
        RewriteResult.Category parentCategory;

        public RewriteResult.Category()
        {
            categoryGroup = RewriteResult.CategoryGroup.OTHER;
        }
    }

    public static class RewriteResult.CategoryDifference
    {

        public List add;
        public List remove;

        public RewriteResult.CategoryDifference()
        {
        }
    }

    public static final class RewriteResult.CategoryGroup extends Enum
    {

        private static final RewriteResult.CategoryGroup $VALUES[];
        public static final RewriteResult.CategoryGroup OTHER;
        public static final RewriteResult.CategoryGroup PRIMARY;
        public static final RewriteResult.CategoryGroup SECONDARY;

        public static RewriteResult.CategoryGroup valueOf(String s)
        {
            return (RewriteResult.CategoryGroup)Enum.valueOf(com/ebay/common/net/api/search/wiremodel/Rewrite$RewriteResult$CategoryGroup, s);
        }

        public static RewriteResult.CategoryGroup[] values()
        {
            return (RewriteResult.CategoryGroup[])$VALUES.clone();
        }

        static 
        {
            PRIMARY = new RewriteResult.CategoryGroup("PRIMARY", 0);
            SECONDARY = new RewriteResult.CategoryGroup("SECONDARY", 1);
            OTHER = new RewriteResult.CategoryGroup("OTHER", 2);
            $VALUES = (new RewriteResult.CategoryGroup[] {
                PRIMARY, SECONDARY, OTHER
            });
        }

        private RewriteResult.CategoryGroup(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class RewriteResult.ConstraintType extends Enum
    {

        private static final RewriteResult.ConstraintType $VALUES[];
        public static final RewriteResult.ConstraintType AUTHORIZED_SELLER_ONLY;
        public static final RewriteResult.ConstraintType AVAILABLE_TO;
        public static final RewriteResult.ConstraintType BEST_OFFER_ONLY;
        public static final RewriteResult.ConstraintType CASH_ON_DELIVERY;
        public static final RewriteResult.ConstraintType CHARITY_ONLY;
        public static final RewriteResult.ConstraintType COMPLETED_LISTINGS_ONLY;
        public static final RewriteResult.ConstraintType EBAY_NOW_DELIVERY;
        public static final RewriteResult.ConstraintType END_EVENT_DATE;
        public static final RewriteResult.ConstraintType END_TIME_FROM;
        public static final RewriteResult.ConstraintType END_TIME_MORE_THAN_HOURS;
        public static final RewriteResult.ConstraintType END_TIME_TO;
        public static final RewriteResult.ConstraintType END_TIME_WITHIN_HOURS;
        public static final RewriteResult.ConstraintType EPID;
        public static final RewriteResult.ConstraintType EXCLUDE_LOCAL_PICKUP_ITEMS;
        public static final RewriteResult.ConstraintType EXCLUDE_SELLER;
        public static final RewriteResult.ConstraintType EXPEDITED_SHIPPING_TYPE;
        public static final RewriteResult.ConstraintType EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY;
        public static final RewriteResult.ConstraintType FREE_SHIPPING_ONLY;
        public static final RewriteResult.ConstraintType GET_IT_FAST_ONLY;
        public static final RewriteResult.ConstraintType INCLUDE_LOCAL_ONLY_ITEMS;
        public static final RewriteResult.ConstraintType INCLUDE_SELLER;
        public static final RewriteResult.ConstraintType INTERMEDIATED_SHIPPING_ONLY;
        public static final RewriteResult.ConstraintType ISBN;
        public static final RewriteResult.ConstraintType ITEM_CONDITION;
        public static final RewriteResult.ConstraintType LISTING_TYPE;
        public static final RewriteResult.ConstraintType LOCAL_MERCHANT_STORE_PICKUP_ONLY;
        public static final RewriteResult.ConstraintType LOCAL_PICKUP_ONLY;
        public static final RewriteResult.ConstraintType LOCATED_IN;
        public static final RewriteResult.ConstraintType LOCKER_PICKUP_OPTION;
        public static final RewriteResult.ConstraintType LOTS_ONLY;
        public static final RewriteResult.ConstraintType MAX_BIDS;
        public static final RewriteResult.ConstraintType MAX_DISTANCE;
        public static final RewriteResult.ConstraintType MAX_HANDLING_TIME;
        public static final RewriteResult.ConstraintType MAX_PRICE;
        public static final RewriteResult.ConstraintType MAX_QUANTITY;
        public static final RewriteResult.ConstraintType MIN_BIDS;
        public static final RewriteResult.ConstraintType MIN_PRICE;
        public static final RewriteResult.ConstraintType MIN_QUANTITY;
        public static final RewriteResult.ConstraintType MPN;
        public static final RewriteResult.ConstraintType NOT_LOCATED_IN;
        public static final RewriteResult.ConstraintType NO_RESERVE_PRICE;
        public static final RewriteResult.ConstraintType NUMBER_OF_RETURN_DAYS;
        public static final RewriteResult.ConstraintType ONE_DAY_HANDLING;
        public static final RewriteResult.ConstraintType ONE_PAISA_AUCTION;
        public static final RewriteResult.ConstraintType OUTLET_SELLER_ONLY;
        public static final RewriteResult.ConstraintType PAYMENT_METHOD;
        public static final RewriteResult.ConstraintType PREFERED_LOCATION;
        public static final RewriteResult.ConstraintType PREFERRED_ITEM_LOCATION;
        public static final RewriteResult.ConstraintType PROMOTIONAL_REBATES;
        public static final RewriteResult.ConstraintType PROMOTION_SALE;
        public static final RewriteResult.ConstraintType RETURNS_ACCEPTED_ONLY;
        public static final RewriteResult.ConstraintType SELLER_BUSINESS_TYPE;
        public static final RewriteResult.ConstraintType SELLER_OFFER;
        public static final RewriteResult.ConstraintType SELLER_PRODUCT_ID;
        public static final RewriteResult.ConstraintType SELLER_WITH_STORE;
        public static final RewriteResult.ConstraintType SOLD_ITEMS_ONLY;
        public static final RewriteResult.ConstraintType START_EVENT_DATE;
        public static final RewriteResult.ConstraintType START_TIME_FROM;
        public static final RewriteResult.ConstraintType START_TIME_TO;
        public static final RewriteResult.ConstraintType START_TIME_WITHIN_HOURS;
        public static final RewriteResult.ConstraintType TOP_RATED_SELLERS_ONLY;
        public static final RewriteResult.ConstraintType UNKOWN;
        public static final RewriteResult.ConstraintType UPC;
        String apiName;

        public static RewriteResult.ConstraintType valueOf(String s)
        {
            return (RewriteResult.ConstraintType)Enum.valueOf(com/ebay/common/net/api/search/wiremodel/Rewrite$RewriteResult$ConstraintType, s);
        }

        public static RewriteResult.ConstraintType[] values()
        {
            return (RewriteResult.ConstraintType[])$VALUES.clone();
        }

        static 
        {
            UNKOWN = new RewriteResult.ConstraintType("UNKOWN", 0, "Unknown");
            ITEM_CONDITION = new RewriteResult.ConstraintType("ITEM_CONDITION", 1, "ItemCondition");
            END_TIME_FROM = new RewriteResult.ConstraintType("END_TIME_FROM", 2, "EndTimeFrom");
            END_TIME_TO = new RewriteResult.ConstraintType("END_TIME_TO", 3, "EndTimeTo");
            BEST_OFFER_ONLY = new RewriteResult.ConstraintType("BEST_OFFER_ONLY", 4, "BestOfferOnly");
            FREE_SHIPPING_ONLY = new RewriteResult.ConstraintType("FREE_SHIPPING_ONLY", 5, "FreeShippingOnly");
            GET_IT_FAST_ONLY = new RewriteResult.ConstraintType("GET_IT_FAST_ONLY", 6, "GetItFastOnly");
            AVAILABLE_TO = new RewriteResult.ConstraintType("AVAILABLE_TO", 7, "AvailableTo");
            LOCATED_IN = new RewriteResult.ConstraintType("LOCATED_IN", 8, "LocatedIn");
            PREFERED_LOCATION = new RewriteResult.ConstraintType("PREFERED_LOCATION", 9, "PreferredLocation");
            LOCAL_PICKUP_ONLY = new RewriteResult.ConstraintType("LOCAL_PICKUP_ONLY", 10, "LocalPickupOnly");
            LISTING_TYPE = new RewriteResult.ConstraintType("LISTING_TYPE", 11, "ListingType");
            LOTS_ONLY = new RewriteResult.ConstraintType("LOTS_ONLY", 12, "LotsOnly");
            MAX_BIDS = new RewriteResult.ConstraintType("MAX_BIDS", 13, "MaxBids");
            MIN_BIDS = new RewriteResult.ConstraintType("MIN_BIDS", 14, "MinBids");
            MAX_PRICE = new RewriteResult.ConstraintType("MAX_PRICE", 15, "MaxPrice");
            MIN_PRICE = new RewriteResult.ConstraintType("MIN_PRICE", 16, "MinPrice");
            PAYMENT_METHOD = new RewriteResult.ConstraintType("PAYMENT_METHOD", 17, "PaymentMethod");
            MAX_QUANTITY = new RewriteResult.ConstraintType("MAX_QUANTITY", 18, "MaxQuantity");
            MIN_QUANTITY = new RewriteResult.ConstraintType("MIN_QUANTITY", 19, "MinQuantity");
            INCLUDE_SELLER = new RewriteResult.ConstraintType("INCLUDE_SELLER", 20, "IncludeSeller");
            EXCLUDE_SELLER = new RewriteResult.ConstraintType("EXCLUDE_SELLER", 21, "ExcludeSeller");
            SELLER_WITH_STORE = new RewriteResult.ConstraintType("SELLER_WITH_STORE", 22, "SellersWithStore");
            MAX_DISTANCE = new RewriteResult.ConstraintType("MAX_DISTANCE", 23, "MaxDistance");
            SELLER_BUSINESS_TYPE = new RewriteResult.ConstraintType("SELLER_BUSINESS_TYPE", 24, "SellerBusinessType");
            TOP_RATED_SELLERS_ONLY = new RewriteResult.ConstraintType("TOP_RATED_SELLERS_ONLY", 25, "TopRatedSellersOnly");
            SOLD_ITEMS_ONLY = new RewriteResult.ConstraintType("SOLD_ITEMS_ONLY", 26, "SoldItemsOnly");
            CHARITY_ONLY = new RewriteResult.ConstraintType("CHARITY_ONLY", 27, "CharityOnly");
            ONE_DAY_HANDLING = new RewriteResult.ConstraintType("ONE_DAY_HANDLING", 28, "OneDayHandling");
            EXPEDITED_SHIPPING_TYPE = new RewriteResult.ConstraintType("EXPEDITED_SHIPPING_TYPE", 29, "ExpeditedShippingType");
            MAX_HANDLING_TIME = new RewriteResult.ConstraintType("MAX_HANDLING_TIME", 30, "MaxHandlingTime");
            RETURNS_ACCEPTED_ONLY = new RewriteResult.ConstraintType("RETURNS_ACCEPTED_ONLY", 31, "ReturnsAcceptedOnly");
            OUTLET_SELLER_ONLY = new RewriteResult.ConstraintType("OUTLET_SELLER_ONLY", 32, "OutletSellerOnly");
            AUTHORIZED_SELLER_ONLY = new RewriteResult.ConstraintType("AUTHORIZED_SELLER_ONLY", 33, "AuthorizedSellerOnly");
            START_TIME_FROM = new RewriteResult.ConstraintType("START_TIME_FROM", 34, "StartTimeFrom");
            START_TIME_TO = new RewriteResult.ConstraintType("START_TIME_TO", 35, "StartTimeTo");
            COMPLETED_LISTINGS_ONLY = new RewriteResult.ConstraintType("COMPLETED_LISTINGS_ONLY", 36, "CompletedListingsOnly");
            CASH_ON_DELIVERY = new RewriteResult.ConstraintType("CASH_ON_DELIVERY", 37, "CashOnDelivery");
            ONE_PAISA_AUCTION = new RewriteResult.ConstraintType("ONE_PAISA_AUCTION", 38, "OnePaisaAuction");
            PROMOTION_SALE = new RewriteResult.ConstraintType("PROMOTION_SALE", 39, "PromotionSale");
            END_TIME_WITHIN_HOURS = new RewriteResult.ConstraintType("END_TIME_WITHIN_HOURS", 40, "EndTimeWithinHours");
            END_TIME_MORE_THAN_HOURS = new RewriteResult.ConstraintType("END_TIME_MORE_THAN_HOURS", 41, "EndTimeMoreThanHours");
            START_TIME_WITHIN_HOURS = new RewriteResult.ConstraintType("START_TIME_WITHIN_HOURS", 42, "StartTimeWithinHours");
            START_EVENT_DATE = new RewriteResult.ConstraintType("START_EVENT_DATE", 43, "StartEventDate");
            END_EVENT_DATE = new RewriteResult.ConstraintType("END_EVENT_DATE", 44, "EndEventDate");
            PROMOTIONAL_REBATES = new RewriteResult.ConstraintType("PROMOTIONAL_REBATES", 45, "PromotionalRebates");
            NO_RESERVE_PRICE = new RewriteResult.ConstraintType("NO_RESERVE_PRICE", 46, "NoReservePrice");
            LOCAL_MERCHANT_STORE_PICKUP_ONLY = new RewriteResult.ConstraintType("LOCAL_MERCHANT_STORE_PICKUP_ONLY", 47, "LocalMerchantStorePickupOnly");
            EBAY_NOW_DELIVERY = new RewriteResult.ConstraintType("EBAY_NOW_DELIVERY", 48, "EbayNowDelivery");
            PREFERRED_ITEM_LOCATION = new RewriteResult.ConstraintType("PREFERRED_ITEM_LOCATION", 49, "PreferredItemLocation");
            NOT_LOCATED_IN = new RewriteResult.ConstraintType("NOT_LOCATED_IN", 50, "NotLocatedIn");
            SELLER_OFFER = new RewriteResult.ConstraintType("SELLER_OFFER", 51, "SellerOffer");
            INCLUDE_LOCAL_ONLY_ITEMS = new RewriteResult.ConstraintType("INCLUDE_LOCAL_ONLY_ITEMS", 52, "IncludeLocalOnlyItems");
            EXCLUDE_LOCAL_PICKUP_ITEMS = new RewriteResult.ConstraintType("EXCLUDE_LOCAL_PICKUP_ITEMS", 53, "ExcludeLocalPickupItems");
            INTERMEDIATED_SHIPPING_ONLY = new RewriteResult.ConstraintType("INTERMEDIATED_SHIPPING_ONLY", 54, "IntermediatedShippingOnly");
            LOCKER_PICKUP_OPTION = new RewriteResult.ConstraintType("LOCKER_PICKUP_OPTION", 55, "LockerPickUpOption");
            NUMBER_OF_RETURN_DAYS = new RewriteResult.ConstraintType("NUMBER_OF_RETURN_DAYS", 56, "NumberOfReturnDays");
            EPID = new RewriteResult.ConstraintType("EPID", 57, "EPID");
            UPC = new RewriteResult.ConstraintType("UPC", 58, "UPC");
            MPN = new RewriteResult.ConstraintType("MPN", 59, "MPN");
            ISBN = new RewriteResult.ConstraintType("ISBN", 60, "ISBN");
            SELLER_PRODUCT_ID = new RewriteResult.ConstraintType("SELLER_PRODUCT_ID", 61, "SellerProductId");
            EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY = new RewriteResult.ConstraintType("EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY", 62, "ExtendedHolidayReturnsEligibleOnly");
            $VALUES = (new RewriteResult.ConstraintType[] {
                UNKOWN, ITEM_CONDITION, END_TIME_FROM, END_TIME_TO, BEST_OFFER_ONLY, FREE_SHIPPING_ONLY, GET_IT_FAST_ONLY, AVAILABLE_TO, LOCATED_IN, PREFERED_LOCATION, 
                LOCAL_PICKUP_ONLY, LISTING_TYPE, LOTS_ONLY, MAX_BIDS, MIN_BIDS, MAX_PRICE, MIN_PRICE, PAYMENT_METHOD, MAX_QUANTITY, MIN_QUANTITY, 
                INCLUDE_SELLER, EXCLUDE_SELLER, SELLER_WITH_STORE, MAX_DISTANCE, SELLER_BUSINESS_TYPE, TOP_RATED_SELLERS_ONLY, SOLD_ITEMS_ONLY, CHARITY_ONLY, ONE_DAY_HANDLING, EXPEDITED_SHIPPING_TYPE, 
                MAX_HANDLING_TIME, RETURNS_ACCEPTED_ONLY, OUTLET_SELLER_ONLY, AUTHORIZED_SELLER_ONLY, START_TIME_FROM, START_TIME_TO, COMPLETED_LISTINGS_ONLY, CASH_ON_DELIVERY, ONE_PAISA_AUCTION, PROMOTION_SALE, 
                END_TIME_WITHIN_HOURS, END_TIME_MORE_THAN_HOURS, START_TIME_WITHIN_HOURS, START_EVENT_DATE, END_EVENT_DATE, PROMOTIONAL_REBATES, NO_RESERVE_PRICE, LOCAL_MERCHANT_STORE_PICKUP_ONLY, EBAY_NOW_DELIVERY, PREFERRED_ITEM_LOCATION, 
                NOT_LOCATED_IN, SELLER_OFFER, INCLUDE_LOCAL_ONLY_ITEMS, EXCLUDE_LOCAL_PICKUP_ITEMS, INTERMEDIATED_SHIPPING_ONLY, LOCKER_PICKUP_OPTION, NUMBER_OF_RETURN_DAYS, EPID, UPC, MPN, 
                ISBN, SELLER_PRODUCT_ID, EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY
            });
        }

        private RewriteResult.ConstraintType(String s, int i, String s1)
        {
            super(s, i);
            apiName = s1;
        }
    }

    public static class RewriteResult.GlobalAspectConstraint
    {

        RewriteResult.ConstraintType constraintType;
        List paramNameValue;
        List value;

        public RewriteResult.GlobalAspectConstraint()
        {
            constraintType = RewriteResult.ConstraintType.UNKOWN;
        }
    }

    public static class RewriteResult.GlobalAspectDifference
    {

        List add;
        List remove;

        public RewriteResult.GlobalAspectDifference()
        {
        }
    }

    public static class RewriteResult.KeywordDifference
    {

        String add;
        String remove;

        public RewriteResult.KeywordDifference()
        {
        }
    }

    public static class RewriteResult.Location
    {

        String city;
        String country;
        String postalCode;
        String stateOrProvince;
        String stateOrProvinceFullName;

        public RewriteResult.Location()
        {
        }
    }

    public static class RewriteResult.RewriteInfo
    {

        public List categoryPaths;

        public RewriteResult.RewriteInfo()
        {
        }
    }

    public static class RewriteResult.ScopedAspectConstraint
    {

        RewriteResult.AspectContstraint aspect;
        RewriteResult.AspectScope scope;

        public RewriteResult.ScopedAspectConstraint()
        {
        }
    }

    public static class RewriteResult.ScopedAspectDifference
    {

        List add;
        List remove;

        public RewriteResult.ScopedAspectDifference()
        {
        }
    }

    public static class RewriteResult.SearchRequest
    {

        public List categoryIds;
        public SearchContraints contraints;
        public List excludeCategoryIds;
        public List features;
        public String keyword;
        public OutputSelector outputSelector;
        public PaginationInput paginationInput;
        public List requestConfig;
        public List scopes;
        public String sellerName;
        public RewriteResult.Location shipToLocation;
        public RewriteResult.SortOrder sortOrder;
        public UserContext userContext;

        public RewriteResult.SearchRequest()
        {
            sortOrder = RewriteResult.SortOrder.UNKNOWN;
        }
    }

    static class RewriteResult.SearchRequest.Feature
    {

        String name;
        List value;

        RewriteResult.SearchRequest.Feature()
        {
        }
    }

    static class RewriteResult.SearchRequest.OutputSelector
    {

        RewriteResult.SearchRequest.OutputSelector()
        {
        }
    }

    static class RewriteResult.SearchRequest.PaginationInput
    {

        int entriesPerPage;
        int pageNumber;
        int skipCount;

        RewriteResult.SearchRequest.PaginationInput()
        {
        }
    }

    static class RewriteResult.SearchRequest.SearchContraints
    {

        List globalAspect;
        List scopedAspect;

        RewriteResult.SearchRequest.SearchContraints()
        {
        }
    }

    static final class RewriteResult.SearchRequest.SearchScope extends Enum
    {

        private static final RewriteResult.SearchRequest.SearchScope $VALUES[];
        public static final RewriteResult.SearchRequest.SearchScope ITEM_TITLE_AND_DESCRIPTION_SEARCH;
        public static final RewriteResult.SearchRequest.SearchScope ITEM_TITLE_SEARCH;
        String apiName;

        public static RewriteResult.SearchRequest.SearchScope valueOf(String s)
        {
            return (RewriteResult.SearchRequest.SearchScope)Enum.valueOf(com/ebay/common/net/api/search/wiremodel/Rewrite$RewriteResult$SearchRequest$SearchScope, s);
        }

        public static RewriteResult.SearchRequest.SearchScope[] values()
        {
            return (RewriteResult.SearchRequest.SearchScope[])$VALUES.clone();
        }

        static 
        {
            ITEM_TITLE_SEARCH = new RewriteResult.SearchRequest.SearchScope("ITEM_TITLE_SEARCH", 0, "ItemTitleSearch");
            ITEM_TITLE_AND_DESCRIPTION_SEARCH = new RewriteResult.SearchRequest.SearchScope("ITEM_TITLE_AND_DESCRIPTION_SEARCH", 1, "ItemTitleAndDescriptionSearch");
            $VALUES = (new RewriteResult.SearchRequest.SearchScope[] {
                ITEM_TITLE_SEARCH, ITEM_TITLE_AND_DESCRIPTION_SEARCH
            });
        }

        private RewriteResult.SearchRequest.SearchScope(String s, int i, String s1)
        {
            super(s, i);
            apiName = s1;
        }
    }

    static class RewriteResult.SearchRequest.UserContext
    {

        RewriteResult.Location userLocation;

        RewriteResult.SearchRequest.UserContext()
        {
        }
    }

    public static class RewriteResult.SearchRequestDifference
    {

        public RewriteResult.CategoryDifference categoryId;
        RewriteResult.GlobalAspectDifference globalAspect;
        RewriteResult.KeywordDifference keyword;
        RewriteResult.ScopedAspectDifference scopedAspect;
        RewriteResult.SortOrderDifference sortOrder;

        public RewriteResult.SearchRequestDifference()
        {
        }
    }

    public static final class RewriteResult.SortOrder extends Enum
    {

        private static final RewriteResult.SortOrder $VALUES[];
        public static final RewriteResult.SortOrder BEST_MATCH;
        public static final RewriteResult.SortOrder BID_COUNT_FEWEST;
        public static final RewriteResult.SortOrder BID_COUNT_MOST;
        public static final RewriteResult.SortOrder CONDITION_NEW_FIRST;
        public static final RewriteResult.SortOrder CONDITION_USED_FIRST;
        public static final RewriteResult.SortOrder COUNTRY_ASCENDING;
        public static final RewriteResult.SortOrder COUNTRY_DESCENDING;
        public static final RewriteResult.SortOrder COUNTRY_REGION_DOWN;
        public static final RewriteResult.SortOrder COUNTRY_REGION_UP;
        public static final RewriteResult.SortOrder CURRENT_PRICE_HIGHEST;
        public static final RewriteResult.SortOrder CURRENT_PRICE_LOWEST;
        public static final RewriteResult.SortOrder DATE_LISTED_OLDEST_FIRST;
        public static final RewriteResult.SortOrder DISTANCE_NEAREST;
        public static final RewriteResult.SortOrder END_DATE_RECENT;
        public static final RewriteResult.SortOrder END_TIME_SOONEST;
        public static final RewriteResult.SortOrder MILEAGE_HIGHEST;
        public static final RewriteResult.SortOrder MILEAGE_LOWEST;
        public static final RewriteResult.SortOrder PRICE_PLUS_SHIPPING_HIGHEST;
        public static final RewriteResult.SortOrder PRICE_PLUS_SHIPPING_LOWEST;
        public static final RewriteResult.SortOrder START_TIME_NEWEST;
        public static final RewriteResult.SortOrder UNKNOWN;
        public static final RewriteResult.SortOrder YEAR_HIGHEST;
        public static final RewriteResult.SortOrder YEAR_LOWEST;
        String apiName;

        public static RewriteResult.SortOrder valueOf(String s)
        {
            return (RewriteResult.SortOrder)Enum.valueOf(com/ebay/common/net/api/search/wiremodel/Rewrite$RewriteResult$SortOrder, s);
        }

        public static RewriteResult.SortOrder[] values()
        {
            return (RewriteResult.SortOrder[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new RewriteResult.SortOrder("UNKNOWN", 0, "Unknown");
            BEST_MATCH = new RewriteResult.SortOrder("BEST_MATCH", 1, "BestMatch");
            CURRENT_PRICE_LOWEST = new RewriteResult.SortOrder("CURRENT_PRICE_LOWEST", 2, "CurrentPriceLowest");
            CURRENT_PRICE_HIGHEST = new RewriteResult.SortOrder("CURRENT_PRICE_HIGHEST", 3, "CurrentPriceHighest");
            DISTANCE_NEAREST = new RewriteResult.SortOrder("DISTANCE_NEAREST", 4, "DistanceNearest");
            END_TIME_SOONEST = new RewriteResult.SortOrder("END_TIME_SOONEST", 5, "EndTimeSoonest");
            PRICE_PLUS_SHIPPING_LOWEST = new RewriteResult.SortOrder("PRICE_PLUS_SHIPPING_LOWEST", 6, "PricePlusShippingLowest");
            PRICE_PLUS_SHIPPING_HIGHEST = new RewriteResult.SortOrder("PRICE_PLUS_SHIPPING_HIGHEST", 7, "PricePlusShippingHighest");
            START_TIME_NEWEST = new RewriteResult.SortOrder("START_TIME_NEWEST", 8, "StartTimeNewest");
            BID_COUNT_MOST = new RewriteResult.SortOrder("BID_COUNT_MOST", 9, "BidCountMost");
            BID_COUNT_FEWEST = new RewriteResult.SortOrder("BID_COUNT_FEWEST", 10, "BidCountFewest");
            COUNTRY_ASCENDING = new RewriteResult.SortOrder("COUNTRY_ASCENDING", 11, "CountryAscending");
            COUNTRY_DESCENDING = new RewriteResult.SortOrder("COUNTRY_DESCENDING", 12, "CountryDescending");
            CONDITION_NEW_FIRST = new RewriteResult.SortOrder("CONDITION_NEW_FIRST", 13, "ConditionNewFirst");
            CONDITION_USED_FIRST = new RewriteResult.SortOrder("CONDITION_USED_FIRST", 14, "ConditionUsedFirst");
            COUNTRY_REGION_DOWN = new RewriteResult.SortOrder("COUNTRY_REGION_DOWN", 15, "CountryRegionDown");
            COUNTRY_REGION_UP = new RewriteResult.SortOrder("COUNTRY_REGION_UP", 16, "CountryRegionUp");
            MILEAGE_LOWEST = new RewriteResult.SortOrder("MILEAGE_LOWEST", 17, "MileageLowest");
            MILEAGE_HIGHEST = new RewriteResult.SortOrder("MILEAGE_HIGHEST", 18, "MileageHighest");
            YEAR_LOWEST = new RewriteResult.SortOrder("YEAR_LOWEST", 19, "YearLowest");
            YEAR_HIGHEST = new RewriteResult.SortOrder("YEAR_HIGHEST", 20, "YearHighest");
            DATE_LISTED_OLDEST_FIRST = new RewriteResult.SortOrder("DATE_LISTED_OLDEST_FIRST", 21, "DateListedOldestFirst");
            END_DATE_RECENT = new RewriteResult.SortOrder("END_DATE_RECENT", 22, "EndDateRecent");
            $VALUES = (new RewriteResult.SortOrder[] {
                UNKNOWN, BEST_MATCH, CURRENT_PRICE_LOWEST, CURRENT_PRICE_HIGHEST, DISTANCE_NEAREST, END_TIME_SOONEST, PRICE_PLUS_SHIPPING_LOWEST, PRICE_PLUS_SHIPPING_HIGHEST, START_TIME_NEWEST, BID_COUNT_MOST, 
                BID_COUNT_FEWEST, COUNTRY_ASCENDING, COUNTRY_DESCENDING, CONDITION_NEW_FIRST, CONDITION_USED_FIRST, COUNTRY_REGION_DOWN, COUNTRY_REGION_UP, MILEAGE_LOWEST, MILEAGE_HIGHEST, YEAR_LOWEST, 
                YEAR_HIGHEST, DATE_LISTED_OLDEST_FIRST, END_DATE_RECENT
            });
        }

        private RewriteResult.SortOrder(String s, int i, String s1)
        {
            super(s, i);
            apiName = s1;
        }
    }

    public static class RewriteResult.SortOrderDifference
    {

        RewriteResult.SortOrder add;
        RewriteResult.SortOrder remove;

        public RewriteResult.SortOrderDifference()
        {
            add = RewriteResult.SortOrder.UNKNOWN;
            remove = RewriteResult.SortOrder.UNKNOWN;
        }
    }


    public List rewriteResults;
    public String type;

    public Rewrite()
    {
    }
}
