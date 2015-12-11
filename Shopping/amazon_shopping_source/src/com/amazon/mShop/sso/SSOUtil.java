// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.amazon.identity.auth.device.api.CustomerAttributeStore;
import com.amazon.identity.auth.device.api.MAPAccountManager;
import com.amazon.identity.auth.device.api.MAPCallbackErrorException;
import com.amazon.identity.auth.device.api.MAPFuture;
import com.amazon.identity.auth.device.api.MultipleAccountManager;
import com.amazon.mShop.debug.DebugSettings;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.net.CookieBridge;
import com.amazon.mShop.platform.AndroidPlatform;
import com.amazon.mShop.platform.AppLocale;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.search.SearchActivity;
import com.amazon.mShop.util.ActivityUtils;
import com.amazon.mShop.util.ConfigUtils;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import java.util.concurrent.ExecutionException;

// Referenced classes of package com.amazon.mShop.sso:
//            IdentityType, MAPCookiesFetcher, MShopCheckLogin, AccountCookiesSyncManager

public class SSOUtil
{
    public static abstract class AuthPool extends Enum
    {

        private static final AuthPool $VALUES[];
        public static final AuthPool Amazon;
        public static final AuthPool AmazonCN;
        public static final AuthPool AmazonJP;

        public static List getAllLocalesList()
        {
            ArrayList arraylist = new ArrayList();
            arraylist.addAll(Amazon.getLocaleList());
            arraylist.addAll(AmazonCN.getLocaleList());
            arraylist.addAll(AmazonJP.getLocaleList());
            return arraylist;
        }

        public static AuthPool valueOf(String s)
        {
            return (AuthPool)Enum.valueOf(com/amazon/mShop/sso/SSOUtil$AuthPool, s);
        }

        public static AuthPool[] values()
        {
            return (AuthPool[])$VALUES.clone();
        }

        public abstract List getLocaleList();

        static 
        {
            Amazon = new AuthPool("Amazon", 0) {

                public List getLocaleList()
                {
                    ArrayList arraylist = new ArrayList();
                    arraylist.add("de_DE");
                    arraylist.add("en_GB");
                    arraylist.add("en_US");
                    arraylist.add("en_IN");
                    arraylist.add("fr_FR");
                    arraylist.add("it_IT");
                    arraylist.add("es_ES");
                    arraylist.add("en_CA");
                    arraylist.add("fr_CA");
                    return arraylist;
                }

            };
            AmazonCN = new AuthPool("AmazonCN", 1) {

                public List getLocaleList()
                {
                    ArrayList arraylist = new ArrayList();
                    arraylist.add("zh_CN");
                    return arraylist;
                }

            };
            AmazonJP = new AuthPool("AmazonJP", 2) {

                public List getLocaleList()
                {
                    ArrayList arraylist = new ArrayList();
                    arraylist.add("ja_JP");
                    return arraylist;
                }

            };
            $VALUES = (new AuthPool[] {
                Amazon, AmazonCN, AmazonJP
            });
        }

        private AuthPool(String s, int i)
        {
            super(s, i);
        }

    }

    public static interface FetchUserFullNameListener
    {

        public abstract void afterFullnameFetched(String s);

        public abstract void beforeFetchingFullname();
    }

    public static class FetchUserFullNameTask extends AsyncTask
    {

        private FetchUserFullNameListener mListener;

        protected volatile Object doInBackground(Object aobj[])
        {
            return doInBackground((Void[])aobj);
        }

        protected transient String doInBackground(Void avoid[])
        {
            avoid = SSOUtil.getCurrentAccount((Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext());
            if (TextUtils.isEmpty(avoid))
            {
                return "";
            } else
            {
                return SSOUtil.getFullNameFromCustomerAttribute(avoid);
            }
        }

        protected volatile void onPostExecute(Object obj)
        {
            onPostExecute((String)obj);
        }

        protected void onPostExecute(String s)
        {
            mListener.afterFullnameFetched(s);
        }

        protected void onPreExecute()
        {
            mListener.beforeFetchingFullname();
        }

        public FetchUserFullNameTask(FetchUserFullNameListener fetchuserfullnamelistener)
        {
            mListener = fetchuserfullnamelistener;
        }
    }


    public static final boolean DEBUG = DebugSettings.isDebugEnabled();
    private static volatile boolean sLoginTriggeredFromApplication = false;
    private static volatile boolean sLogoutTriggeredFromApplication = false;
    private static String sTempAccountForCurrentLocale = null;

