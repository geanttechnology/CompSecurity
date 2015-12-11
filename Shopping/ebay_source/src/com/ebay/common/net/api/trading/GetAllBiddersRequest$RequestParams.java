// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetAllBiddersRequest

public static final class tradingApi
{

    public final long itemId;
    public final EbayTradingApi tradingApi;

    public String toString()
    {
        return (new StringBuilder()).append("ItemId: ").append(itemId).toString();
    }

    public (long l, EbayTradingApi ebaytradingapi)
    {
        itemId = l;
        tradingApi = ebaytradingapi;
    }
}
