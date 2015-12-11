// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.accounts.Account;
import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.amazon.dcp.sso.IAmazonAccountAuthenticator;
import com.amazon.dcp.sso.ISubAuthenticatorResponse;
import com.amazon.identity.auth.device.utils.MAPLog;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AbstractSubAuthenticator

private class <init> extends com.amazon.dcp.sso.ator.Transport
{

    final AbstractSubAuthenticator this$0;

    public void getAccountRemovalAllowed(ISubAuthenticatorResponse isubauthenticatorresponse, String s, String s1)
        throws RemoteException
    {
        AbstractSubAuthenticator.access$100(AbstractSubAuthenticator.this);
        AbstractSubAuthenticator.this.getAccountRemovalAllowed(isubauthenticatorresponse, new Account(s1, s));
    }

    public void getAuthToken(ISubAuthenticatorResponse isubauthenticatorresponse, String s, String s1, String s2, Bundle bundle, IAmazonAccountAuthenticator iamazonaccountauthenticator)
    {
        AbstractSubAuthenticator.access$100(AbstractSubAuthenticator.this);
        if (isubauthenticatorresponse == null || iamazonaccountauthenticator == null)
        {
            MAPLog.e(AbstractSubAuthenticator.access$200(), "Invalid parameter passed to getAuthToken");
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
            flag = super.Transport(i, parcel, parcel1, j);
        }
        // Misplaced declaration of an exception variable
        catch (Parcel parcel)
        {
            MAPLog.e(AbstractSubAuthenticator.access$200(), "Unexpected Runtime Exception", parcel);
            throw parcel;
        }
        return flag;
    }

    public void updateAuthToken(ISubAuthenticatorResponse isubauthenticatorresponse, String s, String s1, String s2, Bundle bundle, IAmazonAccountAuthenticator iamazonaccountauthenticator)
    {
        AbstractSubAuthenticator.access$100(AbstractSubAuthenticator.this);
        if (isubauthenticatorresponse == null || iamazonaccountauthenticator == null)
        {
            MAPLog.e(AbstractSubAuthenticator.access$200(), "Invalid parameter passed to updateAuthTokens");
            return;
        } else
        {
            AbstractSubAuthenticator.this.updateAuthToken(isubauthenticatorresponse, new Account(s1, s), s2, bundle, iamazonaccountauthenticator);
            return;
        }
    }

    private ()
    {
        this$0 = AbstractSubAuthenticator.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
