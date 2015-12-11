// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.view.View;
import android.widget.FrameLayout;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.browseproduct.ProductTabContainer;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragmentContainer;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragmentContainer;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.api.lib.models.search.SearchApi;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import hz;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.base:
//            BaseFragmentContainer

public class BBYBaseFragment extends Fragment
{

    private boolean a;
    public Activity d;
    public FrameLayout e;
    public nb f;

    public BBYBaseFragment()
    {
    }

    public FrameLayout a(View view)
    {
        if (e == null)
        {
            e = (FrameLayout)view.findViewById(0x7f0c0064);
        }
        return e;
    }

    public void a(SearchApi searchapi, String s)
    {
        HomeTabFragment hometabfragment;
        Fragment fragment;
        fragment = ((HomeActivity)d).getSupportFragmentManager().findFragmentById(0x7f0c0033);
        hometabfragment = null;
        if (fragment instanceof HomeTabFragment)
        {
            hometabfragment = (HomeTabFragment)fragment;
        }
        if (fragment instanceof BaseFragmentContainer) goto _L2; else goto _L1
_L1:
        hometabfragment.b().getCurrentTab();
        JVM INSTR tableswitch 0 3: default 80
    //                   0 108
    //                   1 80
    //                   2 80
    //                   3 108;
           goto _L2 _L3 _L2 _L2 _L3
_L2:
        (new Handler()).postDelayed(new Runnable(searchapi, s, fragment, hometabfragment) {

            final SearchApi a;
            final String b;
            final Fragment c;
            final HomeTabFragment d;
            final BBYBaseFragment e;

            public void run()
            {
                PLPFragmentContainer plpfragmentcontainer = null;
                ArrayList arraylist = a.getSkuDetails();
                Object obj;
                Object obj1;
                if (arraylist.size() == 1)
                {
                    obj = (BBYProduct)arraylist.get(0);
                    obj1 = ((BBYProduct) (obj)).getSkuId();
                    Object obj2 = new HashMap();
                    ((HashMap) (obj2)).put("bb.searchTerm", obj1);
                    ((HashMap) (obj2)).put("bb.numResults", Integer.valueOf(arraylist.size()));
                    ((HashMap) (obj2)).put(lu.bo, "browse,pdp");
                    ((HashMap) (obj2)).put(lu.bp, "PDH");
                    lu.b(lu.e, ((HashMap) (obj2)));
                    obj2 = ((HomeActivity)e.d).getCurrentActionBarTitle();
                    obj = new PDPFragment(((String) (obj1)), ((BBYProduct) (obj)).getSummary().getProductId(), false, false);
                    obj1 = new PDPFragmentContainer(((String) (obj2)));
                } else
                {
                    obj = new PLPFragment(b, a, true);
                    obj1 = null;
                }
                if (c instanceof BaseFragmentContainer)
                {
                    if ((c instanceof PDPFragmentContainer) || (c instanceof PLPFragmentContainer))
                    {
                        if ((c instanceof PLPFragmentContainer) && (obj instanceof PLPFragment))
                        {
                            ((PLPFragment)obj).b(true);
                            ((PLPFragment)obj).c(true);
                        }
                        ((BaseFragmentContainer)c).a(((Fragment) (obj)), true);
                        return;
                    }
                    if (arraylist.size() == 1)
                    {
                        ((HomeActivity)e.d).addFragment(0x7f0c0033, ((Fragment) (obj1)), "PDPFragmentContainer");
                        ((PDPFragment)obj).b(true);
                        ((BaseFragmentContainer) (obj1)).a(((Fragment) (obj)), true);
                        return;
                    } else
                    {
                        obj1 = new PLPFragmentContainer(false, true);
                        ((PLPFragment)obj).b(true);
                        ((PLPFragment)obj).c(true);
                        ((HomeActivity)e.d).addFragment(0x7f0c0033, ((Fragment) (obj1)), "PLPFragmentContainer");
                        ((BaseFragmentContainer) (obj1)).a(((Fragment) (obj)), true);
                        return;
                    }
                }
                Fragment fragment2 = d.getChildFragmentManager().findFragmentByTag("PRODUCTS");
                Fragment fragment3 = ((ProductTabContainer)fragment2).b();
                Fragment fragment1 = plpfragmentcontainer;
                if (fragment3.getChildFragmentManager() != null)
                {
                    fragment1 = plpfragmentcontainer;
                    if (fragment3.getChildFragmentManager().getFragments() != null)
                    {
                        fragment1 = plpfragmentcontainer;
                        if (fragment3.getChildFragmentManager().getFragments().size() > 0)
                        {
                            fragment1 = (Fragment)fragment3.getChildFragmentManager().getFragments().get(0);
                        }
                    }
                }
                plpfragmentcontainer = new PLPFragmentContainer();
                if (fragment1 != null && (fragment1 instanceof PLPFragment))
                {
                    ((BaseFragmentContainer)fragment3).a(((Fragment) (obj)), false);
                    return;
                }
                if (fragment3 instanceof PLPFragment)
                {
                    ((BaseFragmentContainer)fragment3).a(((Fragment) (obj)), true);
                    return;
                }
                if (arraylist.size() == 1)
                {
                    ((BaseTabContainer)fragment2).a(((Fragment) (obj1)), true);
                    ((BaseFragmentContainer) (obj1)).a(((Fragment) (obj)), true);
                    return;
                } else
                {
                    ((BaseTabContainer)fragment2).a(plpfragmentcontainer, true);
                    plpfragmentcontainer.a(((Fragment) (obj)), true);
                    return;
                }
            }

            
            {
                e = BBYBaseFragment.this;
                a = searchapi;
                b = s;
                c = fragment;
                d = hometabfragment;
                super();
            }
        }, 500L);
        return;
_L3:
        hometabfragment.a(1);
        if (true) goto _L2; else goto _L4
_L4:
    }

    public void a(String s, FrameLayout framelayout)
    {
        (new hz(d, this, framelayout, s, null, null, "", 1, 20, false, true)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void b_()
    {
    }

    public void d(boolean flag)
    {
        a = flag;
    }

    public boolean l()
    {
        return a;
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        f = nb.a();
    }
}
