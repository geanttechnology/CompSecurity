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
import android.widget.LinearLayout;
import android.widget.ListView;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.base.BBYBaseFragment;

public class SearchProductsFragment extends BBYBaseFragment
{

    private View a;
    private Activity b;
    private ListView c;
    private LinearLayout g;

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        b = (FragmentActivity)activity;
        ((HomeActivity)activity).instantiateSearch();
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        a = layoutinflater.inflate(0x7f0300eb, null);
        c = (ListView)a.findViewById(0x7f0c03ae);
        g = (LinearLayout)a.findViewById(0x7f0c02af);
        return a;
    }
}
