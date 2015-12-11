// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.mobile.activities;

import android.text.TextUtils;
import com.ebay.common.Preferences;
import com.ebay.mobile.MyApp;
import com.ebay.mobile.dcs.DcsHelper;
import com.ebay.nautilus.domain.dcs.DeviceConfiguration;

// Referenced classes of package com.ebay.mobile.activities:
//            ShowWebViewActivity

public class OcsActivity extends ShowWebViewActivity
{

    public OcsActivity()
    {
    }

    protected void readIntent()
    {
        boolean flag = true;
        super.readIntent();
        impression = "ContactEbaySupport";
        title = getString(0x7f07027b);
        useBackStack = true;
        DcsHelper dcshelper = MyApp.getDeviceConfiguration();
        scope = dcshelper.getConfig().get(com.ebay.mobile.dcs.Dcs.Connect.S.ocsSsoScope);
        url = dcshelper.ocsUrl();
        if (TextUtils.isEmpty(scope) || !MyApp.getPrefs().isSignedIn())
        {
            flag = false;
        }
        useSso = flag;
        addDeviceId = false;
    }
}