    public SSOUtil()
    {
    }

    public static void addAccountCustomKeyMapping(String s)
    {
        if (Util.isEmpty(s))
        {
            return;
        }
        String s1 = getCustomKeyForAccountMapping();
        MultipleAccountManager multipleaccountmanager = getMultipleAccountManager();
        if (!multipleaccountmanager.doesAccountHaveMapping(s, new com.amazon.identity.auth.device.api.MultipleAccountManager.PackageMappingType(AndroidPlatform.getInstance().getApplicationContext().getPackageName())))
        {
            multipleaccountmanager.setAccountMappings(s, new com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType[] {
                new com.amazon.identity.auth.device.api.MultipleAccountManager.PackageMappingType(AndroidPlatform.getInstance().getApplicationContext().getPackageName())
            });
        }
        if (!multipleaccountmanager.doesAccountHaveMapping(s, new com.amazon.identity.auth.device.api.MultipleAccountManager.CustomKeyMappingType(s1)))
        {
            if (DEBUG)
            {
                Log.i("Amazon.SSOUtil", (new StringBuilder()).append("addCustomKeyMapping ").append(s1).append(" for ").append(s).toString());
            }
            multipleaccountmanager.setAccountMappings(s, new com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType[] {
                new com.amazon.identity.auth.device.api.MultipleAccountManager.CustomKeyMappingType(s1)
            });
        }
        setTempAccountForCurrentLocale(null);
    }

    public static void clearCookieAndCookieJarForAllLocales(Context context)
    {
        String s;
        for (Iterator iterator = getAllLocalesList().iterator(); iterator.hasNext(); com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().remove("cookieJar.mShop", s))
        {
            s = (String)iterator.next();
            com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().remove("secureCookieJar.mShop", s);
        }

        CookieBridge.clearCookiesOfAllLocales(context);
    }

    public static void clearCookieAndCookieJarForWorldwideAuthPool(Context context)
    {
        String s;
        for (Iterator iterator = getWorldWideAuthPoolLocalesList().iterator(); iterator.hasNext(); com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().remove("cookieJar.mShop", s))
        {
            s = (String)iterator.next();
            com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().remove("secureCookieJar.mShop", s);
        }

        CookieBridge.clearCookiesOfAllLocales(context);
    }

    public static void clearCurrentLocaleCookieAndCookieJar(Context context)
    {
        AndroidPlatform.getInstance().getDataStore().remove("secureCookieJar.mShop");
        AndroidPlatform.getInstance().getDataStore().remove("cookieJar.mShop");
        CookieBridge.clearCurrentLocaleCookies(context);
    }

    public static void clearLastSkipSiginTimeForAllAuthPools(Context context)
    {
        context = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        AuthPool aauthpool[] = AuthPool.values();
        int j = aauthpool.length;
        for (int i = 0; i < j; i++)
        {
            AuthPool authpool = aauthpool[i];
            context.remove("LAST_SKIP_SIGN_IN_TIME_IN_MS", (new StringBuilder()).append("MSHOP-ACCOUNT-").append(authpool.name()).toString());
        }

    }

    public static void clearMShopUserDataInWorldwideAuthPool(Context context)
    {
        clearCookieAndCookieJarForWorldwideAuthPool(context);
        clearUserFullNameForWorldWideAuthPool();
        removePreviousAccountInWorldwideAuthPool();
        clearLastSkipSiginTimeForAllAuthPools(context);
        SearchActivity.clearPreviousSearchTermForLocales(getWorldWideAuthPoolLocalesList());
    }

    public static void clearMapSSOUserDataInAllLocales(Context context)
    {
        clearCookieAndCookieJarForAllLocales(context);
        removePreviousAccountInAllLocales();
        clearUserFullNameForAllLocales();
        clearLastSkipSiginTimeForAllAuthPools(context);
        SearchActivity.clearPreviousSearchTermForLocales(getAllLocalesList());
    }

    public static void clearUserFullNameForAllLocales()
    {
        DataStore datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        for (Iterator iterator = AuthPool.getAllLocalesList().iterator(); iterator.hasNext(); datastore.remove("userFullName", (String)iterator.next())) { }
    }

    public static void clearUserFullNameForWorldWideAuthPool()
    {
        DataStore datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        for (Iterator iterator = AuthPool.Amazon.getLocaleList().iterator(); iterator.hasNext(); datastore.remove("userFullName", (String)iterator.next())) { }
    }

