// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.Date;
import java.util.List;

public class Event extends BaseApiResponse
{
    public class Amount
    {

        public String currencyId;
        public String symbol;
        final Event this$0;
        public Double value;

        public Amount()
        {
            this$0 = Event.this;
            super();
        }
    }

    public class Category
    {

        public String id;
        public boolean leafCategory;
        public int level;
        public String name;
        final Event this$0;

        public String toString()
        {
            return (new StringBuilder()).append("Category(").append(id).append(",").append(name).append(",").append(level).append(",").append(leafCategory).append(")").toString();
        }

        public Category()
        {
            this$0 = Event.this;
            super();
        }
    }

    public class CategoryHistogram
    {

        public Category category;
        public List childCategoryHistogram;
        final Event this$0;

        public String toString()
        {
            return (new StringBuilder()).append("CategoryHistogram(").append(category).append(",").append(childCategoryHistogram).append(")").toString();
        }

        public CategoryHistogram()
        {
            this$0 = Event.this;
            super();
        }
    }

    public class DiscountPriceInfo
    {

        public MinimumAdvertisedPriceExposure minimumAdvertisedPriceExposure;
        public Amount originalRetailPrice;
        public String originalRetailPriceText;
        public PricingTreatment pricingTreatment;
        final Event this$0;

        public DiscountPriceInfo()
        {
            this$0 = Event.this;
            super();
        }
    }

    public static class Item
    {

        public DiscountPriceInfo discountPriceInfo;
        public long itemId;
        public List itemImageInfo;
        public ListingInfo listingInfo;
        public String listingSiteId;
        public boolean multiVariationListing;
        public SellerInfo sellerInfo;
        public SellingStatus sellingStatus;
        public ShippingInfo shippingInfo;
        public String title;

        public Item()
        {
        }
    }

    public static class ItemImageInfo
    {

        public String imageSize;
        public String imageURL;
        public String imageURLType;

        public ItemImageInfo()
        {
        }
    }

    public class ListingInfo
    {

        public boolean bestOfferEnabled;
        public boolean buyItNowAvailable;
        public Amount buyItNowPrice;
        public Date endTime;
        public long endTimeLong;
        public Date listedTime;
        public ListingType listingType;
        final Event this$0;

        public ListingInfo()
        {
            this$0 = Event.this;
            super();
        }
    }

    public static final class ListingType extends Enum
    {

        private static final ListingType $VALUES[];
        public static final ListingType AD;
        public static final ListingType CHINESE_AUCTION;
        public static final ListingType CLASSIFIED_AD;
        public static final ListingType DUTCH_AUCTION;
        public static final ListingType EBAY_AD;
        public static final ListingType EBX_ONLY;
        public static final ListingType FIXED_PRICE;
        public static final ListingType HALF_SALE;
        public static final ListingType LIVE_AUCTION;
        public static final ListingType PERSONAL_OFFER;
        public static final ListingType SDC_SALE;
        public static final ListingType WANTED_ITEM;

        public static ListingType valueOf(String s)
        {
            return (ListingType)Enum.valueOf(com/ebay/nautilus/domain/data/Event$ListingType, s);
        }

        public static ListingType[] values()
        {
            return (ListingType[])$VALUES.clone();
        }

        static 
        {
            CHINESE_AUCTION = new ListingType("CHINESE_AUCTION", 0);
            DUTCH_AUCTION = new ListingType("DUTCH_AUCTION", 1);
            LIVE_AUCTION = new ListingType("LIVE_AUCTION", 2);
            AD = new ListingType("AD", 3);
            FIXED_PRICE = new ListingType("FIXED_PRICE", 4);
            PERSONAL_OFFER = new ListingType("PERSONAL_OFFER", 5);
            WANTED_ITEM = new ListingType("WANTED_ITEM", 6);
            HALF_SALE = new ListingType("HALF_SALE", 7);
            CLASSIFIED_AD = new ListingType("CLASSIFIED_AD", 8);
            EBX_ONLY = new ListingType("EBX_ONLY", 9);
            SDC_SALE = new ListingType("SDC_SALE", 10);
            EBAY_AD = new ListingType("EBAY_AD", 11);
            $VALUES = (new ListingType[] {
                CHINESE_AUCTION, DUTCH_AUCTION, LIVE_AUCTION, AD, FIXED_PRICE, PERSONAL_OFFER, WANTED_ITEM, HALF_SALE, CLASSIFIED_AD, EBX_ONLY, 
                SDC_SALE, EBAY_AD
            });
        }

        private ListingType(String s, int i)
        {
            super(s, i);
        }
    }

    public static final class MinimumAdvertisedPriceExposure extends Enum
    {

        private static final MinimumAdvertisedPriceExposure $VALUES[];
        public static final MinimumAdvertisedPriceExposure DuringCheckout;
        public static final MinimumAdvertisedPriceExposure None;
        public static final MinimumAdvertisedPriceExposure PreCheckout;

        public static MinimumAdvertisedPriceExposure valueOf(String s)
        {
            return (MinimumAdvertisedPriceExposure)Enum.valueOf(com/ebay/nautilus/domain/data/Event$MinimumAdvertisedPriceExposure, s);
        }

