// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.domain.net.api.trading;

import java.util.HashSet;

// Referenced classes of package com.ebay.nautilus.domain.net.api.trading:
//            GetMyEbayCountsRequest, EbayTradingApi

public final class GetMyEbaySellingCountsRequest extends GetMyEbayCountsRequest
{

    public GetMyEbaySellingCountsRequest(EbayTradingApi ebaytradingapi, boolean flag, boolean flag1, boolean flag2, boolean flag3)
    {
        super(ebaytradingapi, "GetMyeBaySelling");
        if (flag)
        {
            lists.add("ActiveList");
        }
        if (flag1)
        {
            lists.add("SoldList");
        }
        if (flag2)
        {
            lists.add("UnsoldList");
        }
        if (flag3)
        {
            lists.add("ScheduledList");
        }
    }
}
