// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.sso;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;

public class Authenticator extends AbstractAccountAuthenticator
{

    protected final Context mContext;

    public Authenticator(Context context)
    {
        super(context);
        mContext = context;
    }

    public Bundle addAccount(AccountAuthenticatorResponse accountauthenticatorresponse, String s, String s1, String as[], Bundle bundle)
        throws NetworkErrorException
    {
        accountauthenticatorresponse = bundle.getString("androidPackageName");
        if (mContext.getPackageManager().checkSignatures(mContext.getPackageName(), accountauthenticatorresponse) != 0)
        {
            throw new SecurityException("caller package is signed with different certificate");
        } else
        {
            return null;
        }
    }

    public Bundle confirmCredentials(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, Bundle bundle)
        throws NetworkErrorException
    {
        return null;
    }

    public Bundle editProperties(AccountAuthenticatorResponse accountauthenticatorresponse, String s)
    {
        return null;
    }

    public Bundle getAuthToken(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, String s, Bundle bundle)
        throws NetworkErrorException
    {
        return null;
    }

    public String getAuthTokenLabel(String s)
    {
        return s;
    }

    public Bundle hasFeatures(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, String as[])
        throws NetworkErrorException
    {
        accountauthenticatorresponse = new Bundle();
        accountauthenticatorresponse.putBoolean("booleanResult", false);
        return accountauthenticatorresponse;
    }

    public Bundle updateCredentials(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, String s, Bundle bundle)
        throws NetworkErrorException
    {
        return null;
    }
}
