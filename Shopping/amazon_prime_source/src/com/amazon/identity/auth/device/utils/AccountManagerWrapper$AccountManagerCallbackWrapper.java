// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.utils;

import android.accounts.AccountManagerCallback;
import android.accounts.AccountManagerFuture;
import com.amazon.identity.platform.metric.PlatformMetricsTimer;

// Referenced classes of package com.amazon.identity.auth.device.utils:
//            AccountManagerWrapper

private static class mTimer
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

    (AccountManagerCallback accountmanagercallback, PlatformMetricsTimer platformmetricstimer)
    {
        mCallback = accountmanagercallback;
        mTimer = platformmetricstimer;
    }
}
