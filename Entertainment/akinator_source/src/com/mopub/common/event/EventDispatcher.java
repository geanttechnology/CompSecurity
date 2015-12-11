// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.event;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.mopub.common.logging.MoPubLog;
import java.util.Iterator;

// Referenced classes of package com.mopub.common.event:
//            BaseEvent, EventRecorder

public class EventDispatcher
{

    private final Iterable mEventRecorders;
    private final android.os.Handler.Callback mHandlerCallback = new android.os.Handler.Callback() {

        final EventDispatcher this$0;

        public boolean handleMessage(Message message)
        {
            if (message.obj instanceof BaseEvent)
            {
                for (Iterator iterator = mEventRecorders.iterator(); iterator.hasNext(); ((EventRecorder)iterator.next()).record((BaseEvent)message.obj)) { }
            } else
            {
                MoPubLog.d("EventDispatcher received non-BaseEvent message type.");
            }
            return true;
        }

            
            {
                this$0 = EventDispatcher.this;
                super();
            }
    };
    private final Looper mLooper;
    private final Handler mMessageHandler;

    EventDispatcher(Iterable iterable, Looper looper)
    {
        mEventRecorders = iterable;
        mLooper = looper;
        mMessageHandler = new Handler(mLooper, mHandlerCallback);
    }

    public void dispatch(BaseEvent baseevent)
    {
        Message.obtain(mMessageHandler, 0, baseevent).sendToTarget();
    }

    Iterable getEventRecorders()
    {
        return mEventRecorders;
    }

    android.os.Handler.Callback getHandlerCallback()
    {
        return mHandlerCallback;
    }

}
