// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import cg;
import com.bestbuy.android.activities.browseproduct.BrowseCategoryFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import cv;
import java.util.ArrayList;
import java.util.HashMap;
import ls;
import lu;
import mf;
import mm;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WishListWithProductsFragment, WishListFragmentContainer, RegistryFragmentContainer, RecentlyViewedListCard

public class MyEmptyWishListFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener, cg
{

    private Button a;
    private RegistryWishList b;
    private View c;
    private ArrayList g;
    private RelativeLayout h;
    private RelativeLayout i;
    private Button j;
    private Button k;
    private cv l;
    private ArrayList m;
    private ArrayList n;
    private boolean o;

    public MyEmptyWishListFragment()
    {
        m = new ArrayList();
        n = new ArrayList();
        o = true;
    }

    public MyEmptyWishListFragment(RegistryWishList registrywishlist)
    {
        m = new ArrayList();
        n = new ArrayList();
        o = true;
        b = registrywishlist;
    }

    public void a(ArrayList arraylist)
    {
    }

    public void b()
    {
        ((BaseFragmentContainer)getParentFragment()).d();
    }

    public void c()
    {
        ArrayList arraylist = f.B();
        String s = b.getUuid();
        if (arraylist.contains(s))
        {
            WishListWithProductsFragment wishlistwithproductsfragment = new WishListWithProductsFragment(this, b, null);
            ((BaseFragmentContainer)getParentFragment()).a(wishlistwithproductsfragment, true, "WishListWithProductsFragment");
            arraylist.remove(s);
            f.a(arraylist);
            f.b(false);
        }
    }

    public void g()
    {
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = (FragmentActivity)activity;
    }

    public void onClick(View view)
    {
        if (view == k)
        {
            ((HomeActivity)d).instantiateSearch();
            view = new HashMap();
            view.put("Search Product", "Selected");
            lu.a(lu.R, view);
        } else
        {
            if (view == a)
            {
                (new mf()).a(d, "LIFE_EVENTS_PRODUCT_SCAN", "LIFE_EVENTS_PRODUCT_SCAN", b.getUuid(), b.getType());
                view = new HashMap();
                view.put("Product Scan", "Selected");
                lu.a(lu.T, view);
                return;
            }
            if (view == j)
            {
                view = new BrowseCategoryFragment(true);
                android.support.v4.app.Fragment fragment = getParentFragment();
                if (fragment instanceof WishListFragmentContainer)
                {
                    ((BaseFragmentContainer)fragment).a(view, true, "BrowseCategoryFragment");
                }
                if (fragment instanceof RegistryFragmentContainer)
                {
                    ((BaseFragmentContainer)fragment).a(view, true, "BrowseCategoryFragment");
                }
                view = new HashMap();
                view.put("Browse Product", "Selected");
                lu.a(lu.S, view);
                return;
            }
            if (view == h)
            {
                view = new PLPFragment(true, g, "Scan History", true);
                android.support.v4.app.Fragment fragment1 = getParentFragment();
                if (fragment1 instanceof WishListFragmentContainer)
                {
                    ((BaseFragmentContainer)fragment1).a(view, true, "PLPFragment");
                }
                if (fragment1 instanceof RegistryFragmentContainer)
                {
                    ((BaseFragmentContainer)fragment1).a(view, true, "PLPFragment");
                }
                view = new HashMap();
                view.put("Scan History", "Selected");
                lu.a(lu.U, view);
                return;
            }
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (b != null)
        {
            b.getType().substring(0, b.getType().length() - 1);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03006a, viewgroup, false);
        c = layoutinflater.findViewById(0x7f0c0064);
        j = (Button)layoutinflater.findViewById(0x7f0c0040);
        k = (Button)layoutinflater.findViewById(0x7f0c0041);
        a = (Button)layoutinflater.findViewById(0x7f0c0044);
        h = (RelativeLayout)layoutinflater.findViewById(0x7f0c0045);
        i = (RelativeLayout)layoutinflater.findViewById(0x7f0c003a);
        j.setText(Html.fromHtml(getString(0x7f0800d2)));
        k.setText(Html.fromHtml(getString(0x7f0802ee)));
        k.setOnClickListener(this);
        j.setOnClickListener(this);
        a.setOnClickListener(this);
        viewgroup = mm.a(d, this, b, null, false, false);
        if (viewgroup != null)
        {
            i.removeAllViews();
            i.addView(viewgroup);
        }
        g = ls.a(d);
        if (g.size() > 0)
        {
            h.setVisibility(0);
            h.setOnClickListener(this);
        } else
        {
            h.setVisibility(8);
        }
        l = (cv)d;
        l.onCreateWishListFragmentLaunch();
        viewgroup = new RecentlyViewedListCard(b.getUuid(), b.getType());
        bundle = getChildFragmentManager().beginTransaction();
        bundle.add(0x7f0c0048, viewgroup, "RecentlyViewedListCard");
        bundle.commit();
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        c();
    }

    public void onResume()
    {
        super.onResume();
        ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
        if (b != null)
        {
            ((BBYBaseFragmentActivity)d).updateActionBarTitle(b.getShortDescription());
            String s = ((BBYBaseFragmentActivity)d).getCurrentActionBarTitle();
            f.i(s);
            ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
            ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, "", false);
        }
        g = ls.a(d);
        if (g.size() > 0)
        {
            h.setVisibility(0);
            h.setOnClickListener(this);
        } else
        {
            h.setVisibility(8);
        }
        if (nb.a().V())
        {
            ((HomeActivity)d).onBackPressed();
        }
    }
}
