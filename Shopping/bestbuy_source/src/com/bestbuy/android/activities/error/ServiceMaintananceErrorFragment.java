// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.error;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bestbuy.android.base.BBYBaseFragment;
import com.bestbuy.android.base.BBYBaseFragmentActivity;
import nb;

public class ServiceMaintananceErrorFragment extends BBYBaseFragment
{

    private Activity a;
    private boolean b;

    public ServiceMaintananceErrorFragment()
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        a = (FragmentActivity)activity;
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f0300ed, viewgroup, false);
        layoutinflater.findViewById(0x7f0c03b0).setOnClickListener(new android.view.View.OnClickListener() {

            final ServiceMaintananceErrorFragment a;

            public void onClick(View view)
            {
                view = new Intent("android.intent.action.VIEW", Uri.parse("http://www.bestbuy.com"));
                a.startActivity(view);
            }

            
            {
                a = ServiceMaintananceErrorFragment.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onDestroy()
    {
        super.onDestroy();
        if (b)
        {
            ((BBYBaseFragmentActivity)a).showActionBarHome();
            ((BBYBaseFragmentActivity)a).updateActionBarTitle(f.T());
        }
    }

    public void onPause()
    {
        super.onPause();
    }

    public void onResume()
    {
        super.onResume();
    }
}
