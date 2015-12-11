// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.bestbuy.android.activities.BaseTabContainer;
import com.bestbuy.android.activities.home.HomeTabFragment;
import com.bestbuy.android.activities.mdot.MdotWebFragment;
import com.bestbuy.android.api.lib.models.product.ProductOffer;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import ez;
import java.util.ArrayList;

public class PDPBuyingOffersListFragment extends BBYBaseFragment
{

    private View a;
    private ListView b;
    private ArrayList c;

    public PDPBuyingOffersListFragment()
    {
    }

    static ArrayList a(PDPBuyingOffersListFragment pdpbuyingofferslistfragment)
    {
        return pdpbuyingofferslistfragment.c;
    }

    private void a(Fragment fragment)
    {
        String s;
        Object obj;
        s = "";
        obj = ((BBYBaseFragmentActivity)d).getSupportFragmentManager().findFragmentById(0x7f0c0033);
        if (!(obj instanceof HomeTabFragment)) goto _L2; else goto _L1
_L1:
        obj = (HomeTabFragment)obj;
        ((HomeTabFragment) (obj)).b().getCurrentTab();
        JVM INSTR tableswitch 0 3: default 68
    //                   0 85
    //                   1 91
    //                   2 97
    //                   3 103;
           goto _L3 _L4 _L5 _L6 _L7
_L3:
        ((BaseTabContainer)((HomeTabFragment) (obj)).getChildFragmentManager().findFragmentByTag(s)).a(fragment, true);
_L2:
        return;
_L4:
        s = "HOME";
        continue; /* Loop/switch isn't completed */
_L5:
        s = "PRODUCTS";
        continue; /* Loop/switch isn't completed */
_L6:
        s = "STORES";
        continue; /* Loop/switch isn't completed */
_L7:
        s = "CART";
        if (true) goto _L3; else goto _L8
_L8:
    }

    static void a(PDPBuyingOffersListFragment pdpbuyingofferslistfragment, Fragment fragment)
    {
        pdpbuyingofferslistfragment.a(fragment);
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

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a = layoutinflater.inflate(0x7f030091, viewgroup, false);
        b = (ListView)a.findViewById(0x7f0c023b);
        layoutinflater = new ez(d, 0x7f0300d6, c);
        b.setAdapter(layoutinflater);
        b.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final PDPBuyingOffersListFragment a;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (ProductOffer)PDPBuyingOffersListFragment.a(a).get(i);
                adapterview = (new StringBuilder()).append("http://www.bestbuy.com/").append(adapterview.getUrl()).toString();
                view = new MdotWebFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putString(a.getResources().getString(0x7f080055), adapterview);
                view.setArguments(bundle1);
                PDPBuyingOffersListFragment.a(a, view);
            }

            
            {
                a = PDPBuyingOffersListFragment.this;
                super();
            }
        });
        return a;
    }

    public void onResume()
    {
        super.onResume();
    }
}
