// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.entity;

import com.amazon.searchapp.retailsearch.model.FeaturedContentItem;
import com.amazon.searchapp.retailsearch.model.FeaturedPromotion;
import com.amazon.searchapp.retailsearch.model.Product;

// Referenced classes of package com.amazon.searchapp.retailsearch.entity:
//            RetailSearchEntity

public class FeaturedContentItemEntity extends RetailSearchEntity
    implements FeaturedContentItem
{

    private String appUrl;
    private String label;
    private Product product;
    private FeaturedPromotion promotion;

    public FeaturedContentItemEntity()
    {
    }

    public String getAppUrl()
    {
        return appUrl;
    }

    public String getLabel()
    {
        return label;
    }

    public Product getProduct()
    {
        return product;
    }

    public FeaturedPromotion getPromotion()
    {
        return promotion;
    }

    public void setAppUrl(String s)
    {
        appUrl = s;
    }

    public void setLabel(String s)
    {
        label = s;
    }

    public void setProduct(Product product1)
    {
        product = product1;
    }

    public void setPromotion(FeaturedPromotion featuredpromotion)
    {
        promotion = featuredpromotion;
    }
}
