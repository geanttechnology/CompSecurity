// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.nps.broker.dispatch;

import com.amazon.logging.Logger;
import com.amazon.mcc.nps.Message;
import com.amazon.mcc.nps.Topic;
import java.util.List;
import java.util.concurrent.ExecutorService;

// Referenced classes of package com.amazon.mcc.nps.broker.dispatch:
//            ImmediateDispatcher

public class ConcurrentDispatcher extends ImmediateDispatcher
{

    private final Logger log = Logger.getLogger(com/amazon/mcc/nps/broker/dispatch/ImmediateDispatcher);
    private final ExecutorService service;

    public ConcurrentDispatcher(ExecutorService executorservice)
    {
        service = executorservice;
    }

    public void notifyObservers(final List observers, final Topic topic, final Message message)
    {
        if (observers == null || observers.size() == 0)
        {
            log.w("Attempted to dispatch message to empty observers");
            return;
        } else
        {
            log.v((new StringBuilder()).append("Scheduling dispatch: T: ").append(topic.getIdentifier()).append(" M: ").append(message.getClass().getName()).toString());
            service.execute(new Runnable() {

                final ConcurrentDispatcher this$0;
                final Message val$message;
                final List val$observers;
                final Topic val$topic;

                public void run()
                {
                    notifyObservers(observers, topic, message);
                }

            
            {
                this$0 = ConcurrentDispatcher.this;
                observers = list;
                topic = topic1;
                message = message1;
                super();
            }
            });
            return;
        }
    }

}
