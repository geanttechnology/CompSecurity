// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.framework.IPCCommand;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            CentralAccountManagerCommunication, AccountManagerLogic

public static class 
    implements IPCCommand
{

    public static final String KEY_VALUES = "values";

    public static Set getResult(Bundle bundle)
    {
        bundle = bundle.getStringArray("values");
        HashSet hashset = new HashSet();
        if (bundle != null)
        {
            hashset.addAll(Arrays.asList(bundle));
        }
        return hashset;
    }

    public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
    {
        context = AccountManagerLogic.getInstance(context);
        bundle = new Bundle();
        bundle.putStringArray("values", (String[])context.getAccounts().toArray(new String[0]));
        return bundle;
    }

    public ()
    {
    }
}
