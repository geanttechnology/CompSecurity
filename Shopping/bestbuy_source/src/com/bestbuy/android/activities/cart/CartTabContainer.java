// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.cart;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragment;
import com.bestbuy.android.activities.browseproduct.pdp.PDPFragmentContainer;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.api.lib.models.dnm.DNMProduct;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import fr;
import java.util.HashMap;
import lu;
import nb;
import nu;

// Referenced classes of package com.bestbuy.android.activities.cart:
//            MyCartFragment

public class CartTabContainer extends BaseTabContainer
{

    private View a;
    private View b;
    private boolean c;
    private nb g;
    private Activity h;

    public CartTabContainer()
    {
        c = false;
    }

    public void a(DNMProduct dnmproduct, String s)
    {
        dnmproduct = new PDPFragment(dnmproduct.getSkuId(), dnmproduct.getProductId(), true, dnmproduct, false, 1);
        s = new PDPFragmentContainer(s);
        a(((android.support.v4.app.Fragment) (s)), true);
        s.a(dnmproduct, true);
    }

    public void a(boolean flag)
    {
        c = flag;
        if (nb.a().b().getInt(getActivity().getResources().getString(0x7f080031), 0) > 0)
        {
            c = false;
        }
        if (!c || fr.d() != null)
        {
            if (!(b() instanceof MdotWebFragment))
            {
                e();
            }
            return;
        }
        HashMap hashmap = new HashMap();
        hashmap.put(lu.bo, "cart");
        hashmap.put(lu.bp, "CRT");
        if (fr.c() != null && !fr.c().isEmpty())
        {
            lu.b(lu.G, hashmap);
        } else
        {
            lu.b(lu.F, hashmap);
        }
        a(((android.support.v4.app.Fragment) (new MyCartFragment())), false);
    }

    public void d()
    {
        g = nb.a();
        a = b.findViewById(0x7f0c0064);
        nu.a = false;
    }

    public void e()
    {
        if (nb.a().b().getInt(getActivity().getResources().getString(0x7f080031), 0) > 0)
        {
            String s = h.getSharedPreferences("sharedPrefs", 0).getString("skusInCart", "");
            if (s.contains(" "))
            {
                s.replace(" ", ";");
            }
        }
        MdotWebFragment mdotwebfragment = new MdotWebFragment(false);
        Bundle bundle = new Bundle();
        bundle.putString("mDotURL", g.g());
        bundle.putBoolean(getResources().getString(0x7f080059), c);
        mdotwebfragment.setArguments(bundle);
        a(mdotwebfragment, false);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        ((BBYBaseFragmentActivity)h).showActionBarHome();
        ((BBYBaseFragmentActivity)h).updateActionBarTitle("Cart");
        d();
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        h = activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        b = layoutinflater.inflate(0x7f03001f, null);
        return b;
    }

    public void onResume()
    {
        super.onResume();
        a(true);
    }
}
