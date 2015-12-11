// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.ssdp;

import org.cybergarage.net.HostInterface;

// Referenced classes of package org.cybergarage.upnp.ssdp:
//            SSDPRequest, SSDP

public class SSDPSearchRequest extends SSDPRequest
{

    public SSDPSearchRequest()
    {
        this("upnp:rootdevice");
    }

    public SSDPSearchRequest(String s)
    {
        this(s, 3);
    }

    public SSDPSearchRequest(String s, int i)
    {
        setMethod("M-SEARCH");
        setURI("*");
        setHeader("ST", s);
        setHeader("MX", Integer.toString(i));
        setHeader("MAN", "\"ssdp:discover\"");
    }

    public void setLocalAddress(String s)
    {
        String s1 = "239.255.255.250";
        if (HostInterface.isIPv6Address(s))
        {
            s1 = SSDP.getIPv6Address();
        }
        setHost(s1, 1900);
    }
}
