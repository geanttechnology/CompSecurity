// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import nb;

public class PDPProductAvailabilityContainer extends BaseFragmentContainer
{

    private Activity a;
    private nb b;
    private String c;

    public PDPProductAvailabilityContainer()
    {
    }

    public PDPProductAvailabilityContainer(String s)
    {
        c = s;
    }

    public void a(String s)
    {
        ((BBYBaseFragmentActivity)a).updateActionBarTitle(s);
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
        b = nb.a();
        bundle = ((BBYBaseFragmentActivity)a).getCurrentActionBarTitle();
        b.i(bundle);
        ((BBYBaseFragmentActivity)a).updateActionBarTitle(c);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a = activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f0300d3, viewgroup, false);
    }

    public void onDestroy()
    {
        super.onDestroy();
    }

    public void onResume()
    {
        super.onResume();
    }
}
