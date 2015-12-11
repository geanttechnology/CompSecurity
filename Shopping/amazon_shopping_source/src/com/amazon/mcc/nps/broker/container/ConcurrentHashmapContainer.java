// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mcc.nps.broker.container;

import com.amazon.logging.Logger;
import com.amazon.mcc.nps.Observer;
import com.amazon.mcc.nps.ObserverProperties;
import com.amazon.mcc.nps.Topic;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

// Referenced classes of package com.amazon.mcc.nps.broker.container:
//            ObserverContainer

public class ConcurrentHashmapContainer
    implements ObserverContainer
{
    private static class RegisteredObserver
    {

        private final Observer observer;
        private final ObserverProperties properties;

        public boolean equals(Object obj)
        {
            if (this != obj) goto _L2; else goto _L1
_L1:
            return true;
_L2:
            if (obj == null)
            {
                return false;
            }
            if (getClass() != obj.getClass())
            {
                return false;
            }
            obj = (RegisteredObserver)obj;
            if (observer != null)
            {
                continue; /* Loop/switch isn't completed */
            }
            if (((RegisteredObserver) (obj)).observer == null) goto _L1; else goto _L3
_L3:
            return false;
            if (observer.equals(((RegisteredObserver) (obj)).observer)) goto _L1; else goto _L4
_L4:
            return false;
        }

        public Observer getObserver()
        {
            return observer;
        }

        public int getPriority()
        {
            return properties.getPriority();
        }

        public int hashCode()
        {
            int i;
            if (observer == null)
            {
                i = 0;
            } else
            {
                i = observer.hashCode();
            }
            return i + 31;
        }

        public RegisteredObserver(Observer observer1, ObserverProperties observerproperties)
        {
            observer = observer1;
            properties = observerproperties;
        }
    }

    private static class RegisteredObserverComparator
        implements Comparator
    {

        public int compare(RegisteredObserver registeredobserver, RegisteredObserver registeredobserver1)
        {
            byte byte0 = 0;
            int i;
            int j;
            if (registeredobserver == null)
            {
                i = 0;
            } else
            {
                i = registeredobserver.getPriority();
            }
            if (registeredobserver1 == null)
            {
                j = 0;
            } else
            {
                j = registeredobserver1.getPriority();
            }
            if (i > j)
            {
                byte0 = -1;
            } else
            if (i < j)
            {
                return 1;
            }
            return byte0;
        }

        public volatile int compare(Object obj, Object obj1)
        {
            return compare((RegisteredObserver)obj, (RegisteredObserver)obj1);
        }

        private RegisteredObserverComparator()
        {
        }

    }


    private final RegisteredObserverComparator comparator = new RegisteredObserverComparator();
    private final Logger log = Logger.getLogger(com/amazon/mcc/nps/broker/container/ConcurrentHashmapContainer);
    private final ConcurrentHashMap observersMap = new ConcurrentHashMap();

    public ConcurrentHashmapContainer()
    {
    }

    private List copyObserversList(List list)
    {
        ArrayList arraylist = new ArrayList(list.size());
        for (list = list.iterator(); list.hasNext(); arraylist.add(((RegisteredObserver)list.next()).getObserver())) { }
        return arraylist;
    }

    public boolean addObserverForTopic(Topic topic, Observer observer, ObserverProperties observerproperties)
    {
        if (topic == null || observer == null)
        {
            log.w("Attempted to add null topic or null observer");
            return false;
        }
        observersMap.putIfAbsent(topic, new ArrayList());
        synchronized ((List)observersMap.get(topic))
        {
            topic.add(new RegisteredObserver(observer, observerproperties));
            Collections.sort(topic, new RegisteredObserverComparator());
        }
        return true;
        observer;
        topic;
        JVM INSTR monitorexit ;
        throw observer;
    }

    public List getObserversForTopic(Topic topic)
    {
        List list;
        String s;
        if (topic == null)
        {
            log.w("GetObserversForTopic called with null topic!");
            return null;
        }
        s = topic.getIdentifier();
        log.v((new StringBuilder()).append("GetObserversForTopic: T: ").append(s).toString());
        if (!observersMap.containsKey(topic))
        {
            break MISSING_BLOCK_LABEL_156;
        }
        list = (List)observersMap.get(topic);
        if (list == null)
        {
            break MISSING_BLOCK_LABEL_125;
        }
        list;
        JVM INSTR monitorenter ;
        log.v(String.format("Found %d observers for topic: T: ", new Object[] {
            Integer.valueOf(list.size()), s
        }));
        topic = Collections.unmodifiableList(copyObserversList(list));
        list;
        JVM INSTR monitorexit ;
        return topic;
        topic;
        list;
        JVM INSTR monitorexit ;
        throw topic;
        log.w((new StringBuilder()).append("Found a null list of observers for topic: T: ").append(topic.getIdentifier()).toString());
        return null;
        log.v((new StringBuilder()).append("No observers found for topic: T: ").append(topic.getIdentifier()).toString());
        return null;
    }

    public boolean removeObserverForTopic(Topic topic, Observer observer)
    {
        if (topic != null && observer != null) goto _L2; else goto _L1
_L1:
        log.w("Attempted to remove null topic or null observer");
_L4:
        return false;
_L2:
        List list = (List)observersMap.get(topic);
        if (list == null) goto _L4; else goto _L3
_L3:
        list;
        JVM INSTR monitorenter ;
        boolean flag;
        flag = list.remove(new RegisteredObserver(observer, new ObserverProperties()));
        if (list.size() == 0)
        {
            observersMap.remove(topic);
        }
        list;
        JVM INSTR monitorexit ;
        return flag;
        topic;
        list;
        JVM INSTR monitorexit ;
        throw topic;
    }
}
