// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.java_websocket.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.channels.NotYetConnectedException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;
import org.java_websocket.WebSocket;
import org.java_websocket.WebSocketAdapter;
import org.java_websocket.WebSocketImpl;
import org.java_websocket.drafts.Draft;
import org.java_websocket.drafts.Draft_17;
import org.java_websocket.exceptions.InvalidHandshakeException;
import org.java_websocket.framing.Framedata;
import org.java_websocket.handshake.HandshakeImpl1Client;
import org.java_websocket.handshake.Handshakedata;
import org.java_websocket.handshake.ServerHandshake;

public abstract class WebSocketClient extends WebSocketAdapter
    implements Runnable, WebSocket
{
    private class WebsocketWriteThread
        implements Runnable
    {

        final WebSocketClient this$0;

        public void run()
        {
            Thread.currentThread().setName("WebsocketWriteThread");
            try
            {
                for (; !Thread.interrupted(); ostream.flush())
                {
                    ByteBuffer bytebuffer = (ByteBuffer)engine.outQueue.take();
                    ostream.write(bytebuffer.array(), 0, bytebuffer.limit());
                }

            }
            catch (IOException ioexception)
            {
                engine.eot();
            }
            catch (InterruptedException interruptedexception)
            {
                return;
            }
        }

        private WebsocketWriteThread()
        {
            this$0 = WebSocketClient.this;
            super();
        }

    }


    static final boolean $assertionsDisabled;
    private CountDownLatch closeLatch;
    private CountDownLatch connectLatch;
    private int connectTimeout;
    private Draft draft;
    private WebSocketImpl engine;
    private Map headers;
    private InputStream istream;
    private OutputStream ostream;
    private Proxy proxy;
    private Socket socket;
    protected URI uri;
    private Thread writeThread;

    public WebSocketClient(URI uri1)
    {
        this(uri1, ((Draft) (new Draft_17())));
    }

    public WebSocketClient(URI uri1, Draft draft1)
    {
        this(uri1, draft1, null, 0);
    }

    public WebSocketClient(URI uri1, Draft draft1, Map map, int i)
    {
        uri = null;
        engine = null;
        socket = null;
        proxy = Proxy.NO_PROXY;
        connectLatch = new CountDownLatch(1);
        closeLatch = new CountDownLatch(1);
        connectTimeout = 0;
        if (uri1 == null)
        {
            throw new IllegalArgumentException();
        }
        if (draft1 == null)
        {
            throw new IllegalArgumentException("null as draft is permitted for `WebSocketServer` only!");
        } else
        {
            uri = uri1;
            draft = draft1;
            headers = map;
            connectTimeout = i;
            engine = new WebSocketImpl(this, draft1);
            return;
        }
    }

    private int getPort()
    {
        String s;
label0:
        {
            int j = uri.getPort();
            int i = j;
            if (j == -1)
            {
                s = uri.getScheme();
                if (!s.equals("wss"))
                {
                    break label0;
                }
                i = 443;
            }
            return i;
        }
        if (s.equals("ws"))
        {
            return 80;
        } else
        {
            throw new RuntimeException((new StringBuilder()).append("unkonow scheme").append(s).toString());
        }
    }

    private void sendHandshake()
        throws InvalidHandshakeException
    {
        Object obj = uri.getPath();
        Object obj1 = uri.getQuery();
        if (obj == null || ((String) (obj)).length() == 0)
        {
            obj = "/";
        }
        String s = ((String) (obj));
        if (obj1 != null)
        {
            s = (new StringBuilder()).append(((String) (obj))).append("?").append(((String) (obj1))).toString();
        }
        int i = getPort();
        obj1 = (new StringBuilder()).append(uri.getHost());
        if (i != 80)
        {
            obj = (new StringBuilder()).append(":").append(i).toString();
        } else
        {
            obj = "";
        }
        obj1 = ((StringBuilder) (obj1)).append(((String) (obj))).toString();
        obj = new HandshakeImpl1Client();
        ((HandshakeImpl1Client) (obj)).setResourceDescriptor(s);
        ((HandshakeImpl1Client) (obj)).put("Host", ((String) (obj1)));
        if (headers != null)
        {
            java.util.Map.Entry entry;
            for (Iterator iterator = headers.entrySet().iterator(); iterator.hasNext(); ((HandshakeImpl1Client) (obj)).put((String)entry.getKey(), (String)entry.getValue()))
            {
                entry = (java.util.Map.Entry)iterator.next();
            }

        }
        engine.startHandshake(((org.java_websocket.handshake.ClientHandshakeBuilder) (obj)));
    }

    public void close()
    {
        if (writeThread != null)
        {
            engine.close(1000);
        }
    }

    public void connect()
    {
        if (writeThread != null)
        {
            throw new IllegalStateException("WebSocketClient objects are not reuseable");
        } else
        {
            writeThread = new Thread(this);
            writeThread.start();
            return;
        }
    }

    public InetSocketAddress getLocalSocketAddress()
    {
        return engine.getLocalSocketAddress();
    }

    public InetSocketAddress getLocalSocketAddress(WebSocket websocket)
    {
        if (socket != null)
        {
            return (InetSocketAddress)socket.getLocalSocketAddress();
        } else
        {
            return null;
        }
    }

    public boolean isClosed()
    {
        return engine.isClosed();
    }

    public abstract void onClose(int i, String s, boolean flag);

    public void onCloseInitiated(int i, String s)
    {
    }

    public void onClosing(int i, String s, boolean flag)
    {
    }

    public abstract void onError(Exception exception);

    public void onFragment(Framedata framedata)
    {
    }

    public abstract void onMessage(String s);

    public void onMessage(ByteBuffer bytebuffer)
    {
    }

    public abstract void onOpen(ServerHandshake serverhandshake);

    public final void onWebsocketClose(WebSocket websocket, int i, String s, boolean flag)
    {
        connectLatch.countDown();
        closeLatch.countDown();
        if (writeThread != null)
        {
            writeThread.interrupt();
        }
        try
        {
            if (socket != null)
            {
                socket.close();
            }
        }
        // Misplaced declaration of an exception variable
        catch (WebSocket websocket)
        {
            onWebsocketError(this, websocket);
        }
        onClose(i, s, flag);
    }

    public void onWebsocketCloseInitiated(WebSocket websocket, int i, String s)
    {
        onCloseInitiated(i, s);
    }

    public void onWebsocketClosing(WebSocket websocket, int i, String s, boolean flag)
    {
        onClosing(i, s, flag);
    }

    public final void onWebsocketError(WebSocket websocket, Exception exception)
    {
        onError(exception);
    }

    public final void onWebsocketMessage(WebSocket websocket, String s)
    {
        onMessage(s);
    }

    public final void onWebsocketMessage(WebSocket websocket, ByteBuffer bytebuffer)
    {
        onMessage(bytebuffer);
    }

    public void onWebsocketMessageFragment(WebSocket websocket, Framedata framedata)
    {
        onFragment(framedata);
    }

    public final void onWebsocketOpen(WebSocket websocket, Handshakedata handshakedata)
    {
        connectLatch.countDown();
        onOpen((ServerHandshake)handshakedata);
    }

    public final void onWriteDemand(WebSocket websocket)
    {
    }

    public void run()
    {
        if (socket != null) goto _L2; else goto _L1
_L1:
        socket = new Socket(proxy);
_L6:
        if (!socket.isBound())
        {
            socket.connect(new InetSocketAddress(uri.getHost(), getPort()), connectTimeout);
        }
        istream = socket.getInputStream();
        ostream = socket.getOutputStream();
        sendHandshake();
        byte abyte0[];
        writeThread = new Thread(new WebsocketWriteThread());
        writeThread.start();
        abyte0 = new byte[WebSocketImpl.RCVBUF];
_L4:
        int i;
        if (isClosed())
        {
            break; /* Loop/switch isn't completed */
        }
        i = istream.read(abyte0);
        if (i == -1)
        {
            break; /* Loop/switch isn't completed */
        }
        engine.decode(ByteBuffer.wrap(abyte0, 0, i));
        IOException ioexception;
        if (true) goto _L4; else goto _L3
_L3:
        try
        {
            engine.eot();
        }
        // Misplaced declaration of an exception variable
        catch (IOException ioexception)
        {
            engine.eot();
        }
        catch (RuntimeException runtimeexception)
        {
            onError(runtimeexception);
            engine.closeConnection(1006, runtimeexception.getMessage());
        }
        if (!$assertionsDisabled && !socket.isClosed())
        {
            throw new AssertionError();
        }
        break MISSING_BLOCK_LABEL_229;
_L2:
        if (!socket.isClosed()) goto _L6; else goto _L5
_L5:
        throw new IOException();
        exception;
        onWebsocketError(engine, exception);
        engine.closeConnection(-1, exception.getMessage());
    }

    public void send(String s)
        throws NotYetConnectedException
    {
        engine.send(s);
    }

    public void sendFrame(Framedata framedata)
    {
        engine.sendFrame(framedata);
    }

    public void setSocket(Socket socket1)
    {
        if (socket != null)
        {
            throw new IllegalStateException("socket has already been set");
        } else
        {
            socket = socket1;
            return;
        }
    }

    static 
    {
        boolean flag;
        if (!org/java_websocket/client/WebSocketClient.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }


}
