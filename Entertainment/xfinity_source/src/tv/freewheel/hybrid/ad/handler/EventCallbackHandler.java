// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package tv.freewheel.hybrid.ad.handler;

import android.net.Uri;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import tv.freewheel.hybrid.ad.AdContext;
import tv.freewheel.hybrid.ad.AdInstance;
import tv.freewheel.hybrid.ad.CreativeRendition;
import tv.freewheel.hybrid.ad.EventCallback;
import tv.freewheel.hybrid.utils.Logger;
import tv.freewheel.hybrid.utils.URLLoader;
import tv.freewheel.hybrid.utils.URLRequest;

public class EventCallbackHandler
{

    protected AdInstance adInstance;
    private String baseUrl;
    private String cachedUrl;
    private EventCallback callback;
    private String crValue;
    private ArrayList externalTrackingURLs;
    private String internalUrl;
    private ArrayList keys;
    protected Logger logger;
    private ArrayList originalKeys;
    private HashMap originalParameterPairs;
    private HashMap parameterPairs;
    protected boolean trackingUrlSend;

    public EventCallbackHandler(EventCallback eventcallback)
        throws MalformedURLException
    {
        trackingUrlSend = false;
        adInstance = null;
        if (eventcallback == null)
        {
            throw new MalformedURLException("callback object is null");
        } else
        {
            logger = Logger.getLogger(this);
            callback = eventcallback;
            keys = new ArrayList();
            originalKeys = new ArrayList();
            parameterPairs = new HashMap();
            originalParameterPairs = new HashMap();
            externalTrackingURLs = new ArrayList();
            parseCallbackUrl(eventcallback.url);
            originalKeys.addAll(keys);
            originalParameterPairs.putAll(parameterPairs);
            return;
        }
    }

    private void parseCallbackUrl(String s)
        throws MalformedURLException
    {
        if (s == null || s.length() == 0)
        {
            throw new MalformedURLException("url is empty");
        }
        cachedUrl = s;
        URL url = new URL(s);
        String as[];
        try
        {
            as = url.getQuery().split("&");
            baseUrl = s.split("\\?")[0];
        }
        catch (NullPointerException nullpointerexception)
        {
            String as1[] = new String[0];
            baseUrl = s;
            s = as1;
            continue;
        }
        s = as;
        do
        {
            int i = 0;
            do
            {
                if (i >= s.length)
                {
                    break;
                }
                String as2[] = s[i].split("=");
                if (as2.length == 0 || as2.length > 2 || as2[0].length() == 0)
                {
                    throw new MalformedURLException("invalid format in query string");
                }
                String s2 = Uri.decode(as2[0]);
                String s1 = "";
                if (as2.length == 2)
                {
                    s1 = Uri.decode(as2[1]);
                }
                if (s2.equals("cr"))
                {
                    crValue = s1.trim();
                } else
                {
                    keys.add(s2);
                    parameterPairs.put(s2, s1);
                }
                i++;
            } while (true);
            return;
        } while (true);
    }

    public void addExternalTrackingURLs(ArrayList arraylist)
    {
        logger.info((new StringBuilder()).append(this).append(" addExternalTrackingURLs ").append(arraylist).toString());
        externalTrackingURLs.removeAll(arraylist);
        externalTrackingURLs.addAll(arraylist);
    }

