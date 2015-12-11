// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.appsettings;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import kb;
import nb;

public class AppSettingsFragment extends BBYBaseFragment
{

    private Activity a;

    public AppSettingsFragment()
    {
    }

    static Activity a(AppSettingsFragment appsettingsfragment)
    {
        return appsettingsfragment.a;
    }

    public void a()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a = activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f03000a, viewgroup, false);
        f = nb.a();
        ((LinearLayout)layoutinflater.findViewById(0x7f0c0051)).setOnClickListener(new android.view.View.OnClickListener() {

            final AppSettingsFragment a;

            public void onClick(View view)
            {
                view = kb.a("AppSettingsEnvironmentFragment");
                ((HomeActivity)AppSettingsFragment.a(a)).addFragment(0x7f0c0033, view, "AppSettingsEnvironmentFragment");
            }

            
            {
                a = AppSettingsFragment.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        ((BBYBaseFragmentActivity)a).showActionBarHome();
        ((BBYBaseFragmentActivity)a).updateActionBarTitle(f.T());
    }

    public void onResume()
    {
        super.onResume();
        String s = ((BBYBaseFragmentActivity)a).getCurrentActionBarTitle();
        if (!s.isEmpty())
        {
            f.i(s);
        }
        ((BBYBaseFragmentActivity)a).updateActionBarTitle("");
        ((BBYBaseFragmentActivity)a).hideActionBarHomeAndSearchBox(a);
    }
}
