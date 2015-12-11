// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.events;

import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.datamapping.DataMapperFactory;
import com.ebay.nautilus.domain.net.ApiSettings;
import com.ebay.nautilus.domain.net.EbayCosRequest;
import com.ebay.nautilus.kernel.net.Response;
import com.google.gson.Gson;
import java.net.URL;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.net.api.events:
//            EventItemsResponse

public class EventItemsRequest extends EbayCosRequest
{
    public static class AspectConstraint
    {

        public String name;
        public List value;

        public AspectConstraint()
        {
        }
    }

    public static class AspectScope
    {

        public String type;
        public String value;

        public AspectScope()
        {
        }
    }

    public static class AttributeNameValue
    {

        public String name;
        public String value;

        public AttributeNameValue()
        {
        }
    }

    public static final class ConstraintType extends Enum
    {

        private static final ConstraintType $VALUES[];
        public static final ConstraintType AuthorizedSellerOnly;
        public static final ConstraintType AvailableTo;
        public static final ConstraintType BestOfferOnly;
        public static final ConstraintType CashOnDelivery;
        public static final ConstraintType CharityOnly;
        public static final ConstraintType CompletedListingsOnly;
        public static final ConstraintType EbayNowDelivery;
        public static final ConstraintType EndEventDate;
        public static final ConstraintType EndTimeFrom;
        public static final ConstraintType EndTimeMoreThanHours;
        public static final ConstraintType EndTimeTo;
        public static final ConstraintType EndTimeWithinHours;
        public static final ConstraintType ExcludeLocalPickupItems;
        public static final ConstraintType ExcludeSeller;
        public static final ConstraintType ExpeditedShippingType;
        public static final ConstraintType FreeShippingOnly;
        public static final ConstraintType GetItFastOnly;
        public static final ConstraintType IncludeLocalOnlyItems;
        public static final ConstraintType IncludeSeller;
        public static final ConstraintType IntermediatedShippingOnly;
        public static final ConstraintType ItemCondition;
        public static final ConstraintType ListingType;
        public static final ConstraintType LocalMerchantStorePickupOnly;
        public static final ConstraintType LocalPickupOnly;
        public static final ConstraintType LocatedIn;
        public static final ConstraintType LockerPickUpOption;
        public static final ConstraintType LotsOnly;
        public static final ConstraintType MaxBids;
        public static final ConstraintType MaxDistance;
        public static final ConstraintType MaxHandlingTime;
        public static final ConstraintType MaxPrice;
        public static final ConstraintType MaxQuantity;
        public static final ConstraintType MinBids;
        public static final ConstraintType MinPrice;
        public static final ConstraintType MinQuantity;
        public static final ConstraintType NoReservePrice;
        public static final ConstraintType NotLocatedIn;
        public static final ConstraintType NumberOfReturnDays;
        public static final ConstraintType OneDayHandling;
        public static final ConstraintType OnePaisaAuction;
        public static final ConstraintType OutletSellerOnly;
        public static final ConstraintType PaymentMethod;
        public static final ConstraintType PreferredItemLocation;
        public static final ConstraintType PreferredLocation;
        public static final ConstraintType PromotionSale;
        public static final ConstraintType PromotionalRebates;
        public static final ConstraintType ReturnsAcceptedOnly;
        public static final ConstraintType SellerBusinessType;
        public static final ConstraintType SellerOffer;
        public static final ConstraintType SellersWithStore;
        public static final ConstraintType SoldItemsOnly;
        public static final ConstraintType StartEventDate;
        public static final ConstraintType StartTimeFrom;
        public static final ConstraintType StartTimeTo;
        public static final ConstraintType StartTimeWithinHours;
        public static final ConstraintType TopRatedSellersOnly;

        public static ConstraintType valueOf(String s)
        {
            return (ConstraintType)Enum.valueOf(com/ebay/nautilus/domain/net/api/events/EventItemsRequest$ConstraintType, s);
        }

        public static ConstraintType[] values()
        {
            return (ConstraintType[])$VALUES.clone();
        }

