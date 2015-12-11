// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.cart;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragmentContainer;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYProductViewPager;
import com.bestbuy.android.bbyobjects.BBYTextView;
import dy;
import fr;
import hg;
import java.util.ArrayList;
import java.util.Locale;
import le;
import ll;
import nb;
import nu;

// Referenced classes of package com.bestbuy.android.activities.cart:
//            CartTabContainer

public class MyCartFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener
{

    private nb a;
    private View b;
    private BBYTextView c;
    private Button g;
    private View h;
    private BBYProductViewPager i;
    private LinearLayout j;
    private LinearLayout k;
    private LinearLayout l;
    private LinearLayout m;
    private hg n;
    private LinearLayout o;
    private dy p;

    public MyCartFragment()
    {
        b = null;
    }

    public void a(ArrayList arraylist)
    {
        h.setVisibility(8);
        p = new dy(d, arraylist, this, true, "Checkout: Cart \u2013 Empty");
        i.setAdapter(p);
        i.startAnimation(ll.a(d));
        if (arraylist.size() == 1)
        {
            i.setPagingEnabled(false);
        }
        ((HomeActivity)d).loadMostPopularRecommendations("cart", "cartloadmostpopular", arraylist);
    }

    public void b()
    {
        o.setVisibility(0);
        ((BBYTextView)b.findViewById(0x7f0c005c)).setText("MOST POPULAR");
        n = new hg(d, this, h, "all", null, 1, 10, false);
        n.executeOnExecutor(nb.h, new Void[0]);
        a = nb.a();
        String s = fr.c();
        if (s != null && !s.isEmpty())
        {
            m.setVisibility(0);
            c.setText(s.toLowerCase(Locale.US));
            g.setText(getString(0x7f08025a));
            g.setEnabled(true);
            return;
        } else
        {
            m.setVisibility(8);
            return;
        }
    }

    public void c()
    {
        fr.a();
        nb.a().a(".bestbuy.com", d);
        m.setVisibility(8);
        if (d != null && (d instanceof HomeActivity))
        {
            ((HomeActivity)d).buildSideMenu();
            nb.a().f(true);
        }
    }

    public void d()
    {
        if (o != null)
        {
            ll.a(o);
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
    }

    public void onClick(View view)
    {
        if (view != j) goto _L2; else goto _L1
_L1:
        PLPFragment plpfragment;
        Object obj;
        view = new PLPFragmentContainer();
        plpfragment = new PLPFragment(true, "MostPopular", "Most Popular", "all", null, "Cart", 50);
        obj = ((FragmentActivity)d).getSupportFragmentManager().findFragmentById(0x7f0c0033);
        if (!(obj instanceof HomeTabFragment)) goto _L4; else goto _L3
_L3:
        obj = (HomeTabFragment)obj;
        ((HomeTabFragment) (obj)).b().getCurrentTab();
        JVM INSTR tableswitch 0 3: default 100
    //                   0 126
    //                   1 100
    //                   2 100
    //                   3 126;
           goto _L5 _L6 _L5 _L5 _L6
_L5:
        (new Handler()).postDelayed(new Runnable(((HomeTabFragment) (obj)), view, plpfragment) {

            final HomeTabFragment a;
            final PLPFragmentContainer b;
            final PLPFragment c;
            final MyCartFragment d;

            public void run()
            {
                ((BaseTabContainer)a.e()).a(b, true);
                b.a(c, true);
            }

            
            {
                d = MyCartFragment.this;
                a = hometabfragment;
                b = plpfragmentcontainer;
                c = plpfragment;
                super();
            }
        }, 500L);
_L4:
        return;
_L6:
        ((HomeTabFragment) (obj)).a(1);
        continue; /* Loop/switch isn't completed */
_L2:
        if (view == k)
        {
            view = new MdotWebFragment(true, true);
            Bundle bundle = new Bundle();
            bundle.putString("mDotURL", a.i());
            view.setArguments(bundle);
            ((HomeActivity)d).addFragment(0x7f0c0033, view, "MdotWebFragment");
            return;
        }
        if (view == l)
        {
            view = new MdotWebFragment(true, true);
            Bundle bundle1 = new Bundle();
            bundle1.putString("mDotURL", a.j());
            view.setArguments(bundle1);
            ((HomeActivity)d).addFragment(0x7f0c0033, view, "MdotWebFragment");
            return;
        }
        if (view != g) goto _L4; else goto _L7
_L7:
        (new le(d, this)).a();
        return;
        if (true) goto _L5; else goto _L8
_L8:
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        a = nb.a();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (b == null)
        {
            b = layoutinflater.inflate(0x7f030069, viewgroup, false);
            i = (BBYProductViewPager)b.findViewById(0x7f0c005e);
            o = (LinearLayout)b.findViewById(0x7f0c0173);
            i.setPageMargin(15);
            h = b.findViewById(0x7f0c0064);
            m = (LinearLayout)b.findViewById(0x7f0c0178);
            c = (BBYTextView)b.findViewById(0x7f0c0179);
            g = (Button)b.findViewById(0x7f0c017a);
            j = (LinearLayout)b.findViewById(0x7f0c0073);
            k = (LinearLayout)b.findViewById(0x7f0c0175);
            l = (LinearLayout)b.findViewById(0x7f0c0177);
            b();
        } else
        {
            ((ViewGroup)b.getParent()).removeView(b);
        }
        g.setOnClickListener(this);
        j.setOnClickListener(this);
        if (k != null)
        {
            k.setOnClickListener(this);
        }
        if (l != null)
        {
            l.setOnClickListener(this);
        }
        if (nb.a().b().getInt(getActivity().getResources().getString(0x7f080031), 0) > 0)
        {
            ((CartTabContainer)getParentFragment()).e();
        }
        nu.a = false;
        return b;
    }

    public void onDetach()
    {
        super.onDetach();
    }

    public void onResume()
    {
        super.onResume();
        if (l())
        {
            b();
        }
        if (p != null)
        {
            p.notifyDataSetChanged();
        }
    }
}
