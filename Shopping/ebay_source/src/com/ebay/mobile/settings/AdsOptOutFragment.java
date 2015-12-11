// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.mobile.analytics.TrackingType;
import com.ebay.mobile.analytics.model.TrackingData;

public class AdsOptOutFragment extends BaseFragment
{

    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo log = new com.ebay.nautilus.kernel.util.FwLog.LogInfo("AdsOptOutFragment", 3, "Ads Opt Out");

    public AdsOptOutFragment()
    {
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (TextView)layoutinflater.inflate(0x7f03022a, viewgroup, false);
        layoutinflater.setText(0x7f070076);
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
        (new TrackingData("AdvertisingOptOut", TrackingType.PAGE_IMPRESSION)).send(getActivity());
    }

}
