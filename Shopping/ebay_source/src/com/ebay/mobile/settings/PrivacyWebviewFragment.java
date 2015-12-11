// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.settings;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.ebay.mobile.activities.BaseFragment;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;

public class PrivacyWebviewFragment extends BaseFragment
{

    public PrivacyWebviewFragment()
    {
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (ViewGroup)layoutinflater.inflate(0x7f03022b, viewgroup, false);
        layoutinflater.findViewById(0x7f100143).setVisibility(8);
        viewgroup = (WebView)layoutinflater.findViewById(0x7f100316);
        viewgroup.getSettings().setJavaScriptEnabled(true);
        viewgroup.loadUrl(DeviceConfiguration.getAsync().get(com.ebay.mobile.dcs.Dcs.Connect.S.privacyNoticeUrl));
        return layoutinflater;
    }
}
