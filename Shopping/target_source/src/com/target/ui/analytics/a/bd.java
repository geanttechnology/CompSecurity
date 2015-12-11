// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.analytics.a;

import android.support.v4.f.a;
import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.mothership.model.product.interfaces.ProductStoreInfo;
import com.target.ui.fragment.product.common.PageItemHierarchy;
import java.util.List;
import java.util.Map;

// Referenced classes of package com.target.ui.analytics.a:
//            f, i, s

class bd extends f
{

    private static final String EVENT_SPACER = ",";
    private static final String PDP_BROWSE_LEVEL = "product details";
    private final Long mLoadTimeMS;
    private final PageItemHierarchy mPageItemHierarchy;
    private final ProductDetails mProductDetails;

    private bd(ProductDetails productdetails, PageItemHierarchy pageitemhierarchy, Long long1)
    {
        mProductDetails = productdetails;
        mPageItemHierarchy = pageitemhierarchy;
        mLoadTimeMS = long1;
    }

    static bd a(ProductDetails productdetails, PageItemHierarchy pageitemhierarchy, long l)
    {
        return new bd(productdetails, pageitemhierarchy, Long.valueOf(l));
    }

    private String a(ProductDetails productdetails)
    {
        if (productdetails == null)
        {
            return "";
        }
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("productView");
        if (productdetails.u().b().isEmpty())
        {
            stringbuilder.append(",");
            stringbuilder.append("productNotMapped");
        }
        return stringbuilder.toString();
    }

    private Map j()
    {
        a a1 = new a();
        if (mProductDetails != null)
        {
            com.target.ui.analytics.a.i.a(a1, "products", com.target.ui.analytics.a.i.a(mProductDetails));
            com.target.ui.analytics.a.i.a(a1, "limitedQuantity", com.target.ui.analytics.a.i.b(mProductDetails));
            com.target.ui.analytics.a.i.a(a1, "events", a(mProductDetails));
        }
        return a1;
    }

    protected Map b()
    {
        Map map = super.b();
        map.putAll(j());
        return map;
    }

    protected s c()
    {
        return com.target.ui.analytics.a.s.ProductDetails;
    }

    protected List d()
    {
        return com.target.ui.analytics.a.i.a(mPageItemHierarchy);
    }

    protected Long i()
    {
        return mLoadTimeMS;
    }
}
