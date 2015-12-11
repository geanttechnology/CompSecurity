// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad;

import tv.freewheel.hybrid.ad.interfaces.IEvent;

// Referenced classes of package tv.freewheel.hybrid.ad:
//            AdContext

class Event
    implements Runnable
{

    final AdContext this$0;
    final IEvent val$event;

    public void run()
    {
        AdContext.access$601(AdContext.this, val$event);
    }

    Event()
    {
        this$0 = final_adcontext;
        val$event = IEvent.this;
        super();
    }
}
