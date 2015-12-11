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

public static class 
    implements IPCCommand
{

    public static final String KEY_DEVICE_TYPE = "device_type";
    public static final String KEY_DIRECTED_ID = "directed_id";
    public static final String KEY_OPTIONS = "options";

    public static Bundle parametersToBundle(String s, String s1, Bundle bundle, Tracer tracer)
    {
        Bundle bundle1 = new Bundle();
        bundle1.putString("directed_id", s);
        bundle1.putString("device_type", s1);
        bundle1.putBundle("options", bundle);
        tracer.addToBundle(bundle1);
        return bundle1;
    }

    public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
    {
        String s;
        String s1;
        Bundle bundle1;
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        s = bundle.getString("directed_id");
        s1 = bundle.getString("device_type");
        bundle1 = bundle.getBundle("options");
        context = AccountManagerLogic.getInstance(context);
        bundle = Tracer.createFromBundle(bundle, "RegisterChildApplication");
        context.registerChildApplication(s, s1, bundle1, MetricsHelper.wrapCallback(bundle, callback), bundle);
        return null;
    }

    public ()
    {
    }
}
