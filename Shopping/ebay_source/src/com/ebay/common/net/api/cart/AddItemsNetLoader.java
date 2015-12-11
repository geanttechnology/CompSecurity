// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartApi

public class AddItemsNetLoader extends EbaySimpleNetLoader
{

    private final EbayCartApi api;
    private final String cartId;
    private final int donationAmountId;
    private final String isoCurrencyCode;
    private final String nonprofitId;
    private final int requestedQuantity;

    public AddItemsNetLoader(EbayContext ebaycontext, EbayCartApi ebaycartapi, String s, String s1, int i, String s2, int j)
    {
        super(ebaycontext);
        api = ebaycartapi;
        cartId = s;
        nonprofitId = s1;
        donationAmountId = i;
        isoCurrencyCode = s2;
        requestedQuantity = j;
    }

    protected EbayRequest createRequest()
    {
        return new AddItems.AddItemsRequest(api, cartId, nonprofitId, donationAmountId, isoCurrencyCode, requestedQuantity);
    }

    public boolean isServiceError()
    {
        return false;
    }
}
