// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.beta;

import c.a.a.a.a;
import c.a.a.a.d;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.crashlytics.android.beta:
//            AbstractCheckForUpdatesController

class ActivityLifecycleCheckForUpdatesController extends AbstractCheckForUpdatesController
{

    private final d callbacks = new _cls1();
    private final ExecutorService executorService;

    public ActivityLifecycleCheckForUpdatesController(a a1, ExecutorService executorservice)
    {
        executorService = executorservice;
        a1.a(callbacks);
    }

    public boolean isActivityLifecycleTriggered()
    {
        return true;
    }


    private class _cls1 extends d
    {

        final ActivityLifecycleCheckForUpdatesController this$0;

        public void onActivityStarted(Activity activity)
        {
            class _cls1
                implements Runnable
            {

                final _cls1 this$1;

                public void run()
                {
                    checkForUpdates();
                }

                _cls1()
                {
                    this$1 = _cls1.this;
                    super();
                }
            }

            if (signalExternallyReady())
            {
                executorService.submit(new _cls1());
            }
        }

        _cls1()
        {
            this$0 = ActivityLifecycleCheckForUpdatesController.this;
            super();
        }
    }

}
