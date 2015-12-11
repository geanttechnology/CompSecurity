// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.pointinside.products;


// Referenced classes of package com.pointinside.products:
//            BaseProduct

static class ProductsProductType
{

    static final int $SwitchMap$com$pointinside$products$BaseProduct$PIProductsProductType[];

    static 
    {
        $SwitchMap$com$pointinside$products$BaseProduct$PIProductsProductType = new int[ProductsProductType.values().length];
        try
        {
            $SwitchMap$com$pointinside$products$BaseProduct$PIProductsProductType[ProductsProductType.product.ordinal()] = 1;
        }
        catch (NoSuchFieldError nosuchfielderror2) { }
        try
        {
            $SwitchMap$com$pointinside$products$BaseProduct$PIProductsProductType[ProductsProductType.metaproduct.ordinal()] = 2;
        }
        catch (NoSuchFieldError nosuchfielderror1) { }
        try
        {
            $SwitchMap$com$pointinside$products$BaseProduct$PIProductsProductType[ProductsProductType.deal.ordinal()] = 3;
        }
        catch (NoSuchFieldError nosuchfielderror)
        {
            return;
        }
    }
}
