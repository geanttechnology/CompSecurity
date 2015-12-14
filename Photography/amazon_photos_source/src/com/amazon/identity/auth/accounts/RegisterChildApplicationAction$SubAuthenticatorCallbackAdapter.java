// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import com.amazon.dcp.sso.ISubAuthenticatorResponse;
import com.amazon.identity.auth.device.api.Callback;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            RegisterChildApplicationAction, AccountsCallbackHelpers

private static class mInnerCallback
    implements ISubAuthenticatorResponse
{

    private final Callback mInnerCallback;

    public IBinder asBinder()
    {
        throw new UnsupportedOperationException("asBinder is not supported in SubAuthenticatorCallbackAdapter");
    }

    public void onError(int i, String s)
        throws RemoteException
    {
        AccountsCallbackHelpers.onError(mInnerCallback, i, s, null);
    }

    public void onResult(Bundle bundle)
        throws RemoteException
    {
        AccountsCallbackHelpers.resultToSuccessOrError(mInnerCallback, bundle);
    }

    public (Callback callback)
    {
        mInnerCallback = callback;
    }
}
