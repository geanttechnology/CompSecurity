// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import com.target.ui.fragment.product.common.PageItemHierarchy;
import java.util.List;

// Referenced classes of package com.target.ui.analytics.a:
//            e, s, i, y

public class ak extends e
{

    private final PageItemHierarchy mPageItemHierarchy;

    private ak(PageItemHierarchy pageitemhierarchy)
    {
        mPageItemHierarchy = pageitemhierarchy;
    }

    public static ak a(PageItemHierarchy pageitemhierarchy)
    {
        return new ak(pageitemhierarchy);
    }

    protected s c()
    {
        return s.ProductDetails;
    }

    protected List d()
    {
        return com.target.ui.analytics.a.i.a(mPageItemHierarchy);
    }

    protected y i()
    {
        return y.ExpressCheckout;
    }
}
