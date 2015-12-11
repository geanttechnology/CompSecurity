// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.sso;

import android.content.Context;
import android.util.Log;
import com.amazon.mShop.model.auth.User;
import com.amazon.mShop.platform.Platform;
import com.amazon.mShop.util.Util;
import com.amazon.rio.j2me.client.persistence.DataStore;
import java.text.DateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

// Referenced classes of package com.amazon.mShop.sso:
//            SSOUtil, MAPCookiesFetcher, MShopCheckLogin

public class AccountCookiesSyncManager
{
    private static class BackgroundAccountSyncRunnable
        implements Runnable
    {

        final String mAccount;
        final Context mApplicationContext;
        final boolean mCheckLoginAfterCookieRetrieved;
        final boolean mForceSync;
        final boolean mXCookieOnly;

        public void run()
        {
            if (AccountCookiesSyncManager.isAccountSyncInProgress())
            {
                if (SSOUtil.DEBUG)
                {
                    Log.v("Amazon.SSOUtil", "Amazon Account synchronization already in progress");
                }
                return;
            } else
            {
                AccountCookiesSyncManager.doSync(mApplicationContext, mForceSync, mCheckLoginAfterCookieRetrieved, mAccount, mXCookieOnly);
                return;
            }
        }

        BackgroundAccountSyncRunnable(Context context, boolean flag, boolean flag1, String s, boolean flag2)
        {
            mApplicationContext = context;
            mForceSync = flag;
            mCheckLoginAfterCookieRetrieved = flag1;
            mAccount = s;
            mXCookieOnly = flag2;
        }
    }

    static class UserSubscriberCallback
    {

        private final String mAccount;
        private final Context mApplicationContext;
        private final boolean mCheckLoginAfterCookieRetrieved;

        public void identityCookiesSuccessfullyFetched()
        {
            if (SSOUtil.DEBUG)
            {
                Log.v("Amazon.SSOUtil", "AccountCookiesSyncManager.UserSubscriberCallback.identityCookiesSuccessfullyFetched()");
            }
            AccountCookiesSyncManager.onCookieFetchCompleted(mApplicationContext, mAccount);
            if (mCheckLoginAfterCookieRetrieved && !Util.isEmpty(mAccount))
            {
                User.saveUser(new User("", SSOUtil.getFullNameFromCustomerAttribute(mAccount), false, false, null, Boolean.valueOf(false), null));
            }
            AccountCookiesSyncManager.onSynchronizationComplete();
            if (Util.isEmpty(mAccount))
            {
                com.amazon.mShop.platform.Platform.Factory.getInstance().getDataStore().putBoolean("hasFetchedNonauthCookies", true);
            } else
            if (mCheckLoginAfterCookieRetrieved)
            {
                (new MShopCheckLogin(mApplicationContext, true, null)).checkLogin();
                return;
            }
        }

        public void onFailed(String s)
        {
            if (SSOUtil.DEBUG)
            {
                Log.w("Amazon.SSOUtil", (new StringBuilder()).append("MAPCookieFetcher failed ").append(s).toString());
            }
            AccountCookiesSyncManager.onSynchronizationComplete();
        }

        UserSubscriberCallback(Context context, String s, boolean flag)
        {
            mApplicationContext = context;
            mCheckLoginAfterCookieRetrieved = flag;
            mAccount = s;
        }
    }


    private static volatile boolean sAccountSyncInProgress = false;
    private static final Object sAccountSyncMonitor = new Object();
    private static final Executor sExecutor = Executors.newSingleThreadExecutor();

    public AccountCookiesSyncManager()
    {
    }

    public static void checkAndWait()
    {
        if (!sAccountSyncInProgress)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        Object obj = sAccountSyncMonitor;
        obj;
        JVM INSTR monitorenter ;
        sAccountSyncMonitor.wait();
_L2:
        return;
        Object obj1;
        obj1;
        if (!SSOUtil.DEBUG) goto _L2; else goto _L1
_L1:
        Log.e("Amazon.SSOUtil", ((InterruptedException) (obj1)).toString());
          goto _L2
        obj1;
        obj;
        JVM INSTR monitorexit ;
        throw obj1;
    }

    private static void doSync(Context context, boolean flag, boolean flag1, String s, boolean flag2)
    {
        (new MAPCookiesFetcher(new UserSubscriberCallback(context, s, flag1), context, flag, s, flag2)).getCookies();
    }

    public static void fetchNonAuthCookies(Context context)
    {
        syncAndWait(context, false, false, null);
    }

    private static boolean isAccountSyncInProgress()
    {
label0:
        {
            synchronized (sAccountSyncMonitor)
            {
                if (!sAccountSyncInProgress)
                {
                    break label0;
                }
            }
            return true;
        }
        sAccountSyncInProgress = true;
        obj;
        JVM INSTR monitorexit ;
        return false;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static void onCookieFetchCompleted(Context context, String s)
    {
        com/amazon/mShop/sso/AccountCookiesSyncManager;
        JVM INSTR monitorenter ;
        if (Util.isEmpty(s))
        {
            s = "";
        }
        SSOUtil.setPreviouslySeenAmazonAccount(context, s);
        com/amazon/mShop/sso/AccountCookiesSyncManager;
        JVM INSTR monitorexit ;
        return;
        context;
        throw context;
    }

    private static void onSynchronizationComplete()
    {
        synchronized (sAccountSyncMonitor)
        {
            sAccountSyncInProgress = false;
            sAccountSyncMonitor.notifyAll();
        }
        if (SSOUtil.DEBUG)
        {
            Log.i("Amazon.SSOUtil", (new StringBuilder()).append("onSynchronizationComplete() END ").append(DateFormat.getTimeInstance(1).format(new Date())).toString());
        }
        return;
        exception;
        obj;
        JVM INSTR monitorexit ;
        throw exception;
    }

    private static void sync(Context context, boolean flag, boolean flag1, String s, boolean flag2)
    {
        sExecutor.execute(new BackgroundAccountSyncRunnable(context, flag, flag1, s, flag2));
    }

    public static void syncAndWait(Context context, boolean flag, boolean flag1, String s)
    {
        syncAndWait(context, flag, flag1, s, false);
    }

    public static void syncAndWait(Context context, boolean flag, boolean flag1, String s, boolean flag2)
    {
        if (SSOUtil.DEBUG)
        {
            Log.i("Amazon.SSOUtil", (new StringBuilder()).append("SSO MAP Account syncAndWait START ").append(DateFormat.getTimeInstance(1).format(new Date())).toString());
        }
        Object obj = sAccountSyncMonitor;
        obj;
        JVM INSTR monitorenter ;
        sync(context, flag, flag1, s, flag2);
        sAccountSyncMonitor.wait();
_L2:
        if (SSOUtil.DEBUG)
        {
            Log.i("Amazon.SSOUtil", (new StringBuilder()).append("SSO MAP Account syncAndWait END ").append(DateFormat.getTimeInstance(1).format(new Date())).toString());
        }
        return;
        context;
        if (SSOUtil.DEBUG)
        {
            Log.e("Amazon.SSOUtil", (new StringBuilder()).append("AccountCookiesSyncManager#syncAndWait").append(context.toString()).toString());
        }
        if (true) goto _L2; else goto _L1
_L1:
        context;
        obj;
        JVM INSTR monitorexit ;
        throw context;
    }





}
