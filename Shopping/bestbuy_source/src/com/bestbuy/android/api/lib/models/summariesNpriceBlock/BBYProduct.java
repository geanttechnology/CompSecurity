// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.summariesNpriceBlock;

import com.bestbuy.android.api.lib.models.search.BBYStoreAvailability;
import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.summariesNpriceBlock:
//            PriceBlock, Price, Summary

public class BBYProduct
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String ep;
    private PriceBlock priceBlock;
    private Price restrictedPrice;
    private String skuId;
    private BBYStoreAvailability storeAvailability;
    private Summary summary;

    public BBYProduct()
    {
    }

    public String getEp()
    {
        return ep;
    }

    public PriceBlock getPriceBlock()
    {
        return priceBlock;
    }

    public Price getRestrictedPrice()
    {
        return restrictedPrice;
    }

    public String getSkuId()
    {
        return skuId;
    }

    public BBYStoreAvailability getStoreAvailability()
    {
        return storeAvailability;
    }

    public Summary getSummary()
    {
        return summary;
    }

    public void setEp(String s)
    {
        ep = s;
    }

    public void setPriceBlock(PriceBlock priceblock)
    {
        priceBlock = priceblock;
    }

    public void setRestrictedPrice(Price price)
    {
        restrictedPrice = price;
    }

    public void setSkuId(String s)
    {
        skuId = s;
    }

    public void setStoreAvailability(BBYStoreAvailability bbystoreavailability)
    {
        storeAvailability = bbystoreavailability;
    }

    public void setSummary(Summary summary1)
    {
        summary = summary1;
    }
}
