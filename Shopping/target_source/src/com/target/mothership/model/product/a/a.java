// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.a;

import com.target.mothership.common.params.ProductSummaryParam;
import com.target.mothership.services.x;

// Referenced classes of package com.target.mothership.model.product.a:
//            d

public abstract class a
{

    public static final String MISSING_MAX_PRICE = "Please enter maxPrice";
    public static final String MISSING_MIN_PRICE = "Please enter minPrice";
    public static final String NULL_PARAM = "Param is null";
    private d mError;

    public a(ProductSummaryParam productsummaryparam)
    {
        if (productsummaryparam == null)
        {
            a(com.target.mothership.model.product.interfaces.a.a.ERR_REQUEST_PARAM_IS_NULL, "Param is null");
        } else
        {
            if (productsummaryparam.i() != null && productsummaryparam.h() == null)
            {
                a(com.target.mothership.model.product.interfaces.a.a.ERR_REQUIRED_MAX_PRICE, "Please enter maxPrice");
            } else
            if (productsummaryparam.h() != null && productsummaryparam.i() == null)
            {
                a(com.target.mothership.model.product.interfaces.a.a.ERR_REQUIRED_MIN_PRICE, "Please enter minPrice");
            }
            if (!b())
            {
                a(productsummaryparam);
                return;
            }
        }
    }

    public com.target.mothership.model.product.interfaces.a.a a()
    {
        return mError;
    }

    protected abstract void a(ProductSummaryParam productsummaryparam);

    protected void a(com.target.mothership.model.product.interfaces.a.a a1, String s)
    {
        mError = new d();
        mError.a(a1);
        mError.a(x.a(s).a());
    }

    public boolean b()
    {
        return mError != null;
    }
}
