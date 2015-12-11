// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bestbuy.android.activities.BaseTabContainer;

// Referenced classes of package com.bestbuy.android.activities.home:
//            HomeFragment

public class HomeTabContainer extends BaseTabContainer
{

    public static boolean a = false;
    private boolean b;

    public HomeTabContainer()
    {
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

    public void d()
    {
        a(new HomeFragment(), false);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        if (!b)
        {
            b = true;
            d();
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f0300d3, null);
    }

    public void onResume()
    {
        super.onResume();
    }

}
