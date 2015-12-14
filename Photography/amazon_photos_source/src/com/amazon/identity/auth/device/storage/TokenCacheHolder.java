// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.accounts.Account;
import android.content.Context;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.token.TokenCache;
import com.amazon.identity.auth.device.utils.AccountManagerWrapper;
import java.util.WeakHashMap;

public class TokenCacheHolder
{
    private static class TokenCacheInfo
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

        public TokenCacheInfo(Context context, AccountManagerWrapper accountmanagerwrapper, Account account)
        {
            mContext = context;
            mAccount = account;
            mCache = new TokenCache(mContext, mAccount);
            mAcctMan = accountmanagerwrapper;
            mAccountValidator = mAcctMan.getUserData(mAccount, "com.amazon.dcp.sso.property.account.UUID");
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/storage/TokenCacheHolder.getName();
    private static TokenCacheHolder sTheOneAndTheOnly;
    private final AccountManagerWrapper mAcctMan;
    private final ServiceWrappingContext mContext;
    private final Object mLock[] = new Object[0];
    private final WeakHashMap mTokenCacheLookup = new WeakHashMap();

    TokenCacheHolder(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mAcctMan = (AccountManagerWrapper)mContext.getSystemService("dcp_account_manager");
    }

    public static TokenCacheHolder getInstance(Context context)
    {
        com/amazon/identity/auth/device/storage/TokenCacheHolder;
        JVM INSTR monitorenter ;
        if (sTheOneAndTheOnly == null)
        {
            sTheOneAndTheOnly = new TokenCacheHolder(context.getApplicationContext());
        }
        context = sTheOneAndTheOnly;
        com/amazon/identity/auth/device/storage/TokenCacheHolder;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public TokenCache getTokenCache(Account account)
    {
label0:
        {
            synchronized (mLock)
            {
                if (mAcctMan.doesAccountExist(account))
                {
                    break label0;
                }
                account = TAG;
            }
            return null;
        }
        account = getTokenCacheFromRegisteredAccount(account);
        aobj;
        JVM INSTR monitorexit ;
        return account;
        account;
        throw account;
    }

    public TokenCache getTokenCacheFromRegisteredAccount(Account account)
    {
        Object aobj[] = mLock;
        aobj;
        JVM INSTR monitorenter ;
        TokenCacheInfo tokencacheinfo1 = (TokenCacheInfo)mTokenCacheLookup.get(account);
        TokenCacheInfo tokencacheinfo;
        if (tokencacheinfo1 == null)
        {
            break MISSING_BLOCK_LABEL_34;
        }
        tokencacheinfo = tokencacheinfo1;
        if (tokencacheinfo1.isValid())
        {
            break MISSING_BLOCK_LABEL_61;
        }
        tokencacheinfo = new TokenCacheInfo(mContext, mAcctMan, account);
        mTokenCacheLookup.put(account, tokencacheinfo);
        account = tokencacheinfo.getTokenCache();
        aobj;
        JVM INSTR monitorexit ;
        return account;
        account;
        throw account;
    }

}
