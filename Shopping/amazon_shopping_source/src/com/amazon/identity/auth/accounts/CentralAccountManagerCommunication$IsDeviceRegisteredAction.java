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

    public static final String KEY_CALLING_APPLICATION_INFO_BUNDLE = "calling.app.info";
    public static final String KEY_VALUE = "value";

    public static boolean getResult(Bundle bundle)
    {
        return bundle.getBoolean("value");
    }

    public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
    {
        context = AccountManagerLogic.getInstance(context);
        bundle = new Bundle();
        bundle.putBoolean("value", context.isDeviceRegistered());
        return bundle;
    }

    public ()
    {
    }
}
