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
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import cv;
import fr;
import java.util.ArrayList;
import kf;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            MyWishListsFragment

public class WishListFragmentContainer extends BaseFragmentContainer
{

    private static final String a = com/bestbuy/android/activities/registry/WishListFragmentContainer.getSimpleName();
    private String b;
    private nb c;
    private cv g;
    private boolean h;
    private String i;

    public WishListFragmentContainer()
    {
    }

    public WishListFragmentContainer(String s)
    {
        b = s;
    }

    public WishListFragmentContainer(boolean flag, String s)
    {
        h = flag;
        i = s;
    }

    private void c()
    {
        nb.a().l(false);
        nb.a().j(false);
        nb.a().k(false);
        c.b(false);
        c.a(new ArrayList());
        c.e("");
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
        bundle = ((BBYBaseFragmentActivity)d).getCurrentActionBarTitle();
        c.i(bundle);
        ((BBYBaseFragmentActivity)d).updateActionBarTitle("My Wish Lists");
        ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
        if (h)
        {
            a(new MyWishListsFragment(h, i), false, "MyWishListsFragment");
            return;
        } else
        {
            a(new MyWishListsFragment(), true, "MyWishListsFragment");
            return;
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
        c = nb.a();
        try
        {
            g = (cv)activity;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            kf.e(a, (new StringBuilder()).append("Calling activity did not implement OnCreateWishListLaunchListener: ").append(activity.getLocalizedMessage()).toString());
        }
        c.f("WishList");
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f030118, viewgroup, false);
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (g != null)
        {
            g.onCreateWishListFragmentExit();
        }
        c();
        if (h)
        {
            if (fr.d() != null && !fr.d().isEmpty())
            {
                ((BBYBaseFragmentActivity)d).changeActionBarAddToVisibility(d, true);
            }
            ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
            ((BBYBaseFragmentActivity)d).updateActionBarTitle("");
            ((BBYBaseFragmentActivity)d).changeActionBarShareVisibility(d, true);
            return;
        } else
        {
            ((BBYBaseFragmentActivity)d).updateActionBarTitle(c.T());
            ((BBYBaseFragmentActivity)d).showActionBarHome();
            return;
        }
    }

}
