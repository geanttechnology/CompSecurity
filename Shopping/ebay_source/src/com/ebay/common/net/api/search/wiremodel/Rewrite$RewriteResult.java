// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search.wiremodel;

import java.util.List;

// Referenced classes of package com.ebay.common.net.api.search.wiremodel:
//            Rewrite

public static class SortOrder.UNKNOWN
{
    public static class AspectContstraint
    {

        String name;
        List value;

        public AspectContstraint()
        {
        }
    }

    public static class AspectScope
    {

        String type;
        String value;

        public AspectScope()
        {
        }
    }

    public static class AttributeNameValue
    {

        String name;
        String value;

        public AttributeNameValue()
        {
        }
    }

    public static class Category
    {

        String applied;
        CategoryGroup categoryGroup;
        public long id;
        String leafCategory;
        int level;
        public String localizedName;
        public String name;
        Category parentCategory;

        public Category()
        {
            categoryGroup = CategoryGroup.OTHER;
        }
    }

    public static class CategoryDifference
    {

        public List add;
        public List remove;

        public CategoryDifference()
        {
        }
    }

    public static final class CategoryGroup extends Enum
    {

        private static final CategoryGroup $VALUES[];
        public static final CategoryGroup OTHER;
        public static final CategoryGroup PRIMARY;
        public static final CategoryGroup SECONDARY;

        public static CategoryGroup valueOf(String s)
        {
            return (CategoryGroup)Enum.valueOf(com/ebay/common/net/api/search/wiremodel/Rewrite$RewriteResult$CategoryGroup, s);
        }

        public static CategoryGroup[] values()
        {
            return (CategoryGroup[])$VALUES.clone();
        }

        static 
        {
            PRIMARY = new CategoryGroup("PRIMARY", 0);
            SECONDARY = new CategoryGroup("SECONDARY", 1);
            OTHER = new CategoryGroup("OTHER", 2);
            $VALUES = (new CategoryGroup[] {
                PRIMARY, SECONDARY, OTHER
            });
        }

