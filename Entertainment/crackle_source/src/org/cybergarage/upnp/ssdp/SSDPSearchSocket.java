// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.ssdp;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import org.cybergarage.net.HostInterface;
import org.cybergarage.upnp.device.SearchListener;
import org.cybergarage.util.ListenerList;

// Referenced classes of package org.cybergarage.upnp.ssdp:
//            HTTPMUSocket, SSDP, SSDPPacket

public class SSDPSearchSocket extends HTTPMUSocket
    implements Runnable
{

    private ListenerList deviceSearchListenerList;
    private Thread deviceSearchThread;
    private boolean useIPv6Address;

    public SSDPSearchSocket(String s, int i, String s1)
    {
        deviceSearchListenerList = new ListenerList();
        deviceSearchThread = null;
        open(s, s1);
    }

    public SSDPSearchSocket(InetAddress inetaddress)
    {
        deviceSearchListenerList = new ListenerList();
        deviceSearchThread = null;
        if (inetaddress.getAddress().length != 4)
        {
            open((Inet6Address)inetaddress);
            return;
        } else
        {
            open((Inet4Address)inetaddress);
            return;
        }
    }

    public void addSearchListener(SearchListener searchlistener)
    {
        deviceSearchListenerList.add(searchlistener);
    }

    public boolean open(String s)
    {
        String s1 = "239.255.255.250";
        useIPv6Address = false;
        if (HostInterface.isIPv6Address(s))
        {
            s1 = SSDP.getIPv6Address();
            useIPv6Address = true;
        }
        return open(s1, 1900, s);
    }

    public boolean open(String s, String s1)
    {
        if (HostInterface.isIPv6Address(s) && HostInterface.isIPv6Address(s1))
        {
            useIPv6Address = true;
        } else
        if (HostInterface.isIPv4Address(s) && HostInterface.isIPv4Address(s1))
        {
            useIPv6Address = false;
        } else
        {
            throw new IllegalArgumentException("Cannot open a UDP Socket for IPv6 address on IPv4 interface or viceversa");
        }
        return open(s1, 1900, s);
    }

    public boolean open(Inet4Address inet4address)
    {
        useIPv6Address = false;
        return open("239.255.255.250", 1900, ((InetAddress) (inet4address)));
    }

    public boolean open(Inet6Address inet6address)
    {
        useIPv6Address = true;
        return open(SSDP.getIPv6Address(), 1900, ((InetAddress) (inet6address)));
    }

    public void performSearchListener(SSDPPacket ssdppacket)
    {
        int j = deviceSearchListenerList.size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            ((SearchListener)deviceSearchListenerList.get(i)).deviceSearchReceived(ssdppacket);
            i++;
        } while (true);
    }

    public void removeSearchListener(SearchListener searchlistener)
    {
        deviceSearchListenerList.remove(searchlistener);
    }

    public void run()
    {
        Thread thread = Thread.currentThread();
        do
        {
            do
            {
                if (deviceSearchThread != thread)
                {
                    return;
                }
                Thread.yield();
                SSDPPacket ssdppacket;
                try
                {
                    ssdppacket = receive();
                }
                catch (IOException ioexception)
                {
                    return;
                }
            } while (ssdppacket == null || !ssdppacket.isDiscover());
            performSearchListener(ssdppacket);
        } while (true);
    }

    public void start()
    {
        StringBuffer stringbuffer = new StringBuffer("Cyber.SSDPSearchSocket/");
        String s = getLocalAddress();
        if (s != null && s.length() > 0)
        {
            stringbuffer.append(getLocalAddress()).append(':');
            stringbuffer.append(getLocalPort()).append(" -> ");
            stringbuffer.append(getMulticastAddress()).append(':');
            stringbuffer.append(getMulticastPort());
        }
        deviceSearchThread = new Thread(this, stringbuffer.toString());
        deviceSearchThread.start();
    }

    public void stop()
    {
        close();
        deviceSearchThread = null;
    }
}
