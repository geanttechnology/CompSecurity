// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import android.util.Log;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.UnknownHostException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            ResponseHandlerInterface

final class d
    implements Runnable
{

    private final AbstractHttpClient a;
    private final HttpContext b;
    private final HttpUriRequest c;
    private final ResponseHandlerInterface d;
    private int e;

    public d(AbstractHttpClient abstracthttpclient, HttpContext httpcontext, HttpUriRequest httpurirequest, ResponseHandlerInterface responsehandlerinterface)
    {
        a = abstracthttpclient;
        b = httpcontext;
        c = httpurirequest;
        d = responsehandlerinterface;
    }

    public final void run()
    {
        if (d != null)
        {
            d.sendStartMessage();
        }
        HttpRequestRetryHandler httprequestretryhandler = a.getHttpRequestRetryHandler();
        IOException ioexception;
        boolean flag1;
        ioexception = null;
        flag1 = true;
_L7:
        if (!flag1) goto _L2; else goto _L1
_L1:
        if (Thread.currentThread().isInterrupted()) goto _L4; else goto _L3
_L3:
        if (c.getURI().getScheme() == null)
        {
            throw new MalformedURLException("No valid URI scheme was provided");
        }
          goto _L5
        Object obj;
        obj;
        Object obj1;
        obj1 = new IOException((new StringBuilder("UnknownHostException exception: ")).append(((UnknownHostException) (obj)).getMessage()).toString());
        if (e <= 0)
        {
            break MISSING_BLOCK_LABEL_399;
        }
        int i = e + 1;
        e = i;
        if (!httprequestretryhandler.retryRequest(((IOException) (obj1)), i, b))
        {
            break MISSING_BLOCK_LABEL_399;
        }
        boolean flag = true;
_L9:
        ioexception = ((IOException) (obj1));
        flag1 = flag;
        if (!flag) goto _L7; else goto _L6
_L6:
        ioexception = ((IOException) (obj1));
        flag1 = flag;
        if (d == null) goto _L7; else goto _L8
_L8:
        d.sendRetryMessage();
        ioexception = ((IOException) (obj1));
        flag1 = flag;
          goto _L7
        obj1;
        Log.e("AsyncHttpRequest", "Unhandled exception origin cause", ((Throwable) (obj1)));
        ioexception = new IOException((new StringBuilder("Unhandled exception: ")).append(((Exception) (obj1)).getMessage()).toString());
_L2:
        throw ioexception;
        obj1;
        if (d != null)
        {
            d.sendFailureMessage(0, null, null, ((Throwable) (obj1)));
        }
_L4:
        if (d != null)
        {
            d.sendFinishMessage();
        }
        return;
_L5:
        obj1 = a.execute(c, b);
        if (!Thread.currentThread().isInterrupted() && d != null)
        {
            d.sendResponseMessage(((org.apache.http.HttpResponse) (obj1)));
        }
          goto _L4
        obj1;
        obj1 = new IOException((new StringBuilder("NPE in HttpClient: ")).append(((NullPointerException) (obj1)).getMessage()).toString());
        int j = e + 1;
        e = j;
        flag = httprequestretryhandler.retryRequest(((IOException) (obj1)), j, b);
          goto _L9
        obj1;
        int k = e + 1;
        e = k;
        flag = httprequestretryhandler.retryRequest(((IOException) (obj1)), k, b);
          goto _L9
        flag = false;
          goto _L9
    }
}
