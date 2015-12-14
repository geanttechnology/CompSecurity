// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.beta;

import android.app.Activity;
import bsm;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.crashlytics.android.beta:
//            ActivityLifecycleCheckForUpdatesController

class this._cls0 extends bsm
{

    final ActivityLifecycleCheckForUpdatesController this$0;

    public void onActivityStarted(Activity activity)
    {
        class _cls1
            implements Runnable
        {

            final ActivityLifecycleCheckForUpdatesController._cls1 this$1;

            public void run()
            {
                checkForUpdates();
            }

            _cls1()
            {
                this$1 = ActivityLifecycleCheckForUpdatesController._cls1.this;
                super();
            }
        }

        if (signalExternallyReady())
        {
            ActivityLifecycleCheckForUpdatesController.access$000(ActivityLifecycleCheckForUpdatesController.this).submit(new _cls1());
        }
    }

    _cls1()
    {
        this$0 = ActivityLifecycleCheckForUpdatesController.this;
        super();
    }
}
