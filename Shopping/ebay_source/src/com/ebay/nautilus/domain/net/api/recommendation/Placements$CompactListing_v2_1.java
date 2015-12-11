// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.recommendation;

import com.ebay.nautilus.domain.data.BaseListingType;

// Referenced classes of package com.ebay.nautilus.domain.net.api.recommendation:
//            Placements

public static final class status extends BaseListingType
{

    public int bidCount;
    public String clickTracking;
    public com.ebay.nautilus.domain.data.mpactListing_v2_1 currentBidPrice;
    public com.ebay.nautilus.domain.data.mpactListing_v2_1 fixedPrice;
    public com.ebay.nautilus.domain.data.um format;
    public boolean freeshippingAvailable;
    public String imageURL;
    public String listingId;
    public com.ebay.nautilus.domain.data.um marketplaceListedOn;
    public com.ebay.nautilus.domain.data.um scheduledEndDate;
    public com.ebay.nautilus.domain.data.um scheduledStartDate;
    public com.ebay.nautilus.domain.data.um status;
    public com.ebay.nautilus.domain.data.um title;

    public ()
    {
        status = com.ebay.nautilus.domain.data.um.ACTIVE;
    }
}
