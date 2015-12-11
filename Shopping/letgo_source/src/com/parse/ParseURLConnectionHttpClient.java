// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.net.ssl.HttpsURLConnection;

// Referenced classes of package com.parse:
//            ParseHttpClient, ParseHttpRequest, ParseHttpBody, ParseHttpResponse

class ParseURLConnectionHttpClient extends ParseHttpClient
{

    private int socketOperationTimeout;

    public ParseURLConnectionHttpClient(int i, SSLSessionCache sslsessioncache)
    {
        socketOperationTimeout = i;
        HttpsURLConnection.setDefaultSSLSocketFactory(SSLCertificateSocketFactory.getDefault(i, sslsessioncache));
    }

    private static void setParseRequestCancelRunnable(ParseHttpRequest parsehttprequest, HttpURLConnection httpurlconnection)
    {
        parsehttprequest.setCancelRunnable(new Runnable(httpurlconnection) {

            final HttpURLConnection val$connection;

            public void run()
            {
                connection.disconnect();
            }

            
            {
                connection = httpurlconnection;
                super();
            }
        });
    }

    ParseHttpResponse executeInternal(ParseHttpRequest parsehttprequest)
        throws IOException
    {
        HttpURLConnection httpurlconnection = getRequest(parsehttprequest);
        ParseHttpBody parsehttpbody = parsehttprequest.getBody();
        if (parsehttpbody != null)
        {
            OutputStream outputstream = httpurlconnection.getOutputStream();
            parsehttpbody.writeTo(outputstream);
            outputstream.flush();
            outputstream.close();
        }
        setParseRequestCancelRunnable(parsehttprequest, httpurlconnection);
        return getResponse(httpurlconnection);
    }

    volatile Object getRequest(ParseHttpRequest parsehttprequest)
        throws IOException
    {
        return getRequest(parsehttprequest);
    }

    HttpURLConnection getRequest(ParseHttpRequest parsehttprequest)
        throws IOException
    {
        HttpURLConnection httpurlconnection = (HttpURLConnection)HttpInstrumentation.openConnection((new URL(parsehttprequest.getUrl())).openConnection());
        httpurlconnection.setRequestMethod(parsehttprequest.getMethod().toString());
        httpurlconnection.setConnectTimeout(socketOperationTimeout);
        httpurlconnection.setReadTimeout(socketOperationTimeout);
        httpurlconnection.setDoInput(true);
        httpurlconnection.setInstanceFollowRedirects(false);
        java.util.Map.Entry entry;
        for (Iterator iterator = parsehttprequest.getAllHeaders().entrySet().iterator(); iterator.hasNext(); httpurlconnection.setRequestProperty((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        parsehttprequest = parsehttprequest.getBody();
        if (parsehttprequest != null)
        {
            httpurlconnection.setRequestProperty("Content-Length", String.valueOf(parsehttprequest.getContentLength()));
            httpurlconnection.setRequestProperty("Content-Type", parsehttprequest.getContentType());
            httpurlconnection.setFixedLengthStreamingMode(parsehttprequest.getContentLength());
            httpurlconnection.setDoOutput(true);
        }
        return httpurlconnection;
    }

    volatile ParseHttpResponse getResponse(Object obj)
        throws IOException
    {
        return getResponse((HttpURLConnection)obj);
    }

    ParseHttpResponse getResponse(HttpURLConnection httpurlconnection)
        throws IOException
    {
        int i = httpurlconnection.getResponseCode();
        java.io.InputStream inputstream;
        String s;
        HashMap hashmap;
        Iterator iterator;
        int j;
        if (i < 400)
        {
            inputstream = httpurlconnection.getInputStream();
        } else
        {
            inputstream = httpurlconnection.getErrorStream();
        }
        j = httpurlconnection.getContentLength();
        s = httpurlconnection.getResponseMessage();
        hashmap = new HashMap();
        iterator = httpurlconnection.getHeaderFields().entrySet().iterator();
        while (iterator.hasNext()) 
        {
            Object obj = (java.util.Map.Entry)iterator.next();
            Object obj1 = ((java.util.Map.Entry) (obj)).getKey();
            if (((java.util.Map.Entry) (obj)).getValue() == null)
            {
                obj = "";
            } else
            {
                obj = ((List)((java.util.Map.Entry) (obj)).getValue()).toString();
            }
            hashmap.put(obj1, obj);
        }
        httpurlconnection = httpurlconnection.getContentType();
        return ((ParseHttpResponse.Builder)((ParseHttpResponse.Builder)((ParseHttpResponse.Builder)((ParseHttpResponse.Builder)((ParseHttpResponse.Builder)((ParseHttpResponse.Builder)(new ParseHttpResponse.Builder()).setStatusCode(i)).setContent(inputstream)).setTotalSize(j)).setReasonPhase(s)).setHeaders(hashmap)).setContentType(httpurlconnection)).build();
    }
}
