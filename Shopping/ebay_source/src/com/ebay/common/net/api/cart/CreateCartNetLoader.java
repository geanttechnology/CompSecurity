// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.data.Address;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartApi

public class CreateCartNetLoader extends EbaySimpleNetLoader
{

    private final Address address;
    private final EbayCartApi api;
    private final String itemId;
    private final int quantity;
    private final String transactionId;
    private final boolean useProgressiveCheckout;
    private final String variationId;

    public CreateCartNetLoader(EbayContext ebaycontext, EbayCartApi ebaycartapi, Address address1, int i, String s, String s1, String s2, 
            boolean flag)
    {
        super(ebaycontext);
        api = ebaycartapi;
        address = address1;
        quantity = i;
        itemId = s;
        transactionId = s1;
        variationId = s2;
        useProgressiveCheckout = flag;
    }

    protected EbayRequest createRequest()
    {
        return new CreateCart.CreateCartRequest(api, address, Integer.valueOf(quantity), itemId, transactionId, variationId, useProgressiveCheckout);
    }

    public boolean isServiceError()
    {
        return false;
    }
}
