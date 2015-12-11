// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.ssdp;


// Referenced classes of package org.cybergarage.upnp.ssdp:
//            SSDPRequest

public class SSDPNotifyRequest extends SSDPRequest
{

    public SSDPNotifyRequest()
    {
        setMethod("NOTIFY");
        setURI("*");
    }
}
