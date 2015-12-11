// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.http.httpCore;

import com.poshmark.application.AppInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

public class PMHttpClient
{
    private static class InflatingEntity extends HttpEntityWrapper
    {

        public InputStream getContent()
            throws IOException
        {
            return new GZIPInputStream(wrappedEntity.getContent());
        }

        public long getContentLength()
        {
            return -1L;
        }

        public InflatingEntity(HttpEntity httpentity)
        {
            super(httpentity);
        }
    }

    private static class SingletonHolder
    {

        public static final PMHttpClient INSTANCE = new PMHttpClient();


        private SingletonHolder()
        {
        }
    }


    public static final int DEFAULT_MAX_CONNECTIONS = 10;
    public static final int DEFAULT_MAX_CONNECTIONS_PER_ROUTE = 10;
    public static final int DEFAULT_SOCKET_BUFFER_SIZE = 8192;
    final HttpClient httpClient;

    private PMHttpClient()
    {
        Object obj = new BasicHttpParams();
        ConnManagerParams.setTimeout(((org.apache.http.params.HttpParams) (obj)), 20000L);
        ConnManagerParams.setMaxConnectionsPerRoute(((org.apache.http.params.HttpParams) (obj)), new ConnPerRouteBean(10));
        ConnManagerParams.setMaxTotalConnections(((org.apache.http.params.HttpParams) (obj)), 10);
        HttpConnectionParams.setSoTimeout(((org.apache.http.params.HttpParams) (obj)), 20000);
        HttpConnectionParams.setConnectionTimeout(((org.apache.http.params.HttpParams) (obj)), 20000);
        HttpConnectionParams.setTcpNoDelay(((org.apache.http.params.HttpParams) (obj)), true);
        HttpConnectionParams.setSocketBufferSize(((org.apache.http.params.HttpParams) (obj)), 8192);
        HttpProtocolParams.setVersion(((org.apache.http.params.HttpParams) (obj)), HttpVersion.HTTP_1_1);
        HttpProtocolParams.setUserAgent(((org.apache.http.params.HttpParams) (obj)), AppInfo.getInstance().userAgent);
        SchemeRegistry schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeregistry.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        obj = new DefaultHttpClient(new ThreadSafeClientConnManager(((org.apache.http.params.HttpParams) (obj)), schemeregistry), ((org.apache.http.params.HttpParams) (obj)));
        httpClient = ((HttpClient) (obj));
        ((DefaultHttpClient) (obj)).addRequestInterceptor(new HttpRequestInterceptor() {

            final PMHttpClient this$0;

            public void process(HttpRequest httprequest, HttpContext httpcontext)
            {
                if (!httprequest.containsHeader("Accept-Encoding"))
                {
                    httprequest.addHeader("Accept-Encoding", "gzip");
                }
            }

            
            {
                this$0 = PMHttpClient.this;
                super();
            }
        });
        ((DefaultHttpClient) (obj)).addResponseInterceptor(new HttpResponseInterceptor() {

            final PMHttpClient this$0;

            public void process(HttpResponse httpresponse, HttpContext httpcontext)
            {
                httpcontext = httpresponse.getEntity();
                if (httpcontext != null) goto _L2; else goto _L1
_L1:
                return;
_L2:
                if ((httpcontext = httpcontext.getContentEncoding()) != null)
                {
                    httpcontext = httpcontext.getElements();
                    int j = httpcontext.length;
                    int i = 0;
                    while (i < j) 
                    {
                        if (httpcontext[i].getName().equalsIgnoreCase("gzip"))
                        {
                            httpresponse.setEntity(new InflatingEntity(httpresponse.getEntity()));
                            return;
                        }
                        i++;
                    }
                }
                if (true) goto _L1; else goto _L3
_L3:
            }

            
            {
                this$0 = PMHttpClient.this;
                super();
            }
        });
    }


    static PMHttpClient getInstance()
    {
        return SingletonHolder.INSTANCE;
    }
}
