// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.framework.IPCCommand;
import com.amazon.identity.auth.device.framework.Tracer;
import com.amazon.identity.auth.device.utils.KeyInfo;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            CentralAccountManagerCommunication, AccountManagerLogic

public static class 
    implements IPCCommand
{

    public static final String KEY_DIRECTED_ID = "directedId";
    public static final String KEY_KEY = "key";
    public static final String KEY_OPTIONS = "options";

    public static Bundle parametersToBundle(String s, String s1, Bundle bundle)
    {
        Bundle bundle1 = new Bundle();
        bundle1.putString("directedId", s);
        bundle1.putString("key", s1);
        bundle1.putBundle("options", bundle);
        return bundle1;
    }

    public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
    {
        String s;
        KeyInfo keyinfo;
        Bundle bundle1;
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        s = bundle.getString("directedId");
        keyinfo = KeyInfo.parseKey(bundle.getString("key"));
        bundle1 = bundle.getBundle("options");
        AccountManagerLogic.getInstance(context).updateAccountWithKey(s, keyinfo, bundle1, callback, Tracer.createFromBundle(bundle, "UpdateCredentials"));
        return null;
    }

    public ()
    {
    }
}
