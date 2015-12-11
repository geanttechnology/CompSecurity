// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.freewheel.ad;

import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.IEventListener;

// Referenced classes of package com.freewheel.ad:
//            AdFetcher, IAdHolder

class this._cls0
    implements IEventListener
{

    final AdFetcher this$0;

    public void run(IEvent ievent)
    {
        if (AdFetcher.access$200(AdFetcher.this))
        {
            return;
        } else
        {
            AdFetcher.access$300(AdFetcher.this).onRequestComplete(ievent);
            return;
        }
    }

    vent()
    {
        this$0 = AdFetcher.this;
        super();
    }
}
