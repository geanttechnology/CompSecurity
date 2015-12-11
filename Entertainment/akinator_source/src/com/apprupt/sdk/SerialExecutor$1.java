// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.apprupt.sdk;


// Referenced classes of package com.apprupt.sdk:
//            SerialExecutor

class val.r
    implements Runnable
{

    final SerialExecutor this$0;
    final Runnable val$r;

    public void run()
    {
        val$r.run();
        scheduleNext();
        return;
        Exception exception;
        exception;
        scheduleNext();
        throw exception;
    }

    ()
    {
        this$0 = final_serialexecutor;
        val$r = Runnable.this;
        super();
    }
}
