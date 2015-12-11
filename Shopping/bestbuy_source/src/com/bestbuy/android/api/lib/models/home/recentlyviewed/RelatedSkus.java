// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.home.recentlyviewed;

import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PriceBlock;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import gu;
import java.io.Serializable;

public class RelatedSkus
    implements gu, Serializable
{

    private static final long serialVersionUID = 0x39dadac94eb90f2dL;
    private String ep;
    private PriceBlock priceBlock;
    private String skuId;
    private Summary summary;

    public RelatedSkus()
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

    public void setSkuId(String s)
    {
        skuId = s;
    }

    public void setSummary(Summary summary1)
    {
        summary = summary1;
    }
}