        static 
        {
            ItemCondition = new ConstraintType("ItemCondition", 0);
            EndTimeFrom = new ConstraintType("EndTimeFrom", 1);
            EndTimeTo = new ConstraintType("EndTimeTo", 2);
            BestOfferOnly = new ConstraintType("BestOfferOnly", 3);
            FreeShippingOnly = new ConstraintType("FreeShippingOnly", 4);
            GetItFastOnly = new ConstraintType("GetItFastOnly", 5);
            AvailableTo = new ConstraintType("AvailableTo", 6);
            LocatedIn = new ConstraintType("LocatedIn", 7);
            PreferredLocation = new ConstraintType("PreferredLocation", 8);
            LocalPickupOnly = new ConstraintType("LocalPickupOnly", 9);
            ListingType = new ConstraintType("ListingType", 10);
            LotsOnly = new ConstraintType("LotsOnly", 11);
            MaxBids = new ConstraintType("MaxBids", 12);
            MinBids = new ConstraintType("MinBids", 13);
            MaxPrice = new ConstraintType("MaxPrice", 14);
            MinPrice = new ConstraintType("MinPrice", 15);
            PaymentMethod = new ConstraintType("PaymentMethod", 16);
            MaxQuantity = new ConstraintType("MaxQuantity", 17);
            MinQuantity = new ConstraintType("MinQuantity", 18);
            IncludeSeller = new ConstraintType("IncludeSeller", 19);
            ExcludeSeller = new ConstraintType("ExcludeSeller", 20);
            SellersWithStore = new ConstraintType("SellersWithStore", 21);
            MaxDistance = new ConstraintType("MaxDistance", 22);
            SellerBusinessType = new ConstraintType("SellerBusinessType", 23);
            TopRatedSellersOnly = new ConstraintType("TopRatedSellersOnly", 24);
            SoldItemsOnly = new ConstraintType("SoldItemsOnly", 25);
            CharityOnly = new ConstraintType("CharityOnly", 26);
            OneDayHandling = new ConstraintType("OneDayHandling", 27);
            ExpeditedShippingType = new ConstraintType("ExpeditedShippingType", 28);
            MaxHandlingTime = new ConstraintType("MaxHandlingTime", 29);
            ReturnsAcceptedOnly = new ConstraintType("ReturnsAcceptedOnly", 30);
            OutletSellerOnly = new ConstraintType("OutletSellerOnly", 31);
            AuthorizedSellerOnly = new ConstraintType("AuthorizedSellerOnly", 32);
            StartTimeFrom = new ConstraintType("StartTimeFrom", 33);
            StartTimeTo = new ConstraintType("StartTimeTo", 34);
            CompletedListingsOnly = new ConstraintType("CompletedListingsOnly", 35);
            CashOnDelivery = new ConstraintType("CashOnDelivery", 36);
            OnePaisaAuction = new ConstraintType("OnePaisaAuction", 37);
            PromotionSale = new ConstraintType("PromotionSale", 38);
            EndTimeWithinHours = new ConstraintType("EndTimeWithinHours", 39);
            EndTimeMoreThanHours = new ConstraintType("EndTimeMoreThanHours", 40);
            StartTimeWithinHours = new ConstraintType("StartTimeWithinHours", 41);
            StartEventDate = new ConstraintType("StartEventDate", 42);
            EndEventDate = new ConstraintType("EndEventDate", 43);
            PromotionalRebates = new ConstraintType("PromotionalRebates", 44);
            NoReservePrice = new ConstraintType("NoReservePrice", 45);
            LocalMerchantStorePickupOnly = new ConstraintType("LocalMerchantStorePickupOnly", 46);
            EbayNowDelivery = new ConstraintType("EbayNowDelivery", 47);
            PreferredItemLocation = new ConstraintType("PreferredItemLocation", 48);
            NotLocatedIn = new ConstraintType("NotLocatedIn", 49);
            SellerOffer = new ConstraintType("SellerOffer", 50);
            IncludeLocalOnlyItems = new ConstraintType("IncludeLocalOnlyItems", 51);
            ExcludeLocalPickupItems = new ConstraintType("ExcludeLocalPickupItems", 52);
            IntermediatedShippingOnly = new ConstraintType("IntermediatedShippingOnly", 53);
            LockerPickUpOption = new ConstraintType("LockerPickUpOption", 54);
            NumberOfReturnDays = new ConstraintType("NumberOfReturnDays", 55);
            $VALUES = (new ConstraintType[] {
                ItemCondition, EndTimeFrom, EndTimeTo, BestOfferOnly, FreeShippingOnly, GetItFastOnly, AvailableTo, LocatedIn, PreferredLocation, LocalPickupOnly, 
                ListingType, LotsOnly, MaxBids, MinBids, MaxPrice, MinPrice, PaymentMethod, MaxQuantity, MinQuantity, IncludeSeller, 
                ExcludeSeller, SellersWithStore, MaxDistance, SellerBusinessType, TopRatedSellersOnly, SoldItemsOnly, CharityOnly, OneDayHandling, ExpeditedShippingType, MaxHandlingTime, 
                ReturnsAcceptedOnly, OutletSellerOnly, AuthorizedSellerOnly, StartTimeFrom, StartTimeTo, CompletedListingsOnly, CashOnDelivery, OnePaisaAuction, PromotionSale, EndTimeWithinHours, 
                EndTimeMoreThanHours, StartTimeWithinHours, StartEventDate, EndEventDate, PromotionalRebates, NoReservePrice, LocalMerchantStorePickupOnly, EbayNowDelivery, PreferredItemLocation, NotLocatedIn, 
                SellerOffer, IncludeLocalOnlyItems, ExcludeLocalPickupItems, IntermediatedShippingOnly, LockerPickUpOption, NumberOfReturnDays
            });
        }

