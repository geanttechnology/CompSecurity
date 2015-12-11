// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.stores;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.home.HomeActivity;
import dp;
import java.util.HashMap;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.stores:
//            StoreSearchMapFragment

public class StoreTabContainer extends BaseTabContainer
{

    private boolean a;
    private nb b;
    private Fragment c;

    public StoreTabContainer()
    {
    }

    private void d()
    {
        HashMap hashmap = new HashMap();
        hashmap.put(lu.bo, "browse,store-locator");
        hashmap.put(lu.bp, "STLM");
        lu.b(lu.E, hashmap);
        c = new StoreSearchMapFragment();
        a(c, false);
    }

    public Fragment b()
    {
        if (getChildFragmentManager() != null)
        {
            return getChildFragmentManager().findFragmentById(0x7f0c009e);
        } else
        {
            return null;
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        b = nb.a();
        return layoutinflater.inflate(0x7f0300d3, null);
    }

    public void onResume()
    {
        super.onResume();
        if (!a)
        {
            a = true;
            d();
        } else
        if ((c instanceof StoreSearchMapFragment) && HomeActivity.inStoresFragment && ((StoreSearchMapFragment)c).a != null)
        {
            ((StoreSearchMapFragment)c).a.onStoresFramentLaunch();
            return;
        }
    }
}
