// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.content.EbayContext;
import java.util.List;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartApi

public class UpdateCartNetLoader extends EbaySimpleNetLoader
{

    private final EbayCartApi api;
    private final String cartId;
    private final String cartLineItemId;
    private final List incentivesToAdd;
    private final List incentivesToRemove;
    private final String lineItemToRemove;
    private final String noteToSeller;
    private final Integer quantity;
    private final String sellerIdentifier;
    private final String shippingServiceId;

    public UpdateCartNetLoader(EbayContext ebaycontext, EbayCartApi ebaycartapi, String s, String s1)
    {
        this(ebaycontext, ebaycartapi, s, s1, null, null, null, null, null, null, s1);
    }

    public UpdateCartNetLoader(EbayContext ebaycontext, EbayCartApi ebaycartapi, String s, String s1, int i)
    {
        this(ebaycontext, ebaycartapi, s, s1, null, Integer.valueOf(i), null, null, null, null, null);
    }

    public UpdateCartNetLoader(EbayContext ebaycontext, EbayCartApi ebaycartapi, String s, String s1, String s2)
    {
        this(ebaycontext, ebaycartapi, s, s1, s2, null, null, null, null, null, null);
    }

    private UpdateCartNetLoader(EbayContext ebaycontext, EbayCartApi ebaycartapi, String s, String s1, String s2, Integer integer, List list, 
            List list1, String s3, String s4, String s5)
    {
        super(ebaycontext);
        api = ebaycartapi;
        cartId = s;
        cartLineItemId = s1;
        shippingServiceId = s2;
        quantity = integer;
        incentivesToAdd = list;
        incentivesToRemove = list1;
        sellerIdentifier = s3;
        noteToSeller = s4;
        lineItemToRemove = s5;
    }

    public UpdateCartNetLoader(EbayContext ebaycontext, EbayCartApi ebaycartapi, String s, String s1, String s2, String s3)
    {
        this(ebaycontext, ebaycartapi, s, null, null, null, null, null, s2, s3, null);
    }

    public UpdateCartNetLoader(EbayContext ebaycontext, EbayCartApi ebaycartapi, String s, List list, List list1)
    {
        this(ebaycontext, ebaycartapi, s, null, null, null, list, list1, null, null, null);
    }

    protected EbayRequest createRequest()
    {
        return new UpdateCart.UpdateCartRequest(api, cartId, cartLineItemId, shippingServiceId, quantity, incentivesToAdd, incentivesToRemove, sellerIdentifier, noteToSeller, lineItemToRemove);
    }

    public boolean isServiceError()
    {
        return false;
    }
}
