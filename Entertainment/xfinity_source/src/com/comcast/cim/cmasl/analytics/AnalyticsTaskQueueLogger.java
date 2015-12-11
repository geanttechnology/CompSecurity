// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.analytics;


// Referenced classes of package com.comcast.cim.cmasl.analytics:
//            AnalyticsLogger, EventData, AnalyticsTask, AnalyticsTaskQueue

public class AnalyticsTaskQueueLogger
    implements AnalyticsLogger
{

    private final AnalyticsTaskQueue analyticsTaskQueue;
    private final String applicationName;
    private final String hostUrl;

    public AnalyticsTaskQueueLogger(AnalyticsTaskQueue analyticstaskqueue, String s, String s1)
    {
        analyticsTaskQueue = analyticstaskqueue;
        applicationName = s;
        hostUrl = s1;
    }

    public void logData(EventData eventdata)
    {
        eventdata.addData("app", applicationName);
        analyticsTaskQueue.add(new AnalyticsTask(hostUrl, eventdata));
    }

    public void startService()
    {
        analyticsTaskQueue.startService();
    }
}
