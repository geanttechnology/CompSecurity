// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;


// Referenced classes of package com.ebay.common.net.api.followinterest:
//            SaasSearchRequest

public static final class  extends Enum
{

    private static final EbayPlus $VALUES[];
    public static final EbayPlus AuthorizedSellerOnly;
    public static final EbayPlus AvailableTo;
    public static final EbayPlus BestOfferOnly;
    public static final EbayPlus CashOnDelivery;
    public static final EbayPlus CharityOnly;
    public static final EbayPlus CompletedListingsOnly;
    public static final EbayPlus EPID;
    public static final EbayPlus EbayNowDelivery;
    public static final EbayPlus EbayPlus;
    public static final EbayPlus EndEventDate;
    public static final EbayPlus EndTimeFrom;
    public static final EbayPlus EndTimeMoreThanHours;
    public static final EbayPlus EndTimeTo;
    public static final EbayPlus EndTimeWithinHours;
    public static final EbayPlus ExcludeLocalPickupItems;
    public static final EbayPlus ExcludeSeller;
    public static final EbayPlus ExpeditedShippingType;
    public static final EbayPlus ExtendedHolidayReturnsEligibleOnly;
    public static final EbayPlus FreeShippingOnly;
    public static final EbayPlus GetItFastOnly;
    public static final EbayPlus ISBN;
    public static final EbayPlus IncludeLocalOnlyItems;
    public static final EbayPlus IncludeSeller;
    public static final EbayPlus IntermediatedShippingOnly;
    public static final EbayPlus ItemCondition;
    public static final EbayPlus ListingType;
    public static final EbayPlus LocalMerchantStorePickupOnly;
    public static final EbayPlus LocalPickupOnly;
    public static final EbayPlus LocatedIn;
    public static final EbayPlus LockerPickUpOption;
    public static final EbayPlus LotsOnly;
    public static final EbayPlus MPN;
    public static final EbayPlus MaxBids;
    public static final EbayPlus MaxDistance;
    public static final EbayPlus MaxHandlingTime;
    public static final EbayPlus MaxPrice;
    public static final EbayPlus MaxQuantity;
    public static final EbayPlus MinBids;
    public static final EbayPlus MinPrice;
    public static final EbayPlus MinQuantity;
    public static final EbayPlus NoReservePrice;
    public static final EbayPlus NotLocatedIn;
    public static final EbayPlus NumberOfReturnDays;
    public static final EbayPlus OneDayHandling;
    public static final EbayPlus OnePaisaAuction;
    public static final EbayPlus OutletSellerOnly;
    public static final EbayPlus PaymentMethod;
    public static final EbayPlus PreferredItemLocation;
    public static final EbayPlus PreferredLocation;
    public static final EbayPlus PromotionSale;
    public static final EbayPlus PromotionalRebates;
    public static final EbayPlus ReturnsAcceptedOnly;
    public static final EbayPlus SellerBusinessType;
    public static final EbayPlus SellerOffer;
    public static final EbayPlus SellerProductId;
    public static final EbayPlus SellersWithStore;
    public static final EbayPlus SoldItemsOnly;
    public static final EbayPlus StartEventDate;
    public static final EbayPlus StartTimeFrom;
    public static final EbayPlus StartTimeTo;
    public static final EbayPlus StartTimeWithinHours;
    public static final EbayPlus TopRatedSellersOnly;
    public static final EbayPlus UPC;

    public static  valueOf(String s)
    {
        return ()Enum.valueOf(com/ebay/common/net/api/followinterest/SaasSearchRequest$ConstraintType, s);
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
        EPID = new <init>("EPID", 56);
        UPC = new <init>("UPC", 57);
        MPN = new <init>("MPN", 58);
        ISBN = new <init>("ISBN", 59);
        SellerProductId = new <init>("SellerProductId", 60);
        ExtendedHolidayReturnsEligibleOnly = new <init>("ExtendedHolidayReturnsEligibleOnly", 61);
        EbayPlus = new <init>("EbayPlus", 62);
        $VALUES = (new .VALUES[] {
            ItemCondition, EndTimeFrom, EndTimeTo, BestOfferOnly, FreeShippingOnly, GetItFastOnly, AvailableTo, LocatedIn, PreferredLocation, LocalPickupOnly, 
            ListingType, LotsOnly, MaxBids, MinBids, MaxPrice, MinPrice, PaymentMethod, MaxQuantity, MinQuantity, IncludeSeller, 
            ExcludeSeller, SellersWithStore, MaxDistance, SellerBusinessType, TopRatedSellersOnly, SoldItemsOnly, CharityOnly, OneDayHandling, ExpeditedShippingType, MaxHandlingTime, 
            ReturnsAcceptedOnly, OutletSellerOnly, AuthorizedSellerOnly, StartTimeFrom, StartTimeTo, CompletedListingsOnly, CashOnDelivery, OnePaisaAuction, PromotionSale, EndTimeWithinHours, 
            EndTimeMoreThanHours, StartTimeWithinHours, StartEventDate, EndEventDate, PromotionalRebates, NoReservePrice, LocalMerchantStorePickupOnly, EbayNowDelivery, PreferredItemLocation, NotLocatedIn, 
            SellerOffer, IncludeLocalOnlyItems, ExcludeLocalPickupItems, IntermediatedShippingOnly, LockerPickUpOption, NumberOfReturnDays, EPID, UPC, MPN, ISBN, 
            SellerProductId, ExtendedHolidayReturnsEligibleOnly, EbayPlus
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
