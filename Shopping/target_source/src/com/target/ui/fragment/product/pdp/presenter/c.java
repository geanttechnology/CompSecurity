// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.pdp.presenter;

import android.view.Menu;
import android.view.MenuInflater;
import com.target.mothership.model.product.interfaces.ProductPromotion;
import com.target.ui.g.a;

public class c
    implements a
{

    public static final String TAG = com/target/ui/fragment/product/pdp/presenter/c.getSimpleName();
    private com.target.ui.fragment.product.pdp.a.c mPresentation;
    private final ProductPromotion mSavedProductPromotion;

    public c(ProductPromotion productpromotion)
    {
        mSavedProductPromotion = productpromotion;
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        mPresentation.a(0x7f0900cc);
    }

    public void a(com.target.ui.fragment.product.pdp.a.c c1)
    {
        mPresentation = c1;
        mPresentation.b(mSavedProductPromotion);
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.product.pdp.a.c)obj);
    }

    public void v_()
    {
    }

    public void z_()
    {
        mPresentation = null;
    }

}
