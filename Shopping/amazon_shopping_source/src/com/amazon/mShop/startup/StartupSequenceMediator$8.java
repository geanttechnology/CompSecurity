// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;

import android.util.Log;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.primeupsell.PrimeUpsellHelper;
import com.amazon.mShop.splashscreen.StartupActivity;
import com.amazon.mShop.sso.IdentityType;
import com.amazon.mShop.sso.SSOUtil;
import com.amazon.mShop.util.mediator.Mediator;
import com.amazon.rio.j2me.client.persistence.DataStore;

// Referenced classes of package com.amazon.mShop.startup:
//            StartupTask, StartupSequenceMediator

class val.activity extends StartupTask
{

    final StartupSequenceMediator this$0;
    final StartupActivity val$activity;

    public void start()
    {
        Log.i("StartupSequenceMediator", (new StringBuilder()).append("start ").append(getId()).toString());
        if (!com.amazon.mShop.platform.ce().getDataStore().getBoolean("ignoreOptOutFirstLaunch", SSOUtil.getAuthPoolForCurrentLocale()) && IdentityType.NON_SSO_TYPE != SSOUtil.getCurrentIdentityType())
        {
            end("taskResultSucceed");
        } else
        {
            if (PrimeUpsellHelper.shouldCheckPrimeFlagStatus())
            {
                StartupSequenceMediator.access$400(StartupSequenceMediator.this, val$activity, this);
                return;
            }
            if (!PrimeUpsellHelper.showPrimeUpsell(val$activity, null, "prime_start", "taskPrimeUpsell"))
            {
                end("taskResultSucceed");
                return;
            }
        }
    }

    (String s, StartupActivity startupactivity)
    {
        this$0 = final_startupsequencemediator;
        val$activity = startupactivity;
        super(Mediator.this, s);
    }
}