        private CategoryGroup(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class ConstraintType extends Enum
    {

        private static final ConstraintType $VALUES[];
        public static final ConstraintType AUTHORIZED_SELLER_ONLY;
        public static final ConstraintType AVAILABLE_TO;
        public static final ConstraintType BEST_OFFER_ONLY;
        public static final ConstraintType CASH_ON_DELIVERY;
        public static final ConstraintType CHARITY_ONLY;
        public static final ConstraintType COMPLETED_LISTINGS_ONLY;
        public static final ConstraintType EBAY_NOW_DELIVERY;
        public static final ConstraintType END_EVENT_DATE;
        public static final ConstraintType END_TIME_FROM;
        public static final ConstraintType END_TIME_MORE_THAN_HOURS;
        public static final ConstraintType END_TIME_TO;
        public static final ConstraintType END_TIME_WITHIN_HOURS;
        public static final ConstraintType EPID;
        public static final ConstraintType EXCLUDE_LOCAL_PICKUP_ITEMS;
        public static final ConstraintType EXCLUDE_SELLER;
        public static final ConstraintType EXPEDITED_SHIPPING_TYPE;
        public static final ConstraintType EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY;
        public static final ConstraintType FREE_SHIPPING_ONLY;
        public static final ConstraintType GET_IT_FAST_ONLY;
        public static final ConstraintType INCLUDE_LOCAL_ONLY_ITEMS;
        public static final ConstraintType INCLUDE_SELLER;
        public static final ConstraintType INTERMEDIATED_SHIPPING_ONLY;
        public static final ConstraintType ISBN;
        public static final ConstraintType ITEM_CONDITION;
        public static final ConstraintType LISTING_TYPE;
        public static final ConstraintType LOCAL_MERCHANT_STORE_PICKUP_ONLY;
        public static final ConstraintType LOCAL_PICKUP_ONLY;
        public static final ConstraintType LOCATED_IN;
        public static final ConstraintType LOCKER_PICKUP_OPTION;
        public static final ConstraintType LOTS_ONLY;
        public static final ConstraintType MAX_BIDS;
        public static final ConstraintType MAX_DISTANCE;
        public static final ConstraintType MAX_HANDLING_TIME;
        public static final ConstraintType MAX_PRICE;
        public static final ConstraintType MAX_QUANTITY;
        public static final ConstraintType MIN_BIDS;
        public static final ConstraintType MIN_PRICE;
        public static final ConstraintType MIN_QUANTITY;
        public static final ConstraintType MPN;
        public static final ConstraintType NOT_LOCATED_IN;
        public static final ConstraintType NO_RESERVE_PRICE;
        public static final ConstraintType NUMBER_OF_RETURN_DAYS;
        public static final ConstraintType ONE_DAY_HANDLING;
        public static final ConstraintType ONE_PAISA_AUCTION;
        public static final ConstraintType OUTLET_SELLER_ONLY;
        public static final ConstraintType PAYMENT_METHOD;
        public static final ConstraintType PREFERED_LOCATION;
        public static final ConstraintType PREFERRED_ITEM_LOCATION;
        public static final ConstraintType PROMOTIONAL_REBATES;
        public static final ConstraintType PROMOTION_SALE;
        public static final ConstraintType RETURNS_ACCEPTED_ONLY;
        public static final ConstraintType SELLER_BUSINESS_TYPE;
        public static final ConstraintType SELLER_OFFER;
        public static final ConstraintType SELLER_PRODUCT_ID;
        public static final ConstraintType SELLER_WITH_STORE;
        public static final ConstraintType SOLD_ITEMS_ONLY;
        public static final ConstraintType START_EVENT_DATE;
        public static final ConstraintType START_TIME_FROM;
        public static final ConstraintType START_TIME_TO;
        public static final ConstraintType START_TIME_WITHIN_HOURS;
        public static final ConstraintType TOP_RATED_SELLERS_ONLY;
        public static final ConstraintType UNKOWN;
        public static final ConstraintType UPC;
        String apiName;

        public static ConstraintType valueOf(String s)
        {
            return (ConstraintType)Enum.valueOf(com/ebay/common/net/api/search/wiremodel/Rewrite$RewriteResult$ConstraintType, s);
        }

        public static ConstraintType[] values()
        {
            return (ConstraintType[])$VALUES.clone();
        }

        static 
        {
            UNKOWN = new ConstraintType("UNKOWN", 0, "Unknown");
            ITEM_CONDITION = new ConstraintType("ITEM_CONDITION", 1, "ItemCondition");
            END_TIME_FROM = new ConstraintType("END_TIME_FROM", 2, "EndTimeFrom");
            END_TIME_TO = new ConstraintType("END_TIME_TO", 3, "EndTimeTo");
            BEST_OFFER_ONLY = new ConstraintType("BEST_OFFER_ONLY", 4, "BestOfferOnly");
            FREE_SHIPPING_ONLY = new ConstraintType("FREE_SHIPPING_ONLY", 5, "FreeShippingOnly");
            GET_IT_FAST_ONLY = new ConstraintType("GET_IT_FAST_ONLY", 6, "GetItFastOnly");
            AVAILABLE_TO = new ConstraintType("AVAILABLE_TO", 7, "AvailableTo");
            LOCATED_IN = new ConstraintType("LOCATED_IN", 8, "LocatedIn");
            PREFERED_LOCATION = new ConstraintType("PREFERED_LOCATION", 9, "PreferredLocation");
            LOCAL_PICKUP_ONLY = new ConstraintType("LOCAL_PICKUP_ONLY", 10, "LocalPickupOnly");
            LISTING_TYPE = new ConstraintType("LISTING_TYPE", 11, "ListingType");
            LOTS_ONLY = new ConstraintType("LOTS_ONLY", 12, "LotsOnly");
            MAX_BIDS = new ConstraintType("MAX_BIDS", 13, "MaxBids");
            MIN_BIDS = new ConstraintType("MIN_BIDS", 14, "MinBids");
            MAX_PRICE = new ConstraintType("MAX_PRICE", 15, "MaxPrice");
            MIN_PRICE = new ConstraintType("MIN_PRICE", 16, "MinPrice");
            PAYMENT_METHOD = new ConstraintType("PAYMENT_METHOD", 17, "PaymentMethod");
            MAX_QUANTITY = new ConstraintType("MAX_QUANTITY", 18, "MaxQuantity");
            MIN_QUANTITY = new ConstraintType("MIN_QUANTITY", 19, "MinQuantity");
            INCLUDE_SELLER = new ConstraintType("INCLUDE_SELLER", 20, "IncludeSeller");
            EXCLUDE_SELLER = new ConstraintType("EXCLUDE_SELLER", 21, "ExcludeSeller");
            SELLER_WITH_STORE = new ConstraintType("SELLER_WITH_STORE", 22, "SellersWithStore");
            MAX_DISTANCE = new ConstraintType("MAX_DISTANCE", 23, "MaxDistance");
            SELLER_BUSINESS_TYPE = new ConstraintType("SELLER_BUSINESS_TYPE", 24, "SellerBusinessType");
            TOP_RATED_SELLERS_ONLY = new ConstraintType("TOP_RATED_SELLERS_ONLY", 25, "TopRatedSellersOnly");
            SOLD_ITEMS_ONLY = new ConstraintType("SOLD_ITEMS_ONLY", 26, "SoldItemsOnly");
            CHARITY_ONLY = new ConstraintType("CHARITY_ONLY", 27, "CharityOnly");
            ONE_DAY_HANDLING = new ConstraintType("ONE_DAY_HANDLING", 28, "OneDayHandling");
            EXPEDITED_SHIPPING_TYPE = new ConstraintType("EXPEDITED_SHIPPING_TYPE", 29, "ExpeditedShippingType");
            MAX_HANDLING_TIME = new ConstraintType("MAX_HANDLING_TIME", 30, "MaxHandlingTime");
            RETURNS_ACCEPTED_ONLY = new ConstraintType("RETURNS_ACCEPTED_ONLY", 31, "ReturnsAcceptedOnly");
            OUTLET_SELLER_ONLY = new ConstraintType("OUTLET_SELLER_ONLY", 32, "OutletSellerOnly");
            AUTHORIZED_SELLER_ONLY = new ConstraintType("AUTHORIZED_SELLER_ONLY", 33, "AuthorizedSellerOnly");
            START_TIME_FROM = new ConstraintType("START_TIME_FROM", 34, "StartTimeFrom");
            START_TIME_TO = new ConstraintType("START_TIME_TO", 35, "StartTimeTo");
            COMPLETED_LISTINGS_ONLY = new ConstraintType("COMPLETED_LISTINGS_ONLY", 36, "CompletedListingsOnly");
            CASH_ON_DELIVERY = new ConstraintType("CASH_ON_DELIVERY", 37, "CashOnDelivery");
            ONE_PAISA_AUCTION = new ConstraintType("ONE_PAISA_AUCTION", 38, "OnePaisaAuction");
            PROMOTION_SALE = new ConstraintType("PROMOTION_SALE", 39, "PromotionSale");
            END_TIME_WITHIN_HOURS = new ConstraintType("END_TIME_WITHIN_HOURS", 40, "EndTimeWithinHours");
            END_TIME_MORE_THAN_HOURS = new ConstraintType("END_TIME_MORE_THAN_HOURS", 41, "EndTimeMoreThanHours");
            START_TIME_WITHIN_HOURS = new ConstraintType("START_TIME_WITHIN_HOURS", 42, "StartTimeWithinHours");
            START_EVENT_DATE = new ConstraintType("START_EVENT_DATE", 43, "StartEventDate");
            END_EVENT_DATE = new ConstraintType("END_EVENT_DATE", 44, "EndEventDate");
            PROMOTIONAL_REBATES = new ConstraintType("PROMOTIONAL_REBATES", 45, "PromotionalRebates");
            NO_RESERVE_PRICE = new ConstraintType("NO_RESERVE_PRICE", 46, "NoReservePrice");
            LOCAL_MERCHANT_STORE_PICKUP_ONLY = new ConstraintType("LOCAL_MERCHANT_STORE_PICKUP_ONLY", 47, "LocalMerchantStorePickupOnly");
            EBAY_NOW_DELIVERY = new ConstraintType("EBAY_NOW_DELIVERY", 48, "EbayNowDelivery");
            PREFERRED_ITEM_LOCATION = new ConstraintType("PREFERRED_ITEM_LOCATION", 49, "PreferredItemLocation");
            NOT_LOCATED_IN = new ConstraintType("NOT_LOCATED_IN", 50, "NotLocatedIn");
            SELLER_OFFER = new ConstraintType("SELLER_OFFER", 51, "SellerOffer");
            INCLUDE_LOCAL_ONLY_ITEMS = new ConstraintType("INCLUDE_LOCAL_ONLY_ITEMS", 52, "IncludeLocalOnlyItems");
            EXCLUDE_LOCAL_PICKUP_ITEMS = new ConstraintType("EXCLUDE_LOCAL_PICKUP_ITEMS", 53, "ExcludeLocalPickupItems");
            INTERMEDIATED_SHIPPING_ONLY = new ConstraintType("INTERMEDIATED_SHIPPING_ONLY", 54, "IntermediatedShippingOnly");
            LOCKER_PICKUP_OPTION = new ConstraintType("LOCKER_PICKUP_OPTION", 55, "LockerPickUpOption");
            NUMBER_OF_RETURN_DAYS = new ConstraintType("NUMBER_OF_RETURN_DAYS", 56, "NumberOfReturnDays");
            EPID = new ConstraintType("EPID", 57, "EPID");
            UPC = new ConstraintType("UPC", 58, "UPC");
            MPN = new ConstraintType("MPN", 59, "MPN");
            ISBN = new ConstraintType("ISBN", 60, "ISBN");
            SELLER_PRODUCT_ID = new ConstraintType("SELLER_PRODUCT_ID", 61, "SellerProductId");
            EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY = new ConstraintType("EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY", 62, "ExtendedHolidayReturnsEligibleOnly");
            $VALUES = (new ConstraintType[] {
                UNKOWN, ITEM_CONDITION, END_TIME_FROM, END_TIME_TO, BEST_OFFER_ONLY, FREE_SHIPPING_ONLY, GET_IT_FAST_ONLY, AVAILABLE_TO, LOCATED_IN, PREFERED_LOCATION, 
                LOCAL_PICKUP_ONLY, LISTING_TYPE, LOTS_ONLY, MAX_BIDS, MIN_BIDS, MAX_PRICE, MIN_PRICE, PAYMENT_METHOD, MAX_QUANTITY, MIN_QUANTITY, 
                INCLUDE_SELLER, EXCLUDE_SELLER, SELLER_WITH_STORE, MAX_DISTANCE, SELLER_BUSINESS_TYPE, TOP_RATED_SELLERS_ONLY, SOLD_ITEMS_ONLY, CHARITY_ONLY, ONE_DAY_HANDLING, EXPEDITED_SHIPPING_TYPE, 
                MAX_HANDLING_TIME, RETURNS_ACCEPTED_ONLY, OUTLET_SELLER_ONLY, AUTHORIZED_SELLER_ONLY, START_TIME_FROM, START_TIME_TO, COMPLETED_LISTINGS_ONLY, CASH_ON_DELIVERY, ONE_PAISA_AUCTION, PROMOTION_SALE, 
                END_TIME_WITHIN_HOURS, END_TIME_MORE_THAN_HOURS, START_TIME_WITHIN_HOURS, START_EVENT_DATE, END_EVENT_DATE, PROMOTIONAL_REBATES, NO_RESERVE_PRICE, LOCAL_MERCHANT_STORE_PICKUP_ONLY, EBAY_NOW_DELIVERY, PREFERRED_ITEM_LOCATION, 
                NOT_LOCATED_IN, SELLER_OFFER, INCLUDE_LOCAL_ONLY_ITEMS, EXCLUDE_LOCAL_PICKUP_ITEMS, INTERMEDIATED_SHIPPING_ONLY, LOCKER_PICKUP_OPTION, NUMBER_OF_RETURN_DAYS, EPID, UPC, MPN, 
                ISBN, SELLER_PRODUCT_ID, EXTENDED_HOLIDAY_RETURNS_ELIGIBLE_ONLY
            });
        }

        private ConstraintType(String s, int i, String s1)
        {
            super(s, i);
            apiName = s1;
        }
    }

    public static class GlobalAspectConstraint
    {

        ConstraintType constraintType;
        List paramNameValue;
        List value;

        public GlobalAspectConstraint()
        {
            constraintType = ConstraintType.UNKOWN;
        }
    }

    public static class GlobalAspectDifference
    {

        List add;
        List remove;

        public GlobalAspectDifference()
        {
        }
    }

    public static class KeywordDifference
    {

        String add;
        String remove;

        public KeywordDifference()
        {
        }
    }

    public static class Location
    {

        String city;
        String country;
        String postalCode;
        String stateOrProvince;
        String stateOrProvinceFullName;

        public Location()
        {
        }
    }

    public static class RewriteInfo
    {

        public List categoryPaths;

        public RewriteInfo()
        {
        }
    }

    public static class ScopedAspectConstraint
    {

        AspectContstraint aspect;
        AspectScope scope;

        public ScopedAspectConstraint()
        {
        }
    }

    public static class ScopedAspectDifference
    {

        List add;
        List remove;

        public ScopedAspectDifference()
        {
        }
    }

    public static class SearchRequest
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
        public Location shipToLocation;
        public SortOrder sortOrder;
        public UserContext userContext;

        public SearchRequest()
        {
            sortOrder = SortOrder.UNKNOWN;
        }
    }

