// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.accounts.AccountAuthenticatorResponse;
import android.accounts.IAccountAuthenticatorResponse;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.amazon.identity.auth.device.api.Callback;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountsCallbackHelpers

public final class AccountAuthenticatorResponseHelper
{

    private AccountAuthenticatorResponseHelper()
    {
    }

    public static AccountAuthenticatorResponse createCallbackToAccountAuthenticatorResponseAdapter(Callback callback)
    {
        callback = new android.accounts.IAccountAuthenticatorResponse.Stub(callback) {

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
        };
        Parcel parcel = Parcel.obtain();
        parcel.writeStrongBinder(callback.asBinder());
        parcel.setDataPosition(0);
        return new AccountAuthenticatorResponse(parcel);
    }
}
