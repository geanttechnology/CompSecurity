// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.AccountManager;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import co.vine.android.client.VineAccountHelper;

// Referenced classes of package co.vine.android:
//            LoginActivity, AuthenticatorActivity

public class VineAccountAuthenticator extends AbstractAccountAuthenticator
{

    private final Context mContext;

    public VineAccountAuthenticator(Context context)
    {
        super(context);
        mContext = context;
    }

    public Bundle addAccount(AccountAuthenticatorResponse accountauthenticatorresponse, String s, String s1, String as[], Bundle bundle)
        throws NetworkErrorException
    {
        s = new Bundle();
        s.putParcelable("intent", (new Intent(mContext, co/vine/android/LoginActivity)).putExtra("accountAuthenticatorResponse", accountauthenticatorresponse));
        return s;
    }

    public Bundle confirmCredentials(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, Bundle bundle)
        throws NetworkErrorException
    {
        bundle = new Intent(mContext, co/vine/android/AuthenticatorActivity);
        bundle.putExtra("username", account.name);
        bundle.putExtra("confirm_credentials", true);
        bundle.putExtra("accountAuthenticatorResponse", accountauthenticatorresponse);
        accountauthenticatorresponse = new Bundle();
        accountauthenticatorresponse.putParcelable("intent", bundle);
        return accountauthenticatorresponse;
    }

    public Bundle editProperties(AccountAuthenticatorResponse accountauthenticatorresponse, String s)
    {
        throw new UnsupportedOperationException();
    }

    public Bundle getAuthToken(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, String s, Bundle bundle)
        throws NetworkErrorException
    {
        if (!s.equals("co.vine.android.basic_auth.token.secret"))
        {
            accountauthenticatorresponse = new Bundle();
            accountauthenticatorresponse.putString("errorMessage", "invalid authTokenType");
            return accountauthenticatorresponse;
        }
        bundle = AccountManager.get(mContext).peekAuthToken(account, s);
        if (bundle != null)
        {
            accountauthenticatorresponse = new Bundle();
            accountauthenticatorresponse.putString("authAccount", account.name);
            accountauthenticatorresponse.putString("accountType", VineAccountHelper.ACCOUNT_TYPE);
            accountauthenticatorresponse.putString("authtoken", bundle);
            return accountauthenticatorresponse;
        } else
        {
            bundle = new Intent(mContext, co/vine/android/AuthenticatorActivity);
            bundle.putExtra("accountAuthenticatorResponse", accountauthenticatorresponse);
            bundle.putExtra("username", account.name);
            bundle.putExtra("auth_token_type", s);
            accountauthenticatorresponse = new Bundle();
            accountauthenticatorresponse.putParcelable("intent", bundle);
            return accountauthenticatorresponse;
        }
    }

    public String getAuthTokenLabel(String s)
    {
        return mContext.getString(0x7f0e004e);
    }

    public Bundle hasFeatures(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, String as[])
        throws NetworkErrorException
    {
        accountauthenticatorresponse = new Bundle();
        accountauthenticatorresponse.putBoolean("booleanResult", false);
        return accountauthenticatorresponse;
    }

    public Bundle updateCredentials(AccountAuthenticatorResponse accountauthenticatorresponse, Account account, String s, Bundle bundle)
    {
        bundle = new Intent(mContext, co/vine/android/AuthenticatorActivity);
        bundle.putExtra("username", account.name);
        bundle.putExtra("auth_token_type", s);
        bundle.putExtra("confirm_credentials", false);
        bundle.putExtra("accountAuthenticatorResponse", accountauthenticatorresponse);
        accountauthenticatorresponse = new Bundle();
        accountauthenticatorresponse.putParcelable("intent", bundle);
        return accountauthenticatorresponse;
    }
}
