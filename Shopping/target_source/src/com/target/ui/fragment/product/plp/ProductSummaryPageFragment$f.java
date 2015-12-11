// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.plp;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.target.ui.fragment.product.plp.presenter.ProductSummaryPagePresenter;

// Referenced classes of package com.target.ui.fragment.product.plp:
//            ProductSummaryPageFragment

private class <init> extends android.support.v7.widget.agment.f
{

    final ProductSummaryPageFragment this$0;

    public void a(RecyclerView recyclerview, int i)
    {
        ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).b(i);
    }

    public void a(RecyclerView recyclerview, int i, int j)
    {
        int k = ProductSummaryPageFragment.e(ProductSummaryPageFragment.this).o();
        int l = ProductSummaryPageFragment.e(ProductSummaryPageFragment.this).w();
        int i1 = ProductSummaryPageFragment.e(ProductSummaryPageFragment.this).i();
        ProductSummaryPageFragment.d(ProductSummaryPageFragment.this).b(i1, k, l, i, j);
    }

    private resenter()
    {
        this$0 = ProductSummaryPageFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
