// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.cybergarage.http;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import org.cybergarage.util.Debug;
import org.cybergarage.util.ListenerList;

// Referenced classes of package org.cybergarage.http:
//            HTTPRequestListener, HTTPServerThread, HTTPRequest

public class HTTPServer
    implements Runnable
{

    public static final int DEFAULT_PORT = 80;
    public static final int DEFAULT_TIMEOUT = 0x13880;
    public static final String NAME = "CyberHTTP";
    public static final String VERSION = "1.0";
    private InetAddress bindAddr;
    private int bindPort;
    private ListenerList httpRequestListenerList;
    private Thread httpServerThread;
    private ServerSocket serverSock;
    protected int timeout;

    public HTTPServer()
    {
        serverSock = null;
        bindAddr = null;
        bindPort = 0;
        timeout = 0x13880;
        httpRequestListenerList = new ListenerList();
        httpServerThread = null;
        serverSock = null;
    }

    public static String getName()
    {
        String s = System.getProperty("os.name");
        String s1 = System.getProperty("os.version");
        return (new StringBuilder(String.valueOf(s))).append("/").append(s1).append(" ").append("CyberHTTP").append("/").append("1.0").toString();
    }

    public Socket accept()
    {
        if (serverSock == null)
        {
            return null;
        }
        Socket socket;
        try
        {
            socket = serverSock.accept();
            socket.setSoTimeout(getTimeout());
        }
        catch (Exception exception)
        {
            return null;
        }
        return socket;
    }

    public void addRequestListener(HTTPRequestListener httprequestlistener)
    {
        httpRequestListenerList.add(httprequestlistener);
    }

    public boolean close()
    {
        if (serverSock == null)
        {
            return true;
        }
        try
        {
            serverSock.close();
            serverSock = null;
            bindAddr = null;
            bindPort = 0;
        }
        catch (Exception exception)
        {
            Debug.warning(exception);
            return false;
        }
        return true;
    }

    public String getBindAddress()
    {
        if (bindAddr == null)
        {
            return "";
        } else
        {
            return bindAddr.toString();
        }
    }

    public int getBindPort()
    {
        return bindPort;
    }

    public ServerSocket getServerSock()
    {
        return serverSock;
    }

    public int getTimeout()
    {
        this;
        JVM INSTR monitorenter ;
        int i = timeout;
        this;
        JVM INSTR monitorexit ;
        return i;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean isOpened()
    {
        return serverSock != null;
    }

    public boolean open(String s, int i)
    {
        if (serverSock != null)
        {
            return true;
        }
        try
        {
            bindAddr = InetAddress.getByName(s);
            bindPort = i;
            serverSock = new ServerSocket(bindPort, 0, bindAddr);
        }
        // Misplaced declaration of an exception variable
        catch (String s)
        {
            return false;
        }
        return true;
    }

    public boolean open(InetAddress inetaddress, int i)
    {
        if (serverSock != null)
        {
            return true;
        }
        try
        {
            serverSock = new ServerSocket(bindPort, 0, bindAddr);
        }
        // Misplaced declaration of an exception variable
        catch (InetAddress inetaddress)
        {
            return false;
        }
        return true;
    }

    public void performRequestListener(HTTPRequest httprequest)
    {
        int j = httpRequestListenerList.size();
        int i = 0;
        do
        {
            if (i >= j)
            {
                return;
            }
            ((HTTPRequestListener)httpRequestListenerList.get(i)).httpRequestRecieved(httprequest);
            i++;
        } while (true);
    }

    public void removeRequestListener(HTTPRequestListener httprequestlistener)
    {
        httpRequestListenerList.remove(httprequestlistener);
    }

    public void run()
    {
        if (isOpened()) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Thread thread = Thread.currentThread();
_L3:
        if (httpServerThread != thread)
        {
            continue; /* Loop/switch isn't completed */
        }
        Thread.yield();
        Socket socket;
        try
        {
            Debug.message("accept ...");
            socket = accept();
        }
        catch (Exception exception)
        {
            Debug.warning(exception);
            return;
        }
        if (socket == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        Debug.message((new StringBuilder("sock = ")).append(socket.getRemoteSocketAddress()).toString());
        (new HTTPServerThread(this, socket)).start();
        Debug.message("httpServThread ...");
          goto _L3
        if (true) goto _L1; else goto _L4
_L4:
    }

    public void setTimeout(int i)
    {
        this;
        JVM INSTR monitorenter ;
        timeout = i;
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean start()
    {
        StringBuffer stringbuffer = new StringBuffer("Cyber.HTTPServer/");
        stringbuffer.append(serverSock.getLocalSocketAddress());
        httpServerThread = new Thread(this, stringbuffer.toString());
        httpServerThread.start();
        return true;
    }

    public boolean stop()
    {
        httpServerThread = null;
        return true;
    }
}
