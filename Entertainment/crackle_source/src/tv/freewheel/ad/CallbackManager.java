// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import tv.freewheel.ad.handler.AdImpressionCallbackHandler;
import tv.freewheel.ad.handler.ClickCallbackHandler;
import tv.freewheel.ad.handler.ErrorCallbackHandler;
import tv.freewheel.ad.handler.EventCallbackHandler;
import tv.freewheel.ad.handler.QuartileCallbackHandler;
import tv.freewheel.ad.handler.ResellerNoAdCallbackHandler;
import tv.freewheel.ad.handler.StandardCallbackHandler;
import tv.freewheel.utils.Logger;
import tv.freewheel.utils.RecordTimer;

// Referenced classes of package tv.freewheel.ad:
//            AdInstance, EventCallback, AdContext, InternalConstants

public class CallbackManager
{

    private AdInstance adInstance;
    public ClickCallbackHandler defaultClickHandler;
    public AdImpressionCallbackHandler defaultImpressionHandler;
    public ErrorCallbackHandler errorHandler;
    private HashMap handlers;
    protected Logger logger;
    private RecordTimer timer;

    public CallbackManager(AdInstance adinstance)
    {
        adInstance = adinstance;
        handlers = new HashMap();
        logger = Logger.getLogger(this);
    }

