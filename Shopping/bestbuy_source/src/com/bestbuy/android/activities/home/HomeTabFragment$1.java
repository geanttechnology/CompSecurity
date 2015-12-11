// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.support.v4.app.FragmentManager;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.browseproduct.BrowseSuperSubCategoryFragment;
import com.bestbuy.android.activities.browseproduct.ProductTabContainer;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragmentContainer;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import java.util.HashMap;
import java.util.Stack;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.home:
//            HomeTabFragment, HomeTabContainer, HomeActivity

class a
    implements android.widget.eListener
{

    final HomeTabFragment a;

    public void onTabChanged(String s)
    {
        boolean flag;
        HomeTabContainer.a = false;
        if (s.equals("PRODUCTS"))
        {
            Object obj = new HashMap();
            ((HashMap) (obj)).put(lu.bo, "browse,products");
            ((HashMap) (obj)).put(lu.bp, "PRD");
            lu.b(lu.D, ((HashMap) (obj)));
            obj = a.getChildFragmentManager().findFragmentByTag("PRODUCTS");
            if (!(obj instanceof ProductTabContainer))
            {
                break MISSING_BLOCK_LABEL_356;
            }
            ((BaseTabContainer)obj).c();
            obj = ((ProductTabContainer)obj).b();
            if (!(obj instanceof PLPFragmentContainer) && !(obj instanceof BrowseSuperSubCategoryFragment))
            {
                break MISSING_BLOCK_LABEL_356;
            }
            flag = false;
        } else
        {
label0:
            {
                if (!s.equals("HOME"))
                {
                    break label0;
                }
                ((BaseTabContainer)a.getChildFragmentManager().findFragmentByTag("HOME")).c();
                HashMap hashmap = new HashMap();
                hashmap.put(lu.bo, "browse,home");
                hashmap.put(lu.bp, "GHP");
                lu.b(lu.a, hashmap);
                HomeTabContainer.a = true;
                flag = true;
            }
        }
_L1:
        s = s.toLowerCase();
        s = (new StringBuilder()).append(s.substring(0, 1).toUpperCase()).append(s.substring(1)).toString();
        HomeTabFragment.a(a).h(s);
        if (flag)
        {
            ((HomeActivity)a.d).updateActionBarTitle(s);
        }
        s = ((BBYBaseFragmentActivity)a.d).getCurrentActionBarTitle();
        HomeTabFragment.a(a).U().clear();
        HomeTabFragment.a(a).i(s);
        android.support.v4.app.Fragment fragment;
        if (s.equals("Products") || s.equals("Home") || s.equals("Stores") || s.equals("Cart"))
        {
            ((BBYBaseFragmentActivity)a.d).showActionBarHome();
            return;
        } else
        {
            ((BBYBaseFragmentActivity)a.d).hideActionBarHome();
            return;
        }
        if (s.equals("STORES"))
        {
            fragment = a.getChildFragmentManager().findFragmentByTag("STORES");
            if (fragment != null)
            {
                ((BaseTabContainer)fragment).c();
            }
        }
        flag = true;
          goto _L1
    }

    erSubCategoryFragment(HomeTabFragment hometabfragment)
    {
        a = hometabfragment;
        super();
    }
}
