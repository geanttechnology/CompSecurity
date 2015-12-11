// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import android.os.RemoteException;
import com.amazon.identity.auth.device.api.Callback;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountAuthenticatorResponseHelper, AccountsCallbackHelpers

static final class val.callback extends android.accounts.ResponseHelper._cls1
{

    final Callback val$callback;

    public void onError(int i, String s)
        throws RemoteException
    {
        AccountsCallbackHelpers.onAccountManagerError(val$callback, i, s);
    }

    public void onRequestContinued()
        throws RemoteException
    {
    }

    public void onResult(Bundle bundle)
        throws RemoteException
    {
        AccountsCallbackHelpers.resultToSuccessOrError(val$callback, bundle);
    }

    (Callback callback1)
    {
        val$callback = callback1;
        super();
    }
}
