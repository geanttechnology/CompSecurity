// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdpbuyingoptions;

import gu;
import java.io.Serializable;
import java.util.ArrayList;

// Referenced classes of package com.bestbuy.android.api.lib.models.pdpbuyingoptions:
//            Names

public class BuyingOptionsResponse
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private ArrayList buyingOptions;
    private Names names;
    private String productType;
    private String skuId;

    public BuyingOptionsResponse()
    {
    }

    public ArrayList getBuyingOptions()
    {
        return buyingOptions;
    }

    public Names getNames()
    {
        return names;
    }

    public String getProductType()
    {
        return productType;
    }

    public String getSkuId()
    {
        return skuId;
    }

    public void setBuyingOptions(ArrayList arraylist)
    {
        buyingOptions = arraylist;
    }

    public void setNames(Names names1)
    {
        names = names1;
    }

    public void setProductType(String s)
    {
        productType = s;
    }

    public void setSkuId(String s)
    {
        skuId = s;
    }
}
