// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;

import amazon.android.dexload.SupplementalDexLoader;
import com.amazon.mShop.appstore.AppstoreUtils;
import com.amazon.mShop.splashscreen.StartupActivity;
import com.amazon.mShop.util.mediator.Mediator;

// Referenced classes of package com.amazon.mShop.startup:
//            StartupTask, StartupSequenceMediator

class val.activity extends StartupTask
{

    final StartupSequenceMediator this$0;
    final StartupActivity val$activity;

    public void start()
    {
        if (AppstoreUtils.isAppstoreAvailable())
        {
            SupplementalDexLoader.getInstance().waitForLoad();
            AppstoreUtils.setAppstoreDeviceInfoCookie(val$activity.getApplicationContext());
            AppstoreUtils.setUpAppstoreDeviceInfoCookieListener();
        }
        end("taskResultSucceed");
    }

    (String s, StartupActivity startupactivity)
    {
        this$0 = final_startupsequencemediator;
        val$activity = startupactivity;
        super(Mediator.this, s);
    }
}
