// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;

import android.util.Log;
import com.amazon.mShop.splashscreen.StartupActivity;
import com.amazon.mShop.util.mediator.Mediator;

// Referenced classes of package com.amazon.mShop.startup:
//            StartupTask, StartupSequenceMediator, UserAgreementActivity

class val.activity extends StartupTask
{

    final StartupSequenceMediator this$0;
    final StartupActivity val$activity;

    public void start()
    {
        Log.i("StartupSequenceMediator", (new StringBuilder()).append("start ").append(getId()).toString());
        if (UserAgreementActivity.shouldShowUserAgreement())
        {
            UserAgreementActivity.startActivity(val$activity, getId());
            return;
        } else
        {
            end("taskResultSucceed");
            return;
        }
    }

    (String s, StartupActivity startupactivity)
    {
        this$0 = final_startupsequencemediator;
        val$activity = startupactivity;
        super(Mediator.this, s);
    }
}
