// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;

import android.util.Log;
import com.amazon.mShop.util.AppUtils;
import com.amazon.mShop.util.mediator.Mediator;

// Referenced classes of package com.amazon.mShop.startup:
//            StartupTask, StartupSequenceMediator

class this._cls0 extends StartupTask
{

    final StartupSequenceMediator this$0;

    public void start()
    {
        Log.i("StartupSequenceMediator", (new StringBuilder()).append("start ").append(getId()).toString());
        AppUtils.sendRequestCoinBalanceBroadcast(mStartupActivity);
        end("taskResultSucceed");
    }

    (Mediator mediator, String s)
    {
        this$0 = StartupSequenceMediator.this;
        super(mediator, s);
    }
}