    public String getCallbackUrl()
    {
        if (cachedUrl == null)
        {
            cachedUrl = (new StringBuilder()).append(baseUrl).append("?").toString();
            Iterator iterator = keys.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s1 = (String)iterator.next();
                String s = (String)parameterPairs.get(s1);
                s1 = Uri.encode(s1);
                if (s != null)
                {
                    cachedUrl = (new StringBuilder()).append(cachedUrl).append(s1).append("=").append(Uri.encode(s)).toString();
                } else
                {
                    cachedUrl = (new StringBuilder()).append(cachedUrl).append(s1).toString();
                }
                if (iterator.hasNext())
                {
                    cachedUrl = (new StringBuilder()).append(cachedUrl).append("&").toString();
                }
            } while (true);
            if (crValue != null)
            {
                cachedUrl = (new StringBuilder()).append(cachedUrl).append("&cr=").append(Uri.encode(crValue)).toString();
            }
        }
        return cachedUrl;
    }

    public ArrayList getExternalTrackingURLs()
    {
        return externalTrackingURLs;
    }

    public String getInternalUrl()
    {
        if (internalUrl == null)
        {
            internalUrl = (new StringBuilder()).append(baseUrl).append("?").toString();
            if (!originalKeys.contains("et"))
            {
                originalKeys.add(0, "et");
            }
            if (!originalKeys.contains("cn"))
            {
                originalKeys.add(0, "cn");
            }
            originalParameterPairs.put("cn", getUrlParameter("cn"));
            originalParameterPairs.put("et", getUrlParameter("et"));
            Iterator iterator = originalKeys.iterator();
            do
            {
                if (!iterator.hasNext())
                {
                    break;
                }
                String s1 = (String)iterator.next();
                String s = (String)originalParameterPairs.get(s1);
                s1 = Uri.encode(s1);
                if (s != null)
                {
                    internalUrl = (new StringBuilder()).append(internalUrl).append(s1).append("=").append(Uri.encode(s)).toString();
                } else
                {
                    internalUrl = (new StringBuilder()).append(internalUrl).append(s1).toString();
                }
                if (iterator.hasNext())
                {
                    internalUrl = (new StringBuilder()).append(internalUrl).append("&").toString();
                }
            } while (true);
            if (crValue != null)
            {
                internalUrl = (new StringBuilder()).append(internalUrl).append("&cr=").append(Uri.encode(crValue)).toString();
            }
        }
        return internalUrl;
    }

    public ArrayList getTrackingURLs()
    {
        ArrayList arraylist = new ArrayList();
        arraylist.addAll(callback.trackingURLs);
        arraylist.addAll(externalTrackingURLs);
        return arraylist;
    }

    public String getUrlParameter(String s)
    {
        if (s.equals("cr"))
        {
            return crValue;
        } else
        {
            return (String)parameterPairs.get(s);
        }
    }

    public boolean isShowBrowser()
    {
        return callback.showBrowser;
    }

    public void send()
    {
        if (adInstance != null && adInstance.getActiveCreativeRendition() != null)
        {
            setParameter("reid", String.valueOf(adInstance.getActiveCreativeRendition().creativeRenditionId));
        }
        sendRequest(getCallbackUrl());
    }

    protected void sendRequest(String s)
    {
        logger.info((new StringBuilder()).append("will send callback: ").append(s).toString());
        s = new URLRequest(s, callback.getAdContext().getUserAgent());
        s.method = 1;
        s.contentType = "text/plain";
        (new URLLoader()).load(s);
    }

    public void sendTrackingCallback()
    {
        Object obj = getTrackingURLs();
        if (((ArrayList) (obj)).size() > 0)
        {
            for (obj = ((ArrayList) (obj)).iterator(); ((Iterator) (obj)).hasNext(); sendRequest((String)((Iterator) (obj)).next())) { }
        }
    }

    public void setAdInstance(AdInstance adinstance)
    {
        adInstance = adinstance;
    }

    public void setParameter(String s, String s1)
    {
        if (s != null && s.length() != 0)
        {
            if (s.equals("cr"))
            {
                if (s1 != null)
                {
                    crValue = s1;
                    cachedUrl = null;
                    internalUrl = null;
                    return;
                }
            } else
            {
                if (!keys.contains(s))
                {
                    keys.add(0, s);
                }
                parameterPairs.put(s, s1);
                cachedUrl = null;
                internalUrl = null;
                return;
            }
        }
    }

    public void setShowBrowserValue(boolean flag)
    {
        callback.showBrowser = flag;
    }
}
