// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.ad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// Referenced classes of package tv.freewheel.ad:
//            AdContextScoped, AdContext

public class EventCallback extends AdContextScoped
{

    public static final String EVENT_TYPES[] = {
        "CLICK", "CLICKTRACKING", "IMPRESSION", "STANDARD"
    };
    public static final String SHORT_EVENT_TYPES[] = {
        "c", "c", "i", "s"
    };
    public static final String VALID_ERROR_EVENT_NAMES[] = {
        "_e_adinst-unavail", "_e_invalid-value", "_e_io", "_e_missing-param", "_e_no-ad", "_e_no-renderer", "_e_null-asset", "_e_parse", "_e_renderer-load", "_e_timeout", 
        "_e_unknown", ""
    };
    public static final String VALID_IMPRESSION_EVENT_NAMES[] = {
        "defaultImpression", "firstQuartile", "midPoint", "thirdQuartile", "complete", "resellerNoAd"
    };
    public static final String VALID_STANDARD_EVENT_NAMES[] = {
        "_pause", "_resume", "_rewind", "_mute", "_un-mute", "_collapse", "_expand", "_minimize", "_close", "_accept-invitation"
    };
    public String name;
    public boolean showBrowser;
    public ArrayList trackingURLs;
    public String type;
    public String url;
    public String usage;

    public EventCallback(AdContext adcontext)
    {
        super(adcontext);
        showBrowser = false;
        trackingURLs = new ArrayList();
    }

    public static String getEventTypeByName(String s)
    {
        String s1 = "CLICKTRACKING";
        if (Arrays.asList(VALID_IMPRESSION_EVENT_NAMES).indexOf(s) > -1)
        {
            s1 = "IMPRESSION";
        } else
        {
            if (Arrays.asList(VALID_STANDARD_EVENT_NAMES).indexOf(s) > -1)
            {
                return "STANDARD";
            }
            if (Arrays.asList(VALID_ERROR_EVENT_NAMES).indexOf(s) > -1)
            {
                return "ERROR";
            }
        }
        return s1;
    }

    public static final String getShortenedEventType(String s)
    {
        int i = Arrays.asList(EVENT_TYPES).indexOf(s);
        if (i > -1)
        {
            return SHORT_EVENT_TYPES[i];
        } else
        {
            return null;
        }
    }

    private void parseTrackingUrl(Element element)
    {
        element = element.getChildNodes();
        for (int i = 0; i < element.getLength(); i++)
        {
            Object obj = element.item(i);
            if (((Node) (obj)).getNodeType() == 1 && ((Node) (obj)).getNodeName().equals("url"))
            {
                obj = (Element)obj;
                trackingURLs.add(((Element) (obj)).getAttribute("value"));
            }
        }

    }

    public static ArrayList validate(String s, String s1, ArrayList arraylist)
    {
        ArrayList arraylist1 = new ArrayList();
        if (s1 == null || s1.equals(""))
        {
            arraylist1.add("eventType is empty.");
        }
        if (arraylist == null || arraylist.size() == 0)
        {
            arraylist1.add("URLs is empty.");
        }
        if (!getEventTypeByName(s).equals(s1))
        {
            arraylist1.add((new StringBuilder()).append("Not a valid combination: eventName is ").append(s).append(" and eventType is ").append(s1).toString());
        }
        return arraylist1;
    }

    public EventCallback cloneForTranslation()
    {
        EventCallback eventcallback = new EventCallback(context);
        eventcallback.usage = usage;
        eventcallback.type = type;
        eventcallback.name = name;
        eventcallback.url = url;
        eventcallback.showBrowser = showBrowser;
        eventcallback.trackingURLs.addAll(trackingURLs);
        return eventcallback;
    }

    public void parse(Element element)
    {
        usage = element.getAttribute("use");
        type = element.getAttribute("type");
        name = element.getAttribute("name");
        url = element.getAttribute("url");
        showBrowser = Boolean.valueOf(element.getAttribute("showBrowser")).booleanValue();
        element = element.getChildNodes();
        for (int i = 0; i < element.getLength(); i++)
        {
            Node node = element.item(i);
            if (node.getNodeType() == 1 && node.getNodeName().equals("trackingURLs"))
            {
                parseTrackingUrl((Element)node);
            }
        }

    }

}
