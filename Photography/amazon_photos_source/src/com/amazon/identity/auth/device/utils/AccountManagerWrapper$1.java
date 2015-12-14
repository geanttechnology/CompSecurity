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
    final String val$password = null;
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
            break MISSING_BLOCK_LABEL_67;
        }
        dAccountCallback daccountcallback = val$callback;
        Account account1 = val$account;
        daccountcallback._mth519a1c20();
_L2:
        accountmanagerfuture;
        JVM INSTR monitorexit ;
        return;
        dAccountCallback daccountcallback1 = val$callback;
        Account account2 = val$account;
        daccountcallback1._mth519a1c20();
        if (true) goto _L2; else goto _L1
_L1:
        Exception exception;
        exception;
        throw exception;
    }


// JavaClassFileOutputException: Invalid index accessing method local variables table of <init>
}
