// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetSuggestedCategoriesRequest

public class GetSuggestedCategoriesNetLoader extends EbaySimpleNetLoader
{

    private final EbayTradingApi api;
    private final String query;

    public GetSuggestedCategoriesNetLoader(EbayContext ebaycontext, EbayTradingApi ebaytradingapi, String s)
    {
        super(ebaycontext);
        api = ebaytradingapi;
        query = s;
    }

    protected EbayRequest createRequest()
    {
        return new GetSuggestedCategoriesRequest(api, query);
    }
}
