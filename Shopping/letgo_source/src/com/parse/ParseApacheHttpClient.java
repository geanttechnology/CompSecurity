// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.net.SSLCertificateSocketFactory;
import android.net.SSLSessionCache;
import android.net.http.AndroidHttpClient;
import com.newrelic.agent.android.instrumentation.HttpInstrumentation;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.params.ConnPerRouteBean;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

// Referenced classes of package com.parse:
//            ParseHttpClient, ParseHttpRequest, ParseHttpResponse, ParseHttpBody

class ParseApacheHttpClient extends ParseHttpClient
{
    private static class ParseApacheHttpEntity extends InputStreamEntity
    {

        private ParseHttpBody parseBody;

        public void writeTo(OutputStream outputstream)
            throws IOException
        {
            parseBody.writeTo(outputstream);
        }

        public ParseApacheHttpEntity(ParseHttpBody parsehttpbody)
        {
            super(parsehttpbody.getContent(), parsehttpbody.getContentLength());
            super.setContentType(parsehttpbody.getContentType());
            parseBody = parsehttpbody;
        }
    }


    private DefaultHttpClient apacheClient;

    public ParseApacheHttpClient(int i, SSLSessionCache sslsessioncache)
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(basichttpparams, false);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, i);
        HttpConnectionParams.setSoTimeout(basichttpparams, i);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        HttpClientParams.setRedirecting(basichttpparams, false);
        SchemeRegistry schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeregistry.register(new Scheme("https", SSLCertificateSocketFactory.getHttpSocketFactory(i, sslsessioncache), 443));
        sslsessioncache = System.getProperty("http.maxConnections");
        if (sslsessioncache != null)
        {
            i = Integer.parseInt(sslsessioncache);
            ConnManagerParams.setMaxConnectionsPerRoute(basichttpparams, new ConnPerRouteBean(i));
            ConnManagerParams.setMaxTotalConnections(basichttpparams, i);
        }
        sslsessioncache = System.getProperty("http.proxyHost");
        String s = System.getProperty("http.proxyPort");
        if (sslsessioncache != null && sslsessioncache.length() != 0 && s != null && s.length() != 0)
        {
            basichttpparams.setParameter("http.route.default-proxy", new HttpHost(sslsessioncache, Integer.parseInt(s), "http"));
        }
        apacheClient = new DefaultHttpClient(new ThreadSafeClientConnManager(basichttpparams, schemeregistry), basichttpparams);
    }

    private static void setParseRequestCancelRunnable(ParseHttpRequest parsehttprequest, HttpUriRequest httpurirequest)
    {
        parsehttprequest.setCancelRunnable(new Runnable(httpurirequest) {

            final HttpUriRequest val$apacheRequest;

            public void run()
            {
                apacheRequest.abort();
            }

            
            {
                apacheRequest = httpurirequest;
                super();
            }
        });
    }

    ParseHttpResponse executeInternal(ParseHttpRequest parsehttprequest)
        throws IOException
    {
        HttpUriRequest httpurirequest = getRequest(parsehttprequest);
        setParseRequestCancelRunnable(parsehttprequest, httpurirequest);
        parsehttprequest = apacheClient;
        if (!(parsehttprequest instanceof HttpClient))
        {
            parsehttprequest = parsehttprequest.execute(httpurirequest);
        } else
        {
            parsehttprequest = HttpInstrumentation.execute((HttpClient)parsehttprequest, httpurirequest);
        }
        return getResponse(parsehttprequest);
    }

    volatile Object getRequest(ParseHttpRequest parsehttprequest)
        throws IOException
    {
        return getRequest(parsehttprequest);
    }

    HttpUriRequest getRequest(ParseHttpRequest parsehttprequest)
        throws IOException
    {
        Object obj;
        ParseRequest.Method method;
        if (parsehttprequest == null)
        {
            throw new IllegalArgumentException("ParseHttpRequest passed to getApacheRequest should not be null.");
        }
        method = parsehttprequest.getMethod();
        obj = parsehttprequest.getUrl();
        static class _cls2
        {

            static final int $SwitchMap$com$parse$ParseRequest$Method[];

            static 
            {
                $SwitchMap$com$parse$ParseRequest$Method = new int[ParseRequest.Method.values().length];
                try
                {
                    $SwitchMap$com$parse$ParseRequest$Method[ParseRequest.Method.GET.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$com$parse$ParseRequest$Method[ParseRequest.Method.DELETE.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$com$parse$ParseRequest$Method[ParseRequest.Method.POST.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$com$parse$ParseRequest$Method[ParseRequest.Method.PUT.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls2..SwitchMap.com.parse.ParseRequest.Method[method.ordinal()];
        JVM INSTR tableswitch 1 4: default 64
    //                   1 94
    //                   2 170
    //                   3 182
    //                   4 194;
           goto _L1 _L2 _L3 _L4 _L5
_L1:
        throw new IllegalStateException((new StringBuilder()).append("Unsupported http method ").append(method.toString()).toString());
_L2:
        obj = new HttpGet(((String) (obj)));
_L7:
        java.util.Map.Entry entry;
        for (Iterator iterator = parsehttprequest.getAllHeaders().entrySet().iterator(); iterator.hasNext(); ((HttpUriRequest) (obj)).setHeader((String)entry.getKey(), (String)entry.getValue()))
        {
            entry = (java.util.Map.Entry)iterator.next();
        }

        break; /* Loop/switch isn't completed */
_L3:
        obj = new HttpDelete(((String) (obj)));
        continue; /* Loop/switch isn't completed */
_L4:
        obj = new HttpPost(((String) (obj)));
        continue; /* Loop/switch isn't completed */
_L5:
        obj = new HttpPut(((String) (obj)));
        if (true) goto _L7; else goto _L6
_L6:
        AndroidHttpClient.modifyRequestToAcceptGzipResponse(((org.apache.http.HttpRequest) (obj)));
        parsehttprequest = parsehttprequest.getBody();
        switch (_cls2..SwitchMap.com.parse.ParseRequest.Method[method.ordinal()])
        {
        default:
            return ((HttpUriRequest) (obj));

        case 3: // '\003'
            ((HttpPost)obj).setEntity(new ParseApacheHttpEntity(parsehttprequest));
            return ((HttpUriRequest) (obj));

        case 4: // '\004'
            ((HttpPut)obj).setEntity(new ParseApacheHttpEntity(parsehttprequest));
            break;
        }
        return ((HttpUriRequest) (obj));
    }

    volatile ParseHttpResponse getResponse(Object obj)
        throws IOException
    {
        return getResponse((HttpResponse)obj);
    }

    ParseHttpResponse getResponse(HttpResponse httpresponse)
        throws IOException
    {
        if (httpresponse == null)
        {
            throw new IllegalArgumentException("HttpResponse passed to getResponse should not be null.");
        }
        int k = httpresponse.getStatusLine().getStatusCode();
        java.io.InputStream inputstream = AndroidHttpClient.getUngzippedContent(httpresponse.getEntity());
        Header aheader[] = httpresponse.getHeaders("Content-Length");
        String s;
        HashMap hashmap;
        Header aheader1[];
        int i;
        int l;
        if (aheader.length > 0)
        {
            i = Integer.parseInt(aheader[0].getValue());
        } else
        {
            i = -1;
        }
        s = httpresponse.getStatusLine().getReasonPhrase();
        hashmap = new HashMap();
        aheader1 = httpresponse.getAllHeaders();
        l = aheader1.length;
        for (int j = 0; j < l; j++)
        {
            Header header = aheader1[j];
            hashmap.put(header.getName(), header.getValue());
        }

        httpresponse = httpresponse.getEntity();
        if (httpresponse != null && httpresponse.getContentType() != null)
        {
            httpresponse = httpresponse.getContentType().getValue();
        } else
        {
            httpresponse = null;
        }
        return ((ParseHttpResponse.Builder)((ParseHttpResponse.Builder)((ParseHttpResponse.Builder)((ParseHttpResponse.Builder)((ParseHttpResponse.Builder)((ParseHttpResponse.Builder)(new ParseHttpResponse.Builder()).setStatusCode(k)).setContent(inputstream)).setTotalSize(i)).setReasonPhase(s)).setHeaders(hashmap)).setContentType(httpresponse)).build();
    }
}
