// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api.common.io;

import android.content.ContentResolver;
import android.os.Build;
import android.os.SystemClock;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.ProtocolException;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.impl.client.EntityEnclosingRequestWrapper;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.google.userfeedback.android.api.common.io:
//            AndroidHttpClient

public class GoogleHttpClient
    implements HttpClient
{

    private static final String TAG = "GoogleHttpClient_v09";
    private final AndroidHttpClient mClient;
    private final ContentResolver mResolver;
    private final String mUserAgent;

    public GoogleHttpClient(ContentResolver contentresolver, String s)
    {
        mClient = AndroidHttpClient.newInstance(s);
        mResolver = contentresolver;
        mUserAgent = s;
    }

    public GoogleHttpClient(ContentResolver contentresolver, String s, boolean flag)
    {
        String s1 = String.valueOf(Build.DEVICE);
        String s2 = String.valueOf(Build.ID);
        s1 = (new StringBuilder(String.valueOf(s).length() + 4 + String.valueOf(s1).length() + String.valueOf(s2).length())).append(s).append(" (").append(s1).append(" ").append(s2).append(")").toString();
        s = s1;
        if (flag)
        {
            s = String.valueOf(s1).concat("; gzip");
        }
        mClient = AndroidHttpClient.newInstance(s);
        mResolver = contentresolver;
        mUserAgent = s;
    }

    public static String getGzipCapableUserAgent(String s)
    {
        return String.valueOf(s).concat("; gzip");
    }

    private static RequestWrapper wrapRequest(HttpUriRequest httpurirequest)
    {
        if (!(httpurirequest instanceof HttpEntityEnclosingRequest))
        {
            break MISSING_BLOCK_LABEL_25;
        }
        httpurirequest = new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest)httpurirequest);
_L1:
        httpurirequest.resetHeaders();
        return httpurirequest;
        try
        {
            httpurirequest = new RequestWrapper(httpurirequest);
        }
        // Misplaced declaration of an exception variable
        catch (HttpUriRequest httpurirequest)
        {
            throw new ClientProtocolException(httpurirequest);
        }
          goto _L1
    }

    public void close()
    {
        mClient.close();
    }

    public void disableCurlLogging()
    {
        mClient.disableCurlLogging();
    }

    public void enableCurlLogging(String s, int i)
    {
        mClient.enableCurlLogging(s, i);
    }

    public Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler)
    {
        return mClient.execute(httphost, httprequest, responsehandler);
    }

    public Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler, HttpContext httpcontext)
    {
        return mClient.execute(httphost, httprequest, responsehandler, httpcontext);
    }

    public Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler)
    {
        return mClient.execute(httpurirequest, responsehandler);
    }

    public Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler, HttpContext httpcontext)
    {
        return mClient.execute(httpurirequest, responsehandler, httpcontext);
    }

    public HttpResponse execute(HttpHost httphost, HttpRequest httprequest)
    {
        return mClient.execute(httphost, httprequest);
    }

    public HttpResponse execute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
    {
        return mClient.execute(httphost, httprequest, httpcontext);
    }

    public HttpResponse execute(HttpUriRequest httpurirequest)
    {
        return execute(httpurirequest, ((HttpContext) (null)));
    }

    public HttpResponse execute(HttpUriRequest httpurirequest, HttpContext httpcontext)
    {
        String s = httpurirequest.getURI().toString();
        URI uri;
        try
        {
            uri = new URI(s);
        }
        // Misplaced declaration of an exception variable
        catch (HttpContext httpcontext)
        {
            httpurirequest = String.valueOf(s);
            if (httpurirequest.length() != 0)
            {
                httpurirequest = "Bad URL from: ".concat(httpurirequest);
            } else
            {
                httpurirequest = new String("Bad URL from: ");
            }
            throw new RuntimeException(httpurirequest, httpcontext);
        }
        httpurirequest = wrapRequest(httpurirequest);
        httpurirequest.setURI(uri);
        return executeWithoutRewriting(httpurirequest, httpcontext);
    }

    public HttpResponse executeWithoutRewriting(HttpUriRequest httpurirequest, HttpContext httpcontext)
    {
        SystemClock.elapsedRealtime();
        try
        {
            httpurirequest = mClient.execute(httpurirequest, httpcontext);
            Integer.toString(httpurirequest.getStatusLine().getStatusCode());
        }
        // Misplaced declaration of an exception variable
        catch (HttpUriRequest httpurirequest)
        {
            throw httpurirequest;
        }
        return httpurirequest;
    }

    public ClientConnectionManager getConnectionManager()
    {
        return mClient.getConnectionManager();
    }

    public HttpParams getParams()
    {
        return mClient.getParams();
    }
}
