// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.digidust.elokence.akinator.activities;

import android.app.ActivityManager;
import com.digidust.elokence.akinator.factories.AkLog;
import com.digidust.elokence.akinator.factories.AkSceneryFactory;

// Referenced classes of package com.digidust.elokence.akinator.activities:
//            SplashscreenActivity

class this._cls0
    implements Runnable
{

    final SplashscreenActivity this$0;

    public void run()
    {
        ActivityManager activitymanager = (ActivityManager)getSystemService("activity");
        AkSceneryFactory.sharedInstance().updateMaxMemory(activitymanager.getMemoryClass());
        AkLog.d("HomeActivity", (new StringBuilder()).append("Memory class : ").append(activitymanager.getMemoryClass()).toString());
        AkSceneryFactory.sharedInstance().initDefault(getScreenWidth());
    }

    ()
    {
        this$0 = SplashscreenActivity.this;
        super();
    }
}
