// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.localeswitch;

import android.view.View;
import com.amazon.mShop.AmazonActivity;
import com.amazon.mShop.net.NetInfo;
import com.amazon.mShop.util.LocaleUtils;
import com.amazon.mShop.util.UIUtils;

// Referenced classes of package com.amazon.mShop.localeswitch:
//            LocaleSwitcher, LocaleSwitchView

public class LocaleSwitchActivity extends AmazonActivity
    implements LocaleSwitcher
{
    public static interface LocaleSwitchListener
    {

        public abstract void onLocaleSwitch(String s, String s1);
    }


    public LocaleSwitchActivity()
    {
    }

    public void changeLocale(String s)
    {
        if (LocaleUtils.isCurrentLocale(s))
        {
            finish();
            return;
        } else
        {
            LocaleUtils.changeLocale(s, this, null);
            return;
        }
    }

    protected View getLocaleSwitchView()
    {
        return new LocaleSwitchView(this, this);
    }

    protected void onDestroy()
    {
        super.onDestroy();
    }

    public void onStart()
    {
        super.onStart();
        if (getCurrentView() == null)
        {
            setRootView(getLocaleSwitchView());
        }
        if (!NetInfo.hasNetworkConnection())
        {
            UIUtils.info(this, com.amazon.mShop.android.lib.R.string.error_network_no_connection_message);
        }
    }
}