        private ConstraintType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class EventRequestParams
    {

        public final SearchConstraints constraints;
        public final String eventId;
        public final OutputSelectors outputSelectors;
        public final PaginationInput paginationInput;
        public final int siteId;
        public final SortOrder sortOrder;

        public EventRequestParams(String s, int i, PaginationInput paginationinput, SearchConstraints searchconstraints, OutputSelectors outputselectors, SortOrder sortorder)
        {
            eventId = s;
            siteId = i;
            paginationInput = paginationinput;
            constraints = searchconstraints;
            outputSelectors = outputselectors;
            sortOrder = sortorder;
        }
    }

    public static class GlobalAspectConstraint
    {

        public ConstraintType constraintType;
        public List paramNameValue;
        public List value;

        public GlobalAspectConstraint()
        {
        }
    }

    public static final class HistogramSelector extends Enum
    {

        private static final HistogramSelector $VALUES[];
        public static final HistogramSelector ASPECT_HISTOGRAM;
        public static final HistogramSelector CATEGORY_HISTOGRAM;

        public static HistogramSelector valueOf(String s)
        {
            return (HistogramSelector)Enum.valueOf(com/ebay/nautilus/domain/net/api/events/EventItemsRequest$HistogramSelector, s);
        }

        public static HistogramSelector[] values()
        {
            return (HistogramSelector[])$VALUES.clone();
        }

        static 
        {
            CATEGORY_HISTOGRAM = new HistogramSelector("CATEGORY_HISTOGRAM", 0);
            ASPECT_HISTOGRAM = new HistogramSelector("ASPECT_HISTOGRAM", 1);
            $VALUES = (new HistogramSelector[] {
                CATEGORY_HISTOGRAM, ASPECT_HISTOGRAM
            });
        }

