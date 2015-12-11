// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;

import android.content.Intent;
import com.amazon.mShop.net.RefMarkerObserver;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.splashscreen.StartupActivity;
import com.amazon.mShop.sso.IdentityType;
import com.amazon.mShop.sso.SSOSplashScreenActivity;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.Util;
import com.amazon.mShop.util.mediator.Mediator;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.startup:
//            StartupTask, StartupSequenceMediator

class this._cls0 extends StartupTask
{

    final StartupSequenceMediator this$0;

    public void start()
    {
        com.amazon.mShop.util._mth12("StartupSequenceMediator", (new StringBuilder()).append("start ").append(getId()).toString());
        Object obj = com.amazon.mShop.platform.e().getDataStore();
        if (StartupSequenceMediator.access$700(StartupSequenceMediator.this) && SSOUtil.hasAmazonAccount())
        {
            RefMarkerObserver.logRefMarker("fs_with_account");
        }
        String s = SSOUtil.getAuthPoolForCurrentLocale();
        if (!((DataStore) (obj)).getBoolean("ignoreOptOutFirstLaunch", s) && IdentityType.NON_SSO_TYPE != SSOUtil.getCurrentIdentityType() && !Util.isEmpty(SSOUtil.selectMatchedAccount()))
        {
            ((DataStore) (obj)).putBoolean("ignoreOptOutFirstLaunch", true, s);
            obj = new Intent();
            ((Intent) (obj)).setClass(mStartupActivity, com/amazon/mShop/sso/SSOSplashScreenActivity);
            mStartupActivity.startActivity(((Intent) (obj)));
        }
        end("taskResultSucceed");
    }

    _cls9(Mediator mediator, String s)
    {
        this$0 = StartupSequenceMediator.this;
        super(mediator, s);
    }
}
