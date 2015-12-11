// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;

import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;
import com.amazon.mShop.feature.Features;
import com.amazon.mShop.primeupsell.PrimeFlagChecker;
import com.amazon.mShop.publicurl.PublicURLActivity;
import com.amazon.mShop.splashscreen.StartupActivity;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.mediator.Mediator;

// Referenced classes of package com.amazon.mShop.startup:
//            StartupTask, StartupSequenceMediator

class val.activity extends StartupTask
{

    final StartupSequenceMediator this$0;
    final StartupActivity val$activity;

    private void startRequestedEntry()
    {
        String s = val$activity.getIntent().getComponent().getClassName();
        if (s.endsWith(val$activity.getString(com.amazon.mShop.android.lib.her_name)))
        {
            ActivityUtils.startAIVGatewayActivity(val$activity, null, -1);
            return;
        }
        if (s.endsWith("PublicUrlActivity"))
        {
            Intent intent = ActivityUtils.getStartActivityIntent(val$activity, com/amazon/mShop/publicurl/PublicURLActivity, -1);
            intent.setData(val$activity.getIntent().getData());
            val$activity.startActivity(intent);
            return;
        } else
        {
            ActivityUtils.startHomeActivity(val$activity);
            return;
        }
    }

    public void start()
    {
        Log.i("StartupSequenceMediator", (new StringBuilder()).append("start ").append(getId()).toString());
        Features.getInstance().removeFeatureStateSubscriber(StartupSequenceMediator.access$500(StartupSequenceMediator.this));
        if (StartupSequenceMediator.access$600(StartupSequenceMediator.this) != null)
        {
            StartupSequenceMediator.access$600(StartupSequenceMediator.this).setSubscriber(null);
        }
        end("taskResultSucceed");
        if (android.os.ceMediator._cls11.end == 18)
        {
            startRequestedEntry();
            val$activity.finish();
            return;
        } else
        {
            val$activity.finish();
            startRequestedEntry();
            return;
        }
    }

    _cls9(String s, StartupActivity startupactivity)
    {
        this$0 = final_startupsequencemediator;
        val$activity = startupactivity;
        super(Mediator.this, s);
    }
}
