// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad.handler;

import java.net.MalformedURLException;
import tv.freewheel.hybrid.ad.EventCallback;
import tv.freewheel.hybrid.ad.slot.Slot;

// Referenced classes of package tv.freewheel.hybrid.ad.handler:
//            EventCallbackHandler

public class SlotImpressionCallbackHandler extends EventCallbackHandler
{

    private boolean imprSent;
    private Slot slot;

    public SlotImpressionCallbackHandler(EventCallback eventcallback)
        throws MalformedURLException
    {
        super(eventcallback);
        imprSent = false;
    }

    public void send()
    {
        if (imprSent && !slot.isPauseMidroll())
        {
            setParameter("init", "2");
        } else
        {
            imprSent = true;
            setParameter("init", "1");
            sendTrackingCallback();
        }
        super.send();
    }

    public void setSlot(Slot slot1)
    {
        slot = slot1;
    }
}
