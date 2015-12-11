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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import cg;
import com.bestbuy.android.activities.browseproduct.BrowseCategoryFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.registry.RecommendationsList;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.api.lib.models.registry.WeddingRegistryData;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import fr;
import java.util.ArrayList;
import java.util.HashMap;
import ji;
import jj;
import ls;
import lu;
import mf;
import mm;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            RecentlyViewedListCard, RecommendationsFragment, EmptyWeddingRegistryContainer, WishListWithProductsFragment

public class MyEmptyWeddingRegistryList extends BBYBaseFragment
    implements android.view.View.OnClickListener, cg
{

    private RelativeLayout a;
    private TextView b;
    private Button c;
    private Button g;
    private RelativeLayout h;
    private RegistryWishList i;
    private View j;
    private ArrayList k;
    private String l;
    private RelativeLayout m;
    private ArrayList n;
    private ArrayList o;

    public MyEmptyWeddingRegistryList()
    {
        n = new ArrayList();
        o = new ArrayList();
    }

    public MyEmptyWeddingRegistryList(RegistryWishList registrywishlist)
    {
        n = new ArrayList();
        o = new ArrayList();
        i = registrywishlist;
    }

    public void a(RegistryWishList registrywishlist)
    {
        ((BBYBaseFragmentActivity)d).updateActionBarTitle(registrywishlist.getShortDescription());
        f.c(false);
        i = registrywishlist;
        RecentlyViewedListCard recentlyviewedlistcard = new RecentlyViewedListCard(registrywishlist.getUuid(), registrywishlist.getType());
        FragmentTransaction fragmenttransaction = getChildFragmentManager().beginTransaction();
        fragmenttransaction.add(0x7f0c0048, recentlyviewedlistcard, "RecentlyViewedListCard");
        fragmenttransaction.commit();
        registrywishlist = mm.a(d, this, null, registrywishlist, false, true);
        if (registrywishlist != null)
        {
            m.removeAllViews();
            m.addView(registrywishlist);
        }
    }

    public void a(WeddingRegistryData weddingregistrydata)
    {
    }

    public void a(ArrayList arraylist)
    {
        n = new ArrayList();
        o = new ArrayList();
        if (arraylist != null && arraylist.size() > 0)
        {
            for (int i1 = 0; i1 < arraylist.size(); i1++)
            {
                n.add(((RecommendationsList)arraylist.get(i1)).getTitle());
                o.add(((RecommendationsList)arraylist.get(i1)).getUrl());
            }

        }
    }

    public void b()
    {
        l = fr.d();
        (new jj(d, this, j, l)).executeOnExecutor(nb.g, new Void[0]);
    }

    public void c()
    {
        if (f.C())
        {
            ((BaseFragmentContainer)getParentFragment()).d();
        }
    }

    public void g()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (f.E().booleanValue())
        {
            b();
            return;
        }
        if (i != null)
        {
            a(i);
            return;
        } else
        {
            b();
            return;
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = (FragmentActivity)activity;
    }

    public void onClick(View view)
    {
        android.support.v4.app.Fragment fragment2;
        switch (view.getId())
        {
        default:
            return;

        case 2131492924: 
            view = new RecommendationsFragment(true, n, o);
            android.support.v4.app.Fragment fragment = getParentFragment();
            if (fragment instanceof EmptyWeddingRegistryContainer)
            {
                ((BaseFragmentContainer)fragment).a(view, true, "RecommendationsFragment");
            }
            view = new HashMap();
            view.put("Need Some Inspiration", "Selected");
            lu.a(lu.aA, view);
            return;

        case 2131493246: 
            ((HomeActivity)d).instantiateSearch();
            view = new HashMap();
            view.put("Search Product", "Selected");
            lu.a(lu.aB, view);
            return;

        case 2131493245: 
            view = new BrowseCategoryFragment(true);
            android.support.v4.app.Fragment fragment1 = getParentFragment();
            if (fragment1 instanceof EmptyWeddingRegistryContainer)
            {
                ((BaseFragmentContainer)fragment1).a(view, true);
            }
            view = new HashMap();
            view.put("Browse Product", "Selected");
            lu.a(lu.aC, view);
            return;

        case 2131492932: 
            (new mf()).a(d, "LIFE_EVENTS_PRODUCT_SCAN", "LIFE_EVENTS_PRODUCT_SCAN", i.getUuid(), i.getType());
            view = new HashMap();
            view.put("Product Scan", "Selected");
            lu.a(lu.aD, view);
            return;

        case 2131492933: 
            view = new PLPFragment(true, k, "Scan History", true);
            fragment2 = getParentFragment();
            break;
        }
        if (fragment2 instanceof EmptyWeddingRegistryContainer)
        {
            ((BaseFragmentContainer)fragment2).a(view, true);
        }
        view = new HashMap();
        view.put("Scan History", "Selected");
        lu.a(lu.aE, view);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (i == null);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03006b, viewgroup, false);
        j = layoutinflater.findViewById(0x7f0c0064);
        viewgroup = (InputMethodManager)d.getSystemService("input_method");
        if (d.getCurrentFocus() != null && d.getCurrentFocus().getWindowToken() != null)
        {
            viewgroup.hideSoftInputFromWindow(d.getCurrentFocus().getWindowToken(), 0);
        }
        a = (RelativeLayout)layoutinflater.findViewById(0x7f0c003c);
        g = (Button)layoutinflater.findViewById(0x7f0c017e);
        g.setText(Html.fromHtml(getString(0x7f0802ee)));
        g.setOnClickListener(this);
        c = (Button)layoutinflater.findViewById(0x7f0c017d);
        c.setText(Html.fromHtml(getString(0x7f0800d2)));
        c.setOnClickListener(this);
        m = (RelativeLayout)layoutinflater.findViewById(0x7f0c003a);
        b = (TextView)layoutinflater.findViewById(0x7f0c0044);
        b.setOnClickListener(this);
        h = (RelativeLayout)layoutinflater.findViewById(0x7f0c0045);
        h.setOnClickListener(this);
        k = ls.a(d);
        if (k.size() > 0)
        {
            h.setOnClickListener(this);
        } else
        {
            h.setVisibility(8);
        }
        if (n != null)
        {
            a.setVisibility(0);
            a.setOnClickListener(this);
            return layoutinflater;
        } else
        {
            a.setVisibility(8);
            return layoutinflater;
        }
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (f.C())
        {
            ArrayList arraylist = f.B();
            String s = i.getUuid();
            if (arraylist.contains(s))
            {
                WishListWithProductsFragment wishlistwithproductsfragment = new WishListWithProductsFragment(this, i, null, true);
                ((BaseFragmentContainer)getParentFragment()).a(wishlistwithproductsfragment, true, "WishListWithProductsFragment");
                arraylist.remove(s);
                f.a(arraylist);
                f.b(false);
            }
        }
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        ((HomeActivity)d).setOnLifeEventsTopNavigationListener(this, "", false);
        if (!f.E().booleanValue())
        {
            if (i != null)
            {
                ((BBYBaseFragmentActivity)d).updateActionBarTitle(i.getShortDescription());
                String s = ((BBYBaseFragmentActivity)d).getCurrentActionBarTitle();
                f.i(s);
            } else
            {
                ((BBYBaseFragmentActivity)d).updateActionBarTitle("");
            }
        }
        if (ls.a(d).size() > 0)
        {
            h.setVisibility(0);
            h.setOnClickListener(this);
        } else
        {
            h.setVisibility(8);
        }
        if (f.C())
        {
            c();
        }
        (new ji(d, this, j)).executeOnExecutor(nb.g, new Void[0]);
    }

    public void onStart()
    {
        super.onStart();
    }

    public void onViewStateRestored(Bundle bundle)
    {
        super.onViewStateRestored(bundle);
    }
}
