// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;

import com.amazon.mShop.primeupsell.PrimeUpsellHelper;
import com.amazon.mShop.splashscreen.StartupActivity;

// Referenced classes of package com.amazon.mShop.startup:
//            StartupSequenceMediator

class val.activity
    implements com.amazon.mShop.primeupsell.
{

    final StartupSequenceMediator this$0;
    final StartupActivity val$activity;

    public void onCancelled()
    {
        endTask("taskPrimeUpsell", "taskResultFail");
    }

    public void onComplete()
    {
        if (!PrimeUpsellHelper.showPrimeUpsell(val$activity, null, "prime_start", "taskPrimeUpsell"))
        {
            endTask("taskPrimeUpsell", "taskResultSucceed");
        }
    }

    public void onError()
    {
        endTask("taskPrimeUpsell", "taskResultFail");
    }

    iber()
    {
        this$0 = final_startupsequencemediator;
        val$activity = StartupActivity.this;
        super();
    }
}
