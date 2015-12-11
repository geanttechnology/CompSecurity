// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;


// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            BasicOfferListing, BasicProductInfo

public class SearchResult
{

    private BasicOfferListing basicOffer;
    private BasicProductInfo basicProduct;

    public SearchResult()
    {
    }

    public BasicOfferListing getBasicOffer()
    {
        return basicOffer;
    }

    public BasicProductInfo getBasicProduct()
    {
        return basicProduct;
    }

    public void setBasicOffer(BasicOfferListing basicofferlisting)
    {
        basicOffer = basicofferlisting;
    }

    public void setBasicProduct(BasicProductInfo basicproductinfo)
    {
        basicProduct = basicproductinfo;
    }
}