    static class SearchRequest.Feature
    {

        String name;
        List value;

        SearchRequest.Feature()
        {
        }
    }

    static class SearchRequest.OutputSelector
    {

        SearchRequest.OutputSelector()
        {
        }
    }

    static class SearchRequest.PaginationInput
    {

        int entriesPerPage;
        int pageNumber;
        int skipCount;

        SearchRequest.PaginationInput()
        {
        }
    }

    static class SearchRequest.SearchContraints
    {

        List globalAspect;
        List scopedAspect;

        SearchRequest.SearchContraints()
        {
        }
    }

    static final class SearchRequest.SearchScope extends Enum
    {

        private static final SearchRequest.SearchScope $VALUES[];
        public static final SearchRequest.SearchScope ITEM_TITLE_AND_DESCRIPTION_SEARCH;
        public static final SearchRequest.SearchScope ITEM_TITLE_SEARCH;
        String apiName;

        public static SearchRequest.SearchScope valueOf(String s)
        {
            return (SearchRequest.SearchScope)Enum.valueOf(com/ebay/common/net/api/search/wiremodel/Rewrite$RewriteResult$SearchRequest$SearchScope, s);
        }

        public static SearchRequest.SearchScope[] values()
        {
            return (SearchRequest.SearchScope[])$VALUES.clone();
        }

