// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;

import com.amazon.mShop.kiang.KiangController;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.splashscreen.StartupActivity;
import com.amazon.mShop.util.BuildUtils;
import com.amazon.mShop.util.Util;
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
        DataStore datastore;
        android.content.Context context;
        datastore = com.amazon.mShop.platform.e().getDataStore();
        context = val$activity.getApplicationContext();
        if (!Util.isEmpty(datastore.getString("applicationInstallId"))) goto _L2; else goto _L1
_L1:
        KiangController.getInstance().kiangRegister(context);
_L4:
        end("taskResultSucceed");
        return;
_L2:
        if (BuildUtils.isKiangUpdateActivated(context))
        {
            KiangController.getInstance().kiangUpdate(context);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    _cls9(String s, StartupActivity startupactivity)
    {
        this$0 = final_startupsequencemediator;
        val$activity = startupactivity;
        super(Mediator.this, s);
    }
}
