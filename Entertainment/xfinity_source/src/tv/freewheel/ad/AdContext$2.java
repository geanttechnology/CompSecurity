// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad;

import java.util.HashMap;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.IEventListener;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.events.Event;

// Referenced classes of package tv.freewheel.ad:
//            AdContext

class this._cls0
    implements IEventListener
{

    final AdContext this$0;

    public void run(IEvent ievent)
    {
        ievent = (String)ievent.getData().get("message");
        AdContext.access$400(AdContext.this).debug((new StringBuilder()).append("request failed: ").append(ievent).toString());
        HashMap hashmap = new HashMap();
        hashmap.put("message", (new StringBuilder()).append("request failed: ").append(ievent).toString());
        hashmap.put("success", "false");
        dispatchEvent(new Event("requestComplete", hashmap));
    }

    Event()
    {
        this$0 = AdContext.this;
        super();
    }
}
