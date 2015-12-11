// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad;

import tv.freewheel.ad.interfaces.IEvent;

// Referenced classes of package tv.freewheel.ad:
//            AdInstance

class vent
    implements Runnable
{

    final AdInstance this$0;
    final IEvent val$eventRef;

    public void run()
    {
        AdInstance.access$000(AdInstance.this, val$eventRef);
    }

    vent()
    {
        this$0 = final_adinstance;
        val$eventRef = IEvent.this;
        super();
    }
}
