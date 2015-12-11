// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.platform.metric;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.framework.Tracer;

// Referenced classes of package com.amazon.identity.platform.metric:
//            MetricsHelper

static final class val.defaultError
    implements Callback
{

    final Callback val$callback;
    final com.amazon.identity.auth.device.api.r.RegistrationError val$defaultError;
    final String val$errorCodeKey;
    final Tracer val$tracer;

    public void onError(Bundle bundle)
    {
        String s = com.amazon.identity.auth.device.api.r.RegistrationError.fromValue(bundle.getInt(val$errorCodeKey, val$defaultError.value()), val$defaultError).getName();
        if (val$tracer != null)
        {
            val$tracer.incrementCounter((new StringBuilder("Error:")).append(s).toString());
            val$tracer.finishTrace();
        }
        val$callback.onError(bundle);
    }

    public void onSuccess(Bundle bundle)
    {
        if (val$tracer != null)
        {
            val$tracer.incrementCounter("Success");
            val$tracer.finishTrace();
        }
        val$callback.onSuccess(bundle);
    }

    ror(Tracer tracer1, Callback callback1, String s, com.amazon.identity.auth.device.api.r.RegistrationError registrationerror)
    {
        val$tracer = tracer1;
        val$callback = callback1;
        val$errorCodeKey = s;
        val$defaultError = registrationerror;
        super();
    }
}
