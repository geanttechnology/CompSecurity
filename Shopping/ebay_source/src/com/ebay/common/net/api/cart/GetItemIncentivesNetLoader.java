// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.cart;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.kernel.content.EbayContext;

// Referenced classes of package com.ebay.common.net.api.cart:
//            EbayCartApi

public class GetItemIncentivesNetLoader extends EbaySimpleNetLoader
{

    private final EbayCartApi api;
    private final String currency;
    private final String itemId;
    private final int quantityPurchased;
    private final boolean shortTimeout;
    private final String transactionId;
    private final GetItemIncentives.ItemIncentiveType types[];
    private final String variationId;

    public GetItemIncentivesNetLoader(EbayContext ebaycontext, EbayCartApi ebaycartapi, String s, String s1, String s2, String s3, int i, 
            boolean flag, boolean flag1)
    {
        GetItemIncentives.ItemIncentiveType itemincentivetype;
        if (flag)
        {
            itemincentivetype = GetItemIncentives.ItemIncentiveType.REWARD;
        } else
        {
            itemincentivetype = GetItemIncentives.ItemIncentiveType.COUPON;
        }
        this(ebaycontext, ebaycartapi, s, s1, s2, s3, i, new GetItemIncentives.ItemIncentiveType[] {
            itemincentivetype
        }, flag1);
    }

    public GetItemIncentivesNetLoader(EbayContext ebaycontext, EbayCartApi ebaycartapi, String s, String s1, String s2, String s3, int i, 
            GetItemIncentives.ItemIncentiveType aitemincentivetype[], boolean flag)
    {
        super(ebaycontext);
        api = ebaycartapi;
        itemId = s1;
        currency = s;
        variationId = s2;
        transactionId = s3;
        quantityPurchased = i;
        types = aitemincentivetype;
        shortTimeout = flag;
    }

    protected EbayRequest createRequest()
    {
        return new GetItemIncentives.GetItemIncentivesRequest(api, currency, itemId, transactionId, variationId, Integer.valueOf(quantityPurchased), types, shortTimeout);
    }

    public boolean isServiceError()
    {
        return false;
    }
}
