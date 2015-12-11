// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.bestbuy.android.activities.browseproduct.pdp;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bestbuy.android.activities.home.HomeActivity;
import com.bestbuy.android.api.lib.models.pdp.OverviewResponse;
import com.bestbuy.android.base.BBYBaseFragment;

public class PDPFooterFragment extends BBYBaseFragment
{

    public PDPFooterFragment()
    {
    }

    public PDPFooterFragment(OverviewResponse overviewresponse)
    {
    }

    public void onActivityCreated(Bundle bundle)
    {
        super.onActivityCreated(bundle);
        ((HomeActivity)d).sendRecommendations("load");
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        d = activity;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        return layoutinflater.inflate(0x7f03008e, viewgroup, false);
    }
}
