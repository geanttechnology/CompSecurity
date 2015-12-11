// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package net.tsz.afinal.http;

import java.io.IOException;
import java.net.UnknownHostException;
import net.tsz.afinal.http.entityhandler.StringEntityHandler;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

public class SyncRequestHandler
{

    private String charset;
    private final AbstractHttpClient client;
    private final HttpContext context;
    private final StringEntityHandler entityHandler = new StringEntityHandler();
    private int executionCount;

    public SyncRequestHandler(AbstractHttpClient abstracthttpclient, HttpContext httpcontext, String s)
    {
        executionCount = 0;
        client = abstracthttpclient;
        context = httpcontext;
        charset = s;
    }

    private Object makeRequestWithRetries(HttpUriRequest httpurirequest)
        throws IOException
    {
        Object obj;
        HttpRequestRetryHandler httprequestretryhandler;
        boolean flag;
        flag = true;
        obj = null;
        httprequestretryhandler = client.getHttpRequestRetryHandler();
_L1:
        Object obj1;
        if (!flag)
        {
            if (obj != null)
            {
                throw obj;
            } else
            {
                throw new IOException("\u672A\u77E5\u7F51\u7EDC\u9519\u8BEF");
            }
        }
        obj = client.execute(httpurirequest, context);
        obj = entityHandler.handleEntity(((HttpResponse) (obj)).getEntity(), null, charset);
        return obj;
        obj;
        int i = executionCount + 1;
        executionCount = i;
        flag = httprequestretryhandler.retryRequest(((IOException) (obj)), i, context);
          goto _L1
        obj;
        int j = executionCount + 1;
        executionCount = j;
        flag = httprequestretryhandler.retryRequest(((IOException) (obj)), j, context);
          goto _L1
        obj1;
        obj1 = new IOException((new StringBuilder("NPE in HttpClient")).append(((NullPointerException) (obj1)).getMessage()).toString());
        int k = executionCount + 1;
        executionCount = k;
        flag = httprequestretryhandler.retryRequest(((IOException) (obj1)), k, context);
          goto _L1
        obj1;
        obj1 = new IOException((new StringBuilder("Exception")).append(((Exception) (obj1)).getMessage()).toString());
        int l = executionCount + 1;
        executionCount = l;
        flag = httprequestretryhandler.retryRequest(((IOException) (obj1)), l, context);
          goto _L1
    }

    public transient Object sendRequest(HttpUriRequest ahttpurirequest[])
    {
        try
        {
            ahttpurirequest = ((HttpUriRequest []) (makeRequestWithRetries(ahttpurirequest[0])));
        }
        // Misplaced declaration of an exception variable
        catch (HttpUriRequest ahttpurirequest[])
        {
            ahttpurirequest.printStackTrace();
            return null;
        }
        return ahttpurirequest;
    }
}
