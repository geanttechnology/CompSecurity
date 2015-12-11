// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.manager;

import android.content.Context;
import com.groupon.util.CarouselExecutorManager;
import com.groupon.util.PausableThreadPoolExecutor;

// Referenced classes of package com.groupon.manager:
//            AnyChannelSyncManager

public class OccasionsSyncManager extends AnyChannelSyncManager
{

    public OccasionsSyncManager(Context context)
    {
        super(context, "OCCASIONS");
    }

    public OccasionsSyncManager(Context context, PausableThreadPoolExecutor pausablethreadpoolexecutor, CarouselExecutorManager carouselexecutormanager)
    {
        super(context, pausablethreadpoolexecutor, "OCCASIONS", carouselexecutormanager);
    }
}
