// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.ssdp;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import org.cybergarage.http.HTTPHeader;
import org.cybergarage.upnp.device.MAN;
import org.cybergarage.upnp.device.NT;
import org.cybergarage.upnp.device.NTS;
import org.cybergarage.upnp.device.ST;
import org.cybergarage.upnp.device.USN;

// Referenced classes of package org.cybergarage.upnp.ssdp:
//            SSDP

public class SSDPPacket
{

    private DatagramPacket dgmPacket;
    private String localAddr;
    public byte packetBytes[];
    private long timeStamp;

    public SSDPPacket(byte abyte0[], int i)
    {
        dgmPacket = null;
        localAddr = "";
        packetBytes = null;
        dgmPacket = new DatagramPacket(abyte0, i);
    }

    public String getCacheControl()
    {
        return HTTPHeader.getValue(getData(), "Cache-Control");
    }

    public byte[] getData()
    {
        if (packetBytes != null)
        {
            return packetBytes;
        } else
        {
            DatagramPacket datagrampacket = getDatagramPacket();
            int i = datagrampacket.getLength();
            packetBytes = (new String(datagrampacket.getData(), 0, i)).getBytes();
            return packetBytes;
        }
    }

    public DatagramPacket getDatagramPacket()
    {
        return dgmPacket;
    }

    public String getHost()
    {
        return HTTPHeader.getValue(getData(), "HOST");
    }

    public InetAddress getHostInetAddress()
    {
        String s1 = "127.0.0.1";
        String s = getHost();
        int i = s.lastIndexOf(":");
        if (i >= 0)
        {
            s1 = s.substring(0, i);
            s = s1;
            if (s1.charAt(0) == '[')
            {
                s = s1.substring(1, s1.length());
            }
            s1 = s;
            if (s.charAt(s.length() - 1) == ']')
            {
                s1 = s.substring(0, s.length() - 1);
            }
        }
        return (new InetSocketAddress(s1, 0)).getAddress();
    }

    public int getLeaseTime()
    {
        return SSDP.getLeaseTime(getCacheControl());
    }

    public String getLocalAddress()
    {
        return localAddr;
    }

    public String getLocation()
    {
        return HTTPHeader.getValue(getData(), "Location");
    }

    public String getMAN()
    {
        return HTTPHeader.getValue(getData(), "MAN");
    }

    public int getMX()
    {
        return HTTPHeader.getIntegerValue(getData(), "MX");
    }

    public String getNT()
    {
        return HTTPHeader.getValue(getData(), "NT");
    }

    public String getNTS()
    {
        return HTTPHeader.getValue(getData(), "NTS");
    }

    public String getRemoteAddress()
    {
        return getDatagramPacket().getAddress().getHostAddress();
    }

    public InetAddress getRemoteInetAddress()
    {
        return getDatagramPacket().getAddress();
    }

    public int getRemotePort()
    {
        return getDatagramPacket().getPort();
    }

    public String getST()
    {
        return HTTPHeader.getValue(getData(), "ST");
    }

    public String getServer()
    {
        return HTTPHeader.getValue(getData(), "Server");
    }

    public long getTimeStamp()
    {
        return timeStamp;
    }

    public String getUSN()
    {
        return HTTPHeader.getValue(getData(), "USN");
    }

    public boolean isAlive()
    {
        return NTS.isAlive(getNTS());
    }

    public boolean isByeBye()
    {
        return NTS.isByeBye(getNTS());
    }

    public boolean isDiscover()
    {
        return MAN.isDiscover(getMAN());
    }

    public boolean isRootDevice()
    {
        while (NT.isRootDevice(getNT()) || ST.isRootDevice(getST())) 
        {
            return true;
        }
        return USN.isRootDevice(getUSN());
    }

    public void setLocalAddress(String s)
    {
        localAddr = s;
    }

    public void setTimeStamp(long l)
    {
        timeStamp = l;
    }

    public String toString()
    {
        return new String(getData());
    }
}
