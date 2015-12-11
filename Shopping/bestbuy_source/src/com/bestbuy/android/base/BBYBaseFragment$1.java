// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import lu;

// Referenced classes of package com.bestbuy.android.base:
//            BBYBaseFragment, BaseFragmentContainer

class d
    implements Runnable
{

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
        Fragment fragment1 = d.getChildFragmentManager().findFragmentByTag("PRODUCTS");
        Fragment fragment2 = ((ProductTabContainer)fragment1).b();
        Fragment fragment = plpfragmentcontainer;
        if (fragment2.getChildFragmentManager() != null)
        {
            fragment = plpfragmentcontainer;
            if (fragment2.getChildFragmentManager().getFragments() != null)
            {
                fragment = plpfragmentcontainer;
                if (fragment2.getChildFragmentManager().getFragments().size() > 0)
                {
                    fragment = (Fragment)fragment2.getChildFragmentManager().getFragments().get(0);
                }
            }
        }
        plpfragmentcontainer = new PLPFragmentContainer();
        if (fragment != null && (fragment instanceof PLPFragment))
        {
            ((BaseFragmentContainer)fragment2).a(((Fragment) (obj)), false);
            return;
        }
        if (fragment2 instanceof PLPFragment)
        {
            ((BaseFragmentContainer)fragment2).a(((Fragment) (obj)), true);
            return;
        }
        if (arraylist.size() == 1)
        {
            ((BaseTabContainer)fragment1).a(((Fragment) (obj1)), true);
            ((BaseFragmentContainer) (obj1)).a(((Fragment) (obj)), true);
            return;
        } else
        {
            ((BaseTabContainer)fragment1).a(plpfragmentcontainer, true);
            plpfragmentcontainer.a(((Fragment) (obj)), true);
            return;
        }
    }

    Fragment(BBYBaseFragment bbybasefragment, SearchApi searchapi, String s, Fragment fragment, HomeTabFragment hometabfragment)
    {
        e = bbybasefragment;
        a = searchapi;
        b = s;
        c = fragment;
        d = hometabfragment;
        super();
    }
}
