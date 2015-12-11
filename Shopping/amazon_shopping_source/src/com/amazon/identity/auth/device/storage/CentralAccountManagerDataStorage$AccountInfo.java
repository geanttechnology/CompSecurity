// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.accounts.Account;
import com.amazon.identity.auth.device.token.TokenCache;
import com.amazon.identity.auth.device.utils.GenericUtils;
import com.amazon.identity.auth.device.utils.PublicCloneable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            CentralAccountManagerDataStorage, TokenCacheHolder

private static class tokens
    implements PublicCloneable
{

    public final Account account;
    public final String directedId;
    private TokenCache mCache;
    private final Object mLock[];
    public final Map tokens;
    public final Map userData;

    public tokens cloneObject()
    {
        return new <init>(directedId, account, GenericUtils.cloneMap(userData), GenericUtils.cloneMap(tokens));
    }

    public volatile PublicCloneable cloneObject()
    {
        return cloneObject();
    }

    public TokenCache getTokenCache(TokenCacheHolder tokencacheholder)
    {
        synchronized (mLock)
        {
            if (mCache == null)
            {
                mCache = tokencacheholder.getTokenCacheFromRegisteredAccount(account);
            }
            tokencacheholder = mCache;
        }
        return tokencacheholder;
    }

    public (String s, Account account1)
    {
        this(s, account1, ((Map) (new ConcurrentHashMap())), ((Map) (new ConcurrentHashMap())));
    }

    private <init>(String s, Account account1, Map map, Map map1)
    {
        mLock = new Object[0];
        directedId = s;
        account = account1;
        userData = map;
        tokens = map1;
    }
}
