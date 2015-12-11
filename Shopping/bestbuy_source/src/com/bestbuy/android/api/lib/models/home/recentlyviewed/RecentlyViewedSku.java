// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home.recentlyviewed;

import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PriceBlock;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import gu;
import java.io.Serializable;
import java.util.List;

public class RecentlyViewedSku
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x39d8d511c8dae947L;
    private String ep;
    private PriceBlock priceBlock;
    private List relatedSkus;
    private String relatedUrl;
    private String skuId;
    private Summary summary;

    public RecentlyViewedSku()
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

    public List getRelatedSkus()
    {
        return relatedSkus;
    }

    public String getRelatedUrl()
    {
        return relatedUrl;
    }

    public String getSkuId()
    {
        return skuId;
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

    public void setRelatedSkus(List list)
    {
        relatedSkus = list;
    }

    public void setRelatedUrl(String s)
    {
        relatedUrl = s;
    }

    public void setSkuId(String s)
    {
        skuId = s;
    }

    public void setSummary(Summary summary1)
    {
        summary = summary1;
    }
}
