// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Iterator;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import tv.freewheel.hybrid.ad.handler.AdImpressionCallbackHandler;
import tv.freewheel.hybrid.ad.handler.ClickCallbackHandler;
import tv.freewheel.hybrid.ad.handler.ErrorCallbackHandler;
import tv.freewheel.hybrid.ad.handler.EventCallbackHandler;
import tv.freewheel.hybrid.ad.handler.QuartileCallbackHandler;
import tv.freewheel.hybrid.ad.handler.ResellerNoAdCallbackHandler;
import tv.freewheel.hybrid.ad.handler.SlotImpressionCallbackHandler;
import tv.freewheel.hybrid.ad.handler.StandardCallbackHandler;
import tv.freewheel.hybrid.ad.handler.VideoViewCallbackHandler;
import tv.freewheel.hybrid.utils.Logger;

// Referenced classes of package tv.freewheel.hybrid.ad:
//            AdContextScoped, EventCallback, AdContext

public class EventCallbackHolder extends AdContextScoped
{

    public ArrayList eventCallbacks;

    public EventCallbackHolder(AdContext adcontext)
    {
        super(adcontext);
        eventCallbacks = new ArrayList();
    }

    public EventCallbackHandler createEventHandler(String s, String s1, boolean flag)
    {
        Object obj;
        logger.debug((new StringBuilder()).append("createEventHandler(").append(s).append(",").append(s1).append(",").append(flag).append(")").toString());
        obj = fetchEventCallback(s, s1, flag);
        if (s1.equals("ERROR"))
        {
            return new ErrorCallbackHandler(((EventCallback) (obj)));
        }
        if (!s1.equals("STANDARD"))
        {
            break MISSING_BLOCK_LABEL_108;
        }
        s1 = new StandardCallbackHandler(((EventCallback) (obj)));
        obj = s1;
        s1.setParameter("cn", s);
        return s1;
        ClickCallbackHandler clickcallbackhandler;
        if (!s1.equals("CLICK") && !s1.equals("CLICKTRACKING"))
        {
            break MISSING_BLOCK_LABEL_192;
        }
        clickcallbackhandler = new ClickCallbackHandler(((EventCallback) (obj)));
        Object obj1;
        obj1 = clickcallbackhandler;
        obj = clickcallbackhandler;
        if (s.equals("defaultClick"))
        {
            break MISSING_BLOCK_LABEL_300;
        }
        obj1 = clickcallbackhandler;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_300;
        }
        obj = clickcallbackhandler;
        clickcallbackhandler.setParameter("cn", s);
        obj = clickcallbackhandler;
        clickcallbackhandler.setParameter("et", EventCallback.getShortenedEventType(s1));
        return clickcallbackhandler;
        if (s.equals("slotImpression"))
        {
            return new SlotImpressionCallbackHandler(((EventCallback) (obj)));
        }
        if (s.equals("defaultImpression"))
        {
            return new AdImpressionCallbackHandler(((EventCallback) (obj)));
        }
        if (s.equals("videoView"))
        {
            return new VideoViewCallbackHandler(((EventCallback) (obj)));
        }
        if (s.equals("resellerNoAd"))
        {
            return new ResellerNoAdCallbackHandler(((EventCallback) (obj)));
        }
        if (!s1.equals("IMPRESSION"))
        {
            break MISSING_BLOCK_LABEL_321;
        }
        obj1 = new QuartileCallbackHandler(((EventCallback) (obj)));
        obj = obj1;
        ((EventCallbackHandler) (obj1)).setParameter("cn", s);
        return ((EventCallbackHandler) (obj1));
        s;
_L2:
        logger.warn(s.getMessage());
        return null;
        s;
        if (true) goto _L2; else goto _L1
_L1:
        return null;
    }

    public EventCallback fetchEventCallback(String s, String s1, boolean flag)
    {
        Object obj = null;
        EventCallback eventcallback = null;
        Iterator iterator = eventCallbacks.iterator();
        do
        {
label0:
            {
                EventCallback eventcallback1 = obj;
                if (iterator.hasNext())
                {
                    eventcallback1 = (EventCallback)iterator.next();
                    if (!eventcallback1.name.equals(s) || !eventcallback1.type.equals(s1))
                    {
                        break label0;
                    }
                }
                if (eventcallback1 != null)
                {
                    return eventcallback1;
                } else
                {
                    return eventcallback;
                }
            }
            if (flag && eventcallback1.type.equals("GENERIC"))
            {
                eventcallback = eventcallback1;
            }
        } while (true);
    }

    public void parseEventCallbacks(Element element)
    {
        element = element.getChildNodes();
        for (int i = 0; i < element.getLength(); i++)
        {
            Node node = element.item(i);
            if (node.getNodeType() == 1 && node.getNodeName().equals("eventCallback"))
            {
                EventCallback eventcallback = new EventCallback(context);
                eventcallback.parse((Element)node);
                eventCallbacks.add(eventcallback);
            }
        }

    }
}