    private EventCallbackHandler getHandlerFromResponse(String s, String s1)
    {
        EventCallbackHandler eventcallbackhandler = null;
        Iterator iterator = adInstance.eventCallbacks.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            EventCallback eventcallback = (EventCallback)iterator.next();
            if (eventcallback.name.equals(s) && eventcallback.type.equals(s1))
            {
                eventcallbackhandler = adInstance.createEventHandler(eventcallback.name, eventcallback.type, false);
            }
        } while (true);
        return eventcallbackhandler;
    }

    public void addEventCallbackHandler(String s, String s1, EventCallbackHandler eventcallbackhandler)
    {
        String s2 = (new StringBuilder()).append(s).append(":").append(s1).toString();
        if (!handlers.containsKey(s2))
        {
            handlers.put((new StringBuilder()).append(s).append(":").append(s1).toString(), eventcallbackhandler);
        }
    }

    public void callback(String s)
    {
        callback(s, new Bundle());
    }

    public void callback(String s, Bundle bundle)
    {
        logger.debug((new StringBuilder()).append("callback(").append(s).append(",").append(bundle).append(")").toString());
        String s1 = EventCallback.getEventTypeByName(s);
        if (s.equals("firstQuartile") || s.equals("midPoint") || s.equals("thirdQuartile") || s.equals("complete"))
        {
            sendQuartile(s);
        } else
        {
            if (s.equals("resellerNoAd"))
            {
                ((ResellerNoAdCallbackHandler)getEventCallbackHandler(s, s1)).send();
                return;
            }
            if (s1.equals("STANDARD"))
            {
                ((StandardCallbackHandler)getEventCallbackHandler(s, s1)).send();
                return;
            }
            if (s1.equals("CLICKTRACKING"))
            {
                ((ClickCallbackHandler)getEventCallbackHandler(s, s1)).send(bundle);
                return;
            }
        }
    }

    public void copyOtherHandlers(CallbackManager callbackmanager)
    {
        logger.debug("copyOtherHandlers()");
        for (Iterator iterator = callbackmanager.handlers.keySet().iterator(); iterator.hasNext();)
        {
            Object obj = (String)iterator.next();
            String as[] = ((String) (obj)).split(":");
            if (as.length != 2)
            {
                logger.warn((new StringBuilder()).append("get invalid event callback name-value pair:").append(((String) (obj))).toString());
            } else
            {
                String s = as[0];
                String s1 = as[1];
                EventCallbackHandler eventcallbackhandler = getEventCallbackHandler(s, s1);
                obj = (EventCallbackHandler)callbackmanager.handlers.get(obj);
                eventcallbackhandler.addExternalTrackingURLs(((EventCallbackHandler) (obj)).getExternalTrackingURLs());
                if (s1.equals("CLICK"))
                {
                    eventcallbackhandler.setParameter("cr", ((EventCallbackHandler) (obj)).getUrlParameter("cr"));
                }
                if (s.equals("") && s1.equals("ERROR"))
                {
                    errorHandler = (ErrorCallbackHandler)eventcallbackhandler;
                } else
                if (s.equals("defaultImpression") && s1.equals("IMPRESSION"))
                {
                    defaultImpressionHandler = (AdImpressionCallbackHandler)eventcallbackhandler;
                } else
                if (s.equals("defaultClick") && s1.equals("CLICK"))
                {
                    defaultClickHandler = (ClickCallbackHandler)eventcallbackhandler;
                }
                eventcallbackhandler.setAdInstance(adInstance);
            }
        }

    }

    public EventCallbackHandler getEventCallbackHandler(String s, String s1)
    {
        String s2 = s1;
        if (s1.equals("CLICKTRACKING"))
        {
            s2 = "CLICK";
        }
        s1 = (EventCallbackHandler)handlers.get((new StringBuilder()).append(s).append(":").append(s2).toString());
        Object obj = s1;
        if (s1 == null)
        {
            obj = getHandlerFromResponse(s, s2);
            s1 = ((String) (obj));
            if (obj == null)
            {
                boolean flag;
                if (!s.equals("defaultImpression") && (!s2.equals("CLICK") || !s.equals("defaultClick")))
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                s1 = adInstance.createEventHandler(s, s2, flag);
            }
            obj = s1;
            if (s1 != null)
            {
                s1.setAdInstance(adInstance);
                addEventCallbackHandler(s, s2, s1);
                obj = s1;
            }
        }
        return ((EventCallbackHandler) (obj));
    }

    public void init()
    {
        errorHandler = (ErrorCallbackHandler)adInstance.createEventHandler("", "ERROR", true);
        errorHandler.setAdInstance(adInstance);
        addEventCallbackHandler("", "ERROR", errorHandler);
        Iterator iterator = adInstance.eventCallbacks.iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            EventCallback eventcallback = (EventCallback)iterator.next();
            if (eventcallback.name.equals("defaultImpression") && eventcallback.type.equals("IMPRESSION"))
            {
                defaultImpressionHandler = (AdImpressionCallbackHandler)adInstance.createEventHandler(eventcallback.name, eventcallback.type, false);
                defaultImpressionHandler.setAdInstance(adInstance);
                addEventCallbackHandler(eventcallback.name, eventcallback.type, defaultImpressionHandler);
            } else
            if (eventcallback.name.equals("defaultClick") && eventcallback.type.equals("CLICK"))
            {
                defaultClickHandler = (ClickCallbackHandler)adInstance.createEventHandler(eventcallback.name, eventcallback.type, false);
                if (adInstance.context.getActivity() != null && defaultClickHandler != null)
                {
                    defaultClickHandler.setAdInstance(adInstance);
                }
                addEventCallbackHandler(eventcallback.name, eventcallback.type, defaultClickHandler);
            } else
            if (eventcallback.type.equals("IMPRESSION") && (eventcallback.name.equals("firstQuartile") || eventcallback.name.equals("midPoint") || eventcallback.name.equals("thirdQuartile") || eventcallback.name.equals("complete")))
            {
                QuartileCallbackHandler quartilecallbackhandler = (QuartileCallbackHandler)adInstance.createEventHandler(eventcallback.name, eventcallback.type, false);
                quartilecallbackhandler.setAdInstance(adInstance);
                addEventCallbackHandler(eventcallback.name, eventcallback.type, quartilecallbackhandler);
            } else
            if (eventcallback.type.equals("STANDARD"))
            {
                StandardCallbackHandler standardcallbackhandler = (StandardCallbackHandler)adInstance.createEventHandler(eventcallback.name, eventcallback.type, false);
                standardcallbackhandler.setAdInstance(adInstance);
                addEventCallbackHandler(eventcallback.name, eventcallback.type, standardcallbackhandler);
            }
        } while (true);
    }

    public void pause()
    {
        if (timer != null)
        {
            timer.pause();
        }
    }

    public void resume()
    {
        if (timer != null)
        {
            timer.resume();
        }
    }

    public void sendDefaultImpression(boolean flag)
    {
        logger.debug((new StringBuilder()).append("sendDefaultImpression(").append(flag).append(")").toString());
        Bundle bundle = new Bundle();
        bundle.putBoolean("endAck", flag);
        bundle.putInt("metr", adInstance.getMetrValue());
        if (flag)
        {
            if (timer == null)
            {
                return;
            }
            bundle.putLong("ct", timer.tick());
            timer = null;
        } else
        {
            timer = new RecordTimer();
            bundle.putLong("ct", timer.tick());
        }
        if (defaultImpressionHandler != null)
        {
            defaultImpressionHandler.send(bundle);
            return;
        } else
        {
            logger.warn("no default impression callback url");
            return;
        }
    }

    public void sendQuartile(String s)
    {
        Integer integer = (Integer)InternalConstants.METR_MAP.get(s);
        if (integer != null)
        {
            int i = adInstance.getMetrValue();
            if ((integer.intValue() & i) != 0)
            {
                QuartileCallbackHandler quartilecallbackhandler = (QuartileCallbackHandler)getEventCallbackHandler(s, "IMPRESSION");
                if (!quartilecallbackhandler.imprSent)
                {
                    if (timer == null)
                    {
                        logger.warn("Quartile should not be sent before impression, do nothing, there must be bug in the renderer!");
                        return;
                    } else
                    {
                        Bundle bundle = new Bundle();
                        bundle.putLong("ct", timer.tick());
                        bundle.putInt("metr", i);
                        logger.debug((new StringBuilder()).append("sendQuartile(").append(s).append(")").toString());
                        quartilecallbackhandler.send(bundle);
                        return;
                    }
                }
            } else
            {
                logger.error((new StringBuilder()).append("Renderer does not support sending ").append(s).append(", ignore.").toString());
                return;
            }
        }
    }
}
