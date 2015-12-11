// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.openx.sdk.event;


// Referenced classes of package com.openx.sdk.event:
//            OXMEvent, OXMEventsHandler

public interface OXMEventsListener
{

    public abstract void fireEvent(OXMEvent oxmevent);

    public abstract void registerEventListener(OXMEvent.OXMEventType oxmeventtype, OXMEventsHandler oxmeventshandler);

    public abstract void unregisterAllEventListeners();

    public abstract void unregisterEventListener(OXMEvent.OXMEventType oxmeventtype, OXMEventsHandler oxmeventshandler);
}
