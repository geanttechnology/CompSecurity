// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.trading;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.api.trading.EbayTradingApi;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.Locale;

// Referenced classes of package com.ebay.common.net.api.trading:
//            GetOrdersRequest

public class GetOrdersNetLoader extends EbaySimpleNetLoader
{

    private final EbayTradingApi api;
    private final String iafToken;
    private final Locale locale;
    private final String orderId;

    public GetOrdersNetLoader(EbayContext ebaycontext, EbayTradingApi ebaytradingapi, String s, Locale locale1, String s1)
    {
        super(ebaycontext);
        iafToken = s;
        api = ebaytradingapi;
        orderId = s1;
        locale = locale1;
    }

    protected EbayRequest createRequest()
    {
        return new GetOrdersRequest(api, iafToken, locale, orderId);
    }
}
