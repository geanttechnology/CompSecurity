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

public class SetShippingAddressNetLoader extends EbaySimpleNetLoader
{

    private final EbayCartApi api;
    private final String cartId;
    private final Address shippingAddress;

    public SetShippingAddressNetLoader(EbayContext ebaycontext, EbayCartApi ebaycartapi, Address address, String s)
    {
        super(ebaycontext);
        api = ebaycartapi;
        shippingAddress = address;
        cartId = s;
    }

    protected EbayRequest createRequest()
    {
        return new SetShippingAddress.SetShippingAddressRequest(api, shippingAddress, cartId);
    }

    public boolean isServiceError()
    {
        return false;
    }
}
