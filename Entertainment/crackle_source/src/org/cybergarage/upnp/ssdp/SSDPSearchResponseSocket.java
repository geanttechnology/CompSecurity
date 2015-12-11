// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.ssdp;

import java.net.DatagramSocket;
import org.cybergarage.upnp.ControlPoint;

// Referenced classes of package org.cybergarage.upnp.ssdp:
//            HTTPUSocket, SSDPSearchRequest, SSDPSearchResponse

public class SSDPSearchResponseSocket extends HTTPUSocket
    implements Runnable
{

    private ControlPoint controlPoint;
    private Thread deviceSearchResponseThread;

    public SSDPSearchResponseSocket()
    {
        controlPoint = null;
        deviceSearchResponseThread = null;
        setControlPoint(null);
    }

    public SSDPSearchResponseSocket(String s, int i)
    {
        super(s, i);
        controlPoint = null;
        deviceSearchResponseThread = null;
        setControlPoint(null);
    }

    public ControlPoint getControlPoint()
    {
        return controlPoint;
    }

    public boolean post(String s, int i, SSDPSearchRequest ssdpsearchrequest)
    {
        return post(s, i, ssdpsearchrequest.toString());
    }

    public boolean post(String s, int i, SSDPSearchResponse ssdpsearchresponse)
    {
        return post(s, i, ssdpsearchresponse.getHeader());
    }

    public void run()
    {
        Thread thread;
        ControlPoint controlpoint;
        thread = Thread.currentThread();
        controlpoint = getControlPoint();
_L5:
        if (deviceSearchResponseThread == thread) goto _L2; else goto _L1
_L1:
        return;
_L2:
        SSDPPacket ssdppacket;
        Thread.yield();
        ssdppacket = receive();
        if (ssdppacket == null) goto _L1; else goto _L3
_L3:
        if (controlpoint != null)
        {
            controlpoint.searchResponseReceived(ssdppacket);
        }
        if (true) goto _L5; else goto _L4
_L4:
    }

    public void setControlPoint(ControlPoint controlpoint)
    {
        controlPoint = controlpoint;
    }

    public void start()
    {
        StringBuffer stringbuffer = new StringBuffer("Cyber.SSDPSearchResponseSocket/");
        DatagramSocket datagramsocket = getDatagramSocket();
        if (datagramsocket.getLocalAddress() != null)
        {
            stringbuffer.append(datagramsocket.getLocalAddress()).append(':');
            stringbuffer.append(datagramsocket.getLocalPort());
        }
        deviceSearchResponseThread = new Thread(this, stringbuffer.toString());
        deviceSearchResponseThread.start();
    }

    public void stop()
    {
        deviceSearchResponseThread = null;
    }
}
