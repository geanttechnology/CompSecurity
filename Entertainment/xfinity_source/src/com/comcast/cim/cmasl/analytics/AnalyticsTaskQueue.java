// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.analytics;

import android.content.Context;
import android.content.Intent;
import com.squareup.tape.ObjectQueue;
import com.squareup.tape.Task;
import com.squareup.tape.TaskQueue;

// Referenced classes of package com.comcast.cim.cmasl.analytics:
//            AnalyticsTask, AnalyticsTaskInjector

public class AnalyticsTaskQueue extends TaskQueue
{

    private final Context context;
    private final Class serviceName;

    public AnalyticsTaskQueue(ObjectQueue objectqueue, AnalyticsTaskInjector analyticstaskinjector, Context context1, Class class1)
    {
        super(objectqueue, analyticstaskinjector);
        context = context1;
        serviceName = class1;
    }

    public void add(AnalyticsTask analyticstask)
    {
        super.add(analyticstask);
        for (; size() > 30; remove()) { }
        startService();
    }

    public volatile void add(Task task)
    {
        add((AnalyticsTask)task);
    }

    public volatile void add(Object obj)
    {
        add((AnalyticsTask)obj);
    }

    protected void startService()
    {
        context.startService(new Intent(context, serviceName));
    }
}
