// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import android.support.v4.util.ArrayMap;
import android.text.TextUtils;
import com.ebay.common.model.search.EbayAspectHistogram;
import com.ebay.common.model.search.EbayCategorySummary;
import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.common.net.api.search.SellerOfferParameters;
import com.ebay.nautilus.domain.EbayCountry;
import com.ebay.nautilus.domain.EbaySite;
import com.ebay.nautilus.domain.data.ItemCurrency;
import com.ebay.nautilus.kernel.cachemanager.CacheManager;
import com.ebay.nautilus.kernel.content.EbayContext;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class SaasSearchRequest
{
    public static class AspectConstraint
    {

        public String name;
        public List value;

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag;
            if (this == obj)
            {
                flag = true;
            } else
            {
                flag = flag1;
                if (obj != null)
                {
                    flag = flag1;
                    if (getClass() == obj.getClass())
                    {
                        obj = (AspectConstraint)obj;
                        flag = flag1;
                        if (name.equals(((AspectConstraint) (obj)).name))
                        {
                            return value.equals(((AspectConstraint) (obj)).value);
                        }
                    }
                }
            }
            return flag;
        }

        public int hashCode()
        {
            return name.hashCode() * 31 + value.hashCode();
        }

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

        public boolean equals(Object obj)
        {
            boolean flag1 = false;
            boolean flag;
            if (this == obj)
            {
                flag = true;
            } else
            {
                flag = flag1;
                if (obj != null)
                {
                    flag = flag1;
                    if (getClass() == obj.getClass())
                    {
                        obj = (AttributeNameValue)obj;
                        flag = flag1;
                        if (name.equals(((AttributeNameValue) (obj)).name))
                        {
                            return value.equals(((AttributeNameValue) (obj)).value);
                        }
                    }
                }
            }
            return flag;
        }

        public int hashCode()
        {
            return name.hashCode() * 31 + value.hashCode();
        }

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
        public static final ConstraintType EPID;
        public static final ConstraintType EbayNowDelivery;
        public static final ConstraintType EbayPlus;
        public static final ConstraintType EndEventDate;
        public static final ConstraintType EndTimeFrom;
        public static final ConstraintType EndTimeMoreThanHours;
        public static final ConstraintType EndTimeTo;
        public static final ConstraintType EndTimeWithinHours;
        public static final ConstraintType ExcludeLocalPickupItems;
        public static final ConstraintType ExcludeSeller;
        public static final ConstraintType ExpeditedShippingType;
        public static final ConstraintType ExtendedHolidayReturnsEligibleOnly;
        public static final ConstraintType FreeShippingOnly;
        public static final ConstraintType GetItFastOnly;
        public static final ConstraintType ISBN;
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
        public static final ConstraintType MPN;
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
        public static final ConstraintType SellerProductId;
        public static final ConstraintType SellersWithStore;
        public static final ConstraintType SoldItemsOnly;
        public static final ConstraintType StartEventDate;
        public static final ConstraintType StartTimeFrom;
        public static final ConstraintType StartTimeTo;
        public static final ConstraintType StartTimeWithinHours;
        public static final ConstraintType TopRatedSellersOnly;
        public static final ConstraintType UPC;

        public static ConstraintType valueOf(String s)
        {
            return (ConstraintType)Enum.valueOf(com/ebay/common/net/api/followinterest/SaasSearchRequest$ConstraintType, s);
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
            EPID = new ConstraintType("EPID", 56);
            UPC = new ConstraintType("UPC", 57);
            MPN = new ConstraintType("MPN", 58);
            ISBN = new ConstraintType("ISBN", 59);
            SellerProductId = new ConstraintType("SellerProductId", 60);
            ExtendedHolidayReturnsEligibleOnly = new ConstraintType("ExtendedHolidayReturnsEligibleOnly", 61);
            EbayPlus = new ConstraintType("EbayPlus", 62);
            $VALUES = (new ConstraintType[] {
                ItemCondition, EndTimeFrom, EndTimeTo, BestOfferOnly, FreeShippingOnly, GetItFastOnly, AvailableTo, LocatedIn, PreferredLocation, LocalPickupOnly, 
                ListingType, LotsOnly, MaxBids, MinBids, MaxPrice, MinPrice, PaymentMethod, MaxQuantity, MinQuantity, IncludeSeller, 
                ExcludeSeller, SellersWithStore, MaxDistance, SellerBusinessType, TopRatedSellersOnly, SoldItemsOnly, CharityOnly, OneDayHandling, ExpeditedShippingType, MaxHandlingTime, 
                ReturnsAcceptedOnly, OutletSellerOnly, AuthorizedSellerOnly, StartTimeFrom, StartTimeTo, CompletedListingsOnly, CashOnDelivery, OnePaisaAuction, PromotionSale, EndTimeWithinHours, 
                EndTimeMoreThanHours, StartTimeWithinHours, StartEventDate, EndEventDate, PromotionalRebates, NoReservePrice, LocalMerchantStorePickupOnly, EbayNowDelivery, PreferredItemLocation, NotLocatedIn, 
                SellerOffer, IncludeLocalOnlyItems, ExcludeLocalPickupItems, IntermediatedShippingOnly, LockerPickUpOption, NumberOfReturnDays, EPID, UPC, MPN, ISBN, 
                SellerProductId, ExtendedHolidayReturnsEligibleOnly, EbayPlus
            });
        }

        private ConstraintType(String s, int i)
        {
            super(s, i);
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

    public static class Location
    {

        public String country;
        public String postalCode;

        public Location()
        {
        }
    }

    public static class Location.Deserializer
        implements JsonDeserializer
    {

        public Location deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            type = (JsonObject)jsonelement;
            jsonelement = new Location();
            jsondeserializationcontext = type.get("country");
            if (jsondeserializationcontext != null)
            {
                jsonelement.country = jsondeserializationcontext.getAsString();
                if (TextUtils.isEmpty(((Location) (jsonelement)).country) || ((Location) (jsonelement)).country.equals("null") || ((Location) (jsonelement)).country.equals("NONE"))
                {
                    jsonelement.country = null;
                }
            }
            type = type.get("postalCode");
            if (type != null)
            {
                jsonelement.postalCode = type.getAsString();
                if (TextUtils.isEmpty(((Location) (jsonelement)).postalCode) || ((Location) (jsonelement)).postalCode.equals("null"))
                {
                    jsonelement.postalCode = null;
                }
            }
            return jsonelement;
        }

        public volatile Object deserialize(JsonElement jsonelement, Type type, JsonDeserializationContext jsondeserializationcontext)
            throws JsonParseException
        {
            return deserialize(jsonelement, type, jsondeserializationcontext);
        }

        public Location.Deserializer()
        {
        }
    }

    public static class PaginationInput
    {

        public Integer entriesPerPage;
        public Integer pageNumber;

        public PaginationInput()
        {
        }
    }

    public static class ScopedAspectConstraint
    {

        public List aspect;
        public AspectScope scope;

        public ScopedAspectConstraint()
        {
        }
    }

    public static class SearchConstraints
    {

        public List globalAspect;
        public List scopedAspect;

        public SearchConstraints()
        {
        }
    }

    public static final class SearchScope extends Enum
    {

        private static final SearchScope $VALUES[];
        public static final SearchScope ItemTitleAndDescriptionSearch;
        public static final SearchScope ItemTitleSearch;

        public static SearchScope valueOf(String s)
        {
            return (SearchScope)Enum.valueOf(com/ebay/common/net/api/followinterest/SaasSearchRequest$SearchScope, s);
        }

        public static SearchScope[] values()
        {
            return (SearchScope[])$VALUES.clone();
        }

        static 
        {
            ItemTitleSearch = new SearchScope("ItemTitleSearch", 0);
            ItemTitleAndDescriptionSearch = new SearchScope("ItemTitleAndDescriptionSearch", 1);
            $VALUES = (new SearchScope[] {
                ItemTitleSearch, ItemTitleAndDescriptionSearch
            });
        }

        private SearchScope(String s, int i)
        {
            super(s, i);
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
        public static final SortOrder PricePlusShippingHighest;
        public static final SortOrder PricePlusShippingLowest;
        public static final SortOrder StartTimeNewest;
        public static final SortOrder YearHighest;
        public static final SortOrder YearLowest;

        public static SortOrder valueOf(String s)
        {
            return (SortOrder)Enum.valueOf(com/ebay/common/net/api/followinterest/SaasSearchRequest$SortOrder, s);
        }

        public static SortOrder[] values()
        {
            return (SortOrder[])$VALUES.clone();
        }

        static 
        {
            BestMatch = new SortOrder("BestMatch", 0);
            CurrentPriceLowest = new SortOrder("CurrentPriceLowest", 1);
            CurrentPriceHighest = new SortOrder("CurrentPriceHighest", 2);
            DistanceNearest = new SortOrder("DistanceNearest", 3);
            EndTimeSoonest = new SortOrder("EndTimeSoonest", 4);
            PricePlusShippingLowest = new SortOrder("PricePlusShippingLowest", 5);
            PricePlusShippingHighest = new SortOrder("PricePlusShippingHighest", 6);
            StartTimeNewest = new SortOrder("StartTimeNewest", 7);
            BidCountMost = new SortOrder("BidCountMost", 8);
            BidCountFewest = new SortOrder("BidCountFewest", 9);
            CountryAscending = new SortOrder("CountryAscending", 10);
            CountryDescending = new SortOrder("CountryDescending", 11);
            ConditionNewFirst = new SortOrder("ConditionNewFirst", 12);
            ConditionUsedFirst = new SortOrder("ConditionUsedFirst", 13);
            CountryRegionDown = new SortOrder("CountryRegionDown", 14);
            CountryRegionUp = new SortOrder("CountryRegionUp", 15);
            MileageLowest = new SortOrder("MileageLowest", 16);
            MileageHighest = new SortOrder("MileageHighest", 17);
            YearLowest = new SortOrder("YearLowest", 18);
            YearHighest = new SortOrder("YearHighest", 19);
            DateListedOldestFirst = new SortOrder("DateListedOldestFirst", 20);
            EndDateRecent = new SortOrder("EndDateRecent", 21);
            $VALUES = (new SortOrder[] {
                BestMatch, CurrentPriceLowest, CurrentPriceHighest, DistanceNearest, EndTimeSoonest, PricePlusShippingLowest, PricePlusShippingHighest, StartTimeNewest, BidCountMost, BidCountFewest, 
                CountryAscending, CountryDescending, ConditionNewFirst, ConditionUsedFirst, CountryRegionDown, CountryRegionUp, MileageLowest, MileageHighest, YearLowest, YearHighest, 
                DateListedOldestFirst, EndDateRecent
            });
        }

        private SortOrder(String s, int i)
        {
            super(s, i);
        }
    }

    public static class UserContext
    {

        public Location userLocation;

        public UserContext()
        {
        }
    }


    public static final List ITEM_CONDITION_NEW_VALUES = Arrays.asList(new String[] {
        "1000", "1500", "1750"
    });
    public static final List ITEM_CONDITION_USED_VALUES = Arrays.asList(new String[] {
        "2000", "2500", "3000", "4000", "5000", "6000", "7000"
    });
    private static final Object cacheLock = new Object();
    private static CacheManager categoryCache;
    public List categoryId;
    public transient String categoryName[];
    public SearchConstraints constraints;
    public String keyword;
    public List outputSelector;
    public PaginationInput paginationInput;
    public List scope;
    public String sellerName;
    public Location shipToLocation;
    public SortOrder sortOrder;
    public UserContext userContext;

    public SaasSearchRequest()
    {
        categoryName = new String[3];
    }

    private static void addGlobalConstraint(SaasSearchRequest saassearchrequest, ConstraintType constrainttype, String s)
    {
        GlobalAspectConstraint globalaspectconstraint = new GlobalAspectConstraint();
        globalaspectconstraint.constraintType = constrainttype;
        globalaspectconstraint.value = Collections.singletonList(s);
        saassearchrequest.constraints.globalAspect.add(globalaspectconstraint);
    }

    private static void addGlobalConstraintWithParamNameValue(SaasSearchRequest saassearchrequest, ConstraintType constrainttype, String s, String s1, String s2)
    {
        addGlobalConstraintWithParamNameValue(saassearchrequest, constrainttype, s, s1, Collections.singletonList(s2));
    }

    private static void addGlobalConstraintWithParamNameValue(SaasSearchRequest saassearchrequest, ConstraintType constrainttype, String s, String s1, List list)
    {
        GlobalAspectConstraint globalaspectconstraint = new GlobalAspectConstraint();
        globalaspectconstraint.constraintType = constrainttype;
        constrainttype = new AttributeNameValue();
        constrainttype.name = s;
        constrainttype.value = s1;
        globalaspectconstraint.paramNameValue = Collections.singletonList(constrainttype);
        globalaspectconstraint.value = list;
        saassearchrequest.constraints.globalAspect.add(globalaspectconstraint);
    }

    private boolean compareAsUnorderedSets(List list, List list1)
    {
        boolean flag2 = true;
        boolean flag;
        boolean flag1;
        if (list == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (list1 == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag == flag1)
        {
            if (list != null)
            {
                if (list.size() == list1.size())
                {
                    if (!list.containsAll(list1) || !list1.containsAll(list))
                    {
                        flag2 = false;
                    }
                    return flag2;
                }
            } else
            {
                return true;
            }
        }
        return false;
    }

    public static SaasSearchRequest fromSearchParameters(SearchParameters searchparameters)
    {
        SaasSearchRequest saassearchrequest = new SaasSearchRequest();
        if (searchparameters == null)
        {
            searchparameters = null;
        } else
        {
            Object obj;
            boolean flag;
            if (!searchparameters.country.isSite())
            {
                flag = true;
            } else
            {
                flag = false;
            }
            saassearchrequest.shipToLocation = new Location();
            saassearchrequest.shipToLocation.country = searchparameters.countryId;
            saassearchrequest.shipToLocation.postalCode = searchparameters.buyerPostalCode;
            if (TextUtils.isEmpty(searchparameters.sortOrder))
            {
                obj = "BestMatch";
            } else
            {
                obj = searchparameters.sortOrder;
            }
            try
            {
                saassearchrequest.sortOrder = SortOrder.valueOf(((String) (obj)));
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                saassearchrequest.sortOrder = SortOrder.BestMatch;
            }
            if (searchparameters.category != null)
            {
                saassearchrequest.categoryId = new ArrayList();
                if (searchparameters.category != null && !searchparameters.category.isDefault())
                {
                    saassearchrequest.categoryId.add(Long.valueOf(searchparameters.category.id));
                }
                if (searchparameters.category1 != null && !searchparameters.category1.isDefault())
                {
                    saassearchrequest.categoryId.add(Long.valueOf(searchparameters.category1.id));
                }
                if (searchparameters.category2 != null && !searchparameters.category2.isDefault())
                {
                    saassearchrequest.categoryId.add(Long.valueOf(searchparameters.category2.id));
                }
            }
            if (!searchparameters.completedListings && searchparameters.descriptionSearch)
            {
                saassearchrequest.scope = Collections.singletonList(SearchScope.ItemTitleAndDescriptionSearch);
            }
            saassearchrequest.constraints = new SearchConstraints();
            saassearchrequest.constraints.globalAspect = new ArrayList();
            saassearchrequest.constraints.scopedAspect = new ArrayList();
            if (searchparameters.aspectHistogram != null && searchparameters.aspectHistogram.hasCheck())
            {
                obj = new ScopedAspectConstraint();
                obj.aspect = new ArrayList();
                Iterator iterator = searchparameters.aspectHistogram.iterator();
                do
                {
                    if (!iterator.hasNext())
                    {
                        break;
                    }
                    Object obj1 = (com.ebay.common.model.search.EbayAspectHistogram.Aspect)iterator.next();
                    if (((com.ebay.common.model.search.EbayAspectHistogram.Aspect) (obj1)).hasCheck())
                    {
                        AspectConstraint aspectconstraint = new AspectConstraint();
                        aspectconstraint.name = ((com.ebay.common.model.search.EbayAspectHistogram.Aspect) (obj1)).serviceName;
                        aspectconstraint.value = new ArrayList();
                        obj1 = ((com.ebay.common.model.search.EbayAspectHistogram.Aspect) (obj1)).iterator();
                        do
                        {
                            if (!((Iterator) (obj1)).hasNext())
                            {
                                break;
                            }
                            com.ebay.common.model.search.EbayAspectHistogram.AspectValue aspectvalue = (com.ebay.common.model.search.EbayAspectHistogram.AspectValue)((Iterator) (obj1)).next();
                            if (aspectvalue.checked)
                            {
                                aspectconstraint.value.add(aspectvalue.serviceValue);
                            }
                        } while (true);
                        ((ScopedAspectConstraint) (obj)).aspect.add(aspectconstraint);
                    }
                } while (true);
                obj.scope = new AspectScope();
                ((ScopedAspectConstraint) (obj)).scope.type = searchparameters.aspectHistogram.scopeType;
                ((ScopedAspectConstraint) (obj)).scope.value = searchparameters.aspectHistogram.scopeValue;
                saassearchrequest.constraints.scopedAspect.add(obj);
            }
            if (!TextUtils.isEmpty(searchparameters.condition))
            {
                String s = searchparameters.condition;
                obj = s;
                if (s.equals("Unspecified"))
                {
                    obj = "non_specified";
                }
                addGlobalConstraint(saassearchrequest, ConstraintType.ItemCondition, ((String) (obj)));
            }
            if (searchparameters.freeShipping)
            {
                addGlobalConstraint(saassearchrequest, ConstraintType.FreeShippingOnly, "true");
            }
            if (searchparameters.expeditedShipping)
            {
                addGlobalConstraint(saassearchrequest, ConstraintType.ExpeditedShippingType, "true");
            }
            if (searchparameters.searchLocalCountryOnly)
            {
                if (!flag)
                {
                    addGlobalConstraint(saassearchrequest, ConstraintType.PreferredItemLocation, "CurrentCountry");
                }
                addGlobalConstraint(saassearchrequest, ConstraintType.LocatedIn, searchparameters.countryId);
            }
            if (searchparameters.searchOtherCountries || searchparameters.searchOtherCountriesGbh)
            {
                addGlobalConstraint(saassearchrequest, ConstraintType.PreferredItemLocation, "Worldwide");
                addGlobalConstraint(saassearchrequest, ConstraintType.AvailableTo, searchparameters.countryId);
            }
            if (!flag && !searchparameters.searchLocalCountryOnly && !searchparameters.searchOtherCountries && !searchparameters.searchOtherCountriesGbh)
            {
                addGlobalConstraint(saassearchrequest, ConstraintType.PreferredItemLocation, "CurrentSite");
            }
            if (searchparameters.buyingFormat != 7 && searchparameters.buyingFormat != 0)
            {
                obj = new ArrayList();
                GlobalAspectConstraint globalaspectconstraint;
                ArrayList arraylist;
                AttributeNameValue attributenamevalue;
                if (searchparameters.buyingFormat == 5)
                {
                    ((ArrayList) (obj)).add("Auction");
                } else
                if (searchparameters.buyingFormat == 6)
                {
                    ((ArrayList) (obj)).add("FixedPrice");
                }
                addGlobalConstraintWithParamNameValue(saassearchrequest, ConstraintType.ListingType, "operator", "exclusive", ((List) (obj)));
            }
            if (searchparameters.bestOfferOnly)
            {
                addGlobalConstraint(saassearchrequest, ConstraintType.BestOfferOnly, "true");
            }
            if (searchparameters.localPickupOnly)
            {
                addGlobalConstraint(saassearchrequest, ConstraintType.LocalPickupOnly, "true");
            }
            if (searchparameters.maxDistance > 0 && !TextUtils.isEmpty(searchparameters.buyerPostalCode))
            {
                addGlobalConstraintWithParamNameValue(saassearchrequest, ConstraintType.MaxDistance, "postalcode", searchparameters.buyerPostalCode, String.valueOf(searchparameters.maxDistance));
            }
            if (searchparameters.minPrice != null)
            {
                addGlobalConstraintWithParamNameValue(saassearchrequest, ConstraintType.MinPrice, "currency", searchparameters.minPrice.code, searchparameters.minPrice.value);
            }
            if (searchparameters.maxPrice != null)
            {
                addGlobalConstraintWithParamNameValue(saassearchrequest, ConstraintType.MaxPrice, "currency", searchparameters.maxPrice.code, searchparameters.maxPrice.value);
            }
            if (searchparameters.completedListings)
            {
                addGlobalConstraint(saassearchrequest, ConstraintType.CompletedListingsOnly, "true");
            }
            if (searchparameters.soldItemsOnly)
            {
                addGlobalConstraint(saassearchrequest, ConstraintType.SoldItemsOnly, "true");
            }
            if (searchparameters.inStorePickupOnly)
            {
                addGlobalConstraint(saassearchrequest, ConstraintType.LocalMerchantStorePickupOnly, "true");
            }
            if (searchparameters.ebnOnly)
            {
                addGlobalConstraint(saassearchrequest, ConstraintType.EbayNowDelivery, "true");
            }
            if (searchparameters.ebayPlusOnly)
            {
                addGlobalConstraint(saassearchrequest, ConstraintType.EbayPlus, "true");
            }
            if (searchparameters.ebayGivingWorks)
            {
                addGlobalConstraint(saassearchrequest, ConstraintType.CharityOnly, "true");
            }
            if (searchparameters.returnsAccepted)
            {
                addGlobalConstraint(saassearchrequest, ConstraintType.ReturnsAcceptedOnly, "true");
            }
            obj = searchparameters.sellerOffer;
            if (obj != null)
            {
                globalaspectconstraint = new GlobalAspectConstraint();
                globalaspectconstraint.constraintType = ConstraintType.SellerOffer;
                arraylist = new ArrayList();
                attributenamevalue = new AttributeNameValue();
                attributenamevalue.name = "sellerName";
                attributenamevalue.value = ((SellerOfferParameters) (obj)).sellerName;
                arraylist.add(attributenamevalue);
                attributenamevalue = new AttributeNameValue();
                attributenamevalue.name = "offerId";
                attributenamevalue.value = ((SellerOfferParameters) (obj)).offerId;
                arraylist.add(attributenamevalue);
                attributenamevalue = new AttributeNameValue();
                attributenamevalue.name = "offerType";
                attributenamevalue.value = ((SellerOfferParameters) (obj)).offerType;
                arraylist.add(attributenamevalue);
                if (!TextUtils.isEmpty(((SellerOfferParameters) (obj)).seedCategoryId))
                {
                    attributenamevalue = new AttributeNameValue();
                    attributenamevalue.name = "seedCategoryId";
                    attributenamevalue.value = ((SellerOfferParameters) (obj)).seedCategoryId;
                    arraylist.add(attributenamevalue);
                }
                globalaspectconstraint.paramNameValue = arraylist;
                saassearchrequest.constraints.globalAspect.add(globalaspectconstraint);
            }
            saassearchrequest.keyword = searchparameters.keywords;
            if (!TextUtils.isEmpty(searchparameters.sellerId))
            {
                saassearchrequest.sellerName = searchparameters.sellerId;
            } else
            if (obj != null)
            {
                saassearchrequest.sellerName = ((SellerOfferParameters) (obj)).sellerName;
            }
            if (saassearchrequest.constraints.globalAspect.isEmpty())
            {
                saassearchrequest.constraints.globalAspect = null;
            }
            searchparameters = saassearchrequest;
            if (saassearchrequest.constraints.scopedAspect.isEmpty())
            {
                saassearchrequest.constraints.scopedAspect = null;
                return saassearchrequest;
            }
        }
        return searchparameters;
    }

    public boolean equals(Object obj)
    {
        SaasSearchRequest saassearchrequest;
        if (this == obj)
        {
            return true;
        }
        if (obj == null || getClass() != obj.getClass())
        {
            return false;
        }
        saassearchrequest = (SaasSearchRequest)obj;
        boolean flag;
        boolean flag9;
        if (categoryId == null || !categoryId.isEmpty() && ((Long)categoryId.get(0)).longValue() == 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (saassearchrequest.categoryId == null || !saassearchrequest.categoryId.isEmpty() && ((Long)saassearchrequest.categoryId.get(0)).longValue() == 0L)
        {
            flag9 = true;
        } else
        {
            flag9 = false;
        }
        if ((!flag || !flag9) && (categoryId == null ? saassearchrequest.categoryId != null : !categoryId.equals(saassearchrequest.categoryId)))
        {
            return false;
        }
        if (constraints == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (saassearchrequest.constraints == null)
        {
            flag9 = true;
        } else
        {
            flag9 = false;
        }
        if (flag != flag9)
        {
            return false;
        }
        if (constraints == null)
        {
            break MISSING_BLOCK_LABEL_1487;
        }
        if (constraints.globalAspect == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (saassearchrequest.constraints.globalAspect == null)
        {
            flag9 = true;
        } else
        {
            flag9 = false;
        }
        if (flag != flag9)
        {
            return false;
        }
        if (constraints.globalAspect == null) goto _L2; else goto _L1
_L1:
        Iterator iterator1;
        Object obj1;
        if (constraints.globalAspect.size() != saassearchrequest.constraints.globalAspect.size())
        {
            return false;
        }
        iterator1 = constraints.globalAspect.iterator();
        obj1 = new ArrayMap(saassearchrequest.constraints.globalAspect.size());
        GlobalAspectConstraint globalaspectconstraint;
        for (obj = saassearchrequest.constraints.globalAspect.iterator(); ((Iterator) (obj)).hasNext(); ((Map) (obj1)).put(globalaspectconstraint.constraintType, globalaspectconstraint))
        {
            globalaspectconstraint = (GlobalAspectConstraint)((Iterator) (obj)).next();
        }

_L15:
        if (!iterator1.hasNext()) goto _L2; else goto _L3
_L3:
        Object obj2;
        obj = (GlobalAspectConstraint)iterator1.next();
        obj2 = (GlobalAspectConstraint)((Map) (obj1)).get(((GlobalAspectConstraint) (obj)).constraintType);
        if (obj == null || obj2 == null || ((GlobalAspectConstraint) (obj)).constraintType == null || ((GlobalAspectConstraint) (obj2)).constraintType == null || !((GlobalAspectConstraint) (obj)).constraintType.equals(((GlobalAspectConstraint) (obj2)).constraintType))
        {
            return false;
        }
        boolean flag1;
        boolean flag10;
        if (((GlobalAspectConstraint) (obj)).value == null)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (((GlobalAspectConstraint) (obj2)).value == null)
        {
            flag10 = true;
        } else
        {
            flag10 = false;
        }
        if (flag1 != flag10)
        {
            return false;
        }
        if (((GlobalAspectConstraint) (obj)).value == null) goto _L5; else goto _L4
_L4:
        Iterator iterator;
        Iterator iterator2;
        if (((GlobalAspectConstraint) (obj)).value.size() != ((GlobalAspectConstraint) (obj2)).value.size())
        {
            return false;
        }
        iterator = ((GlobalAspectConstraint) (obj)).value.iterator();
        iterator2 = ((GlobalAspectConstraint) (obj2)).value.iterator();
_L11:
        if (!iterator.hasNext()) goto _L5; else goto _L6
_L6:
        Object obj3;
        String s;
        obj3 = (String)iterator.next();
        s = (String)iterator2.next();
        static class _cls1
        {

            static final int $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[];

            static 
            {
                $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType = new int[ConstraintType.values().length];
                try
                {
                    $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[ConstraintType.ItemCondition.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror21) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[ConstraintType.FreeShippingOnly.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror20) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[ConstraintType.ExpeditedShippingType.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror19) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[ConstraintType.PreferredLocation.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror18) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[ConstraintType.PreferredItemLocation.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror17) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[ConstraintType.LocatedIn.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror16) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[ConstraintType.AvailableTo.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror15) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[ConstraintType.ListingType.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror14) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[ConstraintType.BestOfferOnly.ordinal()] = 9;
                }
                catch (NoSuchFieldError nosuchfielderror13) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[ConstraintType.LocalPickupOnly.ordinal()] = 10;
                }
                catch (NoSuchFieldError nosuchfielderror12) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[ConstraintType.MaxDistance.ordinal()] = 11;
                }
                catch (NoSuchFieldError nosuchfielderror11) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[ConstraintType.MinPrice.ordinal()] = 12;
                }
                catch (NoSuchFieldError nosuchfielderror10) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[ConstraintType.MaxPrice.ordinal()] = 13;
                }
                catch (NoSuchFieldError nosuchfielderror9) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[ConstraintType.CompletedListingsOnly.ordinal()] = 14;
                }
                catch (NoSuchFieldError nosuchfielderror8) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[ConstraintType.SoldItemsOnly.ordinal()] = 15;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[ConstraintType.LocalMerchantStorePickupOnly.ordinal()] = 16;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[ConstraintType.EbayNowDelivery.ordinal()] = 17;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[ConstraintType.EbayPlus.ordinal()] = 18;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[ConstraintType.CharityOnly.ordinal()] = 19;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[ConstraintType.ReturnsAcceptedOnly.ordinal()] = 20;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[ConstraintType.IncludeSeller.ordinal()] = 21;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$ebay$common$net$api$followinterest$SaasSearchRequest$ConstraintType[ConstraintType.SellerOffer.ordinal()] = 22;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.com.ebay.common.net.api.followinterest.SaasSearchRequest.ConstraintType[((GlobalAspectConstraint) (obj)).constraintType.ordinal()];
        JVM INSTR tableswitch 11 13: default 628
    //                   11 676
    //                   12 645
    //                   13 645;
           goto _L7 _L8 _L9 _L9
_L8:
        continue; /* Loop/switch isn't completed */
_L7:
        if (obj3 == null ? s == null : ((String) (obj3)).equals(s)) goto _L11; else goto _L10
_L10:
        return false;
_L9:
        if (obj3 == null ? s == null : Double.compare(Double.parseDouble(((String) (obj3))), Double.parseDouble(s)) == 0) goto _L11; else goto _L12
_L12:
        return false;
        if (obj3 == null ? s == null : Integer.parseInt(((String) (obj3))) == Integer.parseInt(s)) goto _L11; else goto _L13
_L13:
        return false;
_L5:
        boolean flag2;
        boolean flag11;
        if (((GlobalAspectConstraint) (obj)).paramNameValue == null)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (((GlobalAspectConstraint) (obj2)).paramNameValue == null)
        {
            flag11 = true;
        } else
        {
            flag11 = false;
        }
        if (flag2 != flag11)
        {
            return false;
        }
        if (((GlobalAspectConstraint) (obj)).paramNameValue == null) goto _L15; else goto _L14
_L14:
        if (((GlobalAspectConstraint) (obj)).paramNameValue.size() != ((GlobalAspectConstraint) (obj2)).paramNameValue.size())
        {
            return false;
        }
        iterator2 = ((GlobalAspectConstraint) (obj)).paramNameValue.iterator();
_L18:
        if (!iterator2.hasNext()) goto _L15; else goto _L16
_L16:
        obj3 = (AttributeNameValue)iterator2.next();
        iterator = null;
        Iterator iterator3 = ((GlobalAspectConstraint) (obj2)).paramNameValue.iterator();
        do
        {
            obj = iterator;
            if (!iterator3.hasNext())
            {
                break;
            }
            obj = (AttributeNameValue)iterator3.next();
        } while (!((AttributeNameValue) (obj)).name.equals(((AttributeNameValue) (obj3)).name));
        if (obj3 == null ? obj != null : !((AttributeNameValue) (obj3)).equals(obj))
        {
            return false;
        }
        if (obj3 == null) goto _L18; else goto _L17
_L17:
        if (((AttributeNameValue) (obj3)).name == null ? ((AttributeNameValue) (obj)).name != null : !((AttributeNameValue) (obj3)).name.equals(((AttributeNameValue) (obj)).name))
        {
            return false;
        }
        if (((AttributeNameValue) (obj3)).value == null ? ((AttributeNameValue) (obj)).value == null : ((AttributeNameValue) (obj3)).value.equals(((AttributeNameValue) (obj)).value)) goto _L18; else goto _L19
_L19:
        return false;
_L2:
        boolean flag3;
        boolean flag12;
        if (constraints.scopedAspect == null)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        if (saassearchrequest.constraints.scopedAspect == null)
        {
            flag12 = true;
        } else
        {
            flag12 = false;
        }
        if (flag3 != flag12)
        {
            return false;
        }
        if (constraints.scopedAspect == null)
        {
            break MISSING_BLOCK_LABEL_1487;
        }
        if (constraints.scopedAspect.size() != saassearchrequest.constraints.scopedAspect.size())
        {
            return false;
        }
        iterator1 = constraints.scopedAspect.iterator();
        obj1 = saassearchrequest.constraints.scopedAspect.iterator();
_L21:
        do
        {
            if (!iterator1.hasNext())
            {
                break MISSING_BLOCK_LABEL_1487;
            }
            obj = (ScopedAspectConstraint)iterator1.next();
            obj2 = (ScopedAspectConstraint)((Iterator) (obj1)).next();
            boolean flag4;
            boolean flag13;
            if (((ScopedAspectConstraint) (obj)).scope == null)
            {
                flag4 = true;
            } else
            {
                flag4 = false;
            }
            if (((ScopedAspectConstraint) (obj2)).scope == null)
            {
                flag13 = true;
            } else
            {
                flag13 = false;
            }
            if (flag4 != flag13)
            {
                return false;
            }
            if (((ScopedAspectConstraint) (obj)).scope != null)
            {
                if (((ScopedAspectConstraint) (obj)).scope.type == null ? ((ScopedAspectConstraint) (obj2)).scope.type != null : !((ScopedAspectConstraint) (obj)).scope.type.equals(((ScopedAspectConstraint) (obj2)).scope.type))
                {
                    return false;
                }
                if (((ScopedAspectConstraint) (obj)).scope.value == null ? ((ScopedAspectConstraint) (obj2)).scope.value != null : !((ScopedAspectConstraint) (obj)).scope.value.equals(((ScopedAspectConstraint) (obj2)).scope.value))
                {
                    return false;
                }
            }
            if (((ScopedAspectConstraint) (obj)).aspect == null)
            {
                flag4 = true;
            } else
            {
                flag4 = false;
            }
            if (((ScopedAspectConstraint) (obj2)).aspect == null)
            {
                flag13 = true;
            } else
            {
                flag13 = false;
            }
            if (flag4 != flag13)
            {
                return false;
            }
        } while (((ScopedAspectConstraint) (obj)).aspect == null);
        if (((ScopedAspectConstraint) (obj)).aspect.size() != ((ScopedAspectConstraint) (obj2)).aspect.size())
        {
            return false;
        }
        iterator2 = ((ScopedAspectConstraint) (obj)).aspect.iterator();
_L23:
        if (!iterator2.hasNext()) goto _L21; else goto _L20
_L20:
        obj3 = (AspectConstraint)iterator2.next();
        iterator = null;
        Iterator iterator4 = ((ScopedAspectConstraint) (obj2)).aspect.iterator();
        do
        {
            obj = iterator;
            if (!iterator4.hasNext())
            {
                break;
            }
            obj = (AspectConstraint)iterator4.next();
        } while (((AspectConstraint) (obj)).name == null || !((AspectConstraint) (obj)).name.equals(((AspectConstraint) (obj3)).name));
        boolean flag5;
        boolean flag14;
        if (obj3 == null)
        {
            flag5 = true;
        } else
        {
            flag5 = false;
        }
        if (obj == null)
        {
            flag14 = true;
        } else
        {
            flag14 = false;
        }
        if (flag5 != flag14)
        {
            return false;
        }
        if (obj3 == null) goto _L23; else goto _L22
_L22:
        if (!((AspectConstraint) (obj3)).name.equals(((AspectConstraint) (obj)).name))
        {
            return false;
        }
        if (compareAsUnorderedSets(((AspectConstraint) (obj3)).value, ((AspectConstraint) (obj)).value)) goto _L23; else goto _L24
_L24:
        return false;
        if (saassearchrequest.keyword != null)
        {
            obj = saassearchrequest.keyword.toLowerCase(Locale.getDefault());
        } else
        {
            obj = null;
        }
        if (keyword == null ? saassearchrequest.keyword != null : !keyword.toLowerCase(Locale.getDefault()).equals(obj))
        {
            return false;
        }
        boolean flag6;
        boolean flag15;
        if (scope == null)
        {
            flag6 = true;
        } else
        {
            flag6 = false;
        }
        if (saassearchrequest.scope == null)
        {
            flag15 = true;
        } else
        {
            flag15 = false;
        }
        if (flag6 != flag15)
        {
            return false;
        }
        if (scope == null) goto _L26; else goto _L25
_L25:
        if (scope.size() != saassearchrequest.scope.size())
        {
            return false;
        }
        obj = scope.iterator();
        iterator = saassearchrequest.scope.iterator();
_L29:
        if (!((Iterator) (obj)).hasNext()) goto _L26; else goto _L27
_L27:
        if (((SearchScope)((Iterator) (obj)).next()).equals((SearchScope)iterator.next())) goto _L29; else goto _L28
_L28:
        return false;
_L26:
        if (sellerName == null ? saassearchrequest.sellerName != null : !sellerName.equals(saassearchrequest.sellerName))
        {
            return false;
        }
        boolean flag7;
        boolean flag16;
        if (shipToLocation == null)
        {
            flag7 = true;
        } else
        {
            flag7 = false;
        }
        if (saassearchrequest.shipToLocation == null)
        {
            flag16 = true;
        } else
        {
            flag16 = false;
        }
        if (flag7 != flag16)
        {
            return false;
        }
        if (shipToLocation != null)
        {
            if (shipToLocation.postalCode == null ? saassearchrequest.shipToLocation.postalCode != null : !shipToLocation.postalCode.equals(saassearchrequest.shipToLocation.postalCode))
            {
                return false;
            }
            if (shipToLocation.country == null ? saassearchrequest.shipToLocation.country != null : !shipToLocation.country.equals(saassearchrequest.shipToLocation.country))
            {
                return false;
            }
        }
        if (sortOrder == null || SortOrder.BestMatch.equals(sortOrder))
        {
            flag7 = true;
        } else
        {
            flag7 = false;
        }
        if (saassearchrequest.sortOrder == null || SortOrder.BestMatch.equals(saassearchrequest.sortOrder))
        {
            flag16 = true;
        } else
        {
            flag16 = false;
        }
        if (sortOrder != saassearchrequest.sortOrder && flag7 != flag16)
        {
            return false;
        }
        if (userContext == null)
        {
            flag7 = true;
        } else
        {
            flag7 = false;
        }
        if (saassearchrequest.userContext == null)
        {
            flag16 = true;
        } else
        {
            flag16 = false;
        }
        if (flag7 != flag16)
        {
            return false;
        }
        if (userContext != null)
        {
            boolean flag8;
            boolean flag17;
            if (userContext.userLocation == null)
            {
                flag8 = true;
            } else
            {
                flag8 = false;
            }
            if (saassearchrequest.userContext.userLocation == null)
            {
                flag17 = true;
            } else
            {
                flag17 = false;
            }
            if (flag8 != flag17)
            {
                return false;
            }
            if (userContext.userLocation != null)
            {
                if (userContext.userLocation.postalCode == null ? saassearchrequest.userContext.userLocation.postalCode != null : !userContext.userLocation.postalCode.equals(saassearchrequest.userContext.userLocation.postalCode))
                {
                    return false;
                }
                if (userContext.userLocation.country == null ? saassearchrequest.userContext.userLocation.country != null : !userContext.userLocation.country.equals(saassearchrequest.userContext.userLocation.country))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public int hashCode()
    {
        int l1 = 0;
        int i;
        int j;
        int k;
        int l;
        int i1;
        int j1;
        int k1;
        if (keyword != null)
        {
            i = keyword.hashCode();
        } else
        {
            i = 0;
        }
        if (categoryId != null)
        {
            j = categoryId.hashCode();
        } else
        {
            j = 0;
        }
        if (constraints != null)
        {
            k = constraints.hashCode();
        } else
        {
            k = 0;
        }
        if (scope != null)
        {
            l = scope.hashCode();
        } else
        {
            l = 0;
        }
        if (sellerName != null)
        {
            i1 = sellerName.hashCode();
        } else
        {
            i1 = 0;
        }
        if (userContext != null)
        {
            j1 = userContext.hashCode();
        } else
        {
            j1 = 0;
        }
        if (shipToLocation != null)
        {
            k1 = shipToLocation.hashCode();
        } else
        {
            k1 = 0;
        }
        if (sortOrder != null)
        {
            l1 = sortOrder.hashCode();
        }
        return ((((((i * 31 + j) * 31 + k) * 31 + l) * 31 + i1) * 31 + j1) * 31 + k1) * 31 + l1;
    }

    public SearchParameters populateSearchParameters(SearchParameters searchparameters)
    {
        SearchParameters searchparameters1;
        searchparameters1 = searchparameters.clone();
        if (shipToLocation != null && !TextUtils.isEmpty(shipToLocation.postalCode))
        {
            searchparameters1.buyerPostalCode = shipToLocation.postalCode;
        }
        if (sortOrder != null)
        {
            searchparameters1.sortOrder = sortOrder.toString();
        }
        if (categoryId != null && !categoryId.isEmpty())
        {
            searchparameters1.category = new EbayCategorySummary(((Long)categoryId.get(0)).longValue(), categoryName[0]);
            if (categoryId.size() >= 2)
            {
                searchparameters1.category1 = new EbayCategorySummary(((Long)categoryId.get(1)).longValue(), categoryName[1]);
            }
            if (categoryId.size() >= 3)
            {
                searchparameters1.category2 = new EbayCategorySummary(((Long)categoryId.get(2)).longValue(), categoryName[2]);
            }
        }
        if (scope != null && !scope.isEmpty() && ((SearchScope)scope.get(0)).equals(SearchScope.ItemTitleAndDescriptionSearch))
        {
            searchparameters1.completedListings = false;
            searchparameters1.soldItemsOnly = false;
            searchparameters1.descriptionSearch = true;
        }
        if (constraints == null) goto _L2; else goto _L1
_L1:
        if (constraints.scopedAspect == null || constraints.scopedAspect.isEmpty()) goto _L4; else goto _L3
_L3:
        searchparameters1.aspectHistogram = new EbayAspectHistogram();
        searchparameters1.aspectHistogram.mergeStrategy = com.ebay.common.model.search.EbayAspectHistogram.HistoMergeStrategy.MERGE_ALL;
        searchparameters = (ScopedAspectConstraint)constraints.scopedAspect.get(0);
        if (((ScopedAspectConstraint) (searchparameters)).scope == null) goto _L6; else goto _L5
_L5:
        searchparameters1.aspectHistogram.scopeType = ((ScopedAspectConstraint) (searchparameters)).scope.type;
        searchparameters1.aspectHistogram.scopeValue = ((ScopedAspectConstraint) (searchparameters)).scope.value;
_L25:
        searchparameters = ((ScopedAspectConstraint) (searchparameters)).aspect.iterator();
_L13:
        Object obj1;
        if (!searchparameters.hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj1 = (AspectConstraint)searchparameters.next();
        Object obj;
        obj = new com.ebay.common.model.search.EbayAspectHistogram.Aspect();
        obj.name = URLDecoder.decode(((AspectConstraint) (obj1)).name, "UTF-8");
        obj.serviceName = ((AspectConstraint) (obj1)).name;
        obj1 = ((AspectConstraint) (obj1)).value.iterator();
_L11:
        if (!((Iterator) (obj1)).hasNext()) goto _L8; else goto _L7
_L7:
        String s;
        Object obj2;
        s = (String)((Iterator) (obj1)).next();
        obj2 = new com.ebay.common.model.search.EbayAspectHistogram.AspectValue();
        obj2.value = URLDecoder.decode(s, "UTF-8");
        if (!((com.ebay.common.model.search.EbayAspectHistogram.AspectValue) (obj2)).value.equals("!")) goto _L10; else goto _L9
_L9:
        obj2.value = "LH_SiteWideCondition_NS";
        obj2.serviceValue = "!";
_L12:
        obj2.checked = true;
        ((com.ebay.common.model.search.EbayAspectHistogram.Aspect) (obj)).add(obj2);
          goto _L11
_L6:
        if (searchparameters1.category != null && searchparameters1.category.id >= 0L)
        {
            searchparameters1.aspectHistogram.scopeType = "Category";
            searchparameters1.aspectHistogram.scopeValue = Long.toString(searchparameters1.category.id);
        }
        continue; /* Loop/switch isn't completed */
_L10:
        obj2.serviceValue = s;
          goto _L12
_L8:
        try
        {
            searchparameters1.aspectHistogram.add(obj);
        }
        // Misplaced declaration of an exception variable
        catch (Object obj) { }
        if (true) goto _L13; else goto _L4
_L4:
        if (constraints.globalAspect == null) goto _L2; else goto _L14
_L14:
        obj2 = constraints.globalAspect.iterator();
_L23:
        Object obj3;
        if (!((Iterator) (obj2)).hasNext())
        {
            break; /* Loop/switch isn't completed */
        }
        obj3 = (GlobalAspectConstraint)((Iterator) (obj2)).next();
        obj = null;
        if (((GlobalAspectConstraint) (obj3)).value != null)
        {
            searchparameters = (String)((GlobalAspectConstraint) (obj3)).value.get(0);
        } else
        {
            searchparameters = ((SearchParameters) (obj));
            if (((GlobalAspectConstraint) (obj3)).paramNameValue != null)
            {
                searchparameters = ((SearchParameters) (obj));
                if (!((GlobalAspectConstraint) (obj3)).paramNameValue.isEmpty())
                {
                    searchparameters = ((AttributeNameValue)((GlobalAspectConstraint) (obj3)).paramNameValue.get(0)).value;
                }
            }
        }
        if (((GlobalAspectConstraint) (obj3)).constraintType == null)
        {
            continue; /* Loop/switch isn't completed */
        }
        switch (_cls1..SwitchMap.com.ebay.common.net.api.followinterest.SaasSearchRequest.ConstraintType[((GlobalAspectConstraint) (obj3)).constraintType.ordinal()])
        {
        default:
            continue; /* Loop/switch isn't completed */

        case 1: // '\001'
            searchparameters1.condition = searchparameters;
            if (searchparameters1.condition.equals("non_specified"))
            {
                searchparameters1.condition = "Unspecified";
                continue; /* Loop/switch isn't completed */
            }
            if (!TextUtils.isDigitsOnly(searchparameters1.condition))
            {
                continue; /* Loop/switch isn't completed */
            }
            searchparameters = ((GlobalAspectConstraint) (obj3)).value.iterator();
            do
            {
                if (searchparameters.hasNext())
                {
                    obj = (String)searchparameters.next();
                    if (!ITEM_CONDITION_NEW_VALUES.contains(obj))
                    {
                        continue;
                    }
                    searchparameters1.condition = "New";
                }
                continue; /* Loop/switch isn't completed */
            } while (!ITEM_CONDITION_USED_VALUES.contains(obj));
            searchparameters1.condition = "Used";
            continue; /* Loop/switch isn't completed */

        case 2: // '\002'
            searchparameters1.freeShipping = Boolean.parseBoolean(searchparameters);
            continue; /* Loop/switch isn't completed */

        case 3: // '\003'
            searchparameters1.expeditedShipping = Boolean.parseBoolean(searchparameters);
            continue; /* Loop/switch isn't completed */

        case 4: // '\004'
        case 5: // '\005'
            if (searchparameters.equals("CurrentCountry"))
            {
                searchparameters1.searchLocalCountryOnly = true;
            } else
            if (searchparameters.equals("Worldwide"))
            {
                searchparameters1.searchOtherCountries = true;
            }
            continue; /* Loop/switch isn't completed */

        case 6: // '\006'
            searchparameters1.countryId = searchparameters;
            continue; /* Loop/switch isn't completed */

        case 7: // '\007'
            searchparameters1.countryId = searchparameters;
            searchparameters1.searchOtherCountries = true;
            continue; /* Loop/switch isn't completed */

        case 8: // '\b'
            if (searchparameters.equals("Auction"))
            {
                searchparameters1.buyingFormat = 5;
            } else
            if (searchparameters.equals("FixedPrice") || searchparameters.equals("BuyItNow"))
            {
                searchparameters1.buyingFormat = 6;
            }
            searchparameters1.bestOfferOnly = false;
            continue; /* Loop/switch isn't completed */

        case 9: // '\t'
            searchparameters1.bestOfferOnly = Boolean.parseBoolean(searchparameters);
            continue; /* Loop/switch isn't completed */

        case 10: // '\n'
            searchparameters1.localPickupOnly = Boolean.parseBoolean(searchparameters);
            continue; /* Loop/switch isn't completed */

        case 11: // '\013'
            obj = ((GlobalAspectConstraint) (obj3)).paramNameValue.iterator();
            do
            {
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    obj1 = (AttributeNameValue)((Iterator) (obj)).next();
                } while (!((AttributeNameValue) (obj1)).name.equals("postalcode"));
                searchparameters1.maxDistance = Integer.parseInt(searchparameters);
                searchparameters1.buyerPostalCode = ((AttributeNameValue) (obj1)).value;
            } while (true);

        case 12: // '\f'
            obj = ((GlobalAspectConstraint) (obj3)).paramNameValue.iterator();
            do
            {
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    obj1 = (AttributeNameValue)((Iterator) (obj)).next();
                } while (!((AttributeNameValue) (obj1)).name.equals("currency"));
                searchparameters1.minPrice = new ItemCurrency(((AttributeNameValue) (obj1)).value, searchparameters);
            } while (true);

        case 13: // '\r'
            obj = ((GlobalAspectConstraint) (obj3)).paramNameValue.iterator();
            do
            {
                do
                {
                    if (!((Iterator) (obj)).hasNext())
                    {
                        continue; /* Loop/switch isn't completed */
                    }
                    obj1 = (AttributeNameValue)((Iterator) (obj)).next();
                } while (!((AttributeNameValue) (obj1)).name.equals("currency"));
                searchparameters1.maxPrice = new ItemCurrency(((AttributeNameValue) (obj1)).value, searchparameters);
            } while (true);

        case 14: // '\016'
            searchparameters1.completedListings = Boolean.parseBoolean(searchparameters);
            continue; /* Loop/switch isn't completed */

        case 15: // '\017'
            searchparameters1.soldItemsOnly = Boolean.parseBoolean(searchparameters);
            continue; /* Loop/switch isn't completed */

        case 16: // '\020'
            searchparameters1.inStorePickupOnly = Boolean.parseBoolean(searchparameters);
            continue; /* Loop/switch isn't completed */

        case 17: // '\021'
            searchparameters1.ebnOnly = Boolean.parseBoolean(searchparameters);
            continue; /* Loop/switch isn't completed */

        case 18: // '\022'
            searchparameters1.ebayPlusOnly = Boolean.parseBoolean(searchparameters);
            continue; /* Loop/switch isn't completed */

        case 19: // '\023'
            searchparameters1.ebayGivingWorks = Boolean.parseBoolean(searchparameters);
            continue; /* Loop/switch isn't completed */

        case 20: // '\024'
            searchparameters1.returnsAccepted = Boolean.parseBoolean(searchparameters);
            continue; /* Loop/switch isn't completed */

        case 21: // '\025'
            sellerName = searchparameters;
            continue; /* Loop/switch isn't completed */

        case 22: // '\026'
            s = null;
            obj1 = null;
            searchparameters = null;
            obj = null;
            obj3 = ((GlobalAspectConstraint) (obj3)).paramNameValue.iterator();
            break;
        }
_L22:
        AttributeNameValue attributenamevalue;
        String s1;
        byte byte0;
        if (!((Iterator) (obj3)).hasNext())
        {
            break MISSING_BLOCK_LABEL_1660;
        }
        attributenamevalue = (AttributeNameValue)((Iterator) (obj3)).next();
        s1 = attributenamevalue.name;
        byte0 = -1;
        s1.hashCode();
        JVM INSTR lookupswitch 4: default 1520
    //                   -2032627702: 1615
    //                   -1548813161: 1581
    //                   316827306: 1564
    //                   1944555446: 1598;
           goto _L15 _L16 _L17 _L18 _L19
_L15:
        break; /* Loop/switch isn't completed */
_L16:
        break MISSING_BLOCK_LABEL_1615;
_L20:
        switch (byte0)
        {
        case 0: // '\0'
            searchparameters = attributenamevalue.value;
            break;

        case 1: // '\001'
            s = attributenamevalue.value;
            break;

        case 2: // '\002'
            obj1 = attributenamevalue.value;
            break;

        case 3: // '\003'
            obj = attributenamevalue.value;
            break;
        }
        continue; /* Loop/switch isn't completed */
_L18:
        if (s1.equals("sellerName"))
        {
            byte0 = 0;
        }
          goto _L20
_L17:
        if (s1.equals("offerId"))
        {
            byte0 = 1;
        }
          goto _L20
_L19:
        if (s1.equals("offerType"))
        {
            byte0 = 2;
        }
          goto _L20
        if (s1.equals("seedCategoryId"))
        {
            byte0 = 3;
        }
          goto _L20
        if (true) goto _L22; else goto _L21
_L21:
        if (!TextUtils.isEmpty(s) && !TextUtils.isEmpty(((CharSequence) (obj1))) && !TextUtils.isEmpty(searchparameters))
        {
            searchparameters1.sellerOffer = new SellerOfferParameters(((String) (obj1)), s, searchparameters, ((String) (obj)));
        }
        if (true) goto _L23; else goto _L2
_L2:
        boolean flag;
        if (!searchparameters1.country.isSite())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && searchparameters1.searchOtherCountries)
        {
            searchparameters1.searchOtherCountries = false;
            searchparameters1.searchOtherCountriesGbh = true;
        }
        searchparameters1.keywords = keyword;
        searchparameters1.sellerId = sellerName;
        if (TextUtils.isEmpty(searchparameters1.sellerId) && searchparameters1.sellerOffer != null)
        {
            searchparameters1.sellerId = searchparameters1.sellerOffer.sellerName;
        }
        return searchparameters1;
        if (true) goto _L25; else goto _L24
_L24:
    }

    public void populateTransientValues(EbayContext ebaycontext, EbaySite ebaysite)
    {
        if (categoryId != null && !categoryId.isEmpty())
        {
            if (categoryName == null)
            {
                categoryName = new String[categoryId.size()];
            }
            for (int i = 0; i < categoryName.length; i++)
            {
                categoryName[i] = "";
            }

        }
    }

}
