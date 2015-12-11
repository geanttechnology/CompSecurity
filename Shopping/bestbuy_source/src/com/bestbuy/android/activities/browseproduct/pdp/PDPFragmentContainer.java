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
import bw;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import kf;

public class PDPFragmentContainer extends BaseFragmentContainer
{

    private String a;
    private bw b;

    public PDPFragmentContainer()
    {
    }

    public PDPFragmentContainer(String s)
    {
        a = s;
    }

    public void a(String s)
    {
        if (b != null)
        {
            b.setShareURL((new StringBuilder()).append("http://www.bestbuy.com/").append(s).toString());
            b.onPDPFragmentLaunch();
        }
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

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
        ((HomeActivity)activity).fragmentHasOptionsMenu(false);
        ((HomeActivity)activity).changeOptionsVisibility(true);
        try
        {
            b = (bw)activity;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            kf.e("PDPFragmentContainer", (new StringBuilder()).append("Calling activity did not implement OnPDPFragmentLaunchListener: ").append(activity.getLocalizedMessage()).toString());
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f0300d3, viewgroup, false);
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (b != null)
        {
            b.onPDPFragmentExit();
        }
    }

    public void onResume()
    {
        super.onResume();
    }
}
