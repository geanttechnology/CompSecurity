// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.clp;

import com.target.mothership.model.product.interfaces.ProductDetails;
import com.target.ui.fragment.product.clp.presenter.CollectionListPagePresenter;
import com.target.ui.helper.product.b;

// Referenced classes of package com.target.ui.fragment.product.clp:
//            CollectionsListPageFragment

private class <init>
    implements com.target.ui.adapter.product.nt.f
{

    final CollectionsListPageFragment this$0;

    public void a(ProductDetails productdetails)
    {
        com.target.ui.fragment.product.clp.CollectionsListPageFragment.b(CollectionsListPageFragment.this).a(productdetails);
    }

    public void b(ProductDetails productdetails)
    {
        com.target.ui.fragment.product.clp.CollectionsListPageFragment.b(CollectionsListPageFragment.this).a(productdetails, b.PICK_UP);
    }

    public void c(ProductDetails productdetails)
    {
        com.target.ui.fragment.product.clp.CollectionsListPageFragment.b(CollectionsListPageFragment.this).a(productdetails, b.SHIP);
    }

    private esenter()
    {
        this$0 = CollectionsListPageFragment.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
