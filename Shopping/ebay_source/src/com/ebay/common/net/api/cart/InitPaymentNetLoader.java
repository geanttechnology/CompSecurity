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

public class InitPaymentNetLoader extends EbaySimpleNetLoader
{

    private final EbayCartApi api;
    private final String cartId;
    private final boolean guestXO;
    private final String paymentMethod;
    private final Address shippingAddress;

    public InitPaymentNetLoader(EbayContext ebaycontext, EbayCartApi ebaycartapi, String s, Address address, boolean flag, String s1)
    {
        super(ebaycontext);
        api = ebaycartapi;
        cartId = s;
        shippingAddress = address;
        guestXO = flag;
        paymentMethod = s1;
    }

    protected EbayRequest createRequest()
    {
        return new InitPayment.InitPaymentRequest(api, cartId, shippingAddress, guestXO, paymentMethod);
    }

    public boolean isServiceError()
    {
        return false;
    }
}
