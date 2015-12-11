// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.amazon.dcp.sso.IAmazonAccountAuthenticator;
import com.amazon.dcp.sso.ISubAuthenticatorResponse;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.SecurityHelpers;

public abstract class AbstractSubAuthenticator
{
    private class Transport extends com.amazon.dcp.sso.ISubAuthenticator.Stub
    {

        final AbstractSubAuthenticator this$0;

        public void getAccountRemovalAllowed(ISubAuthenticatorResponse isubauthenticatorresponse, String s, String s1)
            throws RemoteException
        {
            SecurityHelpers.checkCaller(AbstractSubAuthenticator.this);
            AbstractSubAuthenticator.this.getAccountRemovalAllowed(isubauthenticatorresponse, new Account(s1, s));
        }

        public void getAuthToken(ISubAuthenticatorResponse isubauthenticatorresponse, String s, String s1, String s2, Bundle bundle, IAmazonAccountAuthenticator iamazonaccountauthenticator)
        {
            SecurityHelpers.checkCaller(AbstractSubAuthenticator.this);
            if (isubauthenticatorresponse == null || iamazonaccountauthenticator == null)
            {
                MAPLog.e(AbstractSubAuthenticator.TAG, "Invalid parameter passed to getAuthToken");
                return;
            } else
            {
                AbstractSubAuthenticator.this.getAuthToken(isubauthenticatorresponse, new Account(s1, s), s2, bundle, iamazonaccountauthenticator);
                return;
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            boolean flag;
            try
            {
                flag = super.onTransact(i, parcel, parcel1, j);
            }
            // Misplaced declaration of an exception variable
            catch (Parcel parcel)
            {
                MAPLog.e(AbstractSubAuthenticator.TAG, "Unexpected Runtime Exception", parcel);
                throw parcel;
            }
            return flag;
        }

        public void updateAuthToken(ISubAuthenticatorResponse isubauthenticatorresponse, String s, String s1, String s2, Bundle bundle, IAmazonAccountAuthenticator iamazonaccountauthenticator)
        {
            SecurityHelpers.checkCaller(AbstractSubAuthenticator.this);
            if (isubauthenticatorresponse == null || iamazonaccountauthenticator == null)
            {
                MAPLog.e(AbstractSubAuthenticator.TAG, "Invalid parameter passed to updateAuthTokens");
                return;
            } else
            {
                AbstractSubAuthenticator.this.updateAuthToken(isubauthenticatorresponse, new Account(s1, s), s2, bundle, iamazonaccountauthenticator);
                return;
            }
        }

        private Transport()
        {
            this$0 = AbstractSubAuthenticator.this;
            super();
        }

    }


    private static final String TAG = com/amazon/identity/auth/accounts/AbstractSubAuthenticator.getName();
    protected final Context mContext;
    private Transport mTransport;

    public AbstractSubAuthenticator(Context context)
    {
        mTransport = new Transport();
        mContext = context;
    }

    public abstract void getAccountRemovalAllowed(ISubAuthenticatorResponse isubauthenticatorresponse, Account account);

    public abstract void getAuthToken(ISubAuthenticatorResponse isubauthenticatorresponse, Account account, String s, Bundle bundle, IAmazonAccountAuthenticator iamazonaccountauthenticator);

    public final IBinder getIBinder()
    {
        return mTransport.asBinder();
    }

    public void updateAuthToken(ISubAuthenticatorResponse isubauthenticatorresponse, Account account, String s, Bundle bundle, IAmazonAccountAuthenticator iamazonaccountauthenticator)
    {
        try
        {
            isubauthenticatorresponse.onError(6, (new StringBuilder("Unsupported for token type: ")).append(s).toString());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ISubAuthenticatorResponse isubauthenticatorresponse)
        {
            MAPLog.e(TAG, "An unexpected remote exception occured during updateAuthTokens.", isubauthenticatorresponse);
        }
    }



}
