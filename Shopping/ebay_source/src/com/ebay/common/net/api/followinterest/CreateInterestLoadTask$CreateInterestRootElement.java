// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.followinterest;

import com.ebay.common.net.api.search.SearchParameters;
import com.ebay.nautilus.domain.EbayCountry;

// Referenced classes of package com.ebay.common.net.api.followinterest:
//            CreateInterestLoadTask, InterestDescriptor, SaasSearchRequest

private static class interest
{

    public static final String CREATION_TYPE_INTEREST = "interest";
    public final InterestDescriptor interest = new InterestDescriptor();
    public String type;

    public (SearchParameters searchparameters)
    {
        type = "interest";
        interest.marketplaceId = searchparameters.country.getSiteGlobalId();
        interest.searchUrl = null;
        interest.searchRequest = SaasSearchRequest.fromSearchParameters(searchparameters);
    }
}
