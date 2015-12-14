// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.accounts;

import android.accounts.Account;
import com.amazon.identity.auth.device.callback.AsyncToSyncAdapter;
import com.amazon.identity.auth.device.utils.MAPLog;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.amazon.identity.auth.accounts:
//            DeregisterAccount, SubAuthenticatorConnection

private static class mAccount extends AsyncToSyncAdapter
    implements lback
{

    private final Account mAccount;
    private final SubAuthenticatorConnection mConnection;
    private AtomicBoolean mSuccess;
    private final Object mSyncObj[] = new Object[0];

    private void setSuccess(boolean flag)
    {
        mSuccess.set(flag);
    }

    public void error$1a7fe030(int i, String s)
    {
        synchronized (mSyncObj)
        {
            MAPLog.e(DeregisterAccount.access$000(), String.format("SubAuth Deregister Error: Package=%s, errorCode=%d, msg=%s", new Object[] {
                mConnection.getPackageName(), Integer.valueOf(i), s
            }));
            setSuccess(false);
            asyncOperationComplete();
        }
    }

    public boolean getSuccess()
    {
        return mSuccess.get();
    }

    public void onTimeout()
    {
        synchronized (mSyncObj)
        {
            MAPLog.e(DeregisterAccount.access$000(), String.format("SubAuth Deregister Timeout: Package=%s", new Object[] {
                mConnection.getPackageName()
            }));
            setSuccess(false);
            asyncOperationComplete();
        }
    }

    protected void startAsyncOperation()
    {
        DeregisterAccount.access$400().execute(new Runnable() {

            final DeregisterAccount.SynchronousSubAuthDeregistration this$0;

            public void run()
            {
                mConnection.deregister(mAccount, DeregisterAccount.SynchronousSubAuthDeregistration.this);
            }

            
            {
                this$0 = DeregisterAccount.SynchronousSubAuthDeregistration.this;
                super();
            }
        });
    }

    public void success$44f542f7()
    {
        synchronized (mSyncObj)
        {
            MAPLog.i(DeregisterAccount.access$000(), String.format("SubAuth Deregister Success: Package=%s,", new Object[] {
                mConnection.getPackageName()
            }));
            setSuccess(true);
            asyncOperationComplete();
        }
    }



    public _cls1.this._cls0(SubAuthenticatorConnection subauthenticatorconnection, Account account)
    {
        mSuccess = new AtomicBoolean(false);
        mConnection = subauthenticatorconnection;
        mAccount = account;
    }
}
