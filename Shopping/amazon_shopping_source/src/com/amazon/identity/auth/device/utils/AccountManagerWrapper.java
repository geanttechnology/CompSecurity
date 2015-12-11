// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.amazon.identity.auth.accounts.AccountRemovedFlagStore;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            DebugHelpers, ThreadUtils, MAPLog

public class AccountManagerWrapper
{
    private static class AccountManagerCallbackWrapper
        implements AccountManagerCallback
    {

        private final AccountManagerCallback mCallback;
        private final PlatformMetricsTimer mTimer;

        public void run(AccountManagerFuture accountmanagerfuture)
        {
            mTimer.stop();
            if (mCallback != null)
            {
                mCallback.run(accountmanagerfuture);
            }
        }

        AccountManagerCallbackWrapper(AccountManagerCallback accountmanagercallback, PlatformMetricsTimer platformmetricstimer)
        {
            mCallback = accountmanagercallback;
            mTimer = platformmetricstimer;
        }
    }

    public static interface AddAccountCallback
    {

        public abstract void accountAdded(Account account);

        public abstract void accountAlreadyExists(Account account);
    }

    private static class BlockingAddAccountCallback
        implements AddAccountCallback
    {

        private boolean mAccountAdded;
        private final CountDownLatch mLatch = new CountDownLatch(1);

        public void accountAdded(Account account)
        {
            mAccountAdded = true;
            mLatch.countDown();
        }

        public void accountAlreadyExists(Account account)
        {
            mAccountAdded = false;
            mLatch.countDown();
        }

        public boolean awaitForResult()
        {
            try
            {
                mLatch.await();
            }
            catch (InterruptedException interruptedexception)
            {
                MAPLog.e(AccountManagerWrapper.TAG, "Interrupted waiting for defensive remove accout.");
            }
            return mAccountAdded;
        }

        public BlockingAddAccountCallback()
        {
            mAccountAdded = false;
        }
    }


    private static final Object LOCKER = new Object[0];
    private static final String METRICS_COMPONENT_NAME = com/amazon/identity/auth/device/utils/AccountManagerWrapper.getSimpleName();
    private static final String TAG = com/amazon/identity/auth/device/utils/AccountManagerWrapper.getName();
    private final AccountManager mAccountManager;
    private final AccountRemovedFlagStore mAccountRemovedFlagStore;
    private final Context mContext;

    public AccountManagerWrapper()
    {
        mContext = null;
        mAccountManager = null;
        mAccountRemovedFlagStore = null;
    }

    private AccountManagerWrapper(Context context, AccountManager accountmanager)
    {
        mContext = context;
        mAccountManager = accountmanager;
        mAccountRemovedFlagStore = new AccountRemovedFlagStore(mContext);
    }

    public static AccountManagerWrapper get(Context context)
    {
        return new AccountManagerWrapper(context, AccountManager.get(context));
    }

