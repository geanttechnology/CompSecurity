// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.plp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import eo;
import hj;
import java.util.ArrayList;
import nb;

public class PLPBundledProductFragment extends BBYBaseFragment
{

    private Activity a;
    private ArrayList b;
    private ListView c;

    public PLPBundledProductFragment()
    {
    }

    public PLPBundledProductFragment(Activity activity, ArrayList arraylist)
    {
        a = activity;
        b = arraylist;
    }

    public void a(ArrayList arraylist)
    {
        arraylist = new eo(a, 0x7f0300bb, arraylist);
        c.setAdapter(arraylist);
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        bundle = ((BBYBaseFragmentActivity)a).getCurrentActionBarTitle();
        f.i(bundle);
        ((BBYBaseFragmentActivity)a).updateActionBarTitle("Bundle Items");
        ((BBYBaseFragmentActivity)a).hideActionBarHome();
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a = activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03001a, viewgroup, false);
        c = (ListView)layoutinflater.findViewById(0x7f0c0075);
        viewgroup = (FrameLayout)layoutinflater.findViewById(0x7f0c0064);
        (new hj(a, this, viewgroup, b)).executeOnExecutor(nb.h, new Void[0]);
        return layoutinflater;
    }
}
