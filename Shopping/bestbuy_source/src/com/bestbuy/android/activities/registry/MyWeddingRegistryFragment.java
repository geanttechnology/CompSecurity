// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import fr;
import java.util.ArrayList;
import jj;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WishListWithProductsFragment, RegistryFragmentContainer, MyEmptyWeddingRegistryList

public class MyWeddingRegistryFragment extends BBYBaseFragment
{

    private RegistryWishList a;
    private View b;
    private View c;

    public MyWeddingRegistryFragment()
    {
    }

    public void a(ArrayList arraylist)
    {
        if (arraylist != null && arraylist.size() > 0)
        {
            arraylist = new WishListWithProductsFragment(this, a, arraylist, true);
            android.support.v4.app.Fragment fragment = getParentFragment();
            if (fragment instanceof RegistryFragmentContainer)
            {
                ((BaseFragmentContainer)fragment).a(arraylist, true);
            }
        } else
        {
            arraylist = new MyEmptyWeddingRegistryList();
            android.support.v4.app.Fragment fragment1 = getParentFragment();
            if (fragment1 instanceof RegistryFragmentContainer)
            {
                ((BaseFragmentContainer)fragment1).a(arraylist, true);
                return;
            }
        }
    }

    public boolean b()
    {
        ((BBYBaseFragmentActivity)d).getSupportFragmentManager().popBackStack();
        return true;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (b == null)
        {
            b = layoutinflater.inflate(0x7f03007f, null);
            layoutinflater = (FrameLayout)b.findViewById(0x7f0c0182);
            c = b.findViewById(0x7f0c0064);
            (new jj(d, this, null, fr.d())).executeOnExecutor(nb.g, new Void[0]);
        } else
        {
            ((ViewGroup)b.getParent()).removeView(b);
        }
        return b;
    }

    public void onDestroy()
    {
        super.onDestroy();
        ((BBYBaseFragmentActivity)d).showActionBarHome();
    }
}
