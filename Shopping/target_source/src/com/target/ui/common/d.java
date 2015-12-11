// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.common;

import com.google.a.a.e;
import com.target.mothership.model.product.interfaces.ProductImage;

// Referenced classes of package com.target.ui.common:
//            ProductFulfillmentOptions, g, h

public class d
{

    private ProductFulfillmentOptions mProductFulfillmentOptions;
    private ProductImage mProductImages;
    private g mProductPromoOptions;
    private h mProductTitleOptions;

    public d(h h, ProductFulfillmentOptions productfulfillmentoptions, g g, ProductImage productimage)
    {
        mProductTitleOptions = h;
        mProductImages = productimage;
        mProductFulfillmentOptions = productfulfillmentoptions;
        mProductPromoOptions = g;
    }

    public h a()
    {
        return mProductTitleOptions;
    }

    public e b()
    {
        return e.c(mProductImages);
    }

    public ProductFulfillmentOptions c()
    {
        return mProductFulfillmentOptions;
    }

    public g d()
    {
        return mProductPromoOptions;
    }
}
