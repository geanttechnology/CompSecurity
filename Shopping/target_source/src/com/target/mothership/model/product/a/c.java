// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.mothership.model.product.a;

import com.target.mothership.common.params.ProductSummaryParam;

// Referenced classes of package com.target.mothership.model.product.a:
//            a

public class c extends a
{

    public static final String BAD_ARGUMENT = "Bad argument : Refer ProductSummaryParam docs for constructor sample";

    public c(ProductSummaryParam productsummaryparam)
    {
        super(productsummaryparam);
    }

    protected void a(ProductSummaryParam productsummaryparam)
    {
        if (productsummaryparam.c() == null && productsummaryparam.d() == null && productsummaryparam.e() == null)
        {
            a(com.target.mothership.model.product.interfaces.a.a.a.ERR_BAD_ARGUMENT, "Bad argument : Refer ProductSummaryParam docs for constructor sample");
        }
    }
}
