// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.programdetails;

import com.comcast.cim.cmasl.taskexecutor.listener.DeferringTaskExecutionListener;
import com.comcast.cim.cmasl.taskexecutor.listener.TaskExecutionListener;

// Referenced classes of package com.xfinity.playerlib.view.programdetails:
//            PreDownloadFlowFragment

private class <init> extends DeferringTaskExecutionListener
{

    final PreDownloadFlowFragment this$0;

    protected void onDefer(Runnable runnable)
    {
        abortFlow();
    }

    protected boolean shouldDefer()
    {
        return !isResumed();
    }

    private (TaskExecutionListener taskexecutionlistener)
    {
        this$0 = PreDownloadFlowFragment.this;
        super(taskexecutionlistener);
    }

    this._cls0(TaskExecutionListener taskexecutionlistener, this._cls0 _pcls0)
    {
        this(taskexecutionlistener);
    }
}
