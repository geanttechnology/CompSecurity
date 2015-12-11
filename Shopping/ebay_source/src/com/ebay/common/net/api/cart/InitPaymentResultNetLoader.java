// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartApi

public class InitPaymentResultNetLoader extends EbaySimpleNetLoader
{

    private final EbayCartApi api;
    private final String cartId;

    public InitPaymentResultNetLoader(EbayContext ebaycontext, EbayCartApi ebaycartapi, String s)
    {
        super(ebaycontext);
        api = ebaycartapi;
        cartId = s;
    }

    protected EbayRequest createRequest()
    {
        return new InitPaymentResult.InitPaymentResultRequest(api, cartId);
    }

    public boolean isServiceError()
    {
        return false;
    }
}
