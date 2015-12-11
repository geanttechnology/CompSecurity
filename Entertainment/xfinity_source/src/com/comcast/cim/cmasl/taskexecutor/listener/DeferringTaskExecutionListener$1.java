// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.taskexecutor.listener;


// Referenced classes of package com.comcast.cim.cmasl.taskexecutor.listener:
//            DeferringTaskExecutionListener, TaskExecutionListener

class val.result
    implements Runnable
{

    final DeferringTaskExecutionListener this$0;
    final Object val$result;

    public void run()
    {
        DeferringTaskExecutionListener.access$000(DeferringTaskExecutionListener.this).onPostExecute(val$result);
    }

    ()
    {
        this$0 = final_deferringtaskexecutionlistener;
        val$result = Object.this;
        super();
    }
}
