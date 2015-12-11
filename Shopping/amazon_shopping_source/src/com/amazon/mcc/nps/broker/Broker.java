// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.nps.broker;

import com.amazon.logging.Logger;
import com.amazon.mcc.nps.Message;
import com.amazon.mcc.nps.Observer;
import com.amazon.mcc.nps.ObserverProperties;
import com.amazon.mcc.nps.Topic;
import com.amazon.mcc.nps.broker.container.ConcurrentHashmapContainer;
import com.amazon.mcc.nps.broker.container.ObserverContainer;
import com.amazon.mcc.nps.broker.dispatch.ImmediateDispatcher;
import com.amazon.mcc.nps.broker.dispatch.MessageDispatcher;
import java.util.List;

public class Broker
{

    private static Broker instance = createDefaultBroker();
    private final ObserverContainer container;
    private final MessageDispatcher dispatcher;
    private final Logger log = Logger.getLogger(com/amazon/mcc/nps/broker/Broker);

    public Broker(MessageDispatcher messagedispatcher, ObserverContainer observercontainer)
    {
        if (messagedispatcher == null)
        {
            throw new IllegalArgumentException("MessageDispatcher must not be null");
        }
        if (observercontainer == null)
        {
            throw new IllegalArgumentException("ObserverContainer must not be null");
        } else
        {
            log.v("Constructing new Broker");
            log.v((new StringBuilder()).append("Dispatcher type: ").append(messagedispatcher.getClass().getName()).toString());
            log.v((new StringBuilder()).append("Container type: ").append(messagedispatcher.getClass().getName()).toString());
            dispatcher = messagedispatcher;
            container = observercontainer;
            return;
        }
    }

    public static Broker createDefaultBroker()
    {
        return new Broker(new ImmediateDispatcher(), new ConcurrentHashmapContainer());
    }

    public void publish(Topic topic, Message message)
    {
        validateTopic(topic);
        validateMessage(message);
        log.v((new StringBuilder()).append("Publish: T: ").append(topic.getIdentifier()).append(", M: ").append(message.getClass().getName()).toString());
        List list = container.getObserversForTopic(topic);
        if (list != null)
        {
            log.v((new StringBuilder()).append("Notifying ").append(list.size()).append(" observers").toString());
        }
        dispatcher.notifyObservers(list, topic, message);
    }

    public boolean register(Topic topic, Observer observer)
    {
        return register(topic, observer, new ObserverProperties());
    }

    public boolean register(Topic topic, Observer observer, ObserverProperties observerproperties)
    {
        validateTopic(topic);
        validateObserver(observer);
        log.v((new StringBuilder()).append("Observer register: T: ").append(topic.getIdentifier()).append(", Observer: ").append(observer.getClass().getName()).append(observer.hashCode()).toString());
        return container.addObserverForTopic(topic, observer, observerproperties);
    }

    public boolean unregister(Topic topic, Observer observer)
    {
        validateTopic(topic);
        validateObserver(observer);
        log.v((new StringBuilder()).append("Observer unregister: T: ").append(topic.getIdentifier()).append(", Observer: ").append(observer.getClass().getName()).append(observer.hashCode()).toString());
        return container.removeObserverForTopic(topic, observer);
    }

    protected void validateMessage(Message message)
    {
        if (message == null)
        {
            throw new IllegalArgumentException("Message must not be null");
        } else
        {
            return;
        }
    }

    protected void validateObserver(Observer observer)
    {
        if (observer == null)
        {
            throw new IllegalArgumentException("Observer must not be null");
        } else
        {
            return;
        }
    }

    protected void validateTopic(Topic topic)
    {
        if (topic == null)
        {
            throw new IllegalArgumentException("Topic must not be null");
        } else
        {
            return;
        }
    }

}
