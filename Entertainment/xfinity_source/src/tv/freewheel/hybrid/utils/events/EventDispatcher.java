// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.utils.events;

import java.util.ArrayList;
import java.util.HashMap;
import tv.freewheel.hybrid.ad.interfaces.IEvent;
import tv.freewheel.hybrid.ad.interfaces.IEventListener;
import tv.freewheel.hybrid.utils.Logger;

public class EventDispatcher
{

    protected HashMap _listenersMap;
    private Logger logger;

    public EventDispatcher()
    {
        logger = Logger.getLogger(this, true);
        removeAllListeners();
    }

    public void addEventListener(String s, IEventListener ieventlistener)
    {
        logger.debug((new StringBuilder()).append("addEventListener(type=").append(s).append(", listener=").append(ieventlistener).append(")").toString());
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
        logger.debug((new StringBuilder()).append("dispatchEvent(event=").append(ievent.getType()).append(")").toString());
        ArrayList arraylist = (ArrayList)_listenersMap.get(ievent.getType());
        if (arraylist != null)
        {
            IEventListener aieventlistener[] = new IEventListener[arraylist.size()];
            arraylist.toArray(aieventlistener);
            int j = aieventlistener.length;
            for (int i = 0; i < j; i++)
            {
                aieventlistener[i].run(ievent);
            }

        }
    }

    public void removeAllListeners()
    {
        logger.debug((new StringBuilder()).append("removeAllListeners for ").append(this).toString());
        _listenersMap = new HashMap();
    }

    public void removeEventListener(String s, IEventListener ieventlistener)
    {
        logger.debug((new StringBuilder()).append("removeEventListener(type=").append(s).append(", listener=").append(ieventlistener).append(")").toString());
        ArrayList arraylist = (ArrayList)_listenersMap.get(s);
        if (arraylist != null)
        {
            arraylist.remove(ieventlistener);
            if (arraylist.isEmpty())
            {
                _listenersMap.remove(s);
            }
        }
    }
}
