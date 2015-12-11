// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            BasicOfferListing, OffersSummary

public class VariationProductInfo
{

    private String asin;
    private BasicOfferListing basicOffer;
    private int imagesCount;
    private String listPrice;
    private OffersSummary offersSummary;
    private List variationAttributes;

    public VariationProductInfo()
    {
    }

    public String getAsin()
    {
        return asin;
    }

    public BasicOfferListing getBasicOffer()
    {
        return basicOffer;
    }

    public int getImagesCount()
    {
        return imagesCount;
    }

    public String getListPrice()
    {
        return listPrice;
    }

    public OffersSummary getOffersSummary()
    {
        return offersSummary;
    }

    public List getVariationAttributes()
    {
        return variationAttributes;
    }

    public void setAsin(String s)
    {
        asin = s;
    }

    public void setBasicOffer(BasicOfferListing basicofferlisting)
    {
        basicOffer = basicofferlisting;
    }

    public void setImagesCount(int i)
    {
        imagesCount = i;
    }

    public void setListPrice(String s)
    {
        listPrice = s;
    }

    public void setOffersSummary(OffersSummary offerssummary)
    {
        offersSummary = offerssummary;
    }

    public void setVariationAttributes(List list)
    {
        variationAttributes = list;
    }
}
