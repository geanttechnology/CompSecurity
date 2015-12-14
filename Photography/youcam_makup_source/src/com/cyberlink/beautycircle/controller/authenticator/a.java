// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.authenticator;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.cyberlink.beautycircle.controller.activity.RegisterActivity;

public class a extends AbstractAccountAuthenticator
{

    private final Context a;

    public a(Context context)
    {
        super(context);
        a = context;
    }

    public Bundle addAccount(AccountAuthenticatorResponse accountauthenticatorresponse, String s, String s1, String as[], Bundle bundle)
    {
        accountauthenticatorresponse = new Intent();
        accountauthenticatorresponse.setClass(a, com/cyberlink/beautycircle/controller/activity/RegisterActivity);
        accountauthenticatorresponse.putExtra("leave_now", true);
        s = new Bundle();
        s.putParcelable("intent", accountauthenticatorresponse);
        return s;
    }

    public Bundle confirmCredentials(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, Bundle bundle)
    {
        return null;
    }

    public Bundle editProperties(AccountAuthenticatorResponse accountauthenticatorresponse, String s)
    {
        return null;
    }

    public Bundle getAuthToken(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, String s, Bundle bundle)
    {
        return null;
    }

    public String getAuthTokenLabel(String s)
    {
        return null;
    }

    public Bundle hasFeatures(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, String as[])
    {
        return null;
    }

    public Bundle updateCredentials(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, String s, Bundle bundle)
    {
        return null;
    }
}
