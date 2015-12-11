// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.ssdp;

import org.cybergarage.upnp.UPnP;

// Referenced classes of package org.cybergarage.upnp.ssdp:
//            SSDPResponse

public class SSDPSearchResponse extends SSDPResponse
{

    public SSDPSearchResponse()
    {
        setStatusCode(200);
        setCacheControl(1800);
        setHeader("Server", UPnP.getServerName());
        setHeader("EXT", "");
    }
}
