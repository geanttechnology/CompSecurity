// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import com.target.mothership.model.product.interfaces.ProductDetails;

// Referenced classes of package com.target.ui.view.product:
//            PlpListItemView

private class mProductDetailsData
    implements .a
{

    final ProductDetails mProductDetailsData;
    final PlpListItemView this$0;

    public void a()
    {
        if (PlpListItemView.a(PlpListItemView.this) == null)
        {
            return;
        } else
        {
            PlpListItemView.a(PlpListItemView.this).b(mProductDetailsData);
            return;
        }
    }

    public void b()
    {
        if (PlpListItemView.a(PlpListItemView.this) == null)
        {
            return;
        } else
        {
            PlpListItemView.a(PlpListItemView.this).c(mProductDetailsData);
            return;
        }
    }

    public void c()
    {
    }

    public void d()
    {
        if (PlpListItemView.a(PlpListItemView.this) == null)
        {
            return;
        } else
        {
            PlpListItemView.a(PlpListItemView.this).a(mProductDetailsData);
            return;
        }
    }

    s.ProductDetails(ProductDetails productdetails)
    {
        this$0 = PlpListItemView.this;
        super();
        mProductDetailsData = productdetails;
    }
}
