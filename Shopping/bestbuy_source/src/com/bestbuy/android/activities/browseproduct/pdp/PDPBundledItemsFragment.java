// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.bbyobjects.BBYProductViewPager;
import com.bestbuy.android.bbyobjects.BBYTextView;
import dy;
import hj;
import java.util.ArrayList;
import ll;
import nb;

public class PDPBundledItemsFragment extends BBYBaseFragment
{

    private Activity a;
    private BBYProductViewPager b;
    private View c;
    private View g;
    private ArrayList h;
    private dy i;

    public PDPBundledItemsFragment()
    {
    }

    public void a(ArrayList arraylist)
    {
        i = new dy(a, arraylist, getParentFragment(), true);
        b.setAdapter(i);
        if (arraylist.size() == 1)
        {
            b.setPagingEnabled(false);
        }
        ((BBYTextView)g.findViewById(0x7f0c0210)).setText((new StringBuilder()).append(arraylist.size()).append(" Items").toString());
    }

    public void b()
    {
        if (g != null)
        {
            ll.a(g);
        }
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        (new hj(a, this, c, h)).executeOnExecutor(nb.h, new Void[0]);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a = activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        g = layoutinflater.inflate(0x7f03008a, viewgroup, false);
        c = g.findViewById(0x7f0c0064);
        b = (BBYProductViewPager)g.findViewById(0x7f0c005e);
        b.setPageMargin(15);
        return g;
    }

    public void onResume()
    {
        super.onResume();
        if (i != null)
        {
            i.notifyDataSetChanged();
        }
    }
}
