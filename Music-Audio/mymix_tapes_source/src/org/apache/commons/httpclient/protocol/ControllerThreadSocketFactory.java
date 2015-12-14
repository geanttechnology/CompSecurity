// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.httpclient.protocol;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import org.apache.commons.httpclient.ConnectTimeoutException;
import org.apache.commons.httpclient.util.TimeoutController;

// Referenced classes of package org.apache.commons.httpclient.protocol:
//            ProtocolSocketFactory

public final class ControllerThreadSocketFactory
{
    public static abstract class SocketTask
        implements Runnable
    {

        private IOException exception;
        private Socket socket;

        public abstract void doit()
            throws IOException;

        protected Socket getSocket()
        {
            return socket;
        }

        public void run()
        {
            try
            {
                doit();
                return;
            }
            catch (IOException ioexception)
            {
                exception = ioexception;
            }
        }

        protected void setSocket(Socket socket1)
        {
            socket = socket1;
        }


        public SocketTask()
        {
        }
    }


    private ControllerThreadSocketFactory()
    {
    }

    public static Socket createSocket(SocketTask sockettask, int i)
        throws IOException, UnknownHostException, ConnectTimeoutException
    {
        long l = i;
        Socket socket;
        try
        {
            TimeoutController.execute(sockettask, l);
        }
        // Misplaced declaration of an exception variable
        catch (SocketTask sockettask)
        {
            throw new ConnectTimeoutException("The host did not accept the connection within timeout of " + i + " ms");
        }
        socket = sockettask.getSocket();
        if (sockettask.exception != null)
        {
            throw sockettask.exception;
        } else
        {
            return socket;
        }
    }

    public static Socket createSocket(final ProtocolSocketFactory socketfactory, final String host, final int port, final InetAddress localAddress, final int localPort, int i)
        throws IOException, UnknownHostException, ConnectTimeoutException
    {
        socketfactory = new _cls1();
        long l = i;
        try
        {
            TimeoutController.execute(socketfactory, l);
        }
        // Misplaced declaration of an exception variable
        catch (final ProtocolSocketFactory socketfactory)
        {
            throw new ConnectTimeoutException("The host did not accept the connection within timeout of " + i + " ms");
        }
        host = socketfactory.getSocket();
        if (((SocketTask) (socketfactory)).exception != null)
        {
            throw ((SocketTask) (socketfactory)).exception;
        } else
        {
            return host;
        }
    }

    private class _cls1 extends SocketTask
    {

        private final String val$host;
        private final InetAddress val$localAddress;
        private final int val$localPort;
        private final int val$port;
        private final ProtocolSocketFactory val$socketfactory;

        public void doit()
            throws IOException
        {
            setSocket(socketfactory.createSocket(host, port, localAddress, localPort));
        }

        _cls1()
            throws IOException
        {
            socketfactory = protocolsocketfactory;
            host = s;
            port = i;
            localAddress = inetaddress;
            localPort = j;
        }
    }

}
