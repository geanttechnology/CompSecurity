// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.accounts.Account;
import android.content.Context;
import android.content.SharedPreferences;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.utils.MAPLog;

public class AccountRemovedFlagStore
{

    private static final Object LOCK[] = new Object[0];
    private static final String TAG = com/amazon/identity/auth/accounts/AccountRemovedFlagStore.getName();
    private final Context mContext;
    private final SharedPreferences mFlagStore;

    public AccountRemovedFlagStore(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mFlagStore = mContext.getSharedPreferences("account_removed_flag_store", 0);
    }

    private static String getKeyForAccount(Account account)
    {
        return (new StringBuilder("Account_To_Remove_")).append(account.name).toString();
    }

    private void throwIfNotValidAccount(Account account)
    {
        if (!"com.amazon.account".equals(account.type))
        {
            throw new IllegalStateException((new StringBuilder("Not valid for accounts of type: ")).append(account.type).toString());
        } else
        {
            return;
        }
    }

    private boolean writeSharedPrefsToDisk(android.content.SharedPreferences.Editor editor)
    {
        int i = 0;
        while (i <= 2) 
        {
            if (editor.commit())
            {
                return true;
            }
            MAPLog.e(TAG, "Commit failed retrying");
            try
            {
                Thread.sleep(15L);
            }
            catch (InterruptedException interruptedexception)
            {
                MAPLog.e(TAG, "Retry sleep interrupted", interruptedexception);
            }
            i++;
        }
        return false;
    }

    public boolean setAccountToRemoved(Account account)
    {
        Object aobj[] = LOCK;
        aobj;
        JVM INSTR monitorenter ;
        throwIfNotValidAccount(account);
        if (writeSharedPrefsToDisk(mFlagStore.edit().putBoolean(getKeyForAccount(account), true)))
        {
            break MISSING_BLOCK_LABEL_49;
        }
        MAPLog.e(TAG, "Could not write account removed flag to disk");
        return false;
        aobj;
        JVM INSTR monitorexit ;
        return true;
        account;
        throw account;
    }

    public boolean shouldAccountBeRemoved(Account account)
    {
        boolean flag;
        synchronized (LOCK)
        {
            throwIfNotValidAccount(account);
            account = getKeyForAccount(account);
            flag = mFlagStore.getBoolean(account, false);
            if (!writeSharedPrefsToDisk(mFlagStore.edit().remove(account)))
            {
                MAPLog.e(TAG, "Could not clear account removed flag to disk");
            }
        }
        return flag;
    }

}
