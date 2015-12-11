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

    public static final String KEY_DIRECTED_ID = "directed_id";
    public static final String KEY_VALUE = "value";

    public static boolean getResult(Bundle bundle)
    {
        return bundle.getBoolean("value");
    }

    public static Bundle parametersToBundle(String s)
    {
        Bundle bundle = new Bundle();
        bundle.putString("directed_id", s);
        return bundle;
    }

    public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
    {
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        bundle = bundle.getString("directed_id");
        context = AccountManagerLogic.getInstance(context);
        callback = new Bundle();
        callback.putBoolean("value", context.isAccountRegistered(bundle));
        return callback;
    }

    public ()
    {
    }
}
