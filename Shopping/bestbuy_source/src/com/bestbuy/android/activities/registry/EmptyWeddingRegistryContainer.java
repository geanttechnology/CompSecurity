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
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import cu;
import fr;
import java.util.ArrayList;
import jd;
import jj;
import kf;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WishListWithProductsFragment, MyEmptyWeddingRegistryList

public class EmptyWeddingRegistryContainer extends BaseFragmentContainer
{

    private nb a;
    private cu b;
    private View c;
    private RegistryWishList g;
    private View h;
    private boolean i;
    private boolean j;

    public EmptyWeddingRegistryContainer()
    {
        i = true;
    }

    public EmptyWeddingRegistryContainer(boolean flag)
    {
        i = true;
        i = flag;
    }

    public EmptyWeddingRegistryContainer(boolean flag, boolean flag1)
    {
        i = true;
        i = flag;
        j = flag1;
    }

    private void f()
    {
        nb.a().l(false);
        nb.a().j(false);
        nb.a().k(false);
        a.b(false);
        a.a(new ArrayList());
        a.e("");
    }

    public void a(RegistryWishList registrywishlist)
    {
        g = registrywishlist;
        c();
    }

    public void a(ArrayList arraylist)
    {
        if (arraylist != null && arraylist.size() > 0)
        {
            lu.a(lu.aH);
            a(((Fragment) (new WishListWithProductsFragment(this, g, arraylist, true))), true, "WishListWithProductsFragment");
            return;
        }
        if (!j)
        {
            lu.a(lu.az);
        }
        a(((Fragment) (new MyEmptyWeddingRegistryList(g))), true, "MyEmptyWeddingRegistryList");
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

    public void c()
    {
        (new jd(d, this, fr.d(), g.getUuid(), "weddingregistrylists", false, h)).executeOnExecutor(nb.g, new Void[0]);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        a = nb.a();
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
        a = nb.a();
        try
        {
            b = (cu)activity;
        }
        // Misplaced declaration of an exception variable
        catch (Activity activity)
        {
            kf.e("RegistryFragmentContainer", (new StringBuilder()).append("Calling activity did not implement OnCreateRegistryLaunchListener: ").append(activity.getLocalizedMessage()).toString());
        }
        a.f("Registry");
        nb.a().l(false);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (c == null)
        {
            c = layoutinflater.inflate(0x7f030118, null);
            layoutinflater = (FrameLayout)c.findViewById(0x7f0c009e);
            h = c.findViewById(0x7f0c0064);
            (new jj(d, this, h, fr.d())).executeOnExecutor(nb.h, new Void[0]);
        } else
        {
            ((ViewGroup)c.getParent()).removeView(c);
        }
        return c;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (i)
        {
            if (b != null)
            {
                b.onCreateRegistryFragmentExit();
            }
            f();
            ((BBYBaseFragmentActivity)d).showActionBarHome();
            if (a.T() != null && !a.T().isEmpty())
            {
                ((BBYBaseFragmentActivity)d).updateActionBarTitle(a.T());
            } else
            {
                ((HomeActivity)d).updateActionBarTitle(a.S());
            }
        } else
        {
            ((BBYBaseFragmentActivity)d).updateActionBarTitle("Registry, Gifts & Lists");
        }
        ((HomeActivity)d).hideLifeEventsTopNavigationButton();
        a.f("");
    }

    public void onResume()
    {
        super.onResume();
        ((BBYBaseFragmentActivity)d).hideActionBarHomeAndSearchBox(d);
    }
}
