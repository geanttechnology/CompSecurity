// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;


class SearchResult
{

    public boolean isBoosted;
    public String productId;
    public BaseProduct.PIProductsProductType type;

    public SearchResult(BaseProduct.PIProductsProductType piproductsproducttype, String s, boolean flag)
    {
        type = piproductsproducttype;
        productId = s;
        isBoosted = flag;
    }
}
