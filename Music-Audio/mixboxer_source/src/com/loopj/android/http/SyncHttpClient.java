// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import android.content.Context;
import android.os.Message;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.loopj.android.http:
//            AsyncHttpClient, AsyncHttpRequest, AsyncHttpResponseHandler, RequestParams

public abstract class SyncHttpClient extends AsyncHttpClient
{

    private int responseCode;
    AsyncHttpResponseHandler responseHandler;
    private String result;

    public SyncHttpClient()
    {
        responseHandler = new AsyncHttpResponseHandler() {

            final SyncHttpClient this$0;

            public void onFailure(Throwable throwable, String s)
            {
                result = onRequestFailed(throwable, s);
            }

            public void onSuccess(String s)
            {
                result = s;
            }

            protected void sendMessage(Message message)
            {
                handleMessage(message);
            }

            void sendResponseMessage(HttpResponse httpresponse)
            {
                responseCode = httpresponse.getStatusLine().getStatusCode();
                super.sendResponseMessage(httpresponse);
            }

            
            {
                this$0 = SyncHttpClient.this;
                super();
            }
        };
    }

    public String delete(String s)
    {
        delete(s, null, responseHandler);
        return result;
    }

    public String delete(String s, RequestParams requestparams)
    {
        delete(s, requestparams, responseHandler);
        return result;
    }

    public void delete(String s, RequestParams requestparams, AsyncHttpResponseHandler asynchttpresponsehandler)
    {
        delete(s, asynchttpresponsehandler);
    }

    public String get(String s)
    {
        get(s, null, responseHandler);
        return result;
    }

    public String get(String s, RequestParams requestparams)
    {
        get(s, requestparams, responseHandler);
        return result;
    }

    public int getResponseCode()
    {
        return responseCode;
    }

    public abstract String onRequestFailed(Throwable throwable, String s);

    public String post(String s)
    {
        post(s, null, responseHandler);
        return result;
    }

    public String post(String s, RequestParams requestparams)
    {
        post(s, requestparams, responseHandler);
        return result;
    }

    public String put(String s)
    {
        put(s, null, responseHandler);
        return result;
    }

    public String put(String s, RequestParams requestparams)
    {
        put(s, requestparams, responseHandler);
        return result;
    }

    protected void sendRequest(DefaultHttpClient defaulthttpclient, HttpContext httpcontext, HttpUriRequest httpurirequest, String s, AsyncHttpResponseHandler asynchttpresponsehandler, Context context)
    {
        if (s != null)
        {
            httpurirequest.addHeader("Content-Type", s);
        }
        (new AsyncHttpRequest(defaulthttpclient, httpcontext, httpurirequest, asynchttpresponsehandler)).run();
    }


/*
    static int access$002(SyncHttpClient synchttpclient, int i)
    {
        synchttpclient.responseCode = i;
        return i;
    }

*/


/*
    static String access$102(SyncHttpClient synchttpclient, String s)
    {
        synchttpclient.result = s;
        return s;
    }

*/
}
