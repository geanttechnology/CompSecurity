// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.pdp.presenter;

import android.view.Menu;
import android.view.MenuInflater;
import com.target.ui.g.a;

public class d
    implements a
{

    public static final String TAG = com/target/ui/fragment/product/pdp/presenter/d.getSimpleName();
    private com.target.ui.fragment.product.pdp.a.d mPresentation;

    public d()
    {
    }

    public void a(Menu menu, MenuInflater menuinflater)
    {
        mPresentation.a("");
    }

    public void a(com.target.ui.fragment.product.pdp.a.d d1)
    {
        mPresentation = d1;
    }

    public volatile void a(Object obj)
    {
        a((com.target.ui.fragment.product.pdp.a.d)obj);
    }

    public void v_()
    {
    }

    public void z_()
    {
        mPresentation = null;
    }

}
