// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.plp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.BBYProduct;
import com.bestbuy.android.api.lib.models.summariesNpriceBlock.Summary;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import em;
import java.util.ArrayList;
import nb;

public class PLPAccessoriesFragment extends BBYBaseFragment
{

    private Activity a;
    private ArrayList b;

    public PLPAccessoriesFragment()
    {
    }

    public PLPAccessoriesFragment(Activity activity, ArrayList arraylist)
    {
        a = activity;
        b = arraylist;
    }

    static ArrayList a(PLPAccessoriesFragment plpaccessoriesfragment)
    {
        return plpaccessoriesfragment.b;
    }

    static Activity b(PLPAccessoriesFragment plpaccessoriesfragment)
    {
        return plpaccessoriesfragment.a;
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = ((BBYBaseFragmentActivity)a).getCurrentActionBarTitle();
        f.i(bundle);
        ((BBYBaseFragmentActivity)a).updateActionBarTitle("Additional Accessories");
        ((BBYBaseFragmentActivity)a).hideActionBarHome();
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a = activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0300ba, viewgroup, false);
        viewgroup = (ListView)layoutinflater.findViewById(0x7f0c0075);
        ((FrameLayout)layoutinflater.findViewById(0x7f0c0064)).setVisibility(8);
        ((RelativeLayout)layoutinflater.findViewById(0x7f0c00be)).setVisibility(8);
        viewgroup.setAdapter(new em(a, 0x7f0300bb, b));
        viewgroup.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {

            final PLPAccessoriesFragment a;

            public void onItemClick(AdapterView adapterview, View view, int i, long l)
            {
                adapterview = (BBYProduct)PLPAccessoriesFragment.a(a).get(i);
                ((HomeActivity)PLPAccessoriesFragment.b(a)).openPDP(adapterview.getSkuId(), (new StringBuilder()).append("").append(adapterview.getSummary().getProductId()).toString(), false);
            }

            
            {
                a = PLPAccessoriesFragment.this;
                super();
            }
        });
        return layoutinflater;
    }
}
