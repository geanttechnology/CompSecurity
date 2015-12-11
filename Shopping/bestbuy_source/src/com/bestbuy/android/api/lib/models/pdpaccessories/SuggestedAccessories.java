// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpaccessories;

import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PriceBlock;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import gu;
import java.io.Serializable;

public class SuggestedAccessories
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private PriceBlock priceBlock;
    private Summary summary;

    public SuggestedAccessories()
    {
    }

    public PriceBlock getPriceBlock()
    {
        return priceBlock;
    }

    public Summary getSummary()
    {
        return summary;
    }

    public void setPriceBlock(PriceBlock priceblock)
    {
        priceBlock = priceblock;
    }

    public void setSummary(Summary summary1)
    {
        summary = summary1;
    }
}
