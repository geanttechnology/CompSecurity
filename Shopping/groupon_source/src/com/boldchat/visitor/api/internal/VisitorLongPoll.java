// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.boldchat.visitor.api.internal;

import com.boldchat.visitor.api.Account;
import com.boldchat.visitor.api.Chat;
import com.boldchat.visitor.api.json.JSONArray;
import com.boldchat.visitor.api.json.JSONException;
import com.boldchat.visitor.api.json.JSONTokener;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPInputStream;

// Referenced classes of package com.boldchat.visitor.api.internal:
//            VisitorMessageProcessor, VisitorMessageListener, RequestUtil

public class VisitorLongPoll extends VisitorMessageProcessor
    implements Runnable
{

    private Account account;
    private Chat chat;
    private boolean closeExpected;
    private InputStream input;
    private int reconnectAttempts;
    private long reconnectStarted;
    private String url;

    public VisitorLongPoll(String s, Account account1, Chat chat1, VisitorMessageListener visitormessagelistener)
    {
        super(visitormessagelistener, false);
        input = null;
        closeExpected = false;
        reconnectAttempts = 0;
        account = account1;
        chat = chat1;
        url = s;
        connect();
    }

    private boolean reconnectSocket()
    {
        if (getVisitorMessageListener() != null)
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

                final VisitorLongPoll this$0;
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
                    connect();
                }

            
            {
                this$0 = VisitorLongPoll.this;
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
        try
        {
            setCloseExpected(true);
            if (input != null)
            {
                input.close();
            }
            input = null;
        }
        catch (IOException ioexception)
        {
            ioexception.printStackTrace();
            return true;
        }
        return true;
    }

    public boolean connect()
    {
        setCloseExpected(false);
        (new Thread(this)).start();
        return true;
    }

    public boolean reconnect()
    {
        close();
        connect();
        return true;
    }

    public void run()
    {
        Object obj;
        int i;
        obj = (HttpURLConnection)(new URL((new StringBuilder()).append(url).append(getLastMessageID()).toString())).openConnection();
        if (account.getTimeout() <= 0)
        {
            break MISSING_BLOCK_LABEL_457;
        }
        i = account.getTimeout();
_L18:
        ((HttpURLConnection) (obj)).setConnectTimeout(i);
        ((HttpURLConnection) (obj)).setReadTimeout(chat.getClientTimeout() * 1000);
        ((HttpURLConnection) (obj)).setRequestProperty("User-Agent", RequestUtil.getDefaultUserAgentString());
        ((HttpURLConnection) (obj)).setRequestProperty("Accept-Encoding", "gzip");
        ((HttpURLConnection) (obj)).setRequestProperty("Authorization", RequestUtil.getAuthorizationHeader(account.getAccountID(), account.getApiAccessKey()));
        if (!"gzip".equals(((HttpURLConnection) (obj)).getHeaderField("Content-Encoding"))) goto _L2; else goto _L1
_L1:
        input = new GZIPInputStream(((HttpURLConnection) (obj)).getInputStream());
_L8:
        if (((HttpURLConnection) (obj)).getResponseCode() == 200)
        {
            getVisitorMessageListener().onOpen(this);
        }
        obj = new JSONArray(new JSONTokener(input));
        input.close();
        input = null;
        if (obj == null) goto _L4; else goto _L3
_L3:
        if (((JSONArray) (obj)).length() <= 0) goto _L4; else goto _L5
_L5:
        i = 0;
_L7:
        if (i >= ((JSONArray) (obj)).length()) goto _L4; else goto _L6
_L6:
        processMessage(((JSONArray) (obj)).optJSONObject(i));
        i++;
          goto _L7
_L2:
        input = ((HttpURLConnection) (obj)).getInputStream();
          goto _L8
        Object obj1;
        obj1;
        ((JSONException) (obj1)).printStackTrace();
        if (!(((JSONException) (obj1)).getCause() instanceof IOException) || closeExpected || reconnectSocket()) goto _L10; else goto _L9
_L9:
        VisitorMessageListener visitormessagelistener = getVisitorMessageListener();
        if (((JSONException) (obj1)).getCause().getLocalizedMessage() == null) goto _L12; else goto _L11
_L11:
        obj1 = ((JSONException) (obj1)).getCause().getLocalizedMessage();
_L15:
        visitormessagelistener.onClose(-100, ((String) (obj1)), false, this);
_L10:
        if (input != null)
        {
            input.close();
        }
_L14:
        return;
_L4:
        if (input == null) goto _L14; else goto _L13
_L13:
        input.close();
        return;
        obj1;
        ((Exception) (obj1)).printStackTrace();
        return;
_L12:
        obj1 = ((JSONException) (obj1)).getCause().getMessage();
          goto _L15
        obj1;
        ((Exception) (obj1)).printStackTrace();
        return;
        obj1;
        if (closeExpected || reconnectSocket())
        {
            continue; /* Loop/switch isn't completed */
        }
        visitormessagelistener = getVisitorMessageListener();
        if (((IOException) (obj1)).getLocalizedMessage() == null)
        {
            break MISSING_BLOCK_LABEL_424;
        }
        obj1 = ((IOException) (obj1)).getLocalizedMessage();
_L17:
        visitormessagelistener.onClose(-100, ((String) (obj1)), false, this);
        if (input == null) goto _L14; else goto _L16
_L16:
        input.close();
        return;
        obj1;
        ((Exception) (obj1)).printStackTrace();
        return;
        obj1 = ((IOException) (obj1)).getMessage();
          goto _L17
        obj1;
        try
        {
            if (input != null)
            {
                input.close();
            }
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
        }
        throw obj1;
        i = 30000;
          goto _L18
    }

    public boolean sendMessage(String s)
    {
        return false;
    }

    public void setCloseExpected(boolean flag)
    {
        closeExpected = flag;
    }
}
