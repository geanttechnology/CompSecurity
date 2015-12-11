// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import com.newrelic.agent.android.instrumentation.Instrumentation;
import java.io.IOException;
import java.net.ConnectException;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.loopj.android.http:
//            BinaryHttpResponseHandler, AsyncHttpResponseHandler

class AsyncHttpRequest
    implements Runnable
{

    private final AbstractHttpClient client;
    private final HttpContext context;
    private int executionCount;
    private boolean isBinaryRequest;
    private final HttpUriRequest request;
    private final AsyncHttpResponseHandler responseHandler;

    public AsyncHttpRequest(AbstractHttpClient abstracthttpclient, HttpContext httpcontext, HttpUriRequest httpurirequest, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        client = abstracthttpclient;
        context = httpcontext;
        request = httpurirequest;
        responseHandler = asynchttpresponsehandler;
        if (asynchttpresponsehandler instanceof BinaryHttpResponseHandler)
        {
            isBinaryRequest = true;
        }
    }

    private void makeRequest()
        throws IOException
    {
        if (!Thread.currentThread().isInterrupted())
        {
            Object obj = client;
            HttpUriRequest httpurirequest = request;
            HttpContext httpcontext = context;
            if (!(obj instanceof HttpClient))
            {
                obj = ((AbstractHttpClient) (obj)).execute(httpurirequest, httpcontext);
            } else
            {
                obj = Instrumentation.execute(((HttpClient) (obj)), httpurirequest, httpcontext);
            }
            if (!Thread.currentThread().isInterrupted() && responseHandler != null)
            {
                responseHandler.sendResponseMessage(((org.apache.http.HttpResponse) (obj)));
            }
        }
    }

    private void makeRequestWithRetries()
        throws ConnectException
    {
        Object obj;
        HttpRequestRetryHandler httprequestretryhandler;
        boolean flag;
        flag = true;
        obj = null;
        httprequestretryhandler = client.getHttpRequestRetryHandler();
_L5:
        if (!flag)
        {
            break; /* Loop/switch isn't completed */
        }
        makeRequest();
_L2:
        return;
        obj;
        if (responseHandler == null) goto _L2; else goto _L1
_L1:
        responseHandler.sendFailureMessage(((Throwable) (obj)), "can't resolve host");
        return;
        obj;
        if (responseHandler == null) goto _L2; else goto _L3
_L3:
        responseHandler.sendFailureMessage(((Throwable) (obj)), "can't resolve host");
        return;
        obj;
        if (responseHandler != null)
        {
            responseHandler.sendFailureMessage(((Throwable) (obj)), "socket time out");
            return;
        }
          goto _L2
        obj;
        int i = executionCount + 1;
        executionCount = i;
        flag = httprequestretryhandler.retryRequest(((IOException) (obj)), i, context);
        continue; /* Loop/switch isn't completed */
        obj;
        obj = new IOException((new StringBuilder()).append("NPE in HttpClient").append(((NullPointerException) (obj)).getMessage()).toString());
        int j = executionCount + 1;
        executionCount = j;
        flag = httprequestretryhandler.retryRequest(((IOException) (obj)), j, context);
        if (true) goto _L5; else goto _L4
_L4:
        ConnectException connectexception = new ConnectException();
        connectexception.initCause(((Throwable) (obj)));
        throw connectexception;
    }

    public void run()
    {
        if (responseHandler != null)
        {
            responseHandler.sendStartMessage();
        }
        makeRequestWithRetries();
        if (responseHandler != null)
        {
            responseHandler.sendFinishMessage();
        }
_L1:
        return;
        IOException ioexception;
        ioexception;
        if (responseHandler != null)
        {
            responseHandler.sendFinishMessage();
            if (isBinaryRequest)
            {
                responseHandler.sendFailureMessage(ioexception, (byte[])null);
                return;
            } else
            {
                responseHandler.sendFailureMessage(ioexception, (String)null);
                return;
            }
        }
          goto _L1
    }
}
