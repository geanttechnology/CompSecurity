// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.ssdp;

import java.net.InetAddress;
import java.util.Vector;
import org.cybergarage.net.HostInterface;
import org.cybergarage.upnp.ControlPoint;

// Referenced classes of package org.cybergarage.upnp.ssdp:
//            SSDPSearchResponseSocket, SSDPSearchRequest, SSDP

public class SSDPSearchResponseSocketList extends Vector
{

    private InetAddress binds[];

    public SSDPSearchResponseSocketList()
    {
        binds = null;
    }

    public SSDPSearchResponseSocketList(InetAddress ainetaddress[])
    {
        binds = null;
        binds = ainetaddress;
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
            getSSDPSearchResponseSocket(i).close();
            i++;
        } while (true);
    }

    public SSDPSearchResponseSocket getSSDPSearchResponseSocket(int i)
    {
        return (SSDPSearchResponseSocket)get(i);
    }

    public boolean open()
    {
        return open(1900);
    }

    public boolean open(int i)
    {
        Object aobj[] = binds;
        if (aobj == null) goto _L2; else goto _L1
_L1:
        String as[];
        int j;
        as = new String[aobj.length];
        j = 0;
_L10:
        if (j < aobj.length) goto _L4; else goto _L3
_L3:
        j = 0;
_L8:
        int k = as.length;
        if (j >= k)
        {
            return true;
        }
          goto _L5
_L4:
        as[j] = aobj[j].getHostAddress();
        j++;
        continue; /* Loop/switch isn't completed */
_L2:
        k = HostInterface.getNHostAddresses();
        aobj = new String[k];
        j = 0;
_L7:
        as = ((String []) (aobj));
        if (j >= k) goto _L3; else goto _L6
_L6:
        aobj[j] = HostInterface.getHostAddress(j);
        j++;
          goto _L7
          goto _L3
_L5:
        add(new SSDPSearchResponseSocket(as[j], i));
        j++;
          goto _L8
        Exception exception;
        exception;
        stop();
        close();
        clear();
        return false;
        if (true) goto _L10; else goto _L9
_L9:
    }

    public boolean post(SSDPSearchRequest ssdpsearchrequest)
    {
        boolean flag = true;
        int j = size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return flag;
            }
            SSDPSearchResponseSocket ssdpsearchresponsesocket = getSSDPSearchResponseSocket(i);
            String s1 = ssdpsearchresponsesocket.getLocalAddress();
            ssdpsearchrequest.setLocalAddress(s1);
            String s = "239.255.255.250";
            if (HostInterface.isIPv6Address(s1))
            {
                s = SSDP.getIPv6Address();
            }
            if (!ssdpsearchresponsesocket.post(s, 1900, ssdpsearchrequest))
            {
                flag = false;
            }
            i++;
        } while (true);
    }

    public void setControlPoint(ControlPoint controlpoint)
    {
        int j = size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            getSSDPSearchResponseSocket(i).setControlPoint(controlpoint);
            i++;
        } while (true);
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
            getSSDPSearchResponseSocket(i).start();
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
            getSSDPSearchResponseSocket(i).stop();
            i++;
        } while (true);
    }
}
