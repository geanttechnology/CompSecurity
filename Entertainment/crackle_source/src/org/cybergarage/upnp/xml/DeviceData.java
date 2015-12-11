// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.xml;

import java.io.File;
import java.net.InetAddress;
import org.cybergarage.http.HTTPServerList;
import org.cybergarage.upnp.device.Advertiser;
import org.cybergarage.upnp.ssdp.SSDP;
import org.cybergarage.upnp.ssdp.SSDPPacket;
import org.cybergarage.upnp.ssdp.SSDPSearchSocketList;
import org.cybergarage.util.ListenerList;

// Referenced classes of package org.cybergarage.upnp.xml:
//            NodeData

public class DeviceData extends NodeData
{

    private Advertiser advertiser;
    private ListenerList controlActionListenerList;
    private File descriptionFile;
    private String descriptionURI;
    private InetAddress httpBinds[];
    private int httpPort;
    private HTTPServerList httpServerList;
    private int leaseTime;
    private String location;
    private InetAddress ssdpBinds[];
    private String ssdpMulticastIPv4;
    private String ssdpMulticastIPv6;
    private SSDPPacket ssdpPacket;
    private int ssdpPort;
    private SSDPSearchSocketList ssdpSearchSocketList;

    public DeviceData()
    {
        descriptionURI = null;
        descriptionFile = null;
        location = "";
        leaseTime = 1800;
        httpServerList = null;
        httpBinds = null;
        httpPort = 4004;
        controlActionListenerList = new ListenerList();
        ssdpSearchSocketList = null;
        ssdpMulticastIPv4 = "239.255.255.250";
        ssdpMulticastIPv6 = SSDP.getIPv6Address();
        ssdpPort = 1900;
        ssdpBinds = null;
        ssdpPacket = null;
        advertiser = null;
    }

    public Advertiser getAdvertiser()
    {
        return advertiser;
    }

    public ListenerList getControlActionListenerList()
    {
        return controlActionListenerList;
    }

    public File getDescriptionFile()
    {
        return descriptionFile;
    }

    public String getDescriptionURI()
    {
        return descriptionURI;
    }

    public InetAddress[] getHTTPBindAddress()
    {
        return httpBinds;
    }

    public int getHTTPPort()
    {
        return httpPort;
    }

    public HTTPServerList getHTTPServerList()
    {
        if (httpServerList == null)
        {
            httpServerList = new HTTPServerList(httpBinds, httpPort);
        }
        return httpServerList;
    }

    public int getLeaseTime()
    {
        return leaseTime;
    }

    public String getLocation()
    {
        return location;
    }

    public String getMulticastIPv4Address()
    {
        return ssdpMulticastIPv4;
    }

    public String getMulticastIPv6Address()
    {
        return ssdpMulticastIPv6;
    }

    public InetAddress[] getSSDPBindAddress()
    {
        return ssdpBinds;
    }

    public SSDPPacket getSSDPPacket()
    {
        return ssdpPacket;
    }

    public int getSSDPPort()
    {
        return ssdpPort;
    }

    public SSDPSearchSocketList getSSDPSearchSocketList()
    {
        if (ssdpSearchSocketList == null)
        {
            ssdpSearchSocketList = new SSDPSearchSocketList(ssdpBinds, ssdpPort, ssdpMulticastIPv4, ssdpMulticastIPv6);
        }
        return ssdpSearchSocketList;
    }

    public void setAdvertiser(Advertiser advertiser1)
    {
        advertiser = advertiser1;
    }

    public void setDescriptionFile(File file)
    {
        descriptionFile = file;
    }

    public void setDescriptionURI(String s)
    {
        descriptionURI = s;
    }

    public void setHTTPBindAddress(InetAddress ainetaddress[])
    {
        httpBinds = ainetaddress;
    }

    public void setHTTPPort(int i)
    {
        httpPort = i;
    }

    public void setLeaseTime(int i)
    {
        leaseTime = i;
    }

    public void setLocation(String s)
    {
        location = s;
    }

    public void setMulticastIPv4Address(String s)
    {
        ssdpMulticastIPv4 = s;
    }

    public void setMulticastIPv6Address(String s)
    {
        ssdpMulticastIPv6 = s;
    }

    public void setSSDPBindAddress(InetAddress ainetaddress[])
    {
        ssdpBinds = ainetaddress;
    }

    public void setSSDPPacket(SSDPPacket ssdppacket)
    {
        ssdpPacket = ssdppacket;
    }

    public void setSSDPPort(int i)
    {
        ssdpPort = i;
    }
}
