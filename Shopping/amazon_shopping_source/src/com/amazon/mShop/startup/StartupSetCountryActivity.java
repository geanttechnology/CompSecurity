// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;

import com.amazon.mShop.localeswitch.LocaleSwitchView;
import com.amazon.mShop.localeswitch.LocaleSwitcher;
import com.amazon.mShop.net.NetInfo;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.LocaleUtils;
import com.amazon.mShop.util.UIUtils;

// Referenced classes of package com.amazon.mShop.startup:
//            BaseActivity

public class StartupSetCountryActivity extends BaseActivity
    implements LocaleSwitcher
{

    public StartupSetCountryActivity()
    {
    }

    public void changeLocale(String s)
    {
        LocaleUtils.setCurrentAppLocale(s);
        AppUtils.resetStatus();
        finishIfNotFinishing();
    }

    public void onStart()
    {
        super.onStart();
        setContentView(new LocaleSwitchView(this, this));
        if (!NetInfo.hasNetworkConnection())
        {
            UIUtils.info(this, com.amazon.mShop.android.lib.R.string.error_network_no_connection_message);
        }
    }
}
