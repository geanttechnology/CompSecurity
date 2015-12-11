// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.pdp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import com.target.ui.fragment.common.TabbedFragment;
import com.target.ui.fragment.common.TargetWebFragment;
import com.target.ui.fragment.product.pdp.a.d;
import java.util.ArrayList;
import java.util.List;

public class ProductShippingAndReturnsPageFragment extends TabbedFragment
    implements d
{

    public static final String TAG = com/target/ui/fragment/product/pdp/ProductShippingAndReturnsPageFragment.getSimpleName();
    private com.target.ui.fragment.product.pdp.presenter.d mPresenter;

    public ProductShippingAndReturnsPageFragment()
    {
    }

    public static ProductShippingAndReturnsPageFragment a()
    {
        return new ProductShippingAndReturnsPageFragment();
    }

    private com.target.ui.fragment.common.TabbedFragment.b b()
    {
        String s = getString(0x7f090486);
        return new com.target.ui.fragment.common.TabbedFragment.b(TargetWebFragment.a(true, "file:///android_asset/htmls/shipping.html", ""), s);
    }

    private com.target.ui.fragment.common.TabbedFragment.b k()
    {
        String s = getString(0x7f09047d);
        return new com.target.ui.fragment.common.TabbedFragment.b(TargetWebFragment.a(true, "file:///android_asset/htmls/returns.html", ""), s);
    }

    public void a(String s)
    {
        j(s);
    }

    protected List c()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.add(b());
        arraylist.add(k());
        return arraylist;
    }

    protected boolean g()
    {
        return true;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        mPresenter = new com.target.ui.fragment.product.pdp.presenter.d();
    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater menuinflater)
    {
        if (!isAdded())
        {
            return;
        } else
        {
            super.onCreateOptionsMenu(menu, menuinflater);
            mPresenter.a(menu, menuinflater);
            return;
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        mPresenter.a(this);
        return super.onCreateView(layoutinflater, viewgroup, bundle);
    }

}
