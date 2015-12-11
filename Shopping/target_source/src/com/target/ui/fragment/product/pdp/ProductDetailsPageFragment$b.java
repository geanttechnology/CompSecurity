// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.pdp;

import com.target.mothership.model.list.interfaces.ListSummary;
import com.target.ui.c.b.e;
import com.target.ui.util.ad;
import com.target.ui.view.common.h;
import com.target.ui.view.product.PdpFulfillmentView;

// Referenced classes of package com.target.ui.fragment.product.pdp:
//            ProductDetailsPageFragment

private class <init> extends e
{

    final ProductDetailsPageFragment this$0;

    public void a(String s)
    {
        ProductDetailsPageFragment.b(ProductDetailsPageFragment.this).c(s);
    }

    public void a(String s, ListSummary listsummary)
    {
        ad.a(getActivity(), s, ProductDetailsPageFragment.b(ProductDetailsPageFragment.this), listsummary, m());
    }

    public void a(boolean flag)
    {
        ProductDetailsPageFragment.d(ProductDetailsPageFragment.this).fulfillmentView.e(flag);
    }

    private ews()
    {
        this$0 = ProductDetailsPageFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
