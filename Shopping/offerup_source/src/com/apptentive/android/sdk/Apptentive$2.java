// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apptentive.android.sdk;

import android.content.Context;
import com.apptentive.android.sdk.module.metric.MetricModule;

// Referenced classes of package com.apptentive.android.sdk:
//            Log

final class val.context
    implements htExceptionHandler
{

    final Context val$context;

    public final void uncaughtException(Thread thread, Throwable throwable)
    {
        Log.w("Caught UncaughtException in thread \"%s\"", throwable, new Object[] {
            thread.getName()
        });
        MetricModule.sendError(val$context.getApplicationContext(), throwable, null, null);
    }

    .MetricModule()
    {
        val$context = context1;
        super();
    }
}
