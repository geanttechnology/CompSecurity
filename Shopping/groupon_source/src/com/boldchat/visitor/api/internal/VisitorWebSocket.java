// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api.internal;

import com.boldchat.visitor.api.Account;
import com.boldchat.visitor.api.Chat;
import com.boldchat.visitor.api.json.JSONArray;
import com.boldchat.visitor.api.json.JSONObject;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

// Referenced classes of package com.boldchat.visitor.api.internal:
//            VisitorMessageProcessor, RPCSender, VisitorMessageListener, ResultListener

public class VisitorWebSocket extends VisitorMessageProcessor
    implements RPCSender
{
    private class WebSocketConnection extends WebSocketClient
    {

        private boolean closeExpected;
        final VisitorWebSocket this$0;

        public void onClose(int i, String s, boolean flag)
        {
            if (!closeExpected && !reconnectWebSocket())
            {
                getVisitorMessageListener().onClose(-100, s, flag, VisitorWebSocket.this);
            }
        }

        public void onError(Exception exception)
        {
            getVisitorMessageListener().onError(exception, VisitorWebSocket.this);
        }

        public void onMessage(String s)
        {
            JSONObject jsonobject;
            try
            {
                if (s.trim().length() == 0)
                {
                    return;
                }
            }
            catch (Exception exception)
            {
                System.err.println((new StringBuilder()).append("Unable to process message: ").append(s).toString());
                exception.printStackTrace();
                return;
            }
            jsonobject = new JSONObject(s);
            processMessage(jsonobject);
            return;
        }

        public void onOpen(ServerHandshake serverhandshake)
        {
            reconnectAttempts = 0;
            reconnectStarted = 0L;
            serverhandshake = new HashMap();
            serverhandshake.put("LastMessageID", getLastMessageID());
            sendRPC("connect", serverhandshake, new ResultListener() {

                final WebSocketConnection this$1;

                public void failure(int i, String s, JSONObject jsonobject)
                {
                    getVisitorMessageListener().onClose(-100, s, false, _fld0);
                }

                public void failure(IOException ioexception)
                {
                    VisitorMessageListener visitormessagelistener = getVisitorMessageListener();
                    if (ioexception.getLocalizedMessage() != null)
                    {
                        ioexception = ioexception.getLocalizedMessage();
                    } else
                    {
                        ioexception = ioexception.getMessage();
                    }
                    visitormessagelistener.onClose(-100, ioexception, false, _fld0);
                }

                public void success(JSONObject jsonobject)
                {
                    connectedOnce = true;
                    getVisitorMessageListener().onOpen(_fld0);
                }

            
            {
                this$1 = WebSocketConnection.this;
                super();
            }
            });
        }


/*
        static boolean access$002(WebSocketConnection websocketconnection, boolean flag)
        {
            websocketconnection.closeExpected = flag;
            return flag;
        }

*/

        public WebSocketConnection(String s)
            throws URISyntaxException
        {
            this$0 = VisitorWebSocket.this;
            super(new URI(s));
            visitorwebsocket = HttpsURLConnection.getDefaultSSLSocketFactory();
            try
            {
                setSocket(createSocket());
            }
            // Misplaced declaration of an exception variable
            catch (VisitorWebSocket visitorwebsocket)
            {
                printStackTrace();
            }
            connect();
        }
    }


    Account account;
    Chat chat;
    boolean connectedOnce;
    Random rand;
    int reconnectAttempts;
    long reconnectStarted;
    WebSocketConnection socket;
    String url;

    public VisitorWebSocket(String s, Account account1, Chat chat1, VisitorMessageListener visitormessagelistener)
    {
        super(visitormessagelistener, true);
        url = null;
        rand = new Random();
        connectedOnce = false;
        reconnectAttempts = 0;
        reconnectStarted = 0L;
        account = account1;
        chat = chat1;
        url = s;
        connectWebSocket();
    }

    private void connectWebSocket()
    {
        try
        {
            socket = new WebSocketConnection(url);
            return;
        }
        catch (URISyntaxException urisyntaxexception)
        {
            throw new RuntimeException(urisyntaxexception);
        }
    }

    private boolean reconnectWebSocket()
    {
        if (getVisitorMessageListener() != null && connectedOnce)
        {
            getVisitorMessageListener().onReconnecting(this);
        }
        if (reconnectAttempts == 0)
        {
            reconnectStarted = System.currentTimeMillis();
        }
        if (System.currentTimeMillis() < reconnectStarted + (long)(chat.getClientTimeout() * 1000))
        {
            long l = reconnectAttempts * reconnectAttempts * 100;
            final long sleep = l;
            if (l > 10000L)
            {
                sleep = 10000L;
            }
            reconnectAttempts = reconnectAttempts + 1;
            System.err.println((new StringBuilder()).append("Attempting chat reconnect: attempt #").append(reconnectAttempts).toString());
            (new Thread(new Runnable() {

                final VisitorWebSocket this$0;
                final long val$sleep;

                public void run()
                {
                    try
                    {
                        Thread.sleep(sleep);
                    }
                    catch (InterruptedException interruptedexception)
                    {
                        interruptedexception.printStackTrace();
                    }
                    connectWebSocket();
                }

            
            {
                this$0 = VisitorWebSocket.this;
                sleep = l;
                super();
            }
            })).start();
            return true;
        } else
        {
            return false;
        }
    }

    public boolean close()
    {
        setCloseExpected(true);
        if (socket != null)
        {
            try
            {
                socket.close();
            }
            catch (Exception exception)
            {
                exception.printStackTrace();
                return false;
            }
        }
        return true;
    }

    public boolean reconnect()
    {
        close();
        connectWebSocket();
        return true;
    }

    public boolean sendMessage(String s)
    {
        socket.send(s);
        return true;
    }

    public void sendRPC(String s, Map map, ResultListener resultlistener)
    {
        JSONObject jsonobject = new JSONObject();
        JSONArray jsonarray = new JSONArray();
        map = new JSONObject(map);
        String s1 = Long.valueOf(Math.abs(rand.nextLong())).toString();
        jsonarray.put(map);
        jsonobject.put("method", s);
        jsonobject.put("params", jsonarray);
        jsonobject.put("id", s1);
        if (resultlistener != null)
        {
            addResultListener(s1, resultlistener);
        }
        socket.send(jsonobject.toString());
    }

    public void setCloseExpected(boolean flag)
    {
        if (socket != null)
        {
            socket.closeExpected = flag;
        }
    }


}
