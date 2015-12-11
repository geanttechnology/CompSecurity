// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import android.os.RemoteException;
import com.amazon.identity.auth.device.api.Callback;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountsCallbackHelpers

public final class AccountAuthenticatorResponseHelper
{

    // Unreferenced inner class com/amazon/identity/auth/accounts/AccountAuthenticatorResponseHelper$1

/* anonymous class */
    static final class _cls1 extends android.accounts.IAccountAuthenticatorResponse.Stub
    {

        final Callback val$callback;

        public void onError(int i, String s)
            throws RemoteException
        {
            AccountsCallbackHelpers.onAccountManagerError(callback, i, s);
        }

        public void onRequestContinued()
            throws RemoteException
        {
        }

        public void onResult(Bundle bundle)
            throws RemoteException
        {
            AccountsCallbackHelpers.resultToSuccessOrError(callback, bundle);
        }

            
            {
                callback = callback1;
                super();
            }
    }

}
