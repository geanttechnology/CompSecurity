// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.ssdp;

import java.net.InetAddress;
import java.util.Vector;
import org.cybergarage.net.HostInterface;
import org.cybergarage.upnp.device.SearchListener;

// Referenced classes of package org.cybergarage.upnp.ssdp:
//            SSDP, SSDPSearchSocket

public class SSDPSearchSocketList extends Vector
{

    private InetAddress binds[];
    private String multicastIPv4;
    private String multicastIPv6;
    private int port;

    public SSDPSearchSocketList()
    {
        binds = null;
        multicastIPv4 = "239.255.255.250";
        multicastIPv6 = SSDP.getIPv6Address();
        port = 1900;
    }

    public SSDPSearchSocketList(InetAddress ainetaddress[])
    {
        binds = null;
        multicastIPv4 = "239.255.255.250";
        multicastIPv6 = SSDP.getIPv6Address();
        port = 1900;
        binds = ainetaddress;
    }

    public SSDPSearchSocketList(InetAddress ainetaddress[], int i, String s, String s1)
    {
        binds = null;
        multicastIPv4 = "239.255.255.250";
        multicastIPv6 = SSDP.getIPv6Address();
        port = 1900;
        binds = ainetaddress;
        port = i;
        multicastIPv4 = s;
        multicastIPv6 = s1;
    }

    public void addSearchListener(SearchListener searchlistener)
    {
        int j = size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            getSSDPSearchSocket(i).addSearchListener(searchlistener);
            i++;
        } while (true);
    }

    public void close()
    {
        int j = size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                clear();
                return;
            }
            getSSDPSearchSocket(i).close();
            i++;
        } while (true);
    }

    public SSDPSearchSocket getSSDPSearchSocket(int i)
    {
        return (SSDPSearchSocket)get(i);
    }

    public boolean open()
    {
        Object aobj[] = binds;
        if (aobj == null) goto _L2; else goto _L1
_L1:
        String as[];
        int i;
        as = new String[aobj.length];
        i = 0;
_L5:
        if (i < aobj.length) goto _L4; else goto _L3
_L3:
        i = 0;
_L8:
        if (i >= as.length)
        {
            return true;
        }
        break MISSING_BLOCK_LABEL_84;
_L4:
        as[i] = aobj[i].getHostAddress();
        i++;
          goto _L5
_L2:
        int j;
        j = HostInterface.getNHostAddresses();
        aobj = new String[j];
        i = 0;
_L7:
        as = ((String []) (aobj));
        if (i >= j) goto _L3; else goto _L6
_L6:
        aobj[i] = HostInterface.getHostAddress(i);
        i++;
          goto _L7
          goto _L3
        if (as[i] != null)
        {
            SSDPSearchSocket ssdpsearchsocket;
            if (HostInterface.isIPv6Address(as[i]))
            {
                ssdpsearchsocket = new SSDPSearchSocket(as[i], port, multicastIPv6);
            } else
            {
                ssdpsearchsocket = new SSDPSearchSocket(as[i], port, multicastIPv4);
            }
            add(ssdpsearchsocket);
        }
        i++;
          goto _L8
    }

    public void start()
    {
        int j = size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            getSSDPSearchSocket(i).start();
            i++;
        } while (true);
    }

    public void stop()
    {
        int j = size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            getSSDPSearchSocket(i).stop();
            i++;
        } while (true);
    }
}
