// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.util.Log;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.UnknownHostException;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.loopj.android.http:
//            ResponseHandlerInterface

public class AsyncHttpRequest
    implements Runnable
{

    private boolean cancelIsNotified;
    private final AbstractHttpClient client;
    private final HttpContext context;
    private int executionCount;
    private boolean isCancelled;
    private boolean isFinished;
    private boolean isRequestPreProcessed;
    private final HttpUriRequest request;
    private final ResponseHandlerInterface responseHandler;

    public AsyncHttpRequest(AbstractHttpClient abstracthttpclient, HttpContext httpcontext, HttpUriRequest httpurirequest, ResponseHandlerInterface responsehandlerinterface)
    {
        client = abstracthttpclient;
        context = httpcontext;
        request = httpurirequest;
        responseHandler = responsehandlerinterface;
    }

    private void makeRequest()
    {
        if (!isCancelled())
        {
            if (request.getURI().getScheme() == null)
            {
                throw new MalformedURLException("No valid URI scheme was provided");
            }
            org.apache.http.HttpResponse httpresponse = client.execute(request, context);
            if (!isCancelled() && responseHandler != null)
            {
                responseHandler.onPreProcessResponse(responseHandler, httpresponse);
                if (!isCancelled())
                {
                    responseHandler.sendResponseMessage(httpresponse);
                    if (!isCancelled())
                    {
                        responseHandler.onPostProcessResponse(responseHandler, httpresponse);
                        return;
                    }
                }
            }
        }
    }

    private void makeRequestWithRetries()
    {
        Object obj2;
        HttpRequestRetryHandler httprequestretryhandler;
        boolean flag1;
        obj2 = null;
        httprequestretryhandler = client.getHttpRequestRetryHandler();
        flag1 = true;
_L7:
        if (!flag1) goto _L2; else goto _L1
_L1:
        makeRequest();
_L11:
        return;
        Object obj;
        obj;
        Object obj1 = new IOException((new StringBuilder()).append("UnknownHostException exception: ").append(((UnknownHostException) (obj)).getMessage()).toString());
        if (executionCount <= 0) goto _L4; else goto _L3
_L3:
        int i;
        i = executionCount + 1;
        executionCount = i;
        if (!httprequestretryhandler.retryRequest(((IOException) (obj1)), i, context)) goto _L4; else goto _L5
_L5:
        boolean flag = true;
_L9:
        obj2 = obj1;
        flag1 = flag;
        if (!flag) goto _L7; else goto _L6
_L6:
        obj2 = obj1;
        flag1 = flag;
        if (responseHandler == null) goto _L7; else goto _L8
_L8:
        responseHandler.sendRetryMessage(executionCount);
        obj2 = obj1;
        flag1 = flag;
          goto _L7
        obj1;
        Log.e("AsyncHttpRequest", "Unhandled exception origin cause", ((Throwable) (obj1)));
        obj2 = new IOException((new StringBuilder()).append("Unhandled exception: ").append(((Exception) (obj1)).getMessage()).toString());
_L2:
        throw obj2;
_L4:
        flag = false;
          goto _L9
        obj1;
        obj1 = new IOException((new StringBuilder()).append("NPE in HttpClient: ").append(((NullPointerException) (obj1)).getMessage()).toString());
        int j = executionCount + 1;
        executionCount = j;
        flag = httprequestretryhandler.retryRequest(((IOException) (obj1)), j, context);
          goto _L9
        obj1;
        if (isCancelled()) goto _L11; else goto _L10
_L10:
        int k = executionCount + 1;
        executionCount = k;
        flag = httprequestretryhandler.retryRequest(((IOException) (obj1)), k, context);
          goto _L9
    }

    private void sendCancelNotification()
    {
        this;
        JVM INSTR monitorenter ;
        if (!isFinished && isCancelled && !cancelIsNotified)
        {
            cancelIsNotified = true;
            if (responseHandler != null)
            {
                responseHandler.sendCancelMessage();
            }
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
        isCancelled = true;
        request.abort();
        return isCancelled();
    }

    public boolean isCancelled()
    {
        if (isCancelled)
        {
            sendCancelNotification();
        }
        return isCancelled;
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
                if (responseHandler != null)
                {
                    responseHandler.sendStartMessage();
                }
                if (!isCancelled())
                {
                    try
                    {
                        makeRequestWithRetries();
                    }
                    catch (IOException ioexception)
                    {
                        if (!isCancelled() && responseHandler != null)
                        {
                            responseHandler.sendFailureMessage(0, null, null, ioexception);
                        } else
                        {
                            Log.e("AsyncHttpRequest", "makeRequestWithRetries returned error, but handler is null", ioexception);
                        }
                    }
                    if (!isCancelled())
                    {
                        if (responseHandler != null)
                        {
                            responseHandler.sendFinishMessage();
                        }
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
}