        private HistogramSelector(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class OutputSelector extends Enum
    {

        private static final OutputSelector $VALUES[];
        public static final OutputSelector itemWithShippingInfo;

        public static OutputSelector valueOf(String s)
        {
            return (OutputSelector)Enum.valueOf(com/ebay/nautilus/domain/net/api/events/EventItemsRequest$OutputSelector, s);
        }

        public static OutputSelector[] values()
        {
            return (OutputSelector[])$VALUES.clone();
        }

        static 
        {
            itemWithShippingInfo = new OutputSelector("itemWithShippingInfo", 0);
            $VALUES = (new OutputSelector[] {
                itemWithShippingInfo
            });
        }

        private OutputSelector(String s, int i)
        {
            super(s, i);
        }
    }

    public static class OutputSelectors
    {

        public List HISTOGRAMS;
        public List OUTPUT_SELECTOR;

        public OutputSelectors()
        {
        }
    }

    public static final class PaginationInput
    {

        public final int entriesPerPage;
        public final int minEntries;
        public final int pageNumber;

        public PaginationInput(int i, int j, int k)
        {
            entriesPerPage = i;
            pageNumber = j;
            minEntries = k;
        }
    }

    public static class ScopedAspectConstraint
    {

        public AspectConstraint aspect;
        public AspectScope scope;

        public ScopedAspectConstraint()
        {
        }
    }

    public static final class SearchConstraints
    {

        public List globalAspect;
        public List scopedAspect;

        public SearchConstraints()
        {
        }
    }

    public static final class SortOrder extends Enum
    {

        private static final SortOrder $VALUES[];
        public static final SortOrder BestMatch;
        public static final SortOrder BidCountFewest;
        public static final SortOrder BidCountMost;
        public static final SortOrder ConditionNewFirst;
        public static final SortOrder ConditionUsedFirst;
        public static final SortOrder CountryAscending;
        public static final SortOrder CountryDescending;
        public static final SortOrder CountryRegionDown;
        public static final SortOrder CountryRegionUp;
        public static final SortOrder CurrentPriceHighest;
        public static final SortOrder CurrentPriceLowest;
        public static final SortOrder DateListedOldestFirst;
        public static final SortOrder DistanceNearest;
        public static final SortOrder EndDateRecent;
        public static final SortOrder EndTimeSoonest;
        public static final SortOrder MileageHighest;
        public static final SortOrder MileageLowest;
        public static final SortOrder None;
        public static final SortOrder PricePlusShippingHighest;
        public static final SortOrder PricePlusShippingLowest;
        public static final SortOrder StartTimeNewest;
        public static final SortOrder YearHighest;
        public static final SortOrder YearLowest;

        public static SortOrder valueOf(String s)
        {
            return (SortOrder)Enum.valueOf(com/ebay/nautilus/domain/net/api/events/EventItemsRequest$SortOrder, s);
        }

        public static SortOrder[] values()
        {
            return (SortOrder[])$VALUES.clone();
        }

        static 
        {
            None = new SortOrder("None", 0);
            BestMatch = new SortOrder("BestMatch", 1);
            CurrentPriceLowest = new SortOrder("CurrentPriceLowest", 2);
            CurrentPriceHighest = new SortOrder("CurrentPriceHighest", 3);
            DistanceNearest = new SortOrder("DistanceNearest", 4);
            EndTimeSoonest = new SortOrder("EndTimeSoonest", 5);
            PricePlusShippingLowest = new SortOrder("PricePlusShippingLowest", 6);
            PricePlusShippingHighest = new SortOrder("PricePlusShippingHighest", 7);
            StartTimeNewest = new SortOrder("StartTimeNewest", 8);
            BidCountMost = new SortOrder("BidCountMost", 9);
            BidCountFewest = new SortOrder("BidCountFewest", 10);
            CountryAscending = new SortOrder("CountryAscending", 11);
            CountryDescending = new SortOrder("CountryDescending", 12);
            ConditionNewFirst = new SortOrder("ConditionNewFirst", 13);
            ConditionUsedFirst = new SortOrder("ConditionUsedFirst", 14);
            CountryRegionDown = new SortOrder("CountryRegionDown", 15);
            CountryRegionUp = new SortOrder("CountryRegionUp", 16);
            MileageLowest = new SortOrder("MileageLowest", 17);
            MileageHighest = new SortOrder("MileageHighest", 18);
            YearLowest = new SortOrder("YearLowest", 19);
            YearHighest = new SortOrder("YearHighest", 20);
            DateListedOldestFirst = new SortOrder("DateListedOldestFirst", 21);
            EndDateRecent = new SortOrder("EndDateRecent", 22);
            $VALUES = (new SortOrder[] {
                None, BestMatch, CurrentPriceLowest, CurrentPriceHighest, DistanceNearest, EndTimeSoonest, PricePlusShippingLowest, PricePlusShippingHighest, StartTimeNewest, BidCountMost, 
                BidCountFewest, CountryAscending, CountryDescending, ConditionNewFirst, ConditionUsedFirst, CountryRegionDown, CountryRegionUp, MileageLowest, MileageHighest, YearLowest, 
                YearHighest, DateListedOldestFirst, EndDateRecent
            });
        }

        private SortOrder(String s, int i)
        {
            super(s, i);
        }
    }


    public static final String OPERATION_NAME = "finditems";
    public static final String SERVICE_NAME = "rps";
    private EventRequestParams eventRequestParams;

    public EventItemsRequest(EbayCountry ebaycountry, EventRequestParams eventrequestparams)
    {
        super("rps", "finditems");
        requestBodyContentType = "application/json";
        responseBodyContentType = "application/json";
        if (ebaycountry != null)
        {
            territory = ebaycountry.getCountryCode();
            marketPlaceId = ebaycountry.getSiteGlobalId();
        }
        eventRequestParams = eventrequestparams;
    }

    public byte[] buildRequest()
        throws com.ebay.nautilus.kernel.net.Connector.BuildRequestDataException
    {
        return DataMapperFactory.getDefaultMapper().toJson(eventRequestParams).getBytes();
    }

    public String getHttpMethod()
    {
        return "POST";
    }

    public URL getRequestUrl()
    {
        return ApiSettings.getUrl(ApiSettings.eventsService);
    }

    public EventItemsResponse getResponse()
    {
        return new EventItemsResponse();
    }

    public volatile Response getResponse()
    {
        return getResponse();
    }

    protected boolean isIdempotent()
    {
        return true;
    }
}
