// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.record;

import com.amazon.mcc.nps.Message;
import com.amazon.mcc.nps.Observer;
import com.amazon.mcc.nps.Topic;
import com.amazon.mcc.nps.broker.Broker;
import java.lang.ref.WeakReference;

// Referenced classes of package com.amazon.mcc.record:
//            BasicRecorder, RecordConstants, PropertyMap, RecordableMessage

public abstract class RecordCollector
{
    private static class RecordObserver
        implements Observer
    {

        private final WeakReference collectorWeakReference;

        public void onUpdate(Topic topic, Message message)
        {
label0:
            {
                if (message instanceof RecordableMessage)
                {
                    topic = (RecordCollector)collectorWeakReference.get();
                    if (topic == null)
                    {
                        break label0;
                    }
                    topic.handle((RecordableMessage)message);
                }
                return;
            }
            BasicRecorder.BROKER.unregister(Topic.of(RecordConstants.RECORD_TOPIC), this);
        }

        public RecordObserver(RecordCollector recordcollector)
        {
            collectorWeakReference = new WeakReference(recordcollector);
        }
    }


    public RecordCollector()
    {
    }

    public abstract void handle(PropertyMap propertymap);

    public void register()
    {
        RecordObserver recordobserver = new RecordObserver(this);
        BasicRecorder.BROKER.register(Topic.of(RecordConstants.RECORD_TOPIC), recordobserver);
    }
}
