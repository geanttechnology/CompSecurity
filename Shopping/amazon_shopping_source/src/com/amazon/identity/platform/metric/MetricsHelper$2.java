// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.platform.metric;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.framework.Tracer;

// Referenced classes of package com.amazon.identity.platform.metric:
//            MetricsHelper, PlatformMetricsTimer

static final class val.callback
    implements Callback
{

    final Callback val$callback;
    final PlatformMetricsTimer val$timer;
    final Tracer val$tracer;

    public void onError(Bundle bundle)
    {
        if (val$timer != null)
        {
            val$timer.stop();
        }
        if (val$tracer != null)
        {
            val$tracer.finishTrace();
        }
        if (val$callback != null)
        {
            val$callback.onError(bundle);
        }
    }

    public void onSuccess(Bundle bundle)
    {
        if (val$timer != null)
        {
            val$timer.stop();
        }
        if (val$tracer != null)
        {
            val$tracer.finishTrace();
        }
        if (val$callback != null)
        {
            val$callback.onSuccess(bundle);
        }
    }

    imer(PlatformMetricsTimer platformmetricstimer, Tracer tracer1, Callback callback1)
    {
        val$timer = platformmetricstimer;
        val$tracer = tracer1;
        val$callback = callback1;
        super();
    }
}
