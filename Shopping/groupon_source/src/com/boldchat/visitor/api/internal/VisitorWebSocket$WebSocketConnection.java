// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api.internal;

import com.boldchat.visitor.api.json.JSONObject;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

// Referenced classes of package com.boldchat.visitor.api.internal:
//            VisitorWebSocket, VisitorMessageListener, ResultListener

private class connect extends WebSocketClient
{

    private boolean closeExpected;
    final VisitorWebSocket this$0;

    public void onClose(int i, String s, boolean flag)
    {
        if (!closeExpected && !VisitorWebSocket.access$200(VisitorWebSocket.this))
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

            final VisitorWebSocket.WebSocketConnection this$1;

            public void failure(int i, String s, JSONObject jsonobject)
            {
                getVisitorMessageListener().onClose(-100, s, false, this$0);
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
                visitormessagelistener.onClose(-100, ioexception, false, this$0);
            }

            public void success(JSONObject jsonobject)
            {
                connectedOnce = true;
                getVisitorMessageListener().onOpen(this$0);
            }

            
            {
                this$1 = VisitorWebSocket.WebSocketConnection.this;
                super();
            }
        });
    }


/*
    static boolean access$002(_cls1 _pcls1, boolean flag)
    {
        _pcls1.closeExpected = flag;
        return flag;
    }

*/

    public _cls1.this._cls1(String s)
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
