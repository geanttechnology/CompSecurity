// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.plp;

import com.target.ui.fragment.product.plp.presenter.ProductSummaryPagePresenter;

// Referenced classes of package com.target.ui.fragment.product.plp:
//            ProductSummaryPageFragment

class val.scrollDeltaY
    implements Runnable
{

    final ProductSummaryPageFragment this$0;
    final int val$eventType;
    final int val$scrollDeltaY;

    public void run()
    {
        if (ProductSummaryPageFragment.a(ProductSummaryPageFragment.this) == null)
        {
            return;
        } else
        {
            ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).a(ProductSummaryPageFragment.a(ProductSummaryPageFragment.this, ProductSummaryPageFragment.b(ProductSummaryPageFragment.this), ProductSummaryPageFragment.c(ProductSummaryPageFragment.this), val$eventType, val$scrollDeltaY));
            return;
        }
    }

    resenter()
    {
        this$0 = final_productsummarypagefragment;
        val$eventType = i;
        val$scrollDeltaY = I.this;
        super();
    }
}
