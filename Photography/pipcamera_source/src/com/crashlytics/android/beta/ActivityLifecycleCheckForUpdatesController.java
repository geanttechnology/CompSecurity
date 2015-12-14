// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.beta;

import android.app.Activity;
import java.util.concurrent.ExecutorService;
import zs;
import zu;

// Referenced classes of package com.crashlytics.android.beta:
//            AbstractCheckForUpdatesController

class ActivityLifecycleCheckForUpdatesController extends AbstractCheckForUpdatesController
{

    private final zu callbacks = new zu() {

        final ActivityLifecycleCheckForUpdatesController this$0;

        public void onActivityStarted(Activity activity)
        {
            if (signalExternallyReady())
            {
                executorService.submit(new Runnable() {

                    final _cls1 this$1;

                    public void run()
                    {
                        checkForUpdates();
                    }

            
            {
                this$1 = _cls1.this;
                super();
            }
                });
            }
        }

            
            {
                this$0 = ActivityLifecycleCheckForUpdatesController.this;
                super();
            }
    };
    private final ExecutorService executorService;

    public ActivityLifecycleCheckForUpdatesController(zs zs1, ExecutorService executorservice)
    {
        executorService = executorservice;
        zs1.a(callbacks);
    }

    public boolean isActivityLifecycleTriggered()
    {
        return true;
    }

}