        static 
        {
            ITEM_TITLE_SEARCH = new SearchRequest.SearchScope("ITEM_TITLE_SEARCH", 0, "ItemTitleSearch");
            ITEM_TITLE_AND_DESCRIPTION_SEARCH = new SearchRequest.SearchScope("ITEM_TITLE_AND_DESCRIPTION_SEARCH", 1, "ItemTitleAndDescriptionSearch");
            $VALUES = (new SearchRequest.SearchScope[] {
                ITEM_TITLE_SEARCH, ITEM_TITLE_AND_DESCRIPTION_SEARCH
            });
        }

        private SearchRequest.SearchScope(String s, int i, String s1)
        {
            super(s, i);
            apiName = s1;
        }
    }

    static class SearchRequest.UserContext
    {

        Location userLocation;

        SearchRequest.UserContext()
        {
        }
    }

    public static class SearchRequestDifference
    {

        public CategoryDifference categoryId;
        GlobalAspectDifference globalAspect;
        KeywordDifference keyword;
        ScopedAspectDifference scopedAspect;
        SortOrderDifference sortOrder;

        public SearchRequestDifference()
        {
        }
    }

    public static final class SortOrder extends Enum
    {

        private static final SortOrder $VALUES[];
        public static final SortOrder BEST_MATCH;
        public static final SortOrder BID_COUNT_FEWEST;
        public static final SortOrder BID_COUNT_MOST;
        public static final SortOrder CONDITION_NEW_FIRST;
        public static final SortOrder CONDITION_USED_FIRST;
        public static final SortOrder COUNTRY_ASCENDING;
        public static final SortOrder COUNTRY_DESCENDING;
        public static final SortOrder COUNTRY_REGION_DOWN;
        public static final SortOrder COUNTRY_REGION_UP;
        public static final SortOrder CURRENT_PRICE_HIGHEST;
        public static final SortOrder CURRENT_PRICE_LOWEST;
        public static final SortOrder DATE_LISTED_OLDEST_FIRST;
        public static final SortOrder DISTANCE_NEAREST;
        public static final SortOrder END_DATE_RECENT;
        public static final SortOrder END_TIME_SOONEST;
        public static final SortOrder MILEAGE_HIGHEST;
        public static final SortOrder MILEAGE_LOWEST;
        public static final SortOrder PRICE_PLUS_SHIPPING_HIGHEST;
        public static final SortOrder PRICE_PLUS_SHIPPING_LOWEST;
        public static final SortOrder START_TIME_NEWEST;
        public static final SortOrder UNKNOWN;
        public static final SortOrder YEAR_HIGHEST;
        public static final SortOrder YEAR_LOWEST;
        String apiName;

