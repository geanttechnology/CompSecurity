// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.http;

import java.net.InetAddress;
import java.util.Vector;
import org.cybergarage.net.HostInterface;

// Referenced classes of package org.cybergarage.http:
//            HTTPServer, HTTPRequestListener

public class HTTPServerList extends Vector
{

    private InetAddress binds[];
    private int port;

    public HTTPServerList()
    {
        binds = null;
        port = 4004;
    }

    public HTTPServerList(InetAddress ainetaddress[], int i)
    {
        binds = null;
        port = 4004;
        binds = ainetaddress;
        port = i;
    }

    public void addRequestListener(HTTPRequestListener httprequestlistener)
    {
        int j = size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            getHTTPServer(i).addRequestListener(httprequestlistener);
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
                return;
            }
            getHTTPServer(i).close();
            i++;
        } while (true);
    }

    public HTTPServer getHTTPServer(int i)
    {
        return (HTTPServer)get(i);
    }

    public int open()
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
        int j;
        j = 0;
        i = 0;
_L8:
        if (i >= as.length)
        {
            return j;
        }
        break MISSING_BLOCK_LABEL_88;
_L4:
        as[i] = aobj[i].getHostAddress();
        i++;
          goto _L5
_L2:
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
        HTTPServer httpserver = new HTTPServer();
        if (as[i] == null || !httpserver.open(as[i], port))
        {
            close();
            clear();
        } else
        {
            add(httpserver);
            j++;
        }
        i++;
          goto _L8
    }

    public boolean open(int i)
    {
        port = i;
        return open() != 0;
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
            getHTTPServer(i).start();
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
            getHTTPServer(i).stop();
            i++;
        } while (true);
    }
}
