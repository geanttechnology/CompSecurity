// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.recommendation;

import com.ebay.nautilus.domain.data.BaseListingType;
import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;
import java.util.List;

public final class Placements extends BaseApiResponse
{
    public static final class CompactListing_v2_1 extends BaseListingType
    {

        public int bidCount;
        public String clickTracking;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount currentBidPrice;
        public com.ebay.nautilus.domain.data.BaseCommonType.Amount fixedPrice;
        public com.ebay.nautilus.domain.data.BaseListingType.ListingFormatEnum format;
        public boolean freeshippingAvailable;
        public String imageURL;
        public String listingId;
        public com.ebay.nautilus.domain.data.BaseListingType.MarketplaceIdEnum marketplaceListedOn;
        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime scheduledEndDate;
        public com.ebay.nautilus.domain.data.BaseCommonType.DateTime scheduledStartDate;
        public com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum status;
        public com.ebay.nautilus.domain.data.BaseCommonType.Text title;

        public CompactListing_v2_1()
        {
            status = com.ebay.nautilus.domain.data.BaseListingType.ListingStatusEnum.ACTIVE;
        }
    }

    public final class PlacementId
    {

        public static final long VIP_ABOVE_DESCRIPTION = 0x18754L;
        public static final long VIP_ABOVE_DESCRIPTION_ENDED = 0x18755L;
        public static final long XO_AFTER_CHECKOUT_PRIMARY = 0x1873dL;
        final Placements this$0;

        public PlacementId()
        {
            this$0 = Placements.this;
            super();
        }
    }

    public static final class RecoPlacement
    {

        public List listings;
        public String placementHeader;
        public Long placementId;

        public RecoPlacement()
        {
        }
    }


    public String impression;
    public List members;
    public Long total;

    public Placements()
    {
    }
}
