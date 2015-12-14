// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.content.Context;
import android.os.Bundle;
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

        public abstract void accountAdded$519a1c20();

        public abstract void accountAlreadyExists$519a1c20();
    }

    private static class BlockingAddAccountCallback
        implements AddAccountCallback
    {

        private boolean mAccountAdded;
        private final CountDownLatch mLatch = new CountDownLatch(1);

        public void accountAdded$519a1c20()
        {
            mAccountAdded = true;
            mLatch.countDown();
        }

        public void accountAlreadyExists$519a1c20()
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

    public void addAccount$2c9ed9ad(String s, Bundle bundle, AccountManagerCallback accountmanagercallback)
    {
        Object obj = mContext;
        DebugHelpers.printBinderFromIMP$5ffc00fd("addAccount");
        obj = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "addAccount");
        mAccountManager.addAccount(s, null, null, bundle, null, new AccountManagerCallbackWrapper(accountmanagercallback, ((PlatformMetricsTimer) (obj))), null);
    }

    public void addAccountExplicitly$69814ad3(final Account account, final Bundle userdata, final AddAccountCallback callback)
    {
        Context context = mContext;
        DebugHelpers.printBinderFromIMP$5ffc00fd("addAccountExplicitly");
        removeAccount(account, new AccountManagerCallback() {

            final AccountManagerWrapper this$0;
            final Account val$account;
            final AddAccountCallback val$callback;
            final String val$password = null;
            final Bundle val$userdata;

            public void run(AccountManagerFuture accountmanagerfuture)
            {
                accountmanagerfuture = ((AccountManagerFuture) (AccountManagerWrapper.LOCKER));
                accountmanagerfuture;
                JVM INSTR monitorenter ;
                boolean flag;
                PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(AccountManagerWrapper.METRICS_COMPONENT_NAME, "addAccountExplicitly");
                flag = mAccountManager.addAccountExplicitly(account, password, userdata);
                platformmetricstimer.stop();
                if (!flag)
                {
                    break MISSING_BLOCK_LABEL_67;
                }
                AddAccountCallback addaccountcallback = callback;
                Account account1 = account;
                addaccountcallback._mth519a1c20();
_L2:
                accountmanagerfuture;
                JVM INSTR monitorexit ;
                return;
                AddAccountCallback addaccountcallback1 = callback;
                Account account2 = account;
                addaccountcallback1._mth519a1c20();
                if (true) goto _L2; else goto _L1
_L1:
                Exception exception;
                exception;
                throw exception;
            }


// JavaClassFileOutputException: Invalid index accessing method local variables table of <init>
        }, true);
    }

    public boolean addAccountExplicitlySync$3429b292(Account account, Bundle bundle)
    {
        BlockingAddAccountCallback blockingaddaccountcallback = new BlockingAddAccountCallback();
        addAccountExplicitly$69814ad3(account, bundle, blockingaddaccountcallback);
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

    public Account[] getAccountsByType(String s)
    {
        Object obj;
        obj = mContext;
        DebugHelpers.printBinderFromIMP$5ffc00fd("getAccountsByType");
        if (mAccountManager == null)
        {
            return new Account[0];
        }
        obj = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "getAccountsByType");
        s = mAccountManager.getAccountsByType(s);
        ((PlatformMetricsTimer) (obj)).stop();
        return s;
        s;
        ((PlatformMetricsTimer) (obj)).stop();
        throw s;
    }

    public AccountManagerFuture getAuthToken$28742b0c(Account account, String s, AccountManagerCallback accountmanagercallback)
    {
        Context context = mContext;
        DebugHelpers.printBinderFromIMP$5ffc00fd("getAuthToken");
        if (mAccountManager == null)
        {
            return null;
        } else
        {
            PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "getAuthToken");
            return mAccountManager.getAuthToken(account, s, null, null, new AccountManagerCallbackWrapper(accountmanagercallback, platformmetricstimer), null);
        }
    }

    public String getUserData(Account account, String s)
    {
        Object obj;
        obj = mContext;
        DebugHelpers.printBinderFromIMP$5ffc00fd("getUserData");
        if (mAccountManager == null || !doesAccountExist(account))
        {
            return null;
        }
        obj = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "getUserData");
        account = mAccountManager.getUserData(account, s);
        ((PlatformMetricsTimer) (obj)).stop();
        return account;
        account;
        ((PlatformMetricsTimer) (obj)).stop();
        throw account;
    }

    public void invalidateAuthToken(String s, String s1)
    {
        Object obj;
        obj = mContext;
        DebugHelpers.printBinderFromIMP$5ffc00fd("invalidateAuthToken");
        if (mAccountManager == null)
        {
            return;
        }
        obj = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "invalidateAuthToken");
        mAccountManager.invalidateAuthToken(s, s1);
        ((PlatformMetricsTimer) (obj)).stop();
        return;
        s;
        ((PlatformMetricsTimer) (obj)).stop();
        throw s;
    }

    public String peekAuthToken(Account account, String s)
    {
        Object obj;
        obj = mContext;
        DebugHelpers.printBinderFromIMP$5ffc00fd("peekAuthToken");
        if (mAccountManager == null)
        {
            return null;
        }
        obj = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "peekAuthToken");
        account = mAccountManager.peekAuthToken(account, s);
        ((PlatformMetricsTimer) (obj)).stop();
        return account;
        account;
        ((PlatformMetricsTimer) (obj)).stop();
        throw account;
    }

    public AccountManagerFuture removeAccount(Account account, AccountManagerCallback accountmanagercallback)
    {
        return removeAccount(account, accountmanagercallback, false);
    }

    public AccountManagerFuture removeAccount(Account account, AccountManagerCallback accountmanagercallback, boolean flag)
    {
        Object obj = mContext;
        DebugHelpers.printBinderFromIMP$5ffc00fd("removeAccount");
        if (mAccountManager == null)
        {
            return null;
        }
        if (flag && mAccountRemovedFlagStore != null)
        {
            mAccountRemovedFlagStore.setAccountToRemoved(account);
        }
        obj = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "removeAccount");
        return mAccountManager.removeAccount(account, new AccountManagerCallbackWrapper(accountmanagercallback, ((PlatformMetricsTimer) (obj))), ThreadUtils.getMapLooperHandler());
    }

    public void setAuthToken(Account account, String s, String s1)
    {
        Object obj;
        obj = mContext;
        DebugHelpers.printBinderFromIMP$5ffc00fd("setAuthToken");
        if (mAccountManager == null)
        {
            return;
        }
        obj = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "setAuthToken");
        mAccountManager.setAuthToken(account, s, s1);
        ((PlatformMetricsTimer) (obj)).stop();
        return;
        account;
        ((PlatformMetricsTimer) (obj)).stop();
        throw account;
    }

    public void setUserData(Account account, String s, String s1)
    {
        Object obj;
        obj = mContext;
        DebugHelpers.printBinderFromIMP$5ffc00fd("setUserData");
        if (mAccountManager == null)
        {
            return;
        }
        obj = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "setUserData");
        mAccountManager.setUserData(account, s, s1);
        ((PlatformMetricsTimer) (obj)).stop();
        return;
        account;
        ((PlatformMetricsTimer) (obj)).stop();
        throw account;
    }

    public String unprotectedGetUserData(Account account, String s)
    {
        Object obj;
        obj = mContext;
        DebugHelpers.printBinderFromIMP$5ffc00fd("unprotectedGetUserData");
        if (account == null)
        {
            throw new IllegalStateException("Account cannot be null");
        }
        if (mAccountManager == null)
        {
            return null;
        }
        obj = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "getUserData");
        account = mAccountManager.getUserData(account, s);
        ((PlatformMetricsTimer) (obj)).stop();
        return account;
        account;
        ((PlatformMetricsTimer) (obj)).stop();
        throw account;
    }

    public AccountManagerFuture updateCredentials$28742b0c(Account account, String s, Bundle bundle, AccountManagerCallback accountmanagercallback)
    {
        Context context = mContext;
        DebugHelpers.printBinderFromIMP$5ffc00fd("updateCredentials");
        if (mAccountManager == null)
        {
            return null;
        } else
        {
            PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(METRICS_COMPONENT_NAME, "updateCredentials");
            return mAccountManager.updateCredentials(account, s, bundle, null, new AccountManagerCallbackWrapper(accountmanagercallback, platformmetricstimer), null);
        }
    }





}
