// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.data.MyEbayListItem;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetItemTransactionsRequest

public class GetItemTransactionsNetLoader extends EbaySimpleNetLoader
{

    private final EbayTradingApi api;
    private final long itemId;
    public MyEbayListItem myEbayListItem;
    private final long transactionId;

    public GetItemTransactionsNetLoader(EbayContext ebaycontext, EbayTradingApi ebaytradingapi, long l, long l1)
    {
        super(ebaycontext);
        api = ebaytradingapi;
        itemId = l;
        transactionId = l1;
    }

    protected EbayRequest createRequest()
    {
        return new GetItemTransactionsRequest(api, itemId, transactionId);
    }
}
