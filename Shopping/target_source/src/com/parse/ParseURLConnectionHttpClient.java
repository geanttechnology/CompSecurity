// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import com.parse.http.ParseHttpBody;
import com.parse.http.ParseHttpRequest;
import com.parse.http.ParseHttpResponse;
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
//            ParseHttpClient

class ParseURLConnectionHttpClient extends ParseHttpClient
{

    private static final String ACCEPT_ENCODING_HEADER = "Accept-encoding";
    private static final String CONTENT_LENGTH_HEADER = "Content-Length";
    private static final String CONTENT_TYPE_HEADER = "Content-Type";
    private static final String GZIP_ENCODING = "gzip";
    private int socketOperationTimeout;

    public ParseURLConnectionHttpClient(int i, SSLSessionCache sslsessioncache)
    {
        socketOperationTimeout = i;
        HttpsURLConnection.setDefaultSSLSocketFactory(SSLCertificateSocketFactory.getDefault(i, sslsessioncache));
    }

    ParseHttpResponse executeInternal(ParseHttpRequest parsehttprequest)
        throws IOException
    {
        HttpURLConnection httpurlconnection = getRequest(parsehttprequest);
        parsehttprequest = parsehttprequest.getBody();
        if (parsehttprequest != null)
        {
            OutputStream outputstream = httpurlconnection.getOutputStream();
            parsehttprequest.writeTo(outputstream);
            outputstream.flush();
            outputstream.close();
        }
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

        if (disableHttpLibraryAutoDecompress())
        {
            httpurlconnection.setRequestProperty("Accept-encoding", "gzip");
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
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            Object obj = (java.util.Map.Entry)iterator.next();
            if (((java.util.Map.Entry) (obj)).getKey() != null && ((List)((java.util.Map.Entry) (obj)).getValue()).size() > 0)
            {
                Object obj1 = ((java.util.Map.Entry) (obj)).getKey();
                if (((java.util.Map.Entry) (obj)).getValue() == null)
                {
                    obj = "";
                } else
                {
                    obj = (String)((List)((java.util.Map.Entry) (obj)).getValue()).get(0);
                }
                hashmap.put(obj1, obj);
            }
        } while (true);
        httpurlconnection = httpurlconnection.getContentType();
        return (new com.parse.http.ParseHttpResponse.Builder()).setStatusCode(i).setContent(inputstream).setTotalSize(j).setReasonPhrase(s).setHeaders(hashmap).setContentType(httpurlconnection).build();
    }
}
