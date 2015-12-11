// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.nps.broker.dispatch;

import com.amazon.logging.Logger;
import com.amazon.mcc.nps.Message;
import com.amazon.mcc.nps.Observer;
import com.amazon.mcc.nps.Topic;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mcc.nps.broker.dispatch:
//            MessageDispatcher

public class ImmediateDispatcher
    implements MessageDispatcher
{

    private final Logger log = Logger.getLogger(com/amazon/mcc/nps/broker/dispatch/ImmediateDispatcher);

    public ImmediateDispatcher()
    {
    }

    public void notifyObservers(List list, Topic topic, Message message)
    {
        if (list == null || list.size() == 0)
        {
            log.v("Attempted to dispatch message to empty observers");
        } else
        {
            log.v((new StringBuilder()).append("Immediately dispatching: T: ").append(topic.getIdentifier()).append(" M: ").append(message.getClass().getName()).toString());
            list = list.iterator();
            while (list.hasNext()) 
            {
                ((Observer)list.next()).onUpdate(topic, message);
            }
        }
    }
}
