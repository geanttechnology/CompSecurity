// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.apache;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.ResponseBody;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.params.AbstractHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.squareup.okhttp.apache:
//            HttpEntityBody

public final class OkApacheClient
    implements HttpClient
{

    private final OkHttpClient client;
    private final HttpParams params;

    public OkApacheClient()
    {
        this(new OkHttpClient());
    }

    public OkApacheClient(OkHttpClient okhttpclient)
    {
        params = new AbstractHttpParams() {

            final OkApacheClient this$0;

            public HttpParams setParameter(String s, Object obj)
            {
                if (s.equals("http.route.default-proxy"))
                {
                    obj = (HttpHost)obj;
                    s = null;
                    if (obj != null)
                    {
                        s = new Proxy(java.net.Proxy.Type.HTTP, new InetSocketAddress(((HttpHost) (obj)).getHostName(), ((HttpHost) (obj)).getPort()));
                    }
                    client.setProxy(s);
                    return this;
                } else
                {
                    throw new IllegalArgumentException(s);
                }
            }

            
            {
                this$0 = OkApacheClient.this;
                super();
            }
        };
        client = okhttpclient;
    }

    private static void consumeContentQuietly(HttpResponse httpresponse)
    {
        try
        {
            httpresponse.getEntity().consumeContent();
            return;
        }
        // Misplaced declaration of an exception variable
        catch (HttpResponse httpresponse)
        {
            return;
        }
    }

    private static Request transformRequest(HttpRequest httprequest)
    {
        com.squareup.okhttp.Request.Builder builder = new com.squareup.okhttp.Request.Builder();
        Object obj = httprequest.getRequestLine();
        String s = ((RequestLine) (obj)).getMethod();
        builder.url(((RequestLine) (obj)).getUri());
        Object obj1 = null;
        Header aheader[] = httprequest.getAllHeaders();
        int j = aheader.length;
        int i = 0;
        while (i < j) 
        {
            Header header = aheader[i];
            String s1 = header.getName();
            if ("Content-Type".equalsIgnoreCase(s1))
            {
                obj1 = header.getValue();
            } else
            {
                builder.header(s1, header.getValue());
            }
            i++;
        }
        aheader = null;
        if (httprequest instanceof HttpEntityEnclosingRequest)
        {
            aheader = ((HttpEntityEnclosingRequest)httprequest).getEntity();
            if (aheader != null)
            {
                httprequest = new HttpEntityBody(aheader, ((String) (obj1)));
                obj1 = aheader.getContentEncoding();
                aheader = httprequest;
                if (obj1 != null)
                {
                    builder.header(((Header) (obj1)).getName(), ((Header) (obj1)).getValue());
                    aheader = httprequest;
                }
            } else
            {
                aheader = RequestBody.create(null, new byte[0]);
            }
        }
        builder.method(s, aheader);
        return builder.build();
    }

    private static HttpResponse transformResponse(Response response)
        throws IOException
    {
        int i = response.code();
        Object obj = response.message();
        obj = new BasicHttpResponse(HttpVersion.HTTP_1_1, i, ((String) (obj)));
        Object obj1 = response.body();
        obj1 = new InputStreamEntity(((ResponseBody) (obj1)).byteStream(), ((ResponseBody) (obj1)).contentLength());
        ((BasicHttpResponse) (obj)).setEntity(((HttpEntity) (obj1)));
        response = response.headers();
        i = 0;
        int j = response.size();
        while (i < j) 
        {
            String s = response.name(i);
            String s1 = response.value(i);
            ((BasicHttpResponse) (obj)).addHeader(s, s1);
            if ("Content-Type".equalsIgnoreCase(s))
            {
                ((InputStreamEntity) (obj1)).setContentType(s1);
            } else
            if ("Content-Encoding".equalsIgnoreCase(s))
            {
                ((InputStreamEntity) (obj1)).setContentEncoding(s1);
            }
            i++;
        }
        return ((HttpResponse) (obj));
    }

    public Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler)
        throws IOException
    {
        return execute(httphost, httprequest, responsehandler, null);
    }

    public Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler, HttpContext httpcontext)
        throws IOException
    {
        httphost = execute(httphost, httprequest, httpcontext);
        httprequest = ((HttpRequest) (responsehandler.handleResponse(httphost)));
        consumeContentQuietly(httphost);
        return httprequest;
        httprequest;
        consumeContentQuietly(httphost);
        throw httprequest;
    }

    public Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler)
        throws IOException
    {
        return execute(null, ((HttpRequest) (httpurirequest)), responsehandler, null);
    }

    public Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler, HttpContext httpcontext)
        throws IOException
    {
        return execute(null, ((HttpRequest) (httpurirequest)), responsehandler, httpcontext);
    }

    public HttpResponse execute(HttpHost httphost, HttpRequest httprequest)
        throws IOException
    {
        return execute(httphost, httprequest, (HttpContext)null);
    }

    public HttpResponse execute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws IOException
    {
        httphost = transformRequest(httprequest);
        return transformResponse(client.newCall(httphost).execute());
    }

    public HttpResponse execute(HttpUriRequest httpurirequest)
        throws IOException
    {
        return execute(((HttpHost) (null)), ((HttpRequest) (httpurirequest)), (HttpContext)null);
    }

    public HttpResponse execute(HttpUriRequest httpurirequest, HttpContext httpcontext)
        throws IOException
    {
        return execute(((HttpHost) (null)), ((HttpRequest) (httpurirequest)), httpcontext);
    }

    public ClientConnectionManager getConnectionManager()
    {
        throw new UnsupportedOperationException();
    }

    public HttpParams getParams()
    {
        return params;
    }

}
