// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.event;

import org.cybergarage.http.HTTP;
import org.cybergarage.http.HTTPRequest;
import org.cybergarage.upnp.Device;
import org.cybergarage.upnp.Service;

// Referenced classes of package org.cybergarage.upnp.event:
//            Subscription, SubscriptionResponse

public class SubscriptionRequest extends HTTPRequest
{

    private static final String CALLBACK_END_WITH = ">";
    private static final String CALLBACK_START_WITH = "<";

    public SubscriptionRequest()
    {
        setContentLength(0L);
    }

    public SubscriptionRequest(HTTPRequest httprequest)
    {
        this();
        set(httprequest);
    }

    private void setService(Service service)
    {
        Object obj;
        String s2;
label0:
        {
            s2 = service.getEventSubURL();
            setURI(s2, true);
            String s = "";
            obj = service.getDevice();
            if (obj != null)
            {
                s = ((Device) (obj)).getURLBase();
            }
            if (s != null)
            {
                obj = s;
                if (s.length() > 0)
                {
                    break label0;
                }
            }
            Device device = service.getRootDevice();
            obj = s;
            if (device != null)
            {
                obj = device.getURLBase();
            }
        }
        String s1;
label1:
        {
            if (obj != null)
            {
                s1 = ((String) (obj));
                if (((String) (obj)).length() > 0)
                {
                    break label1;
                }
            }
            service = service.getRootDevice();
            s1 = ((String) (obj));
            if (service != null)
            {
                s1 = service.getLocation();
            }
        }
label2:
        {
            if (s1 != null)
            {
                service = s1;
                if (s1.length() > 0)
                {
                    break label2;
                }
            }
            service = s1;
            if (HTTP.isAbsoluteURL(s2))
            {
                service = s2;
            }
        }
        obj = HTTP.getHost(service);
        int i = HTTP.getPort(service);
        setHost(((String) (obj)), i);
        setRequestHost(((String) (obj)));
        setRequestPort(i);
    }

    public String getCallback()
    {
        return getStringHeaderValue("CALLBACK", "<", ">");
    }

    public String getNT()
    {
        return getHeaderValue("NT");
    }

    public String getSID()
    {
        String s1 = Subscription.getSID(getHeaderValue("SID"));
        String s = s1;
        if (s1 == null)
        {
            s = "";
        }
        return s;
    }

    public long getTimeout()
    {
        return Subscription.getTimeout(getHeaderValue("TIMEOUT"));
    }

    public boolean hasCallback()
    {
        String s = getCallback();
        return s != null && s.length() > 0;
    }

    public boolean hasNT()
    {
        String s = getNT();
        return s != null && s.length() > 0;
    }

    public boolean hasSID()
    {
        String s = getSID();
        return s != null && s.length() > 0;
    }

    public SubscriptionResponse post()
    {
        return new SubscriptionResponse(post(getRequestHost(), getRequestPort()));
    }

    public void post(SubscriptionResponse subscriptionresponse)
    {
        super.post(subscriptionresponse);
    }

    public void setCallback(String s)
    {
        setStringHeader("CALLBACK", s, "<", ">");
    }

    public void setNT(String s)
    {
        setHeader("NT", s);
    }

    public void setRenewRequest(Service service, String s, long l)
    {
        setMethod("SUBSCRIBE");
        setService(service);
        setSID(s);
        setTimeout(l);
    }

    public void setSID(String s)
    {
        setHeader("SID", Subscription.toSIDHeaderString(s));
    }

    public void setSubscribeRequest(Service service, String s, long l)
    {
        setMethod("SUBSCRIBE");
        setService(service);
        setCallback(s);
        setNT("upnp:event");
        setTimeout(l);
    }

    public final void setTimeout(long l)
    {
        setHeader("TIMEOUT", Subscription.toTimeoutHeaderString(l));
    }

    public void setUnsubscribeRequest(Service service)
    {
        setMethod("UNSUBSCRIBE");
        setService(service);
        setSID(service.getSID());
    }
}
