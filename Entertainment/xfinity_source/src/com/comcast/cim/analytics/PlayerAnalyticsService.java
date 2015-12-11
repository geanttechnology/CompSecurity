// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.analytics;

import com.comcast.cim.cmasl.analytics.AnalyticsService;
import com.comcast.cim.cmasl.analytics.AnalyticsServiceConfiguration;
import com.comcast.cim.cmasl.analytics.AnalyticsTaskQueue;
import com.comcast.cim.cmasl.android.util.system.InternetConnection;
import com.comcast.cim.container.PlayerContainer;

public class PlayerAnalyticsService extends AnalyticsService
{

    private AnalyticsTaskQueue analyticsTaskQueue;
    private InternetConnection internetConnection;
    private AnalyticsServiceConfiguration serviceConfiguration;

    public PlayerAnalyticsService()
    {
        analyticsTaskQueue = PlayerContainer.getInstance().getAnalyticsTaskQueue();
        internetConnection = PlayerContainer.getInstance().getInternetConnection();
        serviceConfiguration = AnalyticsServiceConfiguration.getDefaultAnalyticsServiceConfiguration();
    }

    protected AnalyticsTaskQueue getAnalyticsTaskQueue()
    {
        return analyticsTaskQueue;
    }

    protected InternetConnection getInternetConnection()
    {
        return internetConnection;
    }

    protected AnalyticsServiceConfiguration getServiceConfiguration()
    {
        return serviceConfiguration;
    }
}