    public static void clearUserInfoOfCurrentLocale()
    {
        Context context = (Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext();
        User.saveUser(null);
        removePreviouslySeenAmazonAccount();
        clearCurrentLocaleCookieAndCookieJar(context);
    }

    public static Set getAllAccounts()
    {
        return getMAPAccountManager(AndroidPlatform.getInstance().getApplicationContext()).getAccounts();
    }

    public static List getAllLocalesList()
    {
        return AuthPool.getAllLocalesList();
    }

    public static String getAuthPoolForCurrentLocale()
    {
        return ConfigUtils.getString((Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext(), com.amazon.mShop.android.lib.R.string.config_auth_pool);
    }

    public static String getAuthPoolFromAccount(String s)
    {
        return getCustomerAttribute(s, "com.amazon.dcp.sso.token.device.accountpool");
    }

    public static String getCurrentAccount(Context context)
    {
        String s = "";
        if (IdentityType.CENTRAL_SSO_TYPE != getCurrentIdentityType()) goto _L2; else goto _L1
_L1:
        String s1 = getPrimaryAccount(context);
        context = s;
        if (!Util.isEmpty(s1))
        {
            context = s1;
        }
_L4:
        return context;
_L2:
        context = s;
        if (IdentityType.DISTRIBUTED_SSO_TYPE == getCurrentIdentityType())
        {
            String s2 = getTempAccountForCurrentLocale();
            context = s2;
            if (Util.isEmpty(s2))
            {
                context = getCustomKeyForAccountMapping();
                String s3 = getMultipleAccountManager().getAccountForMapping(new com.amazon.identity.auth.device.api.MultipleAccountManager.AccountMappingType[] {
                    new com.amazon.identity.auth.device.api.MultipleAccountManager.CustomKeyMappingType(context)
                });
                context = s;
                if (!Util.isEmpty(s3))
                {
                    context = s3;
                }
            }
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    public static IdentityType getCurrentIdentityType()
    {
        String s = AppLocale.getInstance().getCurrentLocale().toString();
        if (!hasAmazonAuthenticator((Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext()))
        {
            return IdentityType.DISTRIBUTED_SSO_TYPE;
        }
        if (!s.equalsIgnoreCase("zh_CN") && !s.equalsIgnoreCase("ja_JP"))
        {
            return IdentityType.CENTRAL_SSO_TYPE;
        } else
        {
            return IdentityType.NON_SSO_TYPE;
        }
    }

    private static String getCustomKeyForAccountMapping()
    {
        String s = getAuthPoolForCurrentLocale();
        return (new StringBuilder()).append("MSHOP-ACCOUNT-").append(s).toString();
    }

    private static String getCustomerAttribute(String s, String s1)
    {
        Context context = AndroidPlatform.getInstance().getApplicationContext();
        String s2 = null;
        if (!Util.isEmpty(s))
        {
            s = CustomerAttributeStore.getInstance(context).getAttribute(s, s1, null);
            try
            {
                s2 = CustomerAttributeStore.getValueOrAttributeDefault((Bundle)s.get());
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return null;
            }
            // Misplaced declaration of an exception variable
            catch (String s)
            {
                s.printStackTrace();
                return null;
            }
        }
        return s2;
    }

    public static String getFullNameFromCustomerAttribute(String s)
    {
        return getCustomerAttribute(s, "com.amazon.dcp.sso.property.username");
    }

    public static MAPAccountManager getMAPAccountManager(Context context)
    {
        return new MAPAccountManager(context);
    }

    private static MultipleAccountManager getMultipleAccountManager()
    {
        return new MultipleAccountManager(AndroidPlatform.getInstance().getApplicationContext());
    }

    public static String getPreviouslySeenAmazonAccount()
    {
        com/amazon/mShop/sso/SSOUtil;
        JVM INSTR monitorenter ;
        String s = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getString("previousAmazonAccount");
        com/amazon/mShop/sso/SSOUtil;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public static String getPrimaryAccount(Context context)
    {
        return getMAPAccountManager(context).getPrimaryAccount();
    }

    public static String getTempAccountForCurrentLocale()
    {
        com/amazon/mShop/sso/SSOUtil;
        JVM INSTR monitorenter ;
        String s = sTempAccountForCurrentLocale;
        com/amazon/mShop/sso/SSOUtil;
        JVM INSTR monitorexit ;
        return s;
        Exception exception;
        exception;
        throw exception;
    }

    public static List getWorldWideAuthPoolLocalesList()
    {
        return AuthPool.Amazon.getLocaleList();
    }

    public static void handleSSOAccount(Context context, String s)
    {
        addAccountCustomKeyMapping(s);
        setPreviouslySeenAmazonAccount(context, s);
        boolean flag1 = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getBoolean("hasFetchedNonauthCookies");
        boolean flag;
        if (!Util.isEmpty(CookieBridge.getCurrentSessionId()))
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag && !flag1)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (flag)
        {
            if ((new MAPCookiesFetcher(s, context)).peekXCookie())
            {
                User.saveUser(new User("", getFullNameFromCustomerAttribute(s), false, false, null, Boolean.valueOf(false), null));
                (new MShopCheckLogin(context, true, null)).checkLogin();
                return;
            } else
            {
                AccountCookiesSyncManager.syncAndWait(context, false, true, s, true);
                return;
            }
        } else
        {
            AccountCookiesSyncManager.syncAndWait(context, false, true, s, false);
            return;
        }
    }

    public static boolean handleSigninPrompt(Context context)
    {
        ActivityUtils.postSignInPromptFeatureTrigger();
        if (needSigninPrompt())
        {
            ActivityUtils.startSigninPromptActivity(context);
            return true;
        } else
        {
            return false;
        }
    }

    public static boolean hasAmazonAccount()
    {
        return !Util.isEmpty(getCurrentAccount((Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext()));
    }

    public static boolean hasAmazonAuthenticator(Context context)
    {
        AuthenticatorDescription aauthenticatordescription[];
        AuthenticatorDescription authenticatordescription;
        int i;
        int j;
        try
        {
            aauthenticatordescription = AccountManager.get(context).getAuthenticatorTypes();
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        if (aauthenticatordescription == null || aauthenticatordescription.length <= 0) goto _L2; else goto _L1
_L1:
        j = aauthenticatordescription.length;
        i = 0;
_L9:
        if (i >= j) goto _L2; else goto _L3
_L3:
        authenticatordescription = aauthenticatordescription[i];
        if (!"com.amazon.account".equals(authenticatordescription.type)) goto _L5; else goto _L4
_L4:
        if (context.getPackageManager().checkSignatures(authenticatordescription.packageName, context.getPackageName()) == 0) goto _L7; else goto _L6
_L6:
        Log.e("Amazon.SSOUtil", "Account Manager account type match but central package signature check failed");
_L2:
        return false;
_L7:
        return true;
_L5:
        i++;
        if (true) goto _L9; else goto _L8
_L8:
    }

    public static void ignoreOptOutSSOIfneeded()
    {
        String s = getAuthPoolForCurrentLocale();
        DataStore datastore = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore();
        if (!datastore.getBoolean("ignoreOptOutFirstLaunch", s))
        {
            datastore.putBoolean("ignoreOptOutFirstLaunch", true, s);
        }
    }

    public static boolean isAppstoreInstalledWithSpecificVersion(Context context)
    {
        boolean flag1 = false;
        int i;
        boolean flag;
        try
        {
            context = context.getPackageManager().getPackageInfo("com.amazon.venezia", 0);
        }
        // Misplaced declaration of an exception variable
        catch (Context context)
        {
            return false;
        }
        flag = flag1;
        if (context == null)
        {
            break MISSING_BLOCK_LABEL_36;
        }
        i = ((PackageInfo) (context)).versionCode;
        flag = flag1;
        if (i >= 0x25f7d940)
        {
            flag = true;
        }
        return flag;
    }

    public static boolean isLoginTriggeredFromApplication()
    {
        com/amazon/mShop/sso/SSOUtil;
        JVM INSTR monitorenter ;
        boolean flag = sLoginTriggeredFromApplication;
        com/amazon/mShop/sso/SSOUtil;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean isLogoutTriggeredFromApplication()
    {
        com/amazon/mShop/sso/SSOUtil;
        JVM INSTR monitorenter ;
        boolean flag = sLogoutTriggeredFromApplication;
        com/amazon/mShop/sso/SSOUtil;
        JVM INSTR monitorexit ;
        return flag;
        Exception exception;
        exception;
        throw exception;
    }

    public static boolean isSSOSupported(Context context)
    {
        return IdentityType.NON_SSO_TYPE != getCurrentIdentityType();
    }

    private static boolean isSkipSigninOverdue(Context context)
    {
        long l = com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().getLong("LAST_SKIP_SIGN_IN_TIME_IN_MS", getCustomKeyForAccountMapping());
        return System.currentTimeMillis() - l > 0x9a7ec800L;
    }

    public static boolean needSigninPrompt()
    {
        Context context = (Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext();
        return Util.isEmpty(getCurrentAccount(context)) && ActivityUtils.isSignInPrompt() && isSkipSigninOverdue(context);
    }

    public static String peekAuthPoolFromAccount(String s)
    {
        return peekCustomerAttributeForAccount(AndroidPlatform.getInstance().getApplicationContext(), s, "com.amazon.dcp.sso.token.device.accountpool");
    }

    public static String peekCustomerAttribute(Context context, String s)
    {
        context = getCurrentAccount(context);
        return peekCustomerAttributeForAccount((Context)com.amazon.mShop.platform.Platform.Factory.getInstance().getApplicationContext(), context, s);
    }

    public static String peekCustomerAttributeForAccount(Context context, String s, String s1)
    {
        String s2 = null;
        if (!Util.isEmpty(s))
        {
            s2 = CustomerAttributeStore.getValueOrAttributeDefault(CustomerAttributeStore.getInstance(context).peekAttribute(s, s1));
        }
        return s2;
    }

    public static void removePreviousAccountInAllLocales()
    {
        DataStore datastore = AndroidPlatform.getInstance().getDataStore();
        for (Iterator iterator = AuthPool.getAllLocalesList().iterator(); iterator.hasNext(); datastore.remove("previousAmazonAccount", (String)iterator.next())) { }
    }

    public static void removePreviousAccountInWorldwideAuthPool()
    {
        DataStore datastore = AndroidPlatform.getInstance().getDataStore();
        for (Iterator iterator = AuthPool.Amazon.getLocaleList().iterator(); iterator.hasNext(); datastore.remove("previousAmazonAccount", (String)iterator.next())) { }
    }

    public static void removePreviouslySeenAmazonAccount()
    {
        com/amazon/mShop/sso/SSOUtil;
        JVM INSTR monitorenter ;
        com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().remove("previousAmazonAccount");
        com/amazon/mShop/sso/SSOUtil;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static String selectMatchedAccount()
    {
        String s1 = "";
        Object obj = AndroidPlatform.getInstance().getApplicationContext();
        String s = getCurrentAccount(((Context) (obj)));
        if (Util.isEmpty(s))
        {
            String s2 = getAuthPoolForCurrentLocale();
            obj = getPrimaryAccount(((Context) (obj)));
            String s3 = peekAuthPoolFromAccount(((String) (obj)));
            s = s1;
            if (!Util.isEmpty(s3))
            {
                s = s1;
                if (!Util.isEmpty(s2))
                {
                    s = s1;
                    if (s3.equals(s2))
                    {
                        s = ((String) (obj));
                    }
                }
            }
        }
        if (!Util.isEmpty(s) && IdentityType.DISTRIBUTED_SSO_TYPE == getCurrentIdentityType())
        {
            addAccountCustomKeyMapping(s);
        }
        return s;
    }

    public static void setLoginTriggeredFromApplication(boolean flag)
    {
        com/amazon/mShop/sso/SSOUtil;
        JVM INSTR monitorenter ;
        sLoginTriggeredFromApplication = flag;
        com/amazon/mShop/sso/SSOUtil;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static void setLogoutTriggeredFromApplication(boolean flag)
    {
        com/amazon/mShop/sso/SSOUtil;
        JVM INSTR monitorenter ;
        sLogoutTriggeredFromApplication = flag;
        com/amazon/mShop/sso/SSOUtil;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public static void setPreviouslySeenAmazonAccount(Context context, String s)
    {
        com/amazon/mShop/sso/SSOUtil;
        JVM INSTR monitorenter ;
        com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putString("previousAmazonAccount", s);
        com/amazon/mShop/sso/SSOUtil;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    public static void setTempAccountForCurrentLocale(String s)
    {
        com/amazon/mShop/sso/SSOUtil;
        JVM INSTR monitorenter ;
        sTempAccountForCurrentLocale = s;
        com/amazon/mShop/sso/SSOUtil;
        JVM INSTR monitorexit ;
        return;
        s;
        throw s;
    }

    public static void skipSigin(Context context)
    {
        com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putLong("LAST_SKIP_SIGN_IN_TIME_IN_MS", System.currentTimeMillis(), getCustomKeyForAccountMapping());
    }

}
