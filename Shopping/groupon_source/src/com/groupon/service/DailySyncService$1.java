// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.groupon.tracking.mobile.sdk.Logger;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.groupon.service:
//            DailySyncService

class val.logValue
    implements commonlib.manager.allbacks
{

    final DailySyncService this$0;
    final String val$logCategory;
    final int val$logValue;
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
        DailySyncService.access$000(DailySyncService.this).logGeneralEvent(val$logCategory, "suppress", (new StringBuilder()).append("email:").append(exception.getClass().getSimpleName()).toString(), val$logValue, Logger.NULL_NST_FIELD);
        DailySyncService.access$100(DailySyncService.this, "email:", exception);
        DailySyncService.access$202(DailySyncService.this, true);
    }

    lbacks()
    {
        this$0 = final_dailysyncservice;
        val$syncFinished = countdownlatch;
        val$logCategory = s;
        val$logValue = I.this;
        super();
    }
}
