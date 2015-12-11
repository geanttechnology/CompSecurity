// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.service.account;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.shazam.android.activities.StubAccountActivity;

public final class a extends AbstractAccountAuthenticator
{

    private final Context a;

    public a(Context context)
    {
        super(context);
        a = context;
    }

    public final Bundle addAccount(AccountAuthenticatorResponse accountauthenticatorresponse, String s, String s1, String as[], Bundle bundle)
    {
        accountauthenticatorresponse = new Intent(a, com/shazam/android/activities/StubAccountActivity);
        s = new Bundle();
        s.putParcelable("intent", accountauthenticatorresponse);
        return s;
    }

    public final Bundle confirmCredentials(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, Bundle bundle)
    {
        return null;
    }

    public final Bundle editProperties(AccountAuthenticatorResponse accountauthenticatorresponse, String s)
    {
        throw new UnsupportedOperationException();
    }

    public final Bundle getAuthToken(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, String s, Bundle bundle)
    {
        throw new UnsupportedOperationException();
    }

    public final String getAuthTokenLabel(String s)
    {
        throw new UnsupportedOperationException();
    }

    public final Bundle hasFeatures(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, String as[])
    {
        throw new UnsupportedOperationException();
    }

    public final Bundle updateCredentials(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, String s, Bundle bundle)
    {
        throw new UnsupportedOperationException();
    }
}
