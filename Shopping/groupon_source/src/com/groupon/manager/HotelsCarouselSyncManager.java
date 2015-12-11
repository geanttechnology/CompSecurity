// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import com.groupon.util.CarouselExecutorManager;
import com.groupon.util.ExecutorManager;
import com.groupon.util.PausableThreadPoolExecutor;

// Referenced classes of package com.groupon.manager:
//            MarketRateSyncManager

public class HotelsCarouselSyncManager extends MarketRateSyncManager
{

    public HotelsCarouselSyncManager(Context context)
    {
        super(context);
    }

    public HotelsCarouselSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor, CarouselExecutorManager carouselexecutormanager)
    {
        super(context, pausablethreadpoolexecutor, carouselexecutormanager);
    }

    public HotelsCarouselSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor, ExecutorManager executormanager)
    {
        super(context, pausablethreadpoolexecutor, executormanager);
    }
}
