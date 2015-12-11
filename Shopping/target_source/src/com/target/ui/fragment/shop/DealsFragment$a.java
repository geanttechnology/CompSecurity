// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.shop;

import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.ui.analytics.a.l;
import com.target.ui.c.a.e;
import com.target.ui.view.common.h;

// Referenced classes of package com.target.ui.fragment.shop:
//            DealsFragment

private class <init> extends e
{

    final DealsFragment this$0;

    public void a(ProductDetails productdetails)
    {
        l.a(productdetails, null, 2).e();
    }

    public void a(String s)
    {
        DealsFragment.a(DealsFragment.this).c(s);
    }

    public void a(boolean flag)
    {
        DealsFragment.a(DealsFragment.this, flag);
    }

    private es.ProductDetails()
    {
        this$0 = DealsFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
