// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.service;

import com.crittercism.app.Crittercism;
import com.groupon.receiver.InstallAlarms;
import com.groupon.service.core.CoreService;
import com.groupon.service.core.CoreServiceException;
import com.groupon.service.core.listener.CoreServiceInitializerListener;
import com.groupon.tracking.mobile.sdk.Logger;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.groupon.service:
//            DailySyncService

private class logValue
    implements CoreServiceInitializerListener
{

    private final String logCategory;
    private final int logValue;
    private final CountDownLatch startupCountDownLatch;
    final DailySyncService this$0;

    public void onAllServicesRefreshCompletedSuccessfully()
    {
        startupCountDownLatch.countDown();
    }

    public void onAllServicesRefreshCompletedWithError(Collection collection)
    {
        DailySyncService.access$000(DailySyncService.this).logGeneralEvent(logCategory, "suppress", (new StringBuilder()).append("startup:").append(((CoreServiceException)collection.iterator().next()).getCoreServiceClass().getSimpleName()).toString(), logValue, Logger.NULL_NST_FIELD);
        if (!InstallAlarms.installWhenException(DailySyncService.this, DailySyncService.access$300(DailySyncService.this)))
        {
            DailySyncService.access$000(DailySyncService.this).logGeneralEvent("daily_syncer", "suppress", "too_many_retries", 1, Logger.NULL_NST_FIELD);
        }
        collection = collection.iterator();
        do
        {
            if (!collection.hasNext())
            {
                break;
            }
            CoreServiceException coreserviceexception = (CoreServiceException)collection.next();
            if (!(coreserviceexception.getCause() instanceof IOException))
            {
                Crittercism.logHandledException(coreserviceexception);
                DailySyncService.access$100(DailySyncService.this, "startup:", coreserviceexception);
            }
        } while (true);
        DailySyncService.access$202(DailySyncService.this, true);
        startupCountDownLatch.countDown();
    }

    public void onServiceRefreshStarted(CoreService coreservice)
    {
    }

    public (CountDownLatch countdownlatch, String s, int i)
    {
        this$0 = DailySyncService.this;
        super();
        startupCountDownLatch = countdownlatch;
        logCategory = s;
        logValue = i;
    }
}
