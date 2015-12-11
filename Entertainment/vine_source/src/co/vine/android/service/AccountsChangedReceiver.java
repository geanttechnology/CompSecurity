// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package co.vine.android.service;

import android.accounts.AccountManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import co.vine.android.client.AppController;
import co.vine.android.client.VineAccountHelper;

public class AccountsChangedReceiver extends BroadcastReceiver
{

    public AccountsChangedReceiver()
    {
    }

    public void onReceive(Context context, Intent intent)
    {
        intent = AccountManager.get(context).getAccountsByType(VineAccountHelper.ACCOUNT_TYPE);
        context = AppController.getInstance(context);
        if (intent.length > 0)
        {
            return;
        } else
        {
            context.logout(context.getActiveSession());
            return;
        }
    }
}
