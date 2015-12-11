// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.framework.IPCCommand;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            NonCanonicalDataStorage, DataStorage

public static class 
    implements IPCCommand
{

    public static final String KEY_DIRECTED_ID = "directedId";
    public static final String KEY_KEY = "key";
    public static final String KEY_VALUE = "value";

    public static String getResult(Bundle bundle)
    {
        return bundle.getString("value");
    }

    public static Bundle parametersToBundle(String s, String s1)
    {
        Bundle bundle = new Bundle();
        bundle.putString("directedId", s);
        bundle.putString("key", s1);
        return bundle;
    }

    public Bundle performIPCAction(Context context, Bundle bundle, Callback callback)
    {
        Bundle bundle1;
        if (bundle == null)
        {
            bundle = new Bundle();
        }
        callback = bundle.getString("directedId");
        bundle = bundle.getString("key");
        context = NonCanonicalDataStorage.access$000(context);
        bundle1 = new Bundle();
        bundle1.putString("value", context.getToken(callback, bundle));
        return bundle1;
    }

    public ()
    {
    }
}
