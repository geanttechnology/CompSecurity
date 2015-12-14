// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.event;

import android.os.HandlerThread;
import java.util.ArrayList;

// Referenced classes of package com.mopub.common.event:
//            ScribeEventRecorder, EventDispatcher, BaseEvent

public class MoPubEvents
{

    private static volatile EventDispatcher sEventDispatcher;

    public MoPubEvents()
    {
    }

    static EventDispatcher getDispatcher()
    {
        Object obj;
        obj = sEventDispatcher;
        if (obj != null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        com/mopub/common/event/MoPubEvents;
        JVM INSTR monitorenter ;
        EventDispatcher eventdispatcher = sEventDispatcher;
        obj = eventdispatcher;
        if (eventdispatcher != null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        obj = new ArrayList();
        HandlerThread handlerthread = new HandlerThread("mopub_event_logging");
        handlerthread.start();
        ((ArrayList) (obj)).add(new ScribeEventRecorder(handlerthread.getLooper()));
        obj = new EventDispatcher(((Iterable) (obj)), handlerthread.getLooper());
        sEventDispatcher = ((EventDispatcher) (obj));
        com/mopub/common/event/MoPubEvents;
        JVM INSTR monitorexit ;
        return ((EventDispatcher) (obj));
        obj;
        com/mopub/common/event/MoPubEvents;
        JVM INSTR monitorexit ;
        throw obj;
        return ((EventDispatcher) (obj));
    }

    public static void log(BaseEvent baseevent)
    {
        getDispatcher().dispatch(baseevent);
    }

    public static void setEventDispatcher(EventDispatcher eventdispatcher)
    {
        sEventDispatcher = eventdispatcher;
    }
}
