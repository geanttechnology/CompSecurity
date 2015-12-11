// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.b;

import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.ui.fragment.product.common.PageItemHierarchy;

// Referenced classes of package com.target.ui.analytics.b:
//            a

public class j extends a
{

    public final long loadTimeMS;
    public final PageItemHierarchy pageItemHierarchy;
    public final ProductDetails productDetails;

    private j(ProductDetails productdetails, PageItemHierarchy pageitemhierarchy, long l)
    {
        productDetails = productdetails;
        pageItemHierarchy = pageitemhierarchy;
        loadTimeMS = l;
    }

    public static j a(ProductDetails productdetails, PageItemHierarchy pageitemhierarchy, long l)
    {
        return new j(productdetails, pageitemhierarchy, l);
    }
}
