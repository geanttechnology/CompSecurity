// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.api.lib.models.offers.Offer;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import lu;
import nb;

public class WebWrapperContainer extends BaseFragmentContainer
{

    private nb a;
    private String b;

    public WebWrapperContainer()
    {
        b = "";
    }

    public WebWrapperContainer(Offer offer)
    {
        b = "";
        b = offer.getUrl();
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
        bundle = new MdotWebFragment(false, true, true, getString(0x7f0800ca), b);
        Bundle bundle1 = new Bundle();
        bundle1.putString("mDotURL", b);
        bundle.setArguments(bundle1);
        a(bundle, true);
        lu.a(lu.V);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
        a = nb.a();
        activity = ((BBYBaseFragmentActivity)activity).getCurrentActionBarTitle();
        if (activity != null && !activity.isEmpty())
        {
            a.i(activity);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030118, viewgroup, false);
    }

    public void onDestroy()
    {
        super.onDestroy();
        ((BBYBaseFragmentActivity)d).updateActionBarTitle(a.T());
        ((HomeActivity)d).fragmentHasOptionsMenu(false);
        ((HomeActivity)d).changeOptionsVisibility(true);
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        ((BBYBaseFragmentActivity)d).updateActionBarTitle(getString(0x7f0800ca));
    }
}
