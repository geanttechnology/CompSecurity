// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import java.util.HashSet;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayCountsRequest, EbayTradingApi

public final class GetMyEbayBuyingCountsRequest extends GetMyEbayCountsRequest
{

    public GetMyEbayBuyingCountsRequest(EbayTradingApi ebaytradingapi, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        super(ebaytradingapi, "GetMyeBayBuying");
        if (flag)
        {
            lists.add("BidList");
        }
        if (flag1)
        {
            lists.add("WonList");
        }
        if (flag2)
        {
            lists.add("LostList");
        }
        if (flag3)
        {
            lists.add("BestOfferList");
        }
    }
}