        public static MinimumAdvertisedPriceExposure[] values()
        {
            return (MinimumAdvertisedPriceExposure[])$VALUES.clone();
        }

        static 
        {
            None = new MinimumAdvertisedPriceExposure("None", 0);
            PreCheckout = new MinimumAdvertisedPriceExposure("PreCheckout", 1);
            DuringCheckout = new MinimumAdvertisedPriceExposure("DuringCheckout", 2);
            $VALUES = (new MinimumAdvertisedPriceExposure[] {
                None, PreCheckout, DuringCheckout
            });
        }

        private MinimumAdvertisedPriceExposure(String s, int i)
        {
            super(s, i);
        }
    }

    public static class PaginationResponse
    {

        public int entriesPerPage;
        public int pageNumber;
        public int totalPages;

        public PaginationResponse()
        {
        }
    }

    public static final class PricingTreatment extends Enum
    {

        private static final PricingTreatment $VALUES[];
        public static final PricingTreatment MAP;
        public static final PricingTreatment None;
        public static final PricingTreatment STP;

        public static PricingTreatment valueOf(String s)
        {
            return (PricingTreatment)Enum.valueOf(com/ebay/nautilus/domain/data/Event$PricingTreatment, s);
        }

        public static PricingTreatment[] values()
        {
            return (PricingTreatment[])$VALUES.clone();
        }

        static 
        {
            None = new PricingTreatment("None", 0);
            STP = new PricingTreatment("STP", 1);
            MAP = new PricingTreatment("MAP", 2);
            $VALUES = (new PricingTreatment[] {
                None, STP, MAP
            });
        }

        private PricingTreatment(String s, int i)
        {
            super(s, i);
        }
    }

    public static class SearchRecord
        implements Comparable
    {

        public Item item;

        public int compareTo(SearchRecord searchrecord)
        {
            return Long.valueOf(item.itemId).compareTo(Long.valueOf(searchrecord.item.itemId));
        }

        public volatile int compareTo(Object obj)
        {
            return compareTo((SearchRecord)obj);
        }

        public SearchRecord()
        {
        }
    }

    public class SearchRefinement
    {

        public List categoryHistogram;
        final Event this$0;

        public String toString()
        {
            return (new StringBuilder()).append("SearchRefinement(").append(categoryHistogram).append(")").toString();
        }

        public SearchRefinement()
        {
            this$0 = Event.this;
            super();
        }
    }

    public class SellerInfo
    {

        public long sellerId;
        final Event this$0;
        public String userName;

        public SellerInfo()
        {
            this$0 = Event.this;
            super();
        }
    }

    public class SellingStatus
    {

        public int bidCount;
        public Amount currentPrice;
        public String currentPriceText;
        public boolean ended;
        public int quantitySold;
        public boolean soldAsBestOffer;
        public boolean soldOut;
        final Event this$0;
        public String timeLeft;
        public int totalQuantity;

        public SellingStatus()
        {
            this$0 = Event.this;
            super();
        }
    }

    public class ShippingInfo
    {

        public boolean freeShippingAvailable;
        public Amount shippingCost;
        public ShippingType shippingType;
        public List shipsToLocation;
        final Event this$0;

        public ShippingInfo()
        {
            this$0 = Event.this;
            super();
        }
    }

    public static final class ShippingType extends Enum
    {

        private static final ShippingType $VALUES[];
        public static final ShippingType Calculated;
        public static final ShippingType CalculatedDomestic;
        public static final ShippingType CalculatedIntl;
        public static final ShippingType ContactSeller;
        public static final ShippingType DigitalDelivery;
        public static final ShippingType Free;
        public static final ShippingType Freight;
        public static final ShippingType LocalDelivery;
        public static final ShippingType NotSpecified;
        public static final ShippingType SeeDescription;

        public static ShippingType valueOf(String s)
        {
            return (ShippingType)Enum.valueOf(com/ebay/nautilus/domain/data/Event$ShippingType, s);
        }

        public static ShippingType[] values()
        {
            return (ShippingType[])$VALUES.clone();
        }

        static 
        {
            NotSpecified = new ShippingType("NotSpecified", 0);
            ContactSeller = new ShippingType("ContactSeller", 1);
            SeeDescription = new ShippingType("SeeDescription", 2);
            LocalDelivery = new ShippingType("LocalDelivery", 3);
            DigitalDelivery = new ShippingType("DigitalDelivery", 4);
            Free = new ShippingType("Free", 5);
            Freight = new ShippingType("Freight", 6);
            Calculated = new ShippingType("Calculated", 7);
            CalculatedIntl = new ShippingType("CalculatedIntl", 8);
            CalculatedDomestic = new ShippingType("CalculatedDomestic", 9);
            $VALUES = (new ShippingType[] {
                NotSpecified, ContactSeller, SeeDescription, LocalDelivery, DigitalDelivery, Free, Freight, Calculated, CalculatedIntl, CalculatedDomestic
            });
        }

        private ShippingType(String s, int i)
        {
            super(s, i);
        }
    }


    public long matchCount;
    public PaginationResponse paginationResponse;
    public List searchRecord;
    public SearchRefinement searchRefinement;

    public Event()
    {
    }
}
