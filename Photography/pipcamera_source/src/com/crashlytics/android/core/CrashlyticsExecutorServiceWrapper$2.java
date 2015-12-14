// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.core;

import aag;
import java.util.concurrent.Callable;
import zw;

// Referenced classes of package com.crashlytics.android.core:
//            CrashlyticsExecutorServiceWrapper

class val.callable
    implements Callable
{

    final CrashlyticsExecutorServiceWrapper this$0;
    final Callable val$callable;

    public Object call()
    {
        Object obj;
        try
        {
            obj = val$callable.call();
        }
        catch (Exception exception)
        {
            zw.h().e("CrashlyticsCore", "Failed to execute task.", exception);
            return null;
        }
        return obj;
    }

    ()
    {
        this$0 = final_crashlyticsexecutorservicewrapper;
        val$callable = Callable.this;
        super();
    }
}
