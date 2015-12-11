// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.ansel.fetch.tools.web.apache.apache40;

import com.amazon.ansel.fetch.tools.collection.CollectionMap;
import com.amazon.ansel.fetch.tools.web.HttpScheme;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.amazon.ansel.fetch.tools.web.apache.apache40:
//            KeepAliveStrategy, GzipEntityWrapper

public class ApacheUtil
{

    public ApacheUtil()
    {
    }

    public static void configureClient(AbstractHttpClient abstracthttpclient)
    {
        configureClient(abstracthttpclient, true, 0x493e0, null);
    }

    public static void configureClient(AbstractHttpClient abstracthttpclient, boolean flag, int i, CollectionMap collectionmap)
    {
        if (flag || collectionmap != null && collectionmap.size() > 0)
        {
            if (collectionmap != null)
            {
                collectionmap = new CollectionMap(collectionmap);
            } else
            {
                collectionmap = null;
            }
            abstracthttpclient.addRequestInterceptor(new HttpRequestInterceptor(flag, collectionmap) {

                final boolean val$enableGzip;
                final CollectionMap val$requestHeaders;

                public void process(HttpRequest httprequest, HttpContext httpcontext)
                    throws HttpException, IOException
                {
                    if (enableGzip && !httprequest.containsHeader("Accept-Encoding"))
                    {
                        httprequest.addHeader("Accept-Encoding", "gzip");
                    }
                    if (requestHeaders != null)
                    {
                        for (httpcontext = requestHeaders.entrySet().iterator(); httpcontext.hasNext();)
                        {
                            java.util.Map.Entry entry = (java.util.Map.Entry)httpcontext.next();
                            Iterator iterator = ((List)entry.getValue()).iterator();
                            while (iterator.hasNext()) 
                            {
                                String s = (String)iterator.next();
                                httprequest.addHeader((String)entry.getKey(), s);
                            }
                        }

                    }
                }

            
            {
                enableGzip = flag;
                requestHeaders = collectionmap;
                super();
            }
            });
        }
        if (flag)
        {
            abstracthttpclient.addResponseInterceptor(new HttpResponseInterceptor() {

                public void process(HttpResponse httpresponse, HttpContext httpcontext)
                    throws HttpException, IOException
                {
                    httpcontext = httpresponse.getEntity();
                    if (httpcontext != null) goto _L2; else goto _L1
_L1:
                    return;
_L2:
                    if ((httpcontext = httpcontext.getContentEncoding()) != null)
                    {
                        httpcontext = httpcontext.getElements();
                        int k = httpcontext.length;
                        int j = 0;
                        while (j < k) 
                        {
                            if (httpcontext[j].getName().equalsIgnoreCase("gzip"))
                            {
                                httpresponse.setEntity(new GzipEntityWrapper(httpresponse.getEntity()));
                                return;
                            }
                            j++;
                        }
                    }
                    if (true) goto _L1; else goto _L3
_L3:
                }

            });
        }
        if (i >= 0)
        {
            abstracthttpclient.setKeepAliveStrategy(new KeepAliveStrategy(i));
        }
    }

    public static ClientConnectionManager createConnectionManager(HttpParams httpparams)
    {
        SchemeRegistry schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme(HttpScheme.HTTP.getName(), PlainSocketFactory.getSocketFactory(), 80));
        schemeregistry.register(new Scheme(HttpScheme.HTTPS.getName(), SSLSocketFactory.getSocketFactory(), 443));
        return new ThreadSafeClientConnManager(httpparams, schemeregistry);
    }

    public static HttpClient createHttpClient(HttpParams httpparams, ClientConnectionManager clientconnectionmanager)
    {
        httpparams = new DefaultHttpClient(clientconnectionmanager, httpparams);
        configureClient(httpparams);
        return httpparams;
    }

    public static HttpParams createHttpParams(int i)
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        ConnManagerParams.setMaxTotalConnections(basichttpparams, i);
        ConnManagerParams.setMaxConnectionsPerRoute(basichttpparams, new ConnPerRouteBean(i));
        ConnManagerParams.setTimeout(basichttpparams, 30000L);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        HttpConnectionParams.setTcpNoDelay(basichttpparams, true);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 30000);
        HttpConnectionParams.setSoTimeout(basichttpparams, 30000);
        HttpProtocolParams.setVersion(basichttpparams, HttpVersion.HTTP_1_1);
        basichttpparams.setParameter("http.protocol.cookie-policy", "compatibility");
        return basichttpparams;
    }
}
