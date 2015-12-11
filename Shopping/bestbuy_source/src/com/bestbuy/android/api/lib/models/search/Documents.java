// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.search;

import com.bestbuy.android.api.lib.models.summariesNpriceBlock.PriceBlock;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.search:
//            BBYStoreAvailability

public class Documents
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private BBYStoreAvailability availability;
    private String category;
    private String categoryid;
    private String condition;
    private String documenttype;
    private PriceBlock priceBlock;
    private String skuId;
    private String skutype;
    private Summary summary;

    public Documents()
    {
    }

    public String getCategory()
    {
        return category;
    }

    public String getCategoryid()
    {
        return categoryid;
    }

    public String getCondition()
    {
        return condition;
    }

    public String getDocumenttype()
    {
        return documenttype;
    }

    public PriceBlock getPriceBlock()
    {
        return priceBlock;
    }

    public String getSkuid()
    {
        return skuId;
    }

    public String getSkutype()
    {
        return skutype;
    }

    public BBYStoreAvailability getStoreAvailability()
    {
        return availability;
    }

    public Summary getSummary()
    {
        return summary;
    }

    public void setCategory(String s)
    {
        category = s;
    }

    public void setCategoryid(String s)
    {
        categoryid = s;
    }

    public void setCondition(String s)
    {
        condition = s;
    }

    public void setDocumenttype(String s)
    {
        documenttype = s;
    }

    public void setPriceBlock(PriceBlock priceblock)
    {
        priceBlock = priceblock;
    }

    public void setSkuid(String s)
    {
        skuId = s;
    }

    public void setSkutype(String s)
    {
        skutype = s;
    }

    public void setStoreAvailability(BBYStoreAvailability bbystoreavailability)
    {
        availability = bbystoreavailability;
    }

    public void setSummary(Summary summary1)
    {
        summary = summary1;
    }
}
