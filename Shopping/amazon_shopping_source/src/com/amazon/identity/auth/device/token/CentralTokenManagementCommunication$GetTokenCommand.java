// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.token;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.framework.IPCCommand;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.platform.metric.MetricsHelper;

// Referenced classes of package com.amazon.identity.auth.device.token:
//            CentralTokenManagementCommunication, TokenManagementLogic

public static class 
    implements IPCCommand
{

    public static final String KEY_DIRECTED_ID = "directed_id";
    public static final String KEY_OPTIONS = "options_key";
    public static final String KEY_TOKEN = "token_key";

    public static Bundle parametersToBundle(String s, String s1, Bundle bundle)
    {
        Bundle bundle1 = new Bundle();
        bundle1.putString("directed_id", s);
        bundle1.putString("token_key", s1);
        bundle1.putBundle("options_key", bundle);
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
        s1 = bundle.getString("token_key");
        bundle1 = bundle.getBundle("options_key");
        bundle = Tracer.createFromBundle(bundle, "TokenManagement:GetToken");
        callback = MetricsHelper.wrapCallback(bundle, callback);
        TokenManagementLogic.getInstance(context).getToken(s, s1, bundle1, callback, bundle);
        return null;
    }

    public ()
    {
    }
}
