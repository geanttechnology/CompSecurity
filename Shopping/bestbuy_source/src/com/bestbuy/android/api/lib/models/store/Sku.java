// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.api.lib.models.store;

import com.bestbuy.android.api.lib.models.store.availability.Availability;
import gu;
import java.io.Serializable;

// Referenced classes of package com.bestbuy.android.api.lib.models.store:
//            Attributes, Names, SellerInfo

public class Sku
    implements gu, Serializable
{

    private Attributes attributes;
    private Availability availability;
    private Names names;
    private String productType;
    private SellerInfo sellerInfo;
    private String skuId;

    public Sku()
    {
    }

    public Attributes getAttributes()
    {
        return attributes;
    }

    public Availability getAvailability()
    {
        return availability;
    }

    public Names getNames()
    {
        return names;
    }

    public String getProductType()
    {
        return productType;
    }

    public SellerInfo getSellerInfo()
    {
        return sellerInfo;
    }

    public String getSkuId()
    {
        return skuId;
    }

    public void setAttributes(Attributes attributes1)
    {
        attributes = attributes1;
    }

    public void setAvailability(Availability availability1)
    {
        availability = availability1;
    }

    public void setNames(Names names1)
    {
        names = names1;
    }

    public void setProductType(String s)
    {
        productType = s;
    }

    public void setSellerInfo(SellerInfo sellerinfo)
    {
        sellerInfo = sellerinfo;
    }

    public void setSkuId(String s)
    {
        skuId = s;
    }

    public String toString()
    {
        return (new StringBuilder()).append("ClassPojo [names = ").append(names).append(", sellerInfo = ").append(sellerInfo).append(", skuId = ").append(skuId).append(", productType = ").append(productType).append(", availability = ").append(availability).append("]").toString();
    }
}
