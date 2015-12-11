// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.framework.IPCCommand;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            CentralAccountManagerCommunication, AccountManagerLogic

public static class 
    implements IPCCommand
{

    public static final String KEY_PACKAGE_NAME = "packageName";
    public static final String KEY_VALUE = "value";

    public static String getResult(Bundle bundle)
    {
        return bundle.getString("value");
    }

    public static Bundle parametersToBundle(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString("packageName", s);
        return bundle;
    }

    public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
    {
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        bundle = bundle.getString("packageName");
        context = AccountManagerLogic.getInstance(context);
        callback = new Bundle();
        callback.putString("value", context.getAccount(bundle));
        return callback;
    }

    public ()
    {
    }
}
