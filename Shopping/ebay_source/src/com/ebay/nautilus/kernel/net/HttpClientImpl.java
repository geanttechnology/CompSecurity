// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.ebay.nautilus.kernel.net;

import android.text.TextUtils;
import android.util.Log;
import com.ebay.nautilus.kernel.NautilusKernel;
import com.ebay.nautilus.kernel.util.FwLog;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.client.HttpClient;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.client.protocol.RequestAddCookies;
import org.apache.http.client.protocol.RequestProxyAuthentication;
import org.apache.http.client.protocol.RequestTargetAuthentication;
import org.apache.http.client.protocol.ResponseProcessCookies;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.HttpEntityWrapper;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

// Referenced classes of package com.ebay.nautilus.kernel.net:
//            NetworkLog, SelfSignedCertSocketFactory, HttpInterceptors, IHeaders, 
//            IHeader

final class HttpClientImpl extends DefaultHttpClient
    implements ConnectionReuseStrategy, HttpClient, ConnectionKeepAliveStrategy
{
    private static class GzipDecompressingEntity extends HttpEntityWrapper
    {

        public InputStream getContent()
            throws IOException, IllegalStateException
        {
            return new GZIPInputStream(wrappedEntity.getContent());
        }

        public long getContentLength()
        {
            return -1L;
        }

        public GzipDecompressingEntity(HttpEntity httpentity)
        {
            super(httpentity);
        }
    }

    private static class GzipRequestInterceptor
        implements HttpRequestInterceptor
    {

        public void process(HttpRequest httprequest, HttpContext httpcontext)
            throws HttpException, IOException
        {
            httprequest.addHeader("accept-encoding", "gzip");
        }

        private GzipRequestInterceptor()
        {
        }

    }

    private static class GzipResponseInterceptor
        implements HttpResponseInterceptor
    {

        public void process(HttpResponse httpresponse, HttpContext httpcontext)
            throws HttpException, IOException
        {
            httpcontext = httpresponse.getEntity();
            if (httpcontext != null)
            {
                httpcontext = httpcontext.getContentEncoding();
                if (httpcontext != null && httpcontext.getValue().compareToIgnoreCase("gzip") == 0)
                {
                    httpresponse.setEntity(new GzipDecompressingEntity(httpresponse.getEntity()));
                }
            }
        }

        private GzipResponseInterceptor()
        {
        }

    }

    private static final class Headers
        implements IHeaders
    {

        private final HttpMessage message;

        public Map getAllHeaders()
        {
            return HttpClientImpl.getHeaderMap(message.getAllHeaders());
        }

        public String getFirstHeader(String s)
        {
            s = message.getFirstHeader(s);
            if (s != null)
            {
                return s.getValue();
            } else
            {
                return null;
            }
        }

        public String getLastHeader(String s)
        {
            s = message.getLastHeader(s);
            if (s != null)
            {
                return s.getValue();
            } else
            {
                return null;
            }
        }

        public Iterator iterator()
        {
            return new HeaderIterator(message.getAllHeaders());
        }

        public void setHeader(String s, String s1)
        {
            message.setHeader(s, s1);
        }

        public Headers(HttpMessage httpmessage)
        {
            message = httpmessage;
        }
    }

    static final class Headers.Header
        implements IHeader
    {

        private final org.apache.http.Header h;

        public String getName()
        {
            return h.getName();
        }

        public String getValue()
        {
            return h.getValue();
        }

        public Headers.Header(org.apache.http.Header header)
        {
            h = header;
        }
    }

    private static final class Headers.HeaderIterator
        implements Iterator
    {

        private final int count;
        private final org.apache.http.Header headers[];
        private int index;

        public boolean hasNext()
        {
            return index < count;
        }

        public IHeader next()
        {
            org.apache.http.Header aheader[] = headers;
            int i = index;
            index = i + 1;
            return new Headers.Header(aheader[i]);
        }

        public volatile Object next()
        {
            return next();
        }

        public void remove()
        {
            throw new RuntimeException("Not allowed");
        }

        public Headers.HeaderIterator(org.apache.http.Header aheader[])
        {
            headers = aheader;
            int i;
            if (aheader == null)
            {
                i = 0;
            } else
            {
                i = aheader.length;
            }
            count = i;
        }
    }

    private static class HeadersLogger
        implements HttpRequestInterceptor, HttpResponseInterceptor
    {

        public void process(HttpRequest httprequest, HttpContext httpcontext)
            throws HttpException, IOException
        {
            NetworkLog.logHeaders(HttpClientImpl.fwLogNetwork.priority, HttpClientImpl.fwLogNetwork.tag, true, new Headers(httprequest));
            if (!(httprequest instanceof HttpEntityEnclosingRequest)) goto _L2; else goto _L1
_L1:
            try
            {
                httpcontext = ((HttpEntityEnclosingRequest)httprequest).getEntity();
                httprequest = httprequest.getFirstHeader("Content-Type");
            }
            catch (Exception exception)
            {
                httpcontext = exception.getMessage();
                httprequest = httpcontext;
                if (httpcontext == null)
                {
                    httprequest = exception.getClass().getName();
                }
                HttpClientImpl.fwLogNetwork.logAsError(httprequest, exception);
                return;
            }
            if (httprequest == null)
            {
                break MISSING_BLOCK_LABEL_70;
            }
            httprequest = httprequest.getValue();
_L3:
            NetworkLog.logContent(EntityUtils.toByteArray(httpcontext), httprequest);
_L2:
            return;
            httprequest = null;
              goto _L3
        }

        public void process(HttpResponse httpresponse, HttpContext httpcontext)
            throws HttpException, IOException
        {
            NetworkLog.logHeaders(HttpClientImpl.fwLogNetwork.priority, HttpClientImpl.fwLogNetwork.tag, false, new Headers(httpresponse));
        }

        private HeadersLogger()
        {
        }

    }


    public static final int DEFAULT_TIMEOUT = 15000;
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo fwLogNetwork;
    private static final com.ebay.nautilus.kernel.util.FwLog.LogInfo fwLogNetworkExtended;

    private HttpClientImpl(ClientConnectionManager clientconnectionmanager, HttpParams httpparams)
    {
        super(clientconnectionmanager, httpparams);
    }

    static Map getHeaderMap(org.apache.http.Header aheader[])
    {
        if (aheader == null || aheader.length == 0)
        {
            return Collections.emptyMap();
        }
        TreeMap treemap = new TreeMap(String.CASE_INSENSITIVE_ORDER);
        int j = aheader.length;
        for (int i = 0; i < j; i++)
        {
            org.apache.http.Header header = aheader[i];
            List list = (List)treemap.get(header.getName());
            Object obj = list;
            if (list == null)
            {
                String s = header.getName();
                obj = new ArrayList();
                treemap.put(s, obj);
            }
            ((List) (obj)).add(header.getValue());
        }

        return Collections.unmodifiableMap(treemap);
    }

    static IHeaders getHeaders(HttpMessage httpmessage)
    {
        if (httpmessage != null)
        {
            return new Headers(httpmessage);
        } else
        {
            return null;
        }
    }

    public static HttpClient newInstance()
    {
        return newInstance(SSLSocketFactory.getSocketFactory());
    }

    public static HttpClient newInstance(KeyStore keystore)
    {
        try
        {
            keystore = newInstance(new SSLSocketFactory(keystore));
        }
        // Misplaced declaration of an exception variable
        catch (KeyStore keystore)
        {
            Log.w("HttpClientImpl", (new StringBuilder()).append("").append(keystore.getMessage()).toString(), keystore);
            return null;
        }
        return keystore;
    }

    private static HttpClient newInstance(SSLSocketFactory sslsocketfactory)
    {
        BasicHttpParams basichttpparams;
        SchemeRegistry schemeregistry;
        if (fwLogNetworkExtended.isLoggable)
        {
            setupHttpClientLog();
        } else
        {
            HttpInterceptors.addRequestInterceptor(new GzipRequestInterceptor());
        }
        basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(basichttpparams, true);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 15000);
        HttpConnectionParams.setSoTimeout(basichttpparams, 60000);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        HttpClientParams.setRedirecting(basichttpparams, true);
        schemeregistry = new SchemeRegistry();
        schemeregistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        if (NautilusKernel.isQaMode())
        {
            schemeregistry.register(new Scheme("https", new SelfSignedCertSocketFactory(), 443));
        } else
        {
            sslsocketfactory.setHostnameVerifier(SSLSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
            schemeregistry.register(new Scheme("https", sslsocketfactory, 443));
        }
        return new HttpClientImpl(new ThreadSafeClientConnManager(basichttpparams, schemeregistry), basichttpparams);
    }

    private static void setupHttpClientLog()
    {
        Handler handler = new Handler() {

            public void close()
            {
            }

            public void flush()
            {
            }

            public void publish(LogRecord logrecord)
            {
                try
                {
                    FwLog.println(HttpClientImpl.fwLogNetworkExtended.priority, (new StringBuilder()).append(HttpClientImpl.fwLogNetworkExtended.tag).append(':').append(logrecord.getLoggerName()).append('(').append(Thread.currentThread().getName()).append(')').toString(), logrecord.getMessage());
                    return;
                }
                catch (Exception exception)
                {
                    String s = exception.getMessage();
                    logrecord = s;
                    if (TextUtils.isEmpty(s))
                    {
                        logrecord = exception.getClass().getSimpleName();
                    }
                    HttpClientImpl.fwLogNetworkExtended.logAsError(logrecord, exception);
                    return;
                }
            }

        };
        Logger alogger[] = new Logger[2];
        alogger[0] = Logger.getLogger("org.apache.http.impl.conn");
        alogger[1] = Logger.getLogger("org.apache.http.wire");
        int j = alogger.length;
        for (int i = 0; i < j; i++)
        {
            Logger logger = alogger[i];
            logger.setLevel(Level.ALL);
            logger.addHandler(handler);
        }

    }

    protected ConnectionKeepAliveStrategy createConnectionKeepAliveStrategy()
    {
        return this;
    }

    protected ConnectionReuseStrategy createConnectionReuseStrategy()
    {
        return this;
    }

    protected HttpContext createHttpContext()
    {
        return new BasicHttpContext();
    }

    protected BasicHttpProcessor createHttpProcessor()
    {
        BasicHttpProcessor basichttpprocessor = super.createHttpProcessor();
        basichttpprocessor.addResponseInterceptor(new GzipResponseInterceptor());
        basichttpprocessor.addRequestInterceptor(HttpInterceptors.getRequestInterceptor());
        basichttpprocessor.addResponseInterceptor(HttpInterceptors.getResponseInterceptor());
        if (fwLogNetwork.isLoggable)
        {
            HeadersLogger headerslogger = new HeadersLogger();
            basichttpprocessor.addRequestInterceptor(headerslogger);
            basichttpprocessor.addResponseInterceptor(headerslogger);
        }
        basichttpprocessor.removeRequestInterceptorByClass(org/apache/http/client/protocol/RequestAddCookies);
        basichttpprocessor.removeResponseInterceptorByClass(org/apache/http/client/protocol/ResponseProcessCookies);
        basichttpprocessor.removeRequestInterceptorByClass(org/apache/http/client/protocol/RequestTargetAuthentication);
        basichttpprocessor.removeRequestInterceptorByClass(org/apache/http/client/protocol/RequestProxyAuthentication);
        return basichttpprocessor;
    }

    public long getKeepAliveDuration(HttpResponse httpresponse, HttpContext httpcontext)
    {
        return 20000L;
    }

    public boolean keepAlive(HttpResponse httpresponse, HttpContext httpcontext)
    {
        return true;
    }

    static 
    {
        fwLogNetwork = NetworkLog.fwLogNetwork;
        fwLogNetworkExtended = new com.ebay.nautilus.kernel.util.FwLog.LogInfo(fwLogNetwork.tag, 2, "Log verbose HTTP traffic");
    }


}
