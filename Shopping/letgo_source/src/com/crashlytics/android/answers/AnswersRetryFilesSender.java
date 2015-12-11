// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.crashlytics.android.answers;

import android.support.v7.anq;
import android.support.v7.anr;
import android.support.v7.ant;
import android.support.v7.aod;
import java.util.List;

// Referenced classes of package com.crashlytics.android.answers:
//            RetryManager, RandomBackoff, SessionAnalyticsFilesSender

class AnswersRetryFilesSender
    implements aod
{

    private static final int BACKOFF_MS = 1000;
    private static final int BACKOFF_POWER = 8;
    private static final double JITTER_PERCENT = 0.10000000000000001D;
    private static final int MAX_RETRIES = 5;
    private final SessionAnalyticsFilesSender filesSender;
    private final RetryManager retryManager;

    AnswersRetryFilesSender(SessionAnalyticsFilesSender sessionanalyticsfilessender, RetryManager retrymanager)
    {
        filesSender = sessionanalyticsfilessender;
        retryManager = retrymanager;
    }

    public static AnswersRetryFilesSender build(SessionAnalyticsFilesSender sessionanalyticsfilessender)
    {
        return new AnswersRetryFilesSender(sessionanalyticsfilessender, new RetryManager(new ant(new RandomBackoff(new anr(1000L, 8), 0.10000000000000001D), new anq(5))));
    }

    public boolean send(List list)
    {
        long l;
label0:
        {
            boolean flag = false;
            l = System.nanoTime();
            if (retryManager.canRetry(l))
            {
                if (!filesSender.send(list))
                {
                    break label0;
                }
                retryManager.reset();
                flag = true;
            }
            return flag;
        }
        retryManager.recordRetry(l);
        return false;
    }
}
