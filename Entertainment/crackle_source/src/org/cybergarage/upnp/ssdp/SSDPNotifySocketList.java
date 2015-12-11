// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.upnp.ssdp;

import java.net.InetAddress;
import java.util.Vector;
import org.cybergarage.net.HostInterface;
import org.cybergarage.upnp.ControlPoint;

// Referenced classes of package org.cybergarage.upnp.ssdp:
//            SSDPNotifySocket

public class SSDPNotifySocketList extends Vector
{

    private InetAddress binds[];

    public SSDPNotifySocketList()
    {
        binds = null;
    }

    public SSDPNotifySocketList(InetAddress ainetaddress[])
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
            getSSDPNotifySocket(i).close();
            i++;
        } while (true);
    }

    public SSDPNotifySocket getSSDPNotifySocket(int i)
    {
        return (SSDPNotifySocket)get(i);
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
            add(new SSDPNotifySocket(as[i]));
        }
        i++;
          goto _L8
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
            getSSDPNotifySocket(i).setControlPoint(controlpoint);
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
            getSSDPNotifySocket(i).start();
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
            getSSDPNotifySocket(i).stop();
            i++;
        } while (true);
    }
}
