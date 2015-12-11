// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.http;

import java.net.Socket;

// Referenced classes of package org.cybergarage.http:
//            HTTPSocket, HTTPRequest, HTTPServer

public class HTTPServerThread extends Thread
{

    private HTTPServer httpServer;
    private Socket sock;

    public HTTPServerThread(HTTPServer httpserver, Socket socket)
    {
        super("Cyber.HTTPServerThread");
        httpServer = httpserver;
        sock = socket;
    }

    public void run()
    {
        HTTPSocket httpsocket;
        HTTPRequest httprequest;
        httpsocket = new HTTPSocket(sock);
        if (!httpsocket.open())
        {
            return;
        }
        httprequest = new HTTPRequest();
        httprequest.setSocket(httpsocket);
_L3:
        if (httprequest.read()) goto _L2; else goto _L1
_L1:
        httpsocket.close();
        return;
_L2:
        httpServer.performRequestListener(httprequest);
        if (httprequest.isKeepAlive()) goto _L3; else goto _L1
    }
}
