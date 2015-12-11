// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.framework.IPCCommand;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            MultipleAccountsCommunication, MultipleAccountsLogic

public static class 
    implements IPCCommand
{

    public static final String KEY_ACCOUNT_MAPPINGS = "mappings";
    public static final String KEY_VALUE = "value";

    public static String getResult(Bundle bundle)
    {
        return bundle.getString("value");
    }

    public static transient Bundle parametersToBundle(com.amazon.identity.auth.device.api. a[])
    {
        Bundle bundle = new Bundle();
        bundle.putString("mappings", MultipleAccountsCommunication.access$000(a));
        return bundle;
    }

    public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
    {
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        bundle = MultipleAccountsCommunication.access$100(bundle.getString("mappings"));
        context = MultipleAccountsLogic.getInstance(context).getAccountForMapping(bundle);
        bundle = new Bundle();
        bundle.putString("value", context);
        return bundle;
    }

    public ()
    {
    }
}
