// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.taskexecutor.executor.TaskExecutor;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;
import java.util.Set;
import org.slf4j.Logger;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            SeriesEntityActivity

private class <init>
    implements TaskExecutor
{

    final SeriesEntityActivity this$0;

    public void cancelNotificationsFor(TaskExecutionListener taskexecutionlistener)
    {
        SeriesEntityActivity.access$800(SeriesEntityActivity.this).remove(taskexecutionlistener);
    }

    public TaskExecutionListener execute(TaskExecutionListener taskexecutionlistener)
    {
        if (SeriesEntityActivity.access$800(SeriesEntityActivity.this).isEmpty())
        {
            SeriesEntityActivity.access$800(SeriesEntityActivity.this).add(taskexecutionlistener);
            SeriesEntityActivity.access$200().debug("Fetching data for delegate listener {}", taskexecutionlistener);
            SeriesEntityActivity.access$400(SeriesEntityActivity.this);
            return taskexecutionlistener;
        } else
        {
            SeriesEntityActivity.access$800(SeriesEntityActivity.this).add(taskexecutionlistener);
            SeriesEntityActivity.access$200().debug("Added {} to the list of pending listeners for in-progress fetch", taskexecutionlistener);
            return taskexecutionlistener;
        }
    }

    private ()
    {
        this$0 = SeriesEntityActivity.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
