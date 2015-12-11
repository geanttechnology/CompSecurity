// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.data.UnifiedStream;

import com.ebay.nautilus.domain.data.CompactListing;
import java.util.List;

// Referenced classes of package com.ebay.nautilus.domain.data.UnifiedStream:
//            Contents

public static final class EekInfo extends CompactListing
{
    public static final class DiscountPrice extends com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPrice
    {

        public com.ebay.nautilus.domain.net.api.viewlisting.Listing.DiscountPriceTypeEnum discountPriceEnum;

        public DiscountPrice()
        {
        }
    }

    public static final class EekInfo
    {

        public String displayText;
        public String label;
        public List status;

        public EekInfo()
        {
        }
    }


    public List aspectValuesList;
    public Boolean dealMsku;
    public List dealVariations;
    public List discountPrices;
    public EekInfo eekInfo;
    public boolean freeShippingAvailable;
    public String imageUrl;
    public Boolean multipleVariationsListed;
    public List purchaseOptions;
    public com.ebay.nautilus.domain.net.api.viewlisting.ans quantityAndAvailabilityByLogisticsPlans;
    public Integer rtmTrackingUrl;
    public com.ebay.nautilus.domain.data.tyByLogisticsPlans timeRemaining;

    public EekInfo()
    {
    }
}
