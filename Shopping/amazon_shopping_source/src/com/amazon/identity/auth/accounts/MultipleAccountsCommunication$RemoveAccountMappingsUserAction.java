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
    public static final String KEY_DIRECTED_ID = "directedId";
    public static final String KEY_VALUE = "value";

    public static boolean getResult(Bundle bundle)
    {
        return bundle.getBoolean("value");
    }

    public static transient Bundle parametersToBundle(String s, com.amazon.identity.auth.device.api. a[])
    {
        Bundle bundle = new Bundle();
        bundle.putString("directedId", s);
        bundle.putString("mappings", MultipleAccountsCommunication.access$000(a));
        return bundle;
    }

    public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
    {
        boolean flag;
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        callback = bundle.getString("directedId");
        bundle = MultipleAccountsCommunication.access$100(bundle.getString("mappings"));
        flag = MultipleAccountsLogic.getInstance(context).removeAccountMappings(callback, bundle);
        context = new Bundle();
        context.putBoolean("value", flag);
        return context;
    }

    public ()
    {
    }
}