        public static SortOrder valueOf(String s)
        {
            return (SortOrder)Enum.valueOf(com/ebay/common/net/api/search/wiremodel/Rewrite$RewriteResult$SortOrder, s);
        }

        public static SortOrder[] values()
        {
            return (SortOrder[])$VALUES.clone();
        }

        static 
        {
            UNKNOWN = new SortOrder("UNKNOWN", 0, "Unknown");
            BEST_MATCH = new SortOrder("BEST_MATCH", 1, "BestMatch");
            CURRENT_PRICE_LOWEST = new SortOrder("CURRENT_PRICE_LOWEST", 2, "CurrentPriceLowest");
            CURRENT_PRICE_HIGHEST = new SortOrder("CURRENT_PRICE_HIGHEST", 3, "CurrentPriceHighest");
            DISTANCE_NEAREST = new SortOrder("DISTANCE_NEAREST", 4, "DistanceNearest");
            END_TIME_SOONEST = new SortOrder("END_TIME_SOONEST", 5, "EndTimeSoonest");
            PRICE_PLUS_SHIPPING_LOWEST = new SortOrder("PRICE_PLUS_SHIPPING_LOWEST", 6, "PricePlusShippingLowest");
            PRICE_PLUS_SHIPPING_HIGHEST = new SortOrder("PRICE_PLUS_SHIPPING_HIGHEST", 7, "PricePlusShippingHighest");
            START_TIME_NEWEST = new SortOrder("START_TIME_NEWEST", 8, "StartTimeNewest");
            BID_COUNT_MOST = new SortOrder("BID_COUNT_MOST", 9, "BidCountMost");
            BID_COUNT_FEWEST = new SortOrder("BID_COUNT_FEWEST", 10, "BidCountFewest");
            COUNTRY_ASCENDING = new SortOrder("COUNTRY_ASCENDING", 11, "CountryAscending");
            COUNTRY_DESCENDING = new SortOrder("COUNTRY_DESCENDING", 12, "CountryDescending");
            CONDITION_NEW_FIRST = new SortOrder("CONDITION_NEW_FIRST", 13, "ConditionNewFirst");
            CONDITION_USED_FIRST = new SortOrder("CONDITION_USED_FIRST", 14, "ConditionUsedFirst");
            COUNTRY_REGION_DOWN = new SortOrder("COUNTRY_REGION_DOWN", 15, "CountryRegionDown");
            COUNTRY_REGION_UP = new SortOrder("COUNTRY_REGION_UP", 16, "CountryRegionUp");
            MILEAGE_LOWEST = new SortOrder("MILEAGE_LOWEST", 17, "MileageLowest");
            MILEAGE_HIGHEST = new SortOrder("MILEAGE_HIGHEST", 18, "MileageHighest");
            YEAR_LOWEST = new SortOrder("YEAR_LOWEST", 19, "YearLowest");
            YEAR_HIGHEST = new SortOrder("YEAR_HIGHEST", 20, "YearHighest");
            DATE_LISTED_OLDEST_FIRST = new SortOrder("DATE_LISTED_OLDEST_FIRST", 21, "DateListedOldestFirst");
            END_DATE_RECENT = new SortOrder("END_DATE_RECENT", 22, "EndDateRecent");
            $VALUES = (new SortOrder[] {
                UNKNOWN, BEST_MATCH, CURRENT_PRICE_LOWEST, CURRENT_PRICE_HIGHEST, DISTANCE_NEAREST, END_TIME_SOONEST, PRICE_PLUS_SHIPPING_LOWEST, PRICE_PLUS_SHIPPING_HIGHEST, START_TIME_NEWEST, BID_COUNT_MOST, 
                BID_COUNT_FEWEST, COUNTRY_ASCENDING, COUNTRY_DESCENDING, CONDITION_NEW_FIRST, CONDITION_USED_FIRST, COUNTRY_REGION_DOWN, COUNTRY_REGION_UP, MILEAGE_LOWEST, MILEAGE_HIGHEST, YEAR_LOWEST, 
                YEAR_HIGHEST, DATE_LISTED_OLDEST_FIRST, END_DATE_RECENT
            });
        }

        private SortOrder(String s, int i, String s1)
        {
            super(s, i);
            apiName = s1;
        }
    }

    public static class SortOrderDifference
    {

        SortOrder add;
        SortOrder remove;

        public SortOrderDifference()
        {
            add = SortOrder.UNKNOWN;
            remove = SortOrder.UNKNOWN;
        }
    }


    public com.ebay.common.net.api.search.ionResult expansionResult;
    public List items;
    public long matchCount;
    public SearchRequest modifiedRequest;
    public SearchRequestDifference requestDifference;
    public RewriteInfo rewriteInfo;

    public SortOrder.UNKNOWN()
    {
    }
}
