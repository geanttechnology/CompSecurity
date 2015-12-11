// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.harvest;


// Referenced classes of package com.newrelic.agent.android.harvest:
//            HarvestTimer

class val.timer
    implements Runnable
{

    final HarvestTimer this$0;
    final HarvestTimer val$timer;

    public void run()
    {
        val$timer.tick();
    }

    ()
    {
        this$0 = final_harvesttimer;
        val$timer = HarvestTimer.this;
        super();
    }
}
