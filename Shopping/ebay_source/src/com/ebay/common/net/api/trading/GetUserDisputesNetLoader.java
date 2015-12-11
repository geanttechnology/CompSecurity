// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetUserDisputesRequest

public class GetUserDisputesNetLoader extends EbaySimpleNetLoader
{

    private final EbayTradingApi api;
    private final int pageNumber;

    public GetUserDisputesNetLoader(EbayContext ebaycontext, EbayTradingApi ebaytradingapi, int i)
    {
        super(ebaycontext);
        api = ebaytradingapi;
        pageNumber = i;
    }

    protected EbayRequest createRequest()
    {
        return new GetUserDisputesRequest(api, pageNumber);
    }
}
