// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.registry;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import nb;

public class EmptyPlpFragment extends BBYBaseFragment
{

    private TextView a;

    public EmptyPlpFragment()
    {
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = (FragmentActivity)activity;
        nb.a().i(((BBYBaseFragmentActivity)activity).getCurrentActionBarTitle());
        ((BBYBaseFragmentActivity)activity).updateActionBarTitle("Empty PLP Page");
        ((BBYBaseFragmentActivity)activity).hideActionBarHomeAndSearchBox(activity);
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030038, viewgroup, false);
        a = (TextView)layoutinflater.findViewById(0x7f0c00e7);
        a.setText("Sorry, there are no Products to display. Please add products to your wish list or registry");
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
    }
}
