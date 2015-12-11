// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import cg;
import com.bestbuy.android.activities.browseproduct.BrowseCategoryFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.registry.RecommendationsList;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYButton;
import com.bestbuy.android.bbyobjects.BBYTextView;
import java.util.ArrayList;
import java.util.HashMap;
import ji;
import ll;
import ls;
import lu;
import mf;
import mm;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            RecommendationsFragment, EmptyWeddingRegistryContainer, RecentlyViewedListCard

public class AddItemsToPLPFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener, cg
{

    Intent a;
    Bundle b;
    private View c;
    private BBYButton g;
    private RelativeLayout h;
    private String i;
    private String j;
    private String k;
    private BBYTextView l;
    private ArrayList m;
    private LinearLayout n;
    private Button o;
    private Button p;
    private boolean q;
    private Activity r;
    private RelativeLayout s;
    private RegistryWishList t;
    private RelativeLayout u;
    private View v;
    private ArrayList w;
    private ArrayList x;

    public AddItemsToPLPFragment()
    {
        a = new Intent();
        b = new Bundle();
        w = new ArrayList();
        x = new ArrayList();
    }

    public AddItemsToPLPFragment(RegistryWishList registrywishlist, String s1, String s2, String s3, boolean flag)
    {
        a = new Intent();
        b = new Bundle();
        w = new ArrayList();
        x = new ArrayList();
        t = registrywishlist;
        i = s1;
        j = s2;
        k = s3;
        q = flag;
    }

    public void a(String s1)
    {
        ((BBYTextView)n.findViewById(0x7f0c0039)).setText(s1);
        ll.b(n);
    }

    public void a(ArrayList arraylist)
    {
        w = new ArrayList();
        x = new ArrayList();
        if (arraylist != null && arraylist.size() > 0)
        {
            for (int i1 = 0; i1 < arraylist.size(); i1++)
            {
                w.add(((RecommendationsList)arraylist.get(i1)).getTitle());
                x.add(((RecommendationsList)arraylist.get(i1)).getUrl());
            }

        }
    }

    public void g()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        (new ji(r, this, v)).executeOnExecutor(nb.g, new Void[0]);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        r = activity;
    }

    public void onClick(View view)
    {
        if (view != p) goto _L2; else goto _L1
_L1:
        ((HomeActivity)r).instantiateSearch();
_L4:
        return;
_L2:
        if (view == g)
        {
            (new mf()).a(getActivity(), "LIFE_EVENTS_PRODUCT_SCAN", "", j, i);
            return;
        }
        if (view == o)
        {
            ((BaseFragmentContainer)getParentFragment()).a(new BrowseCategoryFragment(true), true);
            return;
        }
        if (view != h)
        {
            continue; /* Loop/switch isn't completed */
        }
        if (m == null || m.size() <= 0) goto _L4; else goto _L3
_L3:
        view = new PLPFragment(true, m, "Scan History", true);
        ((BaseFragmentContainer)getParentFragment()).a(view, true, "PLPFragment");
        return;
        if (view != u) goto _L4; else goto _L5
_L5:
        view = new RecommendationsFragment(true, w, x);
        android.support.v4.app.Fragment fragment = getParentFragment();
        if (fragment instanceof EmptyWeddingRegistryContainer)
        {
            ((BaseFragmentContainer)fragment).a(view, true, "RecommendationsFragment");
        } else
        {
            ((BaseFragmentContainer)fragment).a(view, true, "RecommendationsFragment");
        }
        view = new HashMap();
        view.put("Need Some Inspiration", "Selected");
        lu.a(lu.aA, view);
        return;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        super.onCreateView(layoutinflater, viewgroup, bundle);
        c = layoutinflater.inflate(0x7f030004, null);
        v = c.findViewById(0x7f0c0064);
        l = (BBYTextView)c.findViewById(0x7f0c0046);
        o = (Button)c.findViewById(0x7f0c0040);
        o.setText(Html.fromHtml(getString(0x7f0800d2)));
        p = (Button)c.findViewById(0x7f0c0041);
        p.setText(Html.fromHtml(getString(0x7f0802ee)));
        s = (RelativeLayout)c.findViewById(0x7f0c003a);
        g = (BBYButton)c.findViewById(0x7f0c0044);
        h = (RelativeLayout)c.findViewById(0x7f0c0045);
        n = (LinearLayout)c.findViewById(0x7f0c0038);
        u = (RelativeLayout)c.findViewById(0x7f0c003c);
        u.setOnClickListener(this);
        m = ls.a(r);
        if (m.size() > 0)
        {
            h.setVisibility(0);
            h.setOnClickListener(this);
        } else
        {
            h.setVisibility(8);
        }
        l.setText(Html.fromHtml(getString(0x7f0802e8)));
        o.setOnClickListener(this);
        p.setOnClickListener(this);
        g.setOnClickListener(this);
        h.setOnClickListener(this);
        if (q)
        {
            lu.a(lu.az);
            u.setVisibility(0);
            layoutinflater = mm.a(r, this, null, t, false, q);
        } else
        {
            lu.a((new StringBuilder()).append(lu.y).append(i.substring(0, i.length() - 1)).toString());
            u.setVisibility(8);
            layoutinflater = mm.a(r, this, t, null, false, q);
        }
        if (layoutinflater != null)
        {
            s.removeAllViews();
            s.addView(layoutinflater);
        }
        ((HomeActivity)r).setOnLifeEventsTopNavigationListener(this, "", false);
        layoutinflater = new RecentlyViewedListCard(j, i, this, getActivity());
        viewgroup = getChildFragmentManager().beginTransaction();
        viewgroup.add(0x7f0c0048, layoutinflater, "RecentlyViewedListCard");
        viewgroup.commit();
        return c;
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
        m = ls.a(r);
        if (m.size() > 0)
        {
            h.setVisibility(0);
            h.setOnClickListener(this);
        } else
        {
            h.setVisibility(8);
        }
        if (t != null)
        {
            ((BBYBaseFragmentActivity)r).changeActionBarAddToVisibility(r, false);
            ((BBYBaseFragmentActivity)r).changeActionBarShareVisibility(r, false);
            ((BBYBaseFragmentActivity)r).updateActionBarTitle(t.getShortDescription());
            String s1 = ((BBYBaseFragmentActivity)r).getCurrentActionBarTitle();
            f.i(s1);
        }
    }
}
