// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYProductViewPager;
import dy;
import il;
import java.util.ArrayList;
import ll;
import nb;

public class PDPRequiredAccessoriesFragment extends BBYBaseFragment
{

    private OverviewResponse a;
    private Activity b;
    private View c;
    private View g;
    private View h;
    private LinearLayout i;
    private RelativeLayout j;
    private ArrayList k;
    private il l;
    private BBYProductViewPager m;
    private dy n;

    public PDPRequiredAccessoriesFragment()
    {
    }

    public PDPRequiredAccessoriesFragment(OverviewResponse overviewresponse)
    {
        a = overviewresponse;
        Bundle bundle = new Bundle();
        bundle.putSerializable("product", overviewresponse);
        setArguments(bundle);
    }

    public void a(ArrayList arraylist)
    {
        k = arraylist;
        n = new dy(b, k, getParentFragment(), true);
        m.setAdapter(n);
        m.startAnimation(ll.a(b));
        if (k.size() == 1)
        {
            m.setPagingEnabled(false);
        }
        i.setVisibility(0);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        b = activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        if (a == null)
        {
            a = (OverviewResponse)getArguments().getSerializable("product");
        }
        if (c == null)
        {
            c = layoutinflater.inflate(0x7f0300ad, viewgroup, false);
            i = (LinearLayout)c.findViewById(0x7f0c02ac);
            g = c.findViewById(0x7f0c02ad);
            h = c.findViewById(0x7f0c02ae);
            m = (BBYProductViewPager)c.findViewById(0x7f0c005e);
            m.setPageMargin(15);
            j = (RelativeLayout)c.findViewById(0x7f0c02af);
            if (a != null)
            {
                l = new il(b, this, h, a);
                l.executeOnExecutor(nb.h, new Void[0]);
            }
        } else
        {
            ((ViewGroup)c.getParent()).removeView(c);
        }
        return c;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (l != null)
        {
            l.cancel(true);
        }
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
        if (n != null)
        {
            n.notifyDataSetChanged();
        }
    }
}
