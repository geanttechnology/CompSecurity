// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.sso;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.groupon.sso:
//            UserCredential

public class SSOHelper
{

    private static final String ACCOUNT_TYPE = "com.groupon.sso";
    private static final String KEY_COUNTRY_CODE = "country_code";
    private static final String KEY_ENCRYPTION_VERSION = "encryption_version";
    private static final String KEY_USERNAME = "username";
    private static final String KEY_USER_FULL_NAME = "user_full_name";
    private static String TAG = "GrouponSSOAuthenticator";
    private static String accountType = null;

    public SSOHelper()
    {
    }

    public static boolean addOrUpdateAccountForApp(Context context, UserCredential usercredential)
    {
        if (context != null && usercredential != null && usercredential.isValid())
        {
            Log.d(TAG, "> Account has valid data");
            Object obj = context.getPackageName();
            AccountManager accountmanager = AccountManager.get(context);
            usercredential.setPackageName(((String) (obj)));
            Account account = findAccountByAppId(accountmanager, getAccountType(context), ((String) (obj)));
            if (account != null)
            {
                Log.d(TAG, "> Account does exist just update the data");
                accountmanager.setUserData(account, "username", usercredential.getUsername());
                accountmanager.setUserData(account, "country_code", usercredential.getCountryCode());
                accountmanager.setUserData(account, "encryption_version", usercredential.getPasswordVersion());
                accountmanager.setUserData(account, "user_full_name", usercredential.getUserFullName());
                accountmanager.setPassword(account, usercredential.getEncryptedPassword());
                return true;
            }
            context = new Account(((String) (obj)), getAccountType(context));
            Log.d(TAG, "> Account does not exist create new account");
            obj = new Bundle();
            ((Bundle) (obj)).putString("username", usercredential.getUsername());
            ((Bundle) (obj)).putString("country_code", usercredential.getCountryCode());
            ((Bundle) (obj)).putString("encryption_version", usercredential.getPasswordVersion());
            ((Bundle) (obj)).putString("user_full_name", usercredential.getUserFullName());
            if (accountmanager.addAccountExplicitly(context, usercredential.getEncryptedPassword(), ((Bundle) (obj))))
            {
                Log.d(TAG, "> Account created successfully");
                return true;
            }
        }
        return false;
    }

    private static UserCredential createUserCredential(AccountManager accountmanager, Account account)
    {
        if (accountmanager == null || account == null)
        {
            return null;
        } else
        {
            UserCredential usercredential = new UserCredential();
            usercredential.setPackageName(account.name);
            usercredential.setEncryptedPassword(accountmanager.getPassword(account));
            usercredential.setUsername(accountmanager.getUserData(account, "username"));
            usercredential.setCountryCode(accountmanager.getUserData(account, "country_code"));
            usercredential.setUserFullName(accountmanager.getUserData(account, "user_full_name"));
            usercredential.setPasswordVersion(accountmanager.getUserData(account, "encryption_version"));
            return usercredential;
        }
    }

    public static boolean deleteAccountForApp(Context context)
    {
        return deleteAccountForApp(context, context.getPackageName());
    }

    public static boolean deleteAccountForApp(Context context, String s)
    {
        Log.d(TAG, (new StringBuilder()).append("> Delete Account for package:").append(s).toString());
        AccountManager accountmanager = AccountManager.get(context);
        context = findAccountByAppId(accountmanager, getAccountType(context), s);
        if (context != null)
        {
            Log.d(TAG, "> Account Found!");
            accountmanager.setUserData(context, "username", null);
            accountmanager.setUserData(context, "country_code", null);
            accountmanager.setUserData(context, "user_full_name", null);
            accountmanager.setUserData(context, "encryption_version", null);
            accountmanager.setPassword(context, null);
            removeAccount(accountmanager, context);
            return true;
        } else
        {
            return false;
        }
    }

