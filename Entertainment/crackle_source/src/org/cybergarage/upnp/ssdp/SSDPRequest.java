// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.ssdp;

import java.io.InputStream;
import org.cybergarage.http.HTTPRequest;

// Referenced classes of package org.cybergarage.upnp.ssdp:
//            SSDP

public class SSDPRequest extends HTTPRequest
{

    public SSDPRequest()
    {
        setVersion("1.1");
    }

    public SSDPRequest(InputStream inputstream)
    {
        super(inputstream);
    }

    public int getLeaseTime()
    {
        return SSDP.getLeaseTime(getHeaderValue("Cache-Control"));
    }

    public String getLocation()
    {
        return getHeaderValue("Location");
    }

    public String getNT()
    {
        return getHeaderValue("NT");
    }

    public String getNTS()
    {
        return getHeaderValue("NTS");
    }

    public String getUSN()
    {
        return getHeaderValue("USN");
    }

    public void setLeaseTime(int i)
    {
        setHeader("Cache-Control", (new StringBuilder("max-age=")).append(Integer.toString(i)).toString());
    }

    public void setLocation(String s)
    {
        setHeader("Location", s);
    }

    public void setNT(String s)
    {
        setHeader("NT", s);
    }

    public void setNTS(String s)
    {
        setHeader("NTS", s);
    }

    public void setUSN(String s)
    {
        setHeader("USN", s);
    }
}
