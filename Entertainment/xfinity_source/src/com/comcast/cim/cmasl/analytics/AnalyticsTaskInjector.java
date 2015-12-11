// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.analytics;

import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutorFactory;
import com.squareup.tape.Task;
import com.squareup.tape.TaskInjector;

// Referenced classes of package com.comcast.cim.cmasl.analytics:
//            AnalyticsTask, AnalyticsSenderFactory

public class AnalyticsTaskInjector
    implements TaskInjector
{

    private final AnalyticsSenderFactory analyticsSenderFactory;
    private final TaskExecutorFactory taskExecutorFactory;

    public AnalyticsTaskInjector(AnalyticsSenderFactory analyticssenderfactory, TaskExecutorFactory taskexecutorfactory)
    {
        analyticsSenderFactory = analyticssenderfactory;
        taskExecutorFactory = taskexecutorfactory;
    }

    public void injectMembers(AnalyticsTask analyticstask)
    {
        analyticstask.setAnalyticsSenderFactory(analyticsSenderFactory);
        analyticstask.setTaskExecutorFactory(taskExecutorFactory);
    }

    public volatile void injectMembers(Task task)
    {
        injectMembers((AnalyticsTask)task);
    }
}
