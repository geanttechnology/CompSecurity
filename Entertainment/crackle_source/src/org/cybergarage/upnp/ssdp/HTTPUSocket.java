// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.ssdp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import org.cybergarage.util.Debug;

// Referenced classes of package org.cybergarage.upnp.ssdp:
//            SSDPPacket

public class HTTPUSocket
{

    private String localAddr;
    private DatagramSocket ssdpUniSock;

    public HTTPUSocket()
    {
        ssdpUniSock = null;
        localAddr = "";
        open();
    }

    public HTTPUSocket(int i)
    {
        ssdpUniSock = null;
        localAddr = "";
        open(i);
    }

    public HTTPUSocket(String s, int i)
    {
        ssdpUniSock = null;
        localAddr = "";
        open(s, i);
    }

    public boolean close()
    {
        if (ssdpUniSock == null)
        {
            return true;
        }
        try
        {
            ssdpUniSock.close();
            ssdpUniSock = null;
        }
        catch (Exception exception)
        {
            Debug.warning(exception);
            return false;
        }
        return true;
    }

    protected void finalize()
    {
        close();
    }

    public DatagramSocket getDatagramSocket()
    {
        return ssdpUniSock;
    }

    public String getLocalAddress()
    {
        if (localAddr.length() > 0)
        {
            return localAddr;
        } else
        {
            return ssdpUniSock.getLocalAddress().getHostAddress();
        }
    }

    public DatagramSocket getUDPSocket()
    {
        return ssdpUniSock;
    }

    public boolean open()
    {
        close();
        try
        {
            ssdpUniSock = new DatagramSocket();
        }
        catch (Exception exception)
        {
            Debug.warning(exception);
            return false;
        }
        return true;
    }

    public boolean open(int i)
    {
        close();
        try
        {
            InetSocketAddress inetsocketaddress = new InetSocketAddress(i);
            ssdpUniSock = new DatagramSocket(null);
            ssdpUniSock.setReuseAddress(true);
            ssdpUniSock.bind(inetsocketaddress);
        }
        catch (Exception exception)
        {
            return false;
        }
        return true;
    }

    public boolean open(String s, int i)
    {
        close();
        try
        {
            ssdpUniSock = new DatagramSocket(new InetSocketAddress(InetAddress.getByName(s), i));
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Debug.warning(s);
            return false;
        }
        setLocalAddress(s);
        return true;
    }

    public boolean post(String s, int i, String s1)
    {
        try
        {
            s = InetAddress.getByName(s);
            s = new DatagramPacket(s1.getBytes(), s1.length(), s, i);
            ssdpUniSock.send(s);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            Debug.warning((new StringBuilder("addr = ")).append(ssdpUniSock.getLocalAddress().getHostName()).toString());
            Debug.warning((new StringBuilder("port = ")).append(ssdpUniSock.getLocalPort()).toString());
            Debug.warning(s);
            return false;
        }
        return true;
    }

    public SSDPPacket receive()
    {
        byte abyte0[] = new byte[1024];
        SSDPPacket ssdppacket = new SSDPPacket(abyte0, abyte0.length);
        ssdppacket.setLocalAddress(getLocalAddress());
        try
        {
            ssdpUniSock.receive(ssdppacket.getDatagramPacket());
            ssdppacket.setTimeStamp(System.currentTimeMillis());
        }
        catch (Exception exception)
        {
            return null;
        }
        return ssdppacket;
    }

    public void setLocalAddress(String s)
    {
        localAddr = s;
    }
}