    public void addAccount(String s, String s1, String as[], Bundle bundle, Activity activity, AccountManagerCallback accountmanagercallback, Handler handler)
    {
        DebugHelpers.printBinderFromIMP(mContext, "addAccount");
        PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "addAccount");
        mAccountManager.addAccount(s, s1, as, bundle, activity, new AccountManagerCallbackWrapper(accountmanagercallback, platformmetricstimer), handler);
    }

    public void addAccountExplicitly(final Account account, final String password, final Bundle userdata, boolean flag, final AddAccountCallback callback)
    {
        DebugHelpers.printBinderFromIMP(mContext, "addAccountExplicitly");
        if (!flag && doesAccountExist(account))
        {
            callback.accountAlreadyExists(account);
            return;
        } else
        {
            removeAccount(account, new AccountManagerCallback() {

                final AccountManagerWrapper this$0;
                final Account val$account;
                final AddAccountCallback val$callback;
                final String val$password;
                final Bundle val$userdata;

                public void run(AccountManagerFuture accountmanagerfuture)
                {
                    accountmanagerfuture = ((AccountManagerFuture) (AccountManagerWrapper.LOCKER));
                    accountmanagerfuture;
                    JVM INSTR monitorenter ;
                    boolean flag1;
                    PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(AccountManagerWrapper.METRICS_COMPONENT_NAME, "addAccountExplicitly");
                    flag1 = mAccountManager.addAccountExplicitly(account, password, userdata);
                    platformmetricstimer.stop();
                    if (!flag1)
                    {
                        break MISSING_BLOCK_LABEL_62;
                    }
                    callback.accountAdded(account);
_L2:
                    accountmanagerfuture;
                    JVM INSTR monitorexit ;
                    return;
                    callback.accountAlreadyExists(account);
                    if (true) goto _L2; else goto _L1
_L1:
                    Exception exception;
                    exception;
                    throw exception;
                }

            
            {
                this$0 = AccountManagerWrapper.this;
                account = account1;
                password = s;
                userdata = bundle;
                callback = addaccountcallback;
                super();
            }
            }, true);
            return;
        }
    }

    public boolean addAccountExplicitlySync(Account account, String s, Bundle bundle)
    {
        return addAccountExplicitlySync(account, s, bundle, false);
    }

    public boolean addAccountExplicitlySync(Account account, String s, Bundle bundle, boolean flag)
    {
        BlockingAddAccountCallback blockingaddaccountcallback = new BlockingAddAccountCallback();
        addAccountExplicitly(account, s, bundle, flag, blockingaddaccountcallback);
        return blockingaddaccountcallback.awaitForResult();
    }

    public boolean doesAccountExist(Account account)
    {
        if (account != null)
        {
            Account aaccount[] = getAccountsByType(account.type);
            int j = aaccount.length;
            int i = 0;
            while (i < j) 
            {
                if (account.equals(aaccount[i]))
                {
                    return true;
                }
                i++;
            }
        }
        return false;
    }

    public AccountManager getAccountManager()
    {
        return mAccountManager;
    }

    public Account[] getAccountsByType(String s)
    {
        PlatformMetricsTimer platformmetricstimer;
        DebugHelpers.printBinderFromIMP(mContext, "getAccountsByType");
        if (mAccountManager == null)
        {
            return new Account[0];
        }
        platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "getAccountsByType");
        s = mAccountManager.getAccountsByType(s);
        platformmetricstimer.stop();
        return s;
        s;
        platformmetricstimer.stop();
        throw s;
    }

    public AccountManagerFuture getAuthToken(Account account, String s, Bundle bundle, Activity activity, AccountManagerCallback accountmanagercallback, Handler handler)
    {
        DebugHelpers.printBinderFromIMP(mContext, "getAuthToken");
        if (mAccountManager == null)
        {
            return null;
        } else
        {
            PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "getAuthToken");
            return mAccountManager.getAuthToken(account, s, bundle, activity, new AccountManagerCallbackWrapper(accountmanagercallback, platformmetricstimer), handler);
        }
    }

    public String getPassword(Account account)
    {
        DebugHelpers.printBinderFromIMP(mContext, "getPassword");
        if (mAccountManager == null)
        {
            return null;
        } else
        {
            return mAccountManager.getPassword(account);
        }
    }

    public String getUserData(Account account, String s)
    {
        PlatformMetricsTimer platformmetricstimer;
        DebugHelpers.printBinderFromIMP(mContext, "getUserData");
        if (mAccountManager == null || !doesAccountExist(account))
        {
            return null;
        }
        platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "getUserData");
        account = mAccountManager.getUserData(account, s);
        platformmetricstimer.stop();
        return account;
        account;
        platformmetricstimer.stop();
        throw account;
    }

    public void invalidateAuthToken(String s, String s1)
    {
        PlatformMetricsTimer platformmetricstimer;
        DebugHelpers.printBinderFromIMP(mContext, "invalidateAuthToken");
        if (mAccountManager == null)
        {
            return;
        }
        platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "invalidateAuthToken");
        mAccountManager.invalidateAuthToken(s, s1);
        platformmetricstimer.stop();
        return;
        s;
        platformmetricstimer.stop();
        throw s;
    }

    public String peekAuthToken(Account account, String s)
    {
        PlatformMetricsTimer platformmetricstimer;
        DebugHelpers.printBinderFromIMP(mContext, "peekAuthToken");
        if (mAccountManager == null)
        {
            return null;
        }
        platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "peekAuthToken");
        account = mAccountManager.peekAuthToken(account, s);
        platformmetricstimer.stop();
        return account;
        account;
        platformmetricstimer.stop();
        throw account;
    }

    public AccountManagerFuture removeAccount(Account account, AccountManagerCallback accountmanagercallback)
    {
        return removeAccount(account, accountmanagercallback, false);
    }

    public AccountManagerFuture removeAccount(Account account, AccountManagerCallback accountmanagercallback, boolean flag)
    {
        DebugHelpers.printBinderFromIMP(mContext, "removeAccount");
        if (mAccountManager == null)
        {
            return null;
        }
        if (flag && mAccountRemovedFlagStore != null)
        {
            mAccountRemovedFlagStore.setAccountToRemoved(account);
        }
        PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "removeAccount");
        return mAccountManager.removeAccount(account, new AccountManagerCallbackWrapper(accountmanagercallback, platformmetricstimer), ThreadUtils.getMapLooperHandler());
    }

    public void setAuthToken(Account account, String s, String s1)
    {
        PlatformMetricsTimer platformmetricstimer;
        DebugHelpers.printBinderFromIMP(mContext, "setAuthToken");
        if (mAccountManager == null)
        {
            return;
        }
        platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "setAuthToken");
        mAccountManager.setAuthToken(account, s, s1);
        platformmetricstimer.stop();
        return;
        account;
        platformmetricstimer.stop();
        throw account;
    }

    public void setUserData(Account account, String s, String s1)
    {
        PlatformMetricsTimer platformmetricstimer;
        DebugHelpers.printBinderFromIMP(mContext, "setUserData");
        if (mAccountManager == null)
        {
            return;
        }
        platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "setUserData");
        mAccountManager.setUserData(account, s, s1);
        platformmetricstimer.stop();
        return;
        account;
        platformmetricstimer.stop();
        throw account;
    }

    public String unprotectedGetUserData(Account account, String s)
    {
        PlatformMetricsTimer platformmetricstimer;
        DebugHelpers.printBinderFromIMP(mContext, "unprotectedGetUserData");
        if (account == null)
        {
            throw new IllegalStateException("Account cannot be null");
        }
        if (mAccountManager == null)
        {
            return null;
        }
        platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "getUserData");
        account = mAccountManager.getUserData(account, s);
        platformmetricstimer.stop();
        return account;
        account;
        platformmetricstimer.stop();
        throw account;
    }

    public AccountManagerFuture updateCredentials(Account account, String s, Bundle bundle, Activity activity, AccountManagerCallback accountmanagercallback, Handler handler)
    {
        DebugHelpers.printBinderFromIMP(mContext, "updateCredentials");
        if (mAccountManager == null)
        {
            return null;
        } else
        {
            PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "updateCredentials");
            return mAccountManager.updateCredentials(account, s, bundle, activity, new AccountManagerCallbackWrapper(accountmanagercallback, platformmetricstimer), handler);
        }
    }





}
