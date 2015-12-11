// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.record;

import com.amazon.mcc.nps.Topic;
import com.amazon.mcc.nps.broker.Broker;
import com.amazon.mcc.nps.broker.container.ConcurrentHashmapContainer;
import com.amazon.mcc.nps.broker.dispatch.ConcurrentDispatcher;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.amazon.mcc.record:
//            Recorder, BasicContext, RecordableMessage, RecordConstants, 
//            RecordableContext, Recordable

public class BasicRecorder
    implements Recorder
{

    static final Broker BROKER = createBroker();
    private final RecordableContext context;

    public BasicRecorder()
    {
        this(((RecordableContext) (new BasicContext())));
    }

    public BasicRecorder(RecordableContext recordablecontext)
    {
        context = recordablecontext;
    }

    private static Broker createBroker()
    {
        return new Broker(new ConcurrentDispatcher(new ThreadPoolExecutor(5, 100, 200L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue())), new ConcurrentHashmapContainer());
    }

    public void record(Recordable recordable)
    {
        recordable = new RecordableMessage(recordable, context);
        BROKER.publish(Topic.of(RecordConstants.RECORD_TOPIC), recordable);
    }

}
