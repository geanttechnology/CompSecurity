// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import android.support.v7.alt;
import android.support.v7.amc;

// Referenced classes of package com.crashlytics.android.core:
//            CrashlyticsExecutorServiceWrapper

class val.runnable
    implements Runnable
{

    final CrashlyticsExecutorServiceWrapper this$0;
    final Runnable val$runnable;

    public void run()
    {
        try
        {
            val$runnable.run();
            return;
        }
        catch (Exception exception)
        {
            alt.h().e("CrashlyticsCore", "Failed to execute task.", exception);
        }
    }

    ()
    {
        this$0 = final_crashlyticsexecutorservicewrapper;
        val$runnable = Runnable.this;
        super();
    }
}
