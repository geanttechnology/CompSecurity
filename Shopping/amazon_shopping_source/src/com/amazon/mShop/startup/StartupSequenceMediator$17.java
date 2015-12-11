// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.startup;


// Referenced classes of package com.amazon.mShop.startup:
//            StartupSequenceMediator, StartupTask

class val.task
    implements Runnable
{

    final StartupSequenceMediator this$0;
    final StartupTask val$task;

    public void run()
    {
        endTask(val$task.getId(), "taskResultFail");
    }

    _cls9()
    {
        this$0 = final_startupsequencemediator;
        val$task = StartupTask.this;
        super();
    }
}
