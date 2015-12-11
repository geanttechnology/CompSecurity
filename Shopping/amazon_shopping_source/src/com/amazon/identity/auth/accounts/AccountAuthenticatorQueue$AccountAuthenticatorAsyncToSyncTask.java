// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.os.Bundle;
import com.amazon.identity.auth.device.api.Callback;
import com.amazon.identity.auth.device.callback.AsyncToSyncAdapter;
import com.amazon.identity.auth.device.utils.MAPLog;
import com.amazon.identity.auth.device.utils.TimeUtil;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            AccountAuthenticatorQueue

private static final class mOperation extends AsyncToSyncAdapter
{

    private static final long ACCOUNT_MANAGER_DEADLOCK_WAIT_DETECTION_SEC;
    private final Callback mCallback;
    private final String mOperation;
    private final ACCOUNT_MANAGER_DEADLOCK_WAIT_DETECTION_SEC mTask;

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

            final AccountAuthenticatorQueue.AccountAuthenticatorAsyncToSyncTask this$0;

            public void onError(Bundle bundle1)
            {
                MAPLog.i(AccountAuthenticatorQueue.access$000(), "Popping task %s off AccountAuthenticatorQueue.", new Object[] {
                    mOperation
                });
                asyncOperationComplete();
                mCallback.onError(bundle1);
            }

            public void onSuccess(Bundle bundle1)
            {
                MAPLog.i(AccountAuthenticatorQueue.access$000(), "Popping task %s off AccountAuthenticatorQueue.", new Object[] {
                    mOperation
                });
                asyncOperationComplete();
                mCallback.onSuccess(bundle1);
            }

            
            {
                this$0 = AccountAuthenticatorQueue.AccountAuthenticatorAsyncToSyncTask.this;
                super();
            }
        };
        MAPLog.i(AccountAuthenticatorQueue.access$000(), "Pushing task %s on AccountAuthenticatorQueue.", new Object[] {
            mOperation
        });
        Bundle bundle = mTask.mTask(callback);
        if (bundle != null)
        {
            callback.onSuccess(bundle);
        }
    }

    static 
    {
        ACCOUNT_MANAGER_DEADLOCK_WAIT_DETECTION_SEC = TimeUtil.fromMinutesTo(5L, TimeUnit.SECONDS);
    }





    public _cls1.this._cls0(_cls1.this._cls0 _pcls0, Callback callback, String s)
    {
        mCallback = callback;
        mTask = _pcls0;
        mOperation = s;
    }
}
