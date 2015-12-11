// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import com.amazon.identity.auth.device.framework.ServiceWrappingContext;
import com.amazon.identity.auth.device.storage.DataStorage;
import com.amazon.identity.auth.device.storage.TokenCacheHolder;
import com.amazon.identity.auth.device.token.TokenCache;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            AccountManagerWrapper

public final class BackwardsCompatiabilityHelper
{

    private BackwardsCompatiabilityHelper()
    {
    }

    public static Bundle addAccountManagerSuccessInformation(Context context, String s, Bundle bundle)
    {
        return addAccountManagerSuccessInformation(getUserName(context, s), s, bundle);
    }

    public static Bundle addAccountManagerSuccessInformation(String s, String s1, Bundle bundle)
    {
        bundle.putString("authAccount", s);
        bundle.putString("accountType", "com.amazon.account");
        bundle.putString("com.amazon.dcp.sso.property.account.acctId", s1);
        return bundle;
    }

    public static void expireTokenValue(Context context, String s, String s1)
    {
        s = getAccountWithDirectedId(context, s);
        if (s != null)
        {
            if ((context = ((TokenCacheHolder)ServiceWrappingContext.create(context).getSystemService("dcp_token_cache_holder")).getTokenCache(s)) != null)
            {
                context.invalidateAuthToken(s1);
                return;
            }
        }
    }

    public static ArrayList fromDirectedIdToArrayListAccounts(Context context, Collection collection)
    {
        com/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;
        JVM INSTR monitorenter ;
        if (collection != null) goto _L2; else goto _L1
_L1:
        context = null;
_L4:
        com/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;
        JVM INSTR monitorexit ;
        return context;
_L2:
        ArrayList arraylist;
        Map map;
        map = getDirectedIdToAccountLookup(getAccountManagerWrapper(context));
        arraylist = new ArrayList();
        collection = collection.iterator();
_L6:
        context = arraylist;
        if (!collection.hasNext()) goto _L4; else goto _L3
_L3:
        context = (Account)map.get((String)collection.next());
        if (context == null) goto _L6; else goto _L5
_L5:
        arraylist.add(context);
          goto _L6
        context;
        throw context;
    }

    private static AccountManagerWrapper getAccountManagerWrapper(Context context)
    {
        return (AccountManagerWrapper)ServiceWrappingContext.create(context).getSystemService("dcp_account_manager");
    }

