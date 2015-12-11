// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bestbuy.android.activities.BaseTabContainer;
import nb;

// Referenced classes of package com.bestbuy.android.activities.browseproduct:
//            BrowseCategoryFragment

public class ProductTabContainer extends BaseTabContainer
{

    private boolean a;
    private nb b;

    public ProductTabContainer()
    {
    }

    private void d()
    {
        a(new BrowseCategoryFragment(), false);
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
        if (!a)
        {
            a = true;
            d();
        }
        if (b.H())
        {
            a(b.I(), true);
            b.g(false);
            b.a(null);
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f0300d3, viewgroup, false);
    }
}
