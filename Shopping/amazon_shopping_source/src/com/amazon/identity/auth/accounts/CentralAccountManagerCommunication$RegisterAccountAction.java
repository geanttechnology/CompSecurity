// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.api.RegistrationType;
import com.amazon.identity.auth.device.framework.IPCCommand;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.platform.metric.MetricsHelper;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            CentralAccountManagerCommunication, AccountManagerLogic

public static class 
    implements IPCCommand
{

    public static final String KEY_REG_DATA = "regData";
    public static final String KEY_REG_TYPE = "regType";

    public static Bundle parametersToBundle(RegistrationType registrationtype, Bundle bundle, Tracer tracer)
    {
        Bundle bundle1 = new Bundle();
        bundle1.putString("regType", registrationtype.getName());
        bundle1.putBundle("regData", bundle);
        tracer.addToBundle(bundle1);
        return bundle1;
    }

    public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
    {
        RegistrationType registrationtype;
        Bundle bundle1;
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        registrationtype = RegistrationType.fromName(bundle.getString("regType"));
        bundle1 = bundle.getBundle("regData");
        context = AccountManagerLogic.getInstance(context);
        bundle = Tracer.createFromBundle(bundle, (new StringBuilder("RegisterAccount:")).append(MetricsHelper.getRegType(registrationtype)).toString());
        bundle.incrementCounter("Count");
        context.registerAccount(registrationtype, bundle1, MetricsHelper.wrapRegistrationCallbackWithMetrics(callback, bundle, "com.amazon.dcp.sso.ErrorCode", com.amazon.identity.auth.device.api.), bundle);
        return null;
    }

    public ()
    {
    }
}
