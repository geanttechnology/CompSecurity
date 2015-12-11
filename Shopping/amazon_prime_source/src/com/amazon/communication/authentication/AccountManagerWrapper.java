// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.authentication;

import android.accounts.Account;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.OnAccountsUpdateListener;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public interface AccountManagerWrapper
{

    public abstract boolean addAccountExplicitly(Account account, String s, Bundle bundle);

    public abstract void addOnAccountsUpdatedListener(OnAccountsUpdateListener onaccountsupdatelistener, Handler handler, boolean flag);

    public abstract Account[] getAccountsByType(String s);

    public abstract String getUserData(Account account, String s);

    public abstract AccountManagerFuture removeAccount(Account account, AccountManagerCallback accountmanagercallback, Handler handler);

    public abstract void removeOnAccountsUpdatedListener(OnAccountsUpdateListener onaccountsupdatelistener);

    public abstract AccountManagerFuture updateCredentials(Account account, String s, Bundle bundle, Activity activity, AccountManagerCallback accountmanagercallback, Handler handler);
}
