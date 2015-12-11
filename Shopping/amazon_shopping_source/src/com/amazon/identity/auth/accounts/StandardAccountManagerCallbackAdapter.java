// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.framework.AccountManagerCallbackAdapter;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountsCallbackHelpers

public class StandardAccountManagerCallbackAdapter extends AccountManagerCallbackAdapter
{

    public StandardAccountManagerCallbackAdapter(Callback callback)
    {
        super(callback);
    }

    protected void onResult(Callback callback, Bundle bundle)
    {
        AccountsCallbackHelpers.resultToSuccessOrError(callback, bundle);
    }

    protected volatile void onResult(Callback callback, Object obj)
    {
        onResult(callback, (Bundle)obj);
    }
}
