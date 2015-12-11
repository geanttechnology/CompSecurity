// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.framework.IPCCommand;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            MultipleAccountsCommunication, MultipleAccountsLogic

public static class 
    implements IPCCommand
{

    public static final String KEY_ACCOUNT_MAPPING = "mapping";
    public static final String KEY_DIRECTED_ID = "directedId";
    public static final String KEY_VALUE = "value";

    public static boolean getResult(Bundle bundle)
    {
        return bundle.getBoolean("value");
    }

    public static Bundle parametersToBundle(String s, com.amazon.identity.auth.device.api. )
    {
        Bundle bundle = new Bundle();
        bundle.putString("directedId", s);
        bundle.putString("mapping", MultipleAccountsCommunication.access$000(new com.amazon.identity.auth.device.api.[] {
            
        }));
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
        bundle = MultipleAccountsCommunication.access$100(bundle.getString("mapping"));
        if (bundle != null && bundle.length == 1)
        {
            flag = MultipleAccountsLogic.getInstance(context).doesAccountHaveMapping(callback, bundle[0]);
        } else
        {
            MAPLog.e(MultipleAccountsCommunication.access$200(), "Did not specify the mappings properly");
            flag = false;
        }
        context = new Bundle();
        context.putBoolean("value", flag);
        return context;
    }

    public ()
    {
    }
}
