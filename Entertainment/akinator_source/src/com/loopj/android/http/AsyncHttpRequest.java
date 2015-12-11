// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import cz.msebera.android.httpclient.client.HttpRequestRetryHandler;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.impl.client.AbstractHttpClient;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.concurrent.atomic.AtomicBoolean;

// Referenced classes of package com.loopj.android.http:
//            Utils, ResponseHandlerInterface, RangeFileAsyncHttpResponseHandler, AsyncHttpClient, 
//            LogInterface

public class AsyncHttpRequest
    implements Runnable
{

    private boolean cancelIsNotified;
    private final AbstractHttpClient client;
    private final HttpContext context;
    private int executionCount;
    private final AtomicBoolean isCancelled = new AtomicBoolean();
    private volatile boolean isFinished;
    private boolean isRequestPreProcessed;
    private final HttpUriRequest request;
    private final ResponseHandlerInterface responseHandler;

    public AsyncHttpRequest(AbstractHttpClient abstracthttpclient, HttpContext httpcontext, HttpUriRequest httpurirequest, ResponseHandlerInterface responsehandlerinterface)
    {
        client = (AbstractHttpClient)Utils.notNull(abstracthttpclient, "client");
        context = (HttpContext)Utils.notNull(httpcontext, "context");
        request = (HttpUriRequest)Utils.notNull(httpurirequest, "request");
        responseHandler = (ResponseHandlerInterface)Utils.notNull(responsehandlerinterface, "responseHandler");
    }

    private void makeRequest()
        throws IOException
    {
        if (!isCancelled())
        {
            if (request.getURI().getScheme() == null)
            {
                throw new MalformedURLException("No valid URI scheme was provided");
            }
            if (responseHandler instanceof RangeFileAsyncHttpResponseHandler)
            {
                ((RangeFileAsyncHttpResponseHandler)responseHandler).updateRequestHeaders(request);
            }
            cz.msebera.android.httpclient.client.methods.CloseableHttpResponse closeablehttpresponse = client.execute(request, context);
            if (!isCancelled())
            {
                responseHandler.onPreProcessResponse(responseHandler, closeablehttpresponse);
                if (!isCancelled())
                {
                    responseHandler.sendResponseMessage(closeablehttpresponse);
                    if (!isCancelled())
                    {
                        responseHandler.onPostProcessResponse(responseHandler, closeablehttpresponse);
                        return;
                    }
                }
            }
        }
    }

    private void makeRequestWithRetries()
        throws IOException
    {
        Object obj;
        HttpRequestRetryHandler httprequestretryhandler;
        boolean flag;
        flag = true;
        httprequestretryhandler = client.getHttpRequestRetryHandler();
        obj = null;
_L5:
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_228;
        }
        makeRequest();
_L8:
        return;
        UnknownHostException unknownhostexception;
        unknownhostexception;
        obj = new IOException((new StringBuilder()).append("UnknownHostException exception: ").append(unknownhostexception.getMessage()).toString());
        if (executionCount <= 0) goto _L2; else goto _L1
_L1:
        int i;
        i = executionCount + 1;
        executionCount = i;
        if (!httprequestretryhandler.retryRequest(unknownhostexception, i, context)) goto _L2; else goto _L3
_L3:
        flag = true;
_L6:
        if (!flag) goto _L5; else goto _L4
_L4:
        responseHandler.sendRetryMessage(executionCount);
          goto _L5
_L2:
        flag = false;
          goto _L6
        obj;
        obj = new IOException((new StringBuilder()).append("NPE in HttpClient: ").append(((NullPointerException) (obj)).getMessage()).toString());
        int j = executionCount + 1;
        executionCount = j;
        flag = httprequestretryhandler.retryRequest(((IOException) (obj)), j, context);
          goto _L6
        obj;
        flag = isCancelled();
        if (flag) goto _L8; else goto _L7
_L7:
        int k = executionCount + 1;
        executionCount = k;
        flag = httprequestretryhandler.retryRequest(((IOException) (obj)), k, context);
          goto _L6
_L10:
        throw obj;
        Exception exception;
        exception;
_L11:
        AsyncHttpClient.log.e("AsyncHttpRequest", "Unhandled exception origin cause", exception);
        exception = new IOException((new StringBuilder()).append("Unhandled exception: ").append(exception.getMessage()).toString());
        if (true) goto _L10; else goto _L9
_L9:
        exception;
          goto _L11
    }

    private void sendCancelNotification()
    {
        this;
        JVM INSTR monitorenter ;
        if (!isFinished && isCancelled.get() && !cancelIsNotified)
        {
            cancelIsNotified = true;
            responseHandler.sendCancelMessage();
        }
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public boolean cancel(boolean flag)
    {
        isCancelled.set(true);
        request.abort();
        return isCancelled();
    }

    public Object getTag()
    {
        return responseHandler.getTag();
    }

    public boolean isCancelled()
    {
        boolean flag = isCancelled.get();
        if (flag)
        {
            sendCancelNotification();
        }
        return flag;
    }

    public boolean isDone()
    {
        return isCancelled() || isFinished;
    }

    public void onPostProcessRequest(AsyncHttpRequest asynchttprequest)
    {
    }

    public void onPreProcessRequest(AsyncHttpRequest asynchttprequest)
    {
    }

    public void run()
    {
        if (!isCancelled())
        {
            if (!isRequestPreProcessed)
            {
                isRequestPreProcessed = true;
                onPreProcessRequest(this);
            }
            if (!isCancelled())
            {
                responseHandler.sendStartMessage();
                if (!isCancelled())
                {
                    try
                    {
                        makeRequestWithRetries();
                    }
                    catch (IOException ioexception)
                    {
                        if (!isCancelled())
                        {
                            responseHandler.sendFailureMessage(0, null, null, ioexception);
                        } else
                        {
                            AsyncHttpClient.log.e("AsyncHttpRequest", "makeRequestWithRetries returned error", ioexception);
                        }
                    }
                    if (!isCancelled())
                    {
                        responseHandler.sendFinishMessage();
                        if (!isCancelled())
                        {
                            onPostProcessRequest(this);
                            isFinished = true;
                            return;
                        }
                    }
                }
            }
        }
    }

    public AsyncHttpRequest setRequestTag(Object obj)
    {
        responseHandler.setTag(obj);
        return this;
    }
}
