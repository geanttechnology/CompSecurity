// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.event;

import android.os.Message;
import com.mopub.common.logging.MoPubLog;
import java.util.Iterator;

// Referenced classes of package com.mopub.common.event:
//            EventDispatcher, BaseEvent, EventRecorder

class this._cls0
    implements android.os.ispatcher._cls1
{

    final EventDispatcher this$0;

    public boolean handleMessage(Message message)
    {
        if (message.obj instanceof BaseEvent)
        {
            for (Iterator iterator = EventDispatcher.access$000(EventDispatcher.this).iterator(); iterator.hasNext(); ((EventRecorder)iterator.next()).record((BaseEvent)message.obj)) { }
        } else
        {
            MoPubLog.d("EventDispatcher received non-BaseEvent message type.");
        }
        return true;
    }

    ()
    {
        this$0 = EventDispatcher.this;
        super();
    }
}
