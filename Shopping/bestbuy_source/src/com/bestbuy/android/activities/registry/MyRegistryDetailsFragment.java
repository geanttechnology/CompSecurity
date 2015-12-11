// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bestbuy.android.api.lib.models.registry.RegistryWishList;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BaseFragmentContainer;
import fr;
import java.util.ArrayList;
import jd;
import nb;

// Referenced classes of package com.bestbuy.android.activities.registry:
//            WishListWithProductsFragment, MyEmptyWeddingRegistryList

public class MyRegistryDetailsFragment extends BBYBaseFragment
{

    private RegistryWishList a;
    private View b;

    public MyRegistryDetailsFragment()
    {
    }

    public void a(ArrayList arraylist)
    {
        BaseFragmentContainer basefragmentcontainer = (BaseFragmentContainer)getParentFragment();
        if (arraylist != null && arraylist.size() > 0)
        {
            basefragmentcontainer.a(new WishListWithProductsFragment(this, a, arraylist, true), true, "WishListWithProductsFragment");
            return;
        } else
        {
            basefragmentcontainer.a(new MyEmptyWeddingRegistryList(a), true, "MyEmptyWeddingRegistryList");
            return;
        }
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        (new jd(activity, this, fr.d(), a.getUuid(), "weddingregistrylists", false, b)).executeOnExecutor(nb.g, new Void[0]);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030119, viewgroup, false);
        b = layoutinflater.findViewById(0x7f0c0064);
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
        if (nb.a().X())
        {
            nb.a().l(false);
            (new jd(d, this, fr.d(), a.getUuid(), "weddingregistrylists", false, b)).executeOnExecutor(nb.g, new Void[0]);
        }
    }
}
