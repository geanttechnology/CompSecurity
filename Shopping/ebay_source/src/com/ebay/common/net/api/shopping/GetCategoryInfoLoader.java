// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.common.net.api.shopping;

import com.ebay.common.content.EbaySimpleNetLoader;
import com.ebay.nautilus.domain.net.EbayRequest;
import com.ebay.nautilus.domain.net.api.shopping.EbayShoppingApi;
import com.ebay.nautilus.domain.net.api.shopping.GetCategoryInfoRequest;
import com.ebay.nautilus.kernel.content.EbayContext;

public class GetCategoryInfoLoader extends EbaySimpleNetLoader
{

    private final EbayShoppingApi api;
    public final long categoryId;
    public boolean includeChildCategories;

    public GetCategoryInfoLoader(EbayContext ebaycontext, EbayShoppingApi ebayshoppingapi, long l)
    {
        super(ebaycontext);
        includeChildCategories = false;
        api = ebayshoppingapi;
        categoryId = l;
    }

    protected EbayRequest createRequest()
    {
        GetCategoryInfoRequest getcategoryinforequest = new GetCategoryInfoRequest(api, categoryId);
        getcategoryinforequest.includeChildCategories = includeChildCategories;
        return getcategoryinforequest;
    }
}
