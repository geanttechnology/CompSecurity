// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.reviews;

import android.widget.AbsListView;
import com.target.ui.view.product.PlpGridFooterView;

// Referenced classes of package com.target.ui.fragment.product.reviews:
//            ProductReadReviewFragment

private class <init>
    implements android.widget.
{

    final ProductReadReviewFragment this$0;

    public void onScroll(AbsListView abslistview, int i, int j, int k)
    {
        if (!ProductReadReviewFragment.a(ProductReadReviewFragment.this, i, j, k)) goto _L2; else goto _L1
_L1:
        if (!ProductReadReviewFragment.a(ProductReadReviewFragment.this).footerView.c()) goto _L4; else goto _L3
_L3:
        return;
_L4:
        ProductReadReviewFragment.b(ProductReadReviewFragment.this);
        ProductReadReviewFragment.a(ProductReadReviewFragment.this).footerView.a();
        return;
_L2:
        if (!ProductReadReviewFragment.c(ProductReadReviewFragment.this))
        {
            ProductReadReviewFragment.a(ProductReadReviewFragment.this).footerView.b();
            return;
        }
        if (true) goto _L3; else goto _L5
_L5:
    }

    public void onScrollStateChanged(AbsListView abslistview, int i)
    {
    }

    private ews()
    {
        this$0 = ProductReadReviewFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
