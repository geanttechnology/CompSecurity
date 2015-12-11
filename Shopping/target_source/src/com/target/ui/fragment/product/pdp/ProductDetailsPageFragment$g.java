// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.pdp;

import android.view.View;
import com.target.ui.analytics.a.ak;
import com.target.ui.fragment.product.pdp.presenter.ProductDetailsPagePresenter;
import com.target.ui.helper.product.b;

// Referenced classes of package com.target.ui.fragment.product.pdp:
//            ProductDetailsPageFragment

private class <init>
    implements android.view.DetailsPageFragment.g
{

    final ProductDetailsPageFragment this$0;

    public void onClick(View view)
    {
        ak.a(ProductDetailsPageFragment.a(ProductDetailsPageFragment.this)).e();
        ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).a(b.EXPRESS_CHECKOUT);
    }

    private resenter()
    {
        this$0 = ProductDetailsPageFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
