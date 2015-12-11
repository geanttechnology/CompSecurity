// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.events;


// Referenced classes of package com.ebay.nautilus.domain.net.api.events:
//            EventItemsRequest

public static final class  extends Enum
{

    private static final NumberOfReturnDays $VALUES[];
    public static final NumberOfReturnDays AuthorizedSellerOnly;
    public static final NumberOfReturnDays AvailableTo;
    public static final NumberOfReturnDays BestOfferOnly;
    public static final NumberOfReturnDays CashOnDelivery;
    public static final NumberOfReturnDays CharityOnly;
    public static final NumberOfReturnDays CompletedListingsOnly;
    public static final NumberOfReturnDays EbayNowDelivery;
    public static final NumberOfReturnDays EndEventDate;
    public static final NumberOfReturnDays EndTimeFrom;
    public static final NumberOfReturnDays EndTimeMoreThanHours;
    public static final NumberOfReturnDays EndTimeTo;
    public static final NumberOfReturnDays EndTimeWithinHours;
    public static final NumberOfReturnDays ExcludeLocalPickupItems;
    public static final NumberOfReturnDays ExcludeSeller;
    public static final NumberOfReturnDays ExpeditedShippingType;
    public static final NumberOfReturnDays FreeShippingOnly;
    public static final NumberOfReturnDays GetItFastOnly;
    public static final NumberOfReturnDays IncludeLocalOnlyItems;
    public static final NumberOfReturnDays IncludeSeller;
    public static final NumberOfReturnDays IntermediatedShippingOnly;
    public static final NumberOfReturnDays ItemCondition;
    public static final NumberOfReturnDays ListingType;
    public static final NumberOfReturnDays LocalMerchantStorePickupOnly;
    public static final NumberOfReturnDays LocalPickupOnly;
    public static final NumberOfReturnDays LocatedIn;
    public static final NumberOfReturnDays LockerPickUpOption;
    public static final NumberOfReturnDays LotsOnly;
    public static final NumberOfReturnDays MaxBids;
    public static final NumberOfReturnDays MaxDistance;
    public static final NumberOfReturnDays MaxHandlingTime;
    public static final NumberOfReturnDays MaxPrice;
    public static final NumberOfReturnDays MaxQuantity;
    public static final NumberOfReturnDays MinBids;
    public static final NumberOfReturnDays MinPrice;
    public static final NumberOfReturnDays MinQuantity;
    public static final NumberOfReturnDays NoReservePrice;
    public static final NumberOfReturnDays NotLocatedIn;
    public static final NumberOfReturnDays NumberOfReturnDays;
    public static final NumberOfReturnDays OneDayHandling;
    public static final NumberOfReturnDays OnePaisaAuction;
    public static final NumberOfReturnDays OutletSellerOnly;
    public static final NumberOfReturnDays PaymentMethod;
    public static final NumberOfReturnDays PreferredItemLocation;
    public static final NumberOfReturnDays PreferredLocation;
    public static final NumberOfReturnDays PromotionSale;
    public static final NumberOfReturnDays PromotionalRebates;
    public static final NumberOfReturnDays ReturnsAcceptedOnly;
    public static final NumberOfReturnDays SellerBusinessType;
    public static final NumberOfReturnDays SellerOffer;
    public static final NumberOfReturnDays SellersWithStore;
    public static final NumberOfReturnDays SoldItemsOnly;
    public static final NumberOfReturnDays StartEventDate;
    public static final NumberOfReturnDays StartTimeFrom;
    public static final NumberOfReturnDays StartTimeTo;
    public static final NumberOfReturnDays StartTimeWithinHours;
    public static final NumberOfReturnDays TopRatedSellersOnly;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/nautilus/domain/net/api/events/EventItemsRequest$ConstraintType, s);
    }

    public static [] values()
    {
        return ([])$VALUES.clone();
    }

    static 
    {
        ItemCondition = new <init>("ItemCondition", 0);
        EndTimeFrom = new <init>("EndTimeFrom", 1);
        EndTimeTo = new <init>("EndTimeTo", 2);
        BestOfferOnly = new <init>("BestOfferOnly", 3);
        FreeShippingOnly = new <init>("FreeShippingOnly", 4);
        GetItFastOnly = new <init>("GetItFastOnly", 5);
        AvailableTo = new <init>("AvailableTo", 6);
        LocatedIn = new <init>("LocatedIn", 7);
        PreferredLocation = new <init>("PreferredLocation", 8);
        LocalPickupOnly = new <init>("LocalPickupOnly", 9);
        ListingType = new <init>("ListingType", 10);
        LotsOnly = new <init>("LotsOnly", 11);
        MaxBids = new <init>("MaxBids", 12);
        MinBids = new <init>("MinBids", 13);
        MaxPrice = new <init>("MaxPrice", 14);
        MinPrice = new <init>("MinPrice", 15);
        PaymentMethod = new <init>("PaymentMethod", 16);
        MaxQuantity = new <init>("MaxQuantity", 17);
        MinQuantity = new <init>("MinQuantity", 18);
        IncludeSeller = new <init>("IncludeSeller", 19);
        ExcludeSeller = new <init>("ExcludeSeller", 20);
        SellersWithStore = new <init>("SellersWithStore", 21);
        MaxDistance = new <init>("MaxDistance", 22);
        SellerBusinessType = new <init>("SellerBusinessType", 23);
        TopRatedSellersOnly = new <init>("TopRatedSellersOnly", 24);
        SoldItemsOnly = new <init>("SoldItemsOnly", 25);
        CharityOnly = new <init>("CharityOnly", 26);
        OneDayHandling = new <init>("OneDayHandling", 27);
        ExpeditedShippingType = new <init>("ExpeditedShippingType", 28);
        MaxHandlingTime = new <init>("MaxHandlingTime", 29);
        ReturnsAcceptedOnly = new <init>("ReturnsAcceptedOnly", 30);
        OutletSellerOnly = new <init>("OutletSellerOnly", 31);
        AuthorizedSellerOnly = new <init>("AuthorizedSellerOnly", 32);
        StartTimeFrom = new <init>("StartTimeFrom", 33);
        StartTimeTo = new <init>("StartTimeTo", 34);
        CompletedListingsOnly = new <init>("CompletedListingsOnly", 35);
        CashOnDelivery = new <init>("CashOnDelivery", 36);
        OnePaisaAuction = new <init>("OnePaisaAuction", 37);
        PromotionSale = new <init>("PromotionSale", 38);
        EndTimeWithinHours = new <init>("EndTimeWithinHours", 39);
        EndTimeMoreThanHours = new <init>("EndTimeMoreThanHours", 40);
        StartTimeWithinHours = new <init>("StartTimeWithinHours", 41);
        StartEventDate = new <init>("StartEventDate", 42);
        EndEventDate = new <init>("EndEventDate", 43);
        PromotionalRebates = new <init>("PromotionalRebates", 44);
        NoReservePrice = new <init>("NoReservePrice", 45);
        LocalMerchantStorePickupOnly = new <init>("LocalMerchantStorePickupOnly", 46);
        EbayNowDelivery = new <init>("EbayNowDelivery", 47);
        PreferredItemLocation = new <init>("PreferredItemLocation", 48);
        NotLocatedIn = new <init>("NotLocatedIn", 49);
        SellerOffer = new <init>("SellerOffer", 50);
        IncludeLocalOnlyItems = new <init>("IncludeLocalOnlyItems", 51);
        ExcludeLocalPickupItems = new <init>("ExcludeLocalPickupItems", 52);
        IntermediatedShippingOnly = new <init>("IntermediatedShippingOnly", 53);
        LockerPickUpOption = new <init>("LockerPickUpOption", 54);
        NumberOfReturnDays = new <init>("NumberOfReturnDays", 55);
        $VALUES = (new .VALUES[] {
            ItemCondition, EndTimeFrom, EndTimeTo, BestOfferOnly, FreeShippingOnly, GetItFastOnly, AvailableTo, LocatedIn, PreferredLocation, LocalPickupOnly, 
            ListingType, LotsOnly, MaxBids, MinBids, MaxPrice, MinPrice, PaymentMethod, MaxQuantity, MinQuantity, IncludeSeller, 
            ExcludeSeller, SellersWithStore, MaxDistance, SellerBusinessType, TopRatedSellersOnly, SoldItemsOnly, CharityOnly, OneDayHandling, ExpeditedShippingType, MaxHandlingTime, 
            ReturnsAcceptedOnly, OutletSellerOnly, AuthorizedSellerOnly, StartTimeFrom, StartTimeTo, CompletedListingsOnly, CashOnDelivery, OnePaisaAuction, PromotionSale, EndTimeWithinHours, 
            EndTimeMoreThanHours, StartTimeWithinHours, StartEventDate, EndEventDate, PromotionalRebates, NoReservePrice, LocalMerchantStorePickupOnly, EbayNowDelivery, PreferredItemLocation, NotLocatedIn, 
            SellerOffer, IncludeLocalOnlyItems, ExcludeLocalPickupItems, IntermediatedShippingOnly, LockerPickUpOption, NumberOfReturnDays
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
