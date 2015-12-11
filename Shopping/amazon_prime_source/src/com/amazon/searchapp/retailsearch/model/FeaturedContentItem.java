// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.searchapp.retailsearch.model;


// Referenced classes of package com.amazon.searchapp.retailsearch.model:
//            Product, FeaturedPromotion

public interface FeaturedContentItem
{

    public abstract String getAppUrl();

    public abstract String getLabel();

    public abstract Product getProduct();

    public abstract FeaturedPromotion getPromotion();

    public abstract void setAppUrl(String s);

    public abstract void setLabel(String s);

    public abstract void setProduct(Product product);

    public abstract void setPromotion(FeaturedPromotion featuredpromotion);
}
