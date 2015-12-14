// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.platform.metric;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;

// Referenced classes of package com.amazon.identity.platform.metric:
//            MetricsHelper, PlatformMetricsTimer

static final class val.callback
    implements Callback
{

    final Callback val$callback;
    final PlatformMetricsTimer val$timer;

    public void onError(Bundle bundle)
    {
        val$timer.stop();
        if (val$callback != null)
        {
            val$callback.onError(bundle);
        }
    }

    public void onSuccess(Bundle bundle)
    {
        val$timer.stop();
        if (val$callback != null)
        {
            val$callback.onSuccess(bundle);
        }
    }

    imer(PlatformMetricsTimer platformmetricstimer, Callback callback1)
    {
        val$timer = platformmetricstimer;
        val$callback = callback1;
        super();
    }
}
