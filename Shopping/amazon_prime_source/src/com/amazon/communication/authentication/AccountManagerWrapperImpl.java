// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.authentication;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.OnAccountsUpdateListener;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

// Referenced classes of package com.amazon.communication.authentication:
//            AccountManagerWrapper

public class AccountManagerWrapperImpl
    implements AccountManagerWrapper
{

    private final AccountManager mAccountManager;

    public AccountManagerWrapperImpl(AccountManager accountmanager)
    {
        mAccountManager = accountmanager;
    }

    public boolean addAccountExplicitly(Account account, String s, Bundle bundle)
    {
        return mAccountManager.addAccountExplicitly(account, s, bundle);
    }

    public void addOnAccountsUpdatedListener(OnAccountsUpdateListener onaccountsupdatelistener, Handler handler, boolean flag)
    {
        mAccountManager.addOnAccountsUpdatedListener(onaccountsupdatelistener, handler, flag);
    }

    public Account[] getAccountsByType(String s)
    {
        return mAccountManager.getAccountsByType(s);
    }

    public String getUserData(Account account, String s)
    {
        return mAccountManager.getUserData(account, s);
    }

    public AccountManagerFuture removeAccount(Account account, AccountManagerCallback accountmanagercallback, Handler handler)
    {
        return mAccountManager.removeAccount(account, accountmanagercallback, handler);
    }

    public void removeOnAccountsUpdatedListener(OnAccountsUpdateListener onaccountsupdatelistener)
    {
        mAccountManager.removeOnAccountsUpdatedListener(onaccountsupdatelistener);
    }

    public AccountManagerFuture updateCredentials(Account account, String s, Bundle bundle, Activity activity, AccountManagerCallback accountmanagercallback, Handler handler)
    {
        return mAccountManager.updateCredentials(account, s, bundle, activity, accountmanagercallback, handler);
    }
}
