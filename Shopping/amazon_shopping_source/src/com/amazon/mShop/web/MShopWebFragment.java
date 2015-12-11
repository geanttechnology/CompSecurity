// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.web;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

// Referenced classes of package com.amazon.mShop.web:
//            MShopWebActivity, MShopWebViewContainer

public class MShopWebFragment extends Fragment
{

    private MShopWebViewContainer mContainer;

    public MShopWebFragment()
    {
    }

    public static MShopWebFragment add(FragmentManager fragmentmanager, int i)
    {
        if (fragmentmanager.findFragmentById(i) != null)
        {
            return (MShopWebFragment)fragmentmanager.findFragmentById(i);
        } else
        {
            MShopWebFragment mshopwebfragment = new MShopWebFragment();
            fragmentmanager.beginTransaction().add(i, mshopwebfragment).commit();
            return mshopwebfragment;
        }
    }

    public void attach()
    {
        getFragmentManager().beginTransaction().attach(this).commitAllowingStateLoss();
    }

    public void detach()
    {
        getFragmentManager().beginTransaction().detach(this).commitAllowingStateLoss();
    }

    public MShopWebViewContainer getContainer()
    {
        return mContainer;
    }

    public void initWebViewContainer(MShopWebActivity mshopwebactivity)
    {
        mContainer = mshopwebactivity.createWebViewContainer();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (mContainer == null)
        {
            initWebViewContainer((MShopWebActivity)getActivity());
        }
        layoutinflater = mContainer.getParent();
        if (layoutinflater != null && (layoutinflater instanceof ViewGroup))
        {
            ((ViewGroup)layoutinflater).removeAllViews();
        }
        return mContainer;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (mContainer != null && mContainer.getWebView() != null)
        {
            mContainer.getWebView().destroy();
        }
    }

    public void onPause()
    {
        super.onPause();
        mContainer.getWebView().onPause();
    }

    public void onResume()
    {
        super.onResume();
        mContainer.getWebView().onResume();
    }

    public void onSaveInstanceState(Bundle bundle)
    {
        super.onSaveInstanceState(bundle);
        mContainer.getWebView().saveState(bundle);
    }
}
