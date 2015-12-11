// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.pdp;

import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Price;
import gu;
import java.io.Serializable;

public class AlternateProduct
    implements gu, Serializable
{

    private static final long serialVersionUID = 1L;
    private String format;
    private Price price;
    private String productId;
    private String skuId;
    private String url;

    public AlternateProduct()
    {
    }

    public String getFormat()
    {
        return format;
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

    public String getUrl()
    {
        return url;
    }

    public void setFormat(String s)
    {
        format = s;
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

    public void setUrl(String s)
    {
        url = s;
    }
}
