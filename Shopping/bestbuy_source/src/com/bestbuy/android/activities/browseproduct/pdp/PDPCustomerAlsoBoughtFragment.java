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
import com.bestbuy.android.activities.browseproduct.plp.PLPFragment;
import com.bestbuy.android.activities.browseproduct.plp.PLPFragmentContainer;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import com.bestbuy.android.base.BaseFragmentContainer;
import com.bestbuy.android.bbyobjects.BBYProductViewPager;
import com.bestbuy.android.bbyobjects.BBYTextView;
import dy;
import hd;
import java.util.ArrayList;
import ll;
import nb;

// Referenced classes of package com.bestbuy.android.activities.browseproduct.pdp:
//            PDPFragment, PDPFragmentContainer

public class PDPCustomerAlsoBoughtFragment extends BBYBaseFragment
    implements android.view.View.OnClickListener
{

    private BBYProductViewPager a;
    private LinearLayout b;
    private View c;
    private View g;
    private String h;
    private String i;
    private hd j;
    private boolean k;
    private dy l;

    public PDPCustomerAlsoBoughtFragment()
    {
        k = false;
    }

    public PDPCustomerAlsoBoughtFragment(OverviewResponse overviewresponse)
    {
        k = false;
        h = overviewresponse.getSkuId();
    }

    public void a(ArrayList arraylist)
    {
        l = new dy(d, arraylist, getParentFragment(), true, "customeralsobought", i);
        a.setAdapter(l);
        a.startAnimation(ll.a(d));
        if (arraylist.size() == 1)
        {
            a.setPagingEnabled(false);
        }
        ((HomeActivity)d).customerAlsoBoughtRecommendations(arraylist);
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
        if (view == b)
        {
            ((BBYBaseFragmentActivity)d).changeActionBarShareVisibility(d, false);
            view = new PLPFragmentContainer(k);
            PLPFragment plpfragment = new PLPFragment(true, "CustomerAlsoBought", "Customers Also Bought", "all", h, "Home", 10);
            ((PDPFragmentContainer)((PDPFragment)getParentFragment()).getParentFragment()).a(view, true);
            view.a(plpfragment, true);
        }
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        bundle = getArguments();
        if (bundle != null && bundle.containsKey("isFromMdot"))
        {
            k = bundle.getBoolean("isFromMdot");
            i = bundle.getString("BreadCrumb");
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (g == null)
        {
            g = layoutinflater.inflate(0x7f0300db, viewgroup, false);
            c = g.findViewById(0x7f0c0064);
            a = (BBYProductViewPager)g.findViewById(0x7f0c005e);
            a.setPageMargin(15);
            b = (LinearLayout)g.findViewById(0x7f0c0073);
            b.setOnClickListener(this);
            g.findViewById(0x7f0c035c).setVisibility(0);
            ((BBYTextView)g.findViewById(0x7f0c005c)).setText("CUSTOMERS ALSO BOUGHT");
            j = new hd(d, this, c, h);
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
            j = new hd(d, this, c, h);
            j.executeOnExecutor(nb.h, new Void[0]);
        }
        if (l != null)
        {
            l.notifyDataSetChanged();
        }
    }
}
