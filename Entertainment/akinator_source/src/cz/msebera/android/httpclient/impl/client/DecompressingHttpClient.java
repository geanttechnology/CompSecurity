// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package cz.msebera.android.httpclient.impl.client;

import cz.msebera.android.httpclient.HttpEntityEnclosingRequest;
import cz.msebera.android.httpclient.HttpException;
import cz.msebera.android.httpclient.HttpHost;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.HttpResponseInterceptor;
import cz.msebera.android.httpclient.client.ClientProtocolException;
import cz.msebera.android.httpclient.client.HttpClient;
import cz.msebera.android.httpclient.client.ResponseHandler;
import cz.msebera.android.httpclient.client.methods.HttpUriRequest;
import cz.msebera.android.httpclient.client.protocol.RequestAcceptEncoding;
import cz.msebera.android.httpclient.client.protocol.ResponseContentEncoding;
import cz.msebera.android.httpclient.client.utils.URIUtils;
import cz.msebera.android.httpclient.conn.ClientConnectionManager;
import cz.msebera.android.httpclient.params.HttpParams;
import cz.msebera.android.httpclient.protocol.BasicHttpContext;
import cz.msebera.android.httpclient.protocol.HttpContext;
import cz.msebera.android.httpclient.util.EntityUtils;
import java.io.IOException;

// Referenced classes of package cz.msebera.android.httpclient.impl.client:
//            DefaultHttpClient, EntityEnclosingRequestWrapper, RequestWrapper

public class DecompressingHttpClient
    implements HttpClient
{

    private final HttpRequestInterceptor acceptEncodingInterceptor;
    private final HttpClient backend;
    private final HttpResponseInterceptor contentEncodingInterceptor;

    public DecompressingHttpClient()
    {
        this(((HttpClient) (new DefaultHttpClient())));
    }

    public DecompressingHttpClient(HttpClient httpclient)
    {
        this(httpclient, ((HttpRequestInterceptor) (new RequestAcceptEncoding())), ((HttpResponseInterceptor) (new ResponseContentEncoding())));
    }

    DecompressingHttpClient(HttpClient httpclient, HttpRequestInterceptor httprequestinterceptor, HttpResponseInterceptor httpresponseinterceptor)
    {
        backend = httpclient;
        acceptEncodingInterceptor = httprequestinterceptor;
        contentEncodingInterceptor = httpresponseinterceptor;
    }

    public HttpResponse execute(HttpHost httphost, HttpRequest httprequest)
        throws IOException, ClientProtocolException
    {
        return execute(httphost, httprequest, (HttpContext)null);
    }

    public HttpResponse execute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
        throws IOException, ClientProtocolException
    {
        if (httpcontext == null)
        {
            try
            {
                httpcontext = new BasicHttpContext();
            }
            // Misplaced declaration of an exception variable
            catch (HttpHost httphost)
            {
                throw new ClientProtocolException(httphost);
            }
        }
        if (!(httprequest instanceof HttpEntityEnclosingRequest))
        {
            break MISSING_BLOCK_LABEL_122;
        }
        httprequest = new EntityEnclosingRequestWrapper((HttpEntityEnclosingRequest)httprequest);
_L1:
        acceptEncodingInterceptor.process(httprequest, httpcontext);
        httphost = backend.execute(httphost, httprequest, httpcontext);
        contentEncodingInterceptor.process(httphost, httpcontext);
        if (Boolean.TRUE.equals(httpcontext.getAttribute("http.client.response.uncompressed")))
        {
            httphost.removeHeaders("Content-Length");
            httphost.removeHeaders("Content-Encoding");
            httphost.removeHeaders("Content-MD5");
        }
        return httphost;
        httprequest = new RequestWrapper(httprequest);
          goto _L1
        httprequest;
        EntityUtils.consume(httphost.getEntity());
        throw httprequest;
        httprequest;
        EntityUtils.consume(httphost.getEntity());
        throw httprequest;
        httprequest;
        EntityUtils.consume(httphost.getEntity());
        throw httprequest;
    }

    public HttpResponse execute(HttpUriRequest httpurirequest)
        throws IOException, ClientProtocolException
    {
        return execute(getHttpHost(httpurirequest), ((HttpRequest) (httpurirequest)), (HttpContext)null);
    }

    public HttpResponse execute(HttpUriRequest httpurirequest, HttpContext httpcontext)
        throws IOException, ClientProtocolException
    {
        return execute(getHttpHost(httpurirequest), ((HttpRequest) (httpurirequest)), httpcontext);
    }

    public Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler)
        throws IOException, ClientProtocolException
    {
        return execute(httphost, httprequest, responsehandler, null);
    }

    public Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler, HttpContext httpcontext)
        throws IOException, ClientProtocolException
    {
        httphost = execute(httphost, httprequest, httpcontext);
        httprequest = ((HttpRequest) (responsehandler.handleResponse(httphost)));
        httphost = httphost.getEntity();
        if (httphost != null)
        {
            EntityUtils.consume(httphost);
        }
        return httprequest;
        httprequest;
        httphost = httphost.getEntity();
        if (httphost != null)
        {
            EntityUtils.consume(httphost);
        }
        throw httprequest;
    }

    public Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler)
        throws IOException, ClientProtocolException
    {
        return execute(getHttpHost(httpurirequest), ((HttpRequest) (httpurirequest)), responsehandler);
    }

    public Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler, HttpContext httpcontext)
        throws IOException, ClientProtocolException
    {
        return execute(getHttpHost(httpurirequest), ((HttpRequest) (httpurirequest)), responsehandler, httpcontext);
    }

    public ClientConnectionManager getConnectionManager()
    {
        return backend.getConnectionManager();
    }

    public HttpClient getHttpClient()
    {
        return backend;
    }

    HttpHost getHttpHost(HttpUriRequest httpurirequest)
    {
        return URIUtils.extractHost(httpurirequest.getURI());
    }

    public HttpParams getParams()
    {
        return backend.getParams();
    }
}