    private static Account findAccountByAppId(AccountManager accountmanager, String s, String s1)
    {
        accountmanager = accountmanager.getAccountsByType(s);
        int j = accountmanager.length;
        for (int i = 0; i < j; i++)
        {
            s = accountmanager[i];
            if (s1.equals(((Account) (s)).name))
            {
                return s;
            }
        }

        return null;
    }

    private static String getAccountType(Context context)
    {
        int i;
        if (accountType != null)
        {
            return accountType;
        }
        context = context.getResources().getXml(R.xml.authenticator);
        i = context.getEventType();
_L7:
        if (i == 1) goto _L2; else goto _L1
_L1:
        String s = context.getName();
        if (s == null) goto _L4; else goto _L3
_L3:
        if (!s.equalsIgnoreCase("account-authenticator")) goto _L4; else goto _L5
_L5:
        i = 0;
_L8:
        if (i >= context.getAttributeCount()) goto _L4; else goto _L6
_L6:
        if (!context.getAttributeName(i).equalsIgnoreCase("accountType"))
        {
            break MISSING_BLOCK_LABEL_134;
        }
        context = context.getAttributeValue(i);
        if (context == null)
        {
            context = "com.groupon.sso";
        }
        accountType = context;
        return accountType;
_L4:
        i = context.next();
          goto _L7
        context;
        Log.d(TAG, "> Account Type cannot be parsed");
_L2:
        accountType = "com.groupon.sso";
        return "com.groupon.sso";
        i++;
          goto _L8
    }

    public static List getAccounts(Context context, String s)
    {
        return getAccounts(context, s, true);
    }

    private static List getAccounts(Context context, String s, boolean flag)
    {
        String s1 = context.getPackageName();
        AccountManager accountmanager = AccountManager.get(context);
        ArrayList arraylist = new ArrayList();
        context = accountmanager.getAccountsByType(getAccountType(context));
        int j = context.length;
        int i = 0;
        do
        {
            if (i >= j)
            {
                break;
            }
            UserCredential usercredential = createUserCredential(accountmanager, context[i]);
            if (usercredential != null && usercredential.isValid() && (TextUtils.isEmpty(s) || s.equalsIgnoreCase(usercredential.getCountryCode())))
            {
                if (s1.equals(usercredential.getPackageName()))
                {
                    if (flag)
                    {
                        arraylist.add(0, usercredential);
                    }
                } else
                {
                    arraylist.add(usercredential);
                }
            }
            i++;
        } while (true);
        return arraylist;
    }

    public static List getAccountsExcludeOwnAppAccount(Context context, String s)
    {
        return getAccounts(context, s, false);
    }

    public static UserCredential getAppAccount(Context context)
    {
        String s = context.getPackageName();
        AccountManager accountmanager = AccountManager.get(context);
        return createUserCredential(accountmanager, findAccountByAppId(accountmanager, getAccountType(context), s));
    }

    public static UserCredential getAppAccount(Context context, String s)
    {
        context = getAppAccount(context);
        if (context != null && !TextUtils.isEmpty(s) && s.equalsIgnoreCase(context.getCountryCode()))
        {
            return context;
        } else
        {
            return null;
        }
    }

    private static void removeAccount(AccountManager accountmanager, Account account)
    {
        accountmanager.removeAccount(account, new AccountManagerCallback() {

            public void run(AccountManagerFuture accountmanagerfuture)
            {
                try
                {
                    Log.i(SSOHelper.TAG, (new StringBuilder()).append("account remove result: ").append(accountmanagerfuture.getResult(5L, TimeUnit.SECONDS)).toString());
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (AccountManagerFuture accountmanagerfuture)
                {
                    Log.e(SSOHelper.TAG, "removeAccount", accountmanagerfuture);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (AccountManagerFuture accountmanagerfuture)
                {
                    Log.e(SSOHelper.TAG, "removeAccount", accountmanagerfuture);
                    return;
                }
                // Misplaced declaration of an exception variable
                catch (AccountManagerFuture accountmanagerfuture)
                {
                    Log.e(SSOHelper.TAG, "removeAccount", accountmanagerfuture);
                }
            }

        }, null);
    }


}
