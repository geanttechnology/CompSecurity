// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.search.idealmodel;

import android.text.TextUtils;
import com.ebay.nautilus.domain.data.Distance;
import com.ebay.nautilus.domain.data.EbaySearchListItem;
import com.ebay.nautilus.domain.data.ItemCurrency;
import java.util.Date;

public class SrpListItemViewModel
{

    public Integer bidCount;
    public ItemCurrency convertedPrice;
    public double distanceLength;
    public String distanceUnit;
    public String eekRating;
    public Date endDate;
    public boolean hasAuction;
    public long id;
    public String imageUrl;
    public String imageZoomGuid;
    public String imageZoomMd5;
    public boolean isAbin;
    public boolean isBestOffer;
    public boolean isClassified;
    public boolean isEbayPlus;
    public boolean isEbn;
    public boolean isEndedWithoutSale;
    public boolean isIspu;
    public boolean isLocal;
    public boolean isMap;
    public boolean isMsku;
    public boolean isPromoted;
    public boolean isPudo;
    public boolean isSold;
    public ItemCurrency price;
    public String pricingTreatment;
    public String promotedLabel;
    public ItemCurrency shipping;
    public String shippingType;
    public ItemCurrency strikeThruPrice;
    public String title;
    public String unitPriceQuantity;
    public String unitPriceType;

    public SrpListItemViewModel()
    {
    }

    public static SrpListItemViewModel instanceFrom(EbaySearchListItem ebaysearchlistitem)
    {
        SrpListItemViewModel srplistitemviewmodel;
label0:
        {
            boolean flag1 = false;
            srplistitemviewmodel = new SrpListItemViewModel();
            srplistitemviewmodel.id = ebaysearchlistitem.id;
            srplistitemviewmodel.imageUrl = ebaysearchlistitem.imageUrl;
            srplistitemviewmodel.imageZoomGuid = ebaysearchlistitem.imageZoomGuid;
            srplistitemviewmodel.imageZoomMd5 = ebaysearchlistitem.imageMd5Hash;
            srplistitemviewmodel.title = ebaysearchlistitem.title;
            srplistitemviewmodel.eekRating = ebaysearchlistitem.eekRating;
            boolean flag;
            if (ebaysearchlistitem.isMsku && ebaysearchlistitem.minPrice != null)
            {
                srplistitemviewmodel.price = ebaysearchlistitem.minPrice;
                srplistitemviewmodel.convertedPrice = ebaysearchlistitem.convertedMinPrice;
            } else
            {
                srplistitemviewmodel.price = ebaysearchlistitem.currentPrice;
                srplistitemviewmodel.convertedPrice = ebaysearchlistitem.convertedCurrentPrice;
            }
            srplistitemviewmodel.unitPriceQuantity = ebaysearchlistitem.unitPriceQuantity;
            srplistitemviewmodel.unitPriceType = ebaysearchlistitem.unitPriceType;
            srplistitemviewmodel.shipping = ebaysearchlistitem.shippingCost;
            srplistitemviewmodel.shippingType = ebaysearchlistitem.shippingType;
            srplistitemviewmodel.isMap = "MAP".equals(ebaysearchlistitem.pricingTreatment);
            if (TextUtils.isEmpty(ebaysearchlistitem.unitPriceType) && TextUtils.isEmpty(ebaysearchlistitem.unitPriceQuantity) || !srplistitemviewmodel.isMap)
            {
                if (ebaysearchlistitem.listingType == 4)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                srplistitemviewmodel.isClassified = flag;
            }
            if (!srplistitemviewmodel.isClassified && ebaysearchlistitem.bestOfferEnabled)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            srplistitemviewmodel.isBestOffer = flag;
            if (!srplistitemviewmodel.isClassified && ebaysearchlistitem.buyItNowAvailable && ebaysearchlistitem.listingType == 3)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            srplistitemviewmodel.isAbin = flag;
            if (ebaysearchlistitem.listingType != 2)
            {
                flag = flag1;
                if (!ebaysearchlistitem.buyItNowAvailable)
                {
                    break label0;
                }
                flag = flag1;
                if (ebaysearchlistitem.listingType != 3)
                {
                    break label0;
                }
            }
            flag = true;
        }
        srplistitemviewmodel.hasAuction = flag;
        if (srplistitemviewmodel.hasAuction)
        {
            srplistitemviewmodel.bidCount = Integer.valueOf(ebaysearchlistitem.bidCount);
        }
        if (srplistitemviewmodel.isMap || !ebaysearchlistitem.bestOfferEnabled && !srplistitemviewmodel.isAbin && (TextUtils.isEmpty(ebaysearchlistitem.unitPriceType) || TextUtils.isEmpty(ebaysearchlistitem.unitPriceQuantity)) && !srplistitemviewmodel.isClassified)
        {
            srplistitemviewmodel.strikeThruPrice = ebaysearchlistitem.originalRetailPrice;
        }
        if (ebaysearchlistitem.distance != null)
        {
            srplistitemviewmodel.distanceLength = ebaysearchlistitem.distance.length;
            srplistitemviewmodel.distanceUnit = ebaysearchlistitem.distance.unit;
        }
        srplistitemviewmodel.isIspu = ebaysearchlistitem.isInStorePickup;
        srplistitemviewmodel.isPudo = ebaysearchlistitem.isPickupAndDropOff;
        srplistitemviewmodel.isEbn = ebaysearchlistitem.isEbn;
        srplistitemviewmodel.isMsku = ebaysearchlistitem.isMsku;
        srplistitemviewmodel.pricingTreatment = ebaysearchlistitem.pricingTreatment;
        if (!TextUtils.isEmpty(ebaysearchlistitem.shippingType) && TextUtils.isEmpty(ebaysearchlistitem.shipToLocation) && (ebaysearchlistitem.shippingType.equals("LocalDelivery") || ebaysearchlistitem.shippingType.equals("FreePickup") && ebaysearchlistitem.shipToLocation.equals("None")))
        {
            srplistitemviewmodel.isLocal = true;
        }
        srplistitemviewmodel.endDate = ebaysearchlistitem.endDate;
        srplistitemviewmodel.isEbayPlus = ebaysearchlistitem.isPlusEligible;
        switch (ebaysearchlistitem.sellingState)
        {
        default:
            return srplistitemviewmodel;

        case 4: // '\004'
            srplistitemviewmodel.isSold = true;
            return srplistitemviewmodel;

        case 5: // '\005'
            srplistitemviewmodel.isEndedWithoutSale = true;
            break;
        }
        return srplistitemviewmodel;
    }
}
