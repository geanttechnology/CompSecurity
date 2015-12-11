// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.framework.IPCCommand;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.platform.metric.MetricsHelper;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            CentralAccountManagerCommunication, AccountManagerLogic

public static class a
    implements IPCCommand
{

    public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
    {
        context = AccountManagerLogic.getInstance(context);
        bundle = Tracer.createFromBundle(bundle, "DeregisterDevice");
        context.deregisterDevice(MetricsHelper.wrapRegistrationCallbackWithMetrics(callback, bundle, "com.amazon.dcp.sso.ErrorCode", com.amazon.identity.auth.device.api.), bundle);
        return null;
    }

    public a()
    {
    }
}
