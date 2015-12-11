// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.viewlisting;

import com.ebay.nautilus.domain.net.dataobject.BaseApiResponse;

// Referenced classes of package com.ebay.nautilus.domain.net.api.viewlisting:
//            ListingBuyingContext, Listing

public final class ListingDetails extends BaseApiResponse
{

    public ListingBuyingContext buyingContext;
    public String errorCode;
    public Listing listing;
    public transient String trackingCorrelationId;
    public transient String trackingData;

    public ListingDetails()
    {
    }
}
