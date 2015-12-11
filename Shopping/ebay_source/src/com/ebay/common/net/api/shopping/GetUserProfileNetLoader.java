// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shopping;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;
import com.ebay.nautilus.domain.net.api.shopping.GetUserProfileRequest;
import com.ebay.nautilus.kernel.content.EbayContext;

public class GetUserProfileNetLoader extends EbaySimpleNetLoader
{

    private final EbayShoppingApi api;
    private final String userId;

    public GetUserProfileNetLoader(EbayContext ebaycontext, EbayShoppingApi ebayshoppingapi, String s)
    {
        super(ebaycontext);
        api = ebayshoppingapi;
        userId = s;
    }

    protected EbayRequest createRequest()
    {
        return new GetUserProfileRequest(api, userId);
    }
}
