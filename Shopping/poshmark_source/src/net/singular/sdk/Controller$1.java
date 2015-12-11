// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.singular.sdk;


// Referenced classes of package net.singular.sdk:
//            Controller, CountersLogger, Collector, PostableWorker

class val.collector
    implements Runnable
{

    final Controller this$0;
    final Collector val$collector;

    public void run()
    {
        try
        {
            Controller.access$000(Controller.this).loadSavedCounters();
            val$collector.initializeIds();
            senderPostable.start();
            return;
        }
        catch (RuntimeException runtimeexception)
        {
            Controller.access$100(Controller.this, runtimeexception, "initController() runnable");
        }
    }

    r()
    {
        this$0 = final_controller;
        val$collector = Collector.this;
        super();
    }
}
