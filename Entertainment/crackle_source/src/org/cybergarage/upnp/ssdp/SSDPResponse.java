// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.ssdp;

import java.io.InputStream;
import org.cybergarage.http.HTTPResponse;

// Referenced classes of package org.cybergarage.upnp.ssdp:
//            SSDP

public class SSDPResponse extends HTTPResponse
{

    public SSDPResponse()
    {
        setVersion("1.1");
    }

    public SSDPResponse(InputStream inputstream)
    {
        super(inputstream);
    }

    public String getHeader()
    {
        StringBuffer stringbuffer = new StringBuffer();
        stringbuffer.append(getStatusLineString());
        stringbuffer.append(getHeaderString());
        stringbuffer.append("\r\n");
        return stringbuffer.toString();
    }

    public int getLeaseTime()
    {
        return SSDP.getLeaseTime(getHeaderValue("Cache-Control"));
    }

    public String getLocation()
    {
        return getHeaderValue("Location");
    }

    public String getMYNAME()
    {
        return getHeaderValue("MYNAME");
    }

    public String getST()
    {
        return getHeaderValue("ST");
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

    public void setMYNAME(String s)
    {
        setHeader("MYNAME", s);
    }

    public void setST(String s)
    {
        setHeader("ST", s);
    }

    public void setUSN(String s)
    {
        setHeader("USN", s);
    }
}
