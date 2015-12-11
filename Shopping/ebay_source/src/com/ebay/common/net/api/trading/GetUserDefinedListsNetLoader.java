// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetUserDefinedListsRequest

public class GetUserDefinedListsNetLoader extends EbaySimpleNetLoader
{

    private final EbayTradingApi api;
    private final boolean includeAll;
    private final String list;

    public GetUserDefinedListsNetLoader(EbayContext ebaycontext, EbayTradingApi ebaytradingapi, boolean flag)
    {
        this(ebaycontext, ebaytradingapi, flag, null);
    }

    public GetUserDefinedListsNetLoader(EbayContext ebaycontext, EbayTradingApi ebaytradingapi, boolean flag, String s)
    {
        super(ebaycontext);
        api = ebaytradingapi;
        includeAll = flag;
        list = s;
    }

    protected EbayRequest createRequest()
    {
        return new GetUserDefinedListsRequest(api, null, includeAll, list);
    }
}
