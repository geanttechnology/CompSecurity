// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bestbuy.android.activities.browseproduct.plp.PLPAccessoriesFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragmentContainer;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYProductViewPager;
import com.bestbuy.android.bbyobjects.BBYTextView;
import dy;
import ia;
import java.util.ArrayList;
import java.util.HashMap;
import ll;
import lu;
import nb;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPFragment, PDPFragmentContainer

public class PDPAccessoriesFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener
{

    private BBYProductViewPager a;
    private View b;
    private LinearLayout c;
    private View g;
    private OverviewResponse h;
    private ArrayList i;
    private ia j;
    private dy k;

    public PDPAccessoriesFragment()
    {
    }

    public PDPAccessoriesFragment(OverviewResponse overviewresponse)
    {
        h = overviewresponse;
        Bundle bundle = new Bundle();
        bundle.putSerializable("product", overviewresponse);
        setArguments(bundle);
    }

    public void a(ArrayList arraylist)
    {
        i = arraylist;
        k = new dy(d, arraylist, getParentFragment(), true);
        a.setAdapter(k);
        a.startAnimation(ll.a(d));
        if (arraylist.size() == 1)
        {
            a.setPagingEnabled(false);
        }
    }

    public void b()
    {
        FragmentTransaction fragmenttransaction = getParentFragment().getChildFragmentManager().beginTransaction();
        fragmenttransaction.remove(this);
        fragmenttransaction.commitAllowingStateLoss();
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

    public void onClick(View view)
    {
        if (view == c)
        {
            ((BBYBaseFragmentActivity)d).changeActionBarShareVisibility(d, false);
            view = new HashMap();
            view.put(lu.ao, "PLP Accessories List");
            lu.b(lu.ao, view);
            view = new PLPFragmentContainer();
            PLPAccessoriesFragment plpaccessoriesfragment = new PLPAccessoriesFragment(d, i);
            ((PDPFragmentContainer)((PDPFragment)getParentFragment()).getParentFragment()).a(view, true, "PDPFragmentContainer");
            view.a(plpaccessoriesfragment, true, "PLPAccessoriesFragment");
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (h == null)
        {
            h = (OverviewResponse)getArguments().getSerializable("product");
        }
        if (g == null)
        {
            g = layoutinflater.inflate(0x7f0300db, viewgroup, false);
            b = g.findViewById(0x7f0c0064);
            a = (BBYProductViewPager)g.findViewById(0x7f0c005e);
            a.setPageMargin(15);
            c = (LinearLayout)g.findViewById(0x7f0c0073);
            c.setOnClickListener(this);
            g.findViewById(0x7f0c035c).setVisibility(0);
            ((BBYTextView)g.findViewById(0x7f0c005c)).setText("ADDITIONAL ACCESSORIES");
            j = new ia(d, this, b, h);
            j.executeOnExecutor(nb.h, new Void[0]);
        } else
        {
            ((ViewGroup)g.getParent()).removeView(g);
        }
        return g;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (j != null)
        {
            j.cancel(true);
        }
    }

    public void onResume()
    {
        super.onResume();
        if (l())
        {
            j = new ia(d, this, b, h);
            j.executeOnExecutor(nb.h, new Void[0]);
        }
        if (k != null)
        {
            k.notifyDataSetChanged();
        }
    }
}
