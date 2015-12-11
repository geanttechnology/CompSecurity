// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.ssdp;

import java.io.IOException;
import java.net.InetAddress;
import org.cybergarage.net.HostInterface;
import org.cybergarage.upnp.ControlPoint;
import org.cybergarage.util.Debug;

// Referenced classes of package org.cybergarage.upnp.ssdp:
//            HTTPMUSocket, SSDP, SSDPNotifyRequest, SSDPPacket

public class SSDPNotifySocket extends HTTPMUSocket
    implements Runnable
{

    private ControlPoint controlPoint;
    private Thread deviceNotifyThread;
    private boolean useIPv6Address;

    public SSDPNotifySocket(String s)
    {
        controlPoint = null;
        deviceNotifyThread = null;
        String s1 = "239.255.255.250";
        useIPv6Address = false;
        if (HostInterface.isIPv6Address(s))
        {
            s1 = SSDP.getIPv6Address();
            useIPv6Address = true;
        }
        open(s1, 1900, s);
        setControlPoint(null);
    }

    public ControlPoint getControlPoint()
    {
        return controlPoint;
    }

    public boolean post(SSDPNotifyRequest ssdpnotifyrequest)
    {
        String s = "239.255.255.250";
        if (useIPv6Address)
        {
            s = SSDP.getIPv6Address();
        }
        ssdpnotifyrequest.setHost(s, 1900);
        return post(((org.cybergarage.http.HTTPRequest) (ssdpnotifyrequest)));
    }

    public void run()
    {
        Thread thread = Thread.currentThread();
        ControlPoint controlpoint = getControlPoint();
        do
        {
            SSDPPacket ssdppacket;
            do
            {
                if (deviceNotifyThread != thread)
                {
                    return;
                }
                Thread.yield();
                InetAddress inetaddress;
                InetAddress inetaddress1;
                try
                {
                    ssdppacket = receive();
                }
                catch (IOException ioexception)
                {
                    return;
                }
            } while (ssdppacket == null);
            inetaddress = getMulticastInetAddress();
            inetaddress1 = ssdppacket.getHostInetAddress();
            if (!inetaddress.equals(inetaddress1))
            {
                Debug.warning((new StringBuilder("Invalidate Multicast Recieved from IP ")).append(inetaddress).append(" on ").append(inetaddress1).toString());
            } else
            if (controlpoint != null)
            {
                controlpoint.notifyReceived(ssdppacket);
            }
        } while (true);
    }

    public void setControlPoint(ControlPoint controlpoint)
    {
        controlPoint = controlpoint;
    }

    public void start()
    {
        StringBuffer stringbuffer = new StringBuffer("Cyber.SSDPNotifySocket/");
        String s = getLocalAddress();
        if (s != null && s.length() > 0)
        {
            stringbuffer.append(getLocalAddress()).append(':');
            stringbuffer.append(getLocalPort()).append(" -> ");
            stringbuffer.append(getMulticastAddress()).append(':');
            stringbuffer.append(getMulticastPort());
        }
        deviceNotifyThread = new Thread(this, stringbuffer.toString());
        deviceNotifyThread.start();
    }

    public void stop()
    {
        close();
        deviceNotifyThread = null;
    }
}
