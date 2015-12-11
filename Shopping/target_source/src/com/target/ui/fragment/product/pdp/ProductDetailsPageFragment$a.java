// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.pdp;

import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.ui.analytics.a.l;
import com.target.ui.c.a.e;
import com.target.ui.fragment.product.pdp.presenter.ProductDetailsPagePresenter;
import com.target.ui.helper.product.b;
import com.target.ui.model.product.GridItem;
import com.target.ui.model.product.ProductVariationModel;
import com.target.ui.view.common.h;

// Referenced classes of package com.target.ui.fragment.product.pdp:
//            ProductDetailsPageFragment

private class <init> extends e
{

    final ProductDetailsPageFragment this$0;

    public void a(ProductDetails productdetails)
    {
        super.a(productdetails);
        l.a(productdetails, ProductDetailsPageFragment.a(ProductDetailsPageFragment.this), 3).e();
    }

    public void a(ProductDetails productdetails, ProductVariationModel productvariationmodel, b b)
    {
        ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).a(productdetails, productvariationmodel);
    }

    public void a(b b, boolean flag)
    {
        ProductDetailsPageFragment.a(ProductDetailsPageFragment.this, b, flag);
    }

    public void a(GridItem griditem)
    {
        ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).b(griditem);
    }

    public void a(ProductVariationModel productvariationmodel)
    {
        ProductDetailsPageFragment.c(ProductDetailsPageFragment.this).a(productvariationmodel);
    }

    public void a(String s)
    {
        com.target.ui.fragment.product.pdp.ProductDetailsPageFragment.b(ProductDetailsPageFragment.this).c(s);
    }

    public void a(boolean flag)
    {
        ProductDetailsPageFragment.a(ProductDetailsPageFragment.this, flag);
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
