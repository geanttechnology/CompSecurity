// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.codebutler.android_websockets;

import android.text.TextUtils;
import android.util.Log;
import java.io.EOFException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.SSLException;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpResponseException;

// Referenced classes of package com.codebutler.android_websockets:
//            WebSocketClient, HybiParser

class this._cls0
    implements Runnable
{

    final WebSocketClient this$0;

    public void run()
    {
        String s;
        WebSocketClient.access$002(WebSocketClient.this, 1);
        s = WebSocketClient.access$100(WebSocketClient.this);
        if (!TextUtils.isEmpty(WebSocketClient.access$200(WebSocketClient.this).getPath()))
        {
            break MISSING_BLOCK_LABEL_435;
        }
        Object obj = "/";
_L1:
        Object obj1 = obj;
        if (!TextUtils.isEmpty(WebSocketClient.access$200(WebSocketClient.this).getQuery()))
        {
            obj1 = (new StringBuilder()).append(((String) (obj))).append("?").append(WebSocketClient.access$200(WebSocketClient.this).getQuery()).toString();
        }
        URI uri = new URI("https", (new StringBuilder()).append("//").append(WebSocketClient.access$200(WebSocketClient.this).getHost()).toString(), null);
        obj = WebSocketClient.access$300(WebSocketClient.this);
        WebSocketClient.access$402(WebSocketClient.this, ((SocketFactory) (obj)).createSocket(WebSocketClient.access$200(WebSocketClient.this).getHost(), 443));
        obj = new PrintWriter(WebSocketClient.access$400(WebSocketClient.this).getOutputStream());
        ((PrintWriter) (obj)).print((new StringBuilder()).append("GET ").append(((String) (obj1))).append(" HTTP/1.1\r\n").toString());
        ((PrintWriter) (obj)).print("Upgrade: websocket\r\n");
        ((PrintWriter) (obj)).print("Connection: Upgrade\r\n");
        ((PrintWriter) (obj)).print((new StringBuilder()).append("Host: ").append(WebSocketClient.access$200(WebSocketClient.this).getHost()).append("\r\n").toString());
        ((PrintWriter) (obj)).print((new StringBuilder()).append("Origin: ").append(uri.toString()).append("\r\n").toString());
        ((PrintWriter) (obj)).print((new StringBuilder()).append("Sec-WebSocket-Key: ").append(s).append("\r\n").toString());
        ((PrintWriter) (obj)).print("Sec-WebSocket-Version: 13\r\n");
        if (WebSocketClient.access$500(WebSocketClient.this) != null)
        {
            NameValuePair namevaluepair;
            for (obj1 = WebSocketClient.access$500(WebSocketClient.this).iterator(); ((Iterator) (obj1)).hasNext(); ((PrintWriter) (obj)).print(String.format("%s: %s\r\n", new Object[] {
    namevaluepair.getName(), namevaluepair.getValue()
})))
            {
                namevaluepair = (NameValuePair)((Iterator) (obj1)).next();
            }

        }
        break MISSING_BLOCK_LABEL_449;
        obj = WebSocketClient.access$200(WebSocketClient.this).getPath();
          goto _L1
        ((PrintWriter) (obj)).print("\r\n");
        ((PrintWriter) (obj)).flush();
        obj = new taInputStream(WebSocketClient.access$400(WebSocketClient.this).getInputStream());
        obj1 = WebSocketClient.access$700(WebSocketClient.this, WebSocketClient.access$600(WebSocketClient.this, ((taInputStream) (obj))));
        if (obj1 == null)
        {
            try
            {
                throw new HttpException("Received no reply from server.");
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.d("WebSocketClient", "WebSocket EOF!", ((Throwable) (obj)));
                WebSocketClient.access$1000(WebSocketClient.this).onDisconnect(0, "EOF");
                WebSocketClient.access$002(WebSocketClient.this, 0);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                Log.d("WebSocketClient", "Websocket SSL error!", ((Throwable) (obj)));
                WebSocketClient.access$1000(WebSocketClient.this).onDisconnect(0, "SSL");
                WebSocketClient.access$002(WebSocketClient.this, 0);
                return;
            }
            // Misplaced declaration of an exception variable
            catch (Object obj)
            {
                WebSocketClient.access$1000(WebSocketClient.this).onError(((Exception) (obj)));
            }
            break MISSING_BLOCK_LABEL_587;
        }
        if (((StatusLine) (obj1)).getStatusCode() != 101)
        {
            throw new HttpResponseException(((StatusLine) (obj1)).getStatusCode(), ((StatusLine) (obj1)).getReasonPhrase());
        }
        break MISSING_BLOCK_LABEL_597;
        WebSocketClient.access$002(WebSocketClient.this, 0);
        return;
        boolean flag = false;
_L3:
        Object obj2 = WebSocketClient.access$600(WebSocketClient.this, ((taInputStream) (obj)));
        if (!TextUtils.isEmpty(((CharSequence) (obj2))))
        {
            obj2 = WebSocketClient.access$800(WebSocketClient.this, ((String) (obj2)));
            if (!((Header) (obj2)).getName().equals("Sec-WebSocket-Accept"))
            {
                continue; /* Loop/switch isn't completed */
            }
            if (!WebSocketClient.access$900(WebSocketClient.this, s).equals(((Header) (obj2)).getValue().trim()))
            {
                throw new HttpException("Bad Sec-WebSocket-Accept header value.");
            }
            break MISSING_BLOCK_LABEL_722;
        }
        if (flag)
        {
            break MISSING_BLOCK_LABEL_689;
        }
        throw new HttpException("No Sec-WebSocket-Accept header.");
        WebSocketClient.access$002(WebSocketClient.this, 2);
        WebSocketClient.access$1000(WebSocketClient.this).onConnect();
        WebSocketClient.access$1100(WebSocketClient.this).start(((taInputStream) (obj)));
        return;
        flag = true;
        if (true) goto _L3; else goto _L2
_L2:
    }

    taInputStream()
    {
        this$0 = WebSocketClient.this;
        super();
    }
}
