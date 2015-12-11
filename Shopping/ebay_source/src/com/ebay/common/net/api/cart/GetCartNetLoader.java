// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartApi

public class GetCartNetLoader extends EbaySimpleNetLoader
{

    private final EbayCartApi api;
    private final String cartId;
    private final String outputCurrencyCode;

    public GetCartNetLoader(EbayContext ebaycontext, EbayCartApi ebaycartapi, String s, String s1)
    {
        super(ebaycontext);
        api = ebaycartapi;
        cartId = s;
        outputCurrencyCode = s1;
    }

    protected EbayRequest createRequest()
    {
        return new GetCart.GetCartRequest(api, cartId, outputCurrencyCode);
    }

    public boolean isServiceError()
    {
        return false;
    }
}
