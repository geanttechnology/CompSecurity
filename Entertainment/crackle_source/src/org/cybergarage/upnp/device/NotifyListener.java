// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.device;

import org.cybergarage.upnp.ssdp.SSDPPacket;

public interface NotifyListener
{

    public abstract void deviceNotifyReceived(SSDPPacket ssdppacket);
}
