// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.summariesNpriceBlock;

import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.summariesNpriceBlock:
//            Price

public class MultipleSellers
    implements Serializable
{

    private String condition;
    private Price price;
    private String productId;
    private String skuId;

    public MultipleSellers()
    {
    }

    public String getCondition()
    {
        return condition;
    }

    public Price getPrice()
    {
        return price;
    }

    public String getProductId()
    {
        return productId;
    }

    public String getSkuId()
    {
        return skuId;
    }

    public void setCondition(String s)
    {
        condition = s;
    }

    public void setPrice(Price price1)
    {
        price = price1;
    }

    public void setProductId(String s)
    {
        productId = s;
    }

    public void setSkuId(String s)
    {
        skuId = s;
    }
}
