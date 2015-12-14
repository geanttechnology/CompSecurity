// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.storage;

import android.accounts.Account;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.framework.PlatformWrapper;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.framework.Value;
import com.amazon.identity.auth.device.token.TokenCache;
import com.amazon.identity.auth.device.utils.AccountManagerWrapper;
import com.amazon.identity.auth.device.utils.BackwardsCompatiabilityHelper;
import com.amazon.identity.auth.device.utils.GenericUtils;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.PublicCloneable;
import com.amazon.identity.auth.device.utils.UnitTestUtils;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.identity.auth.device.storage:
//            DataStorage, TokenCacheHolder, AccountTransaction, LocalKeyValueStore

public class CentralAccountManagerDataStorage extends DataStorage
{
    private static class AccountInfo
        implements PublicCloneable
    {

        public final Account account;
        public final String directedId;
        private TokenCache mCache;
        private final Object mLock[];
        public final Map tokens;
        public final Map userData;

        public AccountInfo cloneObject()
        {
            return new AccountInfo(directedId, account, GenericUtils.cloneMap(userData), GenericUtils.cloneMap(tokens));
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

        public AccountInfo(String s, Account account1)
        {
            this(s, account1, ((Map) (new ConcurrentHashMap())), ((Map) (new ConcurrentHashMap())));
        }

        private AccountInfo(String s, Account account1, Map map, Map map1)
        {
            mLock = new Object[0];
            directedId = s;
            account = account1;
            userData = map;
            tokens = map1;
        }
    }


    private static final String TAG = com/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage.getName();
    private static CentralAccountManagerDataStorage sTheInstanceToRuleThemAll;
    private volatile ConcurrentHashMap mAccountInfo;
    private final Object mAccountInfoLock[] = new Object[0];
    private final AccountManagerWrapper mAcctMan;
    private final Context mContext;
    private final PlatformWrapper mPlatform;
    private final TokenCacheHolder mTokenCacheHolder;

    CentralAccountManagerDataStorage(Context context)
    {
        mContext = ServiceWrappingContext.create(context);
        mPlatform = (PlatformWrapper)mContext.getSystemService("sso_platform");
        mTokenCacheHolder = (TokenCacheHolder)mContext.getSystemService("dcp_token_cache_holder");
        mAcctMan = (AccountManagerWrapper)mContext.getSystemService("dcp_account_manager");
    }

    private AccountInfo getAccountInfoSnapshot(String s)
    {
        return getRequiredAccountInfo(s, getAccountInfosSnapshot());
    }

    private Map getAccountInfosSnapshot()
    {
        ConcurrentHashMap concurrenthashmap = mAccountInfo;
        if (isAccountInfoPopulatedAndUsable(concurrenthashmap))
        {
            return GenericUtils.cloneMap(concurrenthashmap);
        }
        Map map;
        synchronized (mAccountInfoLock)
        {
            map = GenericUtils.cloneMap(getRawAccountInfos());
        }
        return map;
    }

    public static CentralAccountManagerDataStorage getInstance(Context context)
    {
        com/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;
        JVM INSTR monitorenter ;
        if (sTheInstanceToRuleThemAll == null || UnitTestUtils.isRunningInUnitTest())
        {
            sTheInstanceToRuleThemAll = new CentralAccountManagerDataStorage(context.getApplicationContext());
        }
        context = sTheInstanceToRuleThemAll;
        com/amazon/identity/auth/device/storage/CentralAccountManagerDataStorage;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    private AccountInfo getRawAccountInfo(String s)
    {
        return getRequiredAccountInfo(s, getRawAccountInfos());
    }

    private Map getRawAccountInfos()
    {
        if (!isAccountInfoPopulatedAndUsable(mAccountInfo))
        {
            Object obj = BackwardsCompatiabilityHelper.getDirectedIdToAccountMapping(mAcctMan);
            ConcurrentHashMap concurrenthashmap = new ConcurrentHashMap();
            java.util.Map.Entry entry;
            for (obj = ((Map) (obj)).entrySet().iterator(); ((Iterator) (obj)).hasNext(); concurrenthashmap.put(entry.getKey(), new AccountInfo((String)entry.getKey(), (Account)entry.getValue())))
            {
                entry = (java.util.Map.Entry)((Iterator) (obj)).next();
            }

            mAccountInfo = concurrenthashmap;
        }
        return mAccountInfo;
    }

    private AccountInfo getRequiredAccountInfo(String s, Map map)
    {
        AccountInfo accountinfo;
        if (s == null)
        {
            MAPLog.e(TAG, "Cannot find account for null directedId");
            accountinfo = null;
        } else
        {
            AccountInfo accountinfo1 = (AccountInfo)map.get(s);
            accountinfo = accountinfo1;
            if (accountinfo1 == null)
            {
                MAPLog.accountNotRegisteredError(TAG, s, map.keySet());
                return accountinfo1;
            }
        }
        return accountinfo;
    }

    private void invalidateAccountCache()
    {
        synchronized (mAccountInfoLock)
        {
            mAccountInfo = null;
        }
    }

    private boolean isAccountInfoPopulatedAndUsable(Map map)
    {
        return map != null && mPlatform.isRunningInCentralApk();
    }

    public static boolean shouldPlatformUseThisStore(PlatformWrapper platformwrapper)
    {
        return platformwrapper.isBackedByAccountManager();
    }

    public boolean addAccount(String s, AccountTransaction accounttransaction, DataStorage.DataPropogationCallback datapropogationcallback)
    {
        String s1;
        Bundle bundle;
        Map map;
label0:
        {
            s1 = accounttransaction.getDirectedId();
            bundle = new Bundle();
            java.util.Map.Entry entry;
            for (Iterator iterator = accounttransaction.getUserData().entrySet().iterator(); iterator.hasNext(); bundle.putString((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

            map = accounttransaction.getTokens();
            synchronized (mAccountInfoLock)
            {
                if (!doesAccountExist(s1))
                {
                    break label0;
                }
            }
            return false;
        }
        boolean flag;
        s = new Account(s, "com.amazon.account");
        bundle.putString("com.amazon.dcp.sso.property.account.acctId", s1);
        flag = mAcctMan.addAccountExplicitlySync$3429b292(s, bundle);
        invalidateAccountCache();
        if (!flag || map == null)
        {
            break MISSING_BLOCK_LABEL_161;
        }
        setTokens(s1, map);
        accounttransaction;
        JVM INSTR monitorexit ;
        if (flag && datapropogationcallback != null)
        {
            datapropogationcallback.onSuccess();
            return flag;
        } else
        {
            return flag;
        }
        s;
        throw s;
    }

    public boolean doesAccountExist(String s)
    {
        if (s == null)
        {
            return false;
        } else
        {
            return getAccountInfosSnapshot().containsKey(s);
        }
    }

    public void expireToken(String s, String s1)
    {
        Object aobj[] = mAccountInfoLock;
        aobj;
        JVM INSTR monitorenter ;
        s = getRawAccountInfo(s);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_28;
        }
        MAPLog.e(TAG, "Cannot expire the requested token for the given directed ID because we couldn't construct a TokenCache");
        aobj;
        JVM INSTR monitorexit ;
        return;
        TokenCache tokencache = s.getTokenCache(mTokenCacheHolder);
        ((AccountInfo) (s)).tokens.remove(s1);
        tokencache.invalidateAuthTokenByType(s1);
        aobj;
        JVM INSTR monitorexit ;
        return;
        s;
        aobj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public Account getAccountForDirectedId(String s)
    {
        s = getAccountInfoSnapshot(s);
        if (s == null)
        {
            return null;
        } else
        {
            return ((AccountInfo) (s)).account;
        }
    }

    public Set getAccountNames()
    {
        HashSet hashset = new HashSet();
        for (Iterator iterator = getAccountInfosSnapshot().values().iterator(); iterator.hasNext(); hashset.add(((AccountInfo)iterator.next()).account.name)) { }
        return hashset;
    }

    public Set getAccounts()
    {
        return getAccountInfosSnapshot().keySet();
    }

    public String getDeviceData(String s, String s1)
    {
        if (!mPlatform.isRunningInCentralApk())
        {
            throw new UnsupportedOperationException("getDeviceData should only be called via central apk");
        } else
        {
            return (new LocalKeyValueStore(mContext, s)).getStringValue(s1);
        }
    }

    public String getDeviceSnapshot()
    {
        MAPLog.i(TAG, "getDeviceSnapshot API is only supported on 3P devices.");
        return "";
    }

    public String getToken(String s, String s1)
    {
        Object obj = getAccountInfoSnapshot(s);
        if (obj == null)
        {
            MAPLog.e(TAG, "Cannot get the requested token for the given directed ID because we couldn't construct a TokenCache");
            return null;
        }
        obj = (Value)((AccountInfo) (obj)).tokens.get(s1);
        if (obj != null)
        {
            return (String)((Value) (obj)).getValue();
        }
        Object aobj[] = mAccountInfoLock;
        aobj;
        JVM INSTR monitorenter ;
        s = getRawAccountInfo(s);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        MAPLog.e(TAG, "Cannot get the requested token for the given directed ID because we couldn't construct a TokenCache");
        aobj;
        JVM INSTR monitorexit ;
        return null;
        s;
        throw s;
        Object obj1 = (Value)((AccountInfo) (s)).tokens.get(s1);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        s = (String)((Value) (obj1)).getValue();
        aobj;
        JVM INSTR monitorexit ;
        return s;
        obj1 = s.getTokenCache(mTokenCacheHolder).getToken(s1);
        ((AccountInfo) (s)).tokens.put(s1, new Value(obj1));
        aobj;
        JVM INSTR monitorexit ;
        return ((String) (obj1));
    }

    public String getUserData(String s, String s1)
    {
        Object obj = getAccountInfoSnapshot(s);
        if (obj == null)
        {
            MAPLog.w(TAG, "Cannot get the requested user data for the given directed ID because it is not registered on the device");
            return null;
        }
        obj = (Value)((AccountInfo) (obj)).userData.get(s1);
        if (obj != null)
        {
            return (String)((Value) (obj)).getValue();
        }
        Object aobj[] = mAccountInfoLock;
        aobj;
        JVM INSTR monitorenter ;
        s = getRawAccountInfo(s);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_82;
        }
        MAPLog.w(TAG, "Cannot get the requested user data for the given directed ID because it is not registered on the device");
        aobj;
        JVM INSTR monitorexit ;
        return null;
        s;
        throw s;
        Object obj1 = (Value)((AccountInfo) (s)).userData.get(s1);
        if (obj1 == null)
        {
            break MISSING_BLOCK_LABEL_115;
        }
        s = (String)((Value) (obj1)).getValue();
        aobj;
        JVM INSTR monitorexit ;
        return s;
        obj1 = mAcctMan.unprotectedGetUserData(((AccountInfo) (s)).account, s1);
        ((AccountInfo) (s)).userData.put(s1, new Value(obj1));
        aobj;
        JVM INSTR monitorexit ;
        return ((String) (obj1));
    }

    public void initialize()
    {
    }

    public void removeAccount(String s)
    {
        Object aobj[] = mAccountInfoLock;
        aobj;
        JVM INSTR monitorenter ;
        Account account = getAccountForDirectedId(s);
        if (account != null)
        {
            break MISSING_BLOCK_LABEL_29;
        }
        MAPLog.w(TAG, "Cannot remove the requested user because it is not registered on the device");
        aobj;
        JVM INSTR monitorexit ;
        return;
        mAccountInfo.remove(s);
        s = mAcctMan.removeAccount(account, null, true);
        boolean flag = false;
        boolean flag1 = ((Boolean)s.getResult()).booleanValue();
        flag = flag1;
        invalidateAccountCache();
_L1:
        if (flag)
        {
            break MISSING_BLOCK_LABEL_88;
        }
        MAPLog.e(TAG, "Locally removing the account from the central store was not succesful");
        aobj;
        JVM INSTR monitorexit ;
        return;
        s;
        aobj;
        JVM INSTR monitorexit ;
        throw s;
        s;
        MAPLog.e(TAG, (new StringBuilder("Could not locally removed account because the operation was canceled. Error: ")).append(s.getMessage()).toString());
        invalidateAccountCache();
          goto _L1
        s;
        MAPLog.e(TAG, (new StringBuilder("Could not locally removed account because their was an Authenticator Exception. Error: ")).append(s.getMessage()).toString());
        invalidateAccountCache();
          goto _L1
        s;
        MAPLog.e(TAG, (new StringBuilder("Could not locally removed account because their was an IO Exception. Error: ")).append(s.getMessage()).toString());
        invalidateAccountCache();
          goto _L1
        s;
        invalidateAccountCache();
        throw s;
    }

    public void setData(AccountTransaction accounttransaction)
    {
        java.util.Map.Entry entry;
        for (Iterator iterator = accounttransaction.getUserData().entrySet().iterator(); iterator.hasNext(); setUserData(accounttransaction.getDirectedId(), (String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        java.util.Map.Entry entry1;
        for (Iterator iterator1 = accounttransaction.getTokens().entrySet().iterator(); iterator1.hasNext(); setToken(accounttransaction.getDirectedId(), (String)entry1.getKey(), (String)entry1.getValue()))
        {
            entry1 = (java.util.Map.Entry)iterator1.next();
        }

    }

    public void setDeviceData(String s, String s1, String s2)
    {
        if (!mPlatform.isRunningInCentralApk())
        {
            throw new UnsupportedOperationException("setDeviceData should only be called via central apk");
        } else
        {
            (new LocalKeyValueStore(mContext, s)).setValue(s1, s2);
            return;
        }
    }

    public void setToken(String s, String s1, String s2)
    {
        Object aobj[] = mAccountInfoLock;
        aobj;
        JVM INSTR monitorenter ;
        s = getRawAccountInfo(s);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        MAPLog.e(TAG, "Cannot set the requested token for the given directed ID because we couldn't construct a TokenCache");
        aobj;
        JVM INSTR monitorexit ;
        return;
        TokenCache tokencache = s.getTokenCache(mTokenCacheHolder);
        ((AccountInfo) (s)).tokens.remove(s1);
        tokencache.setAuthToken(s1, s2);
        aobj;
        JVM INSTR monitorexit ;
        return;
        s;
        aobj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void setUserData(String s, String s1, String s2)
    {
        Object aobj[] = mAccountInfoLock;
        aobj;
        JVM INSTR monitorenter ;
        s = getRawAccountInfo(s);
        if (s != null)
        {
            break MISSING_BLOCK_LABEL_32;
        }
        MAPLog.w(TAG, "Cannot set the requested user data for the given directed ID because it is not registered on the device");
        aobj;
        JVM INSTR monitorexit ;
        return;
        ((AccountInfo) (s)).userData.remove(s1);
        mAcctMan.setUserData(((AccountInfo) (s)).account, s1, s2);
        aobj;
        JVM INSTR monitorexit ;
        return;
        s;
        aobj;
        JVM INSTR monitorexit ;
        throw s;
    }

    public void setup()
    {
    }

    public void syncDirtyData()
    {
    }

}
