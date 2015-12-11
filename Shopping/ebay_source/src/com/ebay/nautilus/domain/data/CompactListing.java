// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data;

import java.util.List;

public class CompactListing
{
    public static final class ImageSummary
    {

        public String imageURL;

        public ImageSummary()
        {
        }
    }


    public int bidCount;
    public BaseCommonType.Amount currentBidPrice;
    public BaseListingType.ListingFormatEnum format;
    public boolean freeShippingAvailable;
    public List images;
    public String listingId;
    public String listingLocale;
    public BaseCommonType.Amount lowestFixedPrice;
    public BaseListingType.MarketplaceIdEnum marketplaceListedOn;
    public BaseCommonType.DateTime scheduledEndDate;
    public BaseCommonType.DateTime scheduledStartDate;
    public String serverSideTrackingInfo;
    public BaseListingType.ListingStatusEnum status;
    public BaseCommonType.Text title;

    public CompactListing()
    {
        status = BaseListingType.ListingStatusEnum.ACTIVE;
    }

    public String getPrimaryImageUrl()
    {
        if (images != null && !images.isEmpty())
        {
            return ((ImageSummary)images.get(0)).imageURL;
        } else
        {
            return null;
        }
    }
}
