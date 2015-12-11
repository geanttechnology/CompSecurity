// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.extension.pausead;

import java.util.HashMap;
import tv.freewheel.hybrid.ad.interfaces.IAdContext;
import tv.freewheel.hybrid.ad.interfaces.IConstants;
import tv.freewheel.hybrid.ad.interfaces.IEvent;
import tv.freewheel.hybrid.ad.interfaces.IEventListener;
import tv.freewheel.hybrid.utils.Logger;
import tv.freewheel.hybrid.utils.events.Event;

// Referenced classes of package tv.freewheel.hybrid.extension.pausead:
//            PauseAdExtension

class this._cls0
    implements IEventListener
{

    final PauseAdExtension this$0;

    public void run(IEvent ievent)
    {
        PauseAdExtension.access$100(PauseAdExtension.this).debug("slotEndedListener");
        if (PauseAdExtension.access$700(PauseAdExtension.this).booleanValue() && PauseAdExtension.access$800(PauseAdExtension.this, ievent).booleanValue())
        {
            PauseAdExtension.access$100(PauseAdExtension.this).debug("slotEndedListener, post EVENT_REQUEST_CONTENT_VIDEO_RESUME");
            ievent = new HashMap();
            ievent.put(PauseAdExtension.access$000(PauseAdExtension.this).INFO_KEY_MESSAGE(), PauseAdExtension.access$500(PauseAdExtension.this));
            ievent.put(PauseAdExtension.access$000(PauseAdExtension.this).INFO_KEY_CUSTOM_ID(), PauseAdExtension.access$500(PauseAdExtension.this));
            PauseAdExtension.access$200(PauseAdExtension.this).dispatchEvent(new Event(PauseAdExtension.access$000(PauseAdExtension.this).EVENT_REQUEST_CONTENT_VIDEO_RESUME(), ievent));
            PauseAdExtension.access$702(PauseAdExtension.this, Boolean.valueOf(false));
            PauseAdExtension.access$602(PauseAdExtension.this, null);
        }
    }

    ()
    {
        this$0 = PauseAdExtension.this;
        super();
    }
}
