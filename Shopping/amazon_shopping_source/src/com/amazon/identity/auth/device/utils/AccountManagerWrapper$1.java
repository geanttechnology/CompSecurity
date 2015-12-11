// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import android.os.Bundle;
import com.amazon.identity.platform.metric.MetricsHelper;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            AccountManagerWrapper

class dAccountCallback
    implements AccountManagerCallback
{

    final AccountManagerWrapper this$0;
    final Account val$account;
    final dAccountCallback val$callback;
    final String val$password;
    final Bundle val$userdata;

    public void run(AccountManagerFuture accountmanagerfuture)
    {
        accountmanagerfuture = ((AccountManagerFuture) (AccountManagerWrapper.access$100()));
        accountmanagerfuture;
        JVM INSTR monitorenter ;
        boolean flag;
        PlatformMetricsTimer platformmetricstimer = MetricsHelper.startVerboseTimer(AccountManagerWrapper.access$200(), "addAccountExplicitly");
        flag = AccountManagerWrapper.access$300(AccountManagerWrapper.this).addAccountExplicitly(val$account, val$password, val$userdata);
        platformmetricstimer.stop();
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_62;
        }
        val$callback.accountAdded(val$account);
_L2:
        accountmanagerfuture;
        JVM INSTR monitorexit ;
        return;
        val$callback.accountAlreadyExists(val$account);
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }

    dAccountCallback()
    {
        this$0 = final_accountmanagerwrapper;
        val$account = account1;
        val$password = s;
        val$userdata = bundle;
        val$callback = dAccountCallback.this;
        super();
    }
}
