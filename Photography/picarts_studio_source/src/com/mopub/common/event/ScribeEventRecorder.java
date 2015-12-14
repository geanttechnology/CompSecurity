// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.common.event;

import android.os.Handler;
import android.os.Looper;
import com.mopub.common.logging.MoPubLog;
import com.mopub.network.ScribeBackoffPolicy;
import com.mopub.network.ScribeRequest;
import com.mopub.network.ScribeRequestManager;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Referenced classes of package com.mopub.common.event:
//            EventRecorder, EventSampler, EventSerializer, BaseEvent

public class ScribeEventRecorder
    implements EventRecorder
{

    private static final int EVENT_COUNT_SEND_THRESHHOLD = 100;
    private static final int POLLING_PERIOD_MS = 0x1d4c0;
    private static final int QUEUE_MAX_SIZE = 500;
    private static final String SCRIBE_URL = "https://analytics.mopub.com/i/jot/exchange_client_event";
    private final Queue mEventQueue;
    private final EventSampler mEventSampler;
    private final EventSerializer mEventSerializer;
    private final Handler mPollHandler;
    private final PollingRunnable mPollingRunnable;
    private final ScribeRequestManager mScribeRequestManager;

    ScribeEventRecorder(Looper looper)
    {
        this(new EventSampler(), ((Queue) (new LinkedList())), new EventSerializer(), new ScribeRequestManager(looper), new Handler(looper));
    }

    ScribeEventRecorder(EventSampler eventsampler, Queue queue, EventSerializer eventserializer, ScribeRequestManager scriberequestmanager, Handler handler)
    {
        mEventSampler = eventsampler;
        mEventQueue = queue;
        mEventSerializer = eventserializer;
        mScribeRequestManager = scriberequestmanager;
        mPollHandler = handler;
        mPollingRunnable = new PollingRunnable();
    }

    List dequeueEvents()
    {
        ArrayList arraylist;
        for (arraylist = new ArrayList(); mEventQueue.peek() != null && arraylist.size() < 100; arraylist.add(mEventQueue.poll())) { }
        return arraylist;
    }

    public void record(BaseEvent baseevent)
    {
        if (!mEventSampler.sample(baseevent))
        {
            return;
        }
        if (mEventQueue.size() >= 500)
        {
            MoPubLog.d((new StringBuilder("EventQueue is at max capacity. Event \"")).append(baseevent.getName()).append("\" is being dropped.").toString());
            return;
        }
        mEventQueue.add(baseevent);
        if (mEventQueue.size() >= 100)
        {
            sendEvents();
        }
        scheduleNextPoll();
    }

    void scheduleNextPoll()
    {
        if (mPollHandler.hasMessages(0) || mEventQueue.isEmpty())
        {
            return;
        } else
        {
            mPollHandler.postDelayed(mPollingRunnable, 0x1d4c0L);
            return;
        }
    }

    void sendEvents()
    {
        final List events;
        if (!mScribeRequestManager.isAtCapacity())
        {
            if (!(events = dequeueEvents()).isEmpty())
            {
                mScribeRequestManager.makeRequest(new com.mopub.network.ScribeRequest.ScribeRequestFactory() {

                    final ScribeEventRecorder this$0;
                    final List val$events;

                    public ScribeRequest createRequest(com.mopub.network.ScribeRequest.Listener listener)
                    {
                        return new ScribeRequest("https://analytics.mopub.com/i/jot/exchange_client_event", events, mEventSerializer, listener);
                    }

            
            {
                this$0 = ScribeEventRecorder.this;
                events = list;
                super();
            }
                }, new ScribeBackoffPolicy());
                return;
            }
        }
    }


    private class PollingRunnable
        implements Runnable
    {

        final ScribeEventRecorder this$0;

        public void run()
        {
            sendEvents();
            scheduleNextPoll();
        }

        PollingRunnable()
        {
            this$0 = ScribeEventRecorder.this;
            super();
        }
    }

}
