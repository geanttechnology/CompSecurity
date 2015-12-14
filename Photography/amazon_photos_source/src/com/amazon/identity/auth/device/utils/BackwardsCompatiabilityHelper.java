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
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            AccountManagerWrapper

public final class BackwardsCompatiabilityHelper
{

    public static Bundle addAccountManagerSuccessInformation(Context context, String s, Bundle bundle)
    {
        context = getAccountWithDirectedId(context, s);
        if (context == null)
        {
            context = null;
        } else
        {
            context = ((Account) (context)).name;
        }
        return addAccountManagerSuccessInformation(((String) (context)), s, bundle);
    }

    public static Bundle addAccountManagerSuccessInformation(String s, String s1, Bundle bundle)
    {
        if (s != null)
        {
            bundle.putString("authAccount", s);
        }
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

    private static AccountManagerWrapper getAccountManagerWrapper(Context context)
    {
        return (AccountManagerWrapper)ServiceWrappingContext.create(context).getSystemService("dcp_account_manager");
    }

    public static Account getAccountWithDirectedId(Context context, String s)
    {
        return ServiceWrappingContext.create(context).getDataStorage().getAccountForDirectedId(s);
    }

    public static String getDirectedId(Context context, Account account)
    {
        return getDirectedId(getAccountManagerWrapper(context), account);
    }

    public static String getDirectedId(Context context, String s, String s1)
    {
        if (s == null || s1 == null)
        {
            return null;
        } else
        {
            s = new Account(s1, s);
            return getDirectedId(getAccountManagerWrapper(context), ((Account) (s)));
        }
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