    public static Account getAccountWithDirectedId(Context context, String s)
    {
        com/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;
        JVM INSTR monitorenter ;
        context = getAccountWithDirectedId(getAccountManagerWrapper(context), s);
        com/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static Account getAccountWithDirectedId(AccountManagerWrapper accountmanagerwrapper, String s)
    {
        com/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;
        JVM INSTR monitorenter ;
        if (s != null) goto _L2; else goto _L1
_L1:
        accountmanagerwrapper = null;
_L4:
        com/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;
        JVM INSTR monitorexit ;
        return accountmanagerwrapper;
_L2:
        accountmanagerwrapper = (Account)getDirectedIdToAccountLookup(accountmanagerwrapper).get(s);
        if (true) goto _L4; else goto _L3
_L3:
        accountmanagerwrapper;
        throw accountmanagerwrapper;
    }

    public static String getDirectedId(Context context, Account account)
    {
        com/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;
        JVM INSTR monitorenter ;
        context = getDirectedId(getAccountManagerWrapper(context), account);
        com/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static String getDirectedId(Context context, String s, String s1)
    {
        com/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;
        JVM INSTR monitorenter ;
        if (s != null && s1 != null) goto _L2; else goto _L1
_L1:
        context = null;
_L4:
        com/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;
        JVM INSTR monitorexit ;
        return context;
_L2:
        s = new Account(s1, s);
        context = getDirectedId(getAccountManagerWrapper(context), ((Account) (s)));
        if (true) goto _L4; else goto _L3
_L3:
        context;
        throw context;
    }

    public static String getDirectedId(AccountManagerWrapper accountmanagerwrapper, Account account)
    {
        if (account == null || !accountmanagerwrapper.doesAccountExist(account))
        {
            return null;
        } else
        {
            return getDirectedIdFromExistingAcconunt(accountmanagerwrapper, account);
        }
    }

    private static String getDirectedIdFromExistingAcconunt(AccountManagerWrapper accountmanagerwrapper, Account account)
    {
        String s1 = accountmanagerwrapper.unprotectedGetUserData(account, "com.amazon.dcp.sso.property.account.acctId");
        String s = s1;
        if (s1 == null)
        {
            s = UUID.randomUUID().toString();
            accountmanagerwrapper.setUserData(account, "com.amazon.dcp.sso.property.account.acctId", s);
        }
        return s;
    }

    private static Map getDirectedIdToAccountLookup(AccountManagerWrapper accountmanagerwrapper)
    {
        HashMap hashmap = new HashMap();
        Account aaccount[] = accountmanagerwrapper.getAccountsByType("com.amazon.account");
        int j = aaccount.length;
        for (int i = 0; i < j; i++)
        {
            Account account = aaccount[i];
            hashmap.put(getDirectedId(accountmanagerwrapper, account), account);
        }

        return hashmap;
    }

    public static Map getDirectedIdToAccountMapping(AccountManagerWrapper accountmanagerwrapper)
    {
        Account aaccount[] = accountmanagerwrapper.getAccountsByType("com.amazon.account");
        HashMap hashmap = new HashMap();
        int j = aaccount.length;
        for (int i = 0; i < j; i++)
        {
            Account account = aaccount[i];
            hashmap.put(getDirectedIdFromExistingAcconunt(accountmanagerwrapper, account), account);
        }

        return hashmap;
    }

    public static Set getDirectedIdsFromAndroidAccounts(Context context, Collection collection)
    {
        com/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;
        JVM INSTR monitorenter ;
        HashSet hashset;
        context = getAccountManagerWrapper(context);
        hashset = new HashSet();
        collection = collection.iterator();
_L2:
        String s;
        do
        {
            if (!collection.hasNext())
            {
                break MISSING_BLOCK_LABEL_67;
            }
            s = getDirectedId(context, (Account)collection.next());
        } while (s == null);
        hashset.add(s);
        if (true) goto _L2; else goto _L1
_L1:
        context;
        throw context;
        com/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;
        JVM INSTR monitorexit ;
        return hashset;
    }

    public static Set getDirectedIdsFromAndroidAccounts(Context context, Account aaccount[])
    {
        com/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;
        JVM INSTR monitorenter ;
        context = getDirectedIdsFromAndroidAccounts(context, ((Collection) (Arrays.asList(aaccount))));
        com/amazon/identity/auth/device/utils/BackwardsCompatiabilityHelper;
        JVM INSTR monitorexit ;
        return context;
        context;
        throw context;
    }

    public static String getUniqueAccountName(DataStorage datastorage, String s)
    {
        Set set = datastorage.getAccountNames();
        datastorage = s;
        int i = 1;
        for (; set.contains(datastorage); datastorage = String.format(datastorage, "%s %d", new Object[] {
    s, Integer.valueOf(i)
}))
        {
            datastorage = Locale.US;
            i++;
        }

        return datastorage;
    }

    public static String getUserName(Context context, String s)
    {
        context = getAccountWithDirectedId(context, s);
        if (context == null)
        {
            return null;
        } else
        {
            return ((Account) (context)).name;
        }
    }

    public static boolean isADcpOnlyToken(String s)
    {
        return "com.amazon.dcp.sso.token.device.adptoken".equals(s) || "com.amazon.dcp.sso.token.device.privatekey".equals(s) || "com.amazon.dcp.sso.token.device.credentialsmap".equals(s);
    }

    public static boolean isEncryptedTokenInUserData(String s)
    {
        while (isADcpOnlyToken(s) || !"com.amazon.dcp.sso.token.cookie.xmain".equals(s) && !"com.amazon.dcp.sso.token.cookie.xmainAndXabcCookies".equals(s) && !s.startsWith("com.amazon.dcp.sso.token.device") && !s.startsWith("com.amazon.dcp.sso.property.account.extratokens") && !"com.amazon.identity.cookies.xfsn".equals(s)) 
        {
            return false;
        }
        return true;
    }
}
