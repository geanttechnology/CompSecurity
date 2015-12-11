// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.dnm;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import nb;

public class DNMSubListContainer extends BaseFragmentContainer
{

    private Activity a;
    private nb b;

    public DNMSubListContainer()
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

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        b.h(true);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a = activity;
        b = nb.a();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f0300d3, viewgroup, false);
    }

    public void onDestroy()
    {
        super.onDestroy();
        b.h(false);
        String s = getResources().getString(0x7f0802ef);
        ((HomeActivity)a).updateSearchHint(s);
        ((BBYBaseFragmentActivity)a).showActionBarHome();
        ((BBYBaseFragmentActivity)a).updateActionBarTitle(b.T());
    }

    public void onResume()
    {
        super.onResume();
        ((BBYBaseFragmentActivity)a).hideActionBarHome();
    }
}
