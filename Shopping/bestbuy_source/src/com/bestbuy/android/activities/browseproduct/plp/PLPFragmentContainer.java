// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.plp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.activities.registry.AddItemsToPLPFragment;
import com.bestbuy.android.activities.registry.EmptyWeddingRegistryContainer;
import com.bestbuy.android.activities.registry.MyEmptyWeddingRegistryList;
import com.bestbuy.android.activities.registry.WishListFragmentContainer;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import nb;

public class PLPFragmentContainer extends BaseFragmentContainer
{

    private boolean a;
    private boolean b;

    public PLPFragmentContainer()
    {
        a = false;
        b = false;
    }

    public PLPFragmentContainer(boolean flag)
    {
        a = false;
        b = false;
        a = flag;
    }

    public PLPFragmentContainer(boolean flag, boolean flag1)
    {
        a = false;
        b = false;
        a = flag;
        b = flag1;
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
        ((BBYBaseFragmentActivity)d).hideActionBarHome();
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f0300d3, viewgroup, false);
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (!b) goto _L2; else goto _L1
_L1:
        Object obj;
        ((BBYBaseFragmentActivity)d).updateActionBarTitle(f.T());
        ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
        obj = ((HomeActivity)d).getSupportFragmentManager();
        if (!f.C()) goto _L4; else goto _L3
_L3:
        if (!f.D().equals("Registry")) goto _L6; else goto _L5
_L5:
        Fragment fragment;
        obj = (EmptyWeddingRegistryContainer)((FragmentManager) (obj)).findFragmentByTag("EmptyWeddingRegistryContainer");
        fragment = ((EmptyWeddingRegistryContainer) (obj)).b();
        if (!(fragment instanceof MyEmptyWeddingRegistryList)) goto _L8; else goto _L7
_L7:
        ((MyEmptyWeddingRegistryList)fragment).c();
_L4:
        return;
_L8:
        if (!(fragment instanceof AddItemsToPLPFragment))
        {
            ((EmptyWeddingRegistryContainer) (obj)).c();
            return;
        }
        continue; /* Loop/switch isn't completed */
_L6:
        obj = (WishListFragmentContainer)((FragmentManager) (obj)).findFragmentByTag("WishListFragmentContainer");
        if (obj != null)
        {
            if (!(((WishListFragmentContainer) (obj)).b() instanceof AddItemsToPLPFragment))
            {
                ((WishListFragmentContainer) (obj)).e();
                return;
            }
        } else
        {
            ((HomeActivity)d).onBackPressed();
            return;
        }
        if (true) goto _L4; else goto _L2
_L2:
        if (!a)
        {
            ((BBYBaseFragmentActivity)d).updateActionBarTitle(f.T());
            ((BBYBaseFragmentActivity)d).showActionBarHome();
            return;
        }
        if (true) goto _L4; else goto _L9
_L9:
    }

    public void onResume()
    {
        super.onResume();
    }
}
