// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.utils;

import java.util.TimerTask;

// Referenced classes of package tv.freewheel.hybrid.utils:
//            Scheduler, RecordTimer

class this._cls0 extends TimerTask
{

    final Scheduler this$0;

    public void run()
    {
        Scheduler.access$002(Scheduler.this, Scheduler.access$100(Scheduler.this).tick());
        Scheduler.access$200(Scheduler.this).run();
    }

    ()
    {
        this$0 = Scheduler.this;
        super();
    }
}
