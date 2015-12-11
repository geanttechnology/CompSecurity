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
import android.widget.FrameLayout;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import cu;
import kf;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            CreateWeddingRegistry

public class RegistryFragmentContainer extends BaseFragmentContainer
{

    private static final String a = com/bestbuy/android/activities/registry/RegistryFragmentContainer.getSimpleName();
    private nb b;
    private cu c;
    private View g;
    private boolean h;
    private String i;

    public RegistryFragmentContainer()
    {
    }

    public RegistryFragmentContainer(boolean flag, String s)
    {
        h = flag;
        i = s;
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
        if (h)
        {
            a(new CreateWeddingRegistry(i), false, "CreateWeddingRegistry");
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
        b = nb.a();
        try
        {
            c = (cu)activity;
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            kf.e(a, (new StringBuilder()).append("Calling activity did not implement OnCreateRegistryLaunchListener: ").append(activity.getLocalizedMessage()).toString());
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (g == null)
        {
            g = layoutinflater.inflate(0x7f030118, null);
            layoutinflater = (FrameLayout)g.findViewById(0x7f0c009e);
        } else
        {
            ((ViewGroup)g.getParent()).removeView(g);
        }
        return g;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (c != null)
        {
            c.onCreateRegistryFragmentExit();
        }
        if (h)
        {
            ((BBYBaseFragmentActivity)d).changeActionBarAddToVisibility(d, true);
            ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
            ((BBYBaseFragmentActivity)d).updateActionBarTitle("");
            ((BBYBaseFragmentActivity)d).changeActionBarShareVisibility(d, true);
            return;
        } else
        {
            ((BBYBaseFragmentActivity)d).updateActionBarTitle(b.T());
            ((BBYBaseFragmentActivity)d).showActionBarHome();
            return;
        }
    }

    public void onResume()
    {
        super.onResume();
    }

}
