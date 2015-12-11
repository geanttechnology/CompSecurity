// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpoffers;

import gu;
import java.io.Serializable;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdpoffers:
//            OfferNames

public class OffersResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private ArrayList financingOffers;
    private OfferNames names;
    private int productId;
    private String productType;
    private String skuId;
    private ArrayList specialOffers;

    public OffersResponse()
    {
    }

    public ArrayList getFinancingOffers()
    {
        return financingOffers;
    }

    public OfferNames getNames()
    {
        return names;
    }

    public int getProductId()
    {
        return productId;
    }

    public String getProductType()
    {
        return productType;
    }

    public String getSkuId()
    {
        return skuId;
    }

    public ArrayList getSpecialOffers()
    {
        return specialOffers;
    }

    public void setFinancingOffers(ArrayList arraylist)
    {
        financingOffers = arraylist;
    }

    public void setNames(OfferNames offernames)
    {
        names = offernames;
    }

    public void setProductId(int i)
    {
        productId = i;
    }

    public void setProductType(String s)
    {
        productType = s;
    }

    public void setSkuId(String s)
    {
        skuId = s;
    }

    public void setSpecialOffers(ArrayList arraylist)
    {
        specialOffers = arraylist;
    }
}
