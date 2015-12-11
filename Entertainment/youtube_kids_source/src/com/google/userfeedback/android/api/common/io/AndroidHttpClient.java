// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.userfeedback.android.api.common.io;

import android.content.ContentResolver;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.entity.AbstractHttpEntity;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.client.RequestWrapper;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;
import org.apache.http.protocol.HttpContext;

public final class AndroidHttpClient
    implements HttpClient
{

    public static final long DEFAULT_SYNC_MIN_GZIP_BYTES = 256L;
    private static final String TAG = "AndroidHttpClient_v09";
    private static final ThreadLocal sThreadBlocked = new ThreadLocal();
    private static final HttpRequestInterceptor sThreadCheckInterceptor = new _cls1();
    private volatile LoggingConfiguration curlConfiguration;
    private final HttpClient _flddelegate;
    private RuntimeException mLeakedException;

    private AndroidHttpClient(ClientConnectionManager clientconnectionmanager, HttpParams httpparams)
    {
        mLeakedException = new IllegalStateException("AndroidHttpClient_v09 created and never closed");
        _flddelegate = new _cls2(clientconnectionmanager, httpparams);
    }

    public static AbstractHttpEntity getCompressedEntity(byte abyte0[], ContentResolver contentresolver)
    {
        if ((long)abyte0.length < getMinGzipSize(contentresolver))
        {
            return new ByteArrayEntity(abyte0);
        } else
        {
            contentresolver = new ByteArrayOutputStream();
            GZIPOutputStream gzipoutputstream = new GZIPOutputStream(contentresolver);
            gzipoutputstream.write(abyte0);
            gzipoutputstream.close();
            abyte0 = new ByteArrayEntity(contentresolver.toByteArray());
            abyte0.setContentEncoding("gzip");
            return abyte0;
        }
    }

    public static long getMinGzipSize(ContentResolver contentresolver)
    {
        return 256L;
    }

    public static InputStream getUngzippedContent(HttpEntity httpentity)
    {
        InputStream inputstream = httpentity.getContent();
        if (inputstream != null)
        {
            if ((httpentity = httpentity.getContentEncoding()) != null && (httpentity = httpentity.getValue()) != null)
            {
                if (httpentity.contains("gzip"))
                {
                    httpentity = new GZIPInputStream(inputstream);
                } else
                {
                    httpentity = inputstream;
                }
                return httpentity;
            }
        }
        return inputstream;
    }

    public static void modifyRequestToAcceptGzipResponse(HttpRequest httprequest)
    {
        httprequest.addHeader("Accept-Encoding", "gzip");
    }

    public static AndroidHttpClient newInstance(String s)
    {
        BasicHttpParams basichttpparams = new BasicHttpParams();
        HttpConnectionParams.setStaleCheckingEnabled(basichttpparams, false);
        HttpConnectionParams.setConnectionTimeout(basichttpparams, 20000);
        HttpConnectionParams.setSoTimeout(basichttpparams, 20000);
        HttpConnectionParams.setSocketBufferSize(basichttpparams, 8192);
        HttpClientParams.setRedirecting(basichttpparams, false);
        HttpProtocolParams.setUserAgent(basichttpparams, s);
        s = new SchemeRegistry();
        s.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        s.register(new Scheme("https", SSLSocketFactory.getSocketFactory(), 443));
        return new AndroidHttpClient(new ThreadSafeClientConnManager(basichttpparams, s), basichttpparams);
    }

    public static void setThreadBlocked(boolean flag)
    {
        sThreadBlocked.set(Boolean.valueOf(flag));
    }

    private static String toCurl(HttpUriRequest httpurirequest)
    {
        StringBuilder stringbuilder = new StringBuilder();
        stringbuilder.append("curl ");
        Header aheader[] = httpurirequest.getAllHeaders();
        int j = aheader.length;
        for (int i = 0; i < j; i++)
        {
            Header header = aheader[i];
            stringbuilder.append("--header \"");
            stringbuilder.append(header.toString().trim());
            stringbuilder.append("\" ");
        }

        java.net.URI uri = httpurirequest.getURI();
        if (httpurirequest instanceof RequestWrapper)
        {
            HttpRequest httprequest = ((RequestWrapper)httpurirequest).getOriginal();
            if (httprequest instanceof HttpUriRequest)
            {
                uri = ((HttpUriRequest)httprequest).getURI();
            }
        }
        stringbuilder.append("\"");
        stringbuilder.append(uri);
        stringbuilder.append("\"");
        if (httpurirequest instanceof HttpEntityEnclosingRequest)
        {
            httpurirequest = ((HttpEntityEnclosingRequest)httpurirequest).getEntity();
            if (httpurirequest != null && httpurirequest.isRepeatable())
            {
                if (httpurirequest.getContentLength() < 1024L)
                {
                    ByteArrayOutputStream bytearrayoutputstream = new ByteArrayOutputStream();
                    httpurirequest.writeTo(bytearrayoutputstream);
                    httpurirequest = bytearrayoutputstream.toString();
                    stringbuilder.append(" --data-ascii \"").append(httpurirequest).append("\"");
                } else
                {
                    stringbuilder.append(" [TOO MUCH DATA TO INCLUDE]");
                }
            }
        }
        return stringbuilder.toString();
    }

    public final void close()
    {
        if (mLeakedException != null)
        {
            getConnectionManager().shutdown();
            mLeakedException = null;
        }
    }

    public final void disableCurlLogging()
    {
        curlConfiguration = null;
    }

    public final void enableCurlLogging(String s, int i)
    {
        if (s == null)
        {
            throw new NullPointerException("name");
        }
        if (i < 2 || i > 7)
        {
            throw new IllegalArgumentException("Level is out of range [2..7]");
        } else
        {
            curlConfiguration = new LoggingConfiguration(s, i, null);
            return;
        }
    }

    public final Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler)
    {
        return _flddelegate.execute(httphost, httprequest, responsehandler);
    }

    public final Object execute(HttpHost httphost, HttpRequest httprequest, ResponseHandler responsehandler, HttpContext httpcontext)
    {
        return _flddelegate.execute(httphost, httprequest, responsehandler, httpcontext);
    }

    public final Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler)
    {
        return _flddelegate.execute(httpurirequest, responsehandler);
    }

    public final Object execute(HttpUriRequest httpurirequest, ResponseHandler responsehandler, HttpContext httpcontext)
    {
        return _flddelegate.execute(httpurirequest, responsehandler, httpcontext);
    }

    public final HttpResponse execute(HttpHost httphost, HttpRequest httprequest)
    {
        return _flddelegate.execute(httphost, httprequest);
    }

    public final HttpResponse execute(HttpHost httphost, HttpRequest httprequest, HttpContext httpcontext)
    {
        return _flddelegate.execute(httphost, httprequest, httpcontext);
    }

    public final HttpResponse execute(HttpUriRequest httpurirequest)
    {
        return _flddelegate.execute(httpurirequest);
    }

    public final HttpResponse execute(HttpUriRequest httpurirequest, HttpContext httpcontext)
    {
        return _flddelegate.execute(httpurirequest, httpcontext);
    }

    protected final void finalize()
    {
        super.finalize();
        if (mLeakedException != null)
        {
            Log.e("AndroidHttpClient_v09", "Leak found", mLeakedException);
            mLeakedException = null;
        }
    }

    public final ClientConnectionManager getConnectionManager()
    {
        return _flddelegate.getConnectionManager();
    }

    public final HttpParams getParams()
    {
        return _flddelegate.getParams();
    }






    private class _cls2 extends DefaultHttpClient
    {

        final AndroidHttpClient this$0;

        protected HttpContext createHttpContext()
        {
            BasicHttpContext basichttpcontext = new BasicHttpContext();
            basichttpcontext.setAttribute("http.authscheme-registry", getAuthSchemes());
            basichttpcontext.setAttribute("http.cookiespec-registry", getCookieSpecs());
            basichttpcontext.setAttribute("http.auth.credentials-provider", getCredentialsProvider());
            return basichttpcontext;
        }

        protected BasicHttpProcessor createHttpProcessor()
        {
            BasicHttpProcessor basichttpprocessor = super.createHttpProcessor();
            basichttpprocessor.addRequestInterceptor(AndroidHttpClient.sThreadCheckInterceptor);
            basichttpprocessor.addRequestInterceptor(new CurlLogger(null));
            return basichttpprocessor;
        }

        _cls2(ClientConnectionManager clientconnectionmanager, HttpParams httpparams)
        {
            this$0 = AndroidHttpClient.this;
            super(clientconnectionmanager, httpparams);
        }

        private class CurlLogger
            implements HttpRequestInterceptor
        {

            final AndroidHttpClient this$0;

            public void process(HttpRequest httprequest, HttpContext httpcontext)
            {
                httpcontext = curlConfiguration;
                if (httpcontext != null && httpcontext.isLoggable() && (httprequest instanceof HttpUriRequest))
                {
                    httpcontext.println(AndroidHttpClient.toCurl((HttpUriRequest)httprequest));
                }
            }

            private CurlLogger()
            {
                this$0 = AndroidHttpClient.this;
                super();
            }

            CurlLogger(_cls1 _pcls1)
            {
                this();
            }
        }

    }


    private class LoggingConfiguration
    {

        private final int level;
        private final String tag;

        private boolean isLoggable()
        {
            return Log.isLoggable(tag, level);
        }

        private void println(String s)
        {
            Log.println(level, tag, s);
        }



        private LoggingConfiguration(String s, int i)
        {
            tag = s;
            level = i;
        }

        LoggingConfiguration(String s, int i, _cls1 _pcls1)
        {
            this(s, i);
        }
    }


    private class _cls1
        implements HttpRequestInterceptor
    {

        public final void process(HttpRequest httprequest, HttpContext httpcontext)
        {
            if (AndroidHttpClient.sThreadBlocked.get() != null && ((Boolean)AndroidHttpClient.sThreadBlocked.get()).booleanValue())
            {
                throw new RuntimeException("This thread forbids HTTP requests");
            } else
            {
                return;
            }
        }

        _cls1()
        {
        }
    }

}
