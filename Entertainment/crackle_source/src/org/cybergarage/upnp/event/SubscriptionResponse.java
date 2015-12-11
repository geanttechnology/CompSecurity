// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.event;

import org.cybergarage.http.HTTPResponse;
import org.cybergarage.upnp.UPnP;

// Referenced classes of package org.cybergarage.upnp.event:
//            Subscription

public class SubscriptionResponse extends HTTPResponse
{

    public SubscriptionResponse()
    {
        setServer(UPnP.getServerName());
    }

    public SubscriptionResponse(HTTPResponse httpresponse)
    {
        super(httpresponse);
    }

    public String getSID()
    {
        return Subscription.getSID(getHeaderValue("SID"));
    }

    public long getTimeout()
    {
        return Subscription.getTimeout(getHeaderValue("TIMEOUT"));
    }

    public void setErrorResponse(int i)
    {
        setStatusCode(i);
        setContentLength(0L);
    }

    public void setResponse(int i)
    {
        setStatusCode(i);
        setContentLength(0L);
    }

    public void setSID(String s)
    {
        setHeader("SID", Subscription.toSIDHeaderString(s));
    }

    public void setTimeout(long l)
    {
        setHeader("TIMEOUT", Subscription.toTimeoutHeaderString(l));
    }
}
