// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.receiver.InstallAlarms;
import com.groupon.tracking.mobile.sdk.Logger;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.groupon.service:
//            DailySyncService

class val.errors
    implements commonlib.manager.allbacks
{

    final DailySyncService this$0;
    final boolean val$errors[];
    final String val$logCategory;
    final int val$logValue;
    final String val$processingStage;
    final CountDownLatch val$syncFinished;

    public void enableSyncProgressIndicator(boolean flag)
    {
        if (!flag)
        {
            val$syncFinished.countDown();
        }
    }

    public void handleSyncError(Runnable runnable, Exception exception)
    {
        DailySyncService.access$000(DailySyncService.this).logGeneralEvent(val$logCategory, "suppress", (new StringBuilder()).append(val$processingStage).append(exception.getClass().getSimpleName()).toString(), val$logValue, Logger.NULL_NST_FIELD);
        DailySyncService.access$100(DailySyncService.this, val$processingStage, exception);
        if (!InstallAlarms.installWhenException(DailySyncService.this, DailySyncService.access$300(DailySyncService.this)))
        {
            DailySyncService.access$000(DailySyncService.this).logGeneralEvent("daily_syncer", "suppress", "too_many_retries", 1, Logger.NULL_NST_FIELD);
        }
        val$errors[0] = true;
    }

    lbacks()
    {
        this$0 = final_dailysyncservice;
        val$syncFinished = countdownlatch;
        val$logCategory = s;
        val$processingStage = s1;
        val$logValue = i;
        val$errors = _5B_Z.this;
        super();
    }
}
