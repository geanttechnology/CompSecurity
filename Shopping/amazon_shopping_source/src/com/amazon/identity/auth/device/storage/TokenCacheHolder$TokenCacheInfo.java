// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.accounts.Account;
import android.content.Context;
import com.amazon.identity.auth.device.token.TokenCache;
import com.amazon.identity.auth.device.utils.AccountManagerWrapper;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            TokenCacheHolder

private static class mAccount
{

    private final Account mAccount;
    private final String mAccountValidator;
    private final AccountManagerWrapper mAcctMan;
    private final TokenCache mCache;
    private final Context mContext;

    public TokenCache getTokenCache()
    {
        return mCache;
    }

    public boolean isValid()
    {
        String s = mAcctMan.getUserData(mAccount, "com.amazon.dcp.sso.property.account.UUID");
        if (s == null)
        {
            return false;
        } else
        {
            return s.equals(mAccountValidator);
        }
    }

    public (Context context, AccountManagerWrapper accountmanagerwrapper, Account account)
    {
        mContext = context;
        mAccount = account;
        mCache = new TokenCache(mContext, mAccount);
        mAcctMan = accountmanagerwrapper;
        mAccountValidator = mAcctMan.getUserData(mAccount, "com.amazon.dcp.sso.property.account.UUID");
    }
}
