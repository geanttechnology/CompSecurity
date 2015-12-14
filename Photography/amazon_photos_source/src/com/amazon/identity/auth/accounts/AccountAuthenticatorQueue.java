// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.callback.AsyncToSyncAdapter;
import com.amazon.identity.auth.device.framework.UnitTestSafeExecutorService;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.ThreadUtils;
import com.amazon.identity.auth.device.utils.TimeUtil;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class AccountAuthenticatorQueue
{
    private static final class AccountAuthenticatorAsyncToSyncTask extends AsyncToSyncAdapter
    {

        private static final long ACCOUNT_MANAGER_DEADLOCK_WAIT_DETECTION_SEC;
        private final Callback mCallback;
        private final String mOperation;
        private final AccountAuthenticatorTask mTask;

        protected void onTimeout()
        {
            throw new RuntimeException("Possible AccountManager Deadlock Detected!");
        }

        public void run()
        {
            this;
            JVM INSTR monitorenter ;
            super.run(Long.valueOf(ACCOUNT_MANAGER_DEADLOCK_WAIT_DETECTION_SEC), TimeUnit.SECONDS, mOperation);
            this;
            JVM INSTR monitorexit ;
            return;
            Exception exception;
            exception;
            throw exception;
        }

        protected void startAsyncOperation()
        {
            Callback callback = new Callback() {

                final AccountAuthenticatorAsyncToSyncTask this$0;

                public void onError(Bundle bundle)
                {
                    MAPLog.formattedInfo(AccountAuthenticatorQueue.TAG, "Popping task %s off AccountAuthenticatorQueue.", new Object[] {
                        mOperation
                    });
                    asyncOperationComplete();
                    mCallback.onError(bundle);
                }

                public void onSuccess(Bundle bundle)
                {
                    MAPLog.formattedInfo(AccountAuthenticatorQueue.TAG, "Popping task %s off AccountAuthenticatorQueue.", new Object[] {
                        mOperation
                    });
                    asyncOperationComplete();
                    mCallback.onSuccess(bundle);
                }

            
            {
                this$0 = AccountAuthenticatorAsyncToSyncTask.this;
                super();
            }
            };
            MAPLog.formattedInfo(AccountAuthenticatorQueue.TAG, "Pushing task %s on AccountAuthenticatorQueue.", new Object[] {
                mOperation
            });
            Bundle bundle = mTask.run(callback);
            if (bundle != null)
            {
                callback.onSuccess(bundle);
            }
        }

        static 
        {
            ACCOUNT_MANAGER_DEADLOCK_WAIT_DETECTION_SEC = TimeUtil.fromMinutesTo(5L, TimeUnit.SECONDS);
        }





        public AccountAuthenticatorAsyncToSyncTask(AccountAuthenticatorTask accountauthenticatortask, Callback callback, String s)
        {
            mCallback = callback;
            mTask = accountauthenticatortask;
            mOperation = s;
        }
    }

    public static interface AccountAuthenticatorTask
    {

        public abstract Bundle run(Callback callback);
    }


    private static final String TAG = com/amazon/identity/auth/accounts/AccountAuthenticatorQueue.getName();
    private final UnitTestSafeExecutorService mAccountAuthenticatorQueue = new UnitTestSafeExecutorService(Executors.newSingleThreadExecutor(ThreadUtils.getNamedThreadFactory("MAP-AccountAuthenticatorQueueThread")));

    public AccountAuthenticatorQueue()
    {
    }

    public void addAccountAuthenticatorTask(AccountAuthenticatorTask accountauthenticatortask, Callback callback, String s)
    {
        mAccountAuthenticatorQueue.execute(new AccountAuthenticatorAsyncToSyncTask(accountauthenticatortask, callback, s));
    }


}
