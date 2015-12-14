// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mixtape.authenticator;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.Bundle;

public class MixtapeNoOpAuthenticator extends AbstractAccountAuthenticator
{

    public MixtapeNoOpAuthenticator(Context context)
    {
        super(context);
    }

    public Bundle addAccount(AccountAuthenticatorResponse accountauthenticatorresponse, String s, String s1, String as[], Bundle bundle)
        throws NetworkErrorException
    {
        return null;
    }

    public Bundle confirmCredentials(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, Bundle bundle)
        throws NetworkErrorException
    {
        return null;
    }

    public Bundle editProperties(AccountAuthenticatorResponse accountauthenticatorresponse, String s)
    {
        throw new UnsupportedOperationException("Stubbed out!");
    }

    public Bundle getAuthToken(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, String s, Bundle bundle)
        throws NetworkErrorException
    {
        throw new UnsupportedOperationException("Stubbed out!");
    }

    public String getAuthTokenLabel(String s)
    {
        return null;
    }

    public Bundle hasFeatures(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, String as[])
        throws NetworkErrorException
    {
        throw new UnsupportedOperationException("Stubbed out!");
    }

    public Bundle updateCredentials(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, String s, Bundle bundle)
        throws NetworkErrorException
    {
        throw new UnsupportedOperationException("Stubbed out!");
    }
}
