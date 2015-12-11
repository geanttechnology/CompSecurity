// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.ssdp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.MulticastSocket;
import java.net.NetworkInterface;
import java.util.Enumeration;
import org.cybergarage.http.HTTPRequest;
import org.cybergarage.upnp.UPnP;
import org.cybergarage.util.Debug;

// Referenced classes of package org.cybergarage.upnp.ssdp:
//            SSDPPacket

public class HTTPMUSocket
{

    private InetSocketAddress ssdpMultiGroup;
    private NetworkInterface ssdpMultiIf;
    private MulticastSocket ssdpMultiSock;

    public HTTPMUSocket()
    {
        ssdpMultiGroup = null;
        ssdpMultiSock = null;
        ssdpMultiIf = null;
    }

    public HTTPMUSocket(String s, int i, String s1)
    {
        ssdpMultiGroup = null;
        ssdpMultiSock = null;
        ssdpMultiIf = null;
        open(s, i, s1);
    }

    public boolean close()
    {
        if (ssdpMultiSock == null)
        {
            return true;
        }
        try
        {
            ssdpMultiSock.leaveGroup(ssdpMultiGroup, ssdpMultiIf);
            ssdpMultiSock.close();
            ssdpMultiSock = null;
        }
        catch (Exception exception)
        {
            return false;
        }
        return true;
    }

    protected void finalize()
    {
        close();
    }

    public String getLocalAddress()
    {
        if (ssdpMultiGroup == null || ssdpMultiIf == null)
        {
            return "";
        }
        InetAddress inetaddress = ssdpMultiGroup.getAddress();
        Enumeration enumeration = ssdpMultiIf.getInetAddresses();
        InetAddress inetaddress1;
        do
        {
            if (!enumeration.hasMoreElements())
            {
                return "";
            }
            inetaddress1 = (InetAddress)enumeration.nextElement();
            if ((inetaddress instanceof Inet6Address) && (inetaddress1 instanceof Inet6Address))
            {
                return inetaddress1.getHostAddress();
            }
        } while (!(inetaddress instanceof Inet4Address) || !(inetaddress1 instanceof Inet4Address));
        return inetaddress1.getHostAddress();
    }

    public int getLocalPort()
    {
        return ssdpMultiSock.getLocalPort();
    }

    public String getMulticastAddress()
    {
        return getMulticastInetAddress().getHostAddress();
    }

    public InetAddress getMulticastInetAddress()
    {
        return ssdpMultiGroup.getAddress();
    }

    public int getMulticastPort()
    {
        return ssdpMultiGroup.getPort();
    }

    public MulticastSocket getSocket()
    {
        return ssdpMultiSock;
    }

    public boolean open(String s, int i, String s1)
    {
        boolean flag;
        try
        {
            flag = open(s, i, InetAddress.getByName(s1));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Debug.warning(s);
            return false;
        }
        return flag;
    }

    public boolean open(String s, int i, InetAddress inetaddress)
    {
        try
        {
            ssdpMultiSock = new MulticastSocket(null);
            ssdpMultiSock.setReuseAddress(true);
            InetSocketAddress inetsocketaddress = new InetSocketAddress(i);
            ssdpMultiSock.bind(inetsocketaddress);
            ssdpMultiGroup = new InetSocketAddress(InetAddress.getByName(s), i);
            ssdpMultiIf = NetworkInterface.getByInetAddress(inetaddress);
            ssdpMultiSock.joinGroup(ssdpMultiGroup, ssdpMultiIf);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Debug.warning(s);
            return false;
        }
        return true;
    }

    public boolean post(HTTPRequest httprequest)
    {
        return send(httprequest.toString(), null, -1);
    }

    public boolean post(HTTPRequest httprequest, String s, int i)
    {
        return send(httprequest.toString(), s, i);
    }

    public SSDPPacket receive()
        throws IOException
    {
        byte abyte0[] = new byte[1024];
        SSDPPacket ssdppacket = new SSDPPacket(abyte0, abyte0.length);
        ssdppacket.setLocalAddress(getLocalAddress());
        if (ssdpMultiSock != null)
        {
            ssdpMultiSock.receive(ssdppacket.getDatagramPacket());
            ssdppacket.setTimeStamp(System.currentTimeMillis());
            return ssdppacket;
        } else
        {
            throw new IOException("Multicast socket has already been closed.");
        }
    }

    public boolean send(String s)
    {
        return send(s, null, -1);
    }

    public boolean send(String s, String s1, int i)
    {
        if (s1 == null || i <= 0)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        MulticastSocket multicastsocket;
        try
        {
            multicastsocket = new MulticastSocket(null);
            multicastsocket.bind(new InetSocketAddress(s1, i));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Debug.warning(s);
            return false;
        }
        s1 = multicastsocket;
        s = new DatagramPacket(s.getBytes(), s.length(), ssdpMultiGroup);
        s1.setTimeToLive(UPnP.getTimeToLive());
        s1.send(s);
        s1.close();
        return true;
        s1 = new MulticastSocket();
        break MISSING_BLOCK_LABEL_35;
    }
}
