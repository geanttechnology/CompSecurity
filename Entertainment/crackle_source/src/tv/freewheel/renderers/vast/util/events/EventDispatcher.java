// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.renderers.vast.util.events;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tv.freewheel.ad.interfaces.IEvent;
import tv.freewheel.ad.interfaces.IEventListener;

public class EventDispatcher
{

    protected HashMap _listenersMap;

    public EventDispatcher()
    {
        removeAllListeners();
    }

    public void addEventListener(String s, IEventListener ieventlistener)
    {
        if (ieventlistener == null)
        {
            return;
        }
        removeEventListener(s, ieventlistener);
        ArrayList arraylist1 = (ArrayList)_listenersMap.get(s);
        ArrayList arraylist = arraylist1;
        if (arraylist1 == null)
        {
            arraylist = new ArrayList();
            _listenersMap.put(s, arraylist);
        }
        arraylist.add(ieventlistener);
    }

    public void dispatchEvent(IEvent ievent)
    {
        Object obj = (ArrayList)_listenersMap.get(ievent.getType());
        if (obj != null)
        {
            for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); ((IEventListener)((Iterator) (obj)).next()).run(ievent)) { }
        }
    }

    public boolean hasEventListener(String s)
    {
        s = (ArrayList)_listenersMap.get(s);
        return s != null && !s.isEmpty();
    }

    public void removeAllListeners()
    {
        _listenersMap = new HashMap();
    }

    public void removeEventListener(String s, IEventListener ieventlistener)
    {
        ArrayList arraylist = (ArrayList)_listenersMap.get(s);
        if (arraylist != null)
        {
            Iterator iterator = arraylist.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                if ((IEventListener)iterator.next() != ieventlistener)
                {
                    continue;
                }
                iterator.remove();
                break;
            } while (true);
            if (arraylist.isEmpty())
            {
                _listenersMap.remove(s);
            }
        }
    }

    public void removeEventListeners(String s)
    {
        _listenersMap.remove(s);
    }
}
